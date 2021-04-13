package com.monitorflux.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_iniciar{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("etcorreo").vw.setTop((int)((35d / 100 * height)));
views.get("etcorreo").vw.setHeight((int)((10d / 100 * height)));
views.get("etcorreo").vw.setWidth((int)((70d / 100 * width)));
views.get("etcorreo").vw.setLeft((int)((15d / 100 * width)));
views.get("etpassword").vw.setTop((int)((48d / 100 * height)));
views.get("etpassword").vw.setHeight((int)((10d / 100 * height)));
views.get("etpassword").vw.setWidth((int)((70d / 100 * width)));
views.get("etpassword").vw.setLeft((int)((15d / 100 * width)));
views.get("lbregistrar").vw.setTop((int)((90d / 100 * height)));
views.get("lbregistrar").vw.setHeight((int)((10d / 100 * height)));
views.get("lbregistrar").vw.setWidth((int)((30d / 100 * width)));
views.get("lbregistrar").vw.setLeft((int)((55d / 100 * width)));
views.get("btniniciar").vw.setTop((int)((75d / 100 * height)));
views.get("btniniciar").vw.setHeight((int)((10d / 100 * height)));
views.get("btniniciar").vw.setWidth((int)((80d / 100 * width)));
views.get("btniniciar").vw.setLeft((int)((10d / 100 * width)));
views.get("label1").vw.setTop((int)((90d / 100 * height)));
views.get("label1").vw.setHeight((int)((10d / 100 * height)));
views.get("label1").vw.setWidth((int)((46d / 100 * width)));
views.get("label1").vw.setLeft((int)((15d / 100 * width)));
views.get("ivlogo").vw.setTop((int)((10d / 100 * height)));
views.get("ivlogo").vw.setWidth((int)((40d / 100 * width)));
views.get("ivlogo").vw.setHeight((int)((40d / 100 * width)));
views.get("ivlogo").vw.setLeft((int)((50d / 100 * width) - (views.get("ivlogo").vw.getWidth() / 2)));
views.get("cbmantener").vw.setTop((int)((62d / 100 * height)));
views.get("cbmantener").vw.setWidth((int)((70d / 100 * width)));
views.get("cbmantener").vw.setHeight((int)((10d / 100 * height)));
views.get("cbmantener").vw.setLeft((int)((50d / 100 * width) - (views.get("cbmantener").vw.getWidth() / 2)));

}
}