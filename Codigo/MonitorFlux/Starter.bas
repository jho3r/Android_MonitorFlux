B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=9.9
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Public sql As SQL
	Public rp As RuntimePermissions
	Public usuarioAdmin As String
	Public claveAdmin As String
	Public usuario As String
	Public clave As String
	Public mantener As String
	
	
End Sub

Sub Service_Create
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.
	
End Sub

Sub Service_Start (StartingIntent As Intent)
	Service.StopAutomaticForeground 'Starter service can start in the foreground state in some edge cases.
	DBUtils.CopyDBFromAssets("monitor.db")
	sql.Initialize(DBUtils.GetDBFolder,"monitor.db",False)
	
	Dim mapConsulta As Map
	mapConsulta = DBUtils.ExecuteMap(sql,"SELECT * FROM admin",Null)
	'Datos de inicio de sesion para admin
	For i = 0 To mapConsulta.Size - 1
		Select mapConsulta.GetKeyAt(i)
			Case "usuario"
				usuarioAdmin = mapConsulta.GetValueAt(i)
			Case "clave"
				claveAdmin = mapConsulta.GetValueAt(i)
		End Select
		Log(mapConsulta.GetKeyAt(i)&","&mapConsulta.GetValueAt(i))
	Next
End Sub

Sub Service_TaskRemoved
	'This event will be raised when the user removes the app from the recent apps list.
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub

Sub checkMantener As Boolean
	Dim mapConsulta As Map
	mapConsulta.Initialize
	mapConsulta = DBUtils.ExecuteMap(sql,"SELECT * FROM login",Null)
	'Datos de inicio de sesion para admin
	For i = 0 To mapConsulta.Size-1
		Select mapConsulta.GetKeyAt(i)
			Case "usuario"
				usuario = mapConsulta.GetValueAt(i)
			Case "clave"
				clave = mapConsulta.GetValueAt(i)
			Case "mantener"
				mantener = mapConsulta.GetValueAt(i)
		End Select
		Log(mapConsulta.GetKeyAt(i)&","&mapConsulta.GetValueAt(i))
	Next
	
	If mantener = "1" Then
		Log("Mantener igual a 1 intentando incio de sesion")
		Return True
	Else
		Log("No se tiene mantener = 1, pasando a ventana de iniciar sesion")
		Return False
	End If
End Sub

Sub actualizarCampos(campoUp As String,parametroUp As String,campowhere As String,parametrowhere As String)
	Dim mapActualizar As Map
	mapActualizar.Initialize
	mapActualizar.Put(campowhere,parametrowhere)
	DBUtils.UpdateRecord(sql,"login",campoUp,parametroUp,mapActualizar)
	
	Dim mapConsulta As Map
	mapConsulta.Initialize
	mapConsulta = DBUtils.ExecuteMap(sql,"SELECT * FROM login",Null)
	'Datos de inicio de sesion para admin
	For i = 0 To mapConsulta.Size-1
		Select mapConsulta.GetKeyAt(i)
			Case "usuario"
				usuario = mapConsulta.GetValueAt(i)
			Case "clave"
				clave = mapConsulta.GetValueAt(i)
			Case "mantener"
				mantener = mapConsulta.GetValueAt(i)
		End Select
		Log(mapConsulta.GetKeyAt(i)&","&mapConsulta.GetValueAt(i) & "de dato actualizado")
	Next
End Sub