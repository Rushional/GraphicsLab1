import model.Lab1Model;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;
import ui.DrawManager;
import ui.Drawer;
import ui.Window;

public class Main {
    public static void main(String[] args) {
        Lab1Model lab1Model = new Lab1Model();
        Display display = Display.getDefault();
        Window window = new Window(display, lab1Model);
        window.build();
        Drawer drawer = new Drawer(window, new GC(window.getCanvas()));
        DrawManager drawManager = new DrawManager(drawer, lab1Model, window.getSliderX(), window.getSliderY());
        window.assignDrawManager(drawManager);
        window.show();
        while (!window.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}
