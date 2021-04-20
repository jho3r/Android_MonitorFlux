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
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "com.monitorflux", "com.monitorflux.starter");
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
	}
public anywheresoftware.b4a.keywords.Common __c = null;
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
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "actualizarcampos", false))
	 {return ((String) Debug.delegate(processBA, "actualizarcampos", new Object[] {_campoup,_parametroup,_campowhere,_parametrowhere}));}
anywheresoftware.b4a.objects.collections.Map _mapactualizar = null;
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub actualizarCampos(campoUp As String,parametroUp";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Dim mapActualizar As Map";
_mapactualizar = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="mapActualizar.Initialize";
_mapactualizar.Initialize();
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="mapActualizar.Put(campowhere,parametrowhere)";
_mapactualizar.Put((Object)(_campowhere),(Object)(_parametrowhere));
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="DBUtils.UpdateRecord(sql,\"login\",campoUp,parametr";
mostCurrent._dbutils._updaterecord /*String*/ (processBA,_sql,"login",_campoup,(Object)(_parametroup),_mapactualizar);
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="End Sub";
return "";
}
public static boolean  _checkmantener() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "checkmantener", false))
	 {return ((Boolean) Debug.delegate(processBA, "checkmantener", null));}
anywheresoftware.b4a.objects.collections.Map _mapconsulta = null;
int _i = 0;
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub checkMantener As Boolean";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="Dim mapConsulta As Map";
_mapconsulta = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="mapConsulta.Initialize";
_mapconsulta.Initialize();
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="mapConsulta = DBUtils.ExecuteMap(sql,\"SELECT * FR";
_mapconsulta = mostCurrent._dbutils._executemap /*anywheresoftware.b4a.objects.collections.Map*/ (processBA,_sql,"SELECT * FROM login",(String[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="For i = 0 To mapConsulta.Size-1";
{
final int step4 = 1;
final int limit4 = (int) (_mapconsulta.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="Select mapConsulta.GetKeyAt(i)";
switch (BA.switchObjectToInt(_mapconsulta.GetKeyAt(_i),(Object)("usuario"),(Object)("clave"),(Object)("mantener"))) {
case 0: {
RDebugUtils.currentLine=1441800;
 //BA.debugLineNum = 1441800;BA.debugLine="usuario = mapConsulta.GetValueAt(i)";
_usuario = BA.ObjectToString(_mapconsulta.GetValueAt(_i));
 break; }
case 1: {
RDebugUtils.currentLine=1441802;
 //BA.debugLineNum = 1441802;BA.debugLine="clave = mapConsulta.GetValueAt(i)";
_clave = BA.ObjectToString(_mapconsulta.GetValueAt(_i));
 break; }
case 2: {
RDebugUtils.currentLine=1441804;
 //BA.debugLineNum = 1441804;BA.debugLine="mantener = mapConsulta.GetValueAt(i)";
_mantener = BA.ObjectToString(_mapconsulta.GetValueAt(_i));
 break; }
}
;
RDebugUtils.currentLine=1441806;
 //BA.debugLineNum = 1441806;BA.debugLine="Log(mapConsulta.GetKeyAt(i)&\",\"&mapConsulta.GetV";
anywheresoftware.b4a.keywords.Common.LogImpl("11441806",BA.ObjectToString(_mapconsulta.GetKeyAt(_i))+","+BA.ObjectToString(_mapconsulta.GetValueAt(_i)),0);
 }
};
RDebugUtils.currentLine=1441809;
 //BA.debugLineNum = 1441809;BA.debugLine="If mantener = \"1\" Then";
if ((_mantener).equals("1")) { 
RDebugUtils.currentLine=1441810;
 //BA.debugLineNum = 1441810;BA.debugLine="Log(\"Mantener igual a 1 intentando incio de sesi";
anywheresoftware.b4a.keywords.Common.LogImpl("11441810","Mantener igual a 1 intentando incio de sesion",0);
RDebugUtils.currentLine=1441811;
 //BA.debugLineNum = 1441811;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=1441813;
 //BA.debugLineNum = 1441813;BA.debugLine="Log(\"No se tiene mantener = 1, pasando a ventana";
anywheresoftware.b4a.keywords.Common.LogImpl("11441813","No se tiene mantener = 1, pasando a ventana de iniciar sesion",0);
RDebugUtils.currentLine=1441814;
 //BA.debugLineNum = 1441814;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=1441816;
 //BA.debugLineNum = 1441816;BA.debugLine="End Sub";
return false;
}
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "application_error", false))
	 {return ((Boolean) Debug.delegate(processBA, "application_error", new Object[] {_error,_stacktrace}));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="End Sub";
return false;
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_create", false))
	 {return ((String) Debug.delegate(processBA, "service_create", null));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_destroy", false))
	 {return ((String) Debug.delegate(processBA, "service_destroy", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_start", false))
	 {return ((String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent}));}
anywheresoftware.b4a.objects.collections.Map _mapconsulta = null;
int _i = 0;
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
mostCurrent._service.StopAutomaticForeground();
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="DBUtils.CopyDBFromAssets(\"monitor.db\")";
mostCurrent._dbutils._copydbfromassets /*String*/ (processBA,"monitor.db");
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="sql.Initialize(DBUtils.GetDBFolder,\"monitor.db\",F";
_sql.Initialize(mostCurrent._dbutils._getdbfolder /*String*/ (processBA),"monitor.db",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="Dim mapConsulta As Map";
_mapconsulta = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="mapConsulta = DBUtils.ExecuteMap(sql,\"SELECT * FR";
_mapconsulta = mostCurrent._dbutils._executemap /*anywheresoftware.b4a.objects.collections.Map*/ (processBA,_sql,"SELECT * FROM admin",(String[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="For i = 0 To mapConsulta.Size - 1";
{
final int step6 = 1;
final int limit6 = (int) (_mapconsulta.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=1179657;
 //BA.debugLineNum = 1179657;BA.debugLine="Select mapConsulta.GetKeyAt(i)";
switch (BA.switchObjectToInt(_mapconsulta.GetKeyAt(_i),(Object)("usuario"),(Object)("clave"))) {
case 0: {
RDebugUtils.currentLine=1179659;
 //BA.debugLineNum = 1179659;BA.debugLine="usuarioAdmin = mapConsulta.GetValueAt(i)";
_usuarioadmin = BA.ObjectToString(_mapconsulta.GetValueAt(_i));
 break; }
case 1: {
RDebugUtils.currentLine=1179661;
 //BA.debugLineNum = 1179661;BA.debugLine="claveAdmin = mapConsulta.GetValueAt(i)";
_claveadmin = BA.ObjectToString(_mapconsulta.GetValueAt(_i));
 break; }
}
;
RDebugUtils.currentLine=1179663;
 //BA.debugLineNum = 1179663;BA.debugLine="Log(mapConsulta.GetKeyAt(i)&\",\"&mapConsulta.GetV";
anywheresoftware.b4a.keywords.Common.LogImpl("11179663",BA.ObjectToString(_mapconsulta.GetKeyAt(_i))+","+BA.ObjectToString(_mapconsulta.GetValueAt(_i)),0);
 }
};
RDebugUtils.currentLine=1179665;
 //BA.debugLineNum = 1179665;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_taskremoved", false))
	 {return ((String) Debug.delegate(processBA, "service_taskremoved", null));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub Service_TaskRemoved";
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="End Sub";
return "";
}
}