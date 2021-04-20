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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.monitorflux", "com.monitorflux.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "com.monitorflux", "com.monitorflux.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.monitorflux.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.objects.Timer _tmrintro = null;
public static anywheresoftware.b4a.objects.collections.List _list = null;
public static boolean _inicio = false;
public static String _id = "";
public static String _urlhistorial = "";
public anywheresoftware.b4a.objects.LabelWrapper _lbfallas = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbbombas = null;
public static String _urlget = "";
public com.monitorflux.httpjob _backendelessget = null;
public static int _i = 0;
public static int _disfallando = 0;
public com.monitorflux.httpjob _historial = null;
public com.monitorflux.httpjob _iniciarsesion = null;
public static String _urliniciar = "";
public com.monitorflux.starter _starter = null;
public com.monitorflux.tutoriales_activity _tutoriales_activity = null;
public com.monitorflux.agregar_activity _agregar_activity = null;
public com.monitorflux.monitor_activity _monitor_activity = null;
public com.monitorflux.datos_activity _datos_activity = null;
public com.monitorflux.registrar_activity _registrar_activity = null;
public com.monitorflux.httputils2service _httputils2service = null;
public com.monitorflux.dbutils _dbutils = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (tutoriales_activity.mostCurrent != null);
vis = vis | (agregar_activity.mostCurrent != null);
vis = vis | (monitor_activity.mostCurrent != null);
vis = vis | (datos_activity.mostCurrent != null);
vis = vis | (registrar_activity.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 41;BA.debugLine="If FirstTime=True Then";
if (_firsttime==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 42;BA.debugLine="Activity.LoadLayout(\"Intro\")			'cargamos el layo";
mostCurrent._activity.LoadLayout("Intro",mostCurrent.activityBA);
 //BA.debugLineNum = 43;BA.debugLine="tmrIntro.Initialize(\"tmrIntro\",3000)	'inicializa";
_tmrintro.Initialize(processBA,"tmrIntro",(long) (3000));
 //BA.debugLineNum = 44;BA.debugLine="tmrIntro.Enabled = True					'Se ejecuta en tmrIn";
_tmrintro.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 45;BA.debugLine="inicio = False";
_inicio = anywheresoftware.b4a.keywords.Common.False;
 }else {
 //BA.debugLineNum = 47;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 48;BA.debugLine="Activity.LoadLayout(\"Principal\")";
mostCurrent._activity.LoadLayout("Principal",mostCurrent.activityBA);
 };
 //BA.debugLineNum = 51;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
_setstatusbarcolor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (231),(int) (231),(int) (222)));
 //BA.debugLineNum = 52;BA.debugLine="urlHistorial = \"https://api.backendless.com/4D759";
_urlhistorial = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Historial?pageSize=100&property=fecha&property=id&property=encendida&where=id%3D'000000'";
 //BA.debugLineNum = 53;BA.debugLine="urlGet = \"https://api.backendless.com/4D75900B-E5";
mostCurrent._urlget = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos?where=ownerId%20%3D%20";
 //BA.debugLineNum = 54;BA.debugLine="backendelessGet.Initialize(\"get\",Me)";
mostCurrent._backendelessget._initialize /*String*/ (processBA,"get",main.getObject());
 //BA.debugLineNum = 55;BA.debugLine="list.Initialize";
_list.Initialize();
 //BA.debugLineNum = 56;BA.debugLine="IniciarSesion.Initialize(\"iniciar\",Me)";
mostCurrent._iniciarsesion._initialize /*String*/ (processBA,"iniciar",main.getObject());
 //BA.debugLineNum = 57;BA.debugLine="urlIniciar = \"https://api.backendless.com/4D75900";
mostCurrent._urliniciar = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/users/login";
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 61;BA.debugLine="If tmrIntro.Enabled = False Then";
if (_tmrintro.getEnabled()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 62;BA.debugLine="Log(\"Timer deshabilitado, intentando inicio\")";
anywheresoftware.b4a.keywords.Common.LogImpl("8196610","Timer deshabilitado, intentando inicio",0);
 //BA.debugLineNum = 63;BA.debugLine="intentoInicio";
_intentoinicio();
 };
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _btnagregar_click() throws Exception{
 //BA.debugLineNum = 91;BA.debugLine="Sub btnAgregar_Click";
 //BA.debugLineNum = 92;BA.debugLine="StartActivity(Agregar_Activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._agregar_activity.getObject()));
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public static String  _btnmonitoreo_click() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Sub btnMonitoreo_Click";
 //BA.debugLineNum = 88;BA.debugLine="StartActivity(Monitor_Activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._monitor_activity.getObject()));
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public static String  _btnout_click() throws Exception{
 //BA.debugLineNum = 201;BA.debugLine="Sub btnOut_Click";
 //BA.debugLineNum = 202;BA.debugLine="Starter.actualizarCampos(\"mantener\",\"0\",\"id\",\"1\")";
mostCurrent._starter._actualizarcampos /*String*/ ("mantener","0","id","1");
 //BA.debugLineNum = 203;BA.debugLine="inicio = False";
_inicio = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 204;BA.debugLine="intentoInicio";
_intentoinicio();
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
return "";
}
public static String  _btntutorial_click() throws Exception{
 //BA.debugLineNum = 95;BA.debugLine="Sub btnTutorial_Click";
 //BA.debugLineNum = 96;BA.debugLine="StartActivity(Tutoriales_Activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tutoriales_activity.getObject()));
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return "";
}
public static String  _conteo(String _res) throws Exception{
String _historialmas = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
String _nombre = "";
 //BA.debugLineNum = 134;BA.debugLine="Sub conteo(res As String)";
 //BA.debugLineNum = 135;BA.debugLine="i=0";
_i = (int) (0);
 //BA.debugLineNum = 136;BA.debugLine="Dim historialmas As String = \"\"";
_historialmas = "";
 //BA.debugLineNum = 137;BA.debugLine="list.Clear";
_list.Clear();
 //BA.debugLineNum = 138;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 139;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
 //BA.debugLineNum = 140;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
 //BA.debugLineNum = 141;BA.debugLine="For Each colroot As Map In root				'map es simila";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group7 = _root;
final int groupLen7 = group7.getSize()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group7.Get(index7)));
 //BA.debugLineNum = 142;BA.debugLine="Dim nombre As String = colroot.Get(\"id\")";
_nombre = BA.ObjectToString(_colroot.Get((Object)("id")));
 //BA.debugLineNum = 143;BA.debugLine="list.Add(nombre)";
_list.Add((Object)(_nombre));
 //BA.debugLineNum = 144;BA.debugLine="i = i + 1";
_i = (int) (_i+1);
 //BA.debugLineNum = 145;BA.debugLine="historialmas = historialmas & \"%20or%20id%3D'\"&n";
_historialmas = _historialmas+"%20or%20id%3D'"+_nombre+"'";
 }
};
 //BA.debugLineNum = 147;BA.debugLine="lbBombas.Text = i & \" Dispositivos\"";
mostCurrent._lbbombas.setText(BA.ObjectToCharSequence(BA.NumberToString(_i)+" Dispositivos"));
 //BA.debugLineNum = 148;BA.debugLine="historial.Initialize(\"historial\",Me)";
mostCurrent._historial._initialize /*String*/ (processBA,"historial",main.getObject());
 //BA.debugLineNum = 149;BA.debugLine="urlHistorial = urlHistorial & historialmas";
_urlhistorial = _urlhistorial+_historialmas;
 //BA.debugLineNum = 150;BA.debugLine="historial.Download(urlHistorial)";
mostCurrent._historial._download /*String*/ (_urlhistorial);
 //BA.debugLineNum = 151;BA.debugLine="End Sub";
return "";
}
public static String  _fallando(String _res) throws Exception{
long _fecha = 0L;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
int _a = 0;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
long _fechaentra = 0L;
boolean _estado = false;
 //BA.debugLineNum = 153;BA.debugLine="Sub fallando(res As String)";
 //BA.debugLineNum = 154;BA.debugLine="disFallando = 0";
_disfallando = (int) (0);
 //BA.debugLineNum = 155;BA.debugLine="Dim fecha As Long = 0";
_fecha = (long) (0);
 //BA.debugLineNum = 156;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 157;BA.debugLine="For a=0 To list.Size -1";
{
final int step4 = 1;
final int limit4 = (int) (_list.getSize()-1);
_a = (int) (0) ;
for (;_a <= limit4 ;_a = _a + step4 ) {
 //BA.debugLineNum = 158;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
 //BA.debugLineNum = 159;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
 //BA.debugLineNum = 160;BA.debugLine="For Each colroot As Map In root				'map es simil";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group7 = _root;
final int groupLen7 = group7.getSize()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group7.Get(index7)));
 //BA.debugLineNum = 162;BA.debugLine="If colroot.Get(\"id\") = list.Get(a) Then";
if ((_colroot.Get((Object)("id"))).equals(_list.Get(_a))) { 
 //BA.debugLineNum = 165;BA.debugLine="Dim fechaEntra As Long = colroot.Get(\"fecha\")";
_fechaentra = BA.ObjectToLongNumber(_colroot.Get((Object)("fecha")));
 //BA.debugLineNum = 166;BA.debugLine="If fechaEntra >= fecha Then";
if (_fechaentra>=_fecha) { 
 //BA.debugLineNum = 167;BA.debugLine="Dim estado As Boolean = colroot.Get(\"encendid";
_estado = BA.ObjectToBoolean(_colroot.Get((Object)("encendida")));
 //BA.debugLineNum = 168;BA.debugLine="fecha = fechaEntra";
_fecha = _fechaentra;
 };
 };
 }
};
 //BA.debugLineNum = 172;BA.debugLine="If estado = False Then";
if (_estado==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 173;BA.debugLine="disFallando = disFallando + 1";
_disfallando = (int) (_disfallando+1);
 //BA.debugLineNum = 174;BA.debugLine="Log(disFallando)";
anywheresoftware.b4a.keywords.Common.LogImpl("8786453",BA.NumberToString(_disfallando),0);
 };
 //BA.debugLineNum = 176;BA.debugLine="fecha = 0";
_fecha = (long) (0);
 }
};
 //BA.debugLineNum = 179;BA.debugLine="lbFallas.Text = disFallando & \" Fallando\"";
mostCurrent._lbfallas.setText(BA.ObjectToCharSequence(BA.NumberToString(_disfallando)+" Fallando"));
 //BA.debugLineNum = 180;BA.debugLine="If disFallando > 0 Then";
if (_disfallando>0) { 
 //BA.debugLineNum = 181;BA.debugLine="lbFallas.Color = Colors.ARGB(255,240,84,84)";
mostCurrent._lbfallas.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (240),(int) (84),(int) (84)));
 }else {
 //BA.debugLineNum = 183;BA.debugLine="lbFallas.Color = Colors.ARGB(128,0,136,145)";
mostCurrent._lbfallas.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (128),(int) (0),(int) (136),(int) (145)));
 };
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 29;BA.debugLine="Private lbFallas As Label";
mostCurrent._lbfallas = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private lbBombas As Label";
mostCurrent._lbbombas = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Dim urlGet As String";
mostCurrent._urlget = "";
 //BA.debugLineNum = 32;BA.debugLine="Dim backendelessGet As HttpJob 'se debe inicializ";
mostCurrent._backendelessget = new com.monitorflux.httpjob();
 //BA.debugLineNum = 33;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 34;BA.debugLine="Dim disFallando As Int";
_disfallando = 0;
 //BA.debugLineNum = 35;BA.debugLine="Dim historial As HttpJob";
mostCurrent._historial = new com.monitorflux.httpjob();
 //BA.debugLineNum = 36;BA.debugLine="Private IniciarSesion As HttpJob";
mostCurrent._iniciarsesion = new com.monitorflux.httpjob();
 //BA.debugLineNum = 37;BA.debugLine="Private urlIniciar As String";
mostCurrent._urliniciar = "";
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _intentoinicio() throws Exception{
 //BA.debugLineNum = 187;BA.debugLine="Sub intentoInicio";
 //BA.debugLineNum = 189;BA.debugLine="If inicio == False Then";
if (_inicio==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 190;BA.debugLine="StartActivity(Registrar_Activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._registrar_activity.getObject()));
 }else {
 //BA.debugLineNum = 193;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 194;BA.debugLine="Activity.LoadLayout(\"Principal\")		'cargamos la p";
mostCurrent._activity.LoadLayout("Principal",mostCurrent.activityBA);
 //BA.debugLineNum = 195;BA.debugLine="backendelessGet.Download(urlGet & \"'\" & ID & \"'\"";
mostCurrent._backendelessget._download /*String*/ (mostCurrent._urlget+"'"+_id+"'");
 };
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(com.monitorflux.httpjob _job) throws Exception{
 //BA.debugLineNum = 115;BA.debugLine="Sub JobDone (Job As HttpJob)";
 //BA.debugLineNum = 116;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("8655361","JobName = "+_job._jobname /*String*/ +", Success = "+BA.ObjectToString(_job._success /*boolean*/ ),0);
 //BA.debugLineNum = 117;BA.debugLine="If Job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 118;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"get","historial","iniciar")) {
case 0: {
 //BA.debugLineNum = 120;BA.debugLine="conteo(Job.GetString) 'se envia la cadena reci";
_conteo(_job._getstring /*String*/ ());
 break; }
case 1: {
 //BA.debugLineNum = 122;BA.debugLine="Log(Job.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("8655367",_job._getstring /*String*/ (),0);
 //BA.debugLineNum = 123;BA.debugLine="fallando(Job.GetString)";
_fallando(_job._getstring /*String*/ ());
 break; }
case 2: {
 //BA.debugLineNum = 125;BA.debugLine="resInicio(Job.GetString) 'se envia la cadena r";
_resinicio(_job._getstring /*String*/ ());
 break; }
}
;
 }else {
 //BA.debugLineNum = 128;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("8655373","Error: "+_job._errormessage /*String*/ ,0);
 //BA.debugLineNum = 129;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 131;BA.debugLine="Job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
starter._process_globals();
tutoriales_activity._process_globals();
agregar_activity._process_globals();
monitor_activity._process_globals();
datos_activity._process_globals();
registrar_activity._process_globals();
httputils2service._process_globals();
dbutils._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 20;BA.debugLine="Dim tmrIntro As Timer 'Timer para el intro de la";
_tmrintro = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 21;BA.debugLine="Dim list As List";
_list = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 22;BA.debugLine="Dim inicio As Boolean";
_inicio = false;
 //BA.debugLineNum = 23;BA.debugLine="Dim ID As String";
_id = "";
 //BA.debugLineNum = 24;BA.debugLine="Dim urlHistorial As String";
_urlhistorial = "";
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _resinicio(String _res) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
 //BA.debugLineNum = 207;BA.debugLine="Sub resInicio(res As String)";
 //BA.debugLineNum = 208;BA.debugLine="inicio = True";
_inicio = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 209;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 210;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
 //BA.debugLineNum = 211;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 212;BA.debugLine="ID = root.Get(\"objectId\")";
_id = BA.ObjectToString(_root.Get((Object)("objectId")));
 //BA.debugLineNum = 213;BA.debugLine="intentoInicio";
_intentoinicio();
 //BA.debugLineNum = 214;BA.debugLine="End Sub";
return "";
}
public static String  _setstatusbarcolor(int _clr) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
 //BA.debugLineNum = 99;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
 //BA.debugLineNum = 100;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 101;BA.debugLine="If p.SdkVersion >= 21 Then";
if (_p.getSdkVersion()>=21) { 
 //BA.debugLineNum = 102;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 103;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
 //BA.debugLineNum = 104;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 105;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(0x80000000)});
 //BA.debugLineNum = 106;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(0x04000000)});
 //BA.debugLineNum = 107;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
 };
 //BA.debugLineNum = 109;BA.debugLine="If p.SdkVersion >= 23 Then";
if (_p.getSdkVersion()>=23) { 
 //BA.debugLineNum = 110;BA.debugLine="jo = Activity";
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(mostCurrent._activity.getObject()));
 //BA.debugLineNum = 111;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
_jo.RunMethod("setSystemUiVisibility",new Object[]{(Object)(8192)});
 };
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
public static String  _tmrintro_tick() throws Exception{
String _datos = "";
 //BA.debugLineNum = 73;BA.debugLine="Sub tmrIntro_Tick";
 //BA.debugLineNum = 74;BA.debugLine="tmrIntro.Enabled = False";
_tmrintro.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 75;BA.debugLine="Log(\"Finalizando intro inicial intentando inicio\"";
anywheresoftware.b4a.keywords.Common.LogImpl("8327682","Finalizando intro inicial intentando inicio",0);
 //BA.debugLineNum = 76;BA.debugLine="If Starter.checkMantener Then";
if (mostCurrent._starter._checkmantener /*boolean*/ ()) { 
 //BA.debugLineNum = 77;BA.debugLine="Dim datos As String";
_datos = "";
 //BA.debugLineNum = 78;BA.debugLine="datos = \"{\"&Chr(34)&\"login\"&Chr(34)&\":\"&Chr(34)&";
_datos = "{"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"login"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+mostCurrent._starter._usuario /*String*/ +BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"password"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+mostCurrent._starter._clave /*String*/ +BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"}";
 //BA.debugLineNum = 79;BA.debugLine="IniciarSesion.PostString(urlIniciar, datos)";
mostCurrent._iniciarsesion._poststring /*String*/ (mostCurrent._urliniciar,_datos);
 //BA.debugLineNum = 80;BA.debugLine="IniciarSesion.GetRequest.SetContentType(\"applica";
mostCurrent._iniciarsesion._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/json");
 }else {
 //BA.debugLineNum = 82;BA.debugLine="intentoInicio";
_intentoinicio();
 };
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
}
