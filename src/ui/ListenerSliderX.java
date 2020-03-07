//package ui;
//
//import org.eclipse.swt.events.SelectionAdapter;
//import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.swt.graphics.Point;
//import org.eclipse.swt.widgets.Text;
//
//public class ListenerSliderX extends SelectionAdapter {
//    private Text textCurrentX;
//    private SliderY sliderY;
//    private DrawManager manager;
//
//    public ListenerSliderX(Text text, SliderY sliderY, DrawManager manager) {
//        textCurrentX = text;
//        this.sliderY = sliderY;
//        this.manager = manager;
//    }
//
//    @Override
//    public void widgetSelected(SelectionEvent e) {
//        textCurrentX.setText(new Integer(getSelection()).toString());
//        x = getSelection();
//        manager.movePoint(new Point(getSelection(), sliderY.getY()));
//    }
//}
