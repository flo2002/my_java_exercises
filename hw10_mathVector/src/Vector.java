public class Vector {
    private Double[] _p1;
    private Double[] _p2;

    public Vector (Double[] p1, Double[] p2) {
        _p1 = p1;
        _p2 = p2;
    }

    public Vector (Double[] p1) {
        this(new Double[] {0.0, 0.0}, p1);
    }

    public Vector (Double angle, Double len) {
        Double p1[] = new Double[] {0.0, 0.0};
        Double p2[] = new Double[] {0.0, 0.0};

        p2[0] = Math.sin(angle) * len;
        p2[1] = Math.cos(angle) * len;

        _p1 = p1;
        _p2 = p2;
    }

    public Vector scalarMultiplication(Double scalar, Vector vector) {
        vector._p1[0] = vector._p1[0] * scalar;
        vector._p1[1] = vector._p1[1] * scalar;
        return vector;
    }

    public Double calculateLength(Double[] p1, Double[] p2) {
        return Math.sqrt(Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2));
    }

    public Double calculateAngle(Double[] p1, Double[] p2) {
        return Math.atan2(p2[1] - p1[1], p2[0] - p1[0]) * 180 / Math.PI;
    }

    public Double calculateNormVector() {
        Double res = 0.0;
        for (int i = 0; i < _p1.length; i++) {
            res += _p1[i] * _p2[i];
            System.out.println(res);
        }

        return Math.sqrt(res);
    }

    public String calculateLinearEquation() {
        return "(n * X) - (n * P) = 0";
    }

    @Override
    public String toString() {
        return "Vector: " + _p1[0] + " " + _p1[1] + " | " + _p2[0] + " " + _p2[1];
    }
}
