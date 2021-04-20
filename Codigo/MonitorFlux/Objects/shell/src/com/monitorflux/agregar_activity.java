
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

public class agregar_activity implements IRemote{
	public static agregar_activity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public agregar_activity() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("agregar_activity"), "com.monitorflux.agregar_activity");
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
		pcBA = new PCBA(this, agregar_activity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _ime = RemoteObject.declareNull("anywheresoftware.b4a.objects.IME");
public static RemoteObject _etnombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _etnumero = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _smsreceiver = RemoteObject.declareNull("anywheresoftware.b4a.phone.PhoneEvents.SMSInterceptor");
public static RemoteObject _rp = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
public static RemoteObject _nombre = RemoteObject.createImmutable("");
public static RemoteObject _numero = RemoteObject.createImmutable("");
public static RemoteObject _descripcion = RemoteObject.createImmutable("");
public static RemoteObject _checkbox = RemoteObject.createImmutable(false);
public static RemoteObject _etdescrip = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _cbmensajes = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _urlagregar = RemoteObject.createImmutable("");
public static RemoteObject _agregar = RemoteObject.declareNull("com.monitorflux.httpjob");
public static com.monitorflux.main _main = null;
public static com.monitorflux.starter _starter = null;
public static com.monitorflux.tutoriales_activity _tutoriales_activity = null;
public static com.monitorflux.monitor_activity _monitor_activity = null;
public static com.monitorflux.datos_activity _datos_activity = null;
public static com.monitorflux.registrar_activity _registrar_activity = null;
public static com.monitorflux.httputils2service _httputils2service = null;
public static com.monitorflux.dbutils _dbutils = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",agregar_activity.mostCurrent._activity,"Agregar",agregar_activity.mostCurrent._agregar,"cbMensajes",agregar_activity.mostCurrent._cbmensajes,"checkbox",agregar_activity._checkbox,"Datos_Activity",Debug.moduleToString(com.monitorflux.datos_activity.class),"DBUtils",Debug.moduleToString(com.monitorflux.dbutils.class),"descripcion",agregar_activity.mostCurrent._descripcion,"etDescrip",agregar_activity.mostCurrent._etdescrip,"etNombre",agregar_activity.mostCurrent._etnombre,"etNumero",agregar_activity.mostCurrent._etnumero,"HttpUtils2Service",Debug.moduleToString(com.monitorflux.httputils2service.class),"ime",agregar_activity.mostCurrent._ime,"Main",Debug.moduleToString(com.monitorflux.main.class),"Monitor_Activity",Debug.moduleToString(com.monitorflux.monitor_activity.class),"nombre",agregar_activity.mostCurrent._nombre,"numero",agregar_activity.mostCurrent._numero,"Registrar_Activity",Debug.moduleToString(com.monitorflux.registrar_activity.class),"rp",agregar_activity.mostCurrent._rp,"smsReceiver",agregar_activity.mostCurrent._smsreceiver,"Starter",Debug.moduleToString(com.monitorflux.starter.class),"Tutoriales_Activity",Debug.moduleToString(com.monitorflux.tutoriales_activity.class),"urlAgregar",agregar_activity.mostCurrent._urlagregar};
}
}