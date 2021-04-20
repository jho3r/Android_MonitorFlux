
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

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "com.monitorflux.main");
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
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _tmrintro = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _list = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _inicio = RemoteObject.createImmutable(false);
public static RemoteObject _id = RemoteObject.createImmutable("");
public static RemoteObject _urlhistorial = RemoteObject.createImmutable("");
public static RemoteObject _lbfallas = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbbombas = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _urlget = RemoteObject.createImmutable("");
public static RemoteObject _backendelessget = RemoteObject.declareNull("com.monitorflux.httpjob");
public static RemoteObject _i = RemoteObject.createImmutable(0);
public static RemoteObject _disfallando = RemoteObject.createImmutable(0);
public static RemoteObject _historial = RemoteObject.declareNull("com.monitorflux.httpjob");
public static RemoteObject _iniciarsesion = RemoteObject.declareNull("com.monitorflux.httpjob");
public static RemoteObject _urliniciar = RemoteObject.createImmutable("");
public static com.monitorflux.starter _starter = null;
public static com.monitorflux.tutoriales_activity _tutoriales_activity = null;
public static com.monitorflux.agregar_activity _agregar_activity = null;
public static com.monitorflux.monitor_activity _monitor_activity = null;
public static com.monitorflux.datos_activity _datos_activity = null;
public static com.monitorflux.registrar_activity _registrar_activity = null;
public static com.monitorflux.httputils2service _httputils2service = null;
public static com.monitorflux.dbutils _dbutils = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"Agregar_Activity",Debug.moduleToString(com.monitorflux.agregar_activity.class),"backendelessGet",main.mostCurrent._backendelessget,"Datos_Activity",Debug.moduleToString(com.monitorflux.datos_activity.class),"DBUtils",Debug.moduleToString(com.monitorflux.dbutils.class),"disFallando",main._disfallando,"historial",main.mostCurrent._historial,"HttpUtils2Service",Debug.moduleToString(com.monitorflux.httputils2service.class),"i",main._i,"ID",main._id,"IniciarSesion",main.mostCurrent._iniciarsesion,"inicio",main._inicio,"lbBombas",main.mostCurrent._lbbombas,"lbFallas",main.mostCurrent._lbfallas,"list",main._list,"Monitor_Activity",Debug.moduleToString(com.monitorflux.monitor_activity.class),"Registrar_Activity",Debug.moduleToString(com.monitorflux.registrar_activity.class),"Starter",Debug.moduleToString(com.monitorflux.starter.class),"tmrIntro",main._tmrintro,"Tutoriales_Activity",Debug.moduleToString(com.monitorflux.tutoriales_activity.class),"urlGet",main.mostCurrent._urlget,"urlHistorial",main._urlhistorial,"urlIniciar",main.mostCurrent._urliniciar,"xui",main._xui};
}
}