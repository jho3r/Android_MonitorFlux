package com.monitorflux;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class datos_activity_subs_0 {


public static RemoteObject  _activity_click() throws Exception{
try {
		Debug.PushSubsStack("Activity_Click (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,259);
if (RapidSub.canDelegate("activity_click")) { return com.monitorflux.datos_activity.remoteMe.runUserSub(false, "datos_activity","activity_click");}
 BA.debugLineNum = 259;BA.debugLine="Sub Activity_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 260;BA.debugLine="panel.Visible = False";
Debug.ShouldStop(8);
datos_activity.mostCurrent._panel.runMethod(true,"setVisible",datos_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 261;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,35);
if (RapidSub.canDelegate("activity_create")) { com.monitorflux.datos_activity.remoteMe.runUserSub(false, "datos_activity","activity_create", _firsttime); return;}
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(com.monitorflux.datos_activity parent,RemoteObject _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
com.monitorflux.datos_activity parent;
RemoteObject _firsttime;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,35);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 38;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(32);
parent.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 39;BA.debugLine="Activity.LoadLayout(\"Datos\")";
Debug.ShouldStop(64);
parent.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Datos")),datos_activity.mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
Debug.ShouldStop(128);
_setstatusbarcolor(parent.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 222))));
 BA.debugLineNum = 41;BA.debugLine="urlGet = \"https://api.backendless.com/4D75900B-E5";
Debug.ShouldStop(256);
parent.mostCurrent._urlget = BA.ObjectToString("https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos?where=ownerId%20%3D%20");
 BA.debugLineNum = 42;BA.debugLine="urlHistorial = Main.urlHistorial & \"&property=flu";
Debug.ShouldStop(512);
parent.mostCurrent._urlhistorial = RemoteObject.concat(parent.mostCurrent._main._urlhistorial /*RemoteObject*/ ,RemoteObject.createImmutable("&property=flujo"));
 BA.debugLineNum = 43;BA.debugLine="backendelessGet.Initialize(\"get\",Me)";
Debug.ShouldStop(1024);
parent.mostCurrent._backendelessget.runClassMethod (com.monitorflux.httpjob.class, "_initialize" /*RemoteObject*/ ,datos_activity.processBA,(Object)(BA.ObjectToString("get")),(Object)(datos_activity.getObject()));
 BA.debugLineNum = 44;BA.debugLine="historial.Initialize(\"historial\",Me)";
Debug.ShouldStop(2048);
parent.mostCurrent._historial.runClassMethod (com.monitorflux.httpjob.class, "_initialize" /*RemoteObject*/ ,datos_activity.processBA,(Object)(BA.ObjectToString("historial")),(Object)(datos_activity.getObject()));
 BA.debugLineNum = 45;BA.debugLine="urlEliminar = \"https://api.backendless.com/4D7590";
Debug.ShouldStop(4096);
parent.mostCurrent._urleliminar = BA.ObjectToString("https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos/");
 BA.debugLineNum = 47;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_RECEIVE_SMS) 'IN";
Debug.ShouldStop(16384);
parent.mostCurrent._rp.runVoidMethod ("CheckAndRequest",datos_activity.processBA,(Object)(parent.mostCurrent._rp.getField(true,"PERMISSION_RECEIVE_SMS")));
 BA.debugLineNum = 48;BA.debugLine="Wait For Activity_PermissionResult(Permission As";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", datos_activity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "datos_activity", "activity_create"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 49;BA.debugLine="If Result Then";
Debug.ShouldStop(65536);
if (true) break;

case 1:
//if
this.state = 4;
if (_result.<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 50;BA.debugLine="ToastMessageShow(\"Permiso para recibir mensaje e";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Permiso para recibir mensaje en uso")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 54;BA.debugLine="backendelessGet.Download(urlGet & \"'\" & Main.ID &";
Debug.ShouldStop(2097152);
parent.mostCurrent._backendelessget.runClassMethod (com.monitorflux.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.concat(parent.mostCurrent._urlget,RemoteObject.createImmutable("'"),parent.mostCurrent._main._id /*RemoteObject*/ ,RemoteObject.createImmutable("'"))));
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _activity_permissionresult(RemoteObject _permission,RemoteObject _result) throws Exception{
}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,61);
if (RapidSub.canDelegate("activity_pause")) { return com.monitorflux.datos_activity.remoteMe.runUserSub(false, "datos_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 61;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 63;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("Activity_Resume (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,57);
if (RapidSub.canDelegate("activity_resume")) { return com.monitorflux.datos_activity.remoteMe.runUserSub(false, "datos_activity","activity_resume");}
 BA.debugLineNum = 57;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnactualizar_click() throws Exception{
try {
		Debug.PushSubsStack("btnActualizar_Click (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,263);
if (RapidSub.canDelegate("btnactualizar_click")) { return com.monitorflux.datos_activity.remoteMe.runUserSub(false, "datos_activity","btnactualizar_click");}
 BA.debugLineNum = 263;BA.debugLine="Sub btnActualizar_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 264;BA.debugLine="enviarSMS.Send2(numero,\"actualizar\",False,False)";
Debug.ShouldStop(128);
datos_activity.mostCurrent._enviarsms.runVoidMethod ("Send2",(Object)(datos_activity.mostCurrent._numero),(Object)(BA.ObjectToString("actualizar")),(Object)(datos_activity.mostCurrent.__c.getField(true,"False")),(Object)(datos_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 266;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("btnAtrasE_Click (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,66);
if (RapidSub.canDelegate("btnatrase_click")) { return com.monitorflux.datos_activity.remoteMe.runUserSub(false, "datos_activity","btnatrase_click");}
 BA.debugLineNum = 66;BA.debugLine="Sub btnAtrasE_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4);
datos_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _btnmas_click() throws Exception{
try {
		Debug.PushSubsStack("btnMas_Click (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,244);
if (RapidSub.canDelegate("btnmas_click")) { return com.monitorflux.datos_activity.remoteMe.runUserSub(false, "datos_activity","btnmas_click");}
 BA.debugLineNum = 244;BA.debugLine="Sub btnMas_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 245;BA.debugLine="panel.Visible = Not(panel.Visible)";
Debug.ShouldStop(1048576);
datos_activity.mostCurrent._panel.runMethod(true,"setVisible",datos_activity.mostCurrent.__c.runMethod(true,"Not",(Object)(datos_activity.mostCurrent._panel.runMethod(true,"getVisible"))));
 BA.debugLineNum = 247;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("cargarDatos (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,96);
if (RapidSub.canDelegate("cargardatos")) { return com.monitorflux.datos_activity.remoteMe.runUserSub(false, "datos_activity","cargardatos", _res);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _nombre = RemoteObject.createImmutable("");
RemoteObject _descripcion = RemoteObject.createImmutable("");
Debug.locals.put("res", _res);
 BA.debugLineNum = 96;BA.debugLine="Sub cargarDatos (res As String)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(1);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 98;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(2);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 101;BA.debugLine="Dim root As List = parser.NextArray";
Debug.ShouldStop(16);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = _parser.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 102;BA.debugLine="For Each colroot As Map In root				'map es simila";
Debug.ShouldStop(32);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group4 = _root;
final int groupLen4 = group4.runMethod(true,"getSize").<Integer>get()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_colroot = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group4.runMethod(false,"Get",index4));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 103;BA.debugLine="If colroot.Get(\"nombre\") = Monitor_Activity.nomb";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nombre")))),(datos_activity.mostCurrent._monitor_activity._nombred /*RemoteObject*/ ))) { 
 BA.debugLineNum = 104;BA.debugLine="Dim nombre As String = colroot.Get(\"nombre\")";
Debug.ShouldStop(128);
_nombre = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nombre")))));Debug.locals.put("nombre", _nombre);Debug.locals.put("nombre", _nombre);
 BA.debugLineNum = 105;BA.debugLine="Dim descripcion As String = colroot.Get(\"descri";
Debug.ShouldStop(256);
_descripcion = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("descripcion")))));Debug.locals.put("descripcion", _descripcion);Debug.locals.put("descripcion", _descripcion);
 BA.debugLineNum = 106;BA.debugLine="numero = colroot.Get(\"numero\")";
Debug.ShouldStop(512);
datos_activity.mostCurrent._numero = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("numero")))));
 BA.debugLineNum = 107;BA.debugLine="idActual = colroot.Get(\"id\")";
Debug.ShouldStop(1024);
datos_activity.mostCurrent._idactual = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 108;BA.debugLine="objectId = colroot.Get(\"objectId\")";
Debug.ShouldStop(2048);
datos_activity.mostCurrent._objectid = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("objectId")))));
 };
 }
}Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 112;BA.debugLine="lbNombre.Text = nombre";
Debug.ShouldStop(32768);
datos_activity.mostCurrent._lbnombre.runMethod(true,"setText",BA.ObjectToCharSequence(_nombre));
 BA.debugLineNum = 113;BA.debugLine="lbNumero.Text = numero";
Debug.ShouldStop(65536);
datos_activity.mostCurrent._lbnumero.runMethod(true,"setText",BA.ObjectToCharSequence(datos_activity.mostCurrent._numero));
 BA.debugLineNum = 114;BA.debugLine="lbDescrip.Text = descripcion";
Debug.ShouldStop(131072);
datos_activity.mostCurrent._lbdescrip.runMethod(true,"setText",BA.ObjectToCharSequence(_descripcion));
 BA.debugLineNum = 115;BA.debugLine="historial.Download(urlHistorial)";
Debug.ShouldStop(262144);
datos_activity.mostCurrent._historial.runClassMethod (com.monitorflux.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(datos_activity.mostCurrent._urlhistorial));
 BA.debugLineNum = 116;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("cargarEstado (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,119);
if (RapidSub.canDelegate("cargarestado")) { return com.monitorflux.datos_activity.remoteMe.runUserSub(false, "datos_activity","cargarestado", _res);}
RemoteObject _fecha = RemoteObject.createImmutable(0L);
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _fechaentra = RemoteObject.createImmutable(0L);
RemoteObject _estado = RemoteObject.createImmutable("");
RemoteObject _flujo = RemoteObject.createImmutable("");
Debug.locals.put("res", _res);
 BA.debugLineNum = 119;BA.debugLine="Sub cargarEstado (res As String)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 120;BA.debugLine="Dim fecha As Long = 0";
Debug.ShouldStop(8388608);
_fecha = BA.numberCast(long.class, 0);Debug.locals.put("fecha", _fecha);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 121;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(16777216);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 122;BA.debugLine="Log(res)";
Debug.ShouldStop(33554432);
datos_activity.mostCurrent.__c.runVoidMethod ("LogImpl","14063235",_res,0);
 BA.debugLineNum = 123;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(67108864);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 126;BA.debugLine="Dim root As List = parser.NextArray";
Debug.ShouldStop(536870912);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = _parser.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 127;BA.debugLine="For Each colroot As Map In root				'map es simila";
Debug.ShouldStop(1073741824);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group6 = _root;
final int groupLen6 = group6.runMethod(true,"getSize").<Integer>get()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_colroot = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group6.runMethod(false,"Get",index6));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 129;BA.debugLine="If colroot.Get(\"id\") = idActual Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("id")))),(datos_activity.mostCurrent._idactual))) { 
 BA.debugLineNum = 131;BA.debugLine="Dim fechaEntra As Long = colroot.Get(\"fecha\")";
Debug.ShouldStop(4);
_fechaentra = BA.numberCast(long.class, _colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha")))));Debug.locals.put("fechaEntra", _fechaentra);Debug.locals.put("fechaEntra", _fechaentra);
 BA.debugLineNum = 132;BA.debugLine="If fechaEntra >= fecha Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("g",_fechaentra,_fecha)) { 
 BA.debugLineNum = 133;BA.debugLine="Dim estado As String = colroot.Get(\"encendida\"";
Debug.ShouldStop(16);
_estado = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("encendida")))));Debug.locals.put("estado", _estado);Debug.locals.put("estado", _estado);
 BA.debugLineNum = 134;BA.debugLine="Dim flujo As String = colroot.Get(\"flujo\")";
Debug.ShouldStop(32);
_flujo = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("flujo")))));Debug.locals.put("flujo", _flujo);Debug.locals.put("flujo", _flujo);
 BA.debugLineNum = 135;BA.debugLine="Log(colroot.Get(\"flujo\"))";
Debug.ShouldStop(64);
datos_activity.mostCurrent.__c.runVoidMethod ("LogImpl","14063248",BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("flujo"))))),0);
 BA.debugLineNum = 136;BA.debugLine="fecha = fechaEntra";
Debug.ShouldStop(128);
_fecha = _fechaentra;Debug.locals.put("fecha", _fecha);
 };
 };
 }
}Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 141;BA.debugLine="If estado = True Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_estado,BA.ObjectToString(datos_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 142;BA.debugLine="lbEstado.Text = \"Encendido\"";
Debug.ShouldStop(8192);
datos_activity.mostCurrent._lbestado.runMethod(true,"setText",BA.ObjectToCharSequence("Encendido"));
 BA.debugLineNum = 143;BA.debugLine="lbEstado.Color = Colors.ARGB(128,0,136,145)";
Debug.ShouldStop(16384);
datos_activity.mostCurrent._lbestado.runVoidMethod ("setColor",datos_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 136)),(Object)(BA.numberCast(int.class, 145))));
 }else 
{ BA.debugLineNum = 144;BA.debugLine="Else If estado = False Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_estado,BA.ObjectToString(datos_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 145;BA.debugLine="lbEstado.Text = \"Apagado\"";
Debug.ShouldStop(65536);
datos_activity.mostCurrent._lbestado.runMethod(true,"setText",BA.ObjectToCharSequence("Apagado"));
 BA.debugLineNum = 146;BA.debugLine="lbEstado.Color = Colors.ARGB(128,240,84,84)";
Debug.ShouldStop(131072);
datos_activity.mostCurrent._lbestado.runVoidMethod ("setColor",datos_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 84)),(Object)(BA.numberCast(int.class, 84))));
 }}
;
 BA.debugLineNum = 150;BA.debugLine="lbFlujo.Text = flujo & \" Litros/Hora\"";
Debug.ShouldStop(2097152);
datos_activity.mostCurrent._lbflujo.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_flujo,RemoteObject.createImmutable(" Litros/Hora"))));
 BA.debugLineNum = 153;BA.debugLine="diferenciaDeFechas(fecha)";
Debug.ShouldStop(16777216);
_diferenciadefechas(_fecha);
 BA.debugLineNum = 154;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("diferenciaDeFechas (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,156);
if (RapidSub.canDelegate("diferenciadefechas")) { return com.monitorflux.datos_activity.remoteMe.runUserSub(false, "datos_activity","diferenciadefechas", _fecha);}
RemoteObject _fechaactual = RemoteObject.createImmutable(0L);
RemoteObject _actual = RemoteObject.createImmutable(0L);
RemoteObject _actualmodificado = RemoteObject.createImmutable(0L);
RemoteObject _mensaje = RemoteObject.createImmutable("");
Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 156;BA.debugLine="Sub diferenciaDeFechas(fecha As Long){";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 158;BA.debugLine="DateTime.DateFormat = \"yyyyMMddHHmm\"";
Debug.ShouldStop(536870912);
datos_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("yyyyMMddHHmm"));
 BA.debugLineNum = 159;BA.debugLine="Dim fechaActual As Long = DateTime.Date(DateTime.";
Debug.ShouldStop(1073741824);
_fechaactual = BA.numberCast(long.class, datos_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(datos_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));Debug.locals.put("fechaActual", _fechaactual);Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 160;BA.debugLine="Dim actual As Long = fechaActual - fecha";
Debug.ShouldStop(-2147483648);
_actual = RemoteObject.solve(new RemoteObject[] {_fechaactual,_fecha}, "-",1, 2);Debug.locals.put("actual", _actual);Debug.locals.put("actual", _actual);
 BA.debugLineNum = 161;BA.debugLine="Dim actualModificado As Long";
Debug.ShouldStop(1);
_actualmodificado = RemoteObject.createImmutable(0L);Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 162;BA.debugLine="Dim mensaje As String";
Debug.ShouldStop(2);
_mensaje = RemoteObject.createImmutable("");Debug.locals.put("mensaje", _mensaje);
 BA.debugLineNum = 164;BA.debugLine="If actual < 100 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("<",_actual,BA.numberCast(long.class, 100))) { 
 BA.debugLineNum = 165;BA.debugLine="actualModificado = fechaActual/100";
Debug.ShouldStop(16);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(100)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 166;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
Debug.ShouldStop(32);
_fechaactual = RemoteObject.solve(new RemoteObject[] {_fechaactual,_actualmodificado,RemoteObject.createImmutable(100)}, "-*",1, 2);Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 167;BA.debugLine="actualModificado = fecha/100";
Debug.ShouldStop(64);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fecha,RemoteObject.createImmutable(100)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 168;BA.debugLine="fecha = fecha - actualModificado*100";
Debug.ShouldStop(128);
_fecha = RemoteObject.solve(new RemoteObject[] {_fecha,_actualmodificado,RemoteObject.createImmutable(100)}, "-*",1, 2);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 169;BA.debugLine="If fecha <= fechaActual Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("k",_fecha,_fechaactual)) { 
 BA.debugLineNum = 170;BA.debugLine="actualModificado = fechaActual - fecha";
Debug.ShouldStop(512);
_actualmodificado = RemoteObject.solve(new RemoteObject[] {_fechaactual,_fecha}, "-",1, 2);Debug.locals.put("actualModificado", _actualmodificado);
 }else {
 BA.debugLineNum = 172;BA.debugLine="actualModificado = fechaActual + (60 - fecha)";
Debug.ShouldStop(2048);
_actualmodificado = RemoteObject.solve(new RemoteObject[] {_fechaactual,(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(60),_fecha}, "-",1, 2))}, "+",1, 2);Debug.locals.put("actualModificado", _actualmodificado);
 };
 BA.debugLineNum = 175;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
Debug.ShouldStop(16384);
_mensaje = RemoteObject.concat(RemoteObject.createImmutable("Actualizado hace "),_actualmodificado,RemoteObject.createImmutable(" minutos"));Debug.locals.put("mensaje", _mensaje);
 }else 
{ BA.debugLineNum = 177;BA.debugLine="Else If actual < 10000 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("<",_actual,BA.numberCast(long.class, 10000))) { 
 BA.debugLineNum = 178;BA.debugLine="actualModificado = fechaActual/10000";
Debug.ShouldStop(131072);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(10000)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 179;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
Debug.ShouldStop(262144);
_fechaactual = RemoteObject.solve(new RemoteObject[] {_fechaactual,_actualmodificado,RemoteObject.createImmutable(10000)}, "-*",1, 2);Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 180;BA.debugLine="actualModificado = fecha/10000";
Debug.ShouldStop(524288);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fecha,RemoteObject.createImmutable(10000)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 181;BA.debugLine="fecha = fecha - actualModificado*10000";
Debug.ShouldStop(1048576);
_fecha = RemoteObject.solve(new RemoteObject[] {_fecha,_actualmodificado,RemoteObject.createImmutable(10000)}, "-*",1, 2);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 182;BA.debugLine="Log(fechaActual)";
Debug.ShouldStop(2097152);
datos_activity.mostCurrent.__c.runVoidMethod ("LogImpl","14128794",BA.NumberToString(_fechaactual),0);
 BA.debugLineNum = 183;BA.debugLine="Log(fecha)";
Debug.ShouldStop(4194304);
datos_activity.mostCurrent.__c.runVoidMethod ("LogImpl","14128795",BA.NumberToString(_fecha),0);
 BA.debugLineNum = 184;BA.debugLine="If fecha < fechaActual Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("<",_fecha,_fechaactual)) { 
 BA.debugLineNum = 185;BA.debugLine="actualModificado = fechaActual/100 - fecha/100";
Debug.ShouldStop(16777216);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(100),_fecha,RemoteObject.createImmutable(100)}, "/-/",1, 0));Debug.locals.put("actualModificado", _actualmodificado);
 }else {
 BA.debugLineNum = 187;BA.debugLine="actualModificado = fechaActual/100 + (24 - fech";
Debug.ShouldStop(67108864);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(100),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(24),_fecha,RemoteObject.createImmutable(100)}, "-/",1, 0))}, "/+",1, 0));Debug.locals.put("actualModificado", _actualmodificado);
 };
 BA.debugLineNum = 190;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
Debug.ShouldStop(536870912);
_mensaje = RemoteObject.concat(RemoteObject.createImmutable("Actualizado hace "),_actualmodificado,RemoteObject.createImmutable(" horas"));Debug.locals.put("mensaje", _mensaje);
 }else 
{ BA.debugLineNum = 193;BA.debugLine="Else If actual < 1000000 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("<",_actual,BA.numberCast(long.class, 1000000))) { 
 BA.debugLineNum = 194;BA.debugLine="actualModificado = fechaActual/1000000";
Debug.ShouldStop(2);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(1000000)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 195;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
Debug.ShouldStop(4);
_fechaactual = RemoteObject.solve(new RemoteObject[] {_fechaactual,_actualmodificado,RemoteObject.createImmutable(1000000)}, "-*",1, 2);Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 196;BA.debugLine="actualModificado = fecha/1000000";
Debug.ShouldStop(8);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fecha,RemoteObject.createImmutable(1000000)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 197;BA.debugLine="fecha = fecha - actualModificado*1000000";
Debug.ShouldStop(16);
_fecha = RemoteObject.solve(new RemoteObject[] {_fecha,_actualmodificado,RemoteObject.createImmutable(1000000)}, "-*",1, 2);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 198;BA.debugLine="actualModificado = Abs(fechaActual - fecha)";
Debug.ShouldStop(32);
_actualmodificado = BA.numberCast(long.class, datos_activity.mostCurrent.__c.runMethod(true,"Abs",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,_fecha}, "-",1, 2)))));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 199;BA.debugLine="If fecha < fechaActual Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("<",_fecha,_fechaactual)) { 
 BA.debugLineNum = 200;BA.debugLine="actualModificado = fechaActual/10000 - fecha/10";
Debug.ShouldStop(128);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(10000),_fecha,RemoteObject.createImmutable(10000)}, "/-/",1, 0));Debug.locals.put("actualModificado", _actualmodificado);
 }else {
 BA.debugLineNum = 202;BA.debugLine="actualModificado = fechaActual/10000 + (30 - fe";
Debug.ShouldStop(512);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(10000),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(30),_fecha,RemoteObject.createImmutable(10000)}, "-/",1, 0))}, "/+",1, 0));Debug.locals.put("actualModificado", _actualmodificado);
 };
 BA.debugLineNum = 205;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
Debug.ShouldStop(4096);
_mensaje = RemoteObject.concat(RemoteObject.createImmutable("Actualizado hace "),_actualmodificado,RemoteObject.createImmutable(" dias"));Debug.locals.put("mensaje", _mensaje);
 }else 
{ BA.debugLineNum = 208;BA.debugLine="Else If actual < 100000000 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("<",_actual,BA.numberCast(long.class, 100000000))) { 
 BA.debugLineNum = 209;BA.debugLine="actualModificado = fechaActual/100000000";
Debug.ShouldStop(65536);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(100000000)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 210;BA.debugLine="fechaActual = fechaActual - actualModificado*100";
Debug.ShouldStop(131072);
_fechaactual = RemoteObject.solve(new RemoteObject[] {_fechaactual,_actualmodificado,RemoteObject.createImmutable(100000000)}, "-*",1, 2);Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 211;BA.debugLine="actualModificado = fecha/100000000";
Debug.ShouldStop(262144);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fecha,RemoteObject.createImmutable(100000000)}, "/",0, 0));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 212;BA.debugLine="fecha = fecha - actualModificado*100000000";
Debug.ShouldStop(524288);
_fecha = RemoteObject.solve(new RemoteObject[] {_fecha,_actualmodificado,RemoteObject.createImmutable(100000000)}, "-*",1, 2);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 213;BA.debugLine="actualModificado = Abs(fechaActual - fecha)";
Debug.ShouldStop(1048576);
_actualmodificado = BA.numberCast(long.class, datos_activity.mostCurrent.__c.runMethod(true,"Abs",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,_fecha}, "-",1, 2)))));Debug.locals.put("actualModificado", _actualmodificado);
 BA.debugLineNum = 214;BA.debugLine="If fecha < fechaActual Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("<",_fecha,_fechaactual)) { 
 BA.debugLineNum = 215;BA.debugLine="actualModificado = fechaActual/1000000 - fecha/";
Debug.ShouldStop(4194304);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(1000000),_fecha,RemoteObject.createImmutable(1000000)}, "/-/",1, 0));Debug.locals.put("actualModificado", _actualmodificado);
 }else {
 BA.debugLineNum = 217;BA.debugLine="actualModificado = fechaActual/1000000 + (12 -";
Debug.ShouldStop(16777216);
_actualmodificado = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_fechaactual,RemoteObject.createImmutable(1000000),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(12),_fecha,RemoteObject.createImmutable(1000000)}, "-/",1, 0))}, "/+",1, 0));Debug.locals.put("actualModificado", _actualmodificado);
 };
 BA.debugLineNum = 220;BA.debugLine="mensaje = \"Actualizado hace \" & actualModificado";
Debug.ShouldStop(134217728);
_mensaje = RemoteObject.concat(RemoteObject.createImmutable("Actualizado hace "),_actualmodificado,RemoteObject.createImmutable(" meses"));Debug.locals.put("mensaje", _mensaje);
 }else {
 BA.debugLineNum = 223;BA.debugLine="mensaje = \"Desactualizado\"";
Debug.ShouldStop(1073741824);
_mensaje = BA.ObjectToString("Desactualizado");Debug.locals.put("mensaje", _mensaje);
 }}}}
;
 BA.debugLineNum = 225;BA.debugLine="lbActualizado.Text = mensaje";
Debug.ShouldStop(1);
datos_activity.mostCurrent._lbactualizado.runMethod(true,"setText",BA.ObjectToCharSequence(_mensaje));
 BA.debugLineNum = 226;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
datos_activity.mostCurrent._backendelessget = RemoteObject.createNew ("com.monitorflux.httpjob");
 //BA.debugLineNum = 16;BA.debugLine="Dim historial As HttpJob";
datos_activity.mostCurrent._historial = RemoteObject.createNew ("com.monitorflux.httpjob");
 //BA.debugLineNum = 17;BA.debugLine="Dim eliminar As HttpJob";
datos_activity.mostCurrent._eliminar = RemoteObject.createNew ("com.monitorflux.httpjob");
 //BA.debugLineNum = 18;BA.debugLine="Private lbNombre As Label";
datos_activity.mostCurrent._lbnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private urlGet As String";
datos_activity.mostCurrent._urlget = RemoteObject.createImmutable("");
 //BA.debugLineNum = 20;BA.debugLine="Private urlHistorial As String";
datos_activity.mostCurrent._urlhistorial = RemoteObject.createImmutable("");
 //BA.debugLineNum = 21;BA.debugLine="Private lbNumero As Label";
datos_activity.mostCurrent._lbnumero = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lbDescrip As Label";
datos_activity.mostCurrent._lbdescrip = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lbEstado As Label";
datos_activity.mostCurrent._lbestado = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private lbFlujo As Label";
datos_activity.mostCurrent._lbflujo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private lbActualizado As Label";
datos_activity.mostCurrent._lbactualizado = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private idActual As String";
datos_activity.mostCurrent._idactual = RemoteObject.createImmutable("");
 //BA.debugLineNum = 27;BA.debugLine="Private objectId As String";
datos_activity.mostCurrent._objectid = RemoteObject.createImmutable("");
 //BA.debugLineNum = 28;BA.debugLine="Private panel As Panel";
datos_activity.mostCurrent._panel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private urlEliminar As String";
datos_activity.mostCurrent._urleliminar = RemoteObject.createImmutable("");
 //BA.debugLineNum = 30;BA.debugLine="Dim rp As RuntimePermissions   'requiere libreria";
datos_activity.mostCurrent._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 31;BA.debugLine="Dim enviarSMS As PhoneSms";
datos_activity.mostCurrent._enviarsms = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.PhoneSms");
 //BA.debugLineNum = 32;BA.debugLine="Private numero As String";
datos_activity.mostCurrent._numero = RemoteObject.createImmutable("");
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,71);
if (RapidSub.canDelegate("jobdone")) { com.monitorflux.datos_activity.remoteMe.runUserSub(false, "datos_activity","jobdone", _job); return;}
ResumableSub_JobDone rsub = new ResumableSub_JobDone(null,_job);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_JobDone extends BA.ResumableSub {
public ResumableSub_JobDone(com.monitorflux.datos_activity parent,RemoteObject _job) {
this.parent = parent;
this._job = _job;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
com.monitorflux.datos_activity parent;
RemoteObject _job;
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("JobDone (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,71);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("Job", _job);
 BA.debugLineNum = 72;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","13932161",RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname" /*RemoteObject*/ ),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success" /*RemoteObject*/ )),0);
 BA.debugLineNum = 73;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(256);
if (true) break;

case 1:
//if
this.state = 18;
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 3;
}else {
this.state = 17;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 74;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
Debug.ShouldStop(512);
if (true) break;

case 4:
//select
this.state = 15;
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("get"),BA.ObjectToString("historial"),BA.ObjectToString("eliminar"))) {
case 0: {
this.state = 6;
if (true) break;
}
case 1: {
this.state = 8;
if (true) break;
}
case 2: {
this.state = 10;
if (true) break;
}
}
if (true) break;

case 6:
//C
this.state = 15;
 BA.debugLineNum = 76;BA.debugLine="cargarDatos(Job.GetString) 'se envia la cadena";
Debug.ShouldStop(2048);
_cargardatos(_job.runClassMethod (com.monitorflux.httpjob.class, "_getstring" /*RemoteObject*/ ));
 if (true) break;

case 8:
//C
this.state = 15;
 BA.debugLineNum = 78;BA.debugLine="cargarEstado(Job.GetString)";
Debug.ShouldStop(8192);
_cargarestado(_job.runClassMethod (com.monitorflux.httpjob.class, "_getstring" /*RemoteObject*/ ));
 if (true) break;

case 10:
//C
this.state = 11;
 BA.debugLineNum = 81;BA.debugLine="Msgbox2Async(\"Dispositivo eliminado correctame";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Dispositivo eliminado correctamente")),(Object)(BA.ObjectToCharSequence("Listo!")),(Object)(BA.ObjectToString("Ok")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),datos_activity.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 82;BA.debugLine="Wait For Msgbox_Result(Result As Int) 'Queda e";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", datos_activity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "datos_activity", "jobdone"), null);
this.state = 19;
return;
case 19:
//C
this.state = 11;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 83;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(262144);
if (true) break;

case 11:
//if
this.state = 14;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 BA.debugLineNum = 84;BA.debugLine="Monitor_Activity.eliminado = True";
Debug.ShouldStop(524288);
parent.mostCurrent._monitor_activity._eliminado /*RemoteObject*/  = parent.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 85;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1048576);
parent.mostCurrent._activity.runVoidMethod ("Finish");
 if (true) break;

case 14:
//C
this.state = 15;
;
 if (true) break;

case 15:
//C
this.state = 18;
;
 if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 89;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","13932178",RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )),0);
 BA.debugLineNum = 90;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 18:
//C
this.state = -1;
;
 BA.debugLineNum = 92;BA.debugLine="Job.Release";
Debug.ShouldStop(134217728);
_job.runClassMethod (com.monitorflux.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _msgbox_result(RemoteObject _result) throws Exception{
}
public static RemoteObject  _lbeliminar_click() throws Exception{
try {
		Debug.PushSubsStack("lbEliminar_Click (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,253);
if (RapidSub.canDelegate("lbeliminar_click")) { return com.monitorflux.datos_activity.remoteMe.runUserSub(false, "datos_activity","lbeliminar_click");}
 BA.debugLineNum = 253;BA.debugLine="Sub lbEliminar_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 254;BA.debugLine="eliminar.Initialize(\"eliminar\",Me)";
Debug.ShouldStop(536870912);
datos_activity.mostCurrent._eliminar.runClassMethod (com.monitorflux.httpjob.class, "_initialize" /*RemoteObject*/ ,datos_activity.processBA,(Object)(BA.ObjectToString("eliminar")),(Object)(datos_activity.getObject()));
 BA.debugLineNum = 255;BA.debugLine="Log(\"Eliminar\")";
Debug.ShouldStop(1073741824);
datos_activity.mostCurrent.__c.runVoidMethod ("LogImpl","14390914",RemoteObject.createImmutable("Eliminar"),0);
 BA.debugLineNum = 256;BA.debugLine="eliminar.Delete(urlEliminar & objectId)";
Debug.ShouldStop(-2147483648);
datos_activity.mostCurrent._eliminar.runClassMethod (com.monitorflux.httpjob.class, "_delete" /*RemoteObject*/ ,(Object)(RemoteObject.concat(datos_activity.mostCurrent._urleliminar,datos_activity.mostCurrent._objectid)));
 BA.debugLineNum = 257;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbhistorial_click() throws Exception{
try {
		Debug.PushSubsStack("lbHistorial_Click (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,249);
if (RapidSub.canDelegate("lbhistorial_click")) { return com.monitorflux.datos_activity.remoteMe.runUserSub(false, "datos_activity","lbhistorial_click");}
 BA.debugLineNum = 249;BA.debugLine="Sub lbHistorial_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 250;BA.debugLine="Log(\"historial\")";
Debug.ShouldStop(33554432);
datos_activity.mostCurrent.__c.runVoidMethod ("LogImpl","14325377",RemoteObject.createImmutable("historial"),0);
 BA.debugLineNum = 251;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("SetStatusBarColor (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,228);
if (RapidSub.canDelegate("setstatusbarcolor")) { return com.monitorflux.datos_activity.remoteMe.runUserSub(false, "datos_activity","setstatusbarcolor", _clr);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _window = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("clr", _clr);
 BA.debugLineNum = 228;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
Debug.ShouldStop(8);
 BA.debugLineNum = 229;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(16);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 230;BA.debugLine="If p.SdkVersion >= 21 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 21))) { 
 BA.debugLineNum = 231;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(64);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 232;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(128);
_jo.runVoidMethod ("InitializeContext",datos_activity.processBA);
 BA.debugLineNum = 233;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
Debug.ShouldStop(256);
_window = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_window = _jo.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getWindow")),(Object)((datos_activity.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("window", _window);Debug.locals.put("window", _window);
 BA.debugLineNum = 234;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
Debug.ShouldStop(512);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("addFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x80000000))})));
 BA.debugLineNum = 235;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
Debug.ShouldStop(1024);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("clearFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x04000000))})));
 BA.debugLineNum = 236;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
Debug.ShouldStop(2048);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setStatusBarColor")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_clr)})));
 };
 BA.debugLineNum = 238;BA.debugLine="If p.SdkVersion >= 23 Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 23))) { 
 BA.debugLineNum = 239;BA.debugLine="jo = Activity";
Debug.ShouldStop(16384);
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), datos_activity.mostCurrent._activity.getObject());
 BA.debugLineNum = 240;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
Debug.ShouldStop(32768);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setSystemUiVisibility")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((8192))})));
 };
 BA.debugLineNum = 242;BA.debugLine="End Sub";
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