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

    void updateTriangle(Point point) {
        drawer.clear();
        drawer.drawPolygon(model.getCurrentTriangle());
        drawer.drawPoint(point);
    }

    void movePoint(Point point) {
        drawer.clear();
        drawer.drawPolygon(model.getDefaultTriangle());
        drawer.drawPoint(point);
    }

    void initiate() {
        drawer.drawCoordinatesGrid();
        drawer.drawPolygon(model.getDefaultTriangle());
        drawer.drawPoint(new Point(600, 400));
    }
}
