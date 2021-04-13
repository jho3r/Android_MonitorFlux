package com.monitorflux;


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
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, true, BA.class);
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
		    processBA = new BA(this, null, null, "com.monitorflux", "com.monitorflux.starter");
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
			processBA.raiseEvent2(null, true, "CREATE", true, "com.monitorflux.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
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
	}public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL _sql = null;
public static anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public static String _usuarioadmin = "";
public static String _claveadmin = "";
public static String _usuario = "";
public static String _clave = "";
public static String _mantener = "";
public com.monitorflux.main _main = null;
public com.monitorflux.tutoriales_activity _tutoriales_activity = null;
public com.monitorflux.agregar_activity _agregar_activity = null;
public com.monitorflux.monitor_activity _monitor_activity = null;
public com.monitorflux.datos_activity _datos_activity = null;
public com.monitorflux.registrar_activity _registrar_activity = null;
public com.monitorflux.httputils2service _httputils2service = null;
public com.monitorflux.dbutils _dbutils = null;
public static String  _actualizarcampos(String _campoup,String _parametroup,String _campowhere,String _parametrowhere) throws Exception{
anywheresoftware.b4a.objects.collections.Map _mapactualizar = null;
 //BA.debugLineNum = 84;BA.debugLine="Sub actualizarCampos(campoUp As String,parametroUp";
 //BA.debugLineNum = 85;BA.debugLine="Dim mapActualizar As Map";
_mapactualizar = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 86;BA.debugLine="mapActualizar.Initialize";
_mapactualizar.Initialize();
 //BA.debugLineNum = 87;BA.debugLine="mapActualizar.Put(campowhere,parametrowhere)";
_mapactualizar.Put((Object)(_campowhere),(Object)(_parametrowhere));
 //BA.debugLineNum = 88;BA.debugLine="DBUtils.UpdateRecord(sql,\"login\",campoUp,parametr";
mostCurrent._dbutils._updaterecord /*String*/ (processBA,_sql,"login",_campoup,(Object)(_parametroup),_mapactualizar);
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 51;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return false;
}
public static boolean  _checkmantener() throws Exception{
anywheresoftware.b4a.objects.collections.Map _mapconsulta = null;
int _i = 0;
 //BA.debugLineNum = 58;BA.debugLine="Sub checkMantener As Boolean";
 //BA.debugLineNum = 59;BA.debugLine="Dim mapConsulta As Map";
_mapconsulta = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 60;BA.debugLine="mapConsulta.Initialize";
_mapconsulta.Initialize();
 //BA.debugLineNum = 61;BA.debugLine="mapConsulta = DBUtils.ExecuteMap(sql,\"SELECT * FR";
_mapconsulta = mostCurrent._dbutils._executemap /*anywheresoftware.b4a.objects.collections.Map*/ (processBA,_sql,"SELECT * FROM login",(String[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 63;BA.debugLine="For i = 0 To mapConsulta.Size-1";
{
final int step4 = 1;
final int limit4 = (int) (_mapconsulta.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 64;BA.debugLine="Select mapConsulta.GetKeyAt(i)";
switch (BA.switchObjectToInt(_mapconsulta.GetKeyAt(_i),(Object)("usuario"),(Object)("clave"),(Object)("mantener"))) {
case 0: {
 //BA.debugLineNum = 66;BA.debugLine="usuario = mapConsulta.GetValueAt(i)";
_usuario = BA.ObjectToString(_mapconsulta.GetValueAt(_i));
 break; }
case 1: {
 //BA.debugLineNum = 68;BA.debugLine="clave = mapConsulta.GetValueAt(i)";
_clave = BA.ObjectToString(_mapconsulta.GetValueAt(_i));
 break; }
case 2: {
 //BA.debugLineNum = 70;BA.debugLine="mantener = mapConsulta.GetValueAt(i)";
_mantener = BA.ObjectToString(_mapconsulta.GetValueAt(_i));
 break; }
}
;
 //BA.debugLineNum = 72;BA.debugLine="Log(mapConsulta.GetKeyAt(i)&\",\"&mapConsulta.GetV";
anywheresoftware.b4a.keywords.Common.LogImpl("21441806",BA.ObjectToString(_mapconsulta.GetKeyAt(_i))+","+BA.ObjectToString(_mapconsulta.GetValueAt(_i)),0);
 }
};
 //BA.debugLineNum = 75;BA.debugLine="If mantener = \"1\" Then";
if ((_mantener).equals("1")) { 
 //BA.debugLineNum = 76;BA.debugLine="Log(\"Mantener igual a 1 intentando incio de sesi";
anywheresoftware.b4a.keywords.Common.LogImpl("21441810","Mantener igual a 1 intentando incio de sesion",0);
 //BA.debugLineNum = 77;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 79;BA.debugLine="Log(\"No se tiene mantener = 1, pasando a ventana";
anywheresoftware.b4a.keywords.Common.LogImpl("21441813","No se tiene mantener = 1, pasando a ventana de iniciar sesion",0);
 //BA.debugLineNum = 80;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return false;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Public sql As SQL";
_sql = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 10;BA.debugLine="Public rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 11;BA.debugLine="Public usuarioAdmin As String";
_usuarioadmin = "";
 //BA.debugLineNum = 12;BA.debugLine="Public claveAdmin As String";
_claveadmin = "";
 //BA.debugLineNum = 13;BA.debugLine="Public usuario As String";
_usuario = "";
 //BA.debugLineNum = 14;BA.debugLine="Public clave As String";
_clave = "";
 //BA.debugLineNum = 15;BA.debugLine="Public mantener As String";
_mantener = "";
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
anywheresoftware.b4a.objects.collections.Map _mapconsulta = null;
int _i = 0;
 //BA.debugLineNum = 26;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 27;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
mostCurrent._service.StopAutomaticForeground();
 //BA.debugLineNum = 28;BA.debugLine="DBUtils.CopyDBFromAssets(\"monitor.db\")";
mostCurrent._dbutils._copydbfromassets /*String*/ (processBA,"monitor.db");
 //BA.debugLineNum = 29;BA.debugLine="sql.Initialize(DBUtils.GetDBFolder,\"monitor.db\",F";
_sql.Initialize(mostCurrent._dbutils._getdbfolder /*String*/ (processBA),"monitor.db",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 31;BA.debugLine="Dim mapConsulta As Map";
_mapconsulta = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 32;BA.debugLine="mapConsulta = DBUtils.ExecuteMap(sql,\"SELECT * FR";
_mapconsulta = mostCurrent._dbutils._executemap /*anywheresoftware.b4a.objects.collections.Map*/ (processBA,_sql,"SELECT * FROM admin",(String[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 34;BA.debugLine="For i = 0 To mapConsulta.Size - 1";
{
final int step6 = 1;
final int limit6 = (int) (_mapconsulta.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 35;BA.debugLine="Select mapConsulta.GetKeyAt(i)";
switch (BA.switchObjectToInt(_mapconsulta.GetKeyAt(_i),(Object)("usuario"),(Object)("clave"))) {
case 0: {
 //BA.debugLineNum = 37;BA.debugLine="usuarioAdmin = mapConsulta.GetValueAt(i)";
_usuarioadmin = BA.ObjectToString(_mapconsulta.GetValueAt(_i));
 break; }
case 1: {
 //BA.debugLineNum = 39;BA.debugLine="claveAdmin = mapConsulta.GetValueAt(i)";
_claveadmin = BA.ObjectToString(_mapconsulta.GetValueAt(_i));
 break; }
}
;
 //BA.debugLineNum = 41;BA.debugLine="Log(mapConsulta.GetKeyAt(i)&\",\"&mapConsulta.GetV";
anywheresoftware.b4a.keywords.Common.LogImpl("21179663",BA.ObjectToString(_mapconsulta.GetKeyAt(_i))+","+BA.ObjectToString(_mapconsulta.GetValueAt(_i)),0);
 }
};
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
 //BA.debugLineNum = 45;BA.debugLine="Sub Service_TaskRemoved";
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
}
