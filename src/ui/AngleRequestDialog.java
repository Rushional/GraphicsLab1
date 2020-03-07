package ui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;

public class AngleRequestDialog extends Dialog {

	private double result;
	private Shell shell;
	private Text text;

	//	Create the dialog.
	public AngleRequestDialog(Shell parent) {
		super(parent, SWT.NONE);
		setText("Ввод угла");
	}

//	Open the dialog.
	public double requestDouble() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

//	Create contents of the dialog
	private void createContents() {
		shell = new Shell(getParent(), SWT.BORDER | SWT.TITLE);
		shell.setSize(400, 160);
		shell.setText(getText());
		shell.setLayout(new GridLayout(2, false));
		
		Label label = new Label(shell, SWT.NONE);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		label.setText("Введите угол поворота(в градусах):");
		
		text = new Text(shell, SWT.BORDER);
		text.addVerifyListener(new VerifyListener(){
			@Override
			public void verifyText(VerifyEvent e) {
//				If the input isn't numbers or a dot, it gets canceled
				for (int i = 0; i < e.text.length(); i++) {
					if ("0123456789.-e".indexOf(e.text.charAt(i)) == -1) {
						e.doit = false;
						break;
					}
				}
			}
		});
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					result = Double.parseDouble(text.getText());
				}
				catch(NumberFormatException ignored){}
				shell.dispose();
			}
		});
		button.setText("OK");

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		button_1.setText("Отмена");
	}
}
