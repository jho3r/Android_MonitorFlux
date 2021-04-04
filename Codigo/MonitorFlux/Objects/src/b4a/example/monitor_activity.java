package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class monitor_activity extends Activity implements B4AActivity{
	public static monitor_activity mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.monitor_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (monitor_activity).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.monitor_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.monitor_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (monitor_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (monitor_activity) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return monitor_activity.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (monitor_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (monitor_activity) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            monitor_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (monitor_activity) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static b4a.example.httpjob _backendelessget = null;
public static String _nombred = "";
public b4a.example3.customlistview _lvelectro = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lbdispositivo = null;
public static String _urlget = "";
public static int _i = 0;
public anywheresoftware.b4a.objects.collections.List _listalterna = null;
public b4a.example.httpjob _historial = null;
public static String _urlhistorial = "";
public anywheresoftware.b4a.objects.collections.List _disfallando = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.tutoriales_activity _tutoriales_activity = null;
public b4a.example.agregar_activity _agregar_activity = null;
public b4a.example.datos_activity _datos_activity = null;
public b4a.example.registrar_activity _registrar_activity = null;
public b4a.example.httputils2service _httputils2service = null;
public b4a.example.dbutils _dbutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="monitor_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=5898244;
 //BA.debugLineNum = 5898244;BA.debugLine="Activity.LoadLayout(\"Monitoreo\")";
mostCurrent._activity.LoadLayout("Monitoreo",mostCurrent.activityBA);
RDebugUtils.currentLine=5898245;
 //BA.debugLineNum = 5898245;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
_setstatusbarcolor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (231),(int) (231),(int) (222)));
RDebugUtils.currentLine=5898246;
 //BA.debugLineNum = 5898246;BA.debugLine="urlGet = \"https://api.backendless.com/4D75900B-E5";
mostCurrent._urlget = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos?where=ownerId%20%3D%20";
RDebugUtils.currentLine=5898247;
 //BA.debugLineNum = 5898247;BA.debugLine="urlHistorial = Main.urlHistorial";
mostCurrent._urlhistorial = mostCurrent._main._urlhistorial /*String*/ ;
RDebugUtils.currentLine=5898248;
 //BA.debugLineNum = 5898248;BA.debugLine="historial.Initialize(\"historial\",Me)";
mostCurrent._historial._initialize /*String*/ (null,processBA,"historial",monitor_activity.getObject());
RDebugUtils.currentLine=5898249;
 //BA.debugLineNum = 5898249;BA.debugLine="listAlterna.Initialize";
mostCurrent._listalterna.Initialize();
RDebugUtils.currentLine=5898250;
 //BA.debugLineNum = 5898250;BA.debugLine="disFallando.Initialize   'guarda el estado de los";
mostCurrent._disfallando.Initialize();
RDebugUtils.currentLine=5898251;
 //BA.debugLineNum = 5898251;BA.debugLine="historial.Download(urlHistorial)";
mostCurrent._historial._download /*String*/ (null,mostCurrent._urlhistorial);
RDebugUtils.currentLine=5898252;
 //BA.debugLineNum = 5898252;BA.debugLine="End Sub";
return "";
}
public static String  _setstatusbarcolor(int _clr) throws Exception{
RDebugUtils.currentModule="monitor_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "setstatusbarcolor", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "setstatusbarcolor", new Object[] {_clr}));}
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
RDebugUtils.currentLine=6488065;
 //BA.debugLineNum = 6488065;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=6488066;
 //BA.debugLineNum = 6488066;BA.debugLine="If p.SdkVersion >= 21 Then";
if (_p.getSdkVersion()>=21) { 
RDebugUtils.currentLine=6488067;
 //BA.debugLineNum = 6488067;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=6488068;
 //BA.debugLineNum = 6488068;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
RDebugUtils.currentLine=6488069;
 //BA.debugLineNum = 6488069;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=6488070;
 //BA.debugLineNum = 6488070;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(0x80000000)});
RDebugUtils.currentLine=6488071;
 //BA.debugLineNum = 6488071;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(0x04000000)});
RDebugUtils.currentLine=6488072;
 //BA.debugLineNum = 6488072;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
 };
RDebugUtils.currentLine=6488074;
 //BA.debugLineNum = 6488074;BA.debugLine="If p.SdkVersion >= 23 Then";
if (_p.getSdkVersion()>=23) { 
RDebugUtils.currentLine=6488075;
 //BA.debugLineNum = 6488075;BA.debugLine="jo = Activity";
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(mostCurrent._activity.getObject()));
RDebugUtils.currentLine=6488076;
 //BA.debugLineNum = 6488076;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
_jo.RunMethod("setSystemUiVisibility",new Object[]{(Object)(8192)});
 };
RDebugUtils.currentLine=6488078;
 //BA.debugLineNum = 6488078;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="monitor_activity";
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="monitor_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="End Sub";
return "";
}
public static String  _additems(String _texto,int _orden) throws Exception{
RDebugUtils.currentModule="monitor_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "additems", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "additems", new Object[] {_texto,_orden}));}
anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
int _a = 0;
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Sub addItems (texto As String, orden As Int)";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="Dim xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=6356995;
 //BA.debugLineNum = 6356995;BA.debugLine="p.SetLayoutAnimated(100,0,0,100%x,10%y)";
_p.SetLayoutAnimated((int) (100),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=6356996;
 //BA.debugLineNum = 6356996;BA.debugLine="p.LoadLayout(\"Item\")";
_p.LoadLayout("Item",mostCurrent.activityBA);
RDebugUtils.currentLine=6356997;
 //BA.debugLineNum = 6356997;BA.debugLine="lbDispositivo.Text=(texto)";
mostCurrent._lbdispositivo.setText(BA.ObjectToCharSequence((_texto)));
RDebugUtils.currentLine=6356998;
 //BA.debugLineNum = 6356998;BA.debugLine="For a=0 To disFallando.Size-1";
{
final int step6 = 1;
final int limit6 = (int) (mostCurrent._disfallando.getSize()-1);
_a = (int) (0) ;
for (;_a <= limit6 ;_a = _a + step6 ) {
RDebugUtils.currentLine=6356999;
 //BA.debugLineNum = 6356999;BA.debugLine="If texto = disFallando.Get(a) Then";
if ((_texto).equals(BA.ObjectToString(mostCurrent._disfallando.Get(_a)))) { 
RDebugUtils.currentLine=6357000;
 //BA.debugLineNum = 6357000;BA.debugLine="lbDispositivo.Color = Colors.ARGB(255,240,84,84";
mostCurrent._lbdispositivo.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (240),(int) (84),(int) (84)));
 };
 }
};
RDebugUtils.currentLine=6357003;
 //BA.debugLineNum = 6357003;BA.debugLine="lvElectro.Add(p,orden)";
mostCurrent._lvelectro._add(_p,(Object)(_orden));
RDebugUtils.currentLine=6357004;
 //BA.debugLineNum = 6357004;BA.debugLine="listAlterna.Add(texto)";
mostCurrent._listalterna.Add((Object)(_texto));
RDebugUtils.currentLine=6357005;
 //BA.debugLineNum = 6357005;BA.debugLine="End Sub";
return "";
}
public static String  _btnatrasm_click() throws Exception{
RDebugUtils.currentModule="monitor_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnatrasm_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnatrasm_click", null));}
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub btnAtrasM_Click";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="End Sub";
return "";
}
public static String  _cargarvalores(String _res) throws Exception{
RDebugUtils.currentModule="monitor_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cargarvalores", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cargarvalores", new Object[] {_res}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
String _nombre = "";
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Sub cargarValores (res As String)";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="i=0";
_i = (int) (0);
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=6225923;
 //BA.debugLineNum = 6225923;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=6225926;
 //BA.debugLineNum = 6225926;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
RDebugUtils.currentLine=6225927;
 //BA.debugLineNum = 6225927;BA.debugLine="For Each colroot As Map In root				'map es simila";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group5 = _root;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group5.Get(index5)));
RDebugUtils.currentLine=6225928;
 //BA.debugLineNum = 6225928;BA.debugLine="Dim nombre As String = colroot.Get(\"nombre\")";
_nombre = BA.ObjectToString(_colroot.Get((Object)("nombre")));
RDebugUtils.currentLine=6225929;
 //BA.debugLineNum = 6225929;BA.debugLine="addItems(nombre,i)";
_additems(_nombre,_i);
RDebugUtils.currentLine=6225930;
 //BA.debugLineNum = 6225930;BA.debugLine="i = i + 1";
_i = (int) (_i+1);
 }
};
RDebugUtils.currentLine=6225933;
 //BA.debugLineNum = 6225933;BA.debugLine="End Sub";
return "";
}
public static String  _fallando(String _res) throws Exception{
RDebugUtils.currentModule="monitor_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fallando", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fallando", new Object[] {_res}));}
long _fecha = 0L;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root = null;
int _a = 0;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
long _fechaentra = 0L;
String _estado = "";
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Sub fallando(res As String)";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="Dim fecha As Long = 0";
_fecha = (long) (0);
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=6291459;
 //BA.debugLineNum = 6291459;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=6291460;
 //BA.debugLineNum = 6291460;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
RDebugUtils.currentLine=6291461;
 //BA.debugLineNum = 6291461;BA.debugLine="For a=0 To Main.list.Size -1";
{
final int step5 = 1;
final int limit5 = (int) (mostCurrent._main._list /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
_a = (int) (0) ;
for (;_a <= limit5 ;_a = _a + step5 ) {
RDebugUtils.currentLine=6291462;
 //BA.debugLineNum = 6291462;BA.debugLine="For Each colroot As Map In root				'map es simil";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group6 = _root;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group6.Get(index6)));
RDebugUtils.currentLine=6291464;
 //BA.debugLineNum = 6291464;BA.debugLine="If colroot.Get(\"id\") = Main.list.Get(a) Then";
if ((_colroot.Get((Object)("id"))).equals(mostCurrent._main._list /*anywheresoftware.b4a.objects.collections.List*/ .Get(_a))) { 
RDebugUtils.currentLine=6291466;
 //BA.debugLineNum = 6291466;BA.debugLine="Dim fechaEntra As Long = colroot.Get(\"fecha\")";
_fechaentra = BA.ObjectToLongNumber(_colroot.Get((Object)("fecha")));
RDebugUtils.currentLine=6291467;
 //BA.debugLineNum = 6291467;BA.debugLine="If fechaEntra >= fecha Then";
if (_fechaentra>=_fecha) { 
RDebugUtils.currentLine=6291468;
 //BA.debugLineNum = 6291468;BA.debugLine="Dim estado As String = colroot.Get(\"encendida";
_estado = BA.ObjectToString(_colroot.Get((Object)("encendida")));
RDebugUtils.currentLine=6291469;
 //BA.debugLineNum = 6291469;BA.debugLine="fecha = fechaEntra";
_fecha = _fechaentra;
 };
 };
 }
};
RDebugUtils.currentLine=6291473;
 //BA.debugLineNum = 6291473;BA.debugLine="If estado = False Then";
if ((_estado).equals(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False))) { 
RDebugUtils.currentLine=6291474;
 //BA.debugLineNum = 6291474;BA.debugLine="disFallando.Add(Main.list.Get(a))";
mostCurrent._disfallando.Add(mostCurrent._main._list /*anywheresoftware.b4a.objects.collections.List*/ .Get(_a));
 };
RDebugUtils.currentLine=6291476;
 //BA.debugLineNum = 6291476;BA.debugLine="fecha = 0";
_fecha = (long) (0);
 }
};
RDebugUtils.currentLine=6291479;
 //BA.debugLineNum = 6291479;BA.debugLine="backendelessGet.Initialize(\"get\",Me)";
_backendelessget._initialize /*String*/ (null,processBA,"get",monitor_activity.getObject());
RDebugUtils.currentLine=6291480;
 //BA.debugLineNum = 6291480;BA.debugLine="backendelessGet.Download(urlGet & \"'\" & Main.ID &";
_backendelessget._download /*String*/ (null,mostCurrent._urlget+"'"+mostCurrent._main._id /*String*/ +"'");
RDebugUtils.currentLine=6291481;
 //BA.debugLineNum = 6291481;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="monitor_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Sub JobDone (Job As HttpJob)";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("16160385","JobName = "+_job._jobname /*String*/ +", Success = "+BA.ObjectToString(_job._success /*boolean*/ ),0);
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="If Job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=6160387;
 //BA.debugLineNum = 6160387;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"get","historial")) {
case 0: {
RDebugUtils.currentLine=6160389;
 //BA.debugLineNum = 6160389;BA.debugLine="cargarValores(Job.GetString) 'se envia la cade";
_cargarvalores(_job._getstring /*String*/ (null));
 break; }
case 1: {
RDebugUtils.currentLine=6160391;
 //BA.debugLineNum = 6160391;BA.debugLine="fallando(Job.GetString)";
_fallando(_job._getstring /*String*/ (null));
 break; }
}
;
 }else {
RDebugUtils.currentLine=6160394;
 //BA.debugLineNum = 6160394;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("16160394","Error: "+_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=6160395;
 //BA.debugLineNum = 6160395;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=6160397;
 //BA.debugLineNum = 6160397;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=6160398;
 //BA.debugLineNum = 6160398;BA.debugLine="End Sub";
return "";
}
public static String  _lvelectro_itemclick(int _index,Object _value) throws Exception{
RDebugUtils.currentModule="monitor_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lvelectro_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lvelectro_itemclick", new Object[] {_index,_value}));}
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Sub lvElectro_ItemClick (Index As Int, Value As Ob";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="nombreD = listAlterna.Get(Value)";
_nombred = BA.ObjectToString(mostCurrent._listalterna.Get((int)(BA.ObjectToNumber(_value))));
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="StartActivity(Datos_Activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._datos_activity.getObject()));
RDebugUtils.currentLine=6422531;
 //BA.debugLineNum = 6422531;BA.debugLine="End Sub";
return "";
}
}