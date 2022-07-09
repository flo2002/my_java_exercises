public class App {
    public static void main(String[] args) throws Exception {
        // Variante 1 mit void Methoden und String als Parametertyp
        System.out.println("Variante 1 mit void Methoden und String als Parametertyp");
        String text1 = new String("HelloWorld");
        CaesarCoder coder1 = new CaesarCoder(text1);
        coder1.setText("HelloWorldHelloWorld");
        System.out.println("\t" + coder1.getText());
        coder1.encode(10);
        System.out.println("\t" + coder1.getText());
        coder1.decode(10);
        System.out.println("\t" + coder1.getText());

        // Variante 3 mit static Methoden und String als Parametertyp
        System.out.println("Variante 3 mit static String:");
        String text3 = new String("AHelloWorld");
        System.out.println("\t" + text3);
        String encrypted3 = CaesarCoder.encode(text3, 8);
        System.out.println("\t" + encrypted3);
        String decrypted3 = CaesarCoder.decode(encrypted3, 8);
        System.out.println("\t" + decrypted3);

        // Variante 4 mit static Methoden und StringBuilder als Parametertyp
        System.out.println("Variante 4 mit static StringBuilder:");
        StringBuilder text4 = new StringBuilder("HelloWorld");
        System.out.println("\t" + text4);
        StringBuilder encrypted4 = CaesarCoder.encode(text4, 12);
        System.out.println("\t" + encrypted4);
        StringBuilder decrypted4 = CaesarCoder.decode(encrypted4, 12);
        System.out.println("\t" + decrypted4);
    }
}
