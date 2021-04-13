package com.monitorflux.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_registrar{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("etnombre").vw.setTop((int)((30d / 100 * height)));
views.get("etnombre").vw.setHeight((int)((10d / 100 * height)));
views.get("etnombre").vw.setWidth((int)((70d / 100 * width)));
views.get("etnombre").vw.setLeft((int)((15d / 100 * width)));
views.get("etcorreor").vw.setTop((int)((41d / 100 * height)));
views.get("etcorreor").vw.setHeight((int)((10d / 100 * height)));
views.get("etcorreor").vw.setWidth((int)((70d / 100 * width)));
views.get("etcorreor").vw.setLeft((int)((15d / 100 * width)));
views.get("etpasswordr").vw.setTop((int)((52d / 100 * height)));
views.get("etpasswordr").vw.setHeight((int)((10d / 100 * height)));
views.get("etpasswordr").vw.setWidth((int)((70d / 100 * width)));
views.get("etpasswordr").vw.setLeft((int)((15d / 100 * width)));
views.get("etconfirm").vw.setTop((int)((63d / 100 * height)));
views.get("etconfirm").vw.setHeight((int)((10d / 100 * height)));
views.get("etconfirm").vw.setWidth((int)((70d / 100 * width)));
views.get("etconfirm").vw.setLeft((int)((15d / 100 * width)));
views.get("btnregistrar").vw.setTop((int)((85d / 100 * height)));
views.get("btnregistrar").vw.setHeight((int)((10d / 100 * height)));
views.get("btnregistrar").vw.setWidth((int)((80d / 100 * width)));
views.get("btnregistrar").vw.setLeft((int)((10d / 100 * width)));
views.get("ivlogo").vw.setTop((int)((10d / 100 * height)));
views.get("ivlogo").vw.setWidth((int)((40d / 100 * width)));
views.get("ivlogo").vw.setHeight((int)((40d / 100 * width)));
views.get("ivlogo").vw.setLeft((int)((50d / 100 * width) - (views.get("ivlogo").vw.getWidth() / 2)));
views.get("btnatrasa").vw.setLeft((int)(0d));
views.get("btnatrasa").vw.setHeight((int)((8d / 100 * height)));
views.get("btnatrasa").vw.setTop((int)(0d));
views.get("btnatrasa").vw.setWidth((int)((8d / 100 * height)));
views.get("lbtitulo").vw.setTop((int)(0d));
views.get("lbtitulo").vw.setWidth((int)((100d / 100 * width)));
views.get("lbtitulo").vw.setLeft((int)(0d));
views.get("lbtitulo").vw.setHeight((int)((8d / 100 * height)));

}
}