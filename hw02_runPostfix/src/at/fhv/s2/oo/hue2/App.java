package at.fhv.s2.oo.hue2;

public class App {
    public static void main(String[] args) throws Exception {
        // Tests:
        Postfix postfix1 = new Postfix("15 5 + 5 + 3 * ;", 2);
        System.out.println(postfix1);
        System.out.println("\t" + postfix1.getResult());
        //postfix1.setPostfix("15 5 5 - 3 * ;", 3);
        //postfix1.setPostfix("15 5 5 - 15 / ;", 3);
        postfix1.setPostfix("-15 5 - 3 * ;", 3);
        //postfix1.setPostfix("15 0 - 15 / ;", 3);
        System.out.println(postfix1);
        System.out.println("\t" + postfix1.getResult());
        Postfix postfix2 = new Postfix();
        System.out.println(postfix2);
    }
}
