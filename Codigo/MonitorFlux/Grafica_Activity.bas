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
	Private rtChart As LineChart
	Dim ph As Phone  
	Dim historial As HttpJob
	Dim urlHistorial As String
	Private mes As Int
	Private flujo As Int
	Private arrN() As Long
	Private arrMes() As Long
	Private arrGrafica1() As Float
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	
	SetStatusBarColor(Colors.Black)
	ph.SetScreenOrientation(-1)
	historial.Initialize("historial",Me)
	urlHistorial = "https://api.backendless.com/4D75900B-E59C-1318-FF7D-6D0FBCB48400/A5201E9F-9465-4336-B56B-C606DDD986ED/data/Historial?where=id%3D'"& Datos_Activity.idActual &"'&property=fecha&property=mes&property=flujo"
	historial.Download(urlHistorial)
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub graficarLuminosidad
	Activity.LoadLayout("Graficas")
	rtChart.GraphPinchZoomable = True              'see note in this methods help about implimentation of this functionality
	rtChart.GraphBackgroundColor = Colors.Black
	rtChart.GraphFrameColor = Colors.Black
	rtChart.GraphFrameWidth = 0.0
	rtChart.GraphPlotAreaBackgroundColor = Colors.RGB(0X22,0X28,0X31)
	rtChart.GraphTitleTextSize = 15
	rtChart.GraphTitleColor = Colors.White
	rtChart.GraphTitleSkewX = -0.25
	rtChart.GraphTitleUnderline = False
	rtChart.GraphTitleBold = True
	rtChart.GraphTitle = "PROMEDIO MENSUAL"              'put this statement last

	rtChart.LegendBackgroundColor = Colors.Black                                                  'it will be converted to an Alpha = 100
	rtChart.LegendTextColor = Colors.Black
	rtChart.LegendTextSize = 0.0

	rtChart.DomianLabel = ""
	rtChart.DomainLabelColor = Colors.Black
	rtChart.DomainLabelTextSize = 0.0

	rtChart.XaxisGridLineColor = Colors.ARGB(100,0xdd,0xdd,0xdd)
	rtChart.XaxisGridLineWidth = 2.0
	rtChart.XaxisLabelTicks = 1
	rtChart.XaxisLabelOrientation = 0
	rtChart.XaxisLabelTextColor = Colors.RGB(0xdd,0xdd,0xdd)
	rtChart.XaxisLabelTextSize = 30.0
	rtChart.XAxisLabels = Array As String("Jan","Feb", "Mar","Apr", "May","Jun","Jul", "Aug","Sep","Oct","Nov","Dec")

	rtChart.YaxisDivisions = 9
	rtChart.YaxisShowZero = False
	rtChart.YaxisRange(-4, 32)
	rtChart.YaxisValueFormat = rtChart.ValueFormat_0               'could be ValueFormat_0, ValueFormat_1, ValueFormat_2, or ValueFormat_3
	rtChart.YaxisGridLineColor = Colors.ARGB(100,0xdd,0xdd,0xdd)
	rtChart.YaxisGridLineWidth = 2
	rtChart.YaxisLabelTicks = 1
	rtChart.YaxisLabelColor = Colors.RGB(0xdd,0xdd,0xdd)
	rtChart.YaxisLabelOrientation = 0
	rtChart.YaxisLabelTextSize = 30.0
	rtChart.YaxisTitleColor = Colors.RGB(0xdd,0xdd,0xdd)
	rtChart.YaxisTitleFakeBold = False
	rtChart.YaxisTitleTextSize = 40.0
	rtChart.YaxisTitleUnderline = False
	rtChart.YaxisTitleTextSkewness = 0
	rtChart.YaxisLabelAndTitleDistance = 60.0
	rtChart.YaxisTitle = "Litros/Minuto"                 'put this statement last
  
	rtChart.MaxNumberOfEntriesPerLineChart = 12                    'this value must be equal to the number of x-axis labels that you pass

	rtChart.Line_1_LegendText = ""
	rtChart.Line_1_Data = arrGrafica1 'Array As Float (22.0, 27.0, 29.0, 28.0, 26.0, 3.0, 3.0, 3.0, 9.0, 14.0,2.0,0.0)
	rtChart.Line_1_PointLabelTextColor = Colors.RGB(0xdd,0xdd,0xdd)
	rtChart.Line_1_PointLabelTextSize = 20.0
	rtChart.Line_1_LineColor = Colors.RGB(0xf0,0x54,0x54)
	rtChart.Line_1_LineWidth = 4.0
	rtChart.Line_1_PointColor = Colors.RGB(0xdd,0xdd,0xdd)
	rtChart.Line_1_PointSize = 20.0
	rtChart.Line_1_PointShape = rtChart.SHAPE_ROUND
	rtChart.Line_1_DrawDash = True
	rtChart.Line_1_DrawCubic = True

  
	rtChart.NumberOfLineCharts = 1                              'set the number of graphs to draw from the 1 to 5 graph that has been set up above
	
	rtChart.DrawTheGraphs


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
End Sub

Sub JobDone (Job As HttpJob)
	Log("JobName = " & Job.JobName & ", Success = " & Job.Success)
	If Job.Success = True Then
		Select Job.JobName 'Nombre del proceso a traves del cual se realizo la peticion
			Case "historial"
				Log(Job.GetString)
				analizarDatos(Job.GetString)
		End Select
	Else
		Log("Error: " & Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub

Sub analizarDatos (res As String)
	arrMes = Array As Long (0,0,0,0,0,0,0,0,0,0,0,0)
	arrN = Array As Long (0,0,0,0,0,0,0,0,0,0,0,0)
	arrGrafica1 = Array As Float (0,0,0,0,0,0,0,0,0,0,0,0)
	
	DateTime.DateFormat = "yyyy"
	Dim fechaActual As Long = DateTime.Date(DateTime.Now)
	fechaActual = fechaActual*100000000
	Log("" & fechaActual & arrMes.Length)
	
	Dim parser As JSONParser 						'definimos objeto que permite procesar JSON
	parser.Initialize(res)
	'se define una lista a la cual se le pueden agregar objetos con add, obtener con get, etc
	'se le agregan los datos parseados
	Dim root As List = parser.NextArray
	For Each colroot As Map In root				'map es similar a list solo que se hace con clave, dato y se añade con put
		If colroot.Get("fecha") >= fechaActual Then
			mes = colroot.Get("mes")
			flujo = colroot.Get("flujo")
			arrMes(mes-1) = arrMes(mes-1) + flujo
			arrN(mes-1) = arrN(mes-1) + 1
		End If
	Next
	Dim si As Boolean
	si=False
	For j=0 To 11
		If arrMes(j) <> 0 Then
			arrGrafica1(j) = arrMes(j)/arrN(j)
		End If
		si= True
	Next
	
	If si = True Then
		graficarLuminosidad
	End If
	
End Sub