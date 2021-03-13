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
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="Activity.LoadLayout(\"Datos\")";
mostCurrent._activity.LoadLayout("Datos",mostCurrent.activityBA);
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="urlGet = \"https://api.backendless.com/85B70858-21";
mostCurrent._urlget = "https://api.backendless.com/85B70858-2193-2A92-FF8E-BF8B113D4100/CC232E12-9D6D-40A6-A41A-23796B090767/data/Dispositivos";
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="urlHistorial = \"https://api.backendless.com/85B70";
mostCurrent._urlhistorial = "https://api.backendless.com/85B70858-2193-2A92-FF8E-BF8B113D4100/CC232E12-9D6D-40A6-A41A-23796B090767/data/Historial";
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="backendelessGet.Initialize(\"get\",Me)";
mostCurrent._backendelessget._initialize /*String*/ (null,processBA,"get",datos_activity.getObject());
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="historial.Initialize(\"historial\",Me)";
mostCurrent._historial._initialize /*String*/ (null,processBA,"historial",datos_activity.getObject());
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="backendelessGet.Download(urlGet)";
mostCurrent._backendelessget._download /*String*/ (null,mostCurrent._urlget);
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="datos_activity";
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="datos_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="End Sub";
return "";
}
public static String  _btnatrase_click() throws Exception{
RDebugUtils.currentModule="datos_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnatrase_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnatrase_click", null));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub btnAtrasE_Click";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Sub cargarDatos (res As String)";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=6619141;
 //BA.debugLineNum = 6619141;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
RDebugUtils.currentLine=6619142;
 //BA.debugLineNum = 6619142;BA.debugLine="For Each colroot As Map In root				'map es simila";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group4 = _root;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group4.Get(index4)));
RDebugUtils.currentLine=6619143;
 //BA.debugLineNum = 6619143;BA.debugLine="If colroot.Get(\"nombre\") = Monitor_Activity.nomb";
if ((_colroot.Get((Object)("nombre"))).equals((Object)(mostCurrent._monitor_activity._nombred /*String*/ ))) { 
RDebugUtils.currentLine=6619144;
 //BA.debugLineNum = 6619144;BA.debugLine="Dim nombre As String = colroot.Get(\"nombre\")";
_nombre = BA.ObjectToString(_colroot.Get((Object)("nombre")));
RDebugUtils.currentLine=6619145;
 //BA.debugLineNum = 6619145;BA.debugLine="Dim descripcion As String = colroot.Get(\"descri";
_descripcion = BA.ObjectToString(_colroot.Get((Object)("descripcion")));
RDebugUtils.currentLine=6619146;
 //BA.debugLineNum = 6619146;BA.debugLine="Dim numero As String = colroot.Get(\"numero\")";
_numero = BA.ObjectToString(_colroot.Get((Object)("numero")));
 };
 }
};
RDebugUtils.currentLine=6619149;
 //BA.debugLineNum = 6619149;BA.debugLine="lbNombre.Text = nombre";
mostCurrent._lbnombre.setText(BA.ObjectToCharSequence(_nombre));
RDebugUtils.currentLine=6619150;
 //BA.debugLineNum = 6619150;BA.debugLine="lbNumero.Text = numero";
mostCurrent._lbnumero.setText(BA.ObjectToCharSequence(_numero));
RDebugUtils.currentLine=6619151;
 //BA.debugLineNum = 6619151;BA.debugLine="lbDescrip.Text = descripcion";
mostCurrent._lbdescrip.setText(BA.ObjectToCharSequence(_descripcion));
RDebugUtils.currentLine=6619152;
 //BA.debugLineNum = 6619152;BA.debugLine="historial.Download(urlHistorial)";
mostCurrent._historial._download /*String*/ (null,mostCurrent._urlhistorial);
RDebugUtils.currentLine=6619153;
 //BA.debugLineNum = 6619153;BA.debugLine="End Sub";
return "";
}
public static String  _cargarestado(String _res) throws Exception{
RDebugUtils.currentModule="datos_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cargarestado", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cargarestado", new Object[] {_res}));}
int _fecha = 0;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
int _fechaentra = 0;
String _estado = "";
String _flujo = "";
long _fechaactual = 0L;
int _actual = 0;
String _mensaje = "";
RDebugUtils.currentLine=7077888;
 //BA.debugLineNum = 7077888;BA.debugLine="Sub cargarEstado (res As String)";
RDebugUtils.currentLine=7077889;
 //BA.debugLineNum = 7077889;BA.debugLine="Dim fecha As Int = 0";
_fecha = (int) (0);
RDebugUtils.currentLine=7077890;
 //BA.debugLineNum = 7077890;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=7077891;
 //BA.debugLineNum = 7077891;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=7077894;
 //BA.debugLineNum = 7077894;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
RDebugUtils.currentLine=7077895;
 //BA.debugLineNum = 7077895;BA.debugLine="For Each colroot As Map In root				'map es simila";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group5 = _root;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group5.Get(index5)));
RDebugUtils.currentLine=7077896;
 //BA.debugLineNum = 7077896;BA.debugLine="If colroot.Get(\"dispositivo\") = lbNombre.Text Th";
if ((_colroot.Get((Object)("dispositivo"))).equals((Object)(mostCurrent._lbnombre.getText()))) { 
RDebugUtils.currentLine=7077897;
 //BA.debugLineNum = 7077897;BA.debugLine="Dim fechaEntra As Int = colroot.Get(\"fecha\")";
_fechaentra = (int)(BA.ObjectToNumber(_colroot.Get((Object)("fecha"))));
RDebugUtils.currentLine=7077898;
 //BA.debugLineNum = 7077898;BA.debugLine="If fechaEntra >= fecha Then";
if (_fechaentra>=_fecha) { 
RDebugUtils.currentLine=7077899;
 //BA.debugLineNum = 7077899;BA.debugLine="Dim estado As String = colroot.Get(\"estado\")";
_estado = BA.ObjectToString(_colroot.Get((Object)("estado")));
RDebugUtils.currentLine=7077900;
 //BA.debugLineNum = 7077900;BA.debugLine="Dim flujo As String = colroot.Get(\"flujo\")";
_flujo = BA.ObjectToString(_colroot.Get((Object)("flujo")));
RDebugUtils.currentLine=7077901;
 //BA.debugLineNum = 7077901;BA.debugLine="fecha = colroot.Get(\"fecha\")";
_fecha = (int)(BA.ObjectToNumber(_colroot.Get((Object)("fecha"))));
 };
 };
 }
};
RDebugUtils.currentLine=7077905;
 //BA.debugLineNum = 7077905;BA.debugLine="If estado = True Then";
if ((_estado).equals(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.True))) { 
RDebugUtils.currentLine=7077906;
 //BA.debugLineNum = 7077906;BA.debugLine="lbEstado.Text = \"Encendido\"";
mostCurrent._lbestado.setText(BA.ObjectToCharSequence("Encendido"));
RDebugUtils.currentLine=7077907;
 //BA.debugLineNum = 7077907;BA.debugLine="lbEstado.Color = Colors.ARGB(128,0,136,145)";
mostCurrent._lbestado.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (128),(int) (0),(int) (136),(int) (145)));
 }else 
{RDebugUtils.currentLine=7077908;
 //BA.debugLineNum = 7077908;BA.debugLine="Else If estado = False Then";
if ((_estado).equals(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False))) { 
RDebugUtils.currentLine=7077909;
 //BA.debugLineNum = 7077909;BA.debugLine="lbEstado.Text = \"Apagado\"";
mostCurrent._lbestado.setText(BA.ObjectToCharSequence("Apagado"));
RDebugUtils.currentLine=7077910;
 //BA.debugLineNum = 7077910;BA.debugLine="lbEstado.Color = Colors.ARGB(128,240,84,84)";
mostCurrent._lbestado.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (128),(int) (240),(int) (84),(int) (84)));
 }}
;
RDebugUtils.currentLine=7077912;
 //BA.debugLineNum = 7077912;BA.debugLine="lbFlujo.Text = flujo & \" Litros/Hora\"";
mostCurrent._lbflujo.setText(BA.ObjectToCharSequence(_flujo+" Litros/Hora"));
RDebugUtils.currentLine=7077914;
 //BA.debugLineNum = 7077914;BA.debugLine="DateTime.DateFormat = \"yyyyMMddHHmm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyyMMddHHmm");
RDebugUtils.currentLine=7077915;
 //BA.debugLineNum = 7077915;BA.debugLine="Dim fechaActual As Long = DateTime.Date(DateTime.";
_fechaactual = (long)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
RDebugUtils.currentLine=7077916;
 //BA.debugLineNum = 7077916;BA.debugLine="Dim actual As Int = fechaActual - fecha";
_actual = (int) (_fechaactual-_fecha);
RDebugUtils.currentLine=7077917;
 //BA.debugLineNum = 7077917;BA.debugLine="Dim mensaje As String";
_mensaje = "";
RDebugUtils.currentLine=7077918;
 //BA.debugLineNum = 7077918;BA.debugLine="If actual <= 30 Then";
if (_actual<=30) { 
RDebugUtils.currentLine=7077919;
 //BA.debugLineNum = 7077919;BA.debugLine="mensaje = \"Actualizado hace menos de 30 minutos\"";
_mensaje = "Actualizado hace menos de 30 minutos";
 }else 
{RDebugUtils.currentLine=7077920;
 //BA.debugLineNum = 7077920;BA.debugLine="Else If actual <= 100 Then";
if (_actual<=100) { 
RDebugUtils.currentLine=7077921;
 //BA.debugLineNum = 7077921;BA.debugLine="mensaje = \"Actualizado hace 1 hora\"";
_mensaje = "Actualizado hace 1 hora";
 }else 
{RDebugUtils.currentLine=7077922;
 //BA.debugLineNum = 7077922;BA.debugLine="Else If actual <= 400 Then";
if (_actual<=400) { 
RDebugUtils.currentLine=7077923;
 //BA.debugLineNum = 7077923;BA.debugLine="mensaje = \"Actualizado hace 4 horas\"";
_mensaje = "Actualizado hace 4 horas";
 }else 
{RDebugUtils.currentLine=7077924;
 //BA.debugLineNum = 7077924;BA.debugLine="Else If actual <= 1200 Then";
if (_actual<=1200) { 
RDebugUtils.currentLine=7077925;
 //BA.debugLineNum = 7077925;BA.debugLine="mensaje = \"Actualizado hace menos de 12 horas\"";
_mensaje = "Actualizado hace menos de 12 horas";
 }else 
{RDebugUtils.currentLine=7077926;
 //BA.debugLineNum = 7077926;BA.debugLine="Else If	actual <= 10000 Then";
if (_actual<=10000) { 
RDebugUtils.currentLine=7077927;
 //BA.debugLineNum = 7077927;BA.debugLine="mensaje = \"Actualizado hace 1 dia\"";
_mensaje = "Actualizado hace 1 dia";
 }else {
RDebugUtils.currentLine=7077929;
 //BA.debugLineNum = 7077929;BA.debugLine="mensaje = \"Desactualizado\"";
_mensaje = "Desactualizado";
 }}}}}
;
RDebugUtils.currentLine=7077931;
 //BA.debugLineNum = 7077931;BA.debugLine="lbActualizado.Text = mensaje";
mostCurrent._lbactualizado.setText(BA.ObjectToCharSequence(_mensaje));
RDebugUtils.currentLine=7077932;
 //BA.debugLineNum = 7077932;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="datos_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Sub JobDone (Job As HttpJob)";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("36684673","JobName = "+_job._jobname /*String*/ +", Success = "+BA.ObjectToString(_job._success /*boolean*/ ),0);
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="If Job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=6684675;
 //BA.debugLineNum = 6684675;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"get","historial")) {
case 0: {
RDebugUtils.currentLine=6684677;
 //BA.debugLineNum = 6684677;BA.debugLine="cargarDatos(Job.GetString) 'se envia la cadena";
_cargardatos(_job._getstring /*String*/ (null));
 break; }
case 1: {
RDebugUtils.currentLine=6684679;
 //BA.debugLineNum = 6684679;BA.debugLine="cargarEstado(Job.GetString)";
_cargarestado(_job._getstring /*String*/ (null));
 break; }
}
;
 }else {
RDebugUtils.currentLine=6684682;
 //BA.debugLineNum = 6684682;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("36684682","Error: "+_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=6684683;
 //BA.debugLineNum = 6684683;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=6684685;
 //BA.debugLineNum = 6684685;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=6684686;
 //BA.debugLineNum = 6684686;BA.debugLine="End Sub";
return "";
}
}