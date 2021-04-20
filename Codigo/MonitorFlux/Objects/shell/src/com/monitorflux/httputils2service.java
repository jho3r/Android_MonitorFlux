
package com.monitorflux;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class httputils2service implements IRemote{
	public static httputils2service mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public httputils2service() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("httputils2service"), "com.monitorflux.httputils2service");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("com.monitorflux.httputils2service");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, httputils2service.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _hc = RemoteObject.declareNull("anywheresoftware.b4h.okhttp.OkHttpClientWrapper");
public static RemoteObject _taskidtojob = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _tempfolder = RemoteObject.createImmutable("");
public static RemoteObject _taskcounter = RemoteObject.createImmutable(0);
public static com.monitorflux.main _main = null;
public static com.monitorflux.starter _starter = null;
public static com.monitorflux.tutoriales_activity _tutoriales_activity = null;
public static com.monitorflux.agregar_activity _agregar_activity = null;
public static com.monitorflux.monitor_activity _monitor_activity = null;
public static com.monitorflux.datos_activity _datos_activity = null;
public static com.monitorflux.registrar_activity _registrar_activity = null;
public static com.monitorflux.dbutils _dbutils = null;
  public Object[] GetGlobals() {
		return new Object[] {"Agregar_Activity",Debug.moduleToString(com.monitorflux.agregar_activity.class),"Datos_Activity",Debug.moduleToString(com.monitorflux.datos_activity.class),"DBUtils",Debug.moduleToString(com.monitorflux.dbutils.class),"hc",httputils2service._hc,"Main",Debug.moduleToString(com.monitorflux.main.class),"Monitor_Activity",Debug.moduleToString(com.monitorflux.monitor_activity.class),"Registrar_Activity",Debug.moduleToString(com.monitorflux.registrar_activity.class),"Service",httputils2service.mostCurrent._service,"Starter",Debug.moduleToString(com.monitorflux.starter.class),"taskCounter",httputils2service._taskcounter,"TaskIdToJob",httputils2service._taskidtojob,"TempFolder",httputils2service._tempfolder,"Tutoriales_Activity",Debug.moduleToString(com.monitorflux.tutoriales_activity.class)};
}
}