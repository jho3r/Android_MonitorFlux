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

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim backendelessGet As HttpJob 'se debe inicializar
	Dim historial As HttpJob
	Dim eliminar As HttpJob
	Private lbNombre As Label
	Private urlGet As String
	Private urlHistorial As String
	Private lbNumero As Label
	Private lbDescrip As Label
	Private lbEstado As Label
	Private lbFlujo As Label
	Private lbActualizado As Label
	Private idActual As String
	Private objectId As String
	Private panel As Panel
	Private urlEliminar As String
	Dim rp As RuntimePermissions   'requiere libreria runtime permissions
	Dim enviarSMS As PhoneSms
	Private numero As String
	Private smsReceiver As SmsInterceptor
	Private Agregar As HttpJob
	Private urlAgregar As String
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.RemoveAllViews
	Activity.LoadLayout("Datos")
	SetStatusBarColor(Colors.RGB(231,231,222))
	urlGet = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos?where=ownerId%20%3D%20"
	urlHistorial = Main.urlHistorial & "&property=flujo"
	backendelessGet.Initialize("get",Me)
	historial.Initialize("historial",Me)
	urlEliminar = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos/"
	urlAgregar = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Historial"
	rp.CheckAndRequest(rp.PERMISSION_RECEIVE_SMS) 'INICIAMOS proceso de verificar permiso recibir SMS
	Wait For Activity_PermissionResult(Permission As String, Result As Boolean) 'esperamos por repuesta de usuario
	If Result Then
		ToastMessageShow("Permiso para recibir mensaje en uso",True)
	End If
	
	
	backendelessGet.Download(urlGet & "'" & Main.ID & "'")			'para cargar los datos generales de la electrobomba
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub btnAtrasE_Click
	smsReceiver.StopListening
	Activity.Finish
End Sub

'LLegada del metodo download
Sub JobDone (Job As HttpJob)
	Log("JobName = " & Job.JobName & ", Success = " & Job.Success)
	If Job.Success = True Then
		Select Job.JobName 'Nombre del proceso a traves del cual se realizo la peticion
			Case "get"						
				cargarDatos(Job.GetString) 'se envia la cadena recibida para procesar
			Case "historial"
				cargarEstado(Job.GetString)
			Case "eliminar"
				'Log(Job.GetString)
				Msgbox2Async("Dispositivo eliminado correctamente","Listo!","Ok","","",Null,False)
				Wait For Msgbox_Result(Result As Int) 'Queda en espera hasta que el usuario responda
				If Result = DialogResponse.POSITIVE Then
					Monitor_Activity.eliminado = True
					Activity.Finish
				End If
			Case "agregar"
				resAgregar(Job.GetString)
		End Select
	Else
		Log("Error: " & Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub

'Obtengo los datos de backendeless para las caracteristicas generales de la electrobomba
Sub cargarDatos (res As String)
	Dim parser As JSONParser 						'definimos objeto que permite procesar JSON
	parser.Initialize(res)
	'se define una lista a la cual se le pueden agregar objetos con add, obtener con get, etc
	'se le agregan los datos parseados
	Dim root As List = parser.NextArray
	For Each colroot As Map In root				'map es similar a list solo que se hace con clave, dato y se añade con put
		If colroot.Get("nombre") = Monitor_Activity.nombreD Then
			Dim nombre As String = colroot.Get("nombre")
			Dim descripcion As String = colroot.Get("descripcion")
			numero = colroot.Get("numero")
			idActual = colroot.Get("id")
			objectId = colroot.Get("objectId")
		End If
	Next
	'asigno el texto a cada label
	lbNombre.Text = nombre
	lbNumero.Text = numero
	lbDescrip.Text = descripcion
	historial.Download(urlHistorial)
End Sub

'metodos para cargar los datos de funcionamiento de la electrobomba o dispositivo
Sub cargarEstado (res As String)
	Dim fecha As Long = 0
	Dim parser As JSONParser 						'definimos objeto que permite procesar JSON
	Log(res)
	parser.Initialize(res)
	'se define una lista a la cual se le pueden agregar objetos con add, obtener con get, etc
	'se le agregan los datos parseados
	Dim root As List = parser.NextArray
	For Each colroot As Map In root				'map es similar a list solo que se hace con clave, dato y se añade con put
		' solo me interesan los datos que esten relacionados con la electrobomba actual
		If colroot.Get("id") = idActual Then		
			'guardo el valor de fecha para comparar y obtener la mas reciente
			Dim fechaEntra As Long = colroot.Get("fecha")
			If fechaEntra >= fecha Then
				Dim estado As String = colroot.Get("encendida")		'guardo los datos para la fecha mas reciente
				Dim flujo As String = colroot.Get("flujo")
				Log(colroot.Get("flujo"))
				fecha = fechaEntra
			End If
		End If
	Next
	'control de colores para funcionamiento o falla de la electrobomba
	If estado = True Then
		lbEstado.Text = "Encendido"
		lbEstado.Color = Colors.ARGB(128,0,136,145)
	Else If estado = False Then
		lbEstado.Text = "Apagado"
		lbEstado.Color = Colors.ARGB(128,240,84,84)
	End If
	
	'cantidad de flujo a modo de texto en el label
	lbFlujo.Text = flujo & " Litros/Hora"
	
	'rutina para obtener la diferencia de fechas y poner en texto hace cuanto que no se actualizan los datos
	diferenciaDeFechas(fecha)
End Sub

Sub diferenciaDeFechas(fecha As Long){
	
	DateTime.DateFormat = "yyyyMMddHHmm"
	Dim fechaActual As Long = DateTime.Date(DateTime.Now)
	Dim actual As Long = fechaActual - fecha
	Dim actualModificado As Long
	Dim mensaje As String
	'Prueba de minutos de desactualizacion
	If actual < 100 Then
		actualModificado = fechaActual/100
		fechaActual = fechaActual - actualModificado*100
		actualModificado = fecha/100
		fecha = fecha - actualModificado*100
		If fecha <= fechaActual Then
			actualModificado = fechaActual - fecha
		Else
			actualModificado = fechaActual + (60 - fecha)
		End If
		
		mensaje = "Actualizado hace " & actualModificado & " minutos"
	'Prueba de horas de desactualizacion
	Else If actual < 10000 Then
		actualModificado = fechaActual/10000
		fechaActual = fechaActual - actualModificado*10000
		actualModificado = fecha/10000
		fecha = fecha - actualModificado*10000
		Log(fechaActual)
		Log(fecha)
		If fecha < fechaActual Then
			actualModificado = fechaActual/100 - fecha/100
		Else
			actualModificado = fechaActual/100 + (24 - fecha/100)
		End If
		
		mensaje = "Actualizado hace " & actualModificado & " horas"
		
	'Prueba de dias de desactualizacion
	Else If actual < 1000000 Then
		actualModificado = fechaActual/1000000
		fechaActual = fechaActual - actualModificado*1000000
		actualModificado = fecha/1000000
		fecha = fecha - actualModificado*1000000
		actualModificado = Abs(fechaActual - fecha)
		If fecha < fechaActual Then
			actualModificado = fechaActual/10000 - fecha/10000
		Else
			actualModificado = fechaActual/10000 + (30 - fecha/10000)
		End If
		
		mensaje = "Actualizado hace " & actualModificado & " dias"
		
	'Prueba de meses de desactulizacion
	Else If actual < 100000000 Then
		actualModificado = fechaActual/100000000
		fechaActual = fechaActual - actualModificado*100000000
		actualModificado = fecha/100000000
		fecha = fecha - actualModificado*100000000
		actualModificado = Abs(fechaActual - fecha)
		If fecha < fechaActual Then
			actualModificado = fechaActual/1000000 - fecha/1000000
		Else
			actualModificado = fechaActual/1000000 + (12 - fecha/1000000)
		End If
		
		mensaje = "Actualizado hace " & actualModificado & " meses"
	'mas de un año de desactualizado
	Else
		mensaje = "Desactualizado"
	End If
	lbActualizado.Text = mensaje
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

Sub btnMas_Click
	panel.Visible = Not(panel.Visible)
	
End Sub

Sub lbHistorial_Click
	Log("historial")
End Sub

Sub lbEliminar_Click
	eliminar.Initialize("eliminar",Me)
	Log("Eliminar")
	eliminar.Delete(urlEliminar & objectId)
End Sub

Sub Activity_Click
	panel.Visible = False
End Sub

Sub btnActualizar_Click
	enviarSMS.Send2(numero,"actualizar",False,False)
	smsReceiver.Initialize("smsReceiver")
	ProgressDialogShow("Conectando con el dispositivo... Espere un momento")
	
End Sub

Sub smsReceiver_MessageReceived (From As String, Body As String) As Boolean
	If From == numero Then
		ProgressDialogHide
		Dim flujo As String = Body
		Dim encendida As Boolean
		encendida = False
		If flujo > 3 Then
			encendida = True
		End If
		smsReceiver.StopListening
		DateTime.DateFormat = "yyyyMMddHHmm"
		Dim fecha As Long = DateTime.Date(DateTime.Now)
		
		Agregar.Initialize("agregar",Me)
		Dim datos As String
		datos = "{"&Chr(34)&"encendida"&Chr(34)&":"&Chr(34)&encendida&Chr(34)&","&Chr(34)&"id"&Chr(34)&":"&Chr(34)&idActual&Chr(34)&","&Chr(34)&"flujo"&Chr(34)&":"&Chr(34)&flujo&Chr(34)&","&Chr(34)&"fecha"&Chr(34)&":"&Chr(34)&fecha&Chr(34)&"}"
		Agregar.PostString(urlAgregar, datos)
		Agregar.GetRequest.SetContentType("application/json")
		ProgressDialogShow("Regitrando dispositivo")
	End If
	Return True
End Sub

Sub resAgregar (res As String)
	ProgressDialogHide
	Log(res)
	Msgbox2Async("Dato adquirido correctamente","Listo!","Ok","","",Null,False)
	Wait For Msgbox_Result(Result As Int) 'Queda en espera hasta que el usuario responda
	If Result = DialogResponse.POSITIVE Then
		historial.Download(urlHistorial)
	End If
End Sub