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

public class datos_activity extends Activity implements B4AActivity{
	public static datos_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.datos_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (datos_activity).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.datos_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.datos_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (datos_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (datos_activity) Resume **");
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
		return datos_activity.class;
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
            BA.LogInfo("** Activity (datos_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (datos_activity) Pause event (activity is not paused). **");
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
            datos_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (datos_activity) Resume **");
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
public b4a.example.httpjob _backendelessget = null;
public b4a.example.httpjob _historial = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbnombre = null;
public static String _urlget = "";
public static String _urlhistorial = "";
public anywheresoftware.b4a.objects.LabelWrapper _lbnumero = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbdescrip = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbestado = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbflujo = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbactualizado = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.tutoriales_activity _tutoriales_activity = null;
public b4a.example.agregar_activity _agregar_activity = null;
public b4a.example.monitor_activity _monitor_activity = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="datos_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="Activity.LoadLayout(\"Datos\")";
mostCurrent._activity.LoadLayout("Datos",mostCurrent.activityBA);
RDebugUtils.currentLine=3145733;
 //BA.debugLineNum = 3145733;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
_setstatusbarcolor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (231),(int) (231),(int) (222)));
RDebugUtils.currentLine=3145734;
 //BA.debugLineNum = 3145734;BA.debugLine="urlGet = \"https://api.backendless.com/85B70858-21";
mostCurrent._urlget = "https://api.backendless.com/85B70858-2193-2A92-FF8E-BF8B113D4100/CC232E12-9D6D-40A6-A41A-23796B090767/data/Dispositivos";
RDebugUtils.currentLine=3145735;
 //BA.debugLineNum = 3145735;BA.debugLine="urlHistorial = \"https://api.backendless.com/85B70";
mostCurrent._urlhistorial = "https://api.backendless.com/85B70858-2193-2A92-FF8E-BF8B113D4100/CC232E12-9D6D-40A6-A41A-23796B090767/data/Historial";
RDebugUtils.currentLine=3145736;
 //BA.debugLineNum = 3145736;BA.debugLine="backendelessGet.Initialize(\"get\",Me)";
mostCurrent._backendelessget._initialize /*String*/ (null,processBA,"get",datos_activity.getObject());
RDebugUtils.currentLine=3145737;
 //BA.debugLineNum = 3145737;BA.debugLine="historial.Initialize(\"historial\",Me)";
mostCurrent._historial._initialize /*String*/ (null,processBA,"historial",datos_activity.getObject());
RDebugUtils.currentLine=3145738;
 //BA.debugLineNum = 3145738;BA.debugLine="backendelessGet.Download(urlGet)			'para cargar l";
mostCurrent._backendelessget._download /*String*/ (null,mostCurrent._urlget);
RDebugUtils.currentLine=3145739;
 //BA.debugLineNum = 3145739;BA.debugLine="End Sub";
return "";
}
public static String  _setstatusbarcolor(int _clr) throws Exception{
RDebugUtils.currentModule="datos_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "setstatusbarcolor", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "setstatusbarcolor", new Object[] {_clr}));}
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="If p.SdkVersion >= 21 Then";
if (_p.getSdkVersion()>=21) { 
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(0x80000000)});
RDebugUtils.currentLine=3670023;
 //BA.debugLineNum = 3670023;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(0x04000000)});
RDebugUtils.currentLine=3670024;
 //BA.debugLineNum = 3670024;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
 };
RDebugUtils.currentLine=3670026;
 //BA.debugLineNum = 3670026;BA.debugLine="If p.SdkVersion >= 23 Then";
if (_p.getSdkVersion()>=23) { 
RDebugUtils.currentLine=3670027;
 //BA.debugLineNum = 3670027;BA.debugLine="jo = Activity";
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(mostCurrent._activity.getObject()));
RDebugUtils.currentLine=3670028;
 //BA.debugLineNum = 3670028;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
_jo.RunMethod("setSystemUiVisibility",new Object[]{(Object)(8192)});
 };
RDebugUtils.currentLine=3670030;
 //BA.debugLineNum = 3670030;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="datos_activity";
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="datos_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="End Sub";
return "";
}
public static String  _btnatrase_click() throws Exception{
RDebugUtils.currentModule="datos_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnatrase_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnatrase_click", null));}
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub btnAtrasE_Click";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="End Sub";
return "";
}
public static String  _cargardatos(String _res) throws Exception{
RDebugUtils.currentModule="datos_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cargardatos", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cargardatos", new Object[] {_res}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
String _nombre = "";
String _descripcion = "";
String _numero = "";
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub cargarDatos (res As String)";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=3473413;
 //BA.debugLineNum = 3473413;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
RDebugUtils.currentLine=3473414;
 //BA.debugLineNum = 3473414;BA.debugLine="For Each colroot As Map In root				'map es simila";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group4 = _root;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group4.Get(index4)));
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="If colroot.Get(\"nombre\") = Monitor_Activity.nomb";
if ((_colroot.Get((Object)("nombre"))).equals((Object)(mostCurrent._monitor_activity._nombred /*String*/ ))) { 
RDebugUtils.currentLine=3473416;
 //BA.debugLineNum = 3473416;BA.debugLine="Dim nombre As String = colroot.Get(\"nombre\")";
_nombre = BA.ObjectToString(_colroot.Get((Object)("nombre")));
RDebugUtils.currentLine=3473417;
 //BA.debugLineNum = 3473417;BA.debugLine="Dim descripcion As String = colroot.Get(\"descri";
_descripcion = BA.ObjectToString(_colroot.Get((Object)("descripcion")));
RDebugUtils.currentLine=3473418;
 //BA.debugLineNum = 3473418;BA.debugLine="Dim numero As String = colroot.Get(\"numero\")";
_numero = BA.ObjectToString(_colroot.Get((Object)("numero")));
 };
 }
};
RDebugUtils.currentLine=3473422;
 //BA.debugLineNum = 3473422;BA.debugLine="lbNombre.Text = nombre";
mostCurrent._lbnombre.setText(BA.ObjectToCharSequence(_nombre));
RDebugUtils.currentLine=3473423;
 //BA.debugLineNum = 3473423;BA.debugLine="lbNumero.Text = numero";
mostCurrent._lbnumero.setText(BA.ObjectToCharSequence(_numero));
RDebugUtils.currentLine=3473424;
 //BA.debugLineNum = 3473424;BA.debugLine="lbDescrip.Text = descripcion";
mostCurrent._lbdescrip.setText(BA.ObjectToCharSequence(_descripcion));
RDebugUtils.currentLine=3473425;
 //BA.debugLineNum = 3473425;BA.debugLine="historial.Download(urlHistorial)";
mostCurrent._historial._download /*String*/ (null,mostCurrent._urlhistorial);
RDebugUtils.currentLine=3473426;
 //BA.debugLineNum = 3473426;BA.debugLine="End Sub";
return "";
}
public static String  _cargarestado(String _res) throws Exception{
RDebugUtils.currentModule="datos_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cargarestado", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cargarestado", new Object[] {_res}));}
long _fecha = 0L;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
long _fechaentra = 0L;
String _estado = "";
String _flujo = "";
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub cargarEstado (res As String)";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="Dim fecha As Long = 0";
_fecha = (long) (0);
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=3538950;
 //BA.debugLineNum = 3538950;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
RDebugUtils.currentLine=3538951;
 //BA.debugLineNum = 3538951;BA.debugLine="For Each colroot As Map In root				'map es simila";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group5 = _root;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group5.Get(index5)));
RDebugUtils.currentLine=3538953;
 //BA.debugLineNum = 3538953;BA.debugLine="If colroot.Get(\"dispositivo\") = lbNombre.Text Th";
if ((_colroot.Get((Object)("dispositivo"))).equals((Object)(mostCurrent._lbnombre.getText()))) { 
RDebugUtils.currentLine=3538955;
 //BA.debugLineNum = 3538955;BA.debugLine="Dim fechaEntra As Long = colroot.Get(\"fecha\")";
_fechaentra = BA.ObjectToLongNumber(_colroot.Get((Object)("fecha")));
RDebugUtils.currentLine=3538956;
 //BA.debugLineNum = 3538956;BA.debugLine="If fechaEntra >= fecha Then";
if (_fechaentra>=_fecha) { 
RDebugUtils.currentLine=3538957;
 //BA.debugLineNum = 3538957;BA.debugLine="Dim estado As String = colroot.Get(\"estado\")";
_estado = BA.ObjectToString(_colroot.Get((Object)("estado")));
RDebugUtils.currentLine=3538958;
 //BA.debugLineNum = 3538958;BA.debugLine="Dim flujo As String = colroot.Get(\"flujo\")";
_flujo = BA.ObjectToString(_colroot.Get((Object)("flujo")));
RDebugUtils.currentLine=3538959;
 //BA.debugLineNum = 3538959;BA.debugLine="fecha = fechaEntra";
_fecha = _fechaentra;
 };
 };
 }
};
RDebugUtils.currentLine=3538964;
 //BA.debugLineNum = 3538964;BA.debugLine="If estado = True Then";
if ((_estado).equals(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.True))) { 
RDebugUtils.currentLine=3538965;
 //BA.debugLineNum = 3538965;BA.debugLine="lbEstado.Text = \"Encendido\"";
mostCurrent._lbestado.setText(BA.ObjectToCharSequence("Encendido"));
RDebugUtils.currentLine=3538966;
 //BA.debugLineNum = 3538966;BA.debugLine="lbEstado.Color = Colors.ARGB(128,0,136,145)";
mostCurrent._lbestado.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (128),(int) (0),(int) (136),(int) (145)));
 }else 
{RDebugUtils.currentLine=3538967;
 //BA.debugLineNum = 3538967;BA.debugLine="Else If estado = False Then";
if ((_estado).equals(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False))) { 
RDebugUtils.currentLine=3538968;
 //BA.debugLineNum = 3538968;BA.debugLine="lbEstado.Text = \"Apagado\"";
mostCurrent._lbestado.setText(BA.ObjectToCharSequence("Apagado"));
RDebugUtils.currentLine=3538969;
 //BA.debugLineNum = 3538969;BA.debugLine="lbEstado.Color = Colors.ARGB(128,240,84,84)";
mostCurrent._lbestado.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (128),(int) (240),(int) (84),(int) (84)));
 }}
;
RDebugUtils.currentLine=3538973;
 //BA.debugLineNum = 3538973;BA.debugLine="lbFlujo.Text = flujo & \" Litros/Hora\"";
mostCurrent._lbflujo.setText(BA.ObjectToCharSequence(_flujo+" Litros/Hora"));
RDebugUtils.currentLine=3538976;
 //BA.debugLineNum = 3538976;BA.debugLine="diferenciaDeFechas(fecha)";
_diferenciadefechas(_fecha);
RDebugUtils.currentLine=3538977;
 //BA.debugLineNum = 3538977;BA.debugLine="End Sub";
return "";
}
public static String  _diferenciadefechas(long _fecha) throws Exception{
RDebugUtils.currentModule="datos_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "diferenciadefechas", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "diferenciadefechas", new Object[] {_fecha}));}
long _fechaactual = 0L;
long _actual = 0L;
long _actualmodificado = 0L;
String _mensaje = "";
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub diferenciaDeFechas(fecha As Long){";
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="DateTime.DateFormat = \"yyyyMMddHHmm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyyMMddHHmm");
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="Dim fechaActual As Long = DateTime.Date(DateTime.";
_fechaactual = (long)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="Dim actual As Long = fechaActual - fecha";
_actual = (long) (_fechaactual-_fecha);
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="Dim actualModificado As Long";
_actualmodificado = 0L;
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="Dim mensaje As String";
_mensaje = "";
RDebugUtils.currentLine=3604488;
 //BA.debugLineNum = 3604488;BA.debugLine="If actual < 100 Then";
if (_actual<100) { 
RDebugUtils.currentLine=3604489;
 //BA.debugLineNum = 3604489;BA.debugLine="actualModificado = fechaActual/100";
_actualmodificado = (long) (_fechaactual/(double)100);
RDebugUtils.currentLine=3604490;
 //BA.debugLineNum = 3604490;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
_fechaactual = (long) (_fechaactual-_actualmodificado*100);
RDebugUtils.currentLine=3604491;
 //BA.debugLineNum = 3604491;BA.debugLine="actualModificado = fecha/100";
_actualmodificado = (long) (_fecha/(double)100);
RDebugUtils.currentLine=3604492;
 //BA.debugLineNum = 3604492;BA.debugLine="fecha = fecha - actualModificado*100";
_fecha = (long) (_fecha-_actualmodificado*100);
RDebugUtils.currentLine=3604493;
 //BA.debugLineNum = 3604493;BA.debugLine="If fecha < fechaActual Then";
if (_fecha<_fechaactual) { 
RDebugUtils.currentLine=3604494;
 //BA.debugLineNum = 3604494;BA.debugLine="actualModificado = fechaActual - fecha";
_actualmodificado = (long) (_fechaactual-_fecha);
 }else {
RDebugUtils.currentLine=3604496;
 //BA.debugLineNum = 3604496;BA.debugLine="actualModificado = fechaActual + (60 - fecha)";
_actualmodificado = (long) (_fechaactual+(60-_fecha));
 };
RDebugUtils.currentLine=3604499;
 //BA.debugLineNum = 3604499;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
_mensaje = "Actualizado hace "+BA.NumberToString(_actualmodificado)+" minutos";
 }else 
{RDebugUtils.currentLine=3604501;
 //BA.debugLineNum = 3604501;BA.debugLine="Else If actual < 10000 Then";
if (_actual<10000) { 
RDebugUtils.currentLine=3604502;
 //BA.debugLineNum = 3604502;BA.debugLine="actualModificado = fechaActual/10000";
_actualmodificado = (long) (_fechaactual/(double)10000);
RDebugUtils.currentLine=3604503;
 //BA.debugLineNum = 3604503;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
_fechaactual = (long) (_fechaactual-_actualmodificado*10000);
RDebugUtils.currentLine=3604504;
 //BA.debugLineNum = 3604504;BA.debugLine="actualModificado = fecha/10000";
_actualmodificado = (long) (_fecha/(double)10000);
RDebugUtils.currentLine=3604505;
 //BA.debugLineNum = 3604505;BA.debugLine="fecha = fecha - actualModificado*10000";
_fecha = (long) (_fecha-_actualmodificado*10000);
RDebugUtils.currentLine=3604506;
 //BA.debugLineNum = 3604506;BA.debugLine="Log(fechaActual)";
anywheresoftware.b4a.keywords.Common.LogImpl("43604506",BA.NumberToString(_fechaactual),0);
RDebugUtils.currentLine=3604507;
 //BA.debugLineNum = 3604507;BA.debugLine="Log(fecha)";
anywheresoftware.b4a.keywords.Common.LogImpl("43604507",BA.NumberToString(_fecha),0);
RDebugUtils.currentLine=3604508;
 //BA.debugLineNum = 3604508;BA.debugLine="If fecha < fechaActual Then";
if (_fecha<_fechaactual) { 
RDebugUtils.currentLine=3604509;
 //BA.debugLineNum = 3604509;BA.debugLine="actualModificado = fechaActual/100 - fecha/100";
_actualmodificado = (long) (_fechaactual/(double)100-_fecha/(double)100);
 }else {
RDebugUtils.currentLine=3604511;
 //BA.debugLineNum = 3604511;BA.debugLine="actualModificado = fechaActual/100 + (24 - fech";
_actualmodificado = (long) (_fechaactual/(double)100+(24-_fecha/(double)100));
 };
RDebugUtils.currentLine=3604514;
 //BA.debugLineNum = 3604514;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
_mensaje = "Actualizado hace "+BA.NumberToString(_actualmodificado)+" horas";
 }else 
{RDebugUtils.currentLine=3604517;
 //BA.debugLineNum = 3604517;BA.debugLine="Else If actual < 1000000 Then";
if (_actual<1000000) { 
RDebugUtils.currentLine=3604518;
 //BA.debugLineNum = 3604518;BA.debugLine="actualModificado = fechaActual/1000000";
_actualmodificado = (long) (_fechaactual/(double)1000000);
RDebugUtils.currentLine=3604519;
 //BA.debugLineNum = 3604519;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
_fechaactual = (long) (_fechaactual-_actualmodificado*1000000);
RDebugUtils.currentLine=3604520;
 //BA.debugLineNum = 3604520;BA.debugLine="actualModificado = fecha/1000000";
_actualmodificado = (long) (_fecha/(double)1000000);
RDebugUtils.currentLine=3604521;
 //BA.debugLineNum = 3604521;BA.debugLine="fecha = fecha - actualModificado*1000000";
_fecha = (long) (_fecha-_actualmodificado*1000000);
RDebugUtils.currentLine=3604522;
 //BA.debugLineNum = 3604522;BA.debugLine="actualModificado = Abs(fechaActual - fecha)";
_actualmodificado = (long) (anywheresoftware.b4a.keywords.Common.Abs(_fechaactual-_fecha));
RDebugUtils.currentLine=3604523;
 //BA.debugLineNum = 3604523;BA.debugLine="If fecha < fechaActual Then";
if (_fecha<_fechaactual) { 
RDebugUtils.currentLine=3604524;
 //BA.debugLineNum = 3604524;BA.debugLine="actualModificado = fechaActual/10000 - fecha/10";
_actualmodificado = (long) (_fechaactual/(double)10000-_fecha/(double)10000);
 }else {
RDebugUtils.currentLine=3604526;
 //BA.debugLineNum = 3604526;BA.debugLine="actualModificado = fechaActual/10000 + (30 - fe";
_actualmodificado = (long) (_fechaactual/(double)10000+(30-_fecha/(double)10000));
 };
RDebugUtils.currentLine=3604529;
 //BA.debugLineNum = 3604529;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
_mensaje = "Actualizado hace "+BA.NumberToString(_actualmodificado)+" dias";
 }else 
{RDebugUtils.currentLine=3604532;
 //BA.debugLineNum = 3604532;BA.debugLine="Else If actual < 100000000 Then";
if (_actual<100000000) { 
RDebugUtils.currentLine=3604533;
 //BA.debugLineNum = 3604533;BA.debugLine="actualModificado = fechaActual/100000000";
_actualmodificado = (long) (_fechaactual/(double)100000000);
RDebugUtils.currentLine=3604534;
 //BA.debugLineNum = 3604534;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
_fechaactual = (long) (_fechaactual-_actualmodificado*100000000);
RDebugUtils.currentLine=3604535;
 //BA.debugLineNum = 3604535;BA.debugLine="actualModificado = fecha/100000000";
_actualmodificado = (long) (_fecha/(double)100000000);
RDebugUtils.currentLine=3604536;
 //BA.debugLineNum = 3604536;BA.debugLine="fecha = fecha - actualModificado*100000000";
_fecha = (long) (_fecha-_actualmodificado*100000000);
RDebugUtils.currentLine=3604537;
 //BA.debugLineNum = 3604537;BA.debugLine="actualModificado = Abs(fechaActual - fecha)";
_actualmodificado = (long) (anywheresoftware.b4a.keywords.Common.Abs(_fechaactual-_fecha));
RDebugUtils.currentLine=3604538;
 //BA.debugLineNum = 3604538;BA.debugLine="If fecha < fechaActual Then";
if (_fecha<_fechaactual) { 
RDebugUtils.currentLine=3604539;
 //BA.debugLineNum = 3604539;BA.debugLine="actualModificado = fechaActual/1000000 - fecha/";
_actualmodificado = (long) (_fechaactual/(double)1000000-_fecha/(double)1000000);
 }else {
RDebugUtils.currentLine=3604541;
 //BA.debugLineNum = 3604541;BA.debugLine="actualModificado = fechaActual/1000000 + (12 -";
_actualmodificado = (long) (_fechaactual/(double)1000000+(12-_fecha/(double)1000000));
 };
RDebugUtils.currentLine=3604544;
 //BA.debugLineNum = 3604544;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
_mensaje = "Actualizado hace "+BA.NumberToString(_actualmodificado)+" meses";
 }else {
RDebugUtils.currentLine=3604547;
 //BA.debugLineNum = 3604547;BA.debugLine="mensaje = \"Desactualizado\"";
_mensaje = "Desactualizado";
 }}}}
;
RDebugUtils.currentLine=3604549;
 //BA.debugLineNum = 3604549;BA.debugLine="lbActualizado.Text = mensaje";
mostCurrent._lbactualizado.setText(BA.ObjectToCharSequence(_mensaje));
RDebugUtils.currentLine=3604550;
 //BA.debugLineNum = 3604550;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="datos_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub JobDone (Job As HttpJob)";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("43407873","JobName = "+_job._jobname /*String*/ +", Success = "+BA.ObjectToString(_job._success /*boolean*/ ),0);
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="If Job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"get","historial")) {
case 0: {
RDebugUtils.currentLine=3407877;
 //BA.debugLineNum = 3407877;BA.debugLine="cargarDatos(Job.GetString) 'se envia la cadena";
_cargardatos(_job._getstring /*String*/ (null));
 break; }
case 1: {
RDebugUtils.currentLine=3407879;
 //BA.debugLineNum = 3407879;BA.debugLine="cargarEstado(Job.GetString)";
_cargarestado(_job._getstring /*String*/ (null));
 break; }
}
;
 }else {
RDebugUtils.currentLine=3407882;
 //BA.debugLineNum = 3407882;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("43407882","Error: "+_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=3407883;
 //BA.debugLineNum = 3407883;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=3407885;
 //BA.debugLineNum = 3407885;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=3407886;
 //BA.debugLineNum = 3407886;BA.debugLine="End Sub";
return "";
}
}