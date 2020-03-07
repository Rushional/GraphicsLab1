package lab;

import org.eclipse.swt.graphics.Point;
import Jama.Matrix;

public class Lab1 {
	private static Matrix defaultTriangle = new Matrix(new double[][] {{600.0, 400.0, 1.0},{600.0, 300.0, 1.0},{700.0, 400.0, 1.0}});
	private Point currentPoint;
	private Matrix currentTriangle;
//	private MainWindow parent;
//
//	public Lab1(MainWindow parent){
//		this.parent = parent;
//	}
//	Вызывается при выборе пункта меню этой лабы.
//	Здесь должен быть основной код лабы.
//	Задает и считает матрицы треугольников.
//	public void run(){
////		defaultTriangle = new Matrix(new double[][] {{600.0, 400.0, 1.0},{600.0, 300.0, 1.0},{700.0, 400.0, 1.0}});
////		перерисовка composite - отправка события PaintEvent
////		и вызов метода MainWindow.paintLab1.paintControl()
////		(paintLab1 добавлен к composite методом addPaintListener())
////		parent.getComposite().redraw();
////		point = new CoordinatesRequestDialog(parent).open();
////		if (point == null) return;
////		parent.getComposite().redraw();
////		Matrix changeSK = new Matrix(new double[][] {{1.0, 0.0, 0.0},{0.0, 1.0, 0.0},{-point.x, -point.y, 1.0}});
////		double angle = new AngleRequestDialog(parent).open();
////		angle = Math.toRadians(angle);
////		Matrix rotate = new Matrix(new double[][] {{Math.cos(-angle), Math.sin(-angle), 0.0},{-Math.sin(-angle), Math.cos(-angle), 0.0},{0.0, 0.0, 1.0}});
////		Matrix changeSKback = new Matrix(new double[][] {{1.0, 0.0, 0.0},{0.0, 1.0, 0.0},{point.x, point.y, 1.0}});
////		changedTriangle = defaultTriangle.times(changeSK);//times - умножение матриц
////		changedTriangle = changedTriangle.times(rotate);
////		changedTriangle = changedTriangle.times(changeSKback);
//
//		//triangle2(повернутый вокруг точки треугольник triangle1) = triangle1 * changeSK * rotate * changeSKback;
//	}
	
	public Matrix getDefaultTriangle(){
		return defaultTriangle;
	}
	
	public Matrix changeTriangle(Point point, double angle){
//		parent.getComposite().redraw();
//		point = new CoordinatesRequestDialog(parent).open();
//		if (point == null) return;
//		parent.getComposite().redraw();
		Matrix changeSK = new Matrix(new double[][] {{1.0, 0.0, 0.0},{0.0, 1.0, 0.0},{-point.x, -point.y, 1.0}});
//		double angle = new AngleRequestDialog(parent).open();
		angle = Math.toRadians(angle);
		Matrix rotate = new Matrix(new double[][] {{Math.cos(-angle), Math.sin(-angle), 0.0},{-Math.sin(-angle), Math.cos(-angle), 0.0},{0.0, 0.0, 1.0}});
		Matrix changeSKback = new Matrix(new double[][] {{1.0, 0.0, 0.0},{0.0, 1.0, 0.0},{point.x, point.y, 1.0}});
		Matrix changedTriangle = defaultTriangle.times(changeSK);//times - умножение матриц
		changedTriangle = changedTriangle.times(rotate);
		changedTriangle = changedTriangle.times(changeSKback);
		currentTriangle = changedTriangle;
		return changedTriangle;
	}
	
	public Point getCurrentPoint(){
		return currentPoint;
	}
}
