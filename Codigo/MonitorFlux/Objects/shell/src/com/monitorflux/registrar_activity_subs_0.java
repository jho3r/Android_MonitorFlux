package com.monitorflux;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class registrar_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (registrar_activity) ","registrar_activity",6,registrar_activity.mostCurrent.activityBA,registrar_activity.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) { return com.monitorflux.registrar_activity.remoteMe.runUserSub(false, "registrar_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"Iniciar\")";
Debug.ShouldStop(-2147483648);
registrar_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Iniciar")),registrar_activity.mostCurrent.activityBA);
 BA.debugLineNum = 33;BA.debugLine="IniciarSesion.Initialize(\"iniciar\",Me)";
Debug.ShouldStop(1);
registrar_activity.mostCurrent._iniciarsesion.runClassMethod (com.monitorflux.httpjob.class, "_initialize" /*RemoteObject*/ ,registrar_activity.processBA,(Object)(BA.ObjectToString("iniciar")),(Object)(registrar_activity.getObject()));
 BA.debugLineNum = 34;BA.debugLine="urlIniciar = \"https://api.backendless.com/4D75900";
Debug.ShouldStop(2);
registrar_activity.mostCurrent._urliniciar = BA.ObjectToString("https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/users/login");
 BA.debugLineNum = 35;BA.debugLine="urlRegistrar = \"https://api.backendless.com/4D759";
Debug.ShouldStop(4);
registrar_activity.mostCurrent._urlregistrar = BA.ObjectToString("https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/users/register");
 BA.debugLineNum = 36;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
Debug.ShouldStop(8);
_setstatusbarcolor(registrar_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 222))));
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
		Debug.PushSubsStack("Activity_Pause (registrar_activity) ","registrar_activity",6,registrar_activity.mostCurrent.activityBA,registrar_activity.mostCurrent,43);
if (RapidSub.canDelegate("activity_pause")) { return com.monitorflux.registrar_activity.remoteMe.runUserSub(false, "registrar_activity","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (registrar_activity) ","registrar_activity",6,registrar_activity.mostCurrent.activityBA,registrar_activity.mostCurrent,39);
if (RapidSub.canDelegate("activity_resume")) { return com.monitorflux.registrar_activity.remoteMe.runUserSub(false, "registrar_activity","activity_resume");}
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
public static RemoteObject  _btnatrasa_click() throws Exception{
try {
		Debug.PushSubsStack("btnAtrasA_Click (registrar_activity) ","registrar_activity",6,registrar_activity.mostCurrent.activityBA,registrar_activity.mostCurrent,185);
if (RapidSub.canDelegate("btnatrasa_click")) { return com.monitorflux.registrar_activity.remoteMe.runUserSub(false, "registrar_activity","btnatrasa_click");}
 BA.debugLineNum = 185;BA.debugLine="Sub btnAtrasA_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 186;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(33554432);
registrar_activity.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 187;BA.debugLine="Activity.LoadLayout(\"Iniciar\")";
Debug.ShouldStop(67108864);
registrar_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Iniciar")),registrar_activity.mostCurrent.activityBA);
 BA.debugLineNum = 188;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btniniciar_click() throws Exception{
try {
		Debug.PushSubsStack("btnIniciar_Click (registrar_activity) ","registrar_activity",6,registrar_activity.mostCurrent.activityBA,registrar_activity.mostCurrent,72);
if (RapidSub.canDelegate("btniniciar_click")) { return com.monitorflux.registrar_activity.remoteMe.runUserSub(false, "registrar_activity","btniniciar_click");}
RemoteObject _datos = RemoteObject.createImmutable("");
 BA.debugLineNum = 72;BA.debugLine="Sub btnIniciar_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="If etCorreo.Text <> \"\" And etPassword.Text <> \"\"";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("!",registrar_activity.mostCurrent._etcorreo.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registrar_activity.mostCurrent._etpassword.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 74;BA.debugLine="If etCorreo.Text.Contains(\"@\") Then";
Debug.ShouldStop(512);
if (registrar_activity.mostCurrent._etcorreo.runMethod(true,"getText").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("@"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 75;BA.debugLine="correo  = etCorreo.Text";
Debug.ShouldStop(1024);
registrar_activity.mostCurrent._correo = registrar_activity.mostCurrent._etcorreo.runMethod(true,"getText");
 BA.debugLineNum = 76;BA.debugLine="clave  = etPassword.Text";
Debug.ShouldStop(2048);
registrar_activity.mostCurrent._clave = registrar_activity.mostCurrent._etpassword.runMethod(true,"getText");
 BA.debugLineNum = 77;BA.debugLine="Dim datos As String";
Debug.ShouldStop(4096);
_datos = RemoteObject.createImmutable("");Debug.locals.put("datos", _datos);
 BA.debugLineNum = 78;BA.debugLine="datos = \"{\"&Chr(34)&\"login\"&Chr(34)&\":\"&Chr(34)";
Debug.ShouldStop(8192);
_datos = RemoteObject.concat(RemoteObject.createImmutable("{"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("login"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(":"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),registrar_activity.mostCurrent._correo,registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(","),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("password"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(":"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),registrar_activity.mostCurrent._clave,registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("}"));Debug.locals.put("datos", _datos);
 BA.debugLineNum = 79;BA.debugLine="IniciarSesion.PostString(urlIniciar, datos)";
Debug.ShouldStop(16384);
registrar_activity.mostCurrent._iniciarsesion.runClassMethod (com.monitorflux.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(registrar_activity.mostCurrent._urliniciar),(Object)(_datos));
 BA.debugLineNum = 80;BA.debugLine="IniciarSesion.GetRequest.SetContentType(\"applic";
Debug.ShouldStop(32768);
registrar_activity.mostCurrent._iniciarsesion.runClassMethod (com.monitorflux.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
 BA.debugLineNum = 81;BA.debugLine="ProgressDialogShow(\"Iniciando sesión\")";
Debug.ShouldStop(65536);
registrar_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",registrar_activity.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Iniciando sesión"))));
 }else 
{ BA.debugLineNum = 82;BA.debugLine="Else If etCorreo.Text == \"admin\" And etPassword.";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",registrar_activity.mostCurrent._etcorreo.runMethod(true,"getText"),BA.ObjectToString("admin")) && RemoteObject.solveBoolean("=",registrar_activity.mostCurrent._etpassword.runMethod(true,"getText"),BA.ObjectToString("admin"))) { 
 BA.debugLineNum = 83;BA.debugLine="correo = Starter.usuarioAdmin";
Debug.ShouldStop(262144);
registrar_activity.mostCurrent._correo = registrar_activity.mostCurrent._starter._usuarioadmin /*RemoteObject*/ ;
 BA.debugLineNum = 84;BA.debugLine="clave = Starter.claveAdmin";
Debug.ShouldStop(524288);
registrar_activity.mostCurrent._clave = registrar_activity.mostCurrent._starter._claveadmin /*RemoteObject*/ ;
 BA.debugLineNum = 85;BA.debugLine="Dim datos As String";
Debug.ShouldStop(1048576);
_datos = RemoteObject.createImmutable("");Debug.locals.put("datos", _datos);
 BA.debugLineNum = 86;BA.debugLine="datos = \"{\"&Chr(34)&\"login\"&Chr(34)&\":\"&Chr(34)";
Debug.ShouldStop(2097152);
_datos = RemoteObject.concat(RemoteObject.createImmutable("{"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("login"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(":"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),registrar_activity.mostCurrent._correo,registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(","),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("password"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(":"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),registrar_activity.mostCurrent._clave,registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("}"));Debug.locals.put("datos", _datos);
 BA.debugLineNum = 87;BA.debugLine="IniciarSesion.PostString(urlIniciar, datos)";
Debug.ShouldStop(4194304);
registrar_activity.mostCurrent._iniciarsesion.runClassMethod (com.monitorflux.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(registrar_activity.mostCurrent._urliniciar),(Object)(_datos));
 BA.debugLineNum = 88;BA.debugLine="IniciarSesion.GetRequest.SetContentType(\"applic";
Debug.ShouldStop(8388608);
registrar_activity.mostCurrent._iniciarsesion.runClassMethod (com.monitorflux.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
 BA.debugLineNum = 89;BA.debugLine="ProgressDialogShow(\"Iniciando sesión\")";
Debug.ShouldStop(16777216);
registrar_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",registrar_activity.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Iniciando sesión"))));
 }else {
 BA.debugLineNum = 91;BA.debugLine="ToastMessageShow(\"Correo invalido\",True)";
Debug.ShouldStop(67108864);
registrar_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Correo invalido")),(Object)(registrar_activity.mostCurrent.__c.getField(true,"True")));
 }}
;
 }else {
 BA.debugLineNum = 94;BA.debugLine="ToastMessageShow(\"Rellena todos los campos\",True";
Debug.ShouldStop(536870912);
registrar_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Rellena todos los campos")),(Object)(registrar_activity.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnregistrar_click() throws Exception{
try {
		Debug.PushSubsStack("btnRegistrar_Click (registrar_activity) ","registrar_activity",6,registrar_activity.mostCurrent.activityBA,registrar_activity.mostCurrent,132);
if (RapidSub.canDelegate("btnregistrar_click")) { return com.monitorflux.registrar_activity.remoteMe.runUserSub(false, "registrar_activity","btnregistrar_click");}
RemoteObject _nombre = RemoteObject.createImmutable("");
RemoteObject _datos = RemoteObject.createImmutable("");
 BA.debugLineNum = 132;BA.debugLine="Sub btnRegistrar_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 133;BA.debugLine="If etNombre.Text == \"\" Or etCorreoR.Text ==\"\" Or";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",registrar_activity.mostCurrent._etnombre.runMethod(true,"getText"),BA.ObjectToString("")) || RemoteObject.solveBoolean("=",registrar_activity.mostCurrent._etcorreor.runMethod(true,"getText"),BA.ObjectToString("")) || RemoteObject.solveBoolean("=",registrar_activity.mostCurrent._etpasswordr.runMethod(true,"getText"),BA.ObjectToString("")) || RemoteObject.solveBoolean("=",registrar_activity.mostCurrent._etconfirm.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 134;BA.debugLine="ToastMessageShow(\"Error! ... Aegurate de llenar";
Debug.ShouldStop(32);
registrar_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Error! ... Aegurate de llenar todos los campos")),(Object)(registrar_activity.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 136;BA.debugLine="If etPasswordR.Text <> etConfirm.Text Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("!",registrar_activity.mostCurrent._etpasswordr.runMethod(true,"getText"),registrar_activity.mostCurrent._etconfirm.runMethod(true,"getText"))) { 
 BA.debugLineNum = 137;BA.debugLine="ToastMessageShow(\"Error! ... Las contraseñas no";
Debug.ShouldStop(256);
registrar_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Error! ... Las contraseñas no coinciden")),(Object)(registrar_activity.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 139;BA.debugLine="Dim correo As String = etCorreoR.Text";
Debug.ShouldStop(1024);
registrar_activity.mostCurrent._correo = registrar_activity.mostCurrent._etcorreor.runMethod(true,"getText");
 BA.debugLineNum = 140;BA.debugLine="Dim clave As String = etPasswordR.Text";
Debug.ShouldStop(2048);
registrar_activity.mostCurrent._clave = registrar_activity.mostCurrent._etpasswordr.runMethod(true,"getText");
 BA.debugLineNum = 141;BA.debugLine="Dim Nombre As String = etNombre.Text";
Debug.ShouldStop(4096);
_nombre = registrar_activity.mostCurrent._etnombre.runMethod(true,"getText");Debug.locals.put("Nombre", _nombre);Debug.locals.put("Nombre", _nombre);
 BA.debugLineNum = 142;BA.debugLine="Dim datos As String";
Debug.ShouldStop(8192);
_datos = RemoteObject.createImmutable("");Debug.locals.put("datos", _datos);
 BA.debugLineNum = 143;BA.debugLine="datos = \"{\"&Chr(34)&\"email\"&Chr(34)&\":\"&Chr(34)";
Debug.ShouldStop(16384);
_datos = RemoteObject.concat(RemoteObject.createImmutable("{"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("email"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(":"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),registrar_activity.mostCurrent._correo,registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(","),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("password"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(":"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),registrar_activity.mostCurrent._clave,registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(","),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("name"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(":"),registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),_nombre,registrar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("}"));Debug.locals.put("datos", _datos);
 BA.debugLineNum = 144;BA.debugLine="Registrar.PostString(urlRegistrar, datos)";
Debug.ShouldStop(32768);
registrar_activity.mostCurrent._registrar.runClassMethod (com.monitorflux.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(registrar_activity.mostCurrent._urlregistrar),(Object)(_datos));
 BA.debugLineNum = 145;BA.debugLine="Registrar.GetRequest.SetContentType(\"applicatio";
Debug.ShouldStop(65536);
registrar_activity.mostCurrent._registrar.runClassMethod (com.monitorflux.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
 BA.debugLineNum = 146;BA.debugLine="ProgressDialogShow(\"Registro en proceso\")";
Debug.ShouldStop(131072);
registrar_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",registrar_activity.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Registro en proceso"))));
 };
 };
 BA.debugLineNum = 149;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
 //BA.debugLineNum = 15;BA.debugLine="Dim IniciarSesion As HttpJob";
registrar_activity.mostCurrent._iniciarsesion = RemoteObject.createNew ("com.monitorflux.httpjob");
 //BA.debugLineNum = 16;BA.debugLine="Dim Registrar As HttpJob";
registrar_activity.mostCurrent._registrar = RemoteObject.createNew ("com.monitorflux.httpjob");
 //BA.debugLineNum = 17;BA.debugLine="Private etCorreo As EditText";
registrar_activity.mostCurrent._etcorreo = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private etPassword As EditText";
registrar_activity.mostCurrent._etpassword = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private urlIniciar As String";
registrar_activity.mostCurrent._urliniciar = RemoteObject.createImmutable("");
 //BA.debugLineNum = 20;BA.debugLine="Private etNombre As EditText";
registrar_activity.mostCurrent._etnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private etConfirm As EditText";
registrar_activity.mostCurrent._etconfirm = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private etCorreoR As EditText";
registrar_activity.mostCurrent._etcorreor = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private etPasswordR As EditText";
registrar_activity.mostCurrent._etpasswordr = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private urlRegistrar As String";
registrar_activity.mostCurrent._urlregistrar = RemoteObject.createImmutable("");
 //BA.debugLineNum = 25;BA.debugLine="Private correo As String";
registrar_activity.mostCurrent._correo = RemoteObject.createImmutable("");
 //BA.debugLineNum = 26;BA.debugLine="Private clave As String";
registrar_activity.mostCurrent._clave = RemoteObject.createImmutable("");
 //BA.debugLineNum = 27;BA.debugLine="Private cbMantener As CheckBox";
registrar_activity.mostCurrent._cbmantener = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _handleerror(RemoteObject _res) throws Exception{
try {
		Debug.PushSubsStack("handleError (registrar_activity) ","registrar_activity",6,registrar_activity.mostCurrent.activityBA,registrar_activity.mostCurrent,164);
if (RapidSub.canDelegate("handleerror")) { return com.monitorflux.registrar_activity.remoteMe.runUserSub(false, "registrar_activity","handleerror", _res);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _code = RemoteObject.createImmutable(0);
RemoteObject _mesage = RemoteObject.createImmutable("");
Debug.locals.put("res", _res);
 BA.debugLineNum = 164;BA.debugLine="Sub handleError(res As String)";
Debug.ShouldStop(8);
 BA.debugLineNum = 165;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(16);
registrar_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 166;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(32);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 167;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(64);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 168;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(128);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 169;BA.debugLine="Dim code As Int = root.Get(\"code\")";
Debug.ShouldStop(256);
_code = BA.numberCast(int.class, _root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("code")))));Debug.locals.put("code", _code);Debug.locals.put("code", _code);
 BA.debugLineNum = 170;BA.debugLine="Dim mesage As String";
Debug.ShouldStop(512);
_mesage = RemoteObject.createImmutable("");Debug.locals.put("mesage", _mesage);
 BA.debugLineNum = 171;BA.debugLine="Select code";
Debug.ShouldStop(1024);
switch (BA.switchObjectToInt(_code,BA.numberCast(int.class, 3003),BA.numberCast(int.class, 3033),BA.numberCast(int.class, 3087))) {
case 0: {
 BA.debugLineNum = 173;BA.debugLine="mesage = \"El correo o la contraseña no son corr";
Debug.ShouldStop(4096);
_mesage = BA.ObjectToString("El correo o la contraseña no son correctos");Debug.locals.put("mesage", _mesage);
 break; }
case 1: {
 BA.debugLineNum = 175;BA.debugLine="mesage = \"El usuario ya esta registrado\"";
Debug.ShouldStop(16384);
_mesage = BA.ObjectToString("El usuario ya esta registrado");Debug.locals.put("mesage", _mesage);
 break; }
case 2: {
 BA.debugLineNum = 177;BA.debugLine="mesage = \"No puedes iniciar sesion, primero deb";
Debug.ShouldStop(65536);
_mesage = BA.ObjectToString("No puedes iniciar sesion, primero debes confirmar tu email");Debug.locals.put("mesage", _mesage);
 break; }
default: {
 BA.debugLineNum = 179;BA.debugLine="mesage = root.Get(\"message\")";
Debug.ShouldStop(262144);
_mesage = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("message")))));Debug.locals.put("mesage", _mesage);
 break; }
}
;
 BA.debugLineNum = 182;BA.debugLine="MsgboxAsync(mesage,\"Error\")";
Debug.ShouldStop(2097152);
registrar_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence(_mesage)),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),registrar_activity.processBA);
 BA.debugLineNum = 183;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("JobDone (registrar_activity) ","registrar_activity",6,registrar_activity.mostCurrent.activityBA,registrar_activity.mostCurrent,47);
if (RapidSub.canDelegate("jobdone")) { return com.monitorflux.registrar_activity.remoteMe.runUserSub(false, "registrar_activity","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 47;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(32768);
registrar_activity.mostCurrent.__c.runVoidMethod ("LogImpl","14849665",RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname" /*RemoteObject*/ ),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success" /*RemoteObject*/ )),0);
 BA.debugLineNum = 49;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),registrar_activity.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 50;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
Debug.ShouldStop(131072);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("iniciar"),BA.ObjectToString("registrar"))) {
case 0: {
 BA.debugLineNum = 52;BA.debugLine="resInicio(Job.GetString) 'se envia la cadena r";
Debug.ShouldStop(524288);
_resinicio(_job.runClassMethod (com.monitorflux.httpjob.class, "_getstring" /*RemoteObject*/ ));
 break; }
case 1: {
 BA.debugLineNum = 54;BA.debugLine="resRegistrar(Job.GetString)";
Debug.ShouldStop(2097152);
_resregistrar(_job.runClassMethod (com.monitorflux.httpjob.class, "_getstring" /*RemoteObject*/ ));
 break; }
}
;
 }else {
 BA.debugLineNum = 57;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(16777216);
registrar_activity.mostCurrent.__c.runVoidMethod ("LogImpl","14849674",RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )),0);
 BA.debugLineNum = 58;BA.debugLine="handleError(Job.ErrorMessage)";
Debug.ShouldStop(33554432);
_handleerror(_job.getField(true,"_errormessage" /*RemoteObject*/ ));
 };
 BA.debugLineNum = 61;BA.debugLine="Job.Release";
Debug.ShouldStop(268435456);
_job.runClassMethod (com.monitorflux.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbregistrar_click() throws Exception{
try {
		Debug.PushSubsStack("lbRegistrar_Click (registrar_activity) ","registrar_activity",6,registrar_activity.mostCurrent.activityBA,registrar_activity.mostCurrent,65);
if (RapidSub.canDelegate("lbregistrar_click")) { return com.monitorflux.registrar_activity.remoteMe.runUserSub(false, "registrar_activity","lbregistrar_click");}
 BA.debugLineNum = 65;BA.debugLine="Sub lbRegistrar_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 66;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(2);
registrar_activity.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 67;BA.debugLine="Activity.LoadLayout(\"Registrar\")";
Debug.ShouldStop(4);
registrar_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Registrar")),registrar_activity.mostCurrent.activityBA);
 BA.debugLineNum = 68;BA.debugLine="Registrar.Initialize(\"registrar\",Me)";
Debug.ShouldStop(8);
registrar_activity.mostCurrent._registrar.runClassMethod (com.monitorflux.httpjob.class, "_initialize" /*RemoteObject*/ ,registrar_activity.processBA,(Object)(BA.ObjectToString("registrar")),(Object)(registrar_activity.getObject()));
 BA.debugLineNum = 69;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
Debug.ShouldStop(16);
_setstatusbarcolor(registrar_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 222))));
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
public static RemoteObject  _resinicio(RemoteObject _res) throws Exception{
try {
		Debug.PushSubsStack("resInicio (registrar_activity) ","registrar_activity",6,registrar_activity.mostCurrent.activityBA,registrar_activity.mostCurrent,99);
if (RapidSub.canDelegate("resinicio")) { return com.monitorflux.registrar_activity.remoteMe.runUserSub(false, "registrar_activity","resinicio", _res);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("res", _res);
 BA.debugLineNum = 99;BA.debugLine="Sub resInicio(res As String)";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(8);
registrar_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 101;BA.debugLine="Main.inicio = True";
Debug.ShouldStop(16);
registrar_activity.mostCurrent._main._inicio /*RemoteObject*/  = registrar_activity.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 102;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(32);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 103;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(64);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 104;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(128);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 105;BA.debugLine="Main.ID = root.Get(\"objectId\")";
Debug.ShouldStop(256);
registrar_activity.mostCurrent._main._id /*RemoteObject*/  = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("objectId")))));
 BA.debugLineNum = 107;BA.debugLine="If cbMantener.Checked Then";
Debug.ShouldStop(1024);
if (registrar_activity.mostCurrent._cbmantener.runMethod(true,"getChecked").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 108;BA.debugLine="Starter.actualizarCampos(\"usuario\",correo,\"id\",\"";
Debug.ShouldStop(2048);
registrar_activity.mostCurrent._starter.runVoidMethod ("_actualizarcampos" /*RemoteObject*/ ,(Object)(BA.ObjectToString("usuario")),(Object)(registrar_activity.mostCurrent._correo),(Object)(BA.ObjectToString("id")),(Object)(RemoteObject.createImmutable("1")));
 BA.debugLineNum = 109;BA.debugLine="Starter.actualizarCampos(\"clave\",clave,\"id\",\"1\")";
Debug.ShouldStop(4096);
registrar_activity.mostCurrent._starter.runVoidMethod ("_actualizarcampos" /*RemoteObject*/ ,(Object)(BA.ObjectToString("clave")),(Object)(registrar_activity.mostCurrent._clave),(Object)(BA.ObjectToString("id")),(Object)(RemoteObject.createImmutable("1")));
 BA.debugLineNum = 110;BA.debugLine="Starter.actualizarCampos(\"mantener\",\"1\",\"id\",\"1\"";
Debug.ShouldStop(8192);
registrar_activity.mostCurrent._starter.runVoidMethod ("_actualizarcampos" /*RemoteObject*/ ,(Object)(BA.ObjectToString("mantener")),(Object)(BA.ObjectToString("1")),(Object)(BA.ObjectToString("id")),(Object)(RemoteObject.createImmutable("1")));
 };
 BA.debugLineNum = 113;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
registrar_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _resregistrar(RemoteObject _res) throws Exception{
try {
		Debug.PushSubsStack("resRegistrar (registrar_activity) ","registrar_activity",6,registrar_activity.mostCurrent.activityBA,registrar_activity.mostCurrent,151);
if (RapidSub.canDelegate("resregistrar")) { return com.monitorflux.registrar_activity.remoteMe.runUserSub(false, "registrar_activity","resregistrar", _res);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _nombre = RemoteObject.createImmutable("");
RemoteObject _titulo = RemoteObject.createImmutable("");
Debug.locals.put("res", _res);
 BA.debugLineNum = 151;BA.debugLine="Sub resRegistrar(res As String)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 152;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(8388608);
registrar_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 153;BA.debugLine="Dim parser As JSONParser 						'definimos objeto";
Debug.ShouldStop(16777216);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 154;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(33554432);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 155;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(67108864);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 156;BA.debugLine="Dim nombre As String = root.Get(\"name\")";
Debug.ShouldStop(134217728);
_nombre = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))));Debug.locals.put("nombre", _nombre);Debug.locals.put("nombre", _nombre);
 BA.debugLineNum = 157;BA.debugLine="Dim titulo As String = \"Hola \" & nombre";
Debug.ShouldStop(268435456);
_titulo = RemoteObject.concat(RemoteObject.createImmutable("Hola "),_nombre);Debug.locals.put("titulo", _titulo);Debug.locals.put("titulo", _titulo);
 BA.debugLineNum = 158;BA.debugLine="MsgboxAsync(\"Tu usuario ha sido registrado correc";
Debug.ShouldStop(536870912);
registrar_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Tu usuario ha sido registrado correctamente, puedes activar tu cuenta desde el correo que ha sido enviado a tu email")),(Object)(BA.ObjectToCharSequence(_titulo)),registrar_activity.processBA);
 BA.debugLineNum = 159;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(1073741824);
registrar_activity.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 160;BA.debugLine="Activity.LoadLayout(\"Iniciar\")";
Debug.ShouldStop(-2147483648);
registrar_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Iniciar")),registrar_activity.mostCurrent.activityBA);
 BA.debugLineNum = 161;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
Debug.ShouldStop(1);
_setstatusbarcolor(registrar_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 222))));
 BA.debugLineNum = 162;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("SetStatusBarColor (registrar_activity) ","registrar_activity",6,registrar_activity.mostCurrent.activityBA,registrar_activity.mostCurrent,116);
if (RapidSub.canDelegate("setstatusbarcolor")) { return com.monitorflux.registrar_activity.remoteMe.runUserSub(false, "registrar_activity","setstatusbarcolor", _clr);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _window = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("clr", _clr);
 BA.debugLineNum = 116;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 117;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(1048576);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 118;BA.debugLine="If p.SdkVersion >= 21 Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 21))) { 
 BA.debugLineNum = 119;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(4194304);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 120;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(8388608);
_jo.runVoidMethod ("InitializeContext",registrar_activity.processBA);
 BA.debugLineNum = 121;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
Debug.ShouldStop(16777216);
_window = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_window = _jo.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getWindow")),(Object)((registrar_activity.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("window", _window);Debug.locals.put("window", _window);
 BA.debugLineNum = 122;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
Debug.ShouldStop(33554432);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("addFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x80000000))})));
 BA.debugLineNum = 123;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
Debug.ShouldStop(67108864);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("clearFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x04000000))})));
 BA.debugLineNum = 124;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
Debug.ShouldStop(134217728);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setStatusBarColor")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_clr)})));
 };
 BA.debugLineNum = 126;BA.debugLine="If p.SdkVersion >= 23 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 23))) { 
 BA.debugLineNum = 127;BA.debugLine="jo = Activity";
Debug.ShouldStop(1073741824);
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), registrar_activity.mostCurrent._activity.getObject());
 BA.debugLineNum = 128;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
Debug.ShouldStop(-2147483648);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setSystemUiVisibility")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((8192))})));
 };
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
}