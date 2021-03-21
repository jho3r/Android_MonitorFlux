package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class tutoriales_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (tutoriales_activity) ","tutoriales_activity",2,tutoriales_activity.mostCurrent.activityBA,tutoriales_activity.mostCurrent,18);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.tutoriales_activity.remoteMe.runUserSub(false, "tutoriales_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 18;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 21;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(1048576);
tutoriales_activity.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 22;BA.debugLine="Activity.LoadLayout(\"Tutorial\")";
Debug.ShouldStop(2097152);
tutoriales_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Tutorial")),tutoriales_activity.mostCurrent.activityBA);
 BA.debugLineNum = 23;BA.debugLine="wv1.LoadUrl(\"https://www.youtube-nocookie.com/emb";
Debug.ShouldStop(4194304);
tutoriales_activity.mostCurrent._wv1.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://www.youtube-nocookie.com/embed/2pOUQB_Cvpw")));
 BA.debugLineNum = 24;BA.debugLine="SetStatusBarColor(Colors.RGB(231,231,222))";
Debug.ShouldStop(8388608);
_setstatusbarcolor(tutoriales_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 231)),(Object)(BA.numberCast(int.class, 222))));
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Pause (tutoriales_activity) ","tutoriales_activity",2,tutoriales_activity.mostCurrent.activityBA,tutoriales_activity.mostCurrent,31);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.tutoriales_activity.remoteMe.runUserSub(false, "tutoriales_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Resume (tutoriales_activity) ","tutoriales_activity",2,tutoriales_activity.mostCurrent.activityBA,tutoriales_activity.mostCurrent,27);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.tutoriales_activity.remoteMe.runUserSub(false, "tutoriales_activity","activity_resume");}
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnatras_click() throws Exception{
try {
		Debug.PushSubsStack("btnAtras_Click (tutoriales_activity) ","tutoriales_activity",2,tutoriales_activity.mostCurrent.activityBA,tutoriales_activity.mostCurrent,35);
if (RapidSub.canDelegate("btnatras_click")) { return b4a.example.tutoriales_activity.remoteMe.runUserSub(false, "tutoriales_activity","btnatras_click");}
 BA.debugLineNum = 35;BA.debugLine="Sub btnAtras_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8);
tutoriales_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private wv1 As WebView";
tutoriales_activity.mostCurrent._wv1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setstatusbarcolor(RemoteObject _clr) throws Exception{
try {
		Debug.PushSubsStack("SetStatusBarColor (tutoriales_activity) ","tutoriales_activity",2,tutoriales_activity.mostCurrent.activityBA,tutoriales_activity.mostCurrent,39);
if (RapidSub.canDelegate("setstatusbarcolor")) { return b4a.example.tutoriales_activity.remoteMe.runUserSub(false, "tutoriales_activity","setstatusbarcolor", _clr);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _window = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("clr", _clr);
 BA.debugLineNum = 39;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
Debug.ShouldStop(64);
 BA.debugLineNum = 40;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(128);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 41;BA.debugLine="If p.SdkVersion >= 21 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 21))) { 
 BA.debugLineNum = 42;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(512);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 43;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(1024);
_jo.runVoidMethod ("InitializeContext",tutoriales_activity.processBA);
 BA.debugLineNum = 44;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
Debug.ShouldStop(2048);
_window = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_window = _jo.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getWindow")),(Object)((tutoriales_activity.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("window", _window);Debug.locals.put("window", _window);
 BA.debugLineNum = 45;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
Debug.ShouldStop(4096);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("addFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x80000000))})));
 BA.debugLineNum = 46;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
Debug.ShouldStop(8192);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("clearFlags")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0x04000000))})));
 BA.debugLineNum = 47;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
Debug.ShouldStop(16384);
_window.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setStatusBarColor")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_clr)})));
 };
 BA.debugLineNum = 49;BA.debugLine="If p.SdkVersion >= 23 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 23))) { 
 BA.debugLineNum = 50;BA.debugLine="jo = Activity";
Debug.ShouldStop(131072);
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), tutoriales_activity.mostCurrent._activity.getObject());
 BA.debugLineNum = 51;BA.debugLine="jo.RunMethod(\"setSystemUiVisibility\", Array(8192";
Debug.ShouldStop(262144);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setSystemUiVisibility")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((8192))})));
 };
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
}