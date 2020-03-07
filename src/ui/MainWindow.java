package ui;

import lab.Lab1;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.layout.GridData;
import Jama.Matrix;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import test.TestingSlider;

public class MainWindow extends Shell {
	private PaintListener paintLab1;

//	private final Composite canvas;
	private Lab1 lab1;

	// Launch the application.
	public static void main(String[] args) {
		TestingSlider sliderTest = new TestingSlider();
		try {
			Display display = Display.getDefault();
			MainWindow shell = new MainWindow(display);
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

	//	Create the shell.
	private MainWindow(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new GridLayout(1, false));
//		canvas = new Canvas(this, SWT.BORDER);
//		canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		// Menu generation
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);

		MenuItem menuItem_1 = new MenuItem(menu, SWT.CASCADE);
		menuItem_1.setText("Лабораторные работы");

		Menu menu_1 = new Menu(menuItem_1);
		menuItem_1.setMenu(menu_1);

//		MenuItem menuItem = new MenuItem(menu_1, SWT.NONE);
//		menuItem.addSelectionListener(new SelectionAdapter() {
//			//is called when lab1 is chosen
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				removeAllListeners(canvas, SWT.Paint);
//				canvas.addPaintListener(paintLab1);
//				lab1.run();
//				canvas.redraw();
//			}
//		});
//		menuItem.setText("Работа 1");
//
//		lab1 = new Lab1(this);
//		paintLab1 = new PaintListener() {
//
////			 PaintListener listens for PaintEvent,
////			 This means paintControl is called after every PaintEvent
////			 which is every time the picture changes
//			@Override
//			public void paintControl(PaintEvent e) {
//				drawCoordinatesGrid(e.gc);
//				if (lab1.getDefaultTriangle() != null){
//					drawPolygon(lab1.getDefaultTriangle(), e.gc);
//				}
//				if (lab1.getChangedTriangle() != null){
//					drawPolygon(lab1.getChangedTriangle(), e.gc);
//				}
//				if (lab1.getPoint() != null){
//					e.gc.drawPoint(lab1.getPoint().x, lab1.getPoint().y);
//					e.gc.drawOval(lab1.getPoint().x -2, lab1.getPoint().y -2, 4, 4);
//				}
//			}
//		};
//		createContents();
//	}

//	Create contents of the shell.
//private void createContents() {
//		setText("Практическая работа");
//		setSize(900, 900);
//	}
//
//	@Override
//	protected void checkSubclass() {
//		// Disable the check that prevents subclassing of SWT components
//	}
//
//	public Composite getComposite(){
//		return canvas;
//	}
//
//	private void removeAllListeners(Widget widget, int eventType){
//		for (Listener l : widget.getListeners(eventType)){
//			widget.removeListener(eventType, l);
//		}
//	}

	/**
	 * Рисует многоугольник, описываемый матрицей вида
	 *|x1 y1 ...|  (точка 1)
	 *|x2 y2 ...|  (точка 2)
	 */
//	private void drawPolygon(Matrix m, GC gc){
//		if (m == null || m.getColumnDimension() < 2){
//			System.out.println("Wrong matrix when drawing the polygon");
//			return;
//		}
//		int[] coordArray = new int[m.getRowDimension()*2];//an array with the coordinates (x1 y1 x2 y2 x3 y3...)
//		for (int i = 0; i < m.getRowDimension(); i++ ){
//			for (int j = 0; j < 2; j++){
//				coordArray[i*2 + j] = (int) m.get(i, j);
//			}
//		}
//		gc.drawPolygon(coordArray);
//	}
//
//	/**
//	 * Рисует ломаную, описываемую матрицей вида
//	 *|x1 y1 ...|  (точка 1)
//	 *|x2 y2 ...|  (точка 2)
//	 */
//	private void drawPolyline(Matrix m, GC gc){
//		if (m == null || m.getColumnDimension() < 2){
//			System.out.println("Отрисовка ломаной: неправильно заданная матрица!");
//			return;
//		}
//		int[] coordArray = new int[m.getRowDimension()*2];
//		for (int i = 0; i < m.getRowDimension(); i++ ){
//			for (int j = 0; j < 2; j++){
//				coordArray[i*2 + j] = (int) m.get(i, j);
//			}
//		}
//		gc.drawPolyline(coordArray);
//	}
//
//	/*
//	 * Рисует линии из 2 точек, описываемые матрицей вида
//	 *|x1 y1 ...|  (точка 1) линия 1
//	 *|x2 y2 ...|  (точка 2) линия 1
//	 *|x3 y3 ...|  (точка 1) линия 2
//	 *|x4 y4 ...|  (точка 2) линия 2
//	 */
//	private void draw2PointLines(Matrix m, GC gc){
//		if (m == null || m.getColumnDimension() < 2 || (m.getRowDimension() & 0x1) != 0){
//			System.out.println("Отрисовка линий из 2 точек: неправильно заданная матрица!");
//			return;
//		}
////		int[] coordArray = new int[m.getRowDimension()*2];//������ � ������������ (x1 y1 x2 y2 x3 y3...)
//		for (int i = 0; i < m.getRowDimension(); i+=2 ){
//			gc.drawLine((int)m.get(i,0), (int)m.get(i,1), (int)m.get(i + 1, 0), (int)m.get(i + 1, 1));
//		}
//	}
//
//	/*
//	 * Рисует точки, описываемые матрицей вида
//	 *|x1 y1 ...|  (точка 1)
//	 *|x2 y2 ...|  (точка 2)
//	 *...
//	 */
//	private void drawFilledCircles(Matrix m, GC gc, int circleRadius, Color color){
//		if (m == null || m.getColumnDimension() < 2){
//			System.out.println("Отрисовка точек: неправильно заданная матрица!");
//			return;
//		}
//		Color back = gc.getBackground();
//		gc.setBackground(color);
//		for (int i = 0; i < m.getRowDimension(); i++ ){
//			gc.fillOval((int) m.get(i, 0) - circleRadius, (int) m.get(i, 1) - circleRadius, 2*circleRadius, 2*circleRadius);
//		}
//		gc.setBackground(back);
//		for (int i = 0; i < m.getRowDimension(); i++ ){
//			gc.drawText(Integer.toString(i), (int) m.get(i, 0) - 2*circleRadius, (int) m.get(i, 1), true);
//		}
//	}
//
//	private void drawCoordinatesGrid(GC gc){
//		int step = 50;
//		int Sizex = this.getSize().x;
//		int Sizey = this.getSize().y;
//		int colorRGB = 180;
//		int i = 0;
//		for (i = 0; i < Sizex; i+= step){
//			gc.drawText(((Integer)i).toString(), i, 0); //integer - строка перевода в разные типы
//		}
//		for (i = 0; i < this.getSize().y; i+= step){
//			gc.drawText(((Integer)i).toString(), 0, i); //integer - строка перевода в разные типы
//		}
//		//gray
//		Color foregroundOld = gc.getForeground();
//		gc.setForeground(new Color(getDisplay(), new RGB(colorRGB,colorRGB,colorRGB)));
//		for (i = 0; i < Sizex; i+= step){
//			gc.drawLine(i, 0, i, Sizey);
//		}
//		for (i = 0; i < this.getSize().y; i+= step){
//			gc.drawLine(0, i, Sizex, i);
//		}
//		gc.setForeground(foregroundOld);
	}
}
