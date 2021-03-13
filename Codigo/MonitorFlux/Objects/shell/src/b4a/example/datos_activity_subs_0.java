package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class datos_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (datos_activity) ","datos_activity",4,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 30;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(536870912);
datos_activity.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 31;BA.debugLine="Activity.LoadLayout(\"Datos\")";
Debug.ShouldStop(1073741824);
datos_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Datos")),datos_activity.mostCurrent.activityBA);
 BA.debugLineNum = 32;BA.debugLine="urlGet = \"https://api.backendless.com/85B70858-21";
Debug.ShouldStop(-2147483648);
datos_activity.mostCurrent._urlget = BA.ObjectToString("https://api.backendless.com/85B70858-2193-2A92-FF8E-BF8B113D4100/CC232E12-9D6D-40A6-A41A-23796B090767/data/Dispositivos");
 BA.debugLineNum = 33;BA.debugLine="urlHistorial = \"https://api.backendless.com/85B70";
Debug.ShouldStop(1);
datos_activity.mostCurrent._urlhistorial = BA.ObjectToString("https://api.backendless.com/85B70858-2193-2A92-FF8E-BF8B113D4100/CC232E12-9D6D-40A6-A41A-23796B090767/data/Historial");
 BA.debugLineNum = 34;BA.debugLine="backendelessGet.Initialize(\"get\",Me)";
Debug.ShouldStop(2);
datos_activity.mostCurrent._backendelessget.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,datos_activity.processBA,(Object)(BA.ObjectToString("get")),(Object)(datos_activity.getObject()));
 BA.debugLineNum = 35;BA.debugLine="historial.Initialize(\"historial\",Me)";
Debug.ShouldStop(4);
datos_activity.mostCurrent._historial.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,datos_activity.processBA,(Object)(BA.ObjectToString("historial")),(Object)(datos_activity.getObject()));
 BA.debugLineNum = 36;BA.debugLine="backendelessGet.Download(urlGet)";
Debug.ShouldStop(8);
datos_activity.mostCurrent._backendelessget.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(datos_activity.mostCurrent._urlget));
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_Pause (datos_activity) ","datos_activity",4,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,43);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Activity_Resume (datos_activity) ","datos_activity",4,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,39);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","activity_resume");}
 BA.debugLineNum = 39;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(64);
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnatrase_click() throws Exception{
try {
		Debug.PushSubsStack("btnAtrasE_Click (datos_activity) ","datos_activity",4,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,48);
if (RapidSub.canDelegate("btnatrase_click")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","btnatrase_click");}
 BA.debugLineNum = 48;BA.debugLine="Sub btnAtrasE_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
datos_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cargardatos(RemoteObject _res) throws Exception{
try {
		Debug.PushSubsStack("cargarDatos (datos_activity) ","datos_activity",4,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,68);
if (RapidSub.canDelegate("cargardatos")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","cargardatos", _res);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _nombre = RemoteObject.createImmutable("");
RemoteObject _descripcion = RemoteObject.createImmutable("");
RemoteObject _numero = RemoteObject.createImmutable("");
Debug.locals.put("res", _res);
 BA.debugLineNum = 68;BA.debugLine="Sub cargarDatos (res As String)";
Debug.ShouldStop(8);
 BA.debugLineNum = 69;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(16);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 70;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(32);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 73;BA.debugLine="Dim root As List = parser.NextArray";
Debug.ShouldStop(256);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = _parser.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 74;BA.debugLine="For Each colroot As Map In root				'map es simila";
Debug.ShouldStop(512);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group4 = _root;
final int groupLen4 = group4.runMethod(true,"getSize").<Integer>get()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_colroot = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group4.runMethod(false,"Get",index4));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 75;BA.debugLine="If colroot.Get(\"nombre\") = Monitor_Activity.nomb";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nombre")))),(datos_activity.mostCurrent._monitor_activity._nombred /*RemoteObject*/ ))) { 
 BA.debugLineNum = 76;BA.debugLine="Dim nombre As String = colroot.Get(\"nombre\")";
Debug.ShouldStop(2048);
_nombre = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nombre")))));Debug.locals.put("nombre", _nombre);Debug.locals.put("nombre", _nombre);
 BA.debugLineNum = 77;BA.debugLine="Dim descripcion As String = colroot.Get(\"descri";
Debug.ShouldStop(4096);
_descripcion = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("descripcion")))));Debug.locals.put("descripcion", _descripcion);Debug.locals.put("descripcion", _descripcion);
 BA.debugLineNum = 78;BA.debugLine="Dim numero As String = colroot.Get(\"numero\")";
Debug.ShouldStop(8192);
_numero = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("numero")))));Debug.locals.put("numero", _numero);Debug.locals.put("numero", _numero);
 };
 }
}Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 81;BA.debugLine="lbNombre.Text = nombre";
Debug.ShouldStop(65536);
datos_activity.mostCurrent._lbnombre.runMethod(true,"setText",BA.ObjectToCharSequence(_nombre));
 BA.debugLineNum = 82;BA.debugLine="lbNumero.Text = numero";
Debug.ShouldStop(131072);
datos_activity.mostCurrent._lbnumero.runMethod(true,"setText",BA.ObjectToCharSequence(_numero));
 BA.debugLineNum = 83;BA.debugLine="lbDescrip.Text = descripcion";
Debug.ShouldStop(262144);
datos_activity.mostCurrent._lbdescrip.runMethod(true,"setText",BA.ObjectToCharSequence(_descripcion));
 BA.debugLineNum = 84;BA.debugLine="historial.Download(urlHistorial)";
Debug.ShouldStop(524288);
datos_activity.mostCurrent._historial.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(datos_activity.mostCurrent._urlhistorial));
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
public static RemoteObject  _cargarestado(RemoteObject _res) throws Exception{
try {
		Debug.PushSubsStack("cargarEstado (datos_activity) ","datos_activity",4,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,87);
if (RapidSub.canDelegate("cargarestado")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","cargarestado", _res);}
RemoteObject _fecha = RemoteObject.createImmutable(0);
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _fechaentra = RemoteObject.createImmutable(0);
RemoteObject _estado = RemoteObject.createImmutable("");
RemoteObject _flujo = RemoteObject.createImmutable("");
RemoteObject _fechaactual = RemoteObject.createImmutable(0L);
RemoteObject _actual = RemoteObject.createImmutable(0);
RemoteObject _mensaje = RemoteObject.createImmutable("");
Debug.locals.put("res", _res);
 BA.debugLineNum = 87;BA.debugLine="Sub cargarEstado (res As String)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="Dim fecha As Int = 0";
Debug.ShouldStop(8388608);
_fecha = BA.numberCast(int.class, 0);Debug.locals.put("fecha", _fecha);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 89;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(16777216);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 90;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(33554432);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 93;BA.debugLine="Dim root As List = parser.NextArray";
Debug.ShouldStop(268435456);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = _parser.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 94;BA.debugLine="For Each colroot As Map In root				'map es simila";
Debug.ShouldStop(536870912);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group5 = _root;
final int groupLen5 = group5.runMethod(true,"getSize").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_colroot = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group5.runMethod(false,"Get",index5));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 95;BA.debugLine="If colroot.Get(\"dispositivo\") = lbNombre.Text Th";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("dispositivo")))),(datos_activity.mostCurrent._lbnombre.runMethod(true,"getText")))) { 
 BA.debugLineNum = 96;BA.debugLine="Dim fechaEntra As Int = colroot.Get(\"fecha\")";
Debug.ShouldStop(-2147483648);
_fechaentra = BA.numberCast(int.class, _colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha")))));Debug.locals.put("fechaEntra", _fechaentra);Debug.locals.put("fechaEntra", _fechaentra);
 BA.debugLineNum = 97;BA.debugLine="If fechaEntra >= fecha Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("g",_fechaentra,BA.numberCast(double.class, _fecha))) { 
 BA.debugLineNum = 98;BA.debugLine="Dim estado As String = colroot.Get(\"estado\")";
Debug.ShouldStop(2);
_estado = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("estado")))));Debug.locals.put("estado", _estado);Debug.locals.put("estado", _estado);
 BA.debugLineNum = 99;BA.debugLine="Dim flujo As String = colroot.Get(\"flujo\")";
Debug.ShouldStop(4);
_flujo = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("flujo")))));Debug.locals.put("flujo", _flujo);Debug.locals.put("flujo", _flujo);
 BA.debugLineNum = 100;BA.debugLine="fecha = colroot.Get(\"fecha\")";
Debug.ShouldStop(8);
_fecha = BA.numberCast(int.class, _colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha")))));Debug.locals.put("fecha", _fecha);
 };
 };
 }
}Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 104;BA.debugLine="If estado = True Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_estado,BA.ObjectToString(datos_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 105;BA.debugLine="lbEstado.Text = \"Encendido\"";
Debug.ShouldStop(256);
datos_activity.mostCurrent._lbestado.runMethod(true,"setText",BA.ObjectToCharSequence("Encendido"));
 BA.debugLineNum = 106;BA.debugLine="lbEstado.Color = Colors.ARGB(128,0,136,145)";
Debug.ShouldStop(512);
datos_activity.mostCurrent._lbestado.runVoidMethod ("setColor",datos_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 136)),(Object)(BA.numberCast(int.class, 145))));
 }else 
{ BA.debugLineNum = 107;BA.debugLine="Else If estado = False Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_estado,BA.ObjectToString(datos_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 108;BA.debugLine="lbEstado.Text = \"Apagado\"";
Debug.ShouldStop(2048);
datos_activity.mostCurrent._lbestado.runMethod(true,"setText",BA.ObjectToCharSequence("Apagado"));
 BA.debugLineNum = 109;BA.debugLine="lbEstado.Color = Colors.ARGB(128,240,84,84)";
Debug.ShouldStop(4096);
datos_activity.mostCurrent._lbestado.runVoidMethod ("setColor",datos_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 84)),(Object)(BA.numberCast(int.class, 84))));
 }}
;
 BA.debugLineNum = 111;BA.debugLine="lbFlujo.Text = flujo & \" Litros/Hora\"";
Debug.ShouldStop(16384);
datos_activity.mostCurrent._lbflujo.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_flujo,RemoteObject.createImmutable(" Litros/Hora"))));
 BA.debugLineNum = 113;BA.debugLine="DateTime.DateFormat = \"yyyyMMddHHmm\"";
Debug.ShouldStop(65536);
datos_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("yyyyMMddHHmm"));
 BA.debugLineNum = 114;BA.debugLine="Dim fechaActual As Long = DateTime.Date(DateTime.";
Debug.ShouldStop(131072);
_fechaactual = BA.numberCast(long.class, datos_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(datos_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));Debug.locals.put("fechaActual", _fechaactual);Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 115;BA.debugLine="Dim actual As Int = fechaActual - fecha";
Debug.ShouldStop(262144);
_actual = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,_fecha}, "-",1, 2));Debug.locals.put("actual", _actual);Debug.locals.put("actual", _actual);
 BA.debugLineNum = 116;BA.debugLine="Dim mensaje As String";
Debug.ShouldStop(524288);
_mensaje = RemoteObject.createImmutable("");Debug.locals.put("mensaje", _mensaje);
 BA.debugLineNum = 117;BA.debugLine="If actual <= 30 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("k",_actual,BA.numberCast(double.class, 30))) { 
 BA.debugLineNum = 118;BA.debugLine="mensaje = \"Actualizado hace menos de 30 minutos\"";
Debug.ShouldStop(2097152);
_mensaje = BA.ObjectToString("Actualizado hace menos de 30 minutos");Debug.locals.put("mensaje", _mensaje);
 }else 
{ BA.debugLineNum = 119;BA.debugLine="Else If actual <= 100 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("k",_actual,BA.numberCast(double.class, 100))) { 
 BA.debugLineNum = 120;BA.debugLine="mensaje = \"Actualizado hace 1 hora\"";
Debug.ShouldStop(8388608);
_mensaje = BA.ObjectToString("Actualizado hace 1 hora");Debug.locals.put("mensaje", _mensaje);
 }else 
{ BA.debugLineNum = 121;BA.debugLine="Else If actual <= 400 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("k",_actual,BA.numberCast(double.class, 400))) { 
 BA.debugLineNum = 122;BA.debugLine="mensaje = \"Actualizado hace 4 horas\"";
Debug.ShouldStop(33554432);
_mensaje = BA.ObjectToString("Actualizado hace 4 horas");Debug.locals.put("mensaje", _mensaje);
 }else 
{ BA.debugLineNum = 123;BA.debugLine="Else If actual <= 1200 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("k",_actual,BA.numberCast(double.class, 1200))) { 
 BA.debugLineNum = 124;BA.debugLine="mensaje = \"Actualizado hace menos de 12 horas\"";
Debug.ShouldStop(134217728);
_mensaje = BA.ObjectToString("Actualizado hace menos de 12 horas");Debug.locals.put("mensaje", _mensaje);
 }else 
{ BA.debugLineNum = 125;BA.debugLine="Else If	actual <= 10000 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("k",_actual,BA.numberCast(double.class, 10000))) { 
 BA.debugLineNum = 126;BA.debugLine="mensaje = \"Actualizado hace 1 dia\"";
Debug.ShouldStop(536870912);
_mensaje = BA.ObjectToString("Actualizado hace 1 dia");Debug.locals.put("mensaje", _mensaje);
 }else {
 BA.debugLineNum = 128;BA.debugLine="mensaje = \"Desactualizado\"";
Debug.ShouldStop(-2147483648);
_mensaje = BA.ObjectToString("Desactualizado");Debug.locals.put("mensaje", _mensaje);
 }}}}}
;
 BA.debugLineNum = 130;BA.debugLine="lbActualizado.Text = mensaje";
Debug.ShouldStop(2);
datos_activity.mostCurrent._lbactualizado.runMethod(true,"setText",BA.ObjectToCharSequence(_mensaje));
 BA.debugLineNum = 131;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim backendelessGet As HttpJob 'se debe inicializ";
datos_activity.mostCurrent._backendelessget = RemoteObject.createNew ("b4a.example.httpjob");
 //BA.debugLineNum = 16;BA.debugLine="Dim historial As HttpJob";
datos_activity.mostCurrent._historial = RemoteObject.createNew ("b4a.example.httpjob");
 //BA.debugLineNum = 17;BA.debugLine="Private lbNombre As Label";
datos_activity.mostCurrent._lbnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim urlGet As String";
datos_activity.mostCurrent._urlget = RemoteObject.createImmutable("");
 //BA.debugLineNum = 19;BA.debugLine="Dim urlHistorial As String";
datos_activity.mostCurrent._urlhistorial = RemoteObject.createImmutable("");
 //BA.debugLineNum = 20;BA.debugLine="Private lbNumero As Label";
datos_activity.mostCurrent._lbnumero = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private lbDescrip As Label";
datos_activity.mostCurrent._lbdescrip = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lbEstado As Label";
datos_activity.mostCurrent._lbestado = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lbFlujo As Label";
datos_activity.mostCurrent._lbflujo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private lbActualizado As Label";
datos_activity.mostCurrent._lbactualizado = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (datos_activity) ","datos_activity",4,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,52);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 52;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(1048576);
datos_activity.mostCurrent.__c.runVoidMethod ("LogImpl","36684673",RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname" /*RemoteObject*/ ),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success" /*RemoteObject*/ )),0);
 BA.debugLineNum = 54;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),datos_activity.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 55;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
Debug.ShouldStop(4194304);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("get"),BA.ObjectToString("historial"))) {
case 0: {
 BA.debugLineNum = 57;BA.debugLine="cargarDatos(Job.GetString) 'se envia la cadena";
Debug.ShouldStop(16777216);
_cargardatos(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ));
 break; }
case 1: {
 BA.debugLineNum = 59;BA.debugLine="cargarEstado(Job.GetString)";
Debug.ShouldStop(67108864);
_cargarestado(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ));
 break; }
}
;
 }else {
 BA.debugLineNum = 62;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(536870912);
datos_activity.mostCurrent.__c.runVoidMethod ("LogImpl","36684682",RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )),0);
 BA.debugLineNum = 63;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(1073741824);
datos_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(datos_activity.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 65;BA.debugLine="Job.Release";
Debug.ShouldStop(1);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 66;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}