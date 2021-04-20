
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

public class monitor_activity implements IRemote{
	public static monitor_activity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public monitor_activity() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("monitor_activity"), "com.monitorflux.monitor_activity");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, monitor_activity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _backendelessget = RemoteObject.declareNull("com.monitorflux.httpjob");
public static RemoteObject _nombred = RemoteObject.createImmutable("");
public static RemoteObject _eliminado = RemoteObject.createImmutable(false);
public static RemoteObject _lvelectro = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _lbdispositivo = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _urlget = RemoteObject.createImmutable("");
public static RemoteObject _i = RemoteObject.createImmutable(0);
public static RemoteObject _listalterna = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _historial = RemoteObject.declareNull("com.monitorflux.httpjob");
public static RemoteObject _urlhistorial = RemoteObject.createImmutable("");
public static RemoteObject _disfallando = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static com.monitorflux.main _main = null;
public static com.monitorflux.starter _starter = null;
public static com.monitorflux.tutoriales_activity _tutoriales_activity = null;
public static com.monitorflux.agregar_activity _agregar_activity = null;
public static com.monitorflux.datos_activity _datos_activity = null;
public static com.monitorflux.registrar_activity _registrar_activity = null;
public static com.monitorflux.httputils2service _httputils2service = null;
public static com.monitorflux.dbutils _dbutils = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",monitor_activity.mostCurrent._activity,"Agregar_Activity",Debug.moduleToString(com.monitorflux.agregar_activity.class),"backendelessGet",monitor_activity._backendelessget,"Datos_Activity",Debug.moduleToString(com.monitorflux.datos_activity.class),"DBUtils",Debug.moduleToString(com.monitorflux.dbutils.class),"disFallando",monitor_activity.mostCurrent._disfallando,"eliminado",monitor_activity._eliminado,"historial",monitor_activity.mostCurrent._historial,"HttpUtils2Service",Debug.moduleToString(com.monitorflux.httputils2service.class),"i",monitor_activity._i,"lbDispositivo",monitor_activity.mostCurrent._lbdispositivo,"listAlterna",monitor_activity.mostCurrent._listalterna,"lvElectro",monitor_activity.mostCurrent._lvelectro,"Main",Debug.moduleToString(com.monitorflux.main.class),"nombreD",monitor_activity._nombred,"Registrar_Activity",Debug.moduleToString(com.monitorflux.registrar_activity.class),"Starter",Debug.moduleToString(com.monitorflux.starter.class),"Tutoriales_Activity",Debug.moduleToString(com.monitorflux.tutoriales_activity.class),"urlGet",monitor_activity.mostCurrent._urlget,"urlHistorial",monitor_activity.mostCurrent._urlhistorial};
}
}