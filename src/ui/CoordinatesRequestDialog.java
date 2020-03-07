package ui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CoordinatesRequestDialog extends Dialog {

	private Point result;
	private Shell shell;
	private Text text1;
	private Text text2;
	private Label label_2;

//	Create the dialog.
	public CoordinatesRequestDialog(Shell parent) {
		super(parent, SWT.NONE);
		setText("Ввод координат");
	}

//	@return the result
	public Point open() {
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

//	Create contents of the dialog.
	private void createContents() {
		shell = new Shell(getParent(), SWT.BORDER | SWT.TITLE);
		shell.setMinimumSize(new Point(50, 20));
		shell.setSize(180, 210);
		shell.setText("Координаты точки");
		shell.setLayout(new GridLayout(2, false));
		
		Label label = new Label(shell, SWT.NONE);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		label.setText("Введите координату  1:");
		
		text1 = new Text(shell, SWT.BORDER);
		text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		label_1.setText("Введите координату 2:");
		
		text2 = new Text(shell, SWT.BORDER);
		text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		label_2 = new Label(shell, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		
		Button buttonOK = new Button(shell, SWT.NONE);
		buttonOK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (text1.getText().length() != 0 && text2.getText().length() != 0){
					try{
						result = new Point(Integer.parseInt(text1.getText()),Integer.parseInt(text2.getText()));
					}
					catch (NumberFormatException ignored){ }
					shell.dispose();
				}
				else{
					label_2.setText("Введите координаты");
				}
			}
		});
		buttonOK.setText("OK");

		Button buttonCancel = new Button(shell, SWT.NONE);
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		buttonCancel.setText("Отмена");
		
		text1.addVerifyListener(new VerifyListener(){
			@Override
			public void verifyText(VerifyEvent e) {
//				If the input isn't numbers or a dot, it gets canceled
				for (int i = 0; i < e.text.length(); i++) {
					if ("0123456789-".indexOf(e.text.charAt(i)) == -1) {
						e.doit = false;
						break;
					}
				}
			}
		});
		
		text2.addVerifyListener(new VerifyListener(){
			@Override
			public void verifyText(VerifyEvent e) {
				for (int i = 0; i < e.text.length(); i++) {
					if ("0123456789-".indexOf(e.text.charAt(i)) == -1) {
						e.doit = false;
						break;
					}
				}
			}
		});
	}

}
