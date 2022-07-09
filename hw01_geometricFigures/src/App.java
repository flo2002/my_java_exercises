public class App {
    public static void main(String[] args) throws Exception {
        // init
        Punkt p0 = new Punkt(2,2);
        Punkt p1 = new Punkt(2,2);
        Punkt p2 = new Punkt(4,4);
        Punkt p3 = new Punkt(5,6);
        Rechteck a1 = new Rechteck(p0, p2);
        Rechteck a2 = new Rechteck(p1, p3);
        System.out.println("init: ");
        System.out.println("    " + a1);
        System.out.println("    " + a2);

        // move
        a2.moveRechteck(3, 2);
        System.out.println("move: ");
        System.out.println("    " + a1);
        System.out.println("    " + a2);

        // isQuadrat
        System.out.println("isQuadrat: ");
        System.out.println("    " + a1.isQuadrat());
        System.out.println("    " + a2.isQuadrat());

        // Umkreis
        System.out.println("Umkreis: ");
        System.out.println("    " + a1);
        System.out.println("    " + a1.umkreis());

        // zoom
        a1.zoomRechteck(-2);
        System.out.println("zoom: ");
        System.out.println("    " + a1);
        a1.zoomRechteck(4);
        System.out.println("    " + a1);

        // split
        Rechteck b[] = a1.splitRechteck();
        System.out.println("split: ");
        System.out.println("    " + b[0]);
        System.out.println("    " + b[1]);
        System.out.println("    " + b[2]);
        System.out.println("    " + b[3]);
    }
}
