package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,37);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="If FirstTime=True Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_firsttime,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 39;BA.debugLine="Activity.LoadLayout(\"Intro\")			'cargamos el layo";
Debug.ShouldStop(64);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Intro")),main.mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="tmrIntro.Initialize(\"tmrIntro\",3000)	'inicializa";
Debug.ShouldStop(128);
main._tmrintro.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("tmrIntro")),(Object)(BA.numberCast(long.class, 3000)));
 BA.debugLineNum = 41;BA.debugLine="tmrIntro.Enabled = True					'Se ejecuta en tmrIn";
Debug.ShouldStop(256);
main._tmrintro.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 42;BA.debugLine="inicio = False";
Debug.ShouldStop(512);
main._inicio = main.mostCurrent.__c.getField(true,"False");
 }else {
 BA.debugLineNum = 44;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(2048);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 45;BA.debugLine="Activity.LoadLayout(\"Principal\")";
Debug.ShouldStop(4096);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Principal")),main.mostCurrent.activityBA);
 };
 BA.debugLineNum = 48;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
Debug.ShouldStop(32768);
_setstatusbarcolor(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 222))));
 BA.debugLineNum = 49;BA.debugLine="urlHistorial = \"https://api.backendless.com/4D759";
Debug.ShouldStop(65536);
main._urlhistorial = BA.ObjectToString("https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Historial?pageSize=100&property=fecha&property=id&property=encendida&where=id%3D'000000'");
 BA.debugLineNum = 50;BA.debugLine="urlGet = \"https://api.backendless.com/4D75900B-E5";
Debug.ShouldStop(131072);
main.mostCurrent._urlget = BA.ObjectToString("https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos?where=ownerId%20%3D%20");
 BA.debugLineNum = 51;BA.debugLine="backendelessGet.Initialize(\"get\",Me)";
Debug.ShouldStop(262144);
main.mostCurrent._backendelessget.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("get")),(Object)(main.getObject()));
 BA.debugLineNum = 52;BA.debugLine="list.Initialize";
Debug.ShouldStop(524288);
main._list.runVoidMethod ("Initialize");
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,63);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 63;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,55);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 55;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="If tmrIntro.Enabled = False Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",main._tmrintro.runMethod(true,"getEnabled"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 57;BA.debugLine="intentoInicio";
Debug.ShouldStop(16777216);
_intentoinicio();
 };
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("btnAgregar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,78);
if (RapidSub.canDelegate("btnagregar_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnagregar_click");}
 BA.debugLineNum = 78;BA.debugLine="Sub btnAgregar_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="StartActivity(Agregar_Activity)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._agregar_activity.getObject())));
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("btnMonitoreo_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,74);
if (RapidSub.canDelegate("btnmonitoreo_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnmonitoreo_click");}
 BA.debugLineNum = 74;BA.debugLine="Sub btnMonitoreo_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="StartActivity(Monitor_Activity)";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._monitor_activity.getObject())));
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("btnTutorial_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,82);
if (RapidSub.canDelegate("btntutorial_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btntutorial_click");}
 BA.debugLineNum = 82;BA.debugLine="Sub btnTutorial_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 83;BA.debugLine="StartActivity(Tutoriales_Activity)";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._tutoriales_activity.getObject())));
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("conteo (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,119);
if (RapidSub.canDelegate("conteo")) { return b4a.example.main.remoteMe.runUserSub(false, "main","conteo", _res);}
RemoteObject _historialmas = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _nombre = RemoteObject.createImmutable("");
Debug.locals.put("res", _res);
 BA.debugLineNum = 119;BA.debugLine="Sub conteo(res As String)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 120;BA.debugLine="i=0";
Debug.ShouldStop(8388608);
main._i = BA.numberCast(int.class, 0);
 BA.debugLineNum = 121;BA.debugLine="Dim historialmas As String = \"\"";
Debug.ShouldStop(16777216);
_historialmas = BA.ObjectToString("");Debug.locals.put("historialmas", _historialmas);Debug.locals.put("historialmas", _historialmas);
 BA.debugLineNum = 122;BA.debugLine="list.Clear";
Debug.ShouldStop(33554432);
main._list.runVoidMethod ("Clear");
 BA.debugLineNum = 123;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(67108864);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 124;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(134217728);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 125;BA.debugLine="Dim root As List = parser.NextArray";
Debug.ShouldStop(268435456);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = _parser.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 126;BA.debugLine="For Each colroot As Map In root				'map es simila";
Debug.ShouldStop(536870912);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group7 = _root;
final int groupLen7 = group7.runMethod(true,"getSize").<Integer>get()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_colroot = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group7.runMethod(false,"Get",index7));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 127;BA.debugLine="Dim nombre As String = colroot.Get(\"id\")";
Debug.ShouldStop(1073741824);
_nombre = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("id")))));Debug.locals.put("nombre", _nombre);Debug.locals.put("nombre", _nombre);
 BA.debugLineNum = 128;BA.debugLine="list.Add(nombre)";
Debug.ShouldStop(-2147483648);
main._list.runVoidMethod ("Add",(Object)((_nombre)));
 BA.debugLineNum = 129;BA.debugLine="i = i + 1";
Debug.ShouldStop(1);
main._i = RemoteObject.solve(new RemoteObject[] {main._i,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 130;BA.debugLine="historialmas = historialmas & \"%20or%20id%3D'\"&n";
Debug.ShouldStop(2);
_historialmas = RemoteObject.concat(_historialmas,RemoteObject.createImmutable("%20or%20id%3D'"),_nombre,RemoteObject.createImmutable("'"));Debug.locals.put("historialmas", _historialmas);
 }
}Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 132;BA.debugLine="lbBombas.Text = i & \" Dispositivos\"";
Debug.ShouldStop(8);
main.mostCurrent._lbbombas.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main._i,RemoteObject.createImmutable(" Dispositivos"))));
 BA.debugLineNum = 133;BA.debugLine="historial.Initialize(\"historial\",Me)";
Debug.ShouldStop(16);
main.mostCurrent._historial.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("historial")),(Object)(main.getObject()));
 BA.debugLineNum = 134;BA.debugLine="urlHistorial = urlHistorial & historialmas";
Debug.ShouldStop(32);
main._urlhistorial = RemoteObject.concat(main._urlhistorial,_historialmas);
 BA.debugLineNum = 135;BA.debugLine="historial.Download(urlHistorial)";
Debug.ShouldStop(64);
main.mostCurrent._historial.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(main._urlhistorial));
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("fallando (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,138);
if (RapidSub.canDelegate("fallando")) { return b4a.example.main.remoteMe.runUserSub(false, "main","fallando", _res);}
RemoteObject _fecha = RemoteObject.createImmutable(0L);
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
int _a = 0;
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _fechaentra = RemoteObject.createImmutable(0L);
RemoteObject _estado = RemoteObject.createImmutable(false);
Debug.locals.put("res", _res);
 BA.debugLineNum = 138;BA.debugLine="Sub fallando(res As String)";
Debug.ShouldStop(512);
 BA.debugLineNum = 139;BA.debugLine="disFallando = 0";
Debug.ShouldStop(1024);
main._disfallando = BA.numberCast(int.class, 0);
 BA.debugLineNum = 140;BA.debugLine="Dim fecha As Long = 0";
Debug.ShouldStop(2048);
_fecha = BA.numberCast(long.class, 0);Debug.locals.put("fecha", _fecha);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 141;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(4096);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 142;BA.debugLine="For a=0 To list.Size -1";
Debug.ShouldStop(8192);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {main._list.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_a = 0 ;
for (;(step4 > 0 && _a <= limit4) || (step4 < 0 && _a >= limit4) ;_a = ((int)(0 + _a + step4))  ) {
Debug.locals.put("a", _a);
 BA.debugLineNum = 143;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(16384);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 144;BA.debugLine="Dim root As List = parser.NextArray";
Debug.ShouldStop(32768);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = _parser.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 145;BA.debugLine="For Each colroot As Map In root				'map es simil";
Debug.ShouldStop(65536);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group7 = _root;
final int groupLen7 = group7.runMethod(true,"getSize").<Integer>get()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_colroot = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group7.runMethod(false,"Get",index7));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 147;BA.debugLine="If colroot.Get(\"id\") = list.Get(a) Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("id")))),main._list.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _a))))) { 
 BA.debugLineNum = 148;BA.debugLine="Log(list.Get(a))";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","14456458",BA.ObjectToString(main._list.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _a)))),0);
 BA.debugLineNum = 150;BA.debugLine="Dim fechaEntra As Long = colroot.Get(\"fecha\")";
Debug.ShouldStop(2097152);
_fechaentra = BA.numberCast(long.class, _colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha")))));Debug.locals.put("fechaEntra", _fechaentra);Debug.locals.put("fechaEntra", _fechaentra);
 BA.debugLineNum = 151;BA.debugLine="If fechaEntra >= fecha Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("g",_fechaentra,_fecha)) { 
 BA.debugLineNum = 152;BA.debugLine="Dim estado As Boolean = colroot.Get(\"encendid";
Debug.ShouldStop(8388608);
_estado = BA.ObjectToBoolean(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("encendida")))));Debug.locals.put("estado", _estado);Debug.locals.put("estado", _estado);
 BA.debugLineNum = 153;BA.debugLine="fecha = fechaEntra";
Debug.ShouldStop(16777216);
_fecha = _fechaentra;Debug.locals.put("fecha", _fecha);
 };
 };
 }
}Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 157;BA.debugLine="If estado = False Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_estado,main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 158;BA.debugLine="disFallando = disFallando + 1";
Debug.ShouldStop(536870912);
main._disfallando = RemoteObject.solve(new RemoteObject[] {main._disfallando,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 159;BA.debugLine="Log(disFallando)";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("LogImpl","14456469",BA.NumberToString(main._disfallando),0);
 };
 BA.debugLineNum = 161;BA.debugLine="fecha = 0";
Debug.ShouldStop(1);
_fecha = BA.numberCast(long.class, 0);Debug.locals.put("fecha", _fecha);
 }
}Debug.locals.put("a", _a);
;
 BA.debugLineNum = 164;BA.debugLine="lbFallas.Text = disFallando & \" Fallando\"";
Debug.ShouldStop(8);
main.mostCurrent._lbfallas.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main._disfallando,RemoteObject.createImmutable(" Fallando"))));
 BA.debugLineNum = 165;BA.debugLine="If disFallando > 0 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean(">",main._disfallando,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 166;BA.debugLine="lbFallas.Color = Colors.ARGB(255,240,84,84)";
Debug.ShouldStop(32);
main.mostCurrent._lbfallas.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 84)),(Object)(BA.numberCast(int.class, 84))));
 }else {
 BA.debugLineNum = 168;BA.debugLine="lbFallas.Color = Colors.ARGB(128,0,136,145)";
Debug.ShouldStop(128);
main.mostCurrent._lbfallas.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 136)),(Object)(BA.numberCast(int.class, 145))));
 };
 BA.debugLineNum = 170;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 26;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 28;BA.debugLine="Private lbFallas As Label";
main.mostCurrent._lbfallas = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private lbBombas As Label";
main.mostCurrent._lbbombas = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim urlGet As String";
main.mostCurrent._urlget = RemoteObject.createImmutable("");
 //BA.debugLineNum = 31;BA.debugLine="Dim backendelessGet As HttpJob 'se debe inicializ";
main.mostCurrent._backendelessget = RemoteObject.createNew ("b4a.example.httpjob");
 //BA.debugLineNum = 32;BA.debugLine="Dim i As Int";
main._i = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 33;BA.debugLine="Dim disFallando As Int";
main._disfallando = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 34;BA.debugLine="Dim historial As HttpJob";
main.mostCurrent._historial = RemoteObject.createNew ("b4a.example.httpjob");
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _intentoinicio() throws Exception{
try {
		Debug.PushSubsStack("intentoInicio (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,172);
if (RapidSub.canDelegate("intentoinicio")) { return b4a.example.main.remoteMe.runUserSub(false, "main","intentoinicio");}
 BA.debugLineNum = 172;BA.debugLine="Sub intentoInicio";
Debug.ShouldStop(2048);
 BA.debugLineNum = 174;BA.debugLine="If inicio == False Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",main._inicio,main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 175;BA.debugLine="StartActivity(Registrar_Activity)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._registrar_activity.getObject())));
 }else {
 BA.debugLineNum = 178;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(131072);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 179;BA.debugLine="Activity.LoadLayout(\"Principal\")		'cargamos la p";
Debug.ShouldStop(262144);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Principal")),main.mostCurrent.activityBA);
 BA.debugLineNum = 180;BA.debugLine="backendelessGet.Download(urlGet & \"'\" & ID & \"'\"";
Debug.ShouldStop(524288);
main.mostCurrent._backendelessget.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.concat(main.mostCurrent._urlget,RemoteObject.createImmutable("'"),main._id,RemoteObject.createImmutable("'"))));
 };
 BA.debugLineNum = 184;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("JobDone (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,102);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.main.remoteMe.runUserSub(false, "main","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 102;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("LogImpl","14325377",RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname" /*RemoteObject*/ ),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success" /*RemoteObject*/ )),0);
 BA.debugLineNum = 104;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 105;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
Debug.ShouldStop(256);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("get"),BA.ObjectToString("historial"))) {
case 0: {
 BA.debugLineNum = 107;BA.debugLine="conteo(Job.GetString) 'se envia la cadena reci";
Debug.ShouldStop(1024);
_conteo(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ));
 break; }
case 1: {
 BA.debugLineNum = 109;BA.debugLine="Log(Job.GetString)";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("LogImpl","14325383",_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 110;BA.debugLine="fallando(Job.GetString)";
Debug.ShouldStop(8192);
_fallando(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ));
 break; }
}
;
 }else {
 BA.debugLineNum = 113;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("LogImpl","14325387",RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )),0);
 BA.debugLineNum = 114;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 116;BA.debugLine="Job.Release";
Debug.ShouldStop(524288);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 117;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
tutoriales_activity.myClass = BA.getDeviceClass ("b4a.example.tutoriales_activity");
agregar_activity.myClass = BA.getDeviceClass ("b4a.example.agregar_activity");
monitor_activity.myClass = BA.getDeviceClass ("b4a.example.monitor_activity");
datos_activity.myClass = BA.getDeviceClass ("b4a.example.datos_activity");
registrar_activity.myClass = BA.getDeviceClass ("b4a.example.registrar_activity");
httputils2service.myClass = BA.getDeviceClass ("b4a.example.httputils2service");
httpjob.myClass = BA.getDeviceClass ("b4a.example.httpjob");
keyvaluestore.myClass = BA.getDeviceClass ("b4a.example.keyvaluestore");
dbutils.myClass = BA.getDeviceClass ("b4a.example.dbutils");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="Dim tmrIntro As Timer 'Timer para el intro de la";
main._tmrintro = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 20;BA.debugLine="Dim list As List";
main._list = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 21;BA.debugLine="Dim inicio As Boolean";
main._inicio = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 22;BA.debugLine="Dim ID As String";
main._id = RemoteObject.createImmutable("");
 //BA.debugLineNum = 23;BA.debugLine="Dim urlHistorial As String";
main._urlhistorial = RemoteObject.createImmutable("");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setstatusbarcolor(RemoteObject _clr) throws Exception{
try {
		Debug.PushSubsStack("SetStatusBarColor (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,86);
if (RapidSub.canDelegate("setstatusbarcolor")) { return b4a.example.main.remoteMe.runUserSub(false, "main","setstatusbarcolor", _clr);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _window = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("clr", _clr);
 BA.debugLineNum = 86;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(4194304);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 88;BA.debugLine="If p.SdkVersion >= 21 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 21))) { 
 BA.debugLineNum = 89;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(16777216);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 90;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(33554432);
_jo.runVoidMethod ("InitializeContext",main.processBA);
 BA.debugLineNum = 91;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
Debug.ShouldStop(67108864);
_window = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_window = _jo.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getWindow")),(Object)((main.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("window", _window);Debug.locals.put("window", _window);
 BA.debugLineNum = 92;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
Debug.ShouldStop(134217728);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("addFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x80000000))})));
 BA.debugLineNum = 93;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
Debug.ShouldStop(268435456);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("clearFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x04000000))})));
 BA.debugLineNum = 94;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
Debug.ShouldStop(536870912);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setStatusBarColor")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_clr)})));
 };
 BA.debugLineNum = 96;BA.debugLine="If p.SdkVersion >= 23 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 23))) { 
 BA.debugLineNum = 97;BA.debugLine="jo = Activity";
Debug.ShouldStop(1);
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), main.mostCurrent._activity.getObject());
 BA.debugLineNum = 98;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
Debug.ShouldStop(2);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setSystemUiVisibility")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((8192))})));
 };
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("tmrIntro_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,67);
if (RapidSub.canDelegate("tmrintro_tick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","tmrintro_tick");}
 BA.debugLineNum = 67;BA.debugLine="Sub tmrIntro_Tick";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="tmrIntro.Enabled = False";
Debug.ShouldStop(8);
main._tmrintro.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 69;BA.debugLine="intentoInicio";
Debug.ShouldStop(16);
_intentoinicio();
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}