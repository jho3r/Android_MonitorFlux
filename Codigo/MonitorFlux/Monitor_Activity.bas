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
	Private lvElectro As CustomListView
	Private lbDispositivo As B4XView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.RemoveAllViews
	Activity.LoadLayout("Monitoreo")
	cargarValores
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub btnAtrasM_Click
	Activity.Finish
End Sub

Sub cargarValores
	addItems("123456789ABCDEF6789MNBVC",0)
	addItems("Electrobomba 2",1)
	addItems("Electrobomba 3",2)
	addItems("Electrobomba 4",3)
	addItems("Electrobomba 5",4)
	addItems("Electrobomba 6",5)
	addItems("Electrobomba 7",6)
	addItems("Electrobomba 8",7)
	addItems("Electrobomba 9",8)
	addItems("Electrobomba 10",9)
	addItems("Electrobomba 11",10)
	addItems("Electrobomba 12",11)
End Sub

'https://www.bing.com/videos/search?q=list+view+b4a&docid=608046453639023701&mid=1876F562235070BDD5FF1876F562235070BDD5FF&view=detail&FORM=VIRE
Sub addItems (texto As String, orden As Int)
	Dim xui As XUI
	Dim p As B4XView = xui.CreatePanel("")
	p.SetLayoutAnimated(100,0,0,100%x,10%y)
	p.LoadLayout("Item")
	lbDispositivo.Text=(texto)
	lvElectro.Add(p,orden)
End Sub

Sub lvElectro_ItemClick (Index As Int, Value As Object)
	StartActivity(Datos_Activity)
End Sub