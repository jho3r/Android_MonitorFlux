
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

public class datos_activity implements IRemote{
	public static datos_activity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public datos_activity() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("datos_activity"), "com.monitorflux.datos_activity");
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
		pcBA = new PCBA(this, datos_activity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _backendelessget = RemoteObject.declareNull("com.monitorflux.httpjob");
public static RemoteObject _historial = RemoteObject.declareNull("com.monitorflux.httpjob");
public static RemoteObject _eliminar = RemoteObject.declareNull("com.monitorflux.httpjob");
public static RemoteObject _lbnombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _urlget = RemoteObject.createImmutable("");
public static RemoteObject _urlhistorial = RemoteObject.createImmutable("");
public static RemoteObject _lbnumero = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbdescrip = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbestado = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbflujo = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbactualizado = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _idactual = RemoteObject.createImmutable("");
public static RemoteObject _objectid = RemoteObject.createImmutable("");
public static RemoteObject _panel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _urleliminar = RemoteObject.createImmutable("");
public static RemoteObject _rp = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
public static RemoteObject _enviarsms = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.PhoneSms");
public static RemoteObject _numero = RemoteObject.createImmutable("");
public static com.monitorflux.main _main = null;
public static com.monitorflux.starter _starter = null;
public static com.monitorflux.tutoriales_activity _tutoriales_activity = null;
public static com.monitorflux.agregar_activity _agregar_activity = null;
public static com.monitorflux.monitor_activity _monitor_activity = null;
public static com.monitorflux.registrar_activity _registrar_activity = null;
public static com.monitorflux.httputils2service _httputils2service = null;
public static com.monitorflux.dbutils _dbutils = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",datos_activity.mostCurrent._activity,"Agregar_Activity",Debug.moduleToString(com.monitorflux.agregar_activity.class),"backendelessGet",datos_activity.mostCurrent._backendelessget,"DBUtils",Debug.moduleToString(com.monitorflux.dbutils.class),"eliminar",datos_activity.mostCurrent._eliminar,"enviarSMS",datos_activity.mostCurrent._enviarsms,"historial",datos_activity.mostCurrent._historial,"HttpUtils2Service",Debug.moduleToString(com.monitorflux.httputils2service.class),"idActual",datos_activity.mostCurrent._idactual,"lbActualizado",datos_activity.mostCurrent._lbactualizado,"lbDescrip",datos_activity.mostCurrent._lbdescrip,"lbEstado",datos_activity.mostCurrent._lbestado,"lbFlujo",datos_activity.mostCurrent._lbflujo,"lbNombre",datos_activity.mostCurrent._lbnombre,"lbNumero",datos_activity.mostCurrent._lbnumero,"Main",Debug.moduleToString(com.monitorflux.main.class),"Monitor_Activity",Debug.moduleToString(com.monitorflux.monitor_activity.class),"numero",datos_activity.mostCurrent._numero,"objectId",datos_activity.mostCurrent._objectid,"panel",datos_activity.mostCurrent._panel,"Registrar_Activity",Debug.moduleToString(com.monitorflux.registrar_activity.class),"rp",datos_activity.mostCurrent._rp,"Starter",Debug.moduleToString(com.monitorflux.starter.class),"Tutoriales_Activity",Debug.moduleToString(com.monitorflux.tutoriales_activity.class),"urlEliminar",datos_activity.mostCurrent._urleliminar,"urlGet",datos_activity.mostCurrent._urlget,"urlHistorial",datos_activity.mostCurrent._urlhistorial};
}
}