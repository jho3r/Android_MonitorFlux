package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class agregar_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (agregar_activity) ","agregar_activity",4,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 25;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(16777216);
agregar_activity.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 26;BA.debugLine="Activity.LoadLayout(\"Agregar\")";
Debug.ShouldStop(33554432);
agregar_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Agregar")),agregar_activity.mostCurrent.activityBA);
 BA.debugLineNum = 27;BA.debugLine="ime.Initialize(\"\")					'inicializo el ime";
Debug.ShouldStop(67108864);
agregar_activity.mostCurrent._ime.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 28;BA.debugLine="ime.SetLengthFilter(etNombre,24)	'Determino el li";
Debug.ShouldStop(134217728);
agregar_activity.mostCurrent._ime.runVoidMethod ("SetLengthFilter",(Object)((agregar_activity.mostCurrent._etnombre.getObject())),(Object)(BA.numberCast(int.class, 24)));
 BA.debugLineNum = 29;BA.debugLine="ime.SetLengthFilter(etNumero,10)	'Determino el li";
Debug.ShouldStop(268435456);
agregar_activity.mostCurrent._ime.runVoidMethod ("SetLengthFilter",(Object)((agregar_activity.mostCurrent._etnumero.getObject())),(Object)(BA.numberCast(int.class, 10)));
 BA.debugLineNum = 30;BA.debugLine="horas.Initialize";
Debug.ShouldStop(536870912);
agregar_activity.mostCurrent._horas.runVoidMethod ("Initialize");
 BA.debugLineNum = 31;BA.debugLine="horas.Add(\"1 hora\")";
Debug.ShouldStop(1073741824);
agregar_activity.mostCurrent._horas.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("1 hora"))));
 BA.debugLineNum = 32;BA.debugLine="horas.Add(\"4 horas\")";
Debug.ShouldStop(-2147483648);
agregar_activity.mostCurrent._horas.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("4 horas"))));
 BA.debugLineNum = 33;BA.debugLine="horas.Add(\"12 horas\")";
Debug.ShouldStop(1);
agregar_activity.mostCurrent._horas.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("12 horas"))));
 BA.debugLineNum = 34;BA.debugLine="horas.Add(\"1 dia\")";
Debug.ShouldStop(2);
agregar_activity.mostCurrent._horas.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("1 dia"))));
 BA.debugLineNum = 35;BA.debugLine="horas.Add(\"Asíncrono\")";
Debug.ShouldStop(4);
agregar_activity.mostCurrent._horas.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("Asíncrono"))));
 BA.debugLineNum = 36;BA.debugLine="etTiempo.SetItems(horas)";
Debug.ShouldStop(8);
agregar_activity.mostCurrent._ettiempo.runVoidMethod ("SetItems",agregar_activity.processBA,(Object)(agregar_activity.mostCurrent._horas));
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
		Debug.PushSubsStack("Activity_Pause (agregar_activity) ","agregar_activity",4,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,43);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (agregar_activity) ","agregar_activity",4,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,39);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","activity_resume");}
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
		Debug.PushSubsStack("btnAtrasA_Click (agregar_activity) ","agregar_activity",4,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,48);
if (RapidSub.canDelegate("btnatrasa_click")) { return b4a.example.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","btnatrasa_click");}
 BA.debugLineNum = 48;BA.debugLine="Sub btnAtrasA_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
agregar_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _btnconectar_click() throws Exception{
try {
		Debug.PushSubsStack("btnConectar_Click (agregar_activity) ","agregar_activity",4,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,52);
if (RapidSub.canDelegate("btnconectar_click")) { return b4a.example.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","btnconectar_click");}
 BA.debugLineNum = 52;BA.debugLine="Sub btnConectar_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ettiempo_focuschanged(RemoteObject _hasfocus) throws Exception{
try {
		Debug.PushSubsStack("etTiempo_FocusChanged (agregar_activity) ","agregar_activity",4,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,57);
if (RapidSub.canDelegate("ettiempo_focuschanged")) { return b4a.example.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","ettiempo_focuschanged", _hasfocus);}
Debug.locals.put("HasFocus", _hasfocus);
 BA.debugLineNum = 57;BA.debugLine="Sub etTiempo_FocusChanged (HasFocus As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 58;BA.debugLine="If HasFocus = True Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_hasfocus,agregar_activity.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 59;BA.debugLine="etTiempo.ShowDropDown";
Debug.ShouldStop(67108864);
agregar_activity.mostCurrent._ettiempo.runVoidMethod ("ShowDropDown");
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim ime As IME					'Creo un ime (necesita libreri";
agregar_activity.mostCurrent._ime = RemoteObject.createNew ("anywheresoftware.b4a.objects.IME");
 //BA.debugLineNum = 16;BA.debugLine="Private etNombre As EditText";
agregar_activity.mostCurrent._etnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private etNumero As EditText";
agregar_activity.mostCurrent._etnumero = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private etTiempo As AutoCompleteEditText";
agregar_activity.mostCurrent._ettiempo = RemoteObject.createNew ("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim horas As List";
agregar_activity.mostCurrent._horas = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}