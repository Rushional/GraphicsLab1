package ui;

import lab.Lab1Model;
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
    private Text textCurrentX, textCurrentY, textCurrentAngle;

    public Window(Display display) {
        super(display, SWT.SHELL_TRIM);
        setText("Лабораторная работа 1");
        setSize(900, 900);
    }

    public void build() {
        Color backgroundColor = new Color(getDisplay(), new RGB(173, 196, 228));
        setLayout(new GridLayout(5, false));

        sliderX = new SliderX(this, SWT.HORIZONTAL);
        sliderX.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 2, 1));
        sliderX.setSize(80, 20);
        sliderX.setMinimum(100);
        sliderX.setMaximum(1000);
        sliderX.setIncrement(10);

        textCurrentX = new Text(this, SWT.BORDER);
        textCurrentX.setText("0");


//        sliderX.addSelectionListener(new SelectionAdapter() {
//            public void widgetSelected(SelectionEvent e) {
//                textCurrentX.setText(new Integer(sliderX.getSelection()).toString());
//                model.changeTriangle(new Point(sliderX.getSelection(), 300), sliderX.getSelection());
//                drawManager.updateTriangle();
//            }
//        });


        sliderAngle = new SliderAngle(this, SWT.HORIZONTAL);
//        final Slider sliderAngle = new Slider(this, SWT.HORIZONTAL);
        sliderAngle.setSize(60, 20);
        sliderAngle.setMinimum(0);
        sliderAngle.setMaximum(360);
        sliderAngle.setIncrement(5);

        textCurrentAngle = new Text(this, SWT.BORDER);
        textCurrentAngle.setText("0");

//        sliderAngle.addSelectionListener(new SelectionAdapter() {
//            public void widgetSelected(SelectionEvent e) {
//                textCurrentAngle.setText(new Integer(sliderAngle.getSelection()).toString());
//            }
//        });

        sliderY = new SliderY(this, SWT.VERTICAL);
//        final Slider sliderY = new Slider(this, SWT.VERTICAL);
        sliderY.setSize(20, 80);
        sliderY.setMinimum(100);
        sliderY.setMaximum(1000);
        sliderY.setIncrement(10);

        canvas = new Canvas(this, SWT.FILL);
        canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                true, true, 4, 2));
        canvas.setBackground(backgroundColor);

        textCurrentY = new Text(this, SWT.BORDER);
        textCurrentY.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
        textCurrentY.setText("0");

//        sliderY.addSelectionListener(new SelectionAdapter() {
//            public void widgetSelected(SelectionEvent e) {
//                textCurrentY.setText(new Integer(sliderY.getSelection()).toString());
//            }
//        });
    }

    public void show() {
        sliderX.assignSelectionListener(textCurrentX, sliderY, drawManager);
        sliderY.assignSelectionListener(textCurrentY, sliderX, drawManager);
        sliderAngle.assignSelectionListener(sliderX, sliderY, textCurrentAngle, model, drawManager);
        drawManager.initiate();
        open();
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

    @Override
    protected void checkSubclass() {
        //  allow subclass
        System.out.println("info   : checking menu subclass");
    }
}
