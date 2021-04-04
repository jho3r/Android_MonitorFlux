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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (tutoriales_activity.mostCurrent != null);
vis = vis | (agregar_activity.mostCurrent != null);
vis = vis | (monitor_activity.mostCurrent != null);
vis = vis | (datos_activity.mostCurrent != null);
vis = vis | (registrar_activity.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
 {
            Activity __a = null;
            if (tutoriales_activity.previousOne != null) {
				__a = tutoriales_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(tutoriales_activity.mostCurrent == null ? null : tutoriales_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (agregar_activity.previousOne != null) {
				__a = agregar_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(agregar_activity.mostCurrent == null ? null : agregar_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (monitor_activity.previousOne != null) {
				__a = monitor_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(monitor_activity.mostCurrent == null ? null : monitor_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (datos_activity.previousOne != null) {
				__a = datos_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(datos_activity.mostCurrent == null ? null : datos_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (registrar_activity.previousOne != null) {
				__a = registrar_activity.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(registrar_activity.mostCurrent == null ? null : registrar_activity.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, httputils2service.class));
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
public b4a.example.httpjob _backendelessget = null;
public static int _i = 0;
public static int _disfallando = 0;
public b4a.example.httpjob _historial = null;
public b4a.example.starter _starter = null;
public b4a.example.tutoriales_activity _tutoriales_activity = null;
public b4a.example.agregar_activity _agregar_activity = null;
public b4a.example.monitor_activity _monitor_activity = null;
public b4a.example.datos_activity _datos_activity = null;
public b4a.example.registrar_activity _registrar_activity = null;
public b4a.example.httputils2service _httputils2service = null;
public b4a.example.dbutils _dbutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="If FirstTime=True Then";
if (_firsttime==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Activity.LoadLayout(\"Intro\")			'cargamos el layo";
mostCurrent._activity.LoadLayout("Intro",mostCurrent.activityBA);
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="tmrIntro.Initialize(\"tmrIntro\",3000)	'inicializa";
_tmrintro.Initialize(processBA,"tmrIntro",(long) (3000));
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="tmrIntro.Enabled = True					'Se ejecuta en tmrIn";
_tmrintro.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="inicio = False";
_inicio = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="Activity.LoadLayout(\"Principal\")";
mostCurrent._activity.LoadLayout("Principal",mostCurrent.activityBA);
 };
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
_setstatusbarcolor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (231),(int) (231),(int) (222)));
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="urlHistorial = \"https://api.backendless.com/4D759";
_urlhistorial = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Historial?pageSize=100&property=fecha&property=id&property=encendida&where=id%3D'000000'";
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="urlGet = \"https://api.backendless.com/4D75900B-E5";
mostCurrent._urlget = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos?where=ownerId%20%3D%20";
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="backendelessGet.Initialize(\"get\",Me)";
mostCurrent._backendelessget._initialize /*String*/ (null,processBA,"get",main.getObject());
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="list.Initialize";
_list.Initialize();
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="End Sub";
return "";
}
public static String  _setstatusbarcolor(int _clr) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "setstatusbarcolor", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "setstatusbarcolor", new Object[] {_clr}));}
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="If p.SdkVersion >= 21 Then";
if (_p.getSdkVersion()>=21) { 
RDebugUtils.currentLine=4259843;
 //BA.debugLineNum = 4259843;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
RDebugUtils.currentLine=4259845;
 //BA.debugLineNum = 4259845;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=4259846;
 //BA.debugLineNum = 4259846;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(0x80000000)});
RDebugUtils.currentLine=4259847;
 //BA.debugLineNum = 4259847;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(0x04000000)});
RDebugUtils.currentLine=4259848;
 //BA.debugLineNum = 4259848;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
 };
RDebugUtils.currentLine=4259850;
 //BA.debugLineNum = 4259850;BA.debugLine="If p.SdkVersion >= 23 Then";
if (_p.getSdkVersion()>=23) { 
RDebugUtils.currentLine=4259851;
 //BA.debugLineNum = 4259851;BA.debugLine="jo = Activity";
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(mostCurrent._activity.getObject()));
RDebugUtils.currentLine=4259852;
 //BA.debugLineNum = 4259852;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
_jo.RunMethod("setSystemUiVisibility",new Object[]{(Object)(8192)});
 };
RDebugUtils.currentLine=4259854;
 //BA.debugLineNum = 4259854;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="If tmrIntro.Enabled = False Then";
if (_tmrintro.getEnabled()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="intentoInicio";
_intentoinicio();
 };
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="End Sub";
return "";
}
public static String  _intentoinicio() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "intentoinicio", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "intentoinicio", null));}
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub intentoInicio";
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="If inicio == False Then";
if (_inicio==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="StartActivity(Registrar_Activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._registrar_activity.getObject()));
 }else {
RDebugUtils.currentLine=4521990;
 //BA.debugLineNum = 4521990;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=4521991;
 //BA.debugLineNum = 4521991;BA.debugLine="Activity.LoadLayout(\"Principal\")		'cargamos la p";
mostCurrent._activity.LoadLayout("Principal",mostCurrent.activityBA);
RDebugUtils.currentLine=4521992;
 //BA.debugLineNum = 4521992;BA.debugLine="backendelessGet.Download(urlGet & \"'\" & ID & \"'\"";
mostCurrent._backendelessget._download /*String*/ (null,mostCurrent._urlget+"'"+_id+"'");
 };
RDebugUtils.currentLine=4521996;
 //BA.debugLineNum = 4521996;BA.debugLine="End Sub";
return "";
}
public static String  _btnagregar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnagregar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnagregar_click", null));}
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub btnAgregar_Click";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="StartActivity(Agregar_Activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._agregar_activity.getObject()));
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="End Sub";
return "";
}
public static String  _btnmonitoreo_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmonitoreo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmonitoreo_click", null));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub btnMonitoreo_Click";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="StartActivity(Monitor_Activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._monitor_activity.getObject()));
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="End Sub";
return "";
}
public static String  _btntutorial_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btntutorial_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btntutorial_click", null));}
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub btnTutorial_Click";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="StartActivity(Tutoriales_Activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tutoriales_activity.getObject()));
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="End Sub";
return "";
}
public static String  _conteo(String _res) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "conteo", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "conteo", new Object[] {_res}));}
String _historialmas = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
String _nombre = "";
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub conteo(res As String)";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="i=0";
_i = (int) (0);
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="Dim historialmas As String = \"\"";
_historialmas = "";
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="list.Clear";
_list.Clear();
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
RDebugUtils.currentLine=4390919;
 //BA.debugLineNum = 4390919;BA.debugLine="For Each colroot As Map In root				'map es simila";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group7 = _root;
final int groupLen7 = group7.getSize()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group7.Get(index7)));
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="Dim nombre As String = colroot.Get(\"id\")";
_nombre = BA.ObjectToString(_colroot.Get((Object)("id")));
RDebugUtils.currentLine=4390921;
 //BA.debugLineNum = 4390921;BA.debugLine="list.Add(nombre)";
_list.Add((Object)(_nombre));
RDebugUtils.currentLine=4390922;
 //BA.debugLineNum = 4390922;BA.debugLine="i = i + 1";
_i = (int) (_i+1);
RDebugUtils.currentLine=4390923;
 //BA.debugLineNum = 4390923;BA.debugLine="historialmas = historialmas & \"%20or%20id%3D'\"&n";
_historialmas = _historialmas+"%20or%20id%3D'"+_nombre+"'";
 }
};
RDebugUtils.currentLine=4390925;
 //BA.debugLineNum = 4390925;BA.debugLine="lbBombas.Text = i & \" Dispositivos\"";
mostCurrent._lbbombas.setText(BA.ObjectToCharSequence(BA.NumberToString(_i)+" Dispositivos"));
RDebugUtils.currentLine=4390926;
 //BA.debugLineNum = 4390926;BA.debugLine="historial.Initialize(\"historial\",Me)";
mostCurrent._historial._initialize /*String*/ (null,processBA,"historial",main.getObject());
RDebugUtils.currentLine=4390927;
 //BA.debugLineNum = 4390927;BA.debugLine="urlHistorial = urlHistorial & historialmas";
_urlhistorial = _urlhistorial+_historialmas;
RDebugUtils.currentLine=4390928;
 //BA.debugLineNum = 4390928;BA.debugLine="historial.Download(urlHistorial)";
mostCurrent._historial._download /*String*/ (null,_urlhistorial);
RDebugUtils.currentLine=4390929;
 //BA.debugLineNum = 4390929;BA.debugLine="End Sub";
return "";
}
public static String  _fallando(String _res) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fallando", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fallando", new Object[] {_res}));}
long _fecha = 0L;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
int _a = 0;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
long _fechaentra = 0L;
boolean _estado = false;
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub fallando(res As String)";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="disFallando = 0";
_disfallando = (int) (0);
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="Dim fecha As Long = 0";
_fecha = (long) (0);
RDebugUtils.currentLine=4456451;
 //BA.debugLineNum = 4456451;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=4456452;
 //BA.debugLineNum = 4456452;BA.debugLine="For a=0 To list.Size -1";
{
final int step4 = 1;
final int limit4 = (int) (_list.getSize()-1);
_a = (int) (0) ;
for (;_a <= limit4 ;_a = _a + step4 ) {
RDebugUtils.currentLine=4456453;
 //BA.debugLineNum = 4456453;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=4456454;
 //BA.debugLineNum = 4456454;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
RDebugUtils.currentLine=4456455;
 //BA.debugLineNum = 4456455;BA.debugLine="For Each colroot As Map In root				'map es simil";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group7 = _root;
final int groupLen7 = group7.getSize()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group7.Get(index7)));
RDebugUtils.currentLine=4456457;
 //BA.debugLineNum = 4456457;BA.debugLine="If colroot.Get(\"id\") = list.Get(a) Then";
if ((_colroot.Get((Object)("id"))).equals(_list.Get(_a))) { 
RDebugUtils.currentLine=4456458;
 //BA.debugLineNum = 4456458;BA.debugLine="Log(list.Get(a))";
anywheresoftware.b4a.keywords.Common.LogImpl("14456458",BA.ObjectToString(_list.Get(_a)),0);
RDebugUtils.currentLine=4456460;
 //BA.debugLineNum = 4456460;BA.debugLine="Dim fechaEntra As Long = colroot.Get(\"fecha\")";
_fechaentra = BA.ObjectToLongNumber(_colroot.Get((Object)("fecha")));
RDebugUtils.currentLine=4456461;
 //BA.debugLineNum = 4456461;BA.debugLine="If fechaEntra >= fecha Then";
if (_fechaentra>=_fecha) { 
RDebugUtils.currentLine=4456462;
 //BA.debugLineNum = 4456462;BA.debugLine="Dim estado As Boolean = colroot.Get(\"encendid";
_estado = BA.ObjectToBoolean(_colroot.Get((Object)("encendida")));
RDebugUtils.currentLine=4456463;
 //BA.debugLineNum = 4456463;BA.debugLine="fecha = fechaEntra";
_fecha = _fechaentra;
 };
 };
 }
};
RDebugUtils.currentLine=4456467;
 //BA.debugLineNum = 4456467;BA.debugLine="If estado = False Then";
if (_estado==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=4456468;
 //BA.debugLineNum = 4456468;BA.debugLine="disFallando = disFallando + 1";
_disfallando = (int) (_disfallando+1);
RDebugUtils.currentLine=4456469;
 //BA.debugLineNum = 4456469;BA.debugLine="Log(disFallando)";
anywheresoftware.b4a.keywords.Common.LogImpl("14456469",BA.NumberToString(_disfallando),0);
 };
RDebugUtils.currentLine=4456471;
 //BA.debugLineNum = 4456471;BA.debugLine="fecha = 0";
_fecha = (long) (0);
 }
};
RDebugUtils.currentLine=4456474;
 //BA.debugLineNum = 4456474;BA.debugLine="lbFallas.Text = disFallando & \" Fallando\"";
mostCurrent._lbfallas.setText(BA.ObjectToCharSequence(BA.NumberToString(_disfallando)+" Fallando"));
RDebugUtils.currentLine=4456475;
 //BA.debugLineNum = 4456475;BA.debugLine="If disFallando > 0 Then";
if (_disfallando>0) { 
RDebugUtils.currentLine=4456476;
 //BA.debugLineNum = 4456476;BA.debugLine="lbFallas.Color = Colors.ARGB(255,240,84,84)";
mostCurrent._lbfallas.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (240),(int) (84),(int) (84)));
 }else {
RDebugUtils.currentLine=4456478;
 //BA.debugLineNum = 4456478;BA.debugLine="lbFallas.Color = Colors.ARGB(128,0,136,145)";
mostCurrent._lbfallas.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (128),(int) (0),(int) (136),(int) (145)));
 };
RDebugUtils.currentLine=4456480;
 //BA.debugLineNum = 4456480;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub JobDone (Job As HttpJob)";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("14325377","JobName = "+_job._jobname /*String*/ +", Success = "+BA.ObjectToString(_job._success /*boolean*/ ),0);
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="If Job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"get","historial")) {
case 0: {
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="conteo(Job.GetString) 'se envia la cadena reci";
_conteo(_job._getstring /*String*/ (null));
 break; }
case 1: {
RDebugUtils.currentLine=4325383;
 //BA.debugLineNum = 4325383;BA.debugLine="Log(Job.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("14325383",_job._getstring /*String*/ (null),0);
RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="fallando(Job.GetString)";
_fallando(_job._getstring /*String*/ (null));
 break; }
}
;
 }else {
RDebugUtils.currentLine=4325387;
 //BA.debugLineNum = 4325387;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("14325387","Error: "+_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=4325388;
 //BA.debugLineNum = 4325388;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4325390;
 //BA.debugLineNum = 4325390;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=4325391;
 //BA.debugLineNum = 4325391;BA.debugLine="End Sub";
return "";
}
public static String  _tmrintro_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tmrintro_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tmrintro_tick", null));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub tmrIntro_Tick";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="tmrIntro.Enabled = False";
_tmrintro.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="intentoInicio";
_intentoinicio();
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="End Sub";
return "";
}
}