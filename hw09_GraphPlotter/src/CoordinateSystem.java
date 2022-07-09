
import javax.swing.*;
import java.awt.*;

public class CoordinateSystem extends JComponent {
    private int _width;
    private int _height;

    private int _steps;
    private int _scaleX;
    private int _scaleY;

    public CoordinateSystem(int steps) {
        _steps = steps;
        _scaleX = 20;
        _scaleY = 20;
    }

    public CoordinateSystem(int scale, int scaleX, int scaleY) {
        this(scale);
        _scaleX = scaleX;
        _scaleY = scaleY;
    }

    public void drawCoordinateSystem(Graphics g) {
        _width = getWidth();
        _height = getHeight();

        g.drawLine(_width/2, 0, _width/2, _height);
        g.drawLine(0, _height/2, _width, _height/2);

        Font font = new Font("Arial", Font.BOLD, 12);
        g.setFont(font);
        g.drawString("x", _width - 10, (_height/2) - 5);
        g.drawString("y", (_width/2)-10, 10);
        font = new Font("Arial", Font.PLAIN, 12);
        g.setFont(font);


        for (int i = _scaleX; i < _width/2; i += _scaleX) {
            int pi = _width/2 + i;  // positive x
            g.drawLine(pi, _height/2, pi, _height/2 + 5);
            g.drawString(String.valueOf(i/_steps), pi, _height/2 + 20);

            int ni = _width/2 - i;  // negative x
            g.drawLine(ni, _height/2, ni, _height/2 + 5);
            g.drawString(String.valueOf(-i/_steps), ni, _height/2 + 20);
        }

        for (int i = _scaleY; i < _height/2; i += _scaleY) {
            int pi = _height/2 - i;  // positive y
            g.drawLine(_width/2, pi, _width/2 + 5, pi);
            g.drawString(String.valueOf(i/_steps), _width/2 + 10, pi);

            int ni = _height/2 + i;  // negative y
            g.drawLine(_width/2, ni, _width/2 + 5, ni);
            g.drawString(String.valueOf(-i/_steps), _width/2 + 10, ni);
        }
    }

    public int getScaleX() {
        return _scaleX;
    }

    public int getScaleY() {
        return _scaleY;
    }

    public void scaleUp() {
        //_scaleX += 5;
        //_scaleY += 5;
        _steps--;
        repaint();
    }

    public void scaleDown() {
        //_scaleX -= 5;
        //_scaleY -= 5;
        _steps++;

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawCoordinateSystem(g);
    }
}
