package ui;

import lab.Lab1Model;
import org.eclipse.swt.graphics.Point;

//Yeah, package ui, whatever
public class DrawManager {
    private Drawer drawer;
    private Lab1Model model;

    public DrawManager(Drawer drawer, Lab1Model model) {
        this.drawer = drawer;
        this.model = model;
    }

    public void updateTriangle() {
        drawer.clear();
        drawer.drawPolygon(model.getCurrentTriangle());
    }

    public void movePoint(Point point) {
        drawer.clear();
        drawer.drawPolygon(model.getDefaultTriangle());
        drawer.drawPoint(point);
    }

    public void initiate() {
        drawer.drawCoordinatesGrid();
        drawer.drawPolygon(model.getDefaultTriangle());
    }
}
