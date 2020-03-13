package ui;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;

public class SliderX extends Slider {
    private int x = 600;

    SliderX(Composite window, int style) {
        super(window, style);
    }

    void assignSelectionListener(Text textCurrentX, SliderY sliderY, DrawManager manager) {
        addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                textCurrentX.setText(Integer.toString(getSelection()));
                x = getSelection();
                manager.movePoint();
            }
        });
    }

    int getX() {
        return x;
    }

    void setX(int x) {
        if (x < 50) x = 50;
        else if (x > 1200) x = 1200;
        this.x = x;
        setSelection(x);
    }

    @Override
    protected void checkSubclass() {
        //  allow subclass
//        System.out.println("info   : checking menu subclass");
    }
}
