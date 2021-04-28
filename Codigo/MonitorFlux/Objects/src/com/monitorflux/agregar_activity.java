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

public class agregar_activity extends Activity implements B4AActivity{
	public static agregar_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.monitorflux", "com.monitorflux.agregar_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (agregar_activity).");
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
		activityBA = new BA(this, layout, processBA, "com.monitorflux", "com.monitorflux.agregar_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.monitorflux.agregar_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (agregar_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (agregar_activity) Resume **");
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
		return agregar_activity.class;
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
            BA.LogInfo("** Activity (agregar_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (agregar_activity) Pause event (activity is not paused). **");
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
            agregar_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (agregar_activity) Resume **");
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
public anywheresoftware.b4a.objects.IME _ime = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etnombre = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etnumero = null;
public anywheresoftware.b4a.phone.PhoneEvents.SMSInterceptor _smsreceiver = null;
public anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public static String _nombre = "";
public static String _numero = "";
public static String _descripcion = "";
public static boolean _checkbox = false;
public anywheresoftware.b4a.objects.EditTextWrapper _etdescrip = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbmensajes = null;
public static String _urlagregar = "";
public com.monitorflux.httpjob _agregar = null;
public anywheresoftware.b4a.phone.Phone.PhoneSms _enviarsms = null;
public com.monitorflux.main _main = null;
public com.monitorflux.starter _starter = null;
public com.monitorflux.tutoriales_activity _tutoriales_activity = null;
public com.monitorflux.monitor_activity _monitor_activity = null;
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
public static void  _activity_create(boolean _firsttime) throws Exception{
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(com.monitorflux.agregar_activity parent,boolean _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
com.monitorflux.agregar_activity parent;
boolean _firsttime;
String _permission = "";
boolean _result = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 37;BA.debugLine="Activity.RemoveAllViews";
parent.mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 38;BA.debugLine="Activity.LoadLayout(\"Agregar\")";
parent.mostCurrent._activity.LoadLayout("Agregar",mostCurrent.activityBA);
 //BA.debugLineNum = 39;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
_setstatusbarcolor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (231),(int) (231),(int) (222)));
 //BA.debugLineNum = 40;BA.debugLine="ime.Initialize(\"\")					'inicializo el ime";
parent.mostCurrent._ime.Initialize("");
 //BA.debugLineNum = 41;BA.debugLine="ime.SetLengthFilter(etNombre,24)	'Determino el li";
parent.mostCurrent._ime.SetLengthFilter((android.widget.EditText)(parent.mostCurrent._etnombre.getObject()),(int) (24));
 //BA.debugLineNum = 42;BA.debugLine="ime.SetLengthFilter(etNumero,10)	'Determino el li";
parent.mostCurrent._ime.SetLengthFilter((android.widget.EditText)(parent.mostCurrent._etnumero.getObject()),(int) (10));
 //BA.debugLineNum = 51;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_RECEIVE_SMS) 'IN";
parent.mostCurrent._rp.CheckAndRequest(processBA,parent.mostCurrent._rp.PERMISSION_RECEIVE_SMS);
 //BA.debugLineNum = 52;BA.debugLine="Wait For Activity_PermissionResult(Permission As";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, this, null);
this.state = 9;
return;
case 9:
//C
this.state = 1;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 53;BA.debugLine="If Result Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 54;BA.debugLine="ToastMessageShow(\"Permiso para recibir mensaje e";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Permiso para recibir mensaje en uso"),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 56;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_SEND_SMS) 'INICI";
parent.mostCurrent._rp.CheckAndRequest(processBA,parent.mostCurrent._rp.PERMISSION_SEND_SMS);
 //BA.debugLineNum = 57;BA.debugLine="Wait For Activity_PermissionResult(Permission As";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, this, null);
this.state = 10;
return;
case 10:
//C
this.state = 5;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 58;BA.debugLine="If Result Then";
if (true) break;

case 5:
//if
this.state = 8;
if (_result) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
 //BA.debugLineNum = 59;BA.debugLine="ToastMessageShow(\"Permiso para enviar mensaje en";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Permiso para enviar mensaje en uso"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 8:
//C
this.state = -1;
;
 //BA.debugLineNum = 61;BA.debugLine="smsReceiver.Initialize(\"smsReceiver\")";
parent.mostCurrent._smsreceiver.Initialize("smsReceiver",processBA);
 //BA.debugLineNum = 62;BA.debugLine="urlAgregar = \"https://api.backendless.com/4D75900";
parent.mostCurrent._urlagregar = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos";
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _activity_permissionresult(String _permission,boolean _result) throws Exception{
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _btnatrasa_click() throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Sub btnAtrasA_Click";
 //BA.debugLineNum = 75;BA.debugLine="smsReceiver.StopListening";
mostCurrent._smsreceiver.StopListening();
 //BA.debugLineNum = 76;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
public static String  _btnconectar_click() throws Exception{
 //BA.debugLineNum = 79;BA.debugLine="Sub btnConectar_Click";
 //BA.debugLineNum = 80;BA.debugLine="nombre = etNombre.Text";
mostCurrent._nombre = mostCurrent._etnombre.getText();
 //BA.debugLineNum = 81;BA.debugLine="numero = etNumero.Text";
mostCurrent._numero = mostCurrent._etnumero.getText();
 //BA.debugLineNum = 82;BA.debugLine="descripcion = etDescrip.Text";
mostCurrent._descripcion = mostCurrent._etdescrip.getText();
 //BA.debugLineNum = 83;BA.debugLine="checkbox = cbMensajes.Checked";
_checkbox = mostCurrent._cbmensajes.getChecked();
 //BA.debugLineNum = 84;BA.debugLine="enviarSMS.Send2(numero,\"000004\",False,False)";
mostCurrent._enviarsms.Send2(mostCurrent._numero,"000004",anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 85;BA.debugLine="ProgressDialogShow(\"Conectando con el dispositivo";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Conectando con el dispositivo... Espere un momento"));
 //BA.debugLineNum = 86;BA.debugLine="Log(\"nombre: \" & nombre & \" numero: \" & numero &";
anywheresoftware.b4a.keywords.Common.LogImpl("72424839","nombre: "+mostCurrent._nombre+" numero: "+mostCurrent._numero+" descripcion: "+mostCurrent._descripcion+" enviar mensajes aqui: "+BA.ObjectToString(_checkbox),0);
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim ime As IME					'Creo un ime (necesita libreri";
mostCurrent._ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 16;BA.debugLine="Private etNombre As EditText";
mostCurrent._etnombre = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private etNumero As EditText";
mostCurrent._etnumero = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private smsReceiver As SmsInterceptor";
mostCurrent._smsreceiver = new anywheresoftware.b4a.phone.PhoneEvents.SMSInterceptor();
 //BA.debugLineNum = 19;BA.debugLine="Dim rp As RuntimePermissions   'requiere libreria";
mostCurrent._rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 23;BA.debugLine="Private nombre As String";
mostCurrent._nombre = "";
 //BA.debugLineNum = 24;BA.debugLine="Private numero As String";
mostCurrent._numero = "";
 //BA.debugLineNum = 25;BA.debugLine="Private descripcion As String";
mostCurrent._descripcion = "";
 //BA.debugLineNum = 26;BA.debugLine="Private checkbox As Boolean";
_checkbox = false;
 //BA.debugLineNum = 27;BA.debugLine="Private etDescrip As EditText";
mostCurrent._etdescrip = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private cbMensajes As CheckBox";
mostCurrent._cbmensajes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private urlAgregar As String";
mostCurrent._urlagregar = "";
 //BA.debugLineNum = 30;BA.debugLine="Private Agregar As HttpJob";
mostCurrent._agregar = new com.monitorflux.httpjob();
 //BA.debugLineNum = 31;BA.debugLine="Dim enviarSMS As PhoneSms";
mostCurrent._enviarsms = new anywheresoftware.b4a.phone.Phone.PhoneSms();
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(com.monitorflux.httpjob _job) throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Sub JobDone (Job As HttpJob)";
 //BA.debugLineNum = 129;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("72621441","JobName = "+_job._jobname /*String*/ +", Success = "+BA.ObjectToString(_job._success /*boolean*/ ),0);
 //BA.debugLineNum = 130;BA.debugLine="If Job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 131;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"agregar")) {
case 0: {
 //BA.debugLineNum = 133;BA.debugLine="resAgregar(Job.GetString) 'se envia la cadena";
_resagregar(_job._getstring /*String*/ ());
 break; }
}
;
 }else {
 //BA.debugLineNum = 136;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("72621448","Error: "+_job._errormessage /*String*/ ,0);
 //BA.debugLineNum = 137;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 139;BA.debugLine="Job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static void  _resagregar(String _res) throws Exception{
ResumableSub_resAgregar rsub = new ResumableSub_resAgregar(null,_res);
rsub.resume(processBA, null);
}
public static class ResumableSub_resAgregar extends BA.ResumableSub {
public ResumableSub_resAgregar(com.monitorflux.agregar_activity parent,String _res) {
this.parent = parent;
this._res = _res;
}
com.monitorflux.agregar_activity parent;
String _res;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 143;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 144;BA.debugLine="Log(res)";
anywheresoftware.b4a.keywords.Common.LogImpl("72686978",_res,0);
 //BA.debugLineNum = 145;BA.debugLine="Msgbox2Async(\"Dispositivo agregado correctamente\"";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Dispositivo agregado correctamente"),BA.ObjectToCharSequence("Listo!"),"Ok","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 146;BA.debugLine="Wait For Msgbox_Result(Result As Int) 'Queda en e";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 147;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 148;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static String  _setstatusbarcolor(int _clr) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
 //BA.debugLineNum = 96;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
 //BA.debugLineNum = 97;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 98;BA.debugLine="If p.SdkVersion >= 21 Then";
if (_p.getSdkVersion()>=21) { 
 //BA.debugLineNum = 99;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 100;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
 //BA.debugLineNum = 101;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 102;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(0x80000000)});
 //BA.debugLineNum = 103;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(0x04000000)});
 //BA.debugLineNum = 104;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
 };
 //BA.debugLineNum = 106;BA.debugLine="If p.SdkVersion >= 23 Then";
if (_p.getSdkVersion()>=23) { 
 //BA.debugLineNum = 107;BA.debugLine="jo = Activity";
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(mostCurrent._activity.getObject()));
 //BA.debugLineNum = 108;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
_jo.RunMethod("setSystemUiVisibility",new Object[]{(Object)(8192)});
 };
 //BA.debugLineNum = 110;BA.debugLine="End Sub";
return "";
}
public static boolean  _smsreceiver_messagereceived(String _from,String _body) throws Exception{
String _codigo = "";
String _datos = "";
 //BA.debugLineNum = 112;BA.debugLine="Sub smsReceiver_MessageReceived (From As String, B";
 //BA.debugLineNum = 113;BA.debugLine="If From == numero Then";
if ((_from).equals(mostCurrent._numero)) { 
 //BA.debugLineNum = 114;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 115;BA.debugLine="Dim codigo As String = Body";
_codigo = _body;
 //BA.debugLineNum = 116;BA.debugLine="smsReceiver.StopListening";
mostCurrent._smsreceiver.StopListening();
 //BA.debugLineNum = 117;BA.debugLine="Agregar.Initialize(\"agregar\",Me)";
mostCurrent._agregar._initialize /*String*/ (processBA,"agregar",agregar_activity.getObject());
 //BA.debugLineNum = 118;BA.debugLine="Dim datos As String";
_datos = "";
 //BA.debugLineNum = 120;BA.debugLine="datos = \"{\"&Chr(34)&\"descripcion\"&Chr(34)&\":\"&Ch";
_datos = "{"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"descripcion"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+mostCurrent._descripcion+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"id"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+_codigo+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"nombre"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+mostCurrent._nombre+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"numero"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+mostCurrent._numero+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"ownerId"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+mostCurrent._main._id /*String*/ +BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"}";
 //BA.debugLineNum = 121;BA.debugLine="Agregar.PostString(urlAgregar, datos)";
mostCurrent._agregar._poststring /*String*/ (mostCurrent._urlagregar,_datos);
 //BA.debugLineNum = 122;BA.debugLine="Agregar.GetRequest.SetContentType(\"application/j";
mostCurrent._agregar._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/json");
 //BA.debugLineNum = 123;BA.debugLine="ProgressDialogShow(\"Regitrando dispositivo\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Regitrando dispositivo"));
 };
 //BA.debugLineNum = 125;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return false;
}
}
