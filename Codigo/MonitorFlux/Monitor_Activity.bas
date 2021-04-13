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
	Public eliminado As Boolean
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private lvElectro As CustomListView
	Private lbDispositivo As B4XView
	Private urlGet As String
	Dim i As Int
	Dim listAlterna As List
	Dim historial As HttpJob
	Private urlHistorial As String
	Dim disFallando As List
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.RemoveAllViews
	Activity.LoadLayout("Monitoreo")
	SetStatusBarColor(Colors.RGB(231,231,222))
	urlGet = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos?where=ownerId%20%3D%20"
	urlHistorial = Main.urlHistorial
	historial.Initialize("historial",Me)
	listAlterna.Initialize
	disFallando.Initialize   'guarda el estado de los dispositivos
	eliminado = False
	historial.Download(urlHistorial)
End Sub

Sub Activity_Resume
	If eliminado = True Then
		Log("Eliminando actividad")
		Activity.Finish
	End If
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
			Case "historial"
				fallando(Job.GetString)
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
		Dim id As String = colroot.Get("id")
		addItems(nombre,i,id)
		i = i + 1
	Next
	
End Sub

Sub fallando(res As String)
	Dim fecha As Long = 0
	Dim parser As JSONParser 						'definimos objeto que permite procesar JSON
	parser.Initialize(res)
	Dim root As List = parser.NextArray
	For a=0 To Main.list.Size -1
		For Each colroot As Map In root				'map es similar a list solo que se hace con clave, dato y se añade con put
			' solo me interesan los datos que esten relacionados con la electrobomba actual
			If colroot.Get("id") = Main.list.Get(a) Then
				'guardo el valor de fecha para comparar y obtener la mas reciente
				Dim fechaEntra As Long = colroot.Get("fecha")
				If fechaEntra >= fecha Then
					Dim estado As String = colroot.Get("encendida")
					fecha = fechaEntra
				End If
			End If
		Next
		If estado = False Then
			disFallando.Add(Main.list.Get(a))
		End If
		fecha = 0
	Next
	
	backendelessGet.Initialize("get",Me)
	backendelessGet.Download(urlGet & "'" & Main.ID & "'")   'Cuando complete el proceso ejecutara jobDone
End Sub

'https://www.bing.com/videos/search?q=list+view+b4a&docid=608046453639023701&mid=1876F562235070BDD5FF1876F562235070BDD5FF&view=detail&FORM=VIRE
Sub addItems (texto As String, orden As Int, id As String)
	Dim xui As XUI
	Dim p As B4XView = xui.CreatePanel("")
	p.SetLayoutAnimated(100,0,0,100%x,10%y)
	p.LoadLayout("Item")
	lbDispositivo.Text=(texto)
	For a=0 To disFallando.Size-1
		If id = disFallando.Get(a) Then
			lbDispositivo.Color = Colors.ARGB(255,240,84,84)
		End If
	Next
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


