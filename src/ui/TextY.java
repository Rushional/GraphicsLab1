package ui;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class TextY extends Text {
    TextY(Composite window, int style) {
        super(window, style);
        addVerifyListener(new IntVerifier());
        setTextLimit(4);
    }

    void assignListener(SliderY sliderY, DrawManager drawManager) {
        addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                String text = ((Text)e.widget).getText();
                if (text.equals("")) text = "0";
                int y = Integer.parseInt(text);
                sliderY.setY(y);
                drawManager.movePoint();
            }
        });
    }

    @Override
    protected void checkSubclass() {
        //  allow subclass
//        System.out.println("info   : checking menu subclass");
    }
}
