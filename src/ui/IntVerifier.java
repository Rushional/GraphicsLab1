package ui;

import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;

public class IntVerifier implements VerifyListener {
    @Override
    public void verifyText(VerifyEvent e) {
//		If the input isn't a number, it gets canceled
        for (int i = 0; i < e.text.length(); i++) {
            if ("0123456789".indexOf(e.text.charAt(i)) == -1) {
                e.doit = false;
                break;
            }
        }
    }
}
