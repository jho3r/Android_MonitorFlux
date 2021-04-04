
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

public class dbutils implements IRemote{
	public static dbutils mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public dbutils() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, dbutils.class);
    static {
		mostCurrent = new dbutils();
        remoteMe = RemoteObject.declareNull("b4a.example.dbutils");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("dbutils"), "b4a.example.dbutils");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("b4a.example.dbutils"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _db_real = RemoteObject.createImmutable("");
public static RemoteObject _db_integer = RemoteObject.createImmutable("");
public static RemoteObject _db_blob = RemoteObject.createImmutable("");
public static RemoteObject _db_text = RemoteObject.createImmutable("");
public static RemoteObject _htmlcss = RemoteObject.createImmutable("");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.tutoriales_activity _tutoriales_activity = null;
public static b4a.example.agregar_activity _agregar_activity = null;
public static b4a.example.monitor_activity _monitor_activity = null;
public static b4a.example.datos_activity _datos_activity = null;
public static b4a.example.registrar_activity _registrar_activity = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Agregar_Activity",Debug.moduleToString(b4a.example.agregar_activity.class),"Datos_Activity",Debug.moduleToString(b4a.example.datos_activity.class),"DB_BLOB",dbutils._db_blob,"DB_INTEGER",dbutils._db_integer,"DB_REAL",dbutils._db_real,"DB_TEXT",dbutils._db_text,"HtmlCSS",dbutils._htmlcss,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"Main",Debug.moduleToString(b4a.example.main.class),"Monitor_Activity",Debug.moduleToString(b4a.example.monitor_activity.class),"Registrar_Activity",Debug.moduleToString(b4a.example.registrar_activity.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"Tutoriales_Activity",Debug.moduleToString(b4a.example.tutoriales_activity.class)};
}
}