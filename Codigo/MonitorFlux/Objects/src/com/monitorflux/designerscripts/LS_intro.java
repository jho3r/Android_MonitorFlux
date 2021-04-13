package com.monitorflux.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_intro{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("ivintro").vw.setWidth((int)((70d / 100 * width)));
views.get("ivintro").vw.setHeight((int)((70d / 100 * width)));
views.get("ivintro").vw.setLeft((int)((50d / 100 * width) - (views.get("ivintro").vw.getWidth() / 2)));
views.get("ivintro").vw.setTop((int)((50d / 100 * height) - (views.get("ivintro").vw.getHeight() / 2)));

}
}