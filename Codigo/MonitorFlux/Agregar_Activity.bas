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
	Private etTiempo As AutoCompleteEditText
	Dim horas As List
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
	horas.Initialize
	horas.Add("1 hora")
	horas.Add("4 horas")
	horas.Add("12 horas")
	horas.Add("1 dia")
	horas.Add("Asíncrono")
	etTiempo.SetItems(horas)
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub btnAtrasA_Click
	Activity.Finish
End Sub

Sub btnConectar_Click
	
End Sub


Sub etTiempo_FocusChanged (HasFocus As Boolean)
	If HasFocus = True Then
		etTiempo.ShowDropDown
	End If
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