package ui;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class TextX extends Text {
    TextX(Composite window, int style) {
        super(window, style);
        addVerifyListener(new IntVerifier());
    }

    void assignListener(SliderX sliderX, DrawManager drawManager) {
        addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                String text = ((Text)e.widget).getText();
                if (text.equals("")) text = "0";
                int x = Integer.parseInt(text);
                sliderX.setX(x);
                drawManager.movePoint();
            }
        });
        setTextLimit(4);
    }

    @Override
    protected void checkSubclass() {
        //  allow subclass
//        System.out.println("info   : checking menu subclass");
    }
}
