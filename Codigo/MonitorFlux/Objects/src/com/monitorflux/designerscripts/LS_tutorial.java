package com.monitorflux.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_tutorial{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("lbtitulo").vw.setTop((int)(0d));
views.get("lbtitulo").vw.setWidth((int)((100d / 100 * width)));
views.get("lbtitulo").vw.setLeft((int)(0d));
views.get("lbtitulo").vw.setHeight((int)((8d / 100 * height)));
views.get("btnatras").vw.setLeft((int)(0d));
views.get("btnatras").vw.setHeight((int)((8d / 100 * height)));
views.get("btnatras").vw.setTop((int)(0d));
views.get("btnatras").vw.setWidth((int)((8d / 100 * height)));
views.get("wv1").vw.setTop((int)((8d / 100 * height)));
views.get("wv1").vw.setLeft((int)(0d));
views.get("wv1").vw.setWidth((int)((100d / 100 * width)));
views.get("wv1").vw.setHeight((int)((92d / 100 * height)));

}
}