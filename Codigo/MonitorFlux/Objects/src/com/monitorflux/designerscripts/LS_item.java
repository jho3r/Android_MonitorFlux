package com.monitorflux.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_item{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("lbdispositivo").vw.setWidth((int)((96d / 100 * width)));
views.get("lbdispositivo").vw.setLeft((int)((2d / 100 * width)));
views.get("lbdispositivo").vw.setHeight((int)((90d / 100 * height)));
views.get("lbdispositivo").vw.setTop((int)((5d / 100 * height)));

}
}