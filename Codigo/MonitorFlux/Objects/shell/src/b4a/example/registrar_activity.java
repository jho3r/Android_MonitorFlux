
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class registrar_activity implements IRemote{
	public static registrar_activity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public registrar_activity() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("registrar_activity"), "b4a.example.registrar_activity");
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
		pcBA = new PCBA(this, registrar_activity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _iniciarsesion = RemoteObject.declareNull("b4a.example.httpjob");
public static RemoteObject _registrar = RemoteObject.declareNull("b4a.example.httpjob");
public static RemoteObject _etcorreo = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _etpassword = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _urliniciar = RemoteObject.createImmutable("");
public static RemoteObject _etnombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _etconfirm = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _etcorreor = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _etpasswordr = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _urlregistrar = RemoteObject.createImmutable("");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.tutoriales_activity _tutoriales_activity = null;
public static b4a.example.agregar_activity _agregar_activity = null;
public static b4a.example.monitor_activity _monitor_activity = null;
public static b4a.example.datos_activity _datos_activity = null;
public static b4a.example.httputils2service _httputils2service = null;
public static b4a.example.dbutils _dbutils = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",registrar_activity.mostCurrent._activity,"Agregar_Activity",Debug.moduleToString(b4a.example.agregar_activity.class),"Datos_Activity",Debug.moduleToString(b4a.example.datos_activity.class),"DBUtils",Debug.moduleToString(b4a.example.dbutils.class),"etConfirm",registrar_activity.mostCurrent._etconfirm,"etCorreo",registrar_activity.mostCurrent._etcorreo,"etCorreoR",registrar_activity.mostCurrent._etcorreor,"etNombre",registrar_activity.mostCurrent._etnombre,"etPassword",registrar_activity.mostCurrent._etpassword,"etPasswordR",registrar_activity.mostCurrent._etpasswordr,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"IniciarSesion",registrar_activity.mostCurrent._iniciarsesion,"Main",Debug.moduleToString(b4a.example.main.class),"Monitor_Activity",Debug.moduleToString(b4a.example.monitor_activity.class),"Registrar",registrar_activity.mostCurrent._registrar,"Starter",Debug.moduleToString(b4a.example.starter.class),"Tutoriales_Activity",Debug.moduleToString(b4a.example.tutoriales_activity.class),"urlIniciar",registrar_activity.mostCurrent._urliniciar,"urlRegistrar",registrar_activity.mostCurrent._urlregistrar};
}
}