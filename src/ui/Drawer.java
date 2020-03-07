package ui;

import Jama.Matrix;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.RGB;

public class Drawer {
    private Window window;
    private GC gc;

    public Drawer(Window window, GC gc) {
        this.window = window;
        this.gc = gc;
    }

    /**
     * Рисует многоугольник, описываемый матрицей вида
     *|x1 y1 ...|  (точка 1)
     *|x2 y2 ...|  (точка 2)
     */
    public void drawPolygon(Matrix m){
        if (m == null || m.getColumnDimension() < 2){
            System.out.println("Wrong matrix when drawing the polygon");
            return;
        }
        int[] coordArray = new int[m.getRowDimension()*2];//an array with the coordinates (x1 y1 x2 y2 x3 y3...)
        for (int i = 0; i < m.getRowDimension(); i++ ){
            for (int j = 0; j < 2; j++){
                coordArray[i*2 + j] = (int) m.get(i, j);
            }
        }
        gc.drawPolygon(coordArray);
    }

    /**
     * Рисует ломаную, описываемую матрицей вида
     *|x1 y1 ...|  (точка 1)
     *|x2 y2 ...|  (точка 2)
     */
    void drawPolyline(Matrix m){
        if (m == null || m.getColumnDimension() < 2){
            System.out.println("Отрисовка ломаной: неправильно заданная матрица!");
            return;
        }
        int[] coordArray = new int[m.getRowDimension()*2];
        for (int i = 0; i < m.getRowDimension(); i++ ){
            for (int j = 0; j < 2; j++){
                coordArray[i*2 + j] = (int) m.get(i, j);
            }
        }
        gc.drawPolyline(coordArray);
    }

    /*
     * Рисует линии из 2 точек, описываемые матрицей вида
     *|x1 y1 ...|  (точка 1) линия 1
     *|x2 y2 ...|  (точка 2) линия 1
     *|x3 y3 ...|  (точка 1) линия 2
     *|x4 y4 ...|  (точка 2) линия 2
     */
    void draw2PointLines(Matrix m){
        if (m == null || m.getColumnDimension() < 2 || (m.getRowDimension() & 0x1) != 0){
            System.out.println("Отрисовка линий из 2 точек: неправильно заданная матрица!");
            return;
        }
//		int[] coordArray = new int[m.getRowDimension()*2];//������ � ������������ (x1 y1 x2 y2 x3 y3...)
        for (int i = 0; i < m.getRowDimension(); i+=2 ){
            gc.drawLine((int)m.get(i,0), (int)m.get(i,1), (int)m.get(i + 1, 0), (int)m.get(i + 1, 1));
        }
    }

    /*
     * Рисует точки, описываемые матрицей вида
     *|x1 y1 ...|  (точка 1)
     *|x2 y2 ...|  (точка 2)
     *...
     */
    void drawFilledCircles(Matrix m, int circleRadius, Color color){
        if (m == null || m.getColumnDimension() < 2){
            System.out.println("Отрисовка точек: неправильно заданная матрица!");
            return;
        }
        Color back = gc.getBackground();
        gc.setBackground(color);
        for (int i = 0; i < m.getRowDimension(); i++ ){
            gc.fillOval((int) m.get(i, 0) - circleRadius, (int) m.get(i, 1) - circleRadius, 2*circleRadius, 2*circleRadius);
        }
        gc.setBackground(back);
        for (int i = 0; i < m.getRowDimension(); i++ ){
            gc.drawText(Integer.toString(i), (int) m.get(i, 0) - 2*circleRadius, (int) m.get(i, 1), true);
        }
    }

    public void drawCoordinatesGrid(){
        int step = 50;
        int sizeX = window.getSize().x;
        int sizeY = window.getSize().y;
        int colorRGB = 180;
        int i = 0;
        for (i = 0; i < sizeX; i+= step){
            gc.drawText(((Integer)i).toString(), i, 0); //integer - строка перевода в разные типы
        }
        for (i = 0; i < window.getSize().y; i+= step){
            gc.drawText(((Integer)i).toString(), 0, i); //integer - строка перевода в разные типы
        }
        //gray
        Color foregroundOld = gc.getForeground();
        gc.setForeground(new Color(window.getDisplay(), new RGB(colorRGB,colorRGB,colorRGB)));
        for (i = 0; i < sizeX; i+= step){
            gc.drawLine(i, 0, i, sizeY);
        }
        for (i = 0; i < window.getSize().y; i+= step){
            gc.drawLine(0, i, sizeX, i);
        }
        gc.setForeground(foregroundOld);
    }
}
