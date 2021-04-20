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
	Dim ime As IME					'Creo un ime (necesita libreria) para poner un maximo de caracteres a et
	Private etNombre As EditText
	Private etNumero As EditText
	Private smsReceiver As SmsInterceptor
	Dim rp As RuntimePermissions   'requiere libreria runtime permissions
	'Private etTiempo As AutoCompleteEditText
	'Dim horas As List
	
	Private nombre As String
	Private numero As String
	Private descripcion As String
	Private checkbox As Boolean
	Private etDescrip As EditText
	Private cbMensajes As CheckBox
	Private urlAgregar As String
	Private Agregar As HttpJob
	Dim enviarSMS As PhoneSms
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.RemoveAllViews
	Activity.LoadLayout("Agregar")
	SetStatusBarColor(Colors.RGB(231,231,222))
	ime.Initialize("")					'inicializo el ime
	ime.SetLengthFilter(etNombre,24)	'Determino el limite de caracteres
	ime.SetLengthFilter(etNumero,10)	'Determino el limite de caracteres
	
	'horas.Initialize
	'horas.Add("1 hora")
	'horas.Add("4 horas")
	'horas.Add("12 horas")
	'horas.Add("1 dia")
	'horas.Add("Asíncrono")
	'etTiempo.SetItems(horas)
	rp.CheckAndRequest(rp.PERMISSION_RECEIVE_SMS) 'INICIAMOS proceso de verificar permiso recibir SMS
	Wait For Activity_PermissionResult(Permission As String, Result As Boolean) 'esperamos por repuesta de usuario
	If Result Then
		ToastMessageShow("Permiso para recibir mensaje en uso",True)
	End If
	smsReceiver.Initialize("smsReceiver")
	urlAgregar = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Dispositivos"
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub btnAtrasA_Click
	smsReceiver.StopListening
	Activity.Finish
End Sub

Sub btnConectar_Click
	nombre = etNombre.Text
	numero = etNumero.Text
	descripcion = etDescrip.Text
	checkbox = cbMensajes.Checked
	enviarSMS.Send2(numero,"000004",False,False)
	ProgressDialogShow("Conectando con el dispositivo... Espere un momento")
	Log("nombre: " & nombre & " numero: " & numero & " descripcion: " & descripcion & " enviar mensajes aqui: " & checkbox)
End Sub


'Sub etTiempo_FocusChanged (HasFocus As Boolean)
	'If HasFocus = True Then
	'	etTiempo.ShowDropDown
	'End If
'End Sub

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

Sub smsReceiver_MessageReceived (From As String, Body As String) As Boolean
	If From == numero Then
		ProgressDialogHide
		Dim codigo As String = Body
		smsReceiver.StopListening
		Agregar.Initialize("agregar",Me)
		Dim datos As String
		
		datos = "{"&Chr(34)&"descripcion"&Chr(34)&":"&Chr(34)&descripcion&Chr(34)&","&Chr(34)&"id"&Chr(34)&":"&Chr(34)&codigo&Chr(34)&","&Chr(34)&"nombre"&Chr(34)&":"&Chr(34)&nombre&Chr(34)&","&Chr(34)&"numero"&Chr(34)&":"&Chr(34)&numero&Chr(34)&","&Chr(34)&"ownerId"&Chr(34)&":"&Chr(34)&Main.ID&Chr(34)&"}"
		Agregar.PostString(urlAgregar, datos)
		Agregar.GetRequest.SetContentType("application/json")
		ProgressDialogShow("Regitrando dispositivo")
	End If
	Return True
End Sub

Sub JobDone (Job As HttpJob)
	Log("JobName = " & Job.JobName & ", Success = " & Job.Success)
	If Job.Success = True Then
		Select Job.JobName 'Nombre del proceso a traves del cual se realizo la peticion
			Case "agregar"
				resAgregar(Job.GetString) 'se envia la cadena recibida para procesar
		End Select
	Else
		Log("Error: " & Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub

Sub resAgregar (res As String)
	ProgressDialogHide
	Log(res)
	Msgbox2Async("Dispositivo agregado correctamente","Listo!","Ok","","",Null,False)
	Wait For Msgbox_Result(Result As Int) 'Queda en espera hasta que el usuario responda
	If Result = DialogResponse.POSITIVE Then
		Activity.Finish
	End If
End Sub