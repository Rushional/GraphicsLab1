package test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.GridData;
/**
 * тестовый класс, в нем можно рисовать
 * @author user
 *
 */
public class TestDraw extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			TestDraw shell = new TestDraw(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public TestDraw(final Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new GridLayout(1, false));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite.addPaintListener(new PaintListener() {
			//здесь рисуются фигуры 
			//при каждом событии PaintEvent для этого composite. 
			//событие вызывается при создании, изменении размера и т.п.
			public void paintControl(PaintEvent e) {
				System.out.println("вызван PaintListener.paintControl()");
				e.gc.drawLine(150, 50, 400, 100);
				e.gc.drawOval(0, 0, 100, 100);
				e.gc.setForeground(new Color(getDisplay(), new RGB(150,150,150)));
				e.gc.drawOval(0, 0, getShell().getSize().x - 50, getShell().getSize().y - 50);
				e.gc.drawPolygon(new int[]{150,150,250,100,400,200,200,300});
				e.gc.fillPolygon(new int[]{150,150,250,100,400,200,200,300});
			}
		});
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
