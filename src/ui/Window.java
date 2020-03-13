package ui;

import model.Lab1Model;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class Window extends Shell {
    private Composite canvas;
    private DrawManager drawManager;
    private Lab1Model model;
    private SliderX sliderX;
    private SliderY sliderY;
    private SliderAngle sliderAngle;
    private TextAngle textCurrentAngle;
    private TextX textCurrentX;
    private TextY textCurrentY;

    public Window(Display display, Lab1Model model) {
        super(display, SWT.SHELL_TRIM);
        setText("Лабораторная работа 1");
        setSize(1300, 900);
        this.model = model;
    }

    public void build() {
        Color backgroundColor = new Color(getDisplay(), new RGB(173, 196, 228)); // Blue background
//        Color backgroundColor = new Color(getDisplay(), new RGB(255, 255, 255)); // Plain white
        Color textBoxColor = new Color(getDisplay(), new RGB(0, 0 ,0)); //Plain black
        setLayout(new GridLayout(6, false));

        Label labelX = new Label(this, SWT.NONE);
        labelX.setText("X:");

        textCurrentX = new TextX(this, SWT.BORDER);
//        textCurrentX.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 2, 1));
//        textCurrentX.setLayoutData(new GridData(27, 20));
        GridData dataTextX = new GridData(SWT.NONE, SWT.NONE, false, false, 2, 1);
        dataTextX.widthHint = 27;
        dataTextX.heightHint = 20;
        textCurrentX.setLayoutData(dataTextX);
        textCurrentX.setText("600");

        sliderX = new SliderX(this, SWT.HORIZONTAL);
        sliderX.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false, 3, 1));
        sliderX.setSize(80, 20);
        sliderX.setMinimum(50);
        sliderX.setMaximum(1200);
        sliderX.setIncrement(10);
        sliderX.setSelection(600);

        Label labelAngle = new Label(this, SWT.NONE);
        labelAngle.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false, 4, 1));
        labelAngle.setText("Поворот треугольника:");

        textCurrentAngle = new TextAngle(this, SWT.BORDER);
        textCurrentAngle.setLayoutData(new GridData(27, 20));
        textCurrentAngle.setText("0");

        sliderAngle = new SliderAngle(this, SWT.HORIZONTAL, model);
//        sliderAngle.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 1, 1));
        sliderAngle.setSize(60, 20);
        sliderAngle.setMinimum(0);
        sliderAngle.setMaximum(370); //For some reason it takes 10 off maximum:c
        sliderAngle.setIncrement(5);
        sliderAngle.setSelection(0);

        Label labelY = new Label(this, SWT.NONE);
        labelY.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false, 2, 1));
        labelY.setText("Y:");

        canvas = new Canvas(this, SWT.FILL);
        canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                true, true, 4, 3));
        canvas.setBackground(backgroundColor);

        textCurrentY = new TextY(this, SWT.BORDER);
//        textCurrentY.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
        GridData dataTextY = new GridData(SWT.NONE, SWT.NONE, false, false, 2, 1);
        dataTextY.widthHint = 27;
        dataTextY.heightHint = 20;
        textCurrentY.setLayoutData(dataTextY);
        textCurrentY.setText("400");

        sliderY = new SliderY(this, SWT.VERTICAL);
//        sliderY.setLayoutData(new GridData(SWT.NONE, SWT.FILL, false, false, 2, 1));
//        sliderY.setSize(20, 80);
        GridData dataSliderY = new GridData(SWT.NONE, SWT.FILL, false, false, 2, 1);
        dataSliderY.widthHint = 41;
        sliderY.setLayoutData(dataSliderY);
        sliderY.setMinimum(50);
        sliderY.setMaximum(760);
        sliderY.setIncrement(10);
        sliderY.setSelection(400);
    }

    public void show() {
        sliderX.assignSelectionListener(textCurrentX, sliderY, drawManager);
        sliderY.assignSelectionListener(textCurrentY, sliderX, drawManager);
        sliderAngle.assignSelectionListener(sliderX, sliderY, textCurrentAngle, drawManager);
        sliderAngle.assignFields(sliderX, sliderY);
        textCurrentX.assignListener(sliderX, drawManager);
        textCurrentY.assignListener(sliderY, drawManager);
        textCurrentAngle.assignListener(sliderAngle, drawManager);
        open();
        drawManager.initiate();
    }

    public void assignModel(Lab1Model model) {
        this.model = model;
    }

    public void assignDrawManager(DrawManager drawManager) {
        this.drawManager = drawManager;
    }

    public Composite getCanvas() {
        return canvas;
    }

    public SliderX getSliderX() {
        return sliderX;
    }

    public SliderY getSliderY() {
        return sliderY;
    }

    @Override
    protected void checkSubclass() {
        //  allow subclass
//        System.out.println("info   : checking menu subclass");
    }
}
