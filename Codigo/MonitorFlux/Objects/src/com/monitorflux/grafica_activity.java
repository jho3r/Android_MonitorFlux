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

public class grafica_activity extends Activity implements B4AActivity{
	public static grafica_activity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.monitorflux", "com.monitorflux.grafica_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (grafica_activity).");
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
		activityBA = new BA(this, layout, processBA, "com.monitorflux", "com.monitorflux.grafica_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.monitorflux.grafica_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (grafica_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (grafica_activity) Resume **");
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
		return grafica_activity.class;
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
            BA.LogInfo("** Activity (grafica_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (grafica_activity) Pause event (activity is not paused). **");
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
            grafica_activity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (grafica_activity) Resume **");
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
public androidplotwrapper.lineChartWrapper _rtchart = null;
public anywheresoftware.b4a.phone.Phone _ph = null;
public com.monitorflux.httpjob _historial = null;
public static String _urlhistorial = "";
public static int _mes = 0;
public static int _flujo = 0;
public static long[] _arrn = null;
public static long[] _arrmes = null;
public static float[] _arrgrafica1 = null;
public com.monitorflux.main _main = null;
public com.monitorflux.starter _starter = null;
public com.monitorflux.tutoriales_activity _tutoriales_activity = null;
public com.monitorflux.agregar_activity _agregar_activity = null;
public com.monitorflux.monitor_activity _monitor_activity = null;
public com.monitorflux.datos_activity _datos_activity = null;
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
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 26;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 29;BA.debugLine="SetStatusBarColor(Colors.Black)";
_setstatusbarcolor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 30;BA.debugLine="ph.SetScreenOrientation(-1)";
mostCurrent._ph.SetScreenOrientation(processBA,(int) (-1));
 //BA.debugLineNum = 31;BA.debugLine="historial.Initialize(\"historial\",Me)";
mostCurrent._historial._initialize /*String*/ (processBA,"historial",grafica_activity.getObject());
 //BA.debugLineNum = 32;BA.debugLine="urlHistorial = \"https://api.backendless.com/4D759";
mostCurrent._urlhistorial = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Historial?where=id%3D'"+mostCurrent._datos_activity._idactual /*String*/ +"'&property=fecha&property=mes&property=flujo";
 //BA.debugLineNum = 33;BA.debugLine="historial.Download(urlHistorial)";
mostCurrent._historial._download /*String*/ (mostCurrent._urlhistorial);
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _analizardatos(String _res) throws Exception{
long _fechaactual = 0L;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
boolean _si = false;
int _j = 0;
 //BA.debugLineNum = 141;BA.debugLine="Sub analizarDatos (res As String)";
 //BA.debugLineNum = 142;BA.debugLine="arrMes = Array As Long (0,0,0,0,0,0,0,0,0,0,0,0)";
_arrmes = new long[]{(long) (0),(long) (0),(long) (0),(long) (0),(long) (0),(long) (0),(long) (0),(long) (0),(long) (0),(long) (0),(long) (0),(long) (0)};
 //BA.debugLineNum = 143;BA.debugLine="arrN = Array As Long (0,0,0,0,0,0,0,0,0,0,0,0)";
_arrn = new long[]{(long) (0),(long) (0),(long) (0),(long) (0),(long) (0),(long) (0),(long) (0),(long) (0),(long) (0),(long) (0),(long) (0),(long) (0)};
 //BA.debugLineNum = 144;BA.debugLine="arrGrafica1 = Array As Float (0,0,0,0,0,0,0,0,0,0";
_arrgrafica1 = new float[]{(float) (0),(float) (0),(float) (0),(float) (0),(float) (0),(float) (0),(float) (0),(float) (0),(float) (0),(float) (0),(float) (0),(float) (0)};
 //BA.debugLineNum = 146;BA.debugLine="DateTime.DateFormat = \"yyyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyy");
 //BA.debugLineNum = 147;BA.debugLine="Dim fechaActual As Long = DateTime.Date(DateTime.";
_fechaactual = (long)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 //BA.debugLineNum = 148;BA.debugLine="fechaActual = fechaActual*100000000";
_fechaactual = (long) (_fechaactual*100000000);
 //BA.debugLineNum = 149;BA.debugLine="Log(\"\" & fechaActual & arrMes.Length)";
anywheresoftware.b4a.keywords.Common.LogImpl("56160392",""+BA.NumberToString(_fechaactual)+BA.NumberToString(_arrmes.length),0);
 //BA.debugLineNum = 151;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 152;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
 //BA.debugLineNum = 155;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
 //BA.debugLineNum = 156;BA.debugLine="For Each colroot As Map In root				'map es simila";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group11 = _root;
final int groupLen11 = group11.getSize()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_colroot = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(group11.Get(index11)));
 //BA.debugLineNum = 157;BA.debugLine="If colroot.Get(\"fecha\") >= fechaActual Then";
if ((double)(BA.ObjectToNumber(_colroot.Get((Object)("fecha"))))>=_fechaactual) { 
 //BA.debugLineNum = 158;BA.debugLine="mes = colroot.Get(\"mes\")";
_mes = (int)(BA.ObjectToNumber(_colroot.Get((Object)("mes"))));
 //BA.debugLineNum = 159;BA.debugLine="flujo = colroot.Get(\"flujo\")";
_flujo = (int)(BA.ObjectToNumber(_colroot.Get((Object)("flujo"))));
 //BA.debugLineNum = 160;BA.debugLine="arrMes(mes-1) = arrMes(mes-1) + flujo";
_arrmes[(int) (_mes-1)] = (long) (_arrmes[(int) (_mes-1)]+_flujo);
 //BA.debugLineNum = 161;BA.debugLine="arrN(mes-1) = arrN(mes-1) + 1";
_arrn[(int) (_mes-1)] = (long) (_arrn[(int) (_mes-1)]+1);
 };
 }
};
 //BA.debugLineNum = 164;BA.debugLine="Dim si As Boolean";
_si = false;
 //BA.debugLineNum = 165;BA.debugLine="si=False";
_si = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 166;BA.debugLine="For j=0 To 11";
{
final int step21 = 1;
final int limit21 = (int) (11);
_j = (int) (0) ;
for (;_j <= limit21 ;_j = _j + step21 ) {
 //BA.debugLineNum = 167;BA.debugLine="If arrMes(j) <> 0 Then";
if (_arrmes[_j]!=0) { 
 //BA.debugLineNum = 168;BA.debugLine="arrGrafica1(j) = arrMes(j)/arrN(j)";
_arrgrafica1[_j] = (float) (_arrmes[_j]/(double)_arrn[_j]);
 };
 //BA.debugLineNum = 170;BA.debugLine="si= True";
_si = anywheresoftware.b4a.keywords.Common.True;
 }
};
 //BA.debugLineNum = 173;BA.debugLine="If si = True Then";
if (_si==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 174;BA.debugLine="graficarLuminosidad";
_graficarluminosidad();
 };
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private rtChart As LineChart";
mostCurrent._rtchart = new androidplotwrapper.lineChartWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Dim ph As Phone";
mostCurrent._ph = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 17;BA.debugLine="Dim historial As HttpJob";
mostCurrent._historial = new com.monitorflux.httpjob();
 //BA.debugLineNum = 18;BA.debugLine="Dim urlHistorial As String";
mostCurrent._urlhistorial = "";
 //BA.debugLineNum = 19;BA.debugLine="Private mes As Int";
_mes = 0;
 //BA.debugLineNum = 20;BA.debugLine="Private flujo As Int";
_flujo = 0;
 //BA.debugLineNum = 21;BA.debugLine="Private arrN() As Long";
_arrn = new long[(int) (0)];
;
 //BA.debugLineNum = 22;BA.debugLine="Private arrMes() As Long";
_arrmes = new long[(int) (0)];
;
 //BA.debugLineNum = 23;BA.debugLine="Private arrGrafica1() As Float";
_arrgrafica1 = new float[(int) (0)];
;
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public static String  _graficarluminosidad() throws Exception{
 //BA.debugLineNum = 44;BA.debugLine="Sub graficarLuminosidad";
 //BA.debugLineNum = 45;BA.debugLine="Activity.LoadLayout(\"Graficas\")";
mostCurrent._activity.LoadLayout("Graficas",mostCurrent.activityBA);
 //BA.debugLineNum = 46;BA.debugLine="rtChart.GraphPinchZoomable = True              's";
mostCurrent._rtchart.setGraphPinchZoomable(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 47;BA.debugLine="rtChart.GraphBackgroundColor = Colors.Black";
mostCurrent._rtchart.setGraphBackgroundColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 48;BA.debugLine="rtChart.GraphFrameColor = Colors.Black";
mostCurrent._rtchart.setGraphFrameColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 49;BA.debugLine="rtChart.GraphFrameWidth = 0.0";
mostCurrent._rtchart.setGraphFrameWidth((float) (0.0));
 //BA.debugLineNum = 50;BA.debugLine="rtChart.GraphPlotAreaBackgroundColor = Colors.RGB";
mostCurrent._rtchart.setGraphPlotAreaBackgroundColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0x22),(int) (0x28),(int) (0x31)));
 //BA.debugLineNum = 51;BA.debugLine="rtChart.GraphTitleTextSize = 15";
mostCurrent._rtchart.setGraphTitleTextSize((int) (15));
 //BA.debugLineNum = 52;BA.debugLine="rtChart.GraphTitleColor = Colors.White";
mostCurrent._rtchart.setGraphTitleColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 53;BA.debugLine="rtChart.GraphTitleSkewX = -0.25";
mostCurrent._rtchart.setGraphTitleSkewX((float) (-0.25));
 //BA.debugLineNum = 54;BA.debugLine="rtChart.GraphTitleUnderline = False";
mostCurrent._rtchart.setGraphTitleUnderline(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 55;BA.debugLine="rtChart.GraphTitleBold = True";
mostCurrent._rtchart.setGraphTitleBold(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 56;BA.debugLine="rtChart.GraphTitle = \"PROMEDIO MENSUAL\"";
mostCurrent._rtchart.setGraphTitle("PROMEDIO MENSUAL");
 //BA.debugLineNum = 58;BA.debugLine="rtChart.LegendBackgroundColor = Colors.Black";
mostCurrent._rtchart.setLegendBackgroundColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 59;BA.debugLine="rtChart.LegendTextColor = Colors.Black";
mostCurrent._rtchart.setLegendTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 60;BA.debugLine="rtChart.LegendTextSize = 0.0";
mostCurrent._rtchart.setLegendTextSize((float) (0.0));
 //BA.debugLineNum = 62;BA.debugLine="rtChart.DomianLabel = \"\"";
mostCurrent._rtchart.setDomianLabel("");
 //BA.debugLineNum = 63;BA.debugLine="rtChart.DomainLabelColor = Colors.Black";
mostCurrent._rtchart.setDomainLabelColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 64;BA.debugLine="rtChart.DomainLabelTextSize = 0.0";
mostCurrent._rtchart.setDomainLabelTextSize((float) (0.0));
 //BA.debugLineNum = 66;BA.debugLine="rtChart.XaxisGridLineColor = Colors.ARGB(100,0xdd";
mostCurrent._rtchart.setXaxisGridLineColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100),(int) (0xdd),(int) (0xdd),(int) (0xdd)));
 //BA.debugLineNum = 67;BA.debugLine="rtChart.XaxisGridLineWidth = 2.0";
mostCurrent._rtchart.setXaxisGridLineWidth((float) (2.0));
 //BA.debugLineNum = 68;BA.debugLine="rtChart.XaxisLabelTicks = 1";
mostCurrent._rtchart.setXaxisLabelTicks((int) (1));
 //BA.debugLineNum = 69;BA.debugLine="rtChart.XaxisLabelOrientation = 0";
mostCurrent._rtchart.setXaxisLabelOrientation((float) (0));
 //BA.debugLineNum = 70;BA.debugLine="rtChart.XaxisLabelTextColor = Colors.RGB(0xdd,0xd";
mostCurrent._rtchart.setXaxisLabelTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0xdd),(int) (0xdd),(int) (0xdd)));
 //BA.debugLineNum = 71;BA.debugLine="rtChart.XaxisLabelTextSize = 30.0";
mostCurrent._rtchart.setXaxisLabelTextSize((float) (30.0));
 //BA.debugLineNum = 72;BA.debugLine="rtChart.XAxisLabels = Array As String(\"Jan\",\"Feb\"";
mostCurrent._rtchart.setXAxisLabels(new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"});
 //BA.debugLineNum = 74;BA.debugLine="rtChart.YaxisDivisions = 9";
mostCurrent._rtchart.setYaxisDivisions((int) (9));
 //BA.debugLineNum = 75;BA.debugLine="rtChart.YaxisShowZero = False";
mostCurrent._rtchart.setYaxisShowZero(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 76;BA.debugLine="rtChart.YaxisRange(-4, 32)";
mostCurrent._rtchart.YaxisRange((float) (-4),(float) (32));
 //BA.debugLineNum = 77;BA.debugLine="rtChart.YaxisValueFormat = rtChart.ValueFormat_0";
mostCurrent._rtchart.setYaxisValueFormat(mostCurrent._rtchart.ValueFormat_0);
 //BA.debugLineNum = 78;BA.debugLine="rtChart.YaxisGridLineColor = Colors.ARGB(100,0xdd";
mostCurrent._rtchart.setYaxisGridLineColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100),(int) (0xdd),(int) (0xdd),(int) (0xdd)));
 //BA.debugLineNum = 79;BA.debugLine="rtChart.YaxisGridLineWidth = 2";
mostCurrent._rtchart.setYaxisGridLineWidth((float) (2));
 //BA.debugLineNum = 80;BA.debugLine="rtChart.YaxisLabelTicks = 1";
mostCurrent._rtchart.setYaxisLabelTicks((int) (1));
 //BA.debugLineNum = 81;BA.debugLine="rtChart.YaxisLabelColor = Colors.RGB(0xdd,0xdd,0x";
mostCurrent._rtchart.setYaxisLabelColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0xdd),(int) (0xdd),(int) (0xdd)));
 //BA.debugLineNum = 82;BA.debugLine="rtChart.YaxisLabelOrientation = 0";
mostCurrent._rtchart.setYaxisLabelOrientation((float) (0));
 //BA.debugLineNum = 83;BA.debugLine="rtChart.YaxisLabelTextSize = 30.0";
mostCurrent._rtchart.setYaxisLabelTextSize((float) (30.0));
 //BA.debugLineNum = 84;BA.debugLine="rtChart.YaxisTitleColor = Colors.RGB(0xdd,0xdd,0x";
mostCurrent._rtchart.setYaxisTitleColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0xdd),(int) (0xdd),(int) (0xdd)));
 //BA.debugLineNum = 85;BA.debugLine="rtChart.YaxisTitleFakeBold = False";
mostCurrent._rtchart.setYaxisTitleFakeBold(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 86;BA.debugLine="rtChart.YaxisTitleTextSize = 40.0";
mostCurrent._rtchart.setYaxisTitleTextSize((float) (40.0));
 //BA.debugLineNum = 87;BA.debugLine="rtChart.YaxisTitleUnderline = False";
mostCurrent._rtchart.setYaxisTitleUnderline(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 88;BA.debugLine="rtChart.YaxisTitleTextSkewness = 0";
mostCurrent._rtchart.setYaxisTitleTextSkewness((float) (0));
 //BA.debugLineNum = 89;BA.debugLine="rtChart.YaxisLabelAndTitleDistance = 60.0";
mostCurrent._rtchart.setYaxisLabelAndTitleDistance((float) (60.0));
 //BA.debugLineNum = 90;BA.debugLine="rtChart.YaxisTitle = \"Litros/Minuto\"";
mostCurrent._rtchart.setYaxisTitle("Litros/Minuto");
 //BA.debugLineNum = 92;BA.debugLine="rtChart.MaxNumberOfEntriesPerLineChart = 12";
mostCurrent._rtchart.setMaxNumberOfEntriesPerLineChart((int) (12));
 //BA.debugLineNum = 94;BA.debugLine="rtChart.Line_1_LegendText = \"\"";
mostCurrent._rtchart.setLine_1_LegendText("");
 //BA.debugLineNum = 95;BA.debugLine="rtChart.Line_1_Data = arrGrafica1 'Array As Float";
mostCurrent._rtchart.setLine_1_Data(_arrgrafica1);
 //BA.debugLineNum = 96;BA.debugLine="rtChart.Line_1_PointLabelTextColor = Colors.RGB(0";
mostCurrent._rtchart.setLine_1_PointLabelTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0xdd),(int) (0xdd),(int) (0xdd)));
 //BA.debugLineNum = 97;BA.debugLine="rtChart.Line_1_PointLabelTextSize = 20.0";
mostCurrent._rtchart.setLine_1_PointLabelTextSize((float) (20.0));
 //BA.debugLineNum = 98;BA.debugLine="rtChart.Line_1_LineColor = Colors.RGB(0xf0,0x54,0";
mostCurrent._rtchart.setLine_1_LineColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0xf0),(int) (0x54),(int) (0x54)));
 //BA.debugLineNum = 99;BA.debugLine="rtChart.Line_1_LineWidth = 4.0";
mostCurrent._rtchart.setLine_1_LineWidth((float) (4.0));
 //BA.debugLineNum = 100;BA.debugLine="rtChart.Line_1_PointColor = Colors.RGB(0xdd,0xdd,";
mostCurrent._rtchart.setLine_1_PointColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0xdd),(int) (0xdd),(int) (0xdd)));
 //BA.debugLineNum = 101;BA.debugLine="rtChart.Line_1_PointSize = 20.0";
mostCurrent._rtchart.setLine_1_PointSize((float) (20.0));
 //BA.debugLineNum = 102;BA.debugLine="rtChart.Line_1_PointShape = rtChart.SHAPE_ROUND";
mostCurrent._rtchart.setLine_1_PointShape(mostCurrent._rtchart.SHAPE_ROUND);
 //BA.debugLineNum = 103;BA.debugLine="rtChart.Line_1_DrawDash = True";
mostCurrent._rtchart.setLine_1_DrawDash(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 104;BA.debugLine="rtChart.Line_1_DrawCubic = True";
mostCurrent._rtchart.setLine_1_DrawCubic(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 107;BA.debugLine="rtChart.NumberOfLineCharts = 1";
mostCurrent._rtchart.setNumberOfLineCharts((int) (1));
 //BA.debugLineNum = 109;BA.debugLine="rtChart.DrawTheGraphs";
mostCurrent._rtchart.DrawTheGraphs();
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(com.monitorflux.httpjob _job) throws Exception{
 //BA.debugLineNum = 126;BA.debugLine="Sub JobDone (Job As HttpJob)";
 //BA.debugLineNum = 127;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("56094849","JobName = "+_job._jobname /*String*/ +", Success = "+BA.ObjectToString(_job._success /*boolean*/ ),0);
 //BA.debugLineNum = 128;BA.debugLine="If Job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 129;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"historial")) {
case 0: {
 //BA.debugLineNum = 131;BA.debugLine="Log(Job.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("56094853",_job._getstring /*String*/ (),0);
 //BA.debugLineNum = 132;BA.debugLine="analizarDatos(Job.GetString)";
_analizardatos(_job._getstring /*String*/ ());
 break; }
}
;
 }else {
 //BA.debugLineNum = 135;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("56094857","Error: "+_job._errormessage /*String*/ ,0);
 //BA.debugLineNum = 136;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 138;BA.debugLine="Job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _setstatusbarcolor(int _clr) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
 //BA.debugLineNum = 114;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
 //BA.debugLineNum = 115;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 116;BA.debugLine="If p.SdkVersion >= 21 Then";
if (_p.getSdkVersion()>=21) { 
 //BA.debugLineNum = 117;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 118;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
 //BA.debugLineNum = 119;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 120;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(0x80000000)});
 //BA.debugLineNum = 121;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(0x04000000)});
 //BA.debugLineNum = 122;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
 };
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
}
