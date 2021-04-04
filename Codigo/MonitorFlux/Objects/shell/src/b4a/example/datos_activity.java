
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("datos_activity"), "b4a.example.datos_activity");
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
public static RemoteObject _backendelessget = RemoteObject.declareNull("b4a.example.httpjob");
public static RemoteObject _historial = RemoteObject.declareNull("b4a.example.httpjob");
public static RemoteObject _lbnombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _urlget = RemoteObject.createImmutable("");
public static RemoteObject _urlhistorial = RemoteObject.createImmutable("");
public static RemoteObject _lbnumero = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbdescrip = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbestado = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbflujo = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbactualizado = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _idactual = RemoteObject.createImmutable("");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.tutoriales_activity _tutoriales_activity = null;
public static b4a.example.agregar_activity _agregar_activity = null;
public static b4a.example.monitor_activity _monitor_activity = null;
public static b4a.example.registrar_activity _registrar_activity = null;
public static b4a.example.httputils2service _httputils2service = null;
public static b4a.example.dbutils _dbutils = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",datos_activity.mostCurrent._activity,"Agregar_Activity",Debug.moduleToString(b4a.example.agregar_activity.class),"backendelessGet",datos_activity.mostCurrent._backendelessget,"DBUtils",Debug.moduleToString(b4a.example.dbutils.class),"historial",datos_activity.mostCurrent._historial,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"idActual",datos_activity.mostCurrent._idactual,"lbActualizado",datos_activity.mostCurrent._lbactualizado,"lbDescrip",datos_activity.mostCurrent._lbdescrip,"lbEstado",datos_activity.mostCurrent._lbestado,"lbFlujo",datos_activity.mostCurrent._lbflujo,"lbNombre",datos_activity.mostCurrent._lbnombre,"lbNumero",datos_activity.mostCurrent._lbnumero,"Main",Debug.moduleToString(b4a.example.main.class),"Monitor_Activity",Debug.moduleToString(b4a.example.monitor_activity.class),"Registrar_Activity",Debug.moduleToString(b4a.example.registrar_activity.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"Tutoriales_Activity",Debug.moduleToString(b4a.example.tutoriales_activity.class),"urlGet",datos_activity.mostCurrent._urlget,"urlHistorial",datos_activity.mostCurrent._urlhistorial};
}
}