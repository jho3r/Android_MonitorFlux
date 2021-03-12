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
 BA.debugLineNum = 23;BA.debugLine="wv1.LoadUrl(\"https://www.youtube.com/watch?v=z7Ph";
Debug.ShouldStop(4194304);
tutoriales_activity.mostCurrent._wv1.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://www.youtube.com/watch?v=z7PhdlezBfE")));
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_Pause (tutoriales_activity) ","tutoriales_activity",2,tutoriales_activity.mostCurrent.activityBA,tutoriales_activity.mostCurrent,30);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.tutoriales_activity.remoteMe.runUserSub(false, "tutoriales_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Resume (tutoriales_activity) ","tutoriales_activity",2,tutoriales_activity.mostCurrent.activityBA,tutoriales_activity.mostCurrent,26);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.tutoriales_activity.remoteMe.runUserSub(false, "tutoriales_activity","activity_resume");}
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("btnAtras_Click (tutoriales_activity) ","tutoriales_activity",2,tutoriales_activity.mostCurrent.activityBA,tutoriales_activity.mostCurrent,34);
if (RapidSub.canDelegate("btnatras_click")) { return b4a.example.tutoriales_activity.remoteMe.runUserSub(false, "tutoriales_activity","btnatras_click");}
 BA.debugLineNum = 34;BA.debugLine="Sub btnAtras_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 35;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4);
tutoriales_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
}