package com.monitorflux;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_0 {


public static RemoteObject  _actualizarcampos(RemoteObject _campoup,RemoteObject _parametroup,RemoteObject _campowhere,RemoteObject _parametrowhere) throws Exception{
try {
		Debug.PushSubsStack("actualizarCampos (starter) ","starter",1,starter.processBA,starter.mostCurrent,84);
if (RapidSub.canDelegate("actualizarcampos")) { return com.monitorflux.starter.remoteMe.runUserSub(false, "starter","actualizarcampos", _campoup, _parametroup, _campowhere, _parametrowhere);}
RemoteObject _mapactualizar = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("campoUp", _campoup);
Debug.locals.put("parametroUp", _parametroup);
Debug.locals.put("campowhere", _campowhere);
Debug.locals.put("parametrowhere", _parametrowhere);
 BA.debugLineNum = 84;BA.debugLine="Sub actualizarCampos(campoUp As String,parametroUp";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="Dim mapActualizar As Map";
Debug.ShouldStop(1048576);
_mapactualizar = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("mapActualizar", _mapactualizar);
 BA.debugLineNum = 86;BA.debugLine="mapActualizar.Initialize";
Debug.ShouldStop(2097152);
_mapactualizar.runVoidMethod ("Initialize");
 BA.debugLineNum = 87;BA.debugLine="mapActualizar.Put(campowhere,parametrowhere)";
Debug.ShouldStop(4194304);
_mapactualizar.runVoidMethod ("Put",(Object)((_campowhere)),(Object)((_parametrowhere)));
 BA.debugLineNum = 88;BA.debugLine="DBUtils.UpdateRecord(sql,\"login\",campoUp,parametr";
Debug.ShouldStop(8388608);
starter.mostCurrent._dbutils.runVoidMethod ("_updaterecord" /*RemoteObject*/ ,starter.processBA,(Object)(starter._sql),(Object)(BA.ObjectToString("login")),(Object)(_campoup),(Object)((_parametroup)),(Object)(_mapactualizar));
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (starter) ","starter",1,starter.processBA,starter.mostCurrent,50);
if (RapidSub.canDelegate("application_error")) { return com.monitorflux.starter.remoteMe.runUserSub(false, "starter","application_error", _error, _stacktrace);}
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 50;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="Return True";
Debug.ShouldStop(262144);
if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _checkmantener() throws Exception{
try {
		Debug.PushSubsStack("checkMantener (starter) ","starter",1,starter.processBA,starter.mostCurrent,58);
if (RapidSub.canDelegate("checkmantener")) { return com.monitorflux.starter.remoteMe.runUserSub(false, "starter","checkmantener");}
RemoteObject _mapconsulta = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
 BA.debugLineNum = 58;BA.debugLine="Sub checkMantener As Boolean";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="Dim mapConsulta As Map";
Debug.ShouldStop(67108864);
_mapconsulta = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("mapConsulta", _mapconsulta);
 BA.debugLineNum = 60;BA.debugLine="mapConsulta.Initialize";
Debug.ShouldStop(134217728);
_mapconsulta.runVoidMethod ("Initialize");
 BA.debugLineNum = 61;BA.debugLine="mapConsulta = DBUtils.ExecuteMap(sql,\"SELECT * FR";
Debug.ShouldStop(268435456);
_mapconsulta = starter.mostCurrent._dbutils.runMethod(false,"_executemap" /*RemoteObject*/ ,starter.processBA,(Object)(starter._sql),(Object)(BA.ObjectToString("SELECT * FROM login")),(Object)((starter.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("mapConsulta", _mapconsulta);
 BA.debugLineNum = 63;BA.debugLine="For i = 0 To mapConsulta.Size-1";
Debug.ShouldStop(1073741824);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {_mapconsulta.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 64;BA.debugLine="Select mapConsulta.GetKeyAt(i)";
Debug.ShouldStop(-2147483648);
switch (BA.switchObjectToInt(_mapconsulta.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))),RemoteObject.createImmutable(("usuario")),RemoteObject.createImmutable(("clave")),RemoteObject.createImmutable(("mantener")))) {
case 0: {
 BA.debugLineNum = 66;BA.debugLine="usuario = mapConsulta.GetValueAt(i)";
Debug.ShouldStop(2);
starter._usuario = BA.ObjectToString(_mapconsulta.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));
 break; }
case 1: {
 BA.debugLineNum = 68;BA.debugLine="clave = mapConsulta.GetValueAt(i)";
Debug.ShouldStop(8);
starter._clave = BA.ObjectToString(_mapconsulta.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));
 break; }
case 2: {
 BA.debugLineNum = 70;BA.debugLine="mantener = mapConsulta.GetValueAt(i)";
Debug.ShouldStop(32);
starter._mantener = BA.ObjectToString(_mapconsulta.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));
 break; }
}
;
 BA.debugLineNum = 72;BA.debugLine="Log(mapConsulta.GetKeyAt(i)&\",\"&mapConsulta.GetV";
Debug.ShouldStop(128);
starter.mostCurrent.__c.runVoidMethod ("LogImpl","11441806",RemoteObject.concat(_mapconsulta.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))),RemoteObject.createImmutable(","),_mapconsulta.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i)))),0);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 75;BA.debugLine="If mantener = \"1\" Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",starter._mantener,BA.ObjectToString("1"))) { 
 BA.debugLineNum = 76;BA.debugLine="Log(\"Mantener igual a 1 intentando incio de sesi";
Debug.ShouldStop(2048);
starter.mostCurrent.__c.runVoidMethod ("LogImpl","11441810",RemoteObject.createImmutable("Mantener igual a 1 intentando incio de sesion"),0);
 BA.debugLineNum = 77;BA.debugLine="Return True";
Debug.ShouldStop(4096);
if (true) return starter.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 79;BA.debugLine="Log(\"No se tiene mantener = 1, pasando a ventana";
Debug.ShouldStop(16384);
starter.mostCurrent.__c.runVoidMethod ("LogImpl","11441813",RemoteObject.createImmutable("No se tiene mantener = 1, pasando a ventana de iniciar sesion"),0);
 BA.debugLineNum = 80;BA.debugLine="Return False";
Debug.ShouldStop(32768);
if (true) return starter.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
 //BA.debugLineNum = 13;BA.debugLine="Public usuario As String";
starter._usuario = RemoteObject.createImmutable("");
 //BA.debugLineNum = 14;BA.debugLine="Public clave As String";
starter._clave = RemoteObject.createImmutable("");
 //BA.debugLineNum = 15;BA.debugLine="Public mantener As String";
starter._mantener = RemoteObject.createImmutable("");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (starter) ","starter",1,starter.processBA,starter.mostCurrent,20);
if (RapidSub.canDelegate("service_create")) { return com.monitorflux.starter.remoteMe.runUserSub(false, "starter","service_create");}
 BA.debugLineNum = 20;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(524288);
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",1,starter.processBA,starter.mostCurrent,54);
if (RapidSub.canDelegate("service_destroy")) { return com.monitorflux.starter.remoteMe.runUserSub(false, "starter","service_destroy");}
 BA.debugLineNum = 54;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Service_Start (starter) ","starter",1,starter.processBA,starter.mostCurrent,26);
if (RapidSub.canDelegate("service_start")) { return com.monitorflux.starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);}
RemoteObject _mapconsulta = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 26;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
Debug.ShouldStop(67108864);
starter.mostCurrent._service.runVoidMethod ("StopAutomaticForeground");
 BA.debugLineNum = 28;BA.debugLine="DBUtils.CopyDBFromAssets(\"monitor.db\")";
Debug.ShouldStop(134217728);
starter.mostCurrent._dbutils.runVoidMethod ("_copydbfromassets" /*RemoteObject*/ ,starter.processBA,(Object)(RemoteObject.createImmutable("monitor.db")));
 BA.debugLineNum = 29;BA.debugLine="sql.Initialize(DBUtils.GetDBFolder,\"monitor.db\",F";
Debug.ShouldStop(268435456);
starter._sql.runVoidMethod ("Initialize",(Object)(starter.mostCurrent._dbutils.runMethod(true,"_getdbfolder" /*RemoteObject*/ ,starter.processBA)),(Object)(BA.ObjectToString("monitor.db")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 31;BA.debugLine="Dim mapConsulta As Map";
Debug.ShouldStop(1073741824);
_mapconsulta = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("mapConsulta", _mapconsulta);
 BA.debugLineNum = 32;BA.debugLine="mapConsulta = DBUtils.ExecuteMap(sql,\"SELECT * FR";
Debug.ShouldStop(-2147483648);
_mapconsulta = starter.mostCurrent._dbutils.runMethod(false,"_executemap" /*RemoteObject*/ ,starter.processBA,(Object)(starter._sql),(Object)(BA.ObjectToString("SELECT * FROM admin")),(Object)((starter.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("mapConsulta", _mapconsulta);
 BA.debugLineNum = 34;BA.debugLine="For i = 0 To mapConsulta.Size - 1";
Debug.ShouldStop(2);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {_mapconsulta.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 35;BA.debugLine="Select mapConsulta.GetKeyAt(i)";
Debug.ShouldStop(4);
switch (BA.switchObjectToInt(_mapconsulta.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))),RemoteObject.createImmutable(("usuario")),RemoteObject.createImmutable(("clave")))) {
case 0: {
 BA.debugLineNum = 37;BA.debugLine="usuarioAdmin = mapConsulta.GetValueAt(i)";
Debug.ShouldStop(16);
starter._usuarioadmin = BA.ObjectToString(_mapconsulta.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));
 break; }
case 1: {
 BA.debugLineNum = 39;BA.debugLine="claveAdmin = mapConsulta.GetValueAt(i)";
Debug.ShouldStop(64);
starter._claveadmin = BA.ObjectToString(_mapconsulta.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));
 break; }
}
;
 BA.debugLineNum = 41;BA.debugLine="Log(mapConsulta.GetKeyAt(i)&\",\"&mapConsulta.GetV";
Debug.ShouldStop(256);
starter.mostCurrent.__c.runVoidMethod ("LogImpl","11179663",RemoteObject.concat(_mapconsulta.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))),RemoteObject.createImmutable(","),_mapconsulta.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i)))),0);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("Service_TaskRemoved (starter) ","starter",1,starter.processBA,starter.mostCurrent,45);
if (RapidSub.canDelegate("service_taskremoved")) { return com.monitorflux.starter.remoteMe.runUserSub(false, "starter","service_taskremoved");}
 BA.debugLineNum = 45;BA.debugLine="Sub Service_TaskRemoved";
Debug.ShouldStop(4096);
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}