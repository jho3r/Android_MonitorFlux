package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class datos_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,27);
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
 BA.debugLineNum = 32;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
Debug.ShouldStop(-2147483648);
_setstatusbarcolor(datos_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 222))));
 BA.debugLineNum = 33;BA.debugLine="urlGet = \"https://api.backendless.com/85B70858-21";
Debug.ShouldStop(1);
datos_activity.mostCurrent._urlget = BA.ObjectToString("https://api.backendless.com/85B70858-2193-2A92-FF8E-BF8B113D4100/CC232E12-9D6D-40A6-A41A-23796B090767/data/Dispositivos");
 BA.debugLineNum = 34;BA.debugLine="urlHistorial = \"https://api.backendless.com/85B70";
Debug.ShouldStop(2);
datos_activity.mostCurrent._urlhistorial = BA.ObjectToString("https://api.backendless.com/85B70858-2193-2A92-FF8E-BF8B113D4100/CC232E12-9D6D-40A6-A41A-23796B090767/data/Historial");
 BA.debugLineNum = 35;BA.debugLine="backendelessGet.Initialize(\"get\",Me)";
Debug.ShouldStop(4);
datos_activity.mostCurrent._backendelessget.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,datos_activity.processBA,(Object)(BA.ObjectToString("get")),(Object)(datos_activity.getObject()));
 BA.debugLineNum = 36;BA.debugLine="historial.Initialize(\"historial\",Me)";
Debug.ShouldStop(8);
datos_activity.mostCurrent._historial.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,datos_activity.processBA,(Object)(BA.ObjectToString("historial")),(Object)(datos_activity.getObject()));
 BA.debugLineNum = 37;BA.debugLine="backendelessGet.Download(urlGet)			'para cargar l";
Debug.ShouldStop(16);
datos_activity.mostCurrent._backendelessget.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(datos_activity.mostCurrent._urlget));
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
		Debug.PushSubsStack("Activity_Pause (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,44);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,40);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","activity_resume");}
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
public static RemoteObject  _btnatrase_click() throws Exception{
try {
		Debug.PushSubsStack("btnAtrasE_Click (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,49);
if (RapidSub.canDelegate("btnatrase_click")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","btnatrase_click");}
 BA.debugLineNum = 49;BA.debugLine="Sub btnAtrasE_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="Activity.Finish";
Debug.ShouldStop(131072);
datos_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _cargardatos(RemoteObject _res) throws Exception{
try {
		Debug.PushSubsStack("cargarDatos (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,71);
if (RapidSub.canDelegate("cargardatos")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","cargardatos", _res);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _nombre = RemoteObject.createImmutable("");
RemoteObject _descripcion = RemoteObject.createImmutable("");
RemoteObject _numero = RemoteObject.createImmutable("");
Debug.locals.put("res", _res);
 BA.debugLineNum = 71;BA.debugLine="Sub cargarDatos (res As String)";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(128);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 73;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(256);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 76;BA.debugLine="Dim root As List = parser.NextArray";
Debug.ShouldStop(2048);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = _parser.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 77;BA.debugLine="For Each colroot As Map In root				'map es simila";
Debug.ShouldStop(4096);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group4 = _root;
final int groupLen4 = group4.runMethod(true,"getSize").<Integer>get()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_colroot = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group4.runMethod(false,"Get",index4));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 78;BA.debugLine="If colroot.Get(\"nombre\") = Monitor_Activity.nomb";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nombre")))),(datos_activity.mostCurrent._monitor_activity._nombred /*RemoteObject*/ ))) { 
 BA.debugLineNum = 79;BA.debugLine="Dim nombre As String = colroot.Get(\"nombre\")";
Debug.ShouldStop(16384);
_nombre = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nombre")))));Debug.locals.put("nombre", _nombre);Debug.locals.put("nombre", _nombre);
 BA.debugLineNum = 80;BA.debugLine="Dim descripcion As String = colroot.Get(\"descri";
Debug.ShouldStop(32768);
_descripcion = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("descripcion")))));Debug.locals.put("descripcion", _descripcion);Debug.locals.put("descripcion", _descripcion);
 BA.debugLineNum = 81;BA.debugLine="Dim numero As String = colroot.Get(\"numero\")";
Debug.ShouldStop(65536);
_numero = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("numero")))));Debug.locals.put("numero", _numero);Debug.locals.put("numero", _numero);
 };
 }
}Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 85;BA.debugLine="lbNombre.Text = nombre";
Debug.ShouldStop(1048576);
datos_activity.mostCurrent._lbnombre.runMethod(true,"setText",BA.ObjectToCharSequence(_nombre));
 BA.debugLineNum = 86;BA.debugLine="lbNumero.Text = numero";
Debug.ShouldStop(2097152);
datos_activity.mostCurrent._lbnumero.runMethod(true,"setText",BA.ObjectToCharSequence(_numero));
 BA.debugLineNum = 87;BA.debugLine="lbDescrip.Text = descripcion";
Debug.ShouldStop(4194304);
datos_activity.mostCurrent._lbdescrip.runMethod(true,"setText",BA.ObjectToCharSequence(_descripcion));
 BA.debugLineNum = 88;BA.debugLine="historial.Download(urlHistorial)";
Debug.ShouldStop(8388608);
datos_activity.mostCurrent._historial.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(datos_activity.mostCurrent._urlhistorial));
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
public static RemoteObject  _cargarestado(RemoteObject _res) throws Exception{
try {
		Debug.PushSubsStack("cargarEstado (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,92);
if (RapidSub.canDelegate("cargarestado")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","cargarestado", _res);}
RemoteObject _fecha = RemoteObject.createImmutable(0L);
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _fechaentra = RemoteObject.createImmutable(0L);
RemoteObject _estado = RemoteObject.createImmutable("");
RemoteObject _flujo = RemoteObject.createImmutable("");
Debug.locals.put("res", _res);
 BA.debugLineNum = 92;BA.debugLine="Sub cargarEstado (res As String)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="Dim fecha As Long = 0";
Debug.ShouldStop(268435456);
_fecha = BA.numberCast(long.class, 0);Debug.locals.put("fecha", _fecha);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 94;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(536870912);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 95;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(1073741824);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 98;BA.debugLine="Dim root As List = parser.NextArray";
Debug.ShouldStop(2);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = _parser.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 99;BA.debugLine="For Each colroot As Map In root				'map es simila";
Debug.ShouldStop(4);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group5 = _root;
final int groupLen5 = group5.runMethod(true,"getSize").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_colroot = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group5.runMethod(false,"Get",index5));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 101;BA.debugLine="If colroot.Get(\"dispositivo\") = lbNombre.Text Th";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("dispositivo")))),(datos_activity.mostCurrent._lbnombre.runMethod(true,"getText")))) { 
 BA.debugLineNum = 103;BA.debugLine="Dim fechaEntra As Long = colroot.Get(\"fecha\")";
Debug.ShouldStop(64);
_fechaentra = BA.numberCast(long.class, _colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha")))));Debug.locals.put("fechaEntra", _fechaentra);Debug.locals.put("fechaEntra", _fechaentra);
 BA.debugLineNum = 104;BA.debugLine="If fechaEntra >= fecha Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("g",_fechaentra,_fecha)) { 
 BA.debugLineNum = 105;BA.debugLine="Dim estado As String = colroot.Get(\"estado\")";
Debug.ShouldStop(256);
_estado = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("estado")))));Debug.locals.put("estado", _estado);Debug.locals.put("estado", _estado);
 BA.debugLineNum = 106;BA.debugLine="Dim flujo As String = colroot.Get(\"flujo\")";
Debug.ShouldStop(512);
_flujo = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("flujo")))));Debug.locals.put("flujo", _flujo);Debug.locals.put("flujo", _flujo);
 BA.debugLineNum = 107;BA.debugLine="fecha = fechaEntra";
Debug.ShouldStop(1024);
_fecha = _fechaentra;Debug.locals.put("fecha", _fecha);
 };
 };
 }
}Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 112;BA.debugLine="If estado = True Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_estado,BA.ObjectToString(datos_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 113;BA.debugLine="lbEstado.Text = \"Encendido\"";
Debug.ShouldStop(65536);
datos_activity.mostCurrent._lbestado.runMethod(true,"setText",BA.ObjectToCharSequence("Encendido"));
 BA.debugLineNum = 114;BA.debugLine="lbEstado.Color = Colors.ARGB(128,0,136,145)";
Debug.ShouldStop(131072);
datos_activity.mostCurrent._lbestado.runVoidMethod ("setColor",datos_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 136)),(Object)(BA.numberCast(int.class, 145))));
 }else 
{ BA.debugLineNum = 115;BA.debugLine="Else If estado = False Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_estado,BA.ObjectToString(datos_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 116;BA.debugLine="lbEstado.Text = \"Apagado\"";
Debug.ShouldStop(524288);
datos_activity.mostCurrent._lbestado.runMethod(true,"setText",BA.ObjectToCharSequence("Apagado"));
 BA.debugLineNum = 117;BA.debugLine="lbEstado.Color = Colors.ARGB(128,240,84,84)";
Debug.ShouldStop(1048576);
datos_activity.mostCurrent._lbestado.runVoidMethod ("setColor",datos_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 84)),(Object)(BA.numberCast(int.class, 84))));
 }}
;
 BA.debugLineNum = 121;BA.debugLine="lbFlujo.Text = flujo & \" Litros/Hora\"";
Debug.ShouldStop(16777216);
datos_activity.mostCurrent._lbflujo.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_flujo,RemoteObject.createImmutable(" Litros/Hora"))));
 BA.debugLineNum = 124;BA.debugLine="diferenciaDeFechas(fecha)";
Debug.ShouldStop(134217728);
_diferenciadefechas(_fecha);
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
public static RemoteObject  _diferenciadefechas(RemoteObject _fecha) throws Exception{
try {
		Debug.PushSubsStack("diferenciaDeFechas (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,127);
if (RapidSub.canDelegate("diferenciadefechas")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","diferenciadefechas", _fecha);}
RemoteObject _fechaactual = RemoteObject.createImmutable(0L);
RemoteObject _actual = RemoteObject.createImmutable(0L);
RemoteObject _actualmodificado = RemoteObject.createImmutable(0L);
RemoteObject _mensaje = RemoteObject.createImmutable("");
Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 127;BA.debugLine="Sub diferenciaDeFechas(fecha As Long){";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 129;BA.debugLine="DateTime.DateFormat = \"yyyyMMddHHmm\"";
Debug.ShouldStop(1);
datos_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("yyyyMMddHHmm"));
 BA.debugLineNum = 130;BA.debugLine="Dim fechaActual As Long = DateTime.Date(DateTime.";
Debug.ShouldStop(2);
_fechaactual = BA.numberCast(long.class, datos_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(datos_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));Debug.locals.put("fechaActual", _fechaactual);Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 131;BA.debugLine="Dim actual As Long = fechaActual - fecha";
Debug.ShouldStop(4);
_actual = RemoteObject.solve(new RemoteObject[] {_fechaactual,_fecha}, "-",1, 2);Debug.locals.put("actual", _actual);Debug.locals.put("actual", _actual);
 BA.debugLineNum = 132;BA.debugLine="Dim actualModificado As Long";
Debug.ShouldStop(8);
_actualmodificado = RemoteObject.createImmutable(0L);Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 133;BA.debugLine="Dim mensaje As String";
Debug.ShouldStop(16);
_mensaje = RemoteObject.createImmutable("");Debug.locals.put("mensaje", _mensaje);
 BA.debugLineNum = 135;BA.debugLine="If actual < 100 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("<",_actual,BA.numberCast(long.class, 100))) { 
 BA.debugLineNum = 136;BA.debugLine="actualModificado = fechaActual/100";
Debug.ShouldStop(128);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(100)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 137;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
Debug.ShouldStop(256);
_fechaactual = RemoteObject.solve(new RemoteObject[] {_fechaactual,_actualmodificado,RemoteObject.createImmutable(100)}, "-*",1, 2);Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 138;BA.debugLine="actualModificado = fecha/100";
Debug.ShouldStop(512);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fecha,RemoteObject.createImmutable(100)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 139;BA.debugLine="fecha = fecha - actualModificado*100";
Debug.ShouldStop(1024);
_fecha = RemoteObject.solve(new RemoteObject[] {_fecha,_actualmodificado,RemoteObject.createImmutable(100)}, "-*",1, 2);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 140;BA.debugLine="If fecha < fechaActual Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("<",_fecha,_fechaactual)) { 
 BA.debugLineNum = 141;BA.debugLine="actualModificado = fechaActual - fecha";
Debug.ShouldStop(4096);
_actualmodificado = RemoteObject.solve(new RemoteObject[] {_fechaactual,_fecha}, "-",1, 2);Debug.locals.put("actualModificado", _actualmodificado);
 }else {
 BA.debugLineNum = 143;BA.debugLine="actualModificado = fechaActual + (60 - fecha)";
Debug.ShouldStop(16384);
_actualmodificado = RemoteObject.solve(new RemoteObject[] {_fechaactual,(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(60),_fecha}, "-",1, 2))}, "+",1, 2);Debug.locals.put("actualModificado", _actualmodificado);
 };
 BA.debugLineNum = 146;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
Debug.ShouldStop(131072);
_mensaje = RemoteObject.concat(RemoteObject.createImmutable("Actualizado hace "),_actualmodificado,RemoteObject.createImmutable(" minutos"));Debug.locals.put("mensaje", _mensaje);
 }else 
{ BA.debugLineNum = 148;BA.debugLine="Else If actual < 10000 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("<",_actual,BA.numberCast(long.class, 10000))) { 
 BA.debugLineNum = 149;BA.debugLine="actualModificado = fechaActual/10000";
Debug.ShouldStop(1048576);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(10000)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 150;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
Debug.ShouldStop(2097152);
_fechaactual = RemoteObject.solve(new RemoteObject[] {_fechaactual,_actualmodificado,RemoteObject.createImmutable(10000)}, "-*",1, 2);Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 151;BA.debugLine="actualModificado = fecha/10000";
Debug.ShouldStop(4194304);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fecha,RemoteObject.createImmutable(10000)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 152;BA.debugLine="fecha = fecha - actualModificado*10000";
Debug.ShouldStop(8388608);
_fecha = RemoteObject.solve(new RemoteObject[] {_fecha,_actualmodificado,RemoteObject.createImmutable(10000)}, "-*",1, 2);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 153;BA.debugLine="Log(fechaActual)";
Debug.ShouldStop(16777216);
datos_activity.mostCurrent.__c.runVoidMethod ("LogImpl","43604506",BA.NumberToString(_fechaactual),0);
 BA.debugLineNum = 154;BA.debugLine="Log(fecha)";
Debug.ShouldStop(33554432);
datos_activity.mostCurrent.__c.runVoidMethod ("LogImpl","43604507",BA.NumberToString(_fecha),0);
 BA.debugLineNum = 155;BA.debugLine="If fecha < fechaActual Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("<",_fecha,_fechaactual)) { 
 BA.debugLineNum = 156;BA.debugLine="actualModificado = fechaActual/100 - fecha/100";
Debug.ShouldStop(134217728);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(100),_fecha,RemoteObject.createImmutable(100)}, "/-/",1, 0));Debug.locals.put("actualModificado", _actualmodificado);
 }else {
 BA.debugLineNum = 158;BA.debugLine="actualModificado = fechaActual/100 + (24 - fech";
Debug.ShouldStop(536870912);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(100),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(24),_fecha,RemoteObject.createImmutable(100)}, "-/",1, 0))}, "/+",1, 0));Debug.locals.put("actualModificado", _actualmodificado);
 };
 BA.debugLineNum = 161;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
Debug.ShouldStop(1);
_mensaje = RemoteObject.concat(RemoteObject.createImmutable("Actualizado hace "),_actualmodificado,RemoteObject.createImmutable(" horas"));Debug.locals.put("mensaje", _mensaje);
 }else 
{ BA.debugLineNum = 164;BA.debugLine="Else If actual < 1000000 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("<",_actual,BA.numberCast(long.class, 1000000))) { 
 BA.debugLineNum = 165;BA.debugLine="actualModificado = fechaActual/1000000";
Debug.ShouldStop(16);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(1000000)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 166;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
Debug.ShouldStop(32);
_fechaactual = RemoteObject.solve(new RemoteObject[] {_fechaactual,_actualmodificado,RemoteObject.createImmutable(1000000)}, "-*",1, 2);Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 167;BA.debugLine="actualModificado = fecha/1000000";
Debug.ShouldStop(64);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fecha,RemoteObject.createImmutable(1000000)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 168;BA.debugLine="fecha = fecha - actualModificado*1000000";
Debug.ShouldStop(128);
_fecha = RemoteObject.solve(new RemoteObject[] {_fecha,_actualmodificado,RemoteObject.createImmutable(1000000)}, "-*",1, 2);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 169;BA.debugLine="actualModificado = Abs(fechaActual - fecha)";
Debug.ShouldStop(256);
_actualmodificado = BA.numberCast(long.class, datos_activity.mostCurrent.__c.runMethod(true,"Abs",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,_fecha}, "-",1, 2)))));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 170;BA.debugLine="If fecha < fechaActual Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("<",_fecha,_fechaactual)) { 
 BA.debugLineNum = 171;BA.debugLine="actualModificado = fechaActual/10000 - fecha/10";
Debug.ShouldStop(1024);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(10000),_fecha,RemoteObject.createImmutable(10000)}, "/-/",1, 0));Debug.locals.put("actualModificado", _actualmodificado);
 }else {
 BA.debugLineNum = 173;BA.debugLine="actualModificado = fechaActual/10000 + (30 - fe";
Debug.ShouldStop(4096);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(10000),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(30),_fecha,RemoteObject.createImmutable(10000)}, "-/",1, 0))}, "/+",1, 0));Debug.locals.put("actualModificado", _actualmodificado);
 };
 BA.debugLineNum = 176;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
Debug.ShouldStop(32768);
_mensaje = RemoteObject.concat(RemoteObject.createImmutable("Actualizado hace "),_actualmodificado,RemoteObject.createImmutable(" dias"));Debug.locals.put("mensaje", _mensaje);
 }else 
{ BA.debugLineNum = 179;BA.debugLine="Else If actual < 100000000 Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("<",_actual,BA.numberCast(long.class, 100000000))) { 
 BA.debugLineNum = 180;BA.debugLine="actualModificado = fechaActual/100000000";
Debug.ShouldStop(524288);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(100000000)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 181;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
Debug.ShouldStop(1048576);
_fechaactual = RemoteObject.solve(new RemoteObject[] {_fechaactual,_actualmodificado,RemoteObject.createImmutable(100000000)}, "-*",1, 2);Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 182;BA.debugLine="actualModificado = fecha/100000000";
Debug.ShouldStop(2097152);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fecha,RemoteObject.createImmutable(100000000)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 183;BA.debugLine="fecha = fecha - actualModificado*100000000";
Debug.ShouldStop(4194304);
_fecha = RemoteObject.solve(new RemoteObject[] {_fecha,_actualmodificado,RemoteObject.createImmutable(100000000)}, "-*",1, 2);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 184;BA.debugLine="actualModificado = Abs(fechaActual - fecha)";
Debug.ShouldStop(8388608);
_actualmodificado = BA.numberCast(long.class, datos_activity.mostCurrent.__c.runMethod(true,"Abs",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,_fecha}, "-",1, 2)))));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 185;BA.debugLine="If fecha < fechaActual Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("<",_fecha,_fechaactual)) { 
 BA.debugLineNum = 186;BA.debugLine="actualModificado = fechaActual/1000000 - fecha/";
Debug.ShouldStop(33554432);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(1000000),_fecha,RemoteObject.createImmutable(1000000)}, "/-/",1, 0));Debug.locals.put("actualModificado", _actualmodificado);
 }else {
 BA.debugLineNum = 188;BA.debugLine="actualModificado = fechaActual/1000000 + (12 -";
Debug.ShouldStop(134217728);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(1000000),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(12),_fecha,RemoteObject.createImmutable(1000000)}, "-/",1, 0))}, "/+",1, 0));Debug.locals.put("actualModificado", _actualmodificado);
 };
 BA.debugLineNum = 191;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
Debug.ShouldStop(1073741824);
_mensaje = RemoteObject.concat(RemoteObject.createImmutable("Actualizado hace "),_actualmodificado,RemoteObject.createImmutable(" meses"));Debug.locals.put("mensaje", _mensaje);
 }else {
 BA.debugLineNum = 194;BA.debugLine="mensaje = \"Desactualizado\"";
Debug.ShouldStop(2);
_mensaje = BA.ObjectToString("Desactualizado");Debug.locals.put("mensaje", _mensaje);
 }}}}
;
 BA.debugLineNum = 196;BA.debugLine="lbActualizado.Text = mensaje";
Debug.ShouldStop(8);
datos_activity.mostCurrent._lbactualizado.runMethod(true,"setText",BA.ObjectToCharSequence(_mensaje));
 BA.debugLineNum = 197;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("JobDone (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,54);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 54;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(4194304);
datos_activity.mostCurrent.__c.runVoidMethod ("LogImpl","43407873",RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname" /*RemoteObject*/ ),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success" /*RemoteObject*/ )),0);
 BA.debugLineNum = 56;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),datos_activity.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 57;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
Debug.ShouldStop(16777216);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("get"),BA.ObjectToString("historial"))) {
case 0: {
 BA.debugLineNum = 59;BA.debugLine="cargarDatos(Job.GetString) 'se envia la cadena";
Debug.ShouldStop(67108864);
_cargardatos(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ));
 break; }
case 1: {
 BA.debugLineNum = 61;BA.debugLine="cargarEstado(Job.GetString)";
Debug.ShouldStop(268435456);
_cargarestado(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ));
 break; }
}
;
 }else {
 BA.debugLineNum = 64;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(-2147483648);
datos_activity.mostCurrent.__c.runVoidMethod ("LogImpl","43407882",RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )),0);
 BA.debugLineNum = 65;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(1);
datos_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(datos_activity.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 67;BA.debugLine="Job.Release";
Debug.ShouldStop(4);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
public static RemoteObject  _setstatusbarcolor(RemoteObject _clr) throws Exception{
try {
		Debug.PushSubsStack("SetStatusBarColor (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,199);
if (RapidSub.canDelegate("setstatusbarcolor")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","setstatusbarcolor", _clr);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _window = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("clr", _clr);
 BA.debugLineNum = 199;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
Debug.ShouldStop(64);
 BA.debugLineNum = 200;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(128);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 201;BA.debugLine="If p.SdkVersion >= 21 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 21))) { 
 BA.debugLineNum = 202;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(512);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 203;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(1024);
_jo.runVoidMethod ("InitializeContext",datos_activity.processBA);
 BA.debugLineNum = 204;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
Debug.ShouldStop(2048);
_window = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_window = _jo.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getWindow")),(Object)((datos_activity.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("window", _window);Debug.locals.put("window", _window);
 BA.debugLineNum = 205;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
Debug.ShouldStop(4096);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("addFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x80000000))})));
 BA.debugLineNum = 206;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
Debug.ShouldStop(8192);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("clearFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x04000000))})));
 BA.debugLineNum = 207;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
Debug.ShouldStop(16384);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setStatusBarColor")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_clr)})));
 };
 BA.debugLineNum = 209;BA.debugLine="If p.SdkVersion >= 23 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 23))) { 
 BA.debugLineNum = 210;BA.debugLine="jo = Activity";
Debug.ShouldStop(131072);
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), datos_activity.mostCurrent._activity.getObject());
 BA.debugLineNum = 211;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
Debug.ShouldStop(262144);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setSystemUiVisibility")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((8192))})));
 };
 BA.debugLineNum = 213;BA.debugLine="End Sub";
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