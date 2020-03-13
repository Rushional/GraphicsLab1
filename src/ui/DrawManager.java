package ui;

import model.Lab1Model;
import org.eclipse.swt.graphics.Point;

//Yeah, package ui, whatever
public class DrawManager {
    private Drawer drawer;
    private Lab1Model model;
    private SliderX sliderX;
    private SliderY sliderY;

    public DrawManager(Drawer drawer, Lab1Model model, SliderX sliderX, SliderY sliderY) {
        this.drawer = drawer;
        this.model = model;
        this.sliderX = sliderX;
        this.sliderY = sliderY;
    }

    void updateTriangle() {
        drawer.clear();
        drawer.drawPolygon(model.getCurrentTriangle());
        drawer.drawPoint(new Point(sliderX.getX(), sliderY.getY()));
    }

    void movePoint() {
        drawer.clear();
        drawer.drawPolygon(model.getDefaultTriangle());
        Point point = new Point(sliderX.getX(), sliderY.getY());
        drawer.drawPoint(point);
    }

    void initiate() {
        drawer.drawCoordinatesGrid();
        drawer.drawPolygon(model.getDefaultTriangle());
        drawer.drawPoint(new Point(600, 400));
    }
}
