package ui;

import lab.Lab1Model;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;

public class WindowPaintListener implements PaintListener {
    private Drawer drawer;
    private Lab1Model lab1Model;

    public WindowPaintListener(Drawer drawer, Lab1Model lab1Model) {
        this.drawer = drawer;
        this.lab1Model = lab1Model;
    }
//    PaintListener listens for PaintEvent,
//    This means paintControl is called after every PaintEvent
//    which is every time the picture changes
    @Override
    public void paintControl(PaintEvent e) {
//        drawer.drawCoordinatesGrid(e.gc);
//        if (lab1.getTriangle1() != null){
//            drawer.drawPolygon(lab1.getTriangle1(), e.gc);
//        }
//        if (lab1.getTriangle2() != null){
//            drawer.drawPolygon(lab1.getTriangle2(), e.gc);
//        }
//        if (lab1.getPoint() != null){
//            e.gc.drawPoint(lab1.getPoint().x, lab1.getPoint().y);
//            e.gc.drawOval(lab1.getPoint().x -2, lab1.getPoint().y -2, 4, 4);
//        }
    }
}
