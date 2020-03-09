package model;

import org.eclipse.swt.graphics.Point;
import Jama.Matrix;

public class Lab1Model {
	private static Matrix defaultTriangle = new Matrix(new double[][] {
			{750.0, 250.0, 1.0},
			{850.0, 250.0, 1.0},
			{850.0, 150.0, 1.0}});
	private Matrix currentTriangle;
	
	public Matrix getDefaultTriangle(){
		return defaultTriangle;
	}
	
	public void changeTriangle(Point point, double angle){
		Matrix changeSK = new Matrix(new double[][] {
				{1.0, 0.0, 0.0},
				{0.0, 1.0, 0.0},
				{-point.x, -point.y, 1.0}});
		angle = Math.toRadians(angle);
		Matrix rotate = new Matrix(new double[][] {
				{Math.cos(-angle), Math.sin(-angle), 0.0},
				{-Math.sin(-angle), Math.cos(-angle), 0.0},
				{0.0, 0.0, 1.0}});
		Matrix changeSKback = new Matrix(new double[][] {
				{1.0, 0.0, 0.0},
				{0.0, 1.0, 0.0},
				{point.x, point.y, 1.0}});
		Matrix changedTriangle = defaultTriangle.times(changeSK); //times - умножение матриц
		changedTriangle = changedTriangle.times(rotate);
		changedTriangle = changedTriangle.times(changeSKback);
		currentTriangle = changedTriangle;
	}

	public Matrix getCurrentTriangle() {
		return currentTriangle;
	}
}
