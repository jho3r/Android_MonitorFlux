package com.monitorflux;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class agregar_activity_subs_0 {


public static void  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,33);
if (RapidSub.canDelegate("activity_create")) { com.monitorflux.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","activity_create", _firsttime); return;}
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
public ResumableSub_Activity_Create(com.monitorflux.agregar_activity parent,RemoteObject _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
com.monitorflux.agregar_activity parent;
RemoteObject _firsttime;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,33);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 36;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(8);
parent.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 37;BA.debugLine="Activity.LoadLayout(\"Agregar\")";
Debug.ShouldStop(16);
parent.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Agregar")),agregar_activity.mostCurrent.activityBA);
 BA.debugLineNum = 38;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
Debug.ShouldStop(32);
_setstatusbarcolor(parent.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 222))));
 BA.debugLineNum = 39;BA.debugLine="ime.Initialize(\"\")					'inicializo el ime";
Debug.ShouldStop(64);
parent.mostCurrent._ime.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 40;BA.debugLine="ime.SetLengthFilter(etNombre,24)	'Determino el li";
Debug.ShouldStop(128);
parent.mostCurrent._ime.runVoidMethod ("SetLengthFilter",(Object)((parent.mostCurrent._etnombre.getObject())),(Object)(BA.numberCast(int.class, 24)));
 BA.debugLineNum = 41;BA.debugLine="ime.SetLengthFilter(etNumero,10)	'Determino el li";
Debug.ShouldStop(256);
parent.mostCurrent._ime.runVoidMethod ("SetLengthFilter",(Object)((parent.mostCurrent._etnumero.getObject())),(Object)(BA.numberCast(int.class, 10)));
 BA.debugLineNum = 50;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_RECEIVE_SMS) 'IN";
Debug.ShouldStop(131072);
parent.mostCurrent._rp.runVoidMethod ("CheckAndRequest",agregar_activity.processBA,(Object)(parent.mostCurrent._rp.getField(true,"PERMISSION_RECEIVE_SMS")));
 BA.debugLineNum = 51;BA.debugLine="Wait For Activity_PermissionResult(Permission As";
Debug.ShouldStop(262144);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", agregar_activity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "agregar_activity", "activity_create"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 52;BA.debugLine="If Result Then";
Debug.ShouldStop(524288);
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
 BA.debugLineNum = 53;BA.debugLine="ToastMessageShow(\"Permiso para recibir mensaje e";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Permiso para recibir mensaje en uso")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 55;BA.debugLine="smsReceiver.Initialize(\"smsReceiver\")";
Debug.ShouldStop(4194304);
parent.mostCurrent._smsreceiver.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("smsReceiver")),agregar_activity.processBA);
 BA.debugLineNum = 56;BA.debugLine="urlAgregar = \"https://api.backendless.com/4D75900";
Debug.ShouldStop(8388608);
parent.mostCurrent._urlagregar = BA.ObjectToString("https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos");
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Pause (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,63);
if (RapidSub.canDelegate("activity_pause")) { return com.monitorflux.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,59);
if (RapidSub.canDelegate("activity_resume")) { return com.monitorflux.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","activity_resume");}
 BA.debugLineNum = 59;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(67108864);
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
public static RemoteObject  _btnatrasa_click() throws Exception{
try {
		Debug.PushSubsStack("btnAtrasA_Click (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,68);
if (RapidSub.canDelegate("btnatrasa_click")) { return com.monitorflux.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","btnatrasa_click");}
 BA.debugLineNum = 68;BA.debugLine="Sub btnAtrasA_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 69;BA.debugLine="smsReceiver.StopListening";
Debug.ShouldStop(16);
agregar_activity.mostCurrent._smsreceiver.runVoidMethod ("StopListening");
 BA.debugLineNum = 70;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32);
agregar_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _btnconectar_click() throws Exception{
try {
		Debug.PushSubsStack("btnConectar_Click (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,73);
if (RapidSub.canDelegate("btnconectar_click")) { return com.monitorflux.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","btnconectar_click");}
 BA.debugLineNum = 73;BA.debugLine="Sub btnConectar_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="ProgressDialogShow(\"Conectando con el dispositivo";
Debug.ShouldStop(512);
agregar_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",agregar_activity.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Conectando con el dispositivo... Espere un momento"))));
 BA.debugLineNum = 75;BA.debugLine="nombre = etNombre.Text";
Debug.ShouldStop(1024);
agregar_activity.mostCurrent._nombre = agregar_activity.mostCurrent._etnombre.runMethod(true,"getText");
 BA.debugLineNum = 76;BA.debugLine="numero = etNumero.Text";
Debug.ShouldStop(2048);
agregar_activity.mostCurrent._numero = agregar_activity.mostCurrent._etnumero.runMethod(true,"getText");
 BA.debugLineNum = 77;BA.debugLine="descripcion = etDescrip.Text";
Debug.ShouldStop(4096);
agregar_activity.mostCurrent._descripcion = agregar_activity.mostCurrent._etdescrip.runMethod(true,"getText");
 BA.debugLineNum = 78;BA.debugLine="checkbox = cbMensajes.Checked";
Debug.ShouldStop(8192);
agregar_activity._checkbox = agregar_activity.mostCurrent._cbmensajes.runMethod(true,"getChecked");
 BA.debugLineNum = 79;BA.debugLine="Log(\"nombre: \" & nombre & \" numero: \" & numero &";
Debug.ShouldStop(16384);
agregar_activity.mostCurrent.__c.runVoidMethod ("LogImpl","12424838",RemoteObject.concat(RemoteObject.createImmutable("nombre: "),agregar_activity.mostCurrent._nombre,RemoteObject.createImmutable(" numero: "),agregar_activity.mostCurrent._numero,RemoteObject.createImmutable(" descripcion: "),agregar_activity.mostCurrent._descripcion,RemoteObject.createImmutable(" enviar mensajes aqui: "),agregar_activity._checkbox),0);
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim ime As IME					'Creo un ime (necesita libreri";
agregar_activity.mostCurrent._ime = RemoteObject.createNew ("anywheresoftware.b4a.objects.IME");
 //BA.debugLineNum = 16;BA.debugLine="Private etNombre As EditText";
agregar_activity.mostCurrent._etnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private etNumero As EditText";
agregar_activity.mostCurrent._etnumero = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private smsReceiver As SmsInterceptor";
agregar_activity.mostCurrent._smsreceiver = RemoteObject.createNew ("anywheresoftware.b4a.phone.PhoneEvents.SMSInterceptor");
 //BA.debugLineNum = 19;BA.debugLine="Dim rp As RuntimePermissions   'requiere libreria";
agregar_activity.mostCurrent._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 23;BA.debugLine="Private nombre As String";
agregar_activity.mostCurrent._nombre = RemoteObject.createImmutable("");
 //BA.debugLineNum = 24;BA.debugLine="Private numero As String";
agregar_activity.mostCurrent._numero = RemoteObject.createImmutable("");
 //BA.debugLineNum = 25;BA.debugLine="Private descripcion As String";
agregar_activity.mostCurrent._descripcion = RemoteObject.createImmutable("");
 //BA.debugLineNum = 26;BA.debugLine="Private checkbox As Boolean";
agregar_activity._checkbox = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 27;BA.debugLine="Private etDescrip As EditText";
agregar_activity.mostCurrent._etdescrip = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private cbMensajes As CheckBox";
agregar_activity.mostCurrent._cbmensajes = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private urlAgregar As String";
agregar_activity.mostCurrent._urlagregar = RemoteObject.createImmutable("");
 //BA.debugLineNum = 30;BA.debugLine="Private Agregar As HttpJob";
agregar_activity.mostCurrent._agregar = RemoteObject.createNew ("com.monitorflux.httpjob");
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,121);
if (RapidSub.canDelegate("jobdone")) { return com.monitorflux.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 121;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 122;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(33554432);
agregar_activity.mostCurrent.__c.runVoidMethod ("LogImpl","12621441",RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname" /*RemoteObject*/ ),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success" /*RemoteObject*/ )),0);
 BA.debugLineNum = 123;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),agregar_activity.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 124;BA.debugLine="Select Job.JobName 'Nombre del proceso a traves";
Debug.ShouldStop(134217728);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("agregar"))) {
case 0: {
 BA.debugLineNum = 126;BA.debugLine="resAgregar(Job.GetString) 'se envia la cadena";
Debug.ShouldStop(536870912);
_resagregar(_job.runClassMethod (com.monitorflux.httpjob.class, "_getstring" /*RemoteObject*/ ));
 break; }
}
;
 }else {
 BA.debugLineNum = 129;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(1);
agregar_activity.mostCurrent.__c.runVoidMethod ("LogImpl","12621448",RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )),0);
 BA.debugLineNum = 130;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(2);
agregar_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(agregar_activity.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 132;BA.debugLine="Job.Release";
Debug.ShouldStop(8);
_job.runClassMethod (com.monitorflux.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 133;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
public static void  _resagregar(RemoteObject _res) throws Exception{
try {
		Debug.PushSubsStack("resAgregar (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,135);
if (RapidSub.canDelegate("resagregar")) { com.monitorflux.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","resagregar", _res); return;}
ResumableSub_resAgregar rsub = new ResumableSub_resAgregar(null,_res);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_resAgregar extends BA.ResumableSub {
public ResumableSub_resAgregar(com.monitorflux.agregar_activity parent,RemoteObject _res) {
this.parent = parent;
this._res = _res;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
com.monitorflux.agregar_activity parent;
RemoteObject _res;
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("resAgregar (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,135);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("res", _res);
 BA.debugLineNum = 136;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 137;BA.debugLine="Log(res)";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","12686978",_res,0);
 BA.debugLineNum = 138;BA.debugLine="Msgbox2Async(\"Dispositivo agregado correctamente\"";
Debug.ShouldStop(512);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Dispositivo agregado correctamente")),(Object)(BA.ObjectToCharSequence("Listo!")),(Object)(BA.ObjectToString("Ok")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),agregar_activity.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 139;BA.debugLine="Wait For Msgbox_Result(Result As Int) 'Queda en e";
Debug.ShouldStop(1024);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", agregar_activity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "agregar_activity", "resagregar"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 140;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(2048);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 141;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4096);
parent.mostCurrent._activity.runVoidMethod ("Finish");
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
public static RemoteObject  _setstatusbarcolor(RemoteObject _clr) throws Exception{
try {
		Debug.PushSubsStack("SetStatusBarColor (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,89);
if (RapidSub.canDelegate("setstatusbarcolor")) { return com.monitorflux.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","setstatusbarcolor", _clr);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _window = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("clr", _clr);
 BA.debugLineNum = 89;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(33554432);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 91;BA.debugLine="If p.SdkVersion >= 21 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 21))) { 
 BA.debugLineNum = 92;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(134217728);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 93;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(268435456);
_jo.runVoidMethod ("InitializeContext",agregar_activity.processBA);
 BA.debugLineNum = 94;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
Debug.ShouldStop(536870912);
_window = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_window = _jo.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getWindow")),(Object)((agregar_activity.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("window", _window);Debug.locals.put("window", _window);
 BA.debugLineNum = 95;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
Debug.ShouldStop(1073741824);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("addFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x80000000))})));
 BA.debugLineNum = 96;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
Debug.ShouldStop(-2147483648);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("clearFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x04000000))})));
 BA.debugLineNum = 97;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
Debug.ShouldStop(1);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setStatusBarColor")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_clr)})));
 };
 BA.debugLineNum = 99;BA.debugLine="If p.SdkVersion >= 23 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 23))) { 
 BA.debugLineNum = 100;BA.debugLine="jo = Activity";
Debug.ShouldStop(8);
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), agregar_activity.mostCurrent._activity.getObject());
 BA.debugLineNum = 101;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
Debug.ShouldStop(16);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setSystemUiVisibility")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((8192))})));
 };
 BA.debugLineNum = 103;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _smsreceiver_messagereceived(RemoteObject _from,RemoteObject _body) throws Exception{
try {
		Debug.PushSubsStack("smsReceiver_MessageReceived (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,105);
if (RapidSub.canDelegate("smsreceiver_messagereceived")) { return com.monitorflux.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","smsreceiver_messagereceived", _from, _body);}
RemoteObject _codigo = RemoteObject.createImmutable("");
RemoteObject _datos = RemoteObject.createImmutable("");
Debug.locals.put("From", _from);
Debug.locals.put("Body", _body);
 BA.debugLineNum = 105;BA.debugLine="Sub smsReceiver_MessageReceived (From As String, B";
Debug.ShouldStop(256);
 BA.debugLineNum = 106;BA.debugLine="If From == numero Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_from,agregar_activity.mostCurrent._numero)) { 
 BA.debugLineNum = 107;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(1024);
agregar_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 108;BA.debugLine="Dim codigo As String = Body";
Debug.ShouldStop(2048);
_codigo = _body;Debug.locals.put("codigo", _codigo);Debug.locals.put("codigo", _codigo);
 BA.debugLineNum = 109;BA.debugLine="smsReceiver.StopListening";
Debug.ShouldStop(4096);
agregar_activity.mostCurrent._smsreceiver.runVoidMethod ("StopListening");
 BA.debugLineNum = 110;BA.debugLine="Agregar.Initialize(\"agregar\",Me)";
Debug.ShouldStop(8192);
agregar_activity.mostCurrent._agregar.runClassMethod (com.monitorflux.httpjob.class, "_initialize" /*RemoteObject*/ ,agregar_activity.processBA,(Object)(BA.ObjectToString("agregar")),(Object)(agregar_activity.getObject()));
 BA.debugLineNum = 111;BA.debugLine="Dim datos As String";
Debug.ShouldStop(16384);
_datos = RemoteObject.createImmutable("");Debug.locals.put("datos", _datos);
 BA.debugLineNum = 113;BA.debugLine="datos = \"{\"&Chr(34)&\"descripcion\"&Chr(34)&\":\"&Ch";
Debug.ShouldStop(65536);
_datos = RemoteObject.concat(RemoteObject.createImmutable("{"),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("descripcion"),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(":"),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),agregar_activity.mostCurrent._descripcion,agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(","),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("id"),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(":"),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),_codigo,agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(","),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("nombre"),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(":"),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),agregar_activity.mostCurrent._nombre,agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(","),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("numero"),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(":"),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),agregar_activity.mostCurrent._numero,agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(","),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("ownerId"),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable(":"),agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),agregar_activity.mostCurrent._main._id /*RemoteObject*/ ,agregar_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 34))),RemoteObject.createImmutable("}"));Debug.locals.put("datos", _datos);
 BA.debugLineNum = 114;BA.debugLine="Agregar.PostString(urlAgregar, datos)";
Debug.ShouldStop(131072);
agregar_activity.mostCurrent._agregar.runClassMethod (com.monitorflux.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(agregar_activity.mostCurrent._urlagregar),(Object)(_datos));
 BA.debugLineNum = 115;BA.debugLine="Agregar.GetRequest.SetContentType(\"application/j";
Debug.ShouldStop(262144);
agregar_activity.mostCurrent._agregar.runClassMethod (com.monitorflux.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
 BA.debugLineNum = 116;BA.debugLine="ProgressDialogShow(\"Regitrando dispositivo\")";
Debug.ShouldStop(524288);
agregar_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",agregar_activity.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Regitrando dispositivo"))));
 };
 BA.debugLineNum = 118;BA.debugLine="Return True";
Debug.ShouldStop(2097152);
if (true) return agregar_activity.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}