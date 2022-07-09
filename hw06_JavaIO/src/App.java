import java.io.FileReader;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {
        // reading text
        StringBuilder output = new StringBuilder();
        try (FileReader fin = new FileReader("test.txt")) {
            int b = fin.read();

            while (b != -1) {
                output.append((char) b);
                b = fin.read();
            }
        }
        System.out.println("Original Text: \t\t\t" + output);

        
        int shift = 1;
        // writing text in caesar cipher
        try (CaesarWriter fout = new CaesarWriter(
                                new FileWriter("test2.txt"), shift)) {
            for (char c : output.toString().toCharArray()) {
                fout.write(c);
            }
        }


        // reading text in caesar cipher
        StringBuilder output2 = new StringBuilder();
        try (CaesarReader fin = new CaesarReader(
                                new FileReader("test2.txt"), shift)) {
            int b = fin.read();

            while (b != -1) {
                output2.append((char) b);
                b = fin.read();
            }
        }

        System.out.println("Decoded Caesar cipher text: \t" + output2);
    }
}
