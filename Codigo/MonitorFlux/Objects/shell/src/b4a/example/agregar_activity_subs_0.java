package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class agregar_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,22);
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
 BA.debugLineNum = 27;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
Debug.ShouldStop(67108864);
_setstatusbarcolor(agregar_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 222))));
 BA.debugLineNum = 28;BA.debugLine="ime.Initialize(\"\")					'inicializo el ime";
Debug.ShouldStop(134217728);
agregar_activity.mostCurrent._ime.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 29;BA.debugLine="ime.SetLengthFilter(etNombre,24)	'Determino el li";
Debug.ShouldStop(268435456);
agregar_activity.mostCurrent._ime.runVoidMethod ("SetLengthFilter",(Object)((agregar_activity.mostCurrent._etnombre.getObject())),(Object)(BA.numberCast(int.class, 24)));
 BA.debugLineNum = 30;BA.debugLine="ime.SetLengthFilter(etNumero,10)	'Determino el li";
Debug.ShouldStop(536870912);
agregar_activity.mostCurrent._ime.runVoidMethod ("SetLengthFilter",(Object)((agregar_activity.mostCurrent._etnumero.getObject())),(Object)(BA.numberCast(int.class, 10)));
 BA.debugLineNum = 31;BA.debugLine="horas.Initialize";
Debug.ShouldStop(1073741824);
agregar_activity.mostCurrent._horas.runVoidMethod ("Initialize");
 BA.debugLineNum = 32;BA.debugLine="horas.Add(\"1 hora\")";
Debug.ShouldStop(-2147483648);
agregar_activity.mostCurrent._horas.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("1 hora"))));
 BA.debugLineNum = 33;BA.debugLine="horas.Add(\"4 horas\")";
Debug.ShouldStop(1);
agregar_activity.mostCurrent._horas.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("4 horas"))));
 BA.debugLineNum = 34;BA.debugLine="horas.Add(\"12 horas\")";
Debug.ShouldStop(2);
agregar_activity.mostCurrent._horas.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("12 horas"))));
 BA.debugLineNum = 35;BA.debugLine="horas.Add(\"1 dia\")";
Debug.ShouldStop(4);
agregar_activity.mostCurrent._horas.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("1 dia"))));
 BA.debugLineNum = 36;BA.debugLine="horas.Add(\"Asíncrono\")";
Debug.ShouldStop(8);
agregar_activity.mostCurrent._horas.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("Asíncrono"))));
 BA.debugLineNum = 37;BA.debugLine="etTiempo.SetItems(horas)";
Debug.ShouldStop(16);
agregar_activity.mostCurrent._ettiempo.runVoidMethod ("SetItems",agregar_activity.processBA,(Object)(agregar_activity.mostCurrent._horas));
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
		Debug.PushSubsStack("Activity_Pause (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,44);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,40);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","activity_resume");}
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
public static RemoteObject  _btnatrasa_click() throws Exception{
try {
		Debug.PushSubsStack("btnAtrasA_Click (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,49);
if (RapidSub.canDelegate("btnatrasa_click")) { return b4a.example.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","btnatrasa_click");}
 BA.debugLineNum = 49;BA.debugLine="Sub btnAtrasA_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="Activity.Finish";
Debug.ShouldStop(131072);
agregar_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _btnconectar_click() throws Exception{
try {
		Debug.PushSubsStack("btnConectar_Click (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,53);
if (RapidSub.canDelegate("btnconectar_click")) { return b4a.example.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","btnconectar_click");}
 BA.debugLineNum = 53;BA.debugLine="Sub btnConectar_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("etTiempo_FocusChanged (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,58);
if (RapidSub.canDelegate("ettiempo_focuschanged")) { return b4a.example.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","ettiempo_focuschanged", _hasfocus);}
Debug.locals.put("HasFocus", _hasfocus);
 BA.debugLineNum = 58;BA.debugLine="Sub etTiempo_FocusChanged (HasFocus As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="If HasFocus = True Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_hasfocus,agregar_activity.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 60;BA.debugLine="etTiempo.ShowDropDown";
Debug.ShouldStop(134217728);
agregar_activity.mostCurrent._ettiempo.runVoidMethod ("ShowDropDown");
 };
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
public static RemoteObject  _setstatusbarcolor(RemoteObject _clr) throws Exception{
try {
		Debug.PushSubsStack("SetStatusBarColor (agregar_activity) ","agregar_activity",3,agregar_activity.mostCurrent.activityBA,agregar_activity.mostCurrent,64);
if (RapidSub.canDelegate("setstatusbarcolor")) { return b4a.example.agregar_activity.remoteMe.runUserSub(false, "agregar_activity","setstatusbarcolor", _clr);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _window = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("clr", _clr);
 BA.debugLineNum = 64;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 65;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(1);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 66;BA.debugLine="If p.SdkVersion >= 21 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 21))) { 
 BA.debugLineNum = 67;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(4);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 68;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(8);
_jo.runVoidMethod ("InitializeContext",agregar_activity.processBA);
 BA.debugLineNum = 69;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
Debug.ShouldStop(16);
_window = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_window = _jo.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getWindow")),(Object)((agregar_activity.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("window", _window);Debug.locals.put("window", _window);
 BA.debugLineNum = 70;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
Debug.ShouldStop(32);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("addFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x80000000))})));
 BA.debugLineNum = 71;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
Debug.ShouldStop(64);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("clearFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x04000000))})));
 BA.debugLineNum = 72;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
Debug.ShouldStop(128);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setStatusBarColor")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_clr)})));
 };
 BA.debugLineNum = 74;BA.debugLine="If p.SdkVersion >= 23 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 23))) { 
 BA.debugLineNum = 75;BA.debugLine="jo = Activity";
Debug.ShouldStop(1024);
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), agregar_activity.mostCurrent._activity.getObject());
 BA.debugLineNum = 76;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
Debug.ShouldStop(2048);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setSystemUiVisibility")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((8192))})));
 };
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}