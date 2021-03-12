package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_principal{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("lbt1").vw.setTop((int)((10d / 100 * height)));
views.get("lbt1").vw.setWidth((int)((80d / 100 * width)));
views.get("lbt1").vw.setLeft((int)((50d / 100 * width) - (views.get("lbt1").vw.getWidth() / 2)));
views.get("lbbombas").vw.setTop((int)((16d / 100 * height)));
views.get("lbbombas").vw.setWidth((int)((80d / 100 * width)));
views.get("lbbombas").vw.setLeft((int)((50d / 100 * width) - (views.get("lbbombas").vw.getWidth() / 2)));
views.get("lbt2").vw.setTop((int)((30d / 100 * height)));
views.get("lbt2").vw.setWidth((int)((80d / 100 * width)));
views.get("lbt2").vw.setLeft((int)((50d / 100 * width) - (views.get("lbt2").vw.getWidth() / 2)));
views.get("lbfallas").vw.setTop((int)((36d / 100 * height)));
views.get("lbfallas").vw.setWidth((int)((80d / 100 * width)));
views.get("lbfallas").vw.setLeft((int)((50d / 100 * width) - (views.get("lbfallas").vw.getWidth() / 2)));
views.get("btnmonitoreo").vw.setTop((int)((60d / 100 * height)));
views.get("btnmonitoreo").vw.setHeight((int)((10d / 100 * height)));
views.get("btnmonitoreo").vw.setWidth((int)((80d / 100 * width)));
views.get("btnmonitoreo").vw.setLeft((int)((50d / 100 * width) - (views.get("btnmonitoreo").vw.getWidth() / 2)));
views.get("btnagregar").vw.setTop((int)((71d / 100 * height)));
views.get("btnagregar").vw.setHeight((int)((10d / 100 * height)));
views.get("btnagregar").vw.setWidth((int)((80d / 100 * width)));
views.get("btnagregar").vw.setLeft((int)((50d / 100 * width) - (views.get("btnagregar").vw.getWidth() / 2)));
views.get("btntutorial").vw.setTop((int)((82d / 100 * height)));
views.get("btntutorial").vw.setHeight((int)((10d / 100 * height)));
views.get("btntutorial").vw.setWidth((int)((80d / 100 * width)));
views.get("btntutorial").vw.setLeft((int)((50d / 100 * width) - (views.get("btntutorial").vw.getWidth() / 2)));

}
}