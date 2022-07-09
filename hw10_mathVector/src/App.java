public class App {
    public static void main(String[] args) throws Exception {
        Double[] p1 = new Double[] {1.0, 1.0};
        Double[] p2 = new Double[] {3.0, 3.0};

        Double angle = 90.0;
        Double len = 2.0;

        Vector v1 = new Vector(p1);
        Vector v2 = new Vector(p1, p2);
        Vector v3 = new Vector(angle, len);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        Vector v4 = v1.scalarMultiplication(2.0, v1);
        System.out.println(v4);
        System.out.println("\tNorm: " + v4.calculateNormVector());
        System.out.println("\tLinear Equation: " + v4.calculateLinearEquation());

    }
}
