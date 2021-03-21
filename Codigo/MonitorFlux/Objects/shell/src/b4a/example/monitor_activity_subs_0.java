package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class monitor_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (monitor_activity) ","monitor_activity",4,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,26);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 29;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(268435456);
monitor_activity.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"Monitoreo\")";
Debug.ShouldStop(536870912);
monitor_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Monitoreo")),monitor_activity.mostCurrent.activityBA);
 BA.debugLineNum = 31;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
Debug.ShouldStop(1073741824);
_setstatusbarcolor(monitor_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 222))));
 BA.debugLineNum = 32;BA.debugLine="urlGet = \"https://api.backendless.com/85B70858-21";
Debug.ShouldStop(-2147483648);
monitor_activity.mostCurrent._urlget = BA.ObjectToString("https://api.backendless.com/85B70858-2193-2A92-FF8E-BF8B113D4100/CC232E12-9D6D-40A6-A41A-23796B090767/data/Dispositivos");
 BA.debugLineNum = 33;BA.debugLine="urlHistorial = \"https://api.backendless.com/85B70";
Debug.ShouldStop(1);
monitor_activity.mostCurrent._urlhistorial = BA.ObjectToString("https://api.backendless.com/85B70858-2193-2A92-FF8E-BF8B113D4100/CC232E12-9D6D-40A6-A41A-23796B090767/data/Historial?pageSize=100");
 BA.debugLineNum = 34;BA.debugLine="historial.Initialize(\"historial\",Me)";
Debug.ShouldStop(2);
monitor_activity.mostCurrent._historial.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,monitor_activity.processBA,(Object)(BA.ObjectToString("historial")),(Object)(monitor_activity.getObject()));
 BA.debugLineNum = 35;BA.debugLine="historial.Download(urlHistorial)";
Debug.ShouldStop(4);
monitor_activity.mostCurrent._historial.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(monitor_activity.mostCurrent._urlhistorial));
 BA.debugLineNum = 36;BA.debugLine="listAlterna.Initialize";
Debug.ShouldStop(8);
monitor_activity.mostCurrent._listalterna.runVoidMethod ("Initialize");
 BA.debugLineNum = 37;BA.debugLine="disFallando.Initialize   'guarda el estado de los";
Debug.ShouldStop(16);
monitor_activity.mostCurrent._disfallando.runVoidMethod ("Initialize");
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Activity_Pause (monitor_activity) ","monitor_activity",4,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,44);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("Activity_Resume (monitor_activity) ","monitor_activity",4,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,40);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","activity_resume");}
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(128);
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _additems(RemoteObject _texto,RemoteObject _orden) throws Exception{
try {
		Debug.PushSubsStack("addItems (monitor_activity) ","monitor_activity",4,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,112);
if (RapidSub.canDelegate("additems")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","additems", _texto, _orden);}
RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
int _a = 0;
Debug.locals.put("texto", _texto);
Debug.locals.put("orden", _orden);
 BA.debugLineNum = 112;BA.debugLine="Sub addItems (texto As String, orden As Int)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="Dim xui As XUI";
Debug.ShouldStop(65536);
_xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");Debug.locals.put("xui", _xui);
 BA.debugLineNum = 114;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(131072);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p = _xui.runMethod(false,"CreatePanel",monitor_activity.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 115;BA.debugLine="p.SetLayoutAnimated(100,0,0,100%x,10%y)";
Debug.ShouldStop(262144);
_p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(monitor_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),monitor_activity.mostCurrent.activityBA)),(Object)(monitor_activity.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),monitor_activity.mostCurrent.activityBA)));
 BA.debugLineNum = 116;BA.debugLine="p.LoadLayout(\"Item\")";
Debug.ShouldStop(524288);
_p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Item")),monitor_activity.mostCurrent.activityBA);
 BA.debugLineNum = 117;BA.debugLine="lbDispositivo.Text=(texto)";
Debug.ShouldStop(1048576);
monitor_activity.mostCurrent._lbdispositivo.runMethod(true,"setText",BA.ObjectToCharSequence((_texto)));
 BA.debugLineNum = 118;BA.debugLine="For a=0 To disFallando.Size-1";
Debug.ShouldStop(2097152);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {monitor_activity.mostCurrent._disfallando.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_a = 0 ;
for (;(step6 > 0 && _a <= limit6) || (step6 < 0 && _a >= limit6) ;_a = ((int)(0 + _a + step6))  ) {
Debug.locals.put("a", _a);
 BA.debugLineNum = 119;BA.debugLine="If texto = disFallando.Get(a) Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_texto,BA.ObjectToString(monitor_activity.mostCurrent._disfallando.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _a)))))) { 
 BA.debugLineNum = 120;BA.debugLine="lbDispositivo.Color = Colors.ARGB(255,240,84,84";
Debug.ShouldStop(8388608);
monitor_activity.mostCurrent._lbdispositivo.runMethod(true,"setColor",monitor_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 84)),(Object)(BA.numberCast(int.class, 84))));
 };
 }
}Debug.locals.put("a", _a);
;
 BA.debugLineNum = 123;BA.debugLine="lvElectro.Add(p,orden)";
Debug.ShouldStop(67108864);
monitor_activity.mostCurrent._lvelectro.runVoidMethod ("_add",(Object)(_p),(Object)((_orden)));
 BA.debugLineNum = 124;BA.debugLine="listAlterna.Add(texto)";
Debug.ShouldStop(134217728);
monitor_activity.mostCurrent._listalterna.runVoidMethod ("Add",(Object)((_texto)));
 BA.debugLineNum = 125;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnatrasm_click() throws Exception{
try {
		Debug.PushSubsStack("btnAtrasM_Click (monitor_activity) ","monitor_activity",4,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,49);
if (RapidSub.canDelegate("btnatrasm_click")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","btnatrasm_click");}
 BA.debugLineNum = 49;BA.debugLine="Sub btnAtrasM_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="Activity.Finish";
Debug.ShouldStop(131072);
monitor_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cargarvalores(RemoteObject _res) throws Exception{
try {
		Debug.PushSubsStack("cargarValores (monitor_activity) ","monitor_activity",4,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,69);
if (RapidSub.canDelegate("cargarvalores")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","cargarvalores", _res);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _nombre = RemoteObject.createImmutable("");
Debug.locals.put("res", _res);
 BA.debugLineNum = 69;BA.debugLine="Sub cargarValores (res As String)";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="i=0";
Debug.ShouldStop(32);
monitor_activity._i = BA.numberCast(int.class, 0);
 BA.debugLineNum = 71;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(64);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 72;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(128);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 75;BA.debugLine="Dim root As List = parser.NextArray";
Debug.ShouldStop(1024);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = _parser.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 76;BA.debugLine="For Each colroot As Map In root				'map es simila";
Debug.ShouldStop(2048);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group5 = _root;
final int groupLen5 = group5.runMethod(true,"getSize").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_colroot = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group5.runMethod(false,"Get",index5));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 77;BA.debugLine="Dim nombre As String = colroot.Get(\"nombre\")";
Debug.ShouldStop(4096);
_nombre = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nombre")))));Debug.locals.put("nombre", _nombre);Debug.locals.put("nombre", _nombre);
 BA.debugLineNum = 78;BA.debugLine="addItems(nombre,i)";
Debug.ShouldStop(8192);
_additems(_nombre,monitor_activity._i);
 BA.debugLineNum = 79;BA.debugLine="i = i + 1";
Debug.ShouldStop(16384);
monitor_activity._i = RemoteObject.solve(new RemoteObject[] {monitor_activity._i,RemoteObject.createImmutable(1)}, "+",1, 1);
 }
}Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("fallando (monitor_activity) ","monitor_activity",4,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,84);
if (RapidSub.canDelegate("fallando")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","fallando", _res);}
RemoteObject _fecha = RemoteObject.createImmutable(0L);
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _a = 0;
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _fechaentra = RemoteObject.createImmutable(0L);
RemoteObject _estado = RemoteObject.createImmutable("");
Debug.locals.put("res", _res);
 BA.debugLineNum = 84;BA.debugLine="Sub fallando(res As String)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="Dim fecha As Long = 0";
Debug.ShouldStop(1048576);
_fecha = BA.numberCast(long.class, 0);Debug.locals.put("fecha", _fecha);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 86;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(2097152);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 87;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(4194304);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 88;BA.debugLine="Dim root As List = parser.NextArray";
Debug.ShouldStop(8388608);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = _parser.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 89;BA.debugLine="For a=0 To Main.list.Size -1";
Debug.ShouldStop(16777216);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {monitor_activity.mostCurrent._main._list /*RemoteObject*/ .runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_a = 0 ;
for (;(step5 > 0 && _a <= limit5) || (step5 < 0 && _a >= limit5) ;_a = ((int)(0 + _a + step5))  ) {
Debug.locals.put("a", _a);
 BA.debugLineNum = 90;BA.debugLine="For Each colroot As Map In root				'map es simil";
Debug.ShouldStop(33554432);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group6 = _root;
final int groupLen6 = group6.runMethod(true,"getSize").<Integer>get()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_colroot = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group6.runMethod(false,"Get",index6));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 92;BA.debugLine="If colroot.Get(\"dispositivo\") = Main.list.Get(a";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("dispositivo")))),monitor_activity.mostCurrent._main._list /*RemoteObject*/ .runMethod(false,"Get",(Object)(BA.numberCast(int.class, _a))))) { 
 BA.debugLineNum = 94;BA.debugLine="Dim fechaEntra As Long = colroot.Get(\"fecha\")";
Debug.ShouldStop(536870912);
_fechaentra = BA.numberCast(long.class, _colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha")))));Debug.locals.put("fechaEntra", _fechaentra);Debug.locals.put("fechaEntra", _fechaentra);
 BA.debugLineNum = 95;BA.debugLine="If fechaEntra >= fecha Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("g",_fechaentra,_fecha)) { 
 BA.debugLineNum = 96;BA.debugLine="Dim estado As String = colroot.Get(\"estado\")";
Debug.ShouldStop(-2147483648);
_estado = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("estado")))));Debug.locals.put("estado", _estado);Debug.locals.put("estado", _estado);
 BA.debugLineNum = 97;BA.debugLine="fecha = fechaEntra";
Debug.ShouldStop(1);
_fecha = _fechaentra;Debug.locals.put("fecha", _fecha);
 };
 };
 }
}Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 101;BA.debugLine="If estado = False Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_estado,BA.ObjectToString(monitor_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 102;BA.debugLine="disFallando.Add(Main.list.Get(a))";
Debug.ShouldStop(32);
monitor_activity.mostCurrent._disfallando.runVoidMethod ("Add",(Object)(monitor_activity.mostCurrent._main._list /*RemoteObject*/ .runMethod(false,"Get",(Object)(BA.numberCast(int.class, _a)))));
 };
 BA.debugLineNum = 104;BA.debugLine="fecha = 0";
Debug.ShouldStop(128);
_fecha = BA.numberCast(long.class, 0);Debug.locals.put("fecha", _fecha);
 }
}Debug.locals.put("a", _a);
;
 BA.debugLineNum = 107;BA.debugLine="backendelessGet.Initialize(\"get\",Me)";
Debug.ShouldStop(1024);
monitor_activity._backendelessget.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,monitor_activity.processBA,(Object)(BA.ObjectToString("get")),(Object)(monitor_activity.getObject()));
 BA.debugLineNum = 108;BA.debugLine="backendelessGet.Download(urlGet)   'Cuando comple";
Debug.ShouldStop(2048);
monitor_activity._backendelessget.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(monitor_activity.mostCurrent._urlget));
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private lvElectro As CustomListView";
monitor_activity.mostCurrent._lvelectro = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 17;BA.debugLine="Private lbDispositivo As B4XView";
monitor_activity.mostCurrent._lbdispositivo = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim urlGet As String";
monitor_activity.mostCurrent._urlget = RemoteObject.createImmutable("");
 //BA.debugLineNum = 19;BA.debugLine="Dim i As Int";
monitor_activity._i = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 20;BA.debugLine="Dim listAlterna As List";
monitor_activity.mostCurrent._listalterna = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 21;BA.debugLine="Dim historial As HttpJob";
monitor_activity.mostCurrent._historial = RemoteObject.createNew ("b4a.example.httpjob");
 //BA.debugLineNum = 22;BA.debugLine="Dim urlHistorial As String";
monitor_activity.mostCurrent._urlhistorial = RemoteObject.createImmutable("");
 //BA.debugLineNum = 23;BA.debugLine="Dim disFallando As List";
monitor_activity.mostCurrent._disfallando = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (monitor_activity) ","monitor_activity",4,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,53);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 53;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(2097152);
monitor_activity.mostCurrent.__c.runVoidMethod ("LogImpl","72686977",RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname" /*RemoteObject*/ ),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success" /*RemoteObject*/ )),0);
 BA.debugLineNum = 55;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),monitor_activity.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 56;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
Debug.ShouldStop(8388608);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("get"),BA.ObjectToString("historial"))) {
case 0: {
 BA.debugLineNum = 58;BA.debugLine="cargarValores(Job.GetString) 'se envia la cade";
Debug.ShouldStop(33554432);
_cargarvalores(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ));
 break; }
case 1: {
 BA.debugLineNum = 60;BA.debugLine="fallando(Job.GetString)";
Debug.ShouldStop(134217728);
_fallando(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ));
 break; }
}
;
 }else {
 BA.debugLineNum = 63;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(1073741824);
monitor_activity.mostCurrent.__c.runVoidMethod ("LogImpl","72686986",RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )),0);
 BA.debugLineNum = 64;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(-2147483648);
monitor_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(monitor_activity.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 66;BA.debugLine="Job.Release";
Debug.ShouldStop(2);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
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
public static RemoteObject  _lvelectro_itemclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("lvElectro_ItemClick (monitor_activity) ","monitor_activity",4,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,127);
if (RapidSub.canDelegate("lvelectro_itemclick")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","lvelectro_itemclick", _index, _value);}
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 127;BA.debugLine="Sub lvElectro_ItemClick (Index As Int, Value As Ob";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 128;BA.debugLine="nombreD = listAlterna.Get(Value)";
Debug.ShouldStop(-2147483648);
monitor_activity._nombred = BA.ObjectToString(monitor_activity.mostCurrent._listalterna.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _value))));
 BA.debugLineNum = 129;BA.debugLine="StartActivity(Datos_Activity)";
Debug.ShouldStop(1);
monitor_activity.mostCurrent.__c.runVoidMethod ("StartActivity",monitor_activity.processBA,(Object)((monitor_activity.mostCurrent._datos_activity.getObject())));
 BA.debugLineNum = 130;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim backendelessGet As HttpJob 'se debe inicializ";
monitor_activity._backendelessget = RemoteObject.createNew ("b4a.example.httpjob");
 //BA.debugLineNum = 10;BA.debugLine="Dim nombreD As String";
monitor_activity._nombred = RemoteObject.createImmutable("");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setstatusbarcolor(RemoteObject _clr) throws Exception{
try {
		Debug.PushSubsStack("SetStatusBarColor (monitor_activity) ","monitor_activity",4,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,132);
if (RapidSub.canDelegate("setstatusbarcolor")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","setstatusbarcolor", _clr);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _window = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("clr", _clr);
 BA.debugLineNum = 132;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
Debug.ShouldStop(8);
 BA.debugLineNum = 133;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(16);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 134;BA.debugLine="If p.SdkVersion >= 21 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 21))) { 
 BA.debugLineNum = 135;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(64);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 136;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(128);
_jo.runVoidMethod ("InitializeContext",monitor_activity.processBA);
 BA.debugLineNum = 137;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
Debug.ShouldStop(256);
_window = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_window = _jo.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getWindow")),(Object)((monitor_activity.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("window", _window);Debug.locals.put("window", _window);
 BA.debugLineNum = 138;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
Debug.ShouldStop(512);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("addFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x80000000))})));
 BA.debugLineNum = 139;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
Debug.ShouldStop(1024);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("clearFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x04000000))})));
 BA.debugLineNum = 140;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
Debug.ShouldStop(2048);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setStatusBarColor")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_clr)})));
 };
 BA.debugLineNum = 142;BA.debugLine="If p.SdkVersion >= 23 Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 23))) { 
 BA.debugLineNum = 143;BA.debugLine="jo = Activity";
Debug.ShouldStop(16384);
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), monitor_activity.mostCurrent._activity.getObject());
 BA.debugLineNum = 144;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
Debug.ShouldStop(32768);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setSystemUiVisibility")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((8192))})));
 };
 BA.debugLineNum = 146;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}