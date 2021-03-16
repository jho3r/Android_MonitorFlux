B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=10.2
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim backendelessGet As HttpJob 'se debe inicializar
	Dim nombreD As String
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private lvElectro As CustomListView
	Private lbDispositivo As B4XView
	Dim urlGet As String
	Dim i As Int
	Dim listAlterna As List
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.RemoveAllViews
	Activity.LoadLayout("Monitoreo")
	SetStatusBarColor(Colors.RGB(231,231,222))
	urlGet = "https://api.backendless.com/85B70858-2193-2A92-FF8E-BF8B113D4100/CC232E12-9D6D-40A6-A41A-23796B090767/data/Dispositivos"
	backendelessGet.Initialize("get",Me)
	backendelessGet.Download(urlGet)   'Cuando complete el proceso ejecutara jobDone
	listAlterna.Initialize
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub btnAtrasM_Click
	Activity.Finish
End Sub

Sub JobDone (Job As HttpJob)
	Log("JobName = " & Job.JobName & ", Success = " & Job.Success)
	If Job.Success = True Then
		Select Job.JobName 'Nombre del proceso a traves del cual se realizo la peticion
			Case "get"
				cargarValores(Job.GetString) 'se envia la cadena recibida para procesar
		End Select
	Else
		Log("Error: " & Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub

Sub cargarValores (res As String)
	i=0
	Dim parser As JSONParser 						'definimos objeto que permite procesar JSON
	parser.Initialize(res)
	'se define una lista a la cual se le pueden agregar objetos con add, obtener con get, etc
	'se le agregan los datos parseados
	Dim root As List = parser.NextArray
	For Each colroot As Map In root				'map es similar a list solo que se hace con clave, dato y se añade con put
		Dim nombre As String = colroot.Get("nombre")
		addItems(nombre,i)
		i = i + 1
	Next
End Sub

'https://www.bing.com/videos/search?q=list+view+b4a&docid=608046453639023701&mid=1876F562235070BDD5FF1876F562235070BDD5FF&view=detail&FORM=VIRE
Sub addItems (texto As String, orden As Int)
	Dim xui As XUI
	Dim p As B4XView = xui.CreatePanel("")
	p.SetLayoutAnimated(100,0,0,100%x,10%y)
	p.LoadLayout("Item")
	lbDispositivo.Text=(texto)
	lvElectro.Add(p,orden)
	listAlterna.Add(texto)
End Sub

Sub lvElectro_ItemClick (Index As Int, Value As Object)
	nombreD = listAlterna.Get(Value)
	StartActivity(Datos_Activity)
End Sub

Sub SetStatusBarColor(clr As Int)
	Dim p As Phone
	If p.SdkVersion >= 21 Then
		Dim jo As JavaObject
		jo.InitializeContext
		Dim window As JavaObject = jo.RunMethodJO("getWindow", Null)
		window.RunMethod("addFlags", Array (0x80000000))
		window.RunMethod("clearFlags", Array (0x04000000))
		window.RunMethod("setStatusBarColor", Array(clr))
	End If
	If p.SdkVersion >= 23 Then
		jo = Activity
		jo.RunMethod("setSystemUiVisibility", Array(8192)) 'SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
	End If
End Sub


