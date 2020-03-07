package lab;

import org.eclipse.swt.graphics.Point;
import Jama.Matrix;

public class Lab1Model {
	private static Matrix defaultTriangle = new Matrix(new double[][] {{600.0, 400.0, 1.0},{600.0, 300.0, 1.0},{700.0, 400.0, 1.0}});
	private Matrix currentTriangle;
	
	public Matrix getDefaultTriangle(){
		return defaultTriangle;
	}

	public void moveHorizontally() {

	}

	public void moveVertically() {

	}

	public void rotate() {

	}
	
	public void changeTriangle(Point point, double angle){
		Matrix changeSK = new Matrix(new double[][] {{1.0, 0.0, 0.0},{0.0, 1.0, 0.0},{-point.x, -point.y, 1.0}});
		angle = Math.toRadians(angle);
		Matrix rotate = new Matrix(new double[][] {{Math.cos(-angle), Math.sin(-angle), 0.0},{-Math.sin(-angle), Math.cos(-angle), 0.0},{0.0, 0.0, 1.0}});
		Matrix changeSKback = new Matrix(new double[][] {{1.0, 0.0, 0.0},{0.0, 1.0, 0.0},{point.x, point.y, 1.0}});
		Matrix changedTriangle = defaultTriangle.times(changeSK); //times - умножение матриц
		changedTriangle = changedTriangle.times(rotate);
		changedTriangle = changedTriangle.times(changeSKback);
		currentTriangle = changedTriangle;
	}

	public Matrix getCurrentTriangle() {
		return currentTriangle;
	}
}
