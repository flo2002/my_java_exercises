
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

public class Graph extends JComponent {
    private CoordinateSystem _coordinateSystem;
    private int _a;
    private int _b;
    private int _c;
    private int[] _xPoints;
    private int[] _yPoints;

    public Graph(CoordinateSystem coordinateSystem, int preferredX, int preferredY, int a, int b, int c) {
        _coordinateSystem = coordinateSystem;
        setPreferredSize(new Dimension(preferredX, preferredY));
        _a = a;
        _b = b;
        _c = c;
    }

    public void drawGraph(Graphics g) {
        calculatePoints();
        g.setColor(Color.RED);
        g.drawPolyline(_xPoints, _yPoints, _xPoints.length);
    }

    private void calculatePoints() {
        int width = getWidth();
        int height = getHeight();
        int scaleX = _coordinateSystem.getScaleX();
        int scaleY = _coordinateSystem.getScaleY();
        int len = width/scaleX;
        _xPoints = new int[len*2];
        _yPoints = new int[len*2];

        for (int i = 0; i < len; i++) {
            _xPoints[len-i] = -1*i;
            _yPoints[len-i] = _a*i*i + -1*_b*i + _c;

            _xPoints[len+i] = i;
            _yPoints[len+i] = _a*i*i + _b*i + _c;
        }

        for (int i = 0; i < _xPoints.length; i++) {
            _xPoints[i] = _xPoints[i] * scaleX + (width/2);
            _yPoints[i] = _yPoints[i] * scaleY * -1 + (height/2);

            System.out.println(i + " " + _xPoints[i] + " " + _yPoints[i]);
        }

        // reverse the array (to remove the spike at the beginning)
        for(int i = 0; i < _yPoints.length / 2; i++) {
            int temp = _yPoints[i];
            _yPoints[i] = _yPoints[_yPoints.length - i - 1];
            _yPoints[_yPoints.length - i - 1] = temp;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
