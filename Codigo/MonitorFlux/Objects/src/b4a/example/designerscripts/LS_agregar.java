package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_agregar{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[Agregar/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="lbTitulo.Top=0"[Agregar/General script]
views.get("lbtitulo").vw.setTop((int)(0d));
//BA.debugLineNum = 4;BA.debugLine="lbTitulo.Width=100%x"[Agregar/General script]
views.get("lbtitulo").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 5;BA.debugLine="lbTitulo.Left=0"[Agregar/General script]
views.get("lbtitulo").vw.setLeft((int)(0d));
//BA.debugLineNum = 6;BA.debugLine="lbTitulo.Height=8%y"[Agregar/General script]
views.get("lbtitulo").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 8;BA.debugLine="btnAtrasA.Left=0"[Agregar/General script]
views.get("btnatrasa").vw.setLeft((int)(0d));
//BA.debugLineNum = 9;BA.debugLine="btnAtrasA.Height=8%y"[Agregar/General script]
views.get("btnatrasa").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 10;BA.debugLine="btnAtrasA.Top=0"[Agregar/General script]
views.get("btnatrasa").vw.setTop((int)(0d));
//BA.debugLineNum = 11;BA.debugLine="btnAtrasA.Width=8%y"[Agregar/General script]
views.get("btnatrasa").vw.setWidth((int)((8d / 100 * height)));
//BA.debugLineNum = 13;BA.debugLine="etNombre.Top=12%y"[Agregar/General script]
views.get("etnombre").vw.setTop((int)((12d / 100 * height)));
//BA.debugLineNum = 14;BA.debugLine="etNombre.Height=10%y"[Agregar/General script]
views.get("etnombre").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 15;BA.debugLine="etNombre.Width=90%x"[Agregar/General script]
views.get("etnombre").vw.setWidth((int)((90d / 100 * width)));
//BA.debugLineNum = 16;BA.debugLine="etNombre.Left=5%x"[Agregar/General script]
views.get("etnombre").vw.setLeft((int)((5d / 100 * width)));
//BA.debugLineNum = 18;BA.debugLine="etNumero.Top=24%y"[Agregar/General script]
views.get("etnumero").vw.setTop((int)((24d / 100 * height)));
//BA.debugLineNum = 19;BA.debugLine="etNumero.Height=10%y"[Agregar/General script]
views.get("etnumero").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 20;BA.debugLine="etNumero.Width=90%x"[Agregar/General script]
views.get("etnumero").vw.setWidth((int)((90d / 100 * width)));
//BA.debugLineNum = 21;BA.debugLine="etNumero.Left=5%x"[Agregar/General script]
views.get("etnumero").vw.setLeft((int)((5d / 100 * width)));
//BA.debugLineNum = 23;BA.debugLine="etDescrip.Top=40%y"[Agregar/General script]
views.get("etdescrip").vw.setTop((int)((40d / 100 * height)));
//BA.debugLineNum = 24;BA.debugLine="etDescrip.Height=20%y"[Agregar/General script]
views.get("etdescrip").vw.setHeight((int)((20d / 100 * height)));
//BA.debugLineNum = 25;BA.debugLine="etDescrip.Width=90%x"[Agregar/General script]
views.get("etdescrip").vw.setWidth((int)((90d / 100 * width)));
//BA.debugLineNum = 26;BA.debugLine="etDescrip.Left=5%x"[Agregar/General script]
views.get("etdescrip").vw.setLeft((int)((5d / 100 * width)));
//BA.debugLineNum = 28;BA.debugLine="cbMensajes.Top=64%y"[Agregar/General script]
views.get("cbmensajes").vw.setTop((int)((64d / 100 * height)));
//BA.debugLineNum = 29;BA.debugLine="cbMensajes.Height=10%y"[Agregar/General script]
views.get("cbmensajes").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 30;BA.debugLine="cbMensajes.Width=84%x"[Agregar/General script]
views.get("cbmensajes").vw.setWidth((int)((84d / 100 * width)));
//BA.debugLineNum = 31;BA.debugLine="cbMensajes.HorizontalCenter=50%x"[Agregar/General script]
views.get("cbmensajes").vw.setLeft((int)((50d / 100 * width) - (views.get("cbmensajes").vw.getWidth() / 2)));
//BA.debugLineNum = 33;BA.debugLine="btnConectar.Top=85%y"[Agregar/General script]
views.get("btnconectar").vw.setTop((int)((85d / 100 * height)));
//BA.debugLineNum = 34;BA.debugLine="btnConectar.Height=10%y"[Agregar/General script]
views.get("btnconectar").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 35;BA.debugLine="btnConectar.Width=80%x"[Agregar/General script]
views.get("btnconectar").vw.setWidth((int)((80d / 100 * width)));
//BA.debugLineNum = 36;BA.debugLine="btnConectar.Left=10%x"[Agregar/General script]
views.get("btnconectar").vw.setLeft((int)((10d / 100 * width)));

}
}