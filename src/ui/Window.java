package ui;

import lab.Lab1;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class Window extends Shell {
    private WindowPaintListener paintListener;
    private final Composite canvas;

    public Window(Display display/*, Drawer drawer, Lab1 lab1*/) {
        super(display, SWT.SHELL_TRIM);
        setLayout(new GridLayout(1, false));
        canvas = new Canvas(this, SWT.BORDER);
        canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        // Menu generation
//        paintListener = new WindowPaintListener(drawer, lab1);
//        canvas.addPaintListener(paintListener);
        setText("Лабораторная работа 1");
        setSize(900, 900);
    }

    public void drawCoordinatesGrid(GC gc){
        int step = 50;
        int Sizex = this.getSize().x;
        int Sizey = this.getSize().y;
        int colorRGB = 180;
        int i = 0;
        for (i = 0; i < Sizex; i+= step){
            gc.drawText(((Integer)i).toString(), i, 0); //integer - строка перевода в разные типы
        }
        for (i = 0; i < this.getSize().y; i+= step){
            gc.drawText(((Integer)i).toString(), 0, i); //integer - строка перевода в разные типы
        }
        //gray
        Color foregroundOld = gc.getForeground();
        gc.setForeground(new Color(getDisplay(), new RGB(colorRGB,colorRGB,colorRGB)));
        for (i = 0; i < Sizex; i+= step){
            gc.drawLine(i, 0, i, Sizey);
        }
        for (i = 0; i < this.getSize().y; i+= step){
            gc.drawLine(0, i, Sizex, i);
        }
        gc.setForeground(foregroundOld);
    }

    public Composite getCanvas() {
        return canvas;
    }

    @Override
    protected void checkSubclass() {
        //  allow subclass
        System.out.println("info   : checking menu subclass");
    }
}
