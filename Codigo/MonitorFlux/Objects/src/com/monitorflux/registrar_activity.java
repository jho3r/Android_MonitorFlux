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
			processBA = new BA(this.getApplicationContext(), null, null, "com.monitorflux", "com.monitorflux.registrar_activity");
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
		activityBA = new BA(this, layout, processBA, "com.monitorflux", "com.monitorflux.registrar_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.monitorflux.registrar_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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

public anywheresoftware.b4a.keywords.Common __c = null;
public com.monitorflux.httpjob _iniciarsesion = null;
public com.monitorflux.httpjob _registrar = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etcorreo = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etpassword = null;
public static String _urliniciar = "";
public anywheresoftware.b4a.objects.EditTextWrapper _etnombre = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etconfirm = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etcorreor = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etpasswordr = null;
public static String _urlregistrar = "";
public static String _correo = "";
public static String _clave = "";
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbmantener = null;
public com.monitorflux.main _main = null;
public com.monitorflux.starter _starter = null;
public com.monitorflux.tutoriales_activity _tutoriales_activity = null;
public com.monitorflux.agregar_activity _agregar_activity = null;
public com.monitorflux.monitor_activity _monitor_activity = null;
public com.monitorflux.datos_activity _datos_activity = null;
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
 //BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"Iniciar\")";
mostCurrent._activity.LoadLayout("Iniciar",mostCurrent.activityBA);
 //BA.debugLineNum = 33;BA.debugLine="IniciarSesion.Initialize(\"iniciar\",Me)";
mostCurrent._iniciarsesion._initialize /*String*/ (processBA,"iniciar",registrar_activity.getObject());
 //BA.debugLineNum = 34;BA.debugLine="urlIniciar = \"https://api.backendless.com/4D75900";
mostCurrent._urliniciar = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/users/login";
 //BA.debugLineNum = 35;BA.debugLine="urlRegistrar = \"https://api.backendless.com/4D759";
mostCurrent._urlregistrar = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/users/register";
 //BA.debugLineNum = 36;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
_setstatusbarcolor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (231),(int) (231),(int) (222)));
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public static String  _btnatrasa_click() throws Exception{
 //BA.debugLineNum = 185;BA.debugLine="Sub btnAtrasA_Click";
 //BA.debugLineNum = 186;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 187;BA.debugLine="Activity.LoadLayout(\"Iniciar\")";
mostCurrent._activity.LoadLayout("Iniciar",mostCurrent.activityBA);
 //BA.debugLineNum = 188;BA.debugLine="End Sub";
return "";
}
public static String  _btniniciar_click() throws Exception{
String _datos = "";
 //BA.debugLineNum = 72;BA.debugLine="Sub btnIniciar_Click";
 //BA.debugLineNum = 73;BA.debugLine="If etCorreo.Text <> \"\" And etPassword.Text <> \"\"";
if ((mostCurrent._etcorreo.getText()).equals("") == false && (mostCurrent._etpassword.getText()).equals("") == false) { 
 //BA.debugLineNum = 74;BA.debugLine="If etCorreo.Text.Contains(\"@\") Then";
if (mostCurrent._etcorreo.getText().contains("@")) { 
 //BA.debugLineNum = 75;BA.debugLine="correo  = etCorreo.Text";
mostCurrent._correo = mostCurrent._etcorreo.getText();
 //BA.debugLineNum = 76;BA.debugLine="clave  = etPassword.Text";
mostCurrent._clave = mostCurrent._etpassword.getText();
 //BA.debugLineNum = 77;BA.debugLine="Dim datos As String";
_datos = "";
 //BA.debugLineNum = 78;BA.debugLine="datos = \"{\"&Chr(34)&\"login\"&Chr(34)&\":\"&Chr(34)";
_datos = "{"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"login"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+mostCurrent._correo+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"password"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+mostCurrent._clave+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"}";
 //BA.debugLineNum = 79;BA.debugLine="IniciarSesion.PostString(urlIniciar, datos)";
mostCurrent._iniciarsesion._poststring /*String*/ (mostCurrent._urliniciar,_datos);
 //BA.debugLineNum = 80;BA.debugLine="IniciarSesion.GetRequest.SetContentType(\"applic";
mostCurrent._iniciarsesion._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/json");
 //BA.debugLineNum = 81;BA.debugLine="ProgressDialogShow(\"Iniciando sesión\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Iniciando sesión"));
 }else if((mostCurrent._etcorreo.getText()).equals("admin") && (mostCurrent._etpassword.getText()).equals("admin")) { 
 //BA.debugLineNum = 83;BA.debugLine="correo = Starter.usuarioAdmin";
mostCurrent._correo = mostCurrent._starter._usuarioadmin /*String*/ ;
 //BA.debugLineNum = 84;BA.debugLine="clave = Starter.claveAdmin";
mostCurrent._clave = mostCurrent._starter._claveadmin /*String*/ ;
 //BA.debugLineNum = 85;BA.debugLine="Dim datos As String";
_datos = "";
 //BA.debugLineNum = 86;BA.debugLine="datos = \"{\"&Chr(34)&\"login\"&Chr(34)&\":\"&Chr(34)";
_datos = "{"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"login"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+mostCurrent._correo+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"password"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+mostCurrent._clave+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"}";
 //BA.debugLineNum = 87;BA.debugLine="IniciarSesion.PostString(urlIniciar, datos)";
mostCurrent._iniciarsesion._poststring /*String*/ (mostCurrent._urliniciar,_datos);
 //BA.debugLineNum = 88;BA.debugLine="IniciarSesion.GetRequest.SetContentType(\"applic";
mostCurrent._iniciarsesion._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/json");
 //BA.debugLineNum = 89;BA.debugLine="ProgressDialogShow(\"Iniciando sesión\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Iniciando sesión"));
 }else {
 //BA.debugLineNum = 91;BA.debugLine="ToastMessageShow(\"Correo invalido\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Correo invalido"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
 //BA.debugLineNum = 94;BA.debugLine="ToastMessageShow(\"Rellena todos los campos\",True";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Rellena todos los campos"),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public static String  _btnregistrar_click() throws Exception{
String _nombre = "";
String _datos = "";
 //BA.debugLineNum = 132;BA.debugLine="Sub btnRegistrar_Click";
 //BA.debugLineNum = 133;BA.debugLine="If etNombre.Text == \"\" Or etCorreoR.Text ==\"\" Or";
if ((mostCurrent._etnombre.getText()).equals("") || (mostCurrent._etcorreor.getText()).equals("") || (mostCurrent._etpasswordr.getText()).equals("") || (mostCurrent._etconfirm.getText()).equals("")) { 
 //BA.debugLineNum = 134;BA.debugLine="ToastMessageShow(\"Error! ... Aegurate de llenar";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error! ... Aegurate de llenar todos los campos"),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 136;BA.debugLine="If etPasswordR.Text <> etConfirm.Text Then";
if ((mostCurrent._etpasswordr.getText()).equals(mostCurrent._etconfirm.getText()) == false) { 
 //BA.debugLineNum = 137;BA.debugLine="ToastMessageShow(\"Error! ... Las contraseñas no";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error! ... Las contraseñas no coinciden"),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 139;BA.debugLine="Dim correo As String = etCorreoR.Text";
mostCurrent._correo = mostCurrent._etcorreor.getText();
 //BA.debugLineNum = 140;BA.debugLine="Dim clave As String = etPasswordR.Text";
mostCurrent._clave = mostCurrent._etpasswordr.getText();
 //BA.debugLineNum = 141;BA.debugLine="Dim Nombre As String = etNombre.Text";
_nombre = mostCurrent._etnombre.getText();
 //BA.debugLineNum = 142;BA.debugLine="Dim datos As String";
_datos = "";
 //BA.debugLineNum = 143;BA.debugLine="datos = \"{\"&Chr(34)&\"email\"&Chr(34)&\":\"&Chr(34)";
_datos = "{"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"email"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+mostCurrent._correo+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"password"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+mostCurrent._clave+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"name"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+_nombre+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"}";
 //BA.debugLineNum = 144;BA.debugLine="Registrar.PostString(urlRegistrar, datos)";
mostCurrent._registrar._poststring /*String*/ (mostCurrent._urlregistrar,_datos);
 //BA.debugLineNum = 145;BA.debugLine="Registrar.GetRequest.SetContentType(\"applicatio";
mostCurrent._registrar._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/json");
 //BA.debugLineNum = 146;BA.debugLine="ProgressDialogShow(\"Registro en proceso\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Registro en proceso"));
 };
 };
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim IniciarSesion As HttpJob";
mostCurrent._iniciarsesion = new com.monitorflux.httpjob();
 //BA.debugLineNum = 16;BA.debugLine="Dim Registrar As HttpJob";
mostCurrent._registrar = new com.monitorflux.httpjob();
 //BA.debugLineNum = 17;BA.debugLine="Private etCorreo As EditText";
mostCurrent._etcorreo = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private etPassword As EditText";
mostCurrent._etpassword = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private urlIniciar As String";
mostCurrent._urliniciar = "";
 //BA.debugLineNum = 20;BA.debugLine="Private etNombre As EditText";
mostCurrent._etnombre = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private etConfirm As EditText";
mostCurrent._etconfirm = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private etCorreoR As EditText";
mostCurrent._etcorreor = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private etPasswordR As EditText";
mostCurrent._etpasswordr = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private urlRegistrar As String";
mostCurrent._urlregistrar = "";
 //BA.debugLineNum = 25;BA.debugLine="Private correo As String";
mostCurrent._correo = "";
 //BA.debugLineNum = 26;BA.debugLine="Private clave As String";
mostCurrent._clave = "";
 //BA.debugLineNum = 27;BA.debugLine="Private cbMantener As CheckBox";
mostCurrent._cbmantener = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public static String  _handleerror(String _res) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
int _code = 0;
String _mesage = "";
 //BA.debugLineNum = 164;BA.debugLine="Sub handleError(res As String)";
 //BA.debugLineNum = 165;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 166;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 167;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
 //BA.debugLineNum = 168;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 169;BA.debugLine="Dim code As Int = root.Get(\"code\")";
_code = (int)(BA.ObjectToNumber(_root.Get((Object)("code"))));
 //BA.debugLineNum = 170;BA.debugLine="Dim mesage As String";
_mesage = "";
 //BA.debugLineNum = 171;BA.debugLine="Select code";
switch (_code) {
case 3003: {
 //BA.debugLineNum = 173;BA.debugLine="mesage = \"El correo o la contraseña no son corr";
_mesage = "El correo o la contraseña no son correctos";
 break; }
case 3033: {
 //BA.debugLineNum = 175;BA.debugLine="mesage = \"El usuario ya esta registrado\"";
_mesage = "El usuario ya esta registrado";
 break; }
case 3087: {
 //BA.debugLineNum = 177;BA.debugLine="mesage = \"No puedes iniciar sesion, primero deb";
_mesage = "No puedes iniciar sesion, primero debes confirmar tu email";
 break; }
default: {
 //BA.debugLineNum = 179;BA.debugLine="mesage = root.Get(\"message\")";
_mesage = BA.ObjectToString(_root.Get((Object)("message")));
 break; }
}
;
 //BA.debugLineNum = 182;BA.debugLine="MsgboxAsync(mesage,\"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence(_mesage),BA.ObjectToCharSequence("Error"),processBA);
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(com.monitorflux.httpjob _job) throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Sub JobDone (Job As HttpJob)";
 //BA.debugLineNum = 48;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("65046273","JobName = "+_job._jobname /*String*/ +", Success = "+BA.ObjectToString(_job._success /*boolean*/ ),0);
 //BA.debugLineNum = 49;BA.debugLine="If Job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 50;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"iniciar","registrar")) {
case 0: {
 //BA.debugLineNum = 52;BA.debugLine="resInicio(Job.GetString) 'se envia la cadena r";
_resinicio(_job._getstring /*String*/ ());
 break; }
case 1: {
 //BA.debugLineNum = 54;BA.debugLine="resRegistrar(Job.GetString)";
_resregistrar(_job._getstring /*String*/ ());
 break; }
}
;
 }else {
 //BA.debugLineNum = 57;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("65046282","Error: "+_job._errormessage /*String*/ ,0);
 //BA.debugLineNum = 58;BA.debugLine="handleError(Job.ErrorMessage)";
_handleerror(_job._errormessage /*String*/ );
 };
 //BA.debugLineNum = 61;BA.debugLine="Job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _lbregistrar_click() throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Sub lbRegistrar_Click";
 //BA.debugLineNum = 66;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 67;BA.debugLine="Activity.LoadLayout(\"Registrar\")";
mostCurrent._activity.LoadLayout("Registrar",mostCurrent.activityBA);
 //BA.debugLineNum = 68;BA.debugLine="Registrar.Initialize(\"registrar\",Me)";
mostCurrent._registrar._initialize /*String*/ (processBA,"registrar",registrar_activity.getObject());
 //BA.debugLineNum = 69;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
_setstatusbarcolor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (231),(int) (231),(int) (222)));
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _resinicio(String _res) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
 //BA.debugLineNum = 99;BA.debugLine="Sub resInicio(res As String)";
 //BA.debugLineNum = 100;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 101;BA.debugLine="Main.inicio = True";
mostCurrent._main._inicio /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 102;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 103;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
 //BA.debugLineNum = 104;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 105;BA.debugLine="Main.ID = root.Get(\"objectId\")";
mostCurrent._main._id /*String*/  = BA.ObjectToString(_root.Get((Object)("objectId")));
 //BA.debugLineNum = 107;BA.debugLine="If cbMantener.Checked Then";
if (mostCurrent._cbmantener.getChecked()) { 
 //BA.debugLineNum = 108;BA.debugLine="Starter.actualizarCampos(\"usuario\",correo,\"id\",\"";
mostCurrent._starter._actualizarcampos /*String*/ ("usuario",mostCurrent._correo,"id","1");
 //BA.debugLineNum = 109;BA.debugLine="Starter.actualizarCampos(\"clave\",clave,\"id\",\"1\")";
mostCurrent._starter._actualizarcampos /*String*/ ("clave",mostCurrent._clave,"id","1");
 //BA.debugLineNum = 110;BA.debugLine="Starter.actualizarCampos(\"mantener\",\"1\",\"id\",\"1\"";
mostCurrent._starter._actualizarcampos /*String*/ ("mantener","1","id","1");
 };
 //BA.debugLineNum = 113;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public static String  _resregistrar(String _res) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
String _nombre = "";
String _titulo = "";
 //BA.debugLineNum = 151;BA.debugLine="Sub resRegistrar(res As String)";
 //BA.debugLineNum = 152;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 153;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 154;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
 //BA.debugLineNum = 155;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 156;BA.debugLine="Dim nombre As String = root.Get(\"name\")";
_nombre = BA.ObjectToString(_root.Get((Object)("name")));
 //BA.debugLineNum = 157;BA.debugLine="Dim titulo As String = \"Hola \" & nombre";
_titulo = "Hola "+_nombre;
 //BA.debugLineNum = 158;BA.debugLine="MsgboxAsync(\"Tu usuario ha sido registrado correc";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Tu usuario ha sido registrado correctamente, puedes activar tu cuenta desde el correo que ha sido enviado a tu email"),BA.ObjectToCharSequence(_titulo),processBA);
 //BA.debugLineNum = 159;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 160;BA.debugLine="Activity.LoadLayout(\"Iniciar\")";
mostCurrent._activity.LoadLayout("Iniciar",mostCurrent.activityBA);
 //BA.debugLineNum = 161;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
_setstatusbarcolor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (231),(int) (231),(int) (222)));
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public static String  _setstatusbarcolor(int _clr) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
 //BA.debugLineNum = 116;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
 //BA.debugLineNum = 117;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 118;BA.debugLine="If p.SdkVersion >= 21 Then";
if (_p.getSdkVersion()>=21) { 
 //BA.debugLineNum = 119;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 120;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
 //BA.debugLineNum = 121;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 122;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(0x80000000)});
 //BA.debugLineNum = 123;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(0x04000000)});
 //BA.debugLineNum = 124;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
 };
 //BA.debugLineNum = 126;BA.debugLine="If p.SdkVersion >= 23 Then";
if (_p.getSdkVersion()>=23) { 
 //BA.debugLineNum = 127;BA.debugLine="jo = Activity";
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(mostCurrent._activity.getObject()));
 //BA.debugLineNum = 128;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
_jo.RunMethod("setSystemUiVisibility",new Object[]{(Object)(8192)});
 };
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
}
