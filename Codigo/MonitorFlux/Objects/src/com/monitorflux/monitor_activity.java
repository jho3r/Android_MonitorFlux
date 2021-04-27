package com.monitorflux;


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
			processBA = new BA(this.getApplicationContext(), null, null, "com.monitorflux", "com.monitorflux.monitor_activity");
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
		activityBA = new BA(this, layout, processBA, "com.monitorflux", "com.monitorflux.monitor_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.monitorflux.monitor_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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

public anywheresoftware.b4a.keywords.Common __c = null;
public static com.monitorflux.httpjob _backendelessget = null;
public static String _nombred = "";
public static boolean _eliminado = false;
public b4a.example3.customlistview _lvelectro = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lbdispositivo = null;
public static String _urlget = "";
public static int _i = 0;
public anywheresoftware.b4a.objects.collections.List _listalterna = null;
public com.monitorflux.httpjob _historial = null;
public static String _urlhistorial = "";
public anywheresoftware.b4a.objects.collections.List _disfallando = null;
public com.monitorflux.main _main = null;
public com.monitorflux.starter _starter = null;
public com.monitorflux.tutoriales_activity _tutoriales_activity = null;
public com.monitorflux.agregar_activity _agregar_activity = null;
public com.monitorflux.datos_activity _datos_activity = null;
public com.monitorflux.registrar_activity _registrar_activity = null;
public com.monitorflux.grafica_activity _grafica_activity = null;
public com.monitorflux.httputils2service _httputils2service = null;
public com.monitorflux.dbutils _dbutils = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 30;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 31;BA.debugLine="Activity.LoadLayout(\"Monitoreo\")";
mostCurrent._activity.LoadLayout("Monitoreo",mostCurrent.activityBA);
 //BA.debugLineNum = 32;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
_setstatusbarcolor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (231),(int) (231),(int) (222)));
 //BA.debugLineNum = 33;BA.debugLine="urlGet = \"https://api.backendless.com/4D75900B-E5";
mostCurrent._urlget = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos?where=ownerId%20%3D%20";
 //BA.debugLineNum = 34;BA.debugLine="urlHistorial = Main.urlHistorial";
mostCurrent._urlhistorial = mostCurrent._main._urlhistorial /*String*/ ;
 //BA.debugLineNum = 35;BA.debugLine="historial.Initialize(\"historial\",Me)";
mostCurrent._historial._initialize /*String*/ (processBA,"historial",monitor_activity.getObject());
 //BA.debugLineNum = 36;BA.debugLine="listAlterna.Initialize";
mostCurrent._listalterna.Initialize();
 //BA.debugLineNum = 37;BA.debugLine="disFallando.Initialize   'guarda el estado de los";
mostCurrent._disfallando.Initialize();
 //BA.debugLineNum = 38;BA.debugLine="eliminado = False";
_eliminado = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 39;BA.debugLine="historial.Download(urlHistorial)";
mostCurrent._historial._download /*String*/ (mostCurrent._urlhistorial);
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 49;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 42;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 43;BA.debugLine="If eliminado = True Then";
if (_eliminado==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 44;BA.debugLine="Log(\"Eliminando actividad\")";
anywheresoftware.b4a.keywords.Common.LogImpl("62949122","Eliminando actividad",0);
 //BA.debugLineNum = 45;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public static String  _additems(String _texto,int _orden,String _id) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
int _a = 0;
 //BA.debugLineNum = 118;BA.debugLine="Sub addItems (texto As String, orden As Int, id As";
 //BA.debugLineNum = 119;BA.debugLine="Dim xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 120;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _xui.CreatePanel(processBA,"");
 //BA.debugLineNum = 121;BA.debugLine="p.SetLayoutAnimated(100,0,0,100%x,10%y)";
_p.SetLayoutAnimated((int) (100),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 122;BA.debugLine="p.LoadLayout(\"Item\")";
_p.LoadLayout("Item",mostCurrent.activityBA);
 //BA.debugLineNum = 123;BA.debugLine="lbDispositivo.Text=(texto)";
mostCurrent._lbdispositivo.setText(BA.ObjectToCharSequence((_texto)));
 //BA.debugLineNum = 124;BA.debugLine="For a=0 To disFallando.Size-1";
{
final int step6 = 1;
final int limit6 = (int) (mostCurrent._disfallando.getSize()-1);
_a = (int) (0) ;
for (;_a <= limit6 ;_a = _a + step6 ) {
 //BA.debugLineNum = 125;BA.debugLine="If id = disFallando.Get(a) Then";
if ((_id).equals(BA.ObjectToString(mostCurrent._disfallando.Get(_a)))) { 
 //BA.debugLineNum = 126;BA.debugLine="lbDispositivo.Color = Colors.ARGB(255,240,84,84";
mostCurrent._lbdispositivo.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (240),(int) (84),(int) (84)));
 };
 }
};
 //BA.debugLineNum = 129;BA.debugLine="lvElectro.Add(p,orden)";
mostCurrent._lvelectro._add(_p,(Object)(_orden));
 //BA.debugLineNum = 130;BA.debugLine="listAlterna.Add(texto)";
mostCurrent._listalterna.Add((Object)(_texto));
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return "";
}
public static String  _btnatrasm_click() throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Sub btnAtrasM_Click";
 //BA.debugLineNum = 55;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static String  _cargarvalores(String _res) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
String _nombre = "";
String _id = "";
 //BA.debugLineNum = 74;BA.debugLine="Sub cargarValores (res As String)";
 //BA.debugLineNum = 75;BA.debugLine="i=0";
_i = (int) (0);
 //BA.debugLineNum = 76;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 77;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
 //BA.debugLineNum = 80;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
 //BA.debugLineNum = 81;BA.debugLine="For Each colroot As Map In root				'map es simila";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group5 = _root;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group5.Get(index5)));
 //BA.debugLineNum = 82;BA.debugLine="Dim nombre As String = colroot.Get(\"nombre\")";
_nombre = BA.ObjectToString(_colroot.Get((Object)("nombre")));
 //BA.debugLineNum = 83;BA.debugLine="Dim id As String = colroot.Get(\"id\")";
_id = BA.ObjectToString(_colroot.Get((Object)("id")));
 //BA.debugLineNum = 84;BA.debugLine="addItems(nombre,i,id)";
_additems(_nombre,_i,_id);
 //BA.debugLineNum = 85;BA.debugLine="i = i + 1";
_i = (int) (_i+1);
 }
};
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public static String  _fallando(String _res) throws Exception{
long _fecha = 0L;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root = null;
int _a = 0;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
long _fechaentra = 0L;
String _estado = "";
 //BA.debugLineNum = 90;BA.debugLine="Sub fallando(res As String)";
 //BA.debugLineNum = 91;BA.debugLine="Dim fecha As Long = 0";
_fecha = (long) (0);
 //BA.debugLineNum = 92;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 93;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
 //BA.debugLineNum = 94;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
 //BA.debugLineNum = 95;BA.debugLine="For a=0 To Main.list.Size -1";
{
final int step5 = 1;
final int limit5 = (int) (mostCurrent._main._list /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
_a = (int) (0) ;
for (;_a <= limit5 ;_a = _a + step5 ) {
 //BA.debugLineNum = 96;BA.debugLine="For Each colroot As Map In root				'map es simil";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group6 = _root;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group6.Get(index6)));
 //BA.debugLineNum = 98;BA.debugLine="If colroot.Get(\"id\") = Main.list.Get(a) Then";
if ((_colroot.Get((Object)("id"))).equals(mostCurrent._main._list /*anywheresoftware.b4a.objects.collections.List*/ .Get(_a))) { 
 //BA.debugLineNum = 100;BA.debugLine="Dim fechaEntra As Long = colroot.Get(\"fecha\")";
_fechaentra = BA.ObjectToLongNumber(_colroot.Get((Object)("fecha")));
 //BA.debugLineNum = 101;BA.debugLine="If fechaEntra >= fecha Then";
if (_fechaentra>=_fecha) { 
 //BA.debugLineNum = 102;BA.debugLine="Dim estado As String = colroot.Get(\"encendida";
_estado = BA.ObjectToString(_colroot.Get((Object)("encendida")));
 //BA.debugLineNum = 103;BA.debugLine="fecha = fechaEntra";
_fecha = _fechaentra;
 };
 };
 }
};
 //BA.debugLineNum = 107;BA.debugLine="If estado = False Then";
if ((_estado).equals(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False))) { 
 //BA.debugLineNum = 108;BA.debugLine="disFallando.Add(Main.list.Get(a))";
mostCurrent._disfallando.Add(mostCurrent._main._list /*anywheresoftware.b4a.objects.collections.List*/ .Get(_a));
 };
 //BA.debugLineNum = 110;BA.debugLine="fecha = 0";
_fecha = (long) (0);
 }
};
 //BA.debugLineNum = 113;BA.debugLine="backendelessGet.Initialize(\"get\",Me)";
_backendelessget._initialize /*String*/ (processBA,"get",monitor_activity.getObject());
 //BA.debugLineNum = 114;BA.debugLine="backendelessGet.Download(urlGet & \"'\" & Main.ID &";
_backendelessget._download /*String*/ (mostCurrent._urlget+"'"+mostCurrent._main._id /*String*/ +"'");
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private lvElectro As CustomListView";
mostCurrent._lvelectro = new b4a.example3.customlistview();
 //BA.debugLineNum = 18;BA.debugLine="Private lbDispositivo As B4XView";
mostCurrent._lbdispositivo = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private urlGet As String";
mostCurrent._urlget = "";
 //BA.debugLineNum = 20;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 21;BA.debugLine="Dim listAlterna As List";
mostCurrent._listalterna = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 22;BA.debugLine="Dim historial As HttpJob";
mostCurrent._historial = new com.monitorflux.httpjob();
 //BA.debugLineNum = 23;BA.debugLine="Private urlHistorial As String";
mostCurrent._urlhistorial = "";
 //BA.debugLineNum = 24;BA.debugLine="Dim disFallando As List";
mostCurrent._disfallando = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(com.monitorflux.httpjob _job) throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Sub JobDone (Job As HttpJob)";
 //BA.debugLineNum = 59;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("63145729","JobName = "+_job._jobname /*String*/ +", Success = "+BA.ObjectToString(_job._success /*boolean*/ ),0);
 //BA.debugLineNum = 60;BA.debugLine="If Job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 61;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"get","historial")) {
case 0: {
 //BA.debugLineNum = 63;BA.debugLine="cargarValores(Job.GetString) 'se envia la cade";
_cargarvalores(_job._getstring /*String*/ ());
 break; }
case 1: {
 //BA.debugLineNum = 65;BA.debugLine="fallando(Job.GetString)";
_fallando(_job._getstring /*String*/ ());
 break; }
}
;
 }else {
 //BA.debugLineNum = 68;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("63145738","Error: "+_job._errormessage /*String*/ ,0);
 //BA.debugLineNum = 69;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 71;BA.debugLine="Job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public static String  _lvelectro_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 133;BA.debugLine="Sub lvElectro_ItemClick (Index As Int, Value As Ob";
 //BA.debugLineNum = 134;BA.debugLine="nombreD = listAlterna.Get(Value)";
_nombred = BA.ObjectToString(mostCurrent._listalterna.Get((int)(BA.ObjectToNumber(_value))));
 //BA.debugLineNum = 135;BA.debugLine="StartActivity(Datos_Activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._datos_activity.getObject()));
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim backendelessGet As HttpJob 'se debe inicializ";
_backendelessget = new com.monitorflux.httpjob();
 //BA.debugLineNum = 10;BA.debugLine="Dim nombreD As String";
_nombred = "";
 //BA.debugLineNum = 11;BA.debugLine="Public eliminado As Boolean";
_eliminado = false;
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public static String  _setstatusbarcolor(int _clr) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
 //BA.debugLineNum = 138;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
 //BA.debugLineNum = 139;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 140;BA.debugLine="If p.SdkVersion >= 21 Then";
if (_p.getSdkVersion()>=21) { 
 //BA.debugLineNum = 141;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 142;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
 //BA.debugLineNum = 143;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 144;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(0x80000000)});
 //BA.debugLineNum = 145;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(0x04000000)});
 //BA.debugLineNum = 146;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
 };
 //BA.debugLineNum = 148;BA.debugLine="If p.SdkVersion >= 23 Then";
if (_p.getSdkVersion()>=23) { 
 //BA.debugLineNum = 149;BA.debugLine="jo = Activity";
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(mostCurrent._activity.getObject()));
 //BA.debugLineNum = 150;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
_jo.RunMethod("setSystemUiVisibility",new Object[]{(Object)(8192)});
 };
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
return "";
}
}
