import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class Codewords {
    private static Set<String> _codewords = new HashSet<String>();
    private static int _generations;

    private static Boolean exists(String codeword) {
        return _codewords.contains(codeword.toString());
    }

    private static char randChar() {
        Random rnd = new Random();
        char c = (char) ('a' + rnd.nextInt(26));
        //char c = (char) ('a' + rnd.nextInt(2));       // for testing
        //char c = (char) ('a' + rnd.nextInt(1));       // for testing
        return c;
    }

    public static String generate(int len) {
        StringBuilder cw = new StringBuilder();
        for (int i=0; len>i; i++) {
            cw.append(randChar());
        }
        
        if (!exists(cw.toString())) {
            _codewords.add(cw.toString());
            return cw.toString();
        } else {
            if (_generations > 10) {
                return "error";
            }
            _generations++;
            return generate(len);
        }
    }

    public String toString() {
        return _codewords.toString();
    }
}
