package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_monitoreo{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("lbtitulo").vw.setTop((int)(0d));
views.get("lbtitulo").vw.setWidth((int)((100d / 100 * width)));
views.get("lbtitulo").vw.setLeft((int)(0d));
views.get("lbtitulo").vw.setHeight((int)((8d / 100 * height)));
views.get("btnatrasm").vw.setLeft((int)(0d));
views.get("btnatrasm").vw.setHeight((int)((8d / 100 * height)));
views.get("btnatrasm").vw.setTop((int)(0d));
views.get("btnatrasm").vw.setWidth((int)((8d / 100 * height)));
views.get("lvelectro").vw.setTop((int)((8d / 100 * height)));
views.get("lvelectro").vw.setWidth((int)((100d / 100 * width)));
views.get("lvelectro").vw.setLeft((int)(0d));
views.get("lvelectro").vw.setHeight((int)((92d / 100 * height)));

}
}