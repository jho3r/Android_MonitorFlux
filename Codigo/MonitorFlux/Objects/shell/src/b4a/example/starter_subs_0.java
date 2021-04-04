package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (starter) ","starter",1,starter.processBA,starter.mostCurrent,47);
if (RapidSub.canDelegate("application_error")) { return b4a.example.starter.remoteMe.runUserSub(false, "starter","application_error", _error, _stacktrace);}
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 47;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="Return True";
Debug.ShouldStop(32768);
if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Public sql As SQL";
starter._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="Public rp As RuntimePermissions";
starter._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 11;BA.debugLine="Public usuarioAdmin As String";
starter._usuarioadmin = RemoteObject.createImmutable("");
 //BA.debugLineNum = 12;BA.debugLine="Public claveAdmin As String";
starter._claveadmin = RemoteObject.createImmutable("");
 //BA.debugLineNum = 13;BA.debugLine="Public idAdmin As String";
starter._idadmin = RemoteObject.createImmutable("");
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (starter) ","starter",1,starter.processBA,starter.mostCurrent,16);
if (RapidSub.canDelegate("service_create")) { return b4a.example.starter.remoteMe.runUserSub(false, "starter","service_create");}
 BA.debugLineNum = 16;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(32768);
 BA.debugLineNum = 20;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",1,starter.processBA,starter.mostCurrent,51);
if (RapidSub.canDelegate("service_destroy")) { return b4a.example.starter.remoteMe.runUserSub(false, "starter","service_destroy");}
 BA.debugLineNum = 51;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(262144);
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (starter) ","starter",1,starter.processBA,starter.mostCurrent,22);
if (RapidSub.canDelegate("service_start")) { return b4a.example.starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);}
RemoteObject _mapconsulta = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 22;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
Debug.ShouldStop(4194304);
starter.mostCurrent._service.runVoidMethod ("StopAutomaticForeground");
 BA.debugLineNum = 24;BA.debugLine="DBUtils.CopyDBFromAssets(\"login.db\")";
Debug.ShouldStop(8388608);
starter.mostCurrent._dbutils.runVoidMethod ("_copydbfromassets" /*RemoteObject*/ ,starter.processBA,(Object)(RemoteObject.createImmutable("login.db")));
 BA.debugLineNum = 25;BA.debugLine="sql.Initialize(DBUtils.GetDBFolder,\"login.db\",Fal";
Debug.ShouldStop(16777216);
starter._sql.runVoidMethod ("Initialize",(Object)(starter.mostCurrent._dbutils.runMethod(true,"_getdbfolder" /*RemoteObject*/ ,starter.processBA)),(Object)(BA.ObjectToString("login.db")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 27;BA.debugLine="Dim mapConsulta As Map";
Debug.ShouldStop(67108864);
_mapconsulta = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("mapConsulta", _mapconsulta);
 BA.debugLineNum = 28;BA.debugLine="mapConsulta = DBUtils.ExecuteMap(sql,\"SELECT * FR";
Debug.ShouldStop(134217728);
_mapconsulta = starter.mostCurrent._dbutils.runMethod(false,"_executemap" /*RemoteObject*/ ,starter.processBA,(Object)(starter._sql),(Object)(BA.ObjectToString("SELECT * FROM usuarios")),(Object)((starter.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("mapConsulta", _mapconsulta);
 BA.debugLineNum = 29;BA.debugLine="For i = 0 To mapConsulta.Size-1";
Debug.ShouldStop(268435456);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {_mapconsulta.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 30;BA.debugLine="Select mapConsulta.GetKeyAt(i)";
Debug.ShouldStop(536870912);
switch (BA.switchObjectToInt(_mapconsulta.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))),RemoteObject.createImmutable(("usuario")),RemoteObject.createImmutable(("clave")),RemoteObject.createImmutable(("Id")))) {
case 0: {
 BA.debugLineNum = 32;BA.debugLine="usuarioAdmin = mapConsulta.GetValueAt(i)";
Debug.ShouldStop(-2147483648);
starter._usuarioadmin = BA.ObjectToString(_mapconsulta.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));
 break; }
case 1: {
 BA.debugLineNum = 34;BA.debugLine="claveAdmin = mapConsulta.GetValueAt(i)";
Debug.ShouldStop(2);
starter._claveadmin = BA.ObjectToString(_mapconsulta.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));
 break; }
case 2: {
 BA.debugLineNum = 36;BA.debugLine="idAdmin = mapConsulta.GetValueAt(i)";
Debug.ShouldStop(8);
starter._idadmin = BA.ObjectToString(_mapconsulta.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));
 break; }
}
;
 BA.debugLineNum = 38;BA.debugLine="Log(mapConsulta.GetKeyAt(i)&\",\"&mapConsulta.GetV";
Debug.ShouldStop(32);
starter.mostCurrent.__c.runVoidMethod ("LogImpl","1458768",RemoteObject.concat(_mapconsulta.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))),RemoteObject.createImmutable(","),_mapconsulta.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i)))),0);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_taskremoved() throws Exception{
try {
		Debug.PushSubsStack("Service_TaskRemoved (starter) ","starter",1,starter.processBA,starter.mostCurrent,42);
if (RapidSub.canDelegate("service_taskremoved")) { return b4a.example.starter.remoteMe.runUserSub(false, "starter","service_taskremoved");}
 BA.debugLineNum = 42;BA.debugLine="Sub Service_TaskRemoved";
Debug.ShouldStop(512);
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}