public class VectorGeneric<T extends Number> {
    private T[] _p1;
    private T[] _p2;

    public Vector (T[] p1, T[] p2) {
        _p1 = p1;
        _p2 = p2;
    }

    public Vector (T[] p1) {
        Object p0[] = new Object[] {0, 0};
        _p1[0] = (T) p0[0];
        _p1[1] = (T) p0[1];

        _p2 = p1;
    }

    public Vector (T angle, T len) {
        Object p0[] = new Object[] {0, 0};
        p0[0] = (T) p0[0];
        p0[1] = (T) p0[1];

        
    }

    public Vector<T> scalarMultiplication(T scalar, Vector<T> vector) {
        vector._p1[0] = (T) ((T) vector._p1[0]).doubleValue() * ((T) scalar).doubleValue();
        return null;
    }

    public Double calculateLength(T[] p1, T[] p2) {
        return Math.sqrt(Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2));
    }

    public Double calculateAngle(T[] p1, T[] p2) {
        return Math.atan2(p2[1] - p1[1], p2[0] - p1[0]) * 180 / Math.PI;
    }

    public Double calculateNormVector() {
        return 
    }

    public String calculateLinearEquation() {
        return 
    }

    @Override
    public String toString() {
        return "Vector: " + _p1[0] + " " + _p1[1] + " | " + _p2[0] + " " + _p2[1];
    }
}
