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