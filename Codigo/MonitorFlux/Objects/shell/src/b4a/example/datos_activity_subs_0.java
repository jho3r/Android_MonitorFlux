package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class datos_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,18);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 18;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 21;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(1048576);
datos_activity.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 22;BA.debugLine="Activity.LoadLayout(\"Datos\")";
Debug.ShouldStop(2097152);
datos_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Datos")),datos_activity.mostCurrent.activityBA);
 BA.debugLineNum = 23;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("Activity_Pause (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,29);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 31;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Resume (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,25);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","activity_resume");}
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("btnAtrasE_Click (datos_activity) ","datos_activity",5,datos_activity.mostCurrent.activityBA,datos_activity.mostCurrent,34);
if (RapidSub.canDelegate("btnatrase_click")) { return b4a.example.datos_activity.remoteMe.runUserSub(false, "datos_activity","btnatrase_click");}
 BA.debugLineNum = 34;BA.debugLine="Sub btnAtrasE_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 35;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4);
datos_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}