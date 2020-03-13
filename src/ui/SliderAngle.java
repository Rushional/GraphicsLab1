package ui;

import model.Lab1Model;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;


public class SliderAngle extends Slider {
    private Lab1Model model;
    private SliderX sliderX;
    private SliderY sliderY;

    SliderAngle(Composite window, int style, Lab1Model model) {
        super(window, style);
        this.model = model;
    }

    void assignSelectionListener(SliderX sliderX, SliderY sliderY,
                                 Text textCurrentAngle, DrawManager manager) {
        addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                textCurrentAngle.setText(Integer.toString(getSelection()));
                Point point = new Point(sliderX.getX(), sliderY.getY());
                model.changeTriangle(point, getSelection());
                manager.updateTriangle();
            }
        });
    }

    //I'd do that in constructor, but it seems like SWT and GridLayout don't like that too much
    //I guess I just don't understand something, but as of now I really hate SWT and Eclipse as a whole
    void assignFields(SliderX sliderX, SliderY sliderY) {
        this.sliderX = sliderX;
        this.sliderY = sliderY;
    }

    void setAngle(int angle) {
        if (angle > 360) angle = 360;
        setSelection(angle);
        model.changeTriangle(new Point(sliderX.getX(), sliderY.getY()), angle);
    }

    @Override
    protected void checkSubclass() {
        //  allow subclass
//        System.out.println("info   : checking menu subclass");
    }
}
