package ui;

import model.Lab1Model;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;


public class SliderAngle extends Slider {
    private Lab1Model model;
    private SliderX sliderX;
    private SliderY sliderY;
    private Label labelPreviousAngle;
    private int previousAngle, currentAngle = 0;

    SliderAngle(Composite window, int style, Lab1Model model) {
        super(window, style);
        this.model = model;
    }

    void assignSelectionListener(SliderX sliderX, SliderY sliderY,
                                 Text textCurrentAngle, DrawManager manager) {
        addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                previousAngle = currentAngle;
                currentAngle = getSelection();
                textCurrentAngle.setText(Integer.toString(currentAngle));
                labelPreviousAngle.setText("Предыдущий угол: " + previousAngle);
                Point point = new Point(sliderX.getX(), sliderY.getY());
                model.changeTriangle(point, getSelection());
                manager.updateTriangle();
            }
        });
    }

    //I'd do that in constructor, but it seems like SWT and GridLayout don't like that too much
    //I guess I just don't understand something, but as of now I really hate SWT and Eclipse as a whole
    void assignFields(SliderX sliderX, SliderY sliderY, Label labelPreviousAngle) {
        this.sliderX = sliderX;
        this.sliderY = sliderY;
        this.labelPreviousAngle = labelPreviousAngle;
    }

    void setAngle(int angle) {
        if (angle > 360) angle = 360;
        previousAngle = currentAngle;
        labelPreviousAngle.setText("Предыдущий угол: " + previousAngle);
        setSelection(angle);
        currentAngle = angle;
        model.changeTriangle(new Point(sliderX.getX(), sliderY.getY()), angle);
    }

    @Override
    protected void checkSubclass() {
        //  allow subclass
//        System.out.println("info   : checking menu subclass");
    }
}
