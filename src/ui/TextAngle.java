package ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class TextAngle extends Text {
    TextAngle(Composite window, int style) {
        super(window, style);
        addVerifyListener(new IntVerifier());
        setTextLimit(3);
    }

    void assignListener(SliderAngle sliderAngle, DrawManager drawManager) {
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.keyCode == SWT.CR) {
                    String text = ((Text)e.widget).getText();
                    if (text.equals("")) text = "0";
                    int angle = Integer.parseInt(text);
                    sliderAngle.setAngle(angle);
                    drawManager.updateTriangle();
                }
            }
        });
    }

    @Override
    protected void checkSubclass() {
        //  allow subclass
//        System.out.println("info   : checking menu subclass");
    }
}
