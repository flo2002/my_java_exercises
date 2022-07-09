public class Rechteck {
    private Punkt _p1;
    private Punkt _p2;

    Rechteck(Punkt p1, Punkt p2) {
        _p1 = p1;
        _p2 = p2;
    }

    Rechteck() {
        this(new Punkt(), new Punkt());
    }

    public void moveRechteck(int x, int y) {
        _p1._x += x;
        _p2._x += x;
        _p1._y += y;
        _p2._y += y;
    }

    public Boolean isQuadrat() {
        int l1 = _p1._x - _p2._x;
        int l2 = _p1._y - _p2._y;

        if (l1 == l2) {
            return true;
        } else {
            return false;
        }
    }

    public double umkreis() {
        int l1 = _p2._x - _p1._x;
        int l2 = _p2._y - _p1._y;

        double rad = Math.sqrt(Math.pow(l1, 2) + Math.pow(l2, 2));

        return rad;
    }

    public void zoomRechteck(int f) {
        /*
            Exception Handling
        */
        
        if (f > 0) {
            _p1._x *= f;
            _p1._y *= f;
            _p2._x *= f;
            _p2._y *= f;
        } else {
            f *= -1;
            _p1._x /= f;
            _p1._y /= f;
            _p2._x /= f;
            _p2._y /= f;
        }
    }

    public Rechteck[] splitRechteck() {
        /*
            Exception Handling
        */

        Rechteck b[] = {
            new Rechteck(),
            new Rechteck(),
            new Rechteck(),
            new Rechteck()
        };
        
        Punkt orig = _p1;
        int l1 = _p2._x - _p1._x;
        int l2 = _p2._y - _p1._y;

        b[0]._p1 = orig;
        b[0]._p2._x = _p1._x + (l1 / 2);
        b[0]._p2._y = _p1._x + (l2 / 2);

        b[1]._p1._x = _p1._x + (l1 / 2);
        b[1]._p1._y = _p1._y;
        b[1]._p2._x = _p1._x + l1;
        b[1]._p2._y = _p1._y + (l2 / 2);

        b[2]._p1._x = _p1._x;
        b[2]._p1._y = _p1._y + (l2 / 2);
        b[2]._p2._x = _p1._x + (l1 / 2);
        b[2]._p2._y = _p1._y + l2;

        b[3]._p1._x = (_p1._x / 2) + l1;
        b[3]._p1._y = (_p1._y / 2) + l2;
        b[3]._p2._x = (_p2._x / 2) + l1;
        b[3]._p2._y = (_p2._y / 2) + l2;

        return b;
    }

    public String toString() {
        return "p1: " + _p1._x + "," + _p1._y + "  p2: " + _p2._x + "," + _p2._y;
    }
}
