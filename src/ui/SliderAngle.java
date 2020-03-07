package ui;

import lab.Lab1Model;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;


public class SliderAngle extends Slider {
//    private SliderX sliderX;
//    private SliderY sliderY;
//    private Text textCurrentAngle;
//    private Lab1Model model;
//    private DrawManager drawManager;

    public SliderAngle(Composite window, int style) {
        super(window, style);
    }

    public void assignSelectionListener(SliderX sliderX, SliderY sliderY,
                                        Text textCurrentAngle, Lab1Model model, DrawManager manager) {
        addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                textCurrentAngle.setText(new Integer(getSelection()).toString());
                Point point = new Point(sliderX.getX(), sliderY.getY());
                model.changeTriangle(point, getSelection());
                manager.updateTriangle(point);
            }
        });
    }

    @Override
    protected void checkSubclass() {
        //  allow subclass
//        System.out.println("info   : checking menu subclass");
    }
}
