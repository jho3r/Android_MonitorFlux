package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,28);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 29;BA.debugLine="If FirstTime=True Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_firsttime,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"Intro\")			'cargamos el layo";
Debug.ShouldStop(536870912);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Intro")),main.mostCurrent.activityBA);
 BA.debugLineNum = 31;BA.debugLine="tmrIntro.Initialize(\"tmrIntro\",3000)	'inicializa";
Debug.ShouldStop(1073741824);
main._tmrintro.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("tmrIntro")),(Object)(BA.numberCast(long.class, 3000)));
 BA.debugLineNum = 32;BA.debugLine="tmrIntro.Enabled = True					'Se ejecuta en tmrIn";
Debug.ShouldStop(-2147483648);
main._tmrintro.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 34;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(2);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 35;BA.debugLine="Activity.LoadLayout(\"Principal\")";
Debug.ShouldStop(4);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Principal")),main.mostCurrent.activityBA);
 };
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,45);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 45;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,41);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(256);
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnagregar_click() throws Exception{
try {
		Debug.PushSubsStack("btnAgregar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,59);
if (RapidSub.canDelegate("btnagregar_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnagregar_click");}
 BA.debugLineNum = 59;BA.debugLine="Sub btnAgregar_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="StartActivity(Agregar_Activity)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._agregar_activity.getObject())));
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
public static RemoteObject  _btnmonitoreo_click() throws Exception{
try {
		Debug.PushSubsStack("btnMonitoreo_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,55);
if (RapidSub.canDelegate("btnmonitoreo_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnmonitoreo_click");}
 BA.debugLineNum = 55;BA.debugLine="Sub btnMonitoreo_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="StartActivity(Monitor_Activity)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._monitor_activity.getObject())));
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btntutorial_click() throws Exception{
try {
		Debug.PushSubsStack("btnTutorial_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,63);
if (RapidSub.canDelegate("btntutorial_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btntutorial_click");}
 BA.debugLineNum = 63;BA.debugLine="Sub btnTutorial_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 64;BA.debugLine="StartActivity(Tutoriales_Activity)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._tutoriales_activity.getObject())));
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 24;BA.debugLine="Private lbFallas As Label";
main.mostCurrent._lbfallas = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private lbBombas As Label";
main.mostCurrent._lbbombas = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
tutoriales_activity_subs_0._process_globals();
agregar_activity_subs_0._process_globals();
monitor_activity_subs_0._process_globals();
datos_activity_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
tutoriales_activity.myClass = BA.getDeviceClass ("b4a.example.tutoriales_activity");
agregar_activity.myClass = BA.getDeviceClass ("b4a.example.agregar_activity");
monitor_activity.myClass = BA.getDeviceClass ("b4a.example.monitor_activity");
datos_activity.myClass = BA.getDeviceClass ("b4a.example.datos_activity");
httputils2service.myClass = BA.getDeviceClass ("b4a.example.httputils2service");
httpjob.myClass = BA.getDeviceClass ("b4a.example.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="Dim tmrIntro As Timer 'Timer para el intro de la";
main._tmrintro = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _tmrintro_tick() throws Exception{
try {
		Debug.PushSubsStack("tmrIntro_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,49);
if (RapidSub.canDelegate("tmrintro_tick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","tmrintro_tick");}
 BA.debugLineNum = 49;BA.debugLine="Sub tmrIntro_Tick";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(131072);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 51;BA.debugLine="Activity.LoadLayout(\"Principal\")		'cargamos la pa";
Debug.ShouldStop(262144);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Principal")),main.mostCurrent.activityBA);
 BA.debugLineNum = 52;BA.debugLine="tmrIntro.Enabled = False";
Debug.ShouldStop(524288);
main._tmrintro.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
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