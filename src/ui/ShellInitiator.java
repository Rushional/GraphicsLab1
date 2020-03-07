package ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ShellInitiator {

	private Shell shell;

	public static void main(String[] args) {
		try {
			ShellInitiator window = new ShellInitiator();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void open() {
		Display display = Display.getDefault();
//		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

//	Create contents of the window.
	private void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Практическая работа");
	}
}
