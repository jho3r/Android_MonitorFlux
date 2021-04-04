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

public class registrar_activity extends Activity implements B4AActivity{
	public static registrar_activity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.registrar_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (registrar_activity).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.registrar_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.registrar_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (registrar_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (registrar_activity) Resume **");
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
		return registrar_activity.class;
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
            BA.LogInfo("** Activity (registrar_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (registrar_activity) Pause event (activity is not paused). **");
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
            registrar_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (registrar_activity) Resume **");
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
public b4a.example.httpjob _iniciarsesion = null;
public b4a.example.httpjob _registrar = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etcorreo = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etpassword = null;
public static String _urliniciar = "";
public anywheresoftware.b4a.objects.EditTextWrapper _etnombre = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etconfirm = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etcorreor = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etpasswordr = null;
public static String _urlregistrar = "";
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.tutoriales_activity _tutoriales_activity = null;
public b4a.example.agregar_activity _agregar_activity = null;
public b4a.example.monitor_activity _monitor_activity = null;
public b4a.example.datos_activity _datos_activity = null;
public b4a.example.httputils2service _httputils2service = null;
public b4a.example.dbutils _dbutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="registrar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=7405568;
 //BA.debugLineNum = 7405568;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=7405570;
 //BA.debugLineNum = 7405570;BA.debugLine="Activity.LoadLayout(\"Iniciar\")";
mostCurrent._activity.LoadLayout("Iniciar",mostCurrent.activityBA);
RDebugUtils.currentLine=7405571;
 //BA.debugLineNum = 7405571;BA.debugLine="IniciarSesion.Initialize(\"iniciar\",Me)";
mostCurrent._iniciarsesion._initialize /*String*/ (null,processBA,"iniciar",registrar_activity.getObject());
RDebugUtils.currentLine=7405572;
 //BA.debugLineNum = 7405572;BA.debugLine="urlIniciar = \"https://api.backendless.com/4D75900";
mostCurrent._urliniciar = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/users/login";
RDebugUtils.currentLine=7405573;
 //BA.debugLineNum = 7405573;BA.debugLine="urlRegistrar = \"https://api.backendless.com/4D759";
mostCurrent._urlregistrar = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/users/register";
RDebugUtils.currentLine=7405574;
 //BA.debugLineNum = 7405574;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
_setstatusbarcolor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (231),(int) (231),(int) (222)));
RDebugUtils.currentLine=7405575;
 //BA.debugLineNum = 7405575;BA.debugLine="End Sub";
return "";
}
public static String  _setstatusbarcolor(int _clr) throws Exception{
RDebugUtils.currentModule="registrar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "setstatusbarcolor", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "setstatusbarcolor", new Object[] {_clr}));}
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
RDebugUtils.currentLine=7864321;
 //BA.debugLineNum = 7864321;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=7864322;
 //BA.debugLineNum = 7864322;BA.debugLine="If p.SdkVersion >= 21 Then";
if (_p.getSdkVersion()>=21) { 
RDebugUtils.currentLine=7864323;
 //BA.debugLineNum = 7864323;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=7864324;
 //BA.debugLineNum = 7864324;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
RDebugUtils.currentLine=7864325;
 //BA.debugLineNum = 7864325;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=7864326;
 //BA.debugLineNum = 7864326;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(0x80000000)});
RDebugUtils.currentLine=7864327;
 //BA.debugLineNum = 7864327;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(0x04000000)});
RDebugUtils.currentLine=7864328;
 //BA.debugLineNum = 7864328;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
 };
RDebugUtils.currentLine=7864330;
 //BA.debugLineNum = 7864330;BA.debugLine="If p.SdkVersion >= 23 Then";
if (_p.getSdkVersion()>=23) { 
RDebugUtils.currentLine=7864331;
 //BA.debugLineNum = 7864331;BA.debugLine="jo = Activity";
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(mostCurrent._activity.getObject()));
RDebugUtils.currentLine=7864332;
 //BA.debugLineNum = 7864332;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
_jo.RunMethod("setSystemUiVisibility",new Object[]{(Object)(8192)});
 };
RDebugUtils.currentLine=7864334;
 //BA.debugLineNum = 7864334;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="registrar_activity";
RDebugUtils.currentLine=7536640;
 //BA.debugLineNum = 7536640;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=7536642;
 //BA.debugLineNum = 7536642;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="registrar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=7471104;
 //BA.debugLineNum = 7471104;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=7471106;
 //BA.debugLineNum = 7471106;BA.debugLine="End Sub";
return "";
}
public static String  _btnatrasa_click() throws Exception{
RDebugUtils.currentModule="registrar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnatrasa_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnatrasa_click", null));}
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Sub btnAtrasA_Click";
RDebugUtils.currentLine=8126465;
 //BA.debugLineNum = 8126465;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="Activity.LoadLayout(\"Iniciar\")";
mostCurrent._activity.LoadLayout("Iniciar",mostCurrent.activityBA);
RDebugUtils.currentLine=8126467;
 //BA.debugLineNum = 8126467;BA.debugLine="End Sub";
return "";
}
public static String  _btniniciar_click() throws Exception{
RDebugUtils.currentModule="registrar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btniniciar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btniniciar_click", null));}
String _correo = "";
String _clave = "";
String _datos = "";
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Sub btnIniciar_Click";
RDebugUtils.currentLine=7733249;
 //BA.debugLineNum = 7733249;BA.debugLine="If etCorreo.Text <> \"\" And etPassword.Text <> \"\"";
if ((mostCurrent._etcorreo.getText()).equals("") == false && (mostCurrent._etpassword.getText()).equals("") == false) { 
RDebugUtils.currentLine=7733250;
 //BA.debugLineNum = 7733250;BA.debugLine="If etCorreo.Text.Contains(\"@\") Then";
if (mostCurrent._etcorreo.getText().contains("@")) { 
RDebugUtils.currentLine=7733251;
 //BA.debugLineNum = 7733251;BA.debugLine="Dim correo As String = etCorreo.Text";
_correo = mostCurrent._etcorreo.getText();
RDebugUtils.currentLine=7733252;
 //BA.debugLineNum = 7733252;BA.debugLine="Dim clave As String = etPassword.Text";
_clave = mostCurrent._etpassword.getText();
RDebugUtils.currentLine=7733253;
 //BA.debugLineNum = 7733253;BA.debugLine="Dim datos As String";
_datos = "";
RDebugUtils.currentLine=7733254;
 //BA.debugLineNum = 7733254;BA.debugLine="datos = \"{\"&Chr(34)&\"login\"&Chr(34)&\":\"&Chr(34)";
_datos = "{"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"login"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+_correo+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"password"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+_clave+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"}";
RDebugUtils.currentLine=7733255;
 //BA.debugLineNum = 7733255;BA.debugLine="IniciarSesion.PostString(urlIniciar, datos)";
mostCurrent._iniciarsesion._poststring /*String*/ (null,mostCurrent._urliniciar,_datos);
RDebugUtils.currentLine=7733256;
 //BA.debugLineNum = 7733256;BA.debugLine="IniciarSesion.GetRequest.SetContentType(\"applic";
mostCurrent._iniciarsesion._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("application/json");
RDebugUtils.currentLine=7733257;
 //BA.debugLineNum = 7733257;BA.debugLine="ProgressDialogShow(\"Iniciando sesión\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Iniciando sesión"));
 }else 
{RDebugUtils.currentLine=7733258;
 //BA.debugLineNum = 7733258;BA.debugLine="Else If etCorreo.Text == \"admin\" And etPassword.";
if ((mostCurrent._etcorreo.getText()).equals("admin") && (mostCurrent._etpassword.getText()).equals("admin")) { 
RDebugUtils.currentLine=7733259;
 //BA.debugLineNum = 7733259;BA.debugLine="Dim correo As String = Starter.usuarioAdmin";
_correo = mostCurrent._starter._usuarioadmin /*String*/ ;
RDebugUtils.currentLine=7733260;
 //BA.debugLineNum = 7733260;BA.debugLine="Dim clave As String = Starter.claveAdmin";
_clave = mostCurrent._starter._claveadmin /*String*/ ;
RDebugUtils.currentLine=7733261;
 //BA.debugLineNum = 7733261;BA.debugLine="Dim datos As String";
_datos = "";
RDebugUtils.currentLine=7733262;
 //BA.debugLineNum = 7733262;BA.debugLine="datos = \"{\"&Chr(34)&\"login\"&Chr(34)&\":\"&Chr(34)";
_datos = "{"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"login"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+_correo+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"password"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+_clave+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"}";
RDebugUtils.currentLine=7733263;
 //BA.debugLineNum = 7733263;BA.debugLine="IniciarSesion.PostString(urlIniciar, datos)";
mostCurrent._iniciarsesion._poststring /*String*/ (null,mostCurrent._urliniciar,_datos);
RDebugUtils.currentLine=7733264;
 //BA.debugLineNum = 7733264;BA.debugLine="IniciarSesion.GetRequest.SetContentType(\"applic";
mostCurrent._iniciarsesion._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("application/json");
RDebugUtils.currentLine=7733265;
 //BA.debugLineNum = 7733265;BA.debugLine="ProgressDialogShow(\"Iniciando sesión\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Iniciando sesión"));
 }else {
RDebugUtils.currentLine=7733267;
 //BA.debugLineNum = 7733267;BA.debugLine="ToastMessageShow(\"Correo invalido\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Correo invalido"),anywheresoftware.b4a.keywords.Common.True);
 }}
;
 }else {
RDebugUtils.currentLine=7733270;
 //BA.debugLineNum = 7733270;BA.debugLine="ToastMessageShow(\"Rellena todos los campos\",True";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Rellena todos los campos"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=7733272;
 //BA.debugLineNum = 7733272;BA.debugLine="End Sub";
return "";
}
public static String  _btnregistrar_click() throws Exception{
RDebugUtils.currentModule="registrar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnregistrar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnregistrar_click", null));}
String _correo = "";
String _clave = "";
String _nombre = "";
String _datos = "";
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Sub btnRegistrar_Click";
RDebugUtils.currentLine=7929857;
 //BA.debugLineNum = 7929857;BA.debugLine="If etNombre.Text == \"\" Or etCorreoR.Text ==\"\" Or";
if ((mostCurrent._etnombre.getText()).equals("") || (mostCurrent._etcorreor.getText()).equals("") || (mostCurrent._etpasswordr.getText()).equals("") || (mostCurrent._etconfirm.getText()).equals("")) { 
RDebugUtils.currentLine=7929858;
 //BA.debugLineNum = 7929858;BA.debugLine="ToastMessageShow(\"Error! ... Aegurate de llenar";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error! ... Aegurate de llenar todos los campos"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=7929860;
 //BA.debugLineNum = 7929860;BA.debugLine="If etPasswordR.Text <> etConfirm.Text Then";
if ((mostCurrent._etpasswordr.getText()).equals(mostCurrent._etconfirm.getText()) == false) { 
RDebugUtils.currentLine=7929861;
 //BA.debugLineNum = 7929861;BA.debugLine="ToastMessageShow(\"Error! ... Las contraseñas no";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error! ... Las contraseñas no coinciden"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=7929863;
 //BA.debugLineNum = 7929863;BA.debugLine="Dim correo As String = etCorreoR.Text";
_correo = mostCurrent._etcorreor.getText();
RDebugUtils.currentLine=7929864;
 //BA.debugLineNum = 7929864;BA.debugLine="Dim clave As String = etPasswordR.Text";
_clave = mostCurrent._etpasswordr.getText();
RDebugUtils.currentLine=7929865;
 //BA.debugLineNum = 7929865;BA.debugLine="Dim Nombre As String = etNombre.Text";
_nombre = mostCurrent._etnombre.getText();
RDebugUtils.currentLine=7929866;
 //BA.debugLineNum = 7929866;BA.debugLine="Dim datos As String";
_datos = "";
RDebugUtils.currentLine=7929867;
 //BA.debugLineNum = 7929867;BA.debugLine="datos = \"{\"&Chr(34)&\"email\"&Chr(34)&\":\"&Chr(34)";
_datos = "{"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"email"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+_correo+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"password"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+_clave+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"name"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+_nombre+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"}";
RDebugUtils.currentLine=7929868;
 //BA.debugLineNum = 7929868;BA.debugLine="Registrar.PostString(urlRegistrar, datos)";
mostCurrent._registrar._poststring /*String*/ (null,mostCurrent._urlregistrar,_datos);
RDebugUtils.currentLine=7929869;
 //BA.debugLineNum = 7929869;BA.debugLine="Registrar.GetRequest.SetContentType(\"applicatio";
mostCurrent._registrar._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("application/json");
RDebugUtils.currentLine=7929870;
 //BA.debugLineNum = 7929870;BA.debugLine="ProgressDialogShow(\"Registro en proceso\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Registro en proceso"));
 };
 };
RDebugUtils.currentLine=7929873;
 //BA.debugLineNum = 7929873;BA.debugLine="End Sub";
return "";
}
public static String  _handleerror(String _res) throws Exception{
RDebugUtils.currentModule="registrar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "handleerror", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "handleerror", new Object[] {_res}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
int _code = 0;
String _mesage = "";
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Sub handleError(res As String)";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=8060931;
 //BA.debugLineNum = 8060931;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=8060932;
 //BA.debugLineNum = 8060932;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=8060933;
 //BA.debugLineNum = 8060933;BA.debugLine="Dim code As Int = root.Get(\"code\")";
_code = (int)(BA.ObjectToNumber(_root.Get((Object)("code"))));
RDebugUtils.currentLine=8060934;
 //BA.debugLineNum = 8060934;BA.debugLine="Dim mesage As String";
_mesage = "";
RDebugUtils.currentLine=8060935;
 //BA.debugLineNum = 8060935;BA.debugLine="Select code";
switch (_code) {
case 3003: {
RDebugUtils.currentLine=8060937;
 //BA.debugLineNum = 8060937;BA.debugLine="mesage = \"El correo o la contraseña no son corr";
_mesage = "El correo o la contraseña no son correctos";
 break; }
case 3033: {
RDebugUtils.currentLine=8060939;
 //BA.debugLineNum = 8060939;BA.debugLine="mesage = \"El usuario ya esta registrado\"";
_mesage = "El usuario ya esta registrado";
 break; }
case 3087: {
RDebugUtils.currentLine=8060941;
 //BA.debugLineNum = 8060941;BA.debugLine="mesage = \"No puedes iniciar sesion, primero deb";
_mesage = "No puedes iniciar sesion, primero debes confirmar tu email";
 break; }
default: {
RDebugUtils.currentLine=8060943;
 //BA.debugLineNum = 8060943;BA.debugLine="mesage = root.Get(\"message\")";
_mesage = BA.ObjectToString(_root.Get((Object)("message")));
 break; }
}
;
RDebugUtils.currentLine=8060946;
 //BA.debugLineNum = 8060946;BA.debugLine="MsgboxAsync(mesage,\"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence(_mesage),BA.ObjectToCharSequence("Error"),processBA);
RDebugUtils.currentLine=8060947;
 //BA.debugLineNum = 8060947;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="registrar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=7602176;
 //BA.debugLineNum = 7602176;BA.debugLine="Sub JobDone (Job As HttpJob)";
RDebugUtils.currentLine=7602177;
 //BA.debugLineNum = 7602177;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("17602177","JobName = "+_job._jobname /*String*/ +", Success = "+BA.ObjectToString(_job._success /*boolean*/ ),0);
RDebugUtils.currentLine=7602178;
 //BA.debugLineNum = 7602178;BA.debugLine="If Job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=7602179;
 //BA.debugLineNum = 7602179;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"iniciar","registrar")) {
case 0: {
RDebugUtils.currentLine=7602181;
 //BA.debugLineNum = 7602181;BA.debugLine="resInicio(Job.GetString) 'se envia la cadena r";
_resinicio(_job._getstring /*String*/ (null));
 break; }
case 1: {
RDebugUtils.currentLine=7602183;
 //BA.debugLineNum = 7602183;BA.debugLine="resRegistrar(Job.GetString)";
_resregistrar(_job._getstring /*String*/ (null));
 break; }
}
;
 }else {
RDebugUtils.currentLine=7602186;
 //BA.debugLineNum = 7602186;BA.debugLine="handleError(Job.ErrorMessage)";
_handleerror(_job._errormessage /*String*/ );
 };
RDebugUtils.currentLine=7602190;
 //BA.debugLineNum = 7602190;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=7602191;
 //BA.debugLineNum = 7602191;BA.debugLine="End Sub";
return "";
}
public static String  _resinicio(String _res) throws Exception{
RDebugUtils.currentModule="registrar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "resinicio", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "resinicio", new Object[] {_res}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Sub resInicio(res As String)";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="Main.inicio = True";
mostCurrent._main._inicio /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=7798787;
 //BA.debugLineNum = 7798787;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=7798788;
 //BA.debugLineNum = 7798788;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=7798789;
 //BA.debugLineNum = 7798789;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=7798790;
 //BA.debugLineNum = 7798790;BA.debugLine="Main.ID = root.Get(\"objectId\")";
mostCurrent._main._id /*String*/  = BA.ObjectToString(_root.Get((Object)("objectId")));
RDebugUtils.currentLine=7798791;
 //BA.debugLineNum = 7798791;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=7798792;
 //BA.debugLineNum = 7798792;BA.debugLine="End Sub";
return "";
}
public static String  _resregistrar(String _res) throws Exception{
RDebugUtils.currentModule="registrar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "resregistrar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "resregistrar", new Object[] {_res}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
String _nombre = "";
String _titulo = "";
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Sub resRegistrar(res As String)";
RDebugUtils.currentLine=7995393;
 //BA.debugLineNum = 7995393;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=7995395;
 //BA.debugLineNum = 7995395;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=7995396;
 //BA.debugLineNum = 7995396;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=7995397;
 //BA.debugLineNum = 7995397;BA.debugLine="Dim nombre As String = root.Get(\"name\")";
_nombre = BA.ObjectToString(_root.Get((Object)("name")));
RDebugUtils.currentLine=7995398;
 //BA.debugLineNum = 7995398;BA.debugLine="Dim titulo As String = \"Hola \" & nombre";
_titulo = "Hola "+_nombre;
RDebugUtils.currentLine=7995399;
 //BA.debugLineNum = 7995399;BA.debugLine="MsgboxAsync(\"Tu usuario ha sido registrado correc";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Tu usuario ha sido registrado correctamente, puedes activar tu cuenta desde el correo que ha sido enviado a tu email"),BA.ObjectToCharSequence(_titulo),processBA);
RDebugUtils.currentLine=7995400;
 //BA.debugLineNum = 7995400;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=7995401;
 //BA.debugLineNum = 7995401;BA.debugLine="Activity.LoadLayout(\"Iniciar\")";
mostCurrent._activity.LoadLayout("Iniciar",mostCurrent.activityBA);
RDebugUtils.currentLine=7995402;
 //BA.debugLineNum = 7995402;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
_setstatusbarcolor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (231),(int) (231),(int) (222)));
RDebugUtils.currentLine=7995403;
 //BA.debugLineNum = 7995403;BA.debugLine="End Sub";
return "";
}
public static String  _lbregistrar_click() throws Exception{
RDebugUtils.currentModule="registrar_activity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbregistrar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbregistrar_click", null));}
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Sub lbRegistrar_Click";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=7667714;
 //BA.debugLineNum = 7667714;BA.debugLine="Activity.LoadLayout(\"Registrar\")";
mostCurrent._activity.LoadLayout("Registrar",mostCurrent.activityBA);
RDebugUtils.currentLine=7667715;
 //BA.debugLineNum = 7667715;BA.debugLine="Registrar.Initialize(\"registrar\",Me)";
mostCurrent._registrar._initialize /*String*/ (null,processBA,"registrar",registrar_activity.getObject());
RDebugUtils.currentLine=7667716;
 //BA.debugLineNum = 7667716;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
_setstatusbarcolor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (231),(int) (231),(int) (222)));
RDebugUtils.currentLine=7667717;
 //BA.debugLineNum = 7667717;BA.debugLine="End Sub";
return "";
}
}