import lab.Lab1Model;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;
import ui.DrawManager;
import ui.Drawer;
import ui.Window;

public class Main {
    public static void main(String[] args) {
        Display display = Display.getDefault();
        Window window = new Window(display/*, drawer, lab1*/);
        window.build();
        GC gc = new GC(window.getCanvas());
        Drawer drawer = new Drawer(window, gc);
        Lab1Model lab1Model = new Lab1Model();
        window.assignModel(lab1Model);
        DrawManager drawManager = new DrawManager(drawer, lab1Model);
        window.assignDrawManager(drawManager);
        window.show();
        while (!window.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}
