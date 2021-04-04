package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends  android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (starter) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, true, anywheresoftware.b4a.ShellBA.class);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "b4a.example", "b4a.example.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (true) {
            BA.LogInfo("** Service (starter) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (starter) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL _sql = null;
public static anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public static String _usuarioadmin = "";
public static String _claveadmin = "";
public static String _idadmin = "";
public b4a.example.main _main = null;
public b4a.example.tutoriales_activity _tutoriales_activity = null;
public b4a.example.agregar_activity _agregar_activity = null;
public b4a.example.monitor_activity _monitor_activity = null;
public b4a.example.datos_activity _datos_activity = null;
public b4a.example.registrar_activity _registrar_activity = null;
public b4a.example.httputils2service _httputils2service = null;
public b4a.example.dbutils _dbutils = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "application_error", false))
	 {return ((Boolean) Debug.delegate(processBA, "application_error", new Object[] {_error,_stacktrace}));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="End Sub";
return false;
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_create", false))
	 {return ((String) Debug.delegate(processBA, "service_create", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_destroy", false))
	 {return ((String) Debug.delegate(processBA, "service_destroy", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_start", false))
	 {return ((String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent}));}
anywheresoftware.b4a.objects.collections.Map _mapconsulta = null;
int _i = 0;
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
mostCurrent._service.StopAutomaticForeground();
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="DBUtils.CopyDBFromAssets(\"login.db\")";
mostCurrent._dbutils._copydbfromassets /*String*/ (processBA,"login.db");
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="sql.Initialize(DBUtils.GetDBFolder,\"login.db\",Fal";
_sql.Initialize(mostCurrent._dbutils._getdbfolder /*String*/ (processBA),"login.db",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="Dim mapConsulta As Map";
_mapconsulta = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="mapConsulta = DBUtils.ExecuteMap(sql,\"SELECT * FR";
_mapconsulta = mostCurrent._dbutils._executemap /*anywheresoftware.b4a.objects.collections.Map*/ (processBA,_sql,"SELECT * FROM usuarios",(String[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="For i = 0 To mapConsulta.Size-1";
{
final int step6 = 1;
final int limit6 = (int) (_mapconsulta.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="Select mapConsulta.GetKeyAt(i)";
switch (BA.switchObjectToInt(_mapconsulta.GetKeyAt(_i),(Object)("usuario"),(Object)("clave"),(Object)("Id"))) {
case 0: {
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="usuarioAdmin = mapConsulta.GetValueAt(i)";
_usuarioadmin = BA.ObjectToString(_mapconsulta.GetValueAt(_i));
 break; }
case 1: {
RDebugUtils.currentLine=458764;
 //BA.debugLineNum = 458764;BA.debugLine="claveAdmin = mapConsulta.GetValueAt(i)";
_claveadmin = BA.ObjectToString(_mapconsulta.GetValueAt(_i));
 break; }
case 2: {
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="idAdmin = mapConsulta.GetValueAt(i)";
_idadmin = BA.ObjectToString(_mapconsulta.GetValueAt(_i));
 break; }
}
;
RDebugUtils.currentLine=458768;
 //BA.debugLineNum = 458768;BA.debugLine="Log(mapConsulta.GetKeyAt(i)&\",\"&mapConsulta.GetV";
anywheresoftware.b4a.keywords.Common.LogImpl("1458768",BA.ObjectToString(_mapconsulta.GetKeyAt(_i))+","+BA.ObjectToString(_mapconsulta.GetValueAt(_i)),0);
 }
};
RDebugUtils.currentLine=458770;
 //BA.debugLineNum = 458770;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_taskremoved", false))
	 {return ((String) Debug.delegate(processBA, "service_taskremoved", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub Service_TaskRemoved";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return "";
}
}