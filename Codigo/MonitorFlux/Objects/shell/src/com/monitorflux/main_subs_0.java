package com.monitorflux;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,40);
if (RapidSub.canDelegate("activity_create")) { return com.monitorflux.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="If FirstTime=True Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_firsttime,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 42;BA.debugLine="Activity.LoadLayout(\"Intro\")			'cargamos el layo";
Debug.ShouldStop(512);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Intro")),main.mostCurrent.activityBA);
 BA.debugLineNum = 43;BA.debugLine="tmrIntro.Initialize(\"tmrIntro\",3000)	'inicializa";
Debug.ShouldStop(1024);
main._tmrintro.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("tmrIntro")),(Object)(BA.numberCast(long.class, 3000)));
 BA.debugLineNum = 44;BA.debugLine="tmrIntro.Enabled = True					'Se ejecuta en tmrIn";
Debug.ShouldStop(2048);
main._tmrintro.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 45;BA.debugLine="inicio = False";
Debug.ShouldStop(4096);
main._inicio = main.mostCurrent.__c.getField(true,"False");
 }else {
 BA.debugLineNum = 47;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(16384);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 48;BA.debugLine="Activity.LoadLayout(\"Principal\")";
Debug.ShouldStop(32768);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Principal")),main.mostCurrent.activityBA);
 };
 BA.debugLineNum = 51;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
Debug.ShouldStop(262144);
_setstatusbarcolor(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 222))));
 BA.debugLineNum = 52;BA.debugLine="urlHistorial = \"https://api.backendless.com/4D759";
Debug.ShouldStop(524288);
main._urlhistorial = BA.ObjectToString("https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Historial?pageSize=100&property=fecha&property=id&property=encendida&where=id%3D'000000'");
 BA.debugLineNum = 53;BA.debugLine="urlGet = \"https://api.backendless.com/4D75900B-E5";
Debug.ShouldStop(1048576);
main.mostCurrent._urlget = BA.ObjectToString("https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos?where=ownerId%20%3D%20");
 BA.debugLineNum = 54;BA.debugLine="backendelessGet.Initialize(\"get\",Me)";
Debug.ShouldStop(2097152);
main.mostCurrent._backendelessget.runClassMethod (com.monitorflux.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("get")),(Object)(main.getObject()));
 BA.debugLineNum = 55;BA.debugLine="list.Initialize";
Debug.ShouldStop(4194304);
main._list.runVoidMethod ("Initialize");
 BA.debugLineNum = 56;BA.debugLine="IniciarSesion.Initialize(\"iniciar\",Me)";
Debug.ShouldStop(8388608);
main.mostCurrent._iniciarsesion.runClassMethod (com.monitorflux.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("iniciar")),(Object)(main.getObject()));
 BA.debugLineNum = 57;BA.debugLine="urlIniciar = \"https://api.backendless.com/4D75900";
Debug.ShouldStop(16777216);
main.mostCurrent._urliniciar = BA.ObjectToString("https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/users/login");
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,69);
if (RapidSub.canDelegate("activity_pause")) { return com.monitorflux.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 69;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,60);
if (RapidSub.canDelegate("activity_resume")) { return com.monitorflux.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 60;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="If tmrIntro.Enabled = False Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main._tmrintro.runMethod(true,"getEnabled"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 62;BA.debugLine="Log(\"Timer deshabilitado, intentando inicio\")";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1196610",RemoteObject.createImmutable("Timer deshabilitado, intentando inicio"),0);
 BA.debugLineNum = 63;BA.debugLine="intentoInicio";
Debug.ShouldStop(1073741824);
_intentoinicio();
 };
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnagregar_click() throws Exception{
try {
		Debug.PushSubsStack("btnAgregar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,91);
if (RapidSub.canDelegate("btnagregar_click")) { return com.monitorflux.main.remoteMe.runUserSub(false, "main","btnagregar_click");}
 BA.debugLineNum = 91;BA.debugLine="Sub btnAgregar_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 92;BA.debugLine="StartActivity(Agregar_Activity)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._agregar_activity.getObject())));
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnmonitoreo_click() throws Exception{
try {
		Debug.PushSubsStack("btnMonitoreo_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,87);
if (RapidSub.canDelegate("btnmonitoreo_click")) { return com.monitorflux.main.remoteMe.runUserSub(false, "main","btnmonitoreo_click");}
 BA.debugLineNum = 87;BA.debugLine="Sub btnMonitoreo_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="StartActivity(Monitor_Activity)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._monitor_activity.getObject())));
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
public static RemoteObject  _btnout_click() throws Exception{
try {
		Debug.PushSubsStack("btnOut_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,201);
if (RapidSub.canDelegate("btnout_click")) { return com.monitorflux.main.remoteMe.runUserSub(false, "main","btnout_click");}
 BA.debugLineNum = 201;BA.debugLine="Sub btnOut_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 202;BA.debugLine="Starter.actualizarCampos(\"mantener\",\"0\",\"id\",\"1\")";
Debug.ShouldStop(512);
main.mostCurrent._starter.runVoidMethod ("_actualizarcampos" /*RemoteObject*/ ,(Object)(BA.ObjectToString("mantener")),(Object)(BA.ObjectToString("0")),(Object)(BA.ObjectToString("id")),(Object)(RemoteObject.createImmutable("1")));
 BA.debugLineNum = 203;BA.debugLine="inicio = False";
Debug.ShouldStop(1024);
main._inicio = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 204;BA.debugLine="intentoInicio";
Debug.ShouldStop(2048);
_intentoinicio();
 BA.debugLineNum = 205;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btntutorial_click() throws Exception{
try {
		Debug.PushSubsStack("btnTutorial_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,95);
if (RapidSub.canDelegate("btntutorial_click")) { return com.monitorflux.main.remoteMe.runUserSub(false, "main","btntutorial_click");}
 BA.debugLineNum = 95;BA.debugLine="Sub btnTutorial_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 96;BA.debugLine="StartActivity(Tutoriales_Activity)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._tutoriales_activity.getObject())));
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _conteo(RemoteObject _res) throws Exception{
try {
		Debug.PushSubsStack("conteo (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,134);
if (RapidSub.canDelegate("conteo")) { return com.monitorflux.main.remoteMe.runUserSub(false, "main","conteo", _res);}
RemoteObject _historialmas = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _nombre = RemoteObject.createImmutable("");
Debug.locals.put("res", _res);
 BA.debugLineNum = 134;BA.debugLine="Sub conteo(res As String)";
Debug.ShouldStop(32);
 BA.debugLineNum = 135;BA.debugLine="i=0";
Debug.ShouldStop(64);
main._i = BA.numberCast(int.class, 0);
 BA.debugLineNum = 136;BA.debugLine="Dim historialmas As String = \"\"";
Debug.ShouldStop(128);
_historialmas = BA.ObjectToString("");Debug.locals.put("historialmas", _historialmas);Debug.locals.put("historialmas", _historialmas);
 BA.debugLineNum = 137;BA.debugLine="list.Clear";
Debug.ShouldStop(256);
main._list.runVoidMethod ("Clear");
 BA.debugLineNum = 138;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(512);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 139;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(1024);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 140;BA.debugLine="Dim root As List = parser.NextArray";
Debug.ShouldStop(2048);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = _parser.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 141;BA.debugLine="For Each colroot As Map In root				'map es simila";
Debug.ShouldStop(4096);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group7 = _root;
final int groupLen7 = group7.runMethod(true,"getSize").<Integer>get()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_colroot = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group7.runMethod(false,"Get",index7));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 142;BA.debugLine="Dim nombre As String = colroot.Get(\"id\")";
Debug.ShouldStop(8192);
_nombre = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("id")))));Debug.locals.put("nombre", _nombre);Debug.locals.put("nombre", _nombre);
 BA.debugLineNum = 143;BA.debugLine="list.Add(nombre)";
Debug.ShouldStop(16384);
main._list.runVoidMethod ("Add",(Object)((_nombre)));
 BA.debugLineNum = 144;BA.debugLine="i = i + 1";
Debug.ShouldStop(32768);
main._i = RemoteObject.solve(new RemoteObject[] {main._i,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 145;BA.debugLine="historialmas = historialmas & \"%20or%20id%3D'\"&n";
Debug.ShouldStop(65536);
_historialmas = RemoteObject.concat(_historialmas,RemoteObject.createImmutable("%20or%20id%3D'"),_nombre,RemoteObject.createImmutable("'"));Debug.locals.put("historialmas", _historialmas);
 }
}Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 147;BA.debugLine="lbBombas.Text = i & \" Dispositivos\"";
Debug.ShouldStop(262144);
main.mostCurrent._lbbombas.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main._i,RemoteObject.createImmutable(" Dispositivos"))));
 BA.debugLineNum = 148;BA.debugLine="historial.Initialize(\"historial\",Me)";
Debug.ShouldStop(524288);
main.mostCurrent._historial.runClassMethod (com.monitorflux.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("historial")),(Object)(main.getObject()));
 BA.debugLineNum = 149;BA.debugLine="urlHistorial = urlHistorial & historialmas";
Debug.ShouldStop(1048576);
main._urlhistorial = RemoteObject.concat(main._urlhistorial,_historialmas);
 BA.debugLineNum = 150;BA.debugLine="historial.Download(urlHistorial)";
Debug.ShouldStop(2097152);
main.mostCurrent._historial.runClassMethod (com.monitorflux.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(main._urlhistorial));
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fallando(RemoteObject _res) throws Exception{
try {
		Debug.PushSubsStack("fallando (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,153);
if (RapidSub.canDelegate("fallando")) { return com.monitorflux.main.remoteMe.runUserSub(false, "main","fallando", _res);}
RemoteObject _fecha = RemoteObject.createImmutable(0L);
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
int _a = 0;
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _fechaentra = RemoteObject.createImmutable(0L);
RemoteObject _estado = RemoteObject.createImmutable(false);
Debug.locals.put("res", _res);
 BA.debugLineNum = 153;BA.debugLine="Sub fallando(res As String)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 154;BA.debugLine="disFallando = 0";
Debug.ShouldStop(33554432);
main._disfallando = BA.numberCast(int.class, 0);
 BA.debugLineNum = 155;BA.debugLine="Dim fecha As Long = 0";
Debug.ShouldStop(67108864);
_fecha = BA.numberCast(long.class, 0);Debug.locals.put("fecha", _fecha);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 156;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(134217728);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 157;BA.debugLine="For a=0 To list.Size -1";
Debug.ShouldStop(268435456);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {main._list.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_a = 0 ;
for (;(step4 > 0 && _a <= limit4) || (step4 < 0 && _a >= limit4) ;_a = ((int)(0 + _a + step4))  ) {
Debug.locals.put("a", _a);
 BA.debugLineNum = 158;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(536870912);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 159;BA.debugLine="Dim root As List = parser.NextArray";
Debug.ShouldStop(1073741824);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = _parser.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 160;BA.debugLine="For Each colroot As Map In root				'map es simil";
Debug.ShouldStop(-2147483648);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group7 = _root;
final int groupLen7 = group7.runMethod(true,"getSize").<Integer>get()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_colroot = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group7.runMethod(false,"Get",index7));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 162;BA.debugLine="If colroot.Get(\"id\") = list.Get(a) Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("id")))),main._list.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _a))))) { 
 BA.debugLineNum = 165;BA.debugLine="Dim fechaEntra As Long = colroot.Get(\"fecha\")";
Debug.ShouldStop(16);
_fechaentra = BA.numberCast(long.class, _colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha")))));Debug.locals.put("fechaEntra", _fechaentra);Debug.locals.put("fechaEntra", _fechaentra);
 BA.debugLineNum = 166;BA.debugLine="If fechaEntra >= fecha Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("g",_fechaentra,_fecha)) { 
 BA.debugLineNum = 167;BA.debugLine="Dim estado As Boolean = colroot.Get(\"encendid";
Debug.ShouldStop(64);
_estado = BA.ObjectToBoolean(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("encendida")))));Debug.locals.put("estado", _estado);Debug.locals.put("estado", _estado);
 BA.debugLineNum = 168;BA.debugLine="fecha = fechaEntra";
Debug.ShouldStop(128);
_fecha = _fechaentra;Debug.locals.put("fecha", _fecha);
 };
 };
 }
}Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 172;BA.debugLine="If estado = False Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_estado,main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 173;BA.debugLine="disFallando = disFallando + 1";
Debug.ShouldStop(4096);
main._disfallando = RemoteObject.solve(new RemoteObject[] {main._disfallando,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 174;BA.debugLine="Log(disFallando)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1786453",BA.NumberToString(main._disfallando),0);
 };
 BA.debugLineNum = 176;BA.debugLine="fecha = 0";
Debug.ShouldStop(32768);
_fecha = BA.numberCast(long.class, 0);Debug.locals.put("fecha", _fecha);
 }
}Debug.locals.put("a", _a);
;
 BA.debugLineNum = 179;BA.debugLine="lbFallas.Text = disFallando & \" Fallando\"";
Debug.ShouldStop(262144);
main.mostCurrent._lbfallas.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main._disfallando,RemoteObject.createImmutable(" Fallando"))));
 BA.debugLineNum = 180;BA.debugLine="If disFallando > 0 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean(">",main._disfallando,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 181;BA.debugLine="lbFallas.Color = Colors.ARGB(255,240,84,84)";
Debug.ShouldStop(1048576);
main.mostCurrent._lbfallas.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 84)),(Object)(BA.numberCast(int.class, 84))));
 }else {
 BA.debugLineNum = 183;BA.debugLine="lbFallas.Color = Colors.ARGB(128,0,136,145)";
Debug.ShouldStop(4194304);
main.mostCurrent._lbfallas.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 136)),(Object)(BA.numberCast(int.class, 145))));
 };
 BA.debugLineNum = 185;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 29;BA.debugLine="Private lbFallas As Label";
main.mostCurrent._lbfallas = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private lbBombas As Label";
main.mostCurrent._lbbombas = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim urlGet As String";
main.mostCurrent._urlget = RemoteObject.createImmutable("");
 //BA.debugLineNum = 32;BA.debugLine="Dim backendelessGet As HttpJob 'se debe inicializ";
main.mostCurrent._backendelessget = RemoteObject.createNew ("com.monitorflux.httpjob");
 //BA.debugLineNum = 33;BA.debugLine="Dim i As Int";
main._i = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 34;BA.debugLine="Dim disFallando As Int";
main._disfallando = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 35;BA.debugLine="Dim historial As HttpJob";
main.mostCurrent._historial = RemoteObject.createNew ("com.monitorflux.httpjob");
 //BA.debugLineNum = 36;BA.debugLine="Private IniciarSesion As HttpJob";
main.mostCurrent._iniciarsesion = RemoteObject.createNew ("com.monitorflux.httpjob");
 //BA.debugLineNum = 37;BA.debugLine="Private urlIniciar As String";
main.mostCurrent._urliniciar = RemoteObject.createImmutable("");
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _intentoinicio() throws Exception{
try {
		Debug.PushSubsStack("intentoInicio (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,187);
if (RapidSub.canDelegate("intentoinicio")) { return com.monitorflux.main.remoteMe.runUserSub(false, "main","intentoinicio");}
 BA.debugLineNum = 187;BA.debugLine="Sub intentoInicio";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 189;BA.debugLine="If inicio == False Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main._inicio,main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 190;BA.debugLine="StartActivity(Registrar_Activity)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._registrar_activity.getObject())));
 }else {
 BA.debugLineNum = 193;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(1);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 194;BA.debugLine="Activity.LoadLayout(\"Principal\")		'cargamos la p";
Debug.ShouldStop(2);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Principal")),main.mostCurrent.activityBA);
 BA.debugLineNum = 195;BA.debugLine="backendelessGet.Download(urlGet & \"'\" & ID & \"'\"";
Debug.ShouldStop(4);
main.mostCurrent._backendelessget.runClassMethod (com.monitorflux.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.concat(main.mostCurrent._urlget,RemoteObject.createImmutable("'"),main._id,RemoteObject.createImmutable("'"))));
 };
 BA.debugLineNum = 199;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,115);
if (RapidSub.canDelegate("jobdone")) { return com.monitorflux.main.remoteMe.runUserSub(false, "main","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 115;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 116;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1655361",RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname" /*RemoteObject*/ ),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success" /*RemoteObject*/ )),0);
 BA.debugLineNum = 117;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 118;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
Debug.ShouldStop(2097152);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("get"),BA.ObjectToString("historial"),BA.ObjectToString("iniciar"))) {
case 0: {
 BA.debugLineNum = 120;BA.debugLine="conteo(Job.GetString) 'se envia la cadena reci";
Debug.ShouldStop(8388608);
_conteo(_job.runClassMethod (com.monitorflux.httpjob.class, "_getstring" /*RemoteObject*/ ));
 break; }
case 1: {
 BA.debugLineNum = 122;BA.debugLine="Log(Job.GetString)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1655367",_job.runClassMethod (com.monitorflux.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 123;BA.debugLine="fallando(Job.GetString)";
Debug.ShouldStop(67108864);
_fallando(_job.runClassMethod (com.monitorflux.httpjob.class, "_getstring" /*RemoteObject*/ ));
 break; }
case 2: {
 BA.debugLineNum = 125;BA.debugLine="resInicio(Job.GetString) 'se envia la cadena r";
Debug.ShouldStop(268435456);
_resinicio(_job.runClassMethod (com.monitorflux.httpjob.class, "_getstring" /*RemoteObject*/ ));
 break; }
}
;
 }else {
 BA.debugLineNum = 128;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1655373",RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )),0);
 BA.debugLineNum = 129;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 131;BA.debugLine="Job.Release";
Debug.ShouldStop(4);
_job.runClassMethod (com.monitorflux.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
tutoriales_activity_subs_0._process_globals();
agregar_activity_subs_0._process_globals();
monitor_activity_subs_0._process_globals();
datos_activity_subs_0._process_globals();
registrar_activity_subs_0._process_globals();
httputils2service_subs_0._process_globals();
dbutils_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("com.monitorflux.main");
starter.myClass = BA.getDeviceClass ("com.monitorflux.starter");
tutoriales_activity.myClass = BA.getDeviceClass ("com.monitorflux.tutoriales_activity");
agregar_activity.myClass = BA.getDeviceClass ("com.monitorflux.agregar_activity");
monitor_activity.myClass = BA.getDeviceClass ("com.monitorflux.monitor_activity");
datos_activity.myClass = BA.getDeviceClass ("com.monitorflux.datos_activity");
registrar_activity.myClass = BA.getDeviceClass ("com.monitorflux.registrar_activity");
httputils2service.myClass = BA.getDeviceClass ("com.monitorflux.httputils2service");
httpjob.myClass = BA.getDeviceClass ("com.monitorflux.httpjob");
keyvaluestore.myClass = BA.getDeviceClass ("com.monitorflux.keyvaluestore");
dbutils.myClass = BA.getDeviceClass ("com.monitorflux.dbutils");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 20;BA.debugLine="Dim tmrIntro As Timer 'Timer para el intro de la";
main._tmrintro = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 21;BA.debugLine="Dim list As List";
main._list = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 22;BA.debugLine="Dim inicio As Boolean";
main._inicio = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 23;BA.debugLine="Dim ID As String";
main._id = RemoteObject.createImmutable("");
 //BA.debugLineNum = 24;BA.debugLine="Dim urlHistorial As String";
main._urlhistorial = RemoteObject.createImmutable("");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _resinicio(RemoteObject _res) throws Exception{
try {
		Debug.PushSubsStack("resInicio (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,207);
if (RapidSub.canDelegate("resinicio")) { return com.monitorflux.main.remoteMe.runUserSub(false, "main","resinicio", _res);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("res", _res);
 BA.debugLineNum = 207;BA.debugLine="Sub resInicio(res As String)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 208;BA.debugLine="inicio = True";
Debug.ShouldStop(32768);
main._inicio = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 209;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(65536);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 210;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(131072);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 211;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(262144);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 212;BA.debugLine="ID = root.Get(\"objectId\")";
Debug.ShouldStop(524288);
main._id = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("objectId")))));
 BA.debugLineNum = 213;BA.debugLine="intentoInicio";
Debug.ShouldStop(1048576);
_intentoinicio();
 BA.debugLineNum = 214;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setstatusbarcolor(RemoteObject _clr) throws Exception{
try {
		Debug.PushSubsStack("SetStatusBarColor (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,99);
if (RapidSub.canDelegate("setstatusbarcolor")) { return com.monitorflux.main.remoteMe.runUserSub(false, "main","setstatusbarcolor", _clr);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _window = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("clr", _clr);
 BA.debugLineNum = 99;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(8);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 101;BA.debugLine="If p.SdkVersion >= 21 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 21))) { 
 BA.debugLineNum = 102;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(32);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 103;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(64);
_jo.runVoidMethod ("InitializeContext",main.processBA);
 BA.debugLineNum = 104;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
Debug.ShouldStop(128);
_window = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_window = _jo.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getWindow")),(Object)((main.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("window", _window);Debug.locals.put("window", _window);
 BA.debugLineNum = 105;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
Debug.ShouldStop(256);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("addFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x80000000))})));
 BA.debugLineNum = 106;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
Debug.ShouldStop(512);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("clearFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x04000000))})));
 BA.debugLineNum = 107;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
Debug.ShouldStop(1024);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setStatusBarColor")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_clr)})));
 };
 BA.debugLineNum = 109;BA.debugLine="If p.SdkVersion >= 23 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 23))) { 
 BA.debugLineNum = 110;BA.debugLine="jo = Activity";
Debug.ShouldStop(8192);
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), main.mostCurrent._activity.getObject());
 BA.debugLineNum = 111;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
Debug.ShouldStop(16384);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setSystemUiVisibility")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((8192))})));
 };
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tmrintro_tick() throws Exception{
try {
		Debug.PushSubsStack("tmrIntro_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,73);
if (RapidSub.canDelegate("tmrintro_tick")) { return com.monitorflux.main.remoteMe.runUserSub(false, "main","tmrintro_tick");}
RemoteObject _datos = RemoteObject.createImmutable("");
 BA.debugLineNum = 73;BA.debugLine="Sub tmrIntro_Tick";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="tmrIntro.Enabled = False";
Debug.ShouldStop(512);
main._tmrintro.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 75;BA.debugLine="Log(\"Finalizando intro inicial intentando inicio\"";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1327682",RemoteObject.createImmutable("Finalizando intro inicial intentando inicio"),0);
 BA.debugLineNum = 76;BA.debugLine="If Starter.checkMantener Then";
Debug.ShouldStop(2048);
if (main.mostCurrent._starter.runMethod(true,"_checkmantener" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 77;BA.debugLine="Dim datos As String";
Debug.ShouldStop(4096);
_datos = RemoteObject.createImmutable("");Debug.locals.put("datos", _datos);
 BA.debugLineNum = 78;BA.debugLine="datos = \"{\"&Chr(34)&\"login\"&Chr(34)&\":\"&Chr(34)&";
Debug.ShouldStop(8192);
_datos = RemoteObject.concat(RemoteObject.createImmutable("{"),main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("login"),main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(":"),main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),main.mostCurrent._starter._usuario /*RemoteObject*/ ,main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(","),main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("password"),main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(":"),main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),main.mostCurrent._starter._clave /*RemoteObject*/ ,main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("}"));Debug.locals.put("datos", _datos);
 BA.debugLineNum = 79;BA.debugLine="IniciarSesion.PostString(urlIniciar, datos)";
Debug.ShouldStop(16384);
main.mostCurrent._iniciarsesion.runClassMethod (com.monitorflux.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(main.mostCurrent._urliniciar),(Object)(_datos));
 BA.debugLineNum = 80;BA.debugLine="IniciarSesion.GetRequest.SetContentType(\"applica";
Debug.ShouldStop(32768);
main.mostCurrent._iniciarsesion.runClassMethod (com.monitorflux.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
 }else {
 BA.debugLineNum = 82;BA.debugLine="intentoInicio";
Debug.ShouldStop(131072);
_intentoinicio();
 };
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}