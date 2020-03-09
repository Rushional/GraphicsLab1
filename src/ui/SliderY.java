package ui;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;

public class SliderY extends Slider {
    private int y = 400;

    SliderY(Composite window, int style) {
        super(window, style);
    }

    void assignSelectionListener(Text textCurrentY, SliderX sliderX, DrawManager manager) {
        addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                textCurrentY.setText(new Integer(getSelection()).toString());
                y = getSelection();
                manager.movePoint(new Point(sliderX.getX(), getSelection()));
            }
        });
    }

    int getY() {
        return y;
    }

    @Override
    protected void checkSubclass() {
        //  allow subclass
//        System.out.println("info   : checking menu subclass");
    }
}
