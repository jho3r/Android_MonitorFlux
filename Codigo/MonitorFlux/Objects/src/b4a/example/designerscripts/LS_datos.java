package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_datos{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("lbnombre").vw.setTop((int)(0d));
views.get("lbnombre").vw.setWidth((int)((100d / 100 * width)));
views.get("lbnombre").vw.setLeft((int)(0d));
views.get("lbnombre").vw.setHeight((int)((8d / 100 * height)));
views.get("btnatrase").vw.setLeft((int)(0d));
views.get("btnatrase").vw.setHeight((int)((8d / 100 * height)));
views.get("btnatrase").vw.setTop((int)(0d));
views.get("btnatrase").vw.setWidth((int)((8d / 100 * height)));
views.get("btnmas").vw.setLeft((int)((85d / 100 * width)));
views.get("btnmas").vw.setHeight((int)((13d / 100 * width)));
views.get("btnmas").vw.setTop((int)((2d / 100 * width)));
views.get("btnmas").vw.setWidth((int)((15d / 100 * width)));
views.get("lb1").vw.setLeft((int)((1d / 100 * width)));
views.get("lb1").vw.setTop((int)((10d / 100 * height)));
views.get("lb1").vw.setWidth((int)((98d / 100 * width)));
views.get("lb1").vw.setHeight((int)((6d / 100 * height)));
views.get("lbnumero").vw.setLeft((int)((1d / 100 * width)));
views.get("lbnumero").vw.setTop((int)((16d / 100 * height)));
views.get("lbnumero").vw.setWidth((int)((98d / 100 * width)));
views.get("lbnumero").vw.setHeight((int)((6d / 100 * height)));
views.get("lb2").vw.setLeft((int)((1d / 100 * width)));
views.get("lb2").vw.setTop((int)((24d / 100 * height)));
views.get("lb2").vw.setWidth((int)((98d / 100 * width)));
views.get("lb2").vw.setHeight((int)((6d / 100 * height)));
views.get("lbdescrip").vw.setLeft((int)((1d / 100 * width)));
views.get("lbdescrip").vw.setTop((int)((30d / 100 * height)));
views.get("lbdescrip").vw.setWidth((int)((98d / 100 * width)));
//BA.debugLineNum = 36;BA.debugLine="lbDescrip.Height=20%y"[Datos/General script]
views.get("lbdescrip").vw.setHeight((int)((20d / 100 * height)));
//BA.debugLineNum = 38;BA.debugLine="lb3.Left=1%x"[Datos/General script]
views.get("lb3").vw.setLeft((int)((1d / 100 * width)));
//BA.debugLineNum = 39;BA.debugLine="lb3.Top=52%y"[Datos/General script]
views.get("lb3").vw.setTop((int)((52d / 100 * height)));
//BA.debugLineNum = 40;BA.debugLine="lb3.Width=98%x"[Datos/General script]
views.get("lb3").vw.setWidth((int)((98d / 100 * width)));
//BA.debugLineNum = 41;BA.debugLine="lb3.Height=6%y"[Datos/General script]
views.get("lb3").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 43;BA.debugLine="lbEstado.Left=20%x"[Datos/General script]
views.get("lbestado").vw.setLeft((int)((20d / 100 * width)));
//BA.debugLineNum = 44;BA.debugLine="lbEstado.Top=58%y"[Datos/General script]
views.get("lbestado").vw.setTop((int)((58d / 100 * height)));
//BA.debugLineNum = 45;BA.debugLine="lbEstado.Width=60%x"[Datos/General script]
views.get("lbestado").vw.setWidth((int)((60d / 100 * width)));
//BA.debugLineNum = 46;BA.debugLine="lbEstado.Height=6%y"[Datos/General script]
views.get("lbestado").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 48;BA.debugLine="lbFlujo.Left=1%x"[Datos/General script]
views.get("lbflujo").vw.setLeft((int)((1d / 100 * width)));
//BA.debugLineNum = 49;BA.debugLine="lbFlujo.Top=65%y"[Datos/General script]
views.get("lbflujo").vw.setTop((int)((65d / 100 * height)));
//BA.debugLineNum = 50;BA.debugLine="lbFlujo.Width=98%x"[Datos/General script]
views.get("lbflujo").vw.setWidth((int)((98d / 100 * width)));
//BA.debugLineNum = 51;BA.debugLine="lbFlujo.Height=6%y"[Datos/General script]
views.get("lbflujo").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 53;BA.debugLine="lbActualizado.Left=1%x"[Datos/General script]
views.get("lbactualizado").vw.setLeft((int)((1d / 100 * width)));
//BA.debugLineNum = 54;BA.debugLine="lbActualizado.Top=72%y"[Datos/General script]
views.get("lbactualizado").vw.setTop((int)((72d / 100 * height)));
//BA.debugLineNum = 55;BA.debugLine="lbActualizado.Width=98%x"[Datos/General script]
views.get("lbactualizado").vw.setWidth((int)((98d / 100 * width)));
//BA.debugLineNum = 56;BA.debugLine="lbActualizado.Height=6%y"[Datos/General script]
views.get("lbactualizado").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 58;BA.debugLine="btnActualizar.Top=87%y"[Datos/General script]
views.get("btnactualizar").vw.setTop((int)((87d / 100 * height)));
//BA.debugLineNum = 59;BA.debugLine="btnActualizar.Height=8%y"[Datos/General script]
views.get("btnactualizar").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 60;BA.debugLine="btnActualizar.Width=80%x"[Datos/General script]
views.get("btnactualizar").vw.setWidth((int)((80d / 100 * width)));
//BA.debugLineNum = 61;BA.debugLine="btnActualizar.Left=10%x"[Datos/General script]
views.get("btnactualizar").vw.setLeft((int)((10d / 100 * width)));

}
}