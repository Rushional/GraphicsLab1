package test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;

public class TestingSlider {

    Display d;

    Shell s;

    public TestingSlider() {
        d = new Display();
        s = new Shell(d);
        s.setSize(600, 600);

        s.setText("A Slider Example");
        final Slider slide = new Slider(s, SWT.VERTICAL);
        slide.setBounds(115, 50, 20, 400);
        slide.setMinimum(0);
        slide.setMaximum(110);
        slide.setIncrement(5);

        final Text t = new Text(s, SWT.BORDER);
        t.setBounds(115, 25, 25, 25);
        t.setText("0");

        slide.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                t.setText(new Integer(slide.getSelection()).toString());
            }
        });

        s.open();
        while (!s.isDisposed()) {
            if (!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }

    public static void main() {
        new TestingSlider();
    }

}