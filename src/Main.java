import lab.Lab1;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;
import test.TestingSlider;
import ui.AngleRequestDialog;
import ui.Drawer;
import ui.Window;

public class Main {
    public static void main(String[] args) {
        TestingSlider sliderTest = new TestingSlider();
        Display display = Display.getDefault();
        Window window = new Window(display/*, drawer, lab1*/);
//        AngleRequestDialog angleDialog = new AngleRequestDialog(window);
//        System.out.println(angleDialog.requestDouble());
        window.open();
        GC gc = new GC(window.getCanvas());
        Drawer drawer = new Drawer(window, gc);
        Lab1 lab1 = new Lab1();
        drawer.drawCoordinatesGrid();
        drawer.drawPolygon(lab1.getDefaultTriangle()/*, gc*/);
        while (!window.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}
