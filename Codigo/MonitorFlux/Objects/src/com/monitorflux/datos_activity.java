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
			processBA = new BA(this.getApplicationContext(), null, null, "com.monitorflux", "com.monitorflux.datos_activity");
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
		activityBA = new BA(this, layout, processBA, "com.monitorflux", "com.monitorflux.datos_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.monitorflux.datos_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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

public anywheresoftware.b4a.keywords.Common __c = null;
public com.monitorflux.httpjob _backendelessget = null;
public com.monitorflux.httpjob _historial = null;
public com.monitorflux.httpjob _eliminar = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbnombre = null;
public static String _urlget = "";
public static String _urlhistorial = "";
public anywheresoftware.b4a.objects.LabelWrapper _lbnumero = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbdescrip = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbestado = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbflujo = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbactualizado = null;
public static String _idactual = "";
public static String _objectid = "";
public anywheresoftware.b4a.objects.PanelWrapper _panel = null;
public static String _urleliminar = "";
public anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public anywheresoftware.b4a.phone.Phone.PhoneSms _enviarsms = null;
public static String _numero = "";
public anywheresoftware.b4a.phone.PhoneEvents.SMSInterceptor _smsreceiver = null;
public com.monitorflux.httpjob _agregar = null;
public static String _urlagregar = "";
public com.monitorflux.main _main = null;
public com.monitorflux.starter _starter = null;
public com.monitorflux.tutoriales_activity _tutoriales_activity = null;
public com.monitorflux.agregar_activity _agregar_activity = null;
public com.monitorflux.monitor_activity _monitor_activity = null;
public com.monitorflux.registrar_activity _registrar_activity = null;
public com.monitorflux.httputils2service _httputils2service = null;
public com.monitorflux.dbutils _dbutils = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_click() throws Exception{
 //BA.debugLineNum = 265;BA.debugLine="Sub Activity_Click";
 //BA.debugLineNum = 266;BA.debugLine="panel.Visible = False";
mostCurrent._panel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 267;BA.debugLine="End Sub";
return "";
}
public static void  _activity_create(boolean _firsttime) throws Exception{
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(com.monitorflux.datos_activity parent,boolean _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
com.monitorflux.datos_activity parent;
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
 //BA.debugLineNum = 41;BA.debugLine="Activity.RemoveAllViews";
parent.mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 42;BA.debugLine="Activity.LoadLayout(\"Datos\")";
parent.mostCurrent._activity.LoadLayout("Datos",mostCurrent.activityBA);
 //BA.debugLineNum = 43;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
_setstatusbarcolor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (231),(int) (231),(int) (222)));
 //BA.debugLineNum = 44;BA.debugLine="urlGet = \"https://api.backendless.com/4D75900B-E5";
parent.mostCurrent._urlget = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos?where=ownerId%20%3D%20";
 //BA.debugLineNum = 45;BA.debugLine="urlHistorial = Main.urlHistorial & \"&property=flu";
parent.mostCurrent._urlhistorial = parent.mostCurrent._main._urlhistorial /*String*/ +"&property=flujo";
 //BA.debugLineNum = 46;BA.debugLine="backendelessGet.Initialize(\"get\",Me)";
parent.mostCurrent._backendelessget._initialize /*String*/ (processBA,"get",datos_activity.getObject());
 //BA.debugLineNum = 47;BA.debugLine="historial.Initialize(\"historial\",Me)";
parent.mostCurrent._historial._initialize /*String*/ (processBA,"historial",datos_activity.getObject());
 //BA.debugLineNum = 48;BA.debugLine="urlEliminar = \"https://api.backendless.com/4D7590";
parent.mostCurrent._urleliminar = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos/";
 //BA.debugLineNum = 49;BA.debugLine="urlAgregar = \"https://api.backendless.com/4D75900";
parent.mostCurrent._urlagregar = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Historial";
 //BA.debugLineNum = 50;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_RECEIVE_SMS) 'IN";
parent.mostCurrent._rp.CheckAndRequest(processBA,parent.mostCurrent._rp.PERMISSION_RECEIVE_SMS);
 //BA.debugLineNum = 51;BA.debugLine="Wait For Activity_PermissionResult(Permission As";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, this, null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 52;BA.debugLine="If Result Then";
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
 //BA.debugLineNum = 53;BA.debugLine="ToastMessageShow(\"Permiso para recibir mensaje e";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Permiso para recibir mensaje en uso"),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 57;BA.debugLine="backendelessGet.Download(urlGet & \"'\" & Main.ID &";
parent.mostCurrent._backendelessget._download /*String*/ (parent.mostCurrent._urlget+"'"+parent.mostCurrent._main._id /*String*/ +"'");
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _activity_permissionresult(String _permission,boolean _result) throws Exception{
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _btnactualizar_click() throws Exception{
String _mensaje = "";
 //BA.debugLineNum = 269;BA.debugLine="Sub btnActualizar_Click";
 //BA.debugLineNum = 270;BA.debugLine="Dim mensaje As String";
_mensaje = "";
 //BA.debugLineNum = 271;BA.debugLine="mensaje = idActual";
_mensaje = mostCurrent._idactual;
 //BA.debugLineNum = 272;BA.debugLine="enviarSMS.Send2(numero,mensaje,False,False)";
mostCurrent._enviarsms.Send2(mostCurrent._numero,_mensaje,anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 273;BA.debugLine="smsReceiver.Initialize(\"smsReceiver\")";
mostCurrent._smsreceiver.Initialize("smsReceiver",processBA);
 //BA.debugLineNum = 274;BA.debugLine="ProgressDialogShow(\"Conectando con el dispositivo";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Conectando con el dispositivo... Espere un momento"));
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return "";
}
public static String  _btnatrase_click() throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Sub btnAtrasE_Click";
 //BA.debugLineNum = 70;BA.debugLine="smsReceiver.StopListening";
mostCurrent._smsreceiver.StopListening();
 //BA.debugLineNum = 71;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public static String  _btnmas_click() throws Exception{
 //BA.debugLineNum = 250;BA.debugLine="Sub btnMas_Click";
 //BA.debugLineNum = 251;BA.debugLine="panel.Visible = Not(panel.Visible)";
mostCurrent._panel.setVisible(anywheresoftware.b4a.keywords.Common.Not(mostCurrent._panel.getVisible()));
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return "";
}
public static String  _cargardatos(String _res) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
String _nombre = "";
String _descripcion = "";
 //BA.debugLineNum = 102;BA.debugLine="Sub cargarDatos (res As String)";
 //BA.debugLineNum = 103;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 104;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
 //BA.debugLineNum = 107;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
 //BA.debugLineNum = 108;BA.debugLine="For Each colroot As Map In root				'map es simila";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group4 = _root;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group4.Get(index4)));
 //BA.debugLineNum = 109;BA.debugLine="If colroot.Get(\"nombre\") = Monitor_Activity.nomb";
if ((_colroot.Get((Object)("nombre"))).equals((Object)(mostCurrent._monitor_activity._nombred /*String*/ ))) { 
 //BA.debugLineNum = 110;BA.debugLine="Dim nombre As String = colroot.Get(\"nombre\")";
_nombre = BA.ObjectToString(_colroot.Get((Object)("nombre")));
 //BA.debugLineNum = 111;BA.debugLine="Dim descripcion As String = colroot.Get(\"descri";
_descripcion = BA.ObjectToString(_colroot.Get((Object)("descripcion")));
 //BA.debugLineNum = 112;BA.debugLine="numero = colroot.Get(\"numero\")";
mostCurrent._numero = BA.ObjectToString(_colroot.Get((Object)("numero")));
 //BA.debugLineNum = 113;BA.debugLine="idActual = colroot.Get(\"id\")";
mostCurrent._idactual = BA.ObjectToString(_colroot.Get((Object)("id")));
 //BA.debugLineNum = 114;BA.debugLine="objectId = colroot.Get(\"objectId\")";
mostCurrent._objectid = BA.ObjectToString(_colroot.Get((Object)("objectId")));
 };
 }
};
 //BA.debugLineNum = 118;BA.debugLine="lbNombre.Text = nombre";
mostCurrent._lbnombre.setText(BA.ObjectToCharSequence(_nombre));
 //BA.debugLineNum = 119;BA.debugLine="lbNumero.Text = numero";
mostCurrent._lbnumero.setText(BA.ObjectToCharSequence(mostCurrent._numero));
 //BA.debugLineNum = 120;BA.debugLine="lbDescrip.Text = descripcion";
mostCurrent._lbdescrip.setText(BA.ObjectToCharSequence(_descripcion));
 //BA.debugLineNum = 121;BA.debugLine="historial.Download(urlHistorial)";
mostCurrent._historial._download /*String*/ (mostCurrent._urlhistorial);
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public static String  _cargarestado(String _res) throws Exception{
long _fecha = 0L;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
long _fechaentra = 0L;
String _estado = "";
String _flujo = "";
 //BA.debugLineNum = 125;BA.debugLine="Sub cargarEstado (res As String)";
 //BA.debugLineNum = 126;BA.debugLine="Dim fecha As Long = 0";
_fecha = (long) (0);
 //BA.debugLineNum = 127;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 128;BA.debugLine="Log(res)";
anywheresoftware.b4a.keywords.Common.LogImpl("84063235",_res,0);
 //BA.debugLineNum = 129;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
 //BA.debugLineNum = 132;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
 //BA.debugLineNum = 133;BA.debugLine="For Each colroot As Map In root				'map es simila";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group6 = _root;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group6.Get(index6)));
 //BA.debugLineNum = 135;BA.debugLine="If colroot.Get(\"id\") = idActual Then";
if ((_colroot.Get((Object)("id"))).equals((Object)(mostCurrent._idactual))) { 
 //BA.debugLineNum = 137;BA.debugLine="Dim fechaEntra As Long = colroot.Get(\"fecha\")";
_fechaentra = BA.ObjectToLongNumber(_colroot.Get((Object)("fecha")));
 //BA.debugLineNum = 138;BA.debugLine="If fechaEntra >= fecha Then";
if (_fechaentra>=_fecha) { 
 //BA.debugLineNum = 139;BA.debugLine="Dim estado As String = colroot.Get(\"encendida\"";
_estado = BA.ObjectToString(_colroot.Get((Object)("encendida")));
 //BA.debugLineNum = 140;BA.debugLine="Dim flujo As String = colroot.Get(\"flujo\")";
_flujo = BA.ObjectToString(_colroot.Get((Object)("flujo")));
 //BA.debugLineNum = 141;BA.debugLine="Log(colroot.Get(\"flujo\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("84063248",BA.ObjectToString(_colroot.Get((Object)("flujo"))),0);
 //BA.debugLineNum = 142;BA.debugLine="fecha = fechaEntra";
_fecha = _fechaentra;
 };
 };
 }
};
 //BA.debugLineNum = 147;BA.debugLine="If estado = True Then";
if ((_estado).equals(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.True))) { 
 //BA.debugLineNum = 148;BA.debugLine="lbEstado.Text = \"Encendido\"";
mostCurrent._lbestado.setText(BA.ObjectToCharSequence("Encendido"));
 //BA.debugLineNum = 149;BA.debugLine="lbEstado.Color = Colors.ARGB(128,0,136,145)";
mostCurrent._lbestado.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (128),(int) (0),(int) (136),(int) (145)));
 }else if((_estado).equals(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False))) { 
 //BA.debugLineNum = 151;BA.debugLine="lbEstado.Text = \"Apagado\"";
mostCurrent._lbestado.setText(BA.ObjectToCharSequence("Apagado"));
 //BA.debugLineNum = 152;BA.debugLine="lbEstado.Color = Colors.ARGB(128,240,84,84)";
mostCurrent._lbestado.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (128),(int) (240),(int) (84),(int) (84)));
 };
 //BA.debugLineNum = 156;BA.debugLine="lbFlujo.Text = flujo & \" Litros/Hora\"";
mostCurrent._lbflujo.setText(BA.ObjectToCharSequence(_flujo+" Litros/Hora"));
 //BA.debugLineNum = 159;BA.debugLine="diferenciaDeFechas(fecha)";
_diferenciadefechas(_fecha);
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public static String  _diferenciadefechas(long _fecha) throws Exception{
long _fechaactual = 0L;
long _actual = 0L;
long _actualmodificado = 0L;
String _mensaje = "";
 //BA.debugLineNum = 162;BA.debugLine="Sub diferenciaDeFechas(fecha As Long){";
 //BA.debugLineNum = 164;BA.debugLine="DateTime.DateFormat = \"yyyyMMddHHmm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyyMMddHHmm");
 //BA.debugLineNum = 165;BA.debugLine="Dim fechaActual As Long = DateTime.Date(DateTime.";
_fechaactual = (long)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 //BA.debugLineNum = 166;BA.debugLine="Dim actual As Long = fechaActual - fecha";
_actual = (long) (_fechaactual-_fecha);
 //BA.debugLineNum = 167;BA.debugLine="Dim actualModificado As Long";
_actualmodificado = 0L;
 //BA.debugLineNum = 168;BA.debugLine="Dim mensaje As String";
_mensaje = "";
 //BA.debugLineNum = 170;BA.debugLine="If actual < 100 Then";
if (_actual<100) { 
 //BA.debugLineNum = 171;BA.debugLine="actualModificado = fechaActual/100";
_actualmodificado = (long) (_fechaactual/(double)100);
 //BA.debugLineNum = 172;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
_fechaactual = (long) (_fechaactual-_actualmodificado*100);
 //BA.debugLineNum = 173;BA.debugLine="actualModificado = fecha/100";
_actualmodificado = (long) (_fecha/(double)100);
 //BA.debugLineNum = 174;BA.debugLine="fecha = fecha - actualModificado*100";
_fecha = (long) (_fecha-_actualmodificado*100);
 //BA.debugLineNum = 175;BA.debugLine="If fecha <= fechaActual Then";
if (_fecha<=_fechaactual) { 
 //BA.debugLineNum = 176;BA.debugLine="actualModificado = fechaActual - fecha";
_actualmodificado = (long) (_fechaactual-_fecha);
 }else {
 //BA.debugLineNum = 178;BA.debugLine="actualModificado = fechaActual + (60 - fecha)";
_actualmodificado = (long) (_fechaactual+(60-_fecha));
 };
 //BA.debugLineNum = 181;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
_mensaje = "Actualizado hace "+BA.NumberToString(_actualmodificado)+" minutos";
 }else if(_actual<10000) { 
 //BA.debugLineNum = 184;BA.debugLine="actualModificado = fechaActual/10000";
_actualmodificado = (long) (_fechaactual/(double)10000);
 //BA.debugLineNum = 185;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
_fechaactual = (long) (_fechaactual-_actualmodificado*10000);
 //BA.debugLineNum = 186;BA.debugLine="actualModificado = fecha/10000";
_actualmodificado = (long) (_fecha/(double)10000);
 //BA.debugLineNum = 187;BA.debugLine="fecha = fecha - actualModificado*10000";
_fecha = (long) (_fecha-_actualmodificado*10000);
 //BA.debugLineNum = 188;BA.debugLine="Log(fechaActual)";
anywheresoftware.b4a.keywords.Common.LogImpl("84128794",BA.NumberToString(_fechaactual),0);
 //BA.debugLineNum = 189;BA.debugLine="Log(fecha)";
anywheresoftware.b4a.keywords.Common.LogImpl("84128795",BA.NumberToString(_fecha),0);
 //BA.debugLineNum = 190;BA.debugLine="If fecha < fechaActual Then";
if (_fecha<_fechaactual) { 
 //BA.debugLineNum = 191;BA.debugLine="actualModificado = fechaActual/100 - fecha/100";
_actualmodificado = (long) (_fechaactual/(double)100-_fecha/(double)100);
 }else {
 //BA.debugLineNum = 193;BA.debugLine="actualModificado = fechaActual/100 + (24 - fech";
_actualmodificado = (long) (_fechaactual/(double)100+(24-_fecha/(double)100));
 };
 //BA.debugLineNum = 196;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
_mensaje = "Actualizado hace "+BA.NumberToString(_actualmodificado)+" horas";
 }else if(_actual<1000000) { 
 //BA.debugLineNum = 200;BA.debugLine="actualModificado = fechaActual/1000000";
_actualmodificado = (long) (_fechaactual/(double)1000000);
 //BA.debugLineNum = 201;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
_fechaactual = (long) (_fechaactual-_actualmodificado*1000000);
 //BA.debugLineNum = 202;BA.debugLine="actualModificado = fecha/1000000";
_actualmodificado = (long) (_fecha/(double)1000000);
 //BA.debugLineNum = 203;BA.debugLine="fecha = fecha - actualModificado*1000000";
_fecha = (long) (_fecha-_actualmodificado*1000000);
 //BA.debugLineNum = 204;BA.debugLine="actualModificado = Abs(fechaActual - fecha)";
_actualmodificado = (long) (anywheresoftware.b4a.keywords.Common.Abs(_fechaactual-_fecha));
 //BA.debugLineNum = 205;BA.debugLine="If fecha < fechaActual Then";
if (_fecha<_fechaactual) { 
 //BA.debugLineNum = 206;BA.debugLine="actualModificado = fechaActual/10000 - fecha/10";
_actualmodificado = (long) (_fechaactual/(double)10000-_fecha/(double)10000);
 }else {
 //BA.debugLineNum = 208;BA.debugLine="actualModificado = fechaActual/10000 + (30 - fe";
_actualmodificado = (long) (_fechaactual/(double)10000+(30-_fecha/(double)10000));
 };
 //BA.debugLineNum = 211;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
_mensaje = "Actualizado hace "+BA.NumberToString(_actualmodificado)+" dias";
 }else if(_actual<100000000) { 
 //BA.debugLineNum = 215;BA.debugLine="actualModificado = fechaActual/100000000";
_actualmodificado = (long) (_fechaactual/(double)100000000);
 //BA.debugLineNum = 216;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
_fechaactual = (long) (_fechaactual-_actualmodificado*100000000);
 //BA.debugLineNum = 217;BA.debugLine="actualModificado = fecha/100000000";
_actualmodificado = (long) (_fecha/(double)100000000);
 //BA.debugLineNum = 218;BA.debugLine="fecha = fecha - actualModificado*100000000";
_fecha = (long) (_fecha-_actualmodificado*100000000);
 //BA.debugLineNum = 219;BA.debugLine="actualModificado = Abs(fechaActual - fecha)";
_actualmodificado = (long) (anywheresoftware.b4a.keywords.Common.Abs(_fechaactual-_fecha));
 //BA.debugLineNum = 220;BA.debugLine="If fecha < fechaActual Then";
if (_fecha<_fechaactual) { 
 //BA.debugLineNum = 221;BA.debugLine="actualModificado = fechaActual/1000000 - fecha/";
_actualmodificado = (long) (_fechaactual/(double)1000000-_fecha/(double)1000000);
 }else {
 //BA.debugLineNum = 223;BA.debugLine="actualModificado = fechaActual/1000000 + (12 -";
_actualmodificado = (long) (_fechaactual/(double)1000000+(12-_fecha/(double)1000000));
 };
 //BA.debugLineNum = 226;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
_mensaje = "Actualizado hace "+BA.NumberToString(_actualmodificado)+" meses";
 }else {
 //BA.debugLineNum = 229;BA.debugLine="mensaje = \"Desactualizado\"";
_mensaje = "Desactualizado";
 };
 //BA.debugLineNum = 231;BA.debugLine="lbActualizado.Text = mensaje";
mostCurrent._lbactualizado.setText(BA.ObjectToCharSequence(_mensaje));
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim backendelessGet As HttpJob 'se debe inicializ";
mostCurrent._backendelessget = new com.monitorflux.httpjob();
 //BA.debugLineNum = 16;BA.debugLine="Dim historial As HttpJob";
mostCurrent._historial = new com.monitorflux.httpjob();
 //BA.debugLineNum = 17;BA.debugLine="Dim eliminar As HttpJob";
mostCurrent._eliminar = new com.monitorflux.httpjob();
 //BA.debugLineNum = 18;BA.debugLine="Private lbNombre As Label";
mostCurrent._lbnombre = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private urlGet As String";
mostCurrent._urlget = "";
 //BA.debugLineNum = 20;BA.debugLine="Private urlHistorial As String";
mostCurrent._urlhistorial = "";
 //BA.debugLineNum = 21;BA.debugLine="Private lbNumero As Label";
mostCurrent._lbnumero = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private lbDescrip As Label";
mostCurrent._lbdescrip = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private lbEstado As Label";
mostCurrent._lbestado = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private lbFlujo As Label";
mostCurrent._lbflujo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private lbActualizado As Label";
mostCurrent._lbactualizado = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private idActual As String";
mostCurrent._idactual = "";
 //BA.debugLineNum = 27;BA.debugLine="Private objectId As String";
mostCurrent._objectid = "";
 //BA.debugLineNum = 28;BA.debugLine="Private panel As Panel";
mostCurrent._panel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private urlEliminar As String";
mostCurrent._urleliminar = "";
 //BA.debugLineNum = 30;BA.debugLine="Dim rp As RuntimePermissions   'requiere libreria";
mostCurrent._rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 31;BA.debugLine="Dim enviarSMS As PhoneSms";
mostCurrent._enviarsms = new anywheresoftware.b4a.phone.Phone.PhoneSms();
 //BA.debugLineNum = 32;BA.debugLine="Private numero As String";
mostCurrent._numero = "";
 //BA.debugLineNum = 33;BA.debugLine="Private smsReceiver As SmsInterceptor";
mostCurrent._smsreceiver = new anywheresoftware.b4a.phone.PhoneEvents.SMSInterceptor();
 //BA.debugLineNum = 34;BA.debugLine="Private Agregar As HttpJob";
mostCurrent._agregar = new com.monitorflux.httpjob();
 //BA.debugLineNum = 35;BA.debugLine="Private urlAgregar As String";
mostCurrent._urlagregar = "";
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public static void  _jobdone(com.monitorflux.httpjob _job) throws Exception{
ResumableSub_JobDone rsub = new ResumableSub_JobDone(null,_job);
rsub.resume(processBA, null);
}
public static class ResumableSub_JobDone extends BA.ResumableSub {
public ResumableSub_JobDone(com.monitorflux.datos_activity parent,com.monitorflux.httpjob _job) {
this.parent = parent;
this._job = _job;
}
com.monitorflux.datos_activity parent;
com.monitorflux.httpjob _job;
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
 //BA.debugLineNum = 76;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("83932161","JobName = "+_job._jobname /*String*/ +", Success = "+BA.ObjectToString(_job._success /*boolean*/ ),0);
 //BA.debugLineNum = 77;BA.debugLine="If Job.Success = True Then";
if (true) break;

case 1:
//if
this.state = 20;
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 3;
}else {
this.state = 19;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 78;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
if (true) break;

case 4:
//select
this.state = 17;
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"get","historial","eliminar","agregar")) {
case 0: {
this.state = 6;
if (true) break;
}
case 1: {
this.state = 8;
if (true) break;
}
case 2: {
this.state = 10;
if (true) break;
}
case 3: {
this.state = 16;
if (true) break;
}
}
if (true) break;

case 6:
//C
this.state = 17;
 //BA.debugLineNum = 80;BA.debugLine="cargarDatos(Job.GetString) 'se envia la cadena";
_cargardatos(_job._getstring /*String*/ ());
 if (true) break;

case 8:
//C
this.state = 17;
 //BA.debugLineNum = 82;BA.debugLine="cargarEstado(Job.GetString)";
_cargarestado(_job._getstring /*String*/ ());
 if (true) break;

case 10:
//C
this.state = 11;
 //BA.debugLineNum = 85;BA.debugLine="Msgbox2Async(\"Dispositivo eliminado correctame";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Dispositivo eliminado correctamente"),BA.ObjectToCharSequence("Listo!"),"Ok","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 86;BA.debugLine="Wait For Msgbox_Result(Result As Int) 'Queda e";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 21;
return;
case 21:
//C
this.state = 11;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 87;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 11:
//if
this.state = 14;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 88;BA.debugLine="Monitor_Activity.eliminado = True";
parent.mostCurrent._monitor_activity._eliminado /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 89;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 if (true) break;

case 14:
//C
this.state = 17;
;
 if (true) break;

case 16:
//C
this.state = 17;
 //BA.debugLineNum = 92;BA.debugLine="resAgregar(Job.GetString)";
_resagregar(_job._getstring /*String*/ ());
 if (true) break;

case 17:
//C
this.state = 20;
;
 if (true) break;

case 19:
//C
this.state = 20;
 //BA.debugLineNum = 95;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("83932180","Error: "+_job._errormessage /*String*/ ,0);
 //BA.debugLineNum = 96;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 20:
//C
this.state = -1;
;
 //BA.debugLineNum = 98;BA.debugLine="Job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static String  _lbeliminar_click() throws Exception{
 //BA.debugLineNum = 259;BA.debugLine="Sub lbEliminar_Click";
 //BA.debugLineNum = 260;BA.debugLine="eliminar.Initialize(\"eliminar\",Me)";
mostCurrent._eliminar._initialize /*String*/ (processBA,"eliminar",datos_activity.getObject());
 //BA.debugLineNum = 261;BA.debugLine="Log(\"Eliminar\")";
anywheresoftware.b4a.keywords.Common.LogImpl("84390914","Eliminar",0);
 //BA.debugLineNum = 262;BA.debugLine="eliminar.Delete(urlEliminar & objectId)";
mostCurrent._eliminar._delete /*String*/ (mostCurrent._urleliminar+mostCurrent._objectid);
 //BA.debugLineNum = 263;BA.debugLine="End Sub";
return "";
}
public static String  _lbhistorial_click() throws Exception{
 //BA.debugLineNum = 255;BA.debugLine="Sub lbHistorial_Click";
 //BA.debugLineNum = 256;BA.debugLine="Log(\"historial\")";
anywheresoftware.b4a.keywords.Common.LogImpl("84325377","historial",0);
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
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
public ResumableSub_resAgregar(com.monitorflux.datos_activity parent,String _res) {
this.parent = parent;
this._res = _res;
}
com.monitorflux.datos_activity parent;
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
 //BA.debugLineNum = 303;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 304;BA.debugLine="Log(res)";
anywheresoftware.b4a.keywords.Common.LogImpl("84653058",_res,0);
 //BA.debugLineNum = 305;BA.debugLine="Msgbox2Async(\"Dato adquirido correctamente\",\"List";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Dato adquirido correctamente"),BA.ObjectToCharSequence("Listo!"),"Ok","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 306;BA.debugLine="Wait For Msgbox_Result(Result As Int) 'Queda en e";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 307;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
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
 //BA.debugLineNum = 308;BA.debugLine="historial.Download(urlHistorial)";
parent.mostCurrent._historial._download /*String*/ (parent.mostCurrent._urlhistorial);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 310;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _setstatusbarcolor(int _clr) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
 //BA.debugLineNum = 234;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
 //BA.debugLineNum = 235;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 236;BA.debugLine="If p.SdkVersion >= 21 Then";
if (_p.getSdkVersion()>=21) { 
 //BA.debugLineNum = 237;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 238;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
 //BA.debugLineNum = 239;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 240;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(0x80000000)});
 //BA.debugLineNum = 241;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(0x04000000)});
 //BA.debugLineNum = 242;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
 };
 //BA.debugLineNum = 244;BA.debugLine="If p.SdkVersion >= 23 Then";
if (_p.getSdkVersion()>=23) { 
 //BA.debugLineNum = 245;BA.debugLine="jo = Activity";
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(mostCurrent._activity.getObject()));
 //BA.debugLineNum = 246;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
_jo.RunMethod("setSystemUiVisibility",new Object[]{(Object)(8192)});
 };
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return "";
}
public static boolean  _smsreceiver_messagereceived(String _from,String _body) throws Exception{
String _flujo = "";
boolean _encendida = false;
long _fecha = 0L;
String _datos = "";
 //BA.debugLineNum = 278;BA.debugLine="Sub smsReceiver_MessageReceived (From As String, B";
 //BA.debugLineNum = 279;BA.debugLine="If From == numero Then";
if ((_from).equals(mostCurrent._numero)) { 
 //BA.debugLineNum = 280;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 281;BA.debugLine="MsgboxAsync(\"Nuevo dato: \" & Body & \" Litros/Hor";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Nuevo dato: "+_body+" Litros/Hora"),BA.ObjectToCharSequence("Dato recibido"),processBA);
 //BA.debugLineNum = 282;BA.debugLine="Dim flujo As String = Body";
_flujo = _body;
 //BA.debugLineNum = 283;BA.debugLine="Dim encendida As Boolean";
_encendida = false;
 //BA.debugLineNum = 284;BA.debugLine="encendida = False";
_encendida = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 285;BA.debugLine="If flujo > 3 Then";
if ((double)(Double.parseDouble(_flujo))>3) { 
 //BA.debugLineNum = 286;BA.debugLine="encendida = True";
_encendida = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 288;BA.debugLine="smsReceiver.StopListening";
mostCurrent._smsreceiver.StopListening();
 //BA.debugLineNum = 289;BA.debugLine="DateTime.DateFormat = \"yyyyMMddHHmm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyyMMddHHmm");
 //BA.debugLineNum = 290;BA.debugLine="Dim fecha As Long = DateTime.Date(DateTime.Now)";
_fecha = (long)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 //BA.debugLineNum = 292;BA.debugLine="Agregar.Initialize(\"agregar\",Me)";
mostCurrent._agregar._initialize /*String*/ (processBA,"agregar",datos_activity.getObject());
 //BA.debugLineNum = 293;BA.debugLine="Dim datos As String";
_datos = "";
 //BA.debugLineNum = 294;BA.debugLine="datos = \"{\"&Chr(34)&\"encendida\"&Chr(34)&\":\"&ence";
_datos = "{"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"encendida"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(_encendida)+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"id"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+mostCurrent._idactual+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"flujo"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+_flujo+","+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"fecha"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+":"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+BA.NumberToString(_fecha)+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34)))+"}";
 //BA.debugLineNum = 295;BA.debugLine="Agregar.PostString(urlAgregar, datos)";
mostCurrent._agregar._poststring /*String*/ (mostCurrent._urlagregar,_datos);
 //BA.debugLineNum = 296;BA.debugLine="Agregar.GetRequest.SetContentType(\"application/j";
mostCurrent._agregar._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/json");
 //BA.debugLineNum = 297;BA.debugLine="ProgressDialogShow(\"Regitrando dispositivo\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Regitrando dispositivo"));
 };
 //BA.debugLineNum = 299;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 300;BA.debugLine="End Sub";
return false;
}
}
