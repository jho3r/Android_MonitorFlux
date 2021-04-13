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
	Dim IniciarSesion As HttpJob
	Dim Registrar As HttpJob
	Private etCorreo As EditText
	Private etPassword As EditText
	Private urlIniciar As String
	Private etNombre As EditText
	Private etConfirm As EditText
	Private etCorreoR As EditText
	Private etPasswordR As EditText
	Private urlRegistrar As String
	Private correo As String
	Private clave As String
	Private cbMantener As CheckBox
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("Iniciar")
	IniciarSesion.Initialize("iniciar",Me)
	urlIniciar = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/users/login"
	urlRegistrar = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/users/register"
	SetStatusBarColor(Colors.RGB(231,231,222))
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub JobDone (Job As HttpJob)
	Log("JobName = " & Job.JobName & ", Success = " & Job.Success)
	If Job.Success = True Then
		Select Job.JobName 'Nombre del proceso a traves del cual se realizo la peticion
			Case "iniciar"
				resInicio(Job.GetString) 'se envia la cadena recibida para procesar
			Case "registrar"
				resRegistrar(Job.GetString)
		End Select
	Else
		Log("Error: " & Job.ErrorMessage)
		handleError(Job.ErrorMessage)
		'ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub


Sub lbRegistrar_Click
	Activity.RemoveAllViews
	Activity.LoadLayout("Registrar")
	Registrar.Initialize("registrar",Me)
	SetStatusBarColor(Colors.RGB(231,231,222))
End Sub

Sub btnIniciar_Click
	If etCorreo.Text <> "" And etPassword.Text <> "" Then
		If etCorreo.Text.Contains("@") Then
			correo  = etCorreo.Text
			clave  = etPassword.Text
			Dim datos As String
			datos = "{"&Chr(34)&"login"&Chr(34)&":"&Chr(34)&correo&Chr(34)&","&Chr(34)&"password"&Chr(34)&":"&Chr(34)&clave&Chr(34)&"}"
			IniciarSesion.PostString(urlIniciar, datos)
			IniciarSesion.GetRequest.SetContentType("application/json")
			ProgressDialogShow("Iniciando sesión")
		Else If etCorreo.Text == "admin" And etPassword.Text == "admin" Then
			correo = Starter.usuarioAdmin
			clave = Starter.claveAdmin
			Dim datos As String
			datos = "{"&Chr(34)&"login"&Chr(34)&":"&Chr(34)&correo&Chr(34)&","&Chr(34)&"password"&Chr(34)&":"&Chr(34)&clave&Chr(34)&"}"
			IniciarSesion.PostString(urlIniciar, datos)
			IniciarSesion.GetRequest.SetContentType("application/json")
			ProgressDialogShow("Iniciando sesión")
		Else
			ToastMessageShow("Correo invalido",True)
		End If
	Else
		ToastMessageShow("Rellena todos los campos",True)
	End If
End Sub

'obtegno los valores del usuario y guardo el objectId para devolver los datos relacionados con el usuario
Sub resInicio(res As String)
	ProgressDialogHide
	Main.inicio = True
	Dim parser As JSONParser 						'definimos objeto que permite procesar JSON
	parser.Initialize(res)
	Dim root As Map = parser.NextObject
	Main.ID = root.Get("objectId")
	
	If cbMantener.Checked Then
		Starter.actualizarCampos("usuario",correo,"id","1")
		Starter.actualizarCampos("clave",clave,"id","1")
		Starter.actualizarCampos("mantener","1","id","1")
	End If
	
	Activity.Finish
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

Sub btnRegistrar_Click
	If etNombre.Text == "" Or etCorreoR.Text =="" Or etPasswordR.Text == "" Or etConfirm.Text == "" Then
		ToastMessageShow("Error! ... Aegurate de llenar todos los campos", True)
	Else
		If etPasswordR.Text <> etConfirm.Text Then
			ToastMessageShow("Error! ... Las contraseñas no coinciden",True)
		Else
			Dim correo As String = etCorreoR.Text
			Dim clave As String = etPasswordR.Text
			Dim Nombre As String = etNombre.Text
			Dim datos As String
			datos = "{"&Chr(34)&"email"&Chr(34)&":"&Chr(34)&correo&Chr(34)&","&Chr(34)&"password"&Chr(34)&":"&Chr(34)&clave&Chr(34)&","&Chr(34)&"name"&Chr(34)&":"&Chr(34)&Nombre&Chr(34)&"}"
			Registrar.PostString(urlRegistrar, datos)
			Registrar.GetRequest.SetContentType("application/json")
			ProgressDialogShow("Registro en proceso")
		End If
	End If
End Sub

Sub resRegistrar(res As String)
	ProgressDialogHide
	Dim parser As JSONParser 						'definimos objeto que permite procesar JSON
	parser.Initialize(res)
	Dim root As Map = parser.NextObject
	Dim nombre As String = root.Get("name")
	Dim titulo As String = "Hola " & nombre
	MsgboxAsync("Tu usuario ha sido registrado correctamente, puedes activar tu cuenta desde el correo que ha sido enviado a tu email",titulo)
	Activity.RemoveAllViews
	Activity.LoadLayout("Iniciar")
	SetStatusBarColor(Colors.RGB(231,231,222))
End Sub

Sub handleError(res As String)
	ProgressDialogHide
	Dim parser As JSONParser 						'definimos objeto que permite procesar JSON
	parser.Initialize(res)
	Dim root As Map = parser.NextObject
	Dim code As Int = root.Get("code")
	Dim mesage As String
	Select code
		Case 3003
			mesage = "El correo o la contraseña no son correctos"
		Case 3033
			mesage = "El usuario ya esta registrado"
		Case 3087
			mesage = "No puedes iniciar sesion, primero debes confirmar tu email"
		Case Else
			mesage = root.Get("message")
	End Select
	
	MsgboxAsync(mesage,"Error")
End Sub

Sub btnAtrasA_Click
	Activity.RemoveAllViews
	Activity.LoadLayout("Iniciar")
End Sub