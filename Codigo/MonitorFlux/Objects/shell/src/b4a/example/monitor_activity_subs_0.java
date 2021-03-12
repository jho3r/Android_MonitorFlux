package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class monitor_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (monitor_activity) ","monitor_activity",3,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,19);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 19;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 22;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(2097152);
monitor_activity.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 23;BA.debugLine="Activity.LoadLayout(\"Monitoreo\")";
Debug.ShouldStop(4194304);
monitor_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Monitoreo")),monitor_activity.mostCurrent.activityBA);
 BA.debugLineNum = 24;BA.debugLine="cargarValores";
Debug.ShouldStop(8388608);
_cargarvalores();
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
		Debug.PushSubsStack("Activity_Pause (monitor_activity) ","monitor_activity",3,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,31);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (monitor_activity) ","monitor_activity",3,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,27);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","activity_resume");}
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
public static RemoteObject  _additems(RemoteObject _texto,RemoteObject _orden) throws Exception{
try {
		Debug.PushSubsStack("addItems (monitor_activity) ","monitor_activity",3,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,56);
if (RapidSub.canDelegate("additems")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","additems", _texto, _orden);}
RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
Debug.locals.put("texto", _texto);
Debug.locals.put("orden", _orden);
 BA.debugLineNum = 56;BA.debugLine="Sub addItems (texto As String, orden As Int)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 57;BA.debugLine="Dim xui As XUI";
Debug.ShouldStop(16777216);
_xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");Debug.locals.put("xui", _xui);
 BA.debugLineNum = 58;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(33554432);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p = _xui.runMethod(false,"CreatePanel",monitor_activity.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 59;BA.debugLine="p.SetLayoutAnimated(100,0,0,100%x,10%y)";
Debug.ShouldStop(67108864);
_p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(monitor_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),monitor_activity.mostCurrent.activityBA)),(Object)(monitor_activity.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),monitor_activity.mostCurrent.activityBA)));
 BA.debugLineNum = 60;BA.debugLine="p.LoadLayout(\"Item\")";
Debug.ShouldStop(134217728);
_p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Item")),monitor_activity.mostCurrent.activityBA);
 BA.debugLineNum = 61;BA.debugLine="lbDispositivo.Text=(texto)";
Debug.ShouldStop(268435456);
monitor_activity.mostCurrent._lbdispositivo.runMethod(true,"setText",BA.ObjectToCharSequence((_texto)));
 BA.debugLineNum = 62;BA.debugLine="lvElectro.Add(p,orden)";
Debug.ShouldStop(536870912);
monitor_activity.mostCurrent._lvelectro.runVoidMethod ("_add",(Object)(_p),(Object)((_orden)));
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
public static RemoteObject  _btnatrasm_click() throws Exception{
try {
		Debug.PushSubsStack("btnAtrasM_Click (monitor_activity) ","monitor_activity",3,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,36);
if (RapidSub.canDelegate("btnatrasm_click")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","btnatrasm_click");}
 BA.debugLineNum = 36;BA.debugLine="Sub btnAtrasM_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16);
monitor_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _cargarvalores() throws Exception{
try {
		Debug.PushSubsStack("cargarValores (monitor_activity) ","monitor_activity",3,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,40);
if (RapidSub.canDelegate("cargarvalores")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","cargarvalores");}
 BA.debugLineNum = 40;BA.debugLine="Sub cargarValores";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="addItems(\"123456789ABCDEF6789MNBVC\",0)";
Debug.ShouldStop(256);
_additems(BA.ObjectToString("123456789ABCDEF6789MNBVC"),BA.numberCast(int.class, 0));
 BA.debugLineNum = 42;BA.debugLine="addItems(\"Electrobomba 2\",1)";
Debug.ShouldStop(512);
_additems(BA.ObjectToString("Electrobomba 2"),BA.numberCast(int.class, 1));
 BA.debugLineNum = 43;BA.debugLine="addItems(\"Electrobomba 3\",2)";
Debug.ShouldStop(1024);
_additems(BA.ObjectToString("Electrobomba 3"),BA.numberCast(int.class, 2));
 BA.debugLineNum = 44;BA.debugLine="addItems(\"Electrobomba 4\",3)";
Debug.ShouldStop(2048);
_additems(BA.ObjectToString("Electrobomba 4"),BA.numberCast(int.class, 3));
 BA.debugLineNum = 45;BA.debugLine="addItems(\"Electrobomba 5\",4)";
Debug.ShouldStop(4096);
_additems(BA.ObjectToString("Electrobomba 5"),BA.numberCast(int.class, 4));
 BA.debugLineNum = 46;BA.debugLine="addItems(\"Electrobomba 6\",5)";
Debug.ShouldStop(8192);
_additems(BA.ObjectToString("Electrobomba 6"),BA.numberCast(int.class, 5));
 BA.debugLineNum = 47;BA.debugLine="addItems(\"Electrobomba 7\",6)";
Debug.ShouldStop(16384);
_additems(BA.ObjectToString("Electrobomba 7"),BA.numberCast(int.class, 6));
 BA.debugLineNum = 48;BA.debugLine="addItems(\"Electrobomba 8\",7)";
Debug.ShouldStop(32768);
_additems(BA.ObjectToString("Electrobomba 8"),BA.numberCast(int.class, 7));
 BA.debugLineNum = 49;BA.debugLine="addItems(\"Electrobomba 9\",8)";
Debug.ShouldStop(65536);
_additems(BA.ObjectToString("Electrobomba 9"),BA.numberCast(int.class, 8));
 BA.debugLineNum = 50;BA.debugLine="addItems(\"Electrobomba 10\",9)";
Debug.ShouldStop(131072);
_additems(BA.ObjectToString("Electrobomba 10"),BA.numberCast(int.class, 9));
 BA.debugLineNum = 51;BA.debugLine="addItems(\"Electrobomba 11\",10)";
Debug.ShouldStop(262144);
_additems(BA.ObjectToString("Electrobomba 11"),BA.numberCast(int.class, 10));
 BA.debugLineNum = 52;BA.debugLine="addItems(\"Electrobomba 12\",11)";
Debug.ShouldStop(524288);
_additems(BA.ObjectToString("Electrobomba 12"),BA.numberCast(int.class, 11));
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private lvElectro As CustomListView";
monitor_activity.mostCurrent._lvelectro = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 16;BA.debugLine="Private lbDispositivo As B4XView";
monitor_activity.mostCurrent._lbdispositivo = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lvelectro_itemclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("lvElectro_ItemClick (monitor_activity) ","monitor_activity",3,monitor_activity.mostCurrent.activityBA,monitor_activity.mostCurrent,65);
if (RapidSub.canDelegate("lvelectro_itemclick")) { return b4a.example.monitor_activity.remoteMe.runUserSub(false, "monitor_activity","lvelectro_itemclick", _index, _value);}
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 65;BA.debugLine="Sub lvElectro_ItemClick (Index As Int, Value As Ob";
Debug.ShouldStop(1);
 BA.debugLineNum = 66;BA.debugLine="StartActivity(Datos_Activity)";
Debug.ShouldStop(2);
monitor_activity.mostCurrent.__c.runVoidMethod ("StartActivity",monitor_activity.processBA,(Object)((monitor_activity.mostCurrent._datos_activity.getObject())));
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
}