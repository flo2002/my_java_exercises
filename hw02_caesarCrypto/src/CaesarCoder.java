public class CaesarCoder {
    // Initialisierungsblock für Variante 1
    private String _text;

    // Konstruktor für Variante 1
    public CaesarCoder(String text1) {
        _text = text1;
    }

    // Variante 1
    public void encode(int key) {
        _text = CaesarCoder.encode(_text, key);
    }

    public void decode(int key) {
        _text = CaesarCoder.decode(_text, key);
    }

    // Variante 3
    public static String encode(String text, int key) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (Character.isLetter(character)) {
                if (Character.isUpperCase(character)) {
                    sb.append((char) (((character - 'A' + key) % 26) + 'A'));
                } else {
                    sb.append((char) (((character - 'a' + key) % 26) + 'a'));
                }
            } else {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    // Variante 4
    public static StringBuilder encode(StringBuilder text, int key) {
        String tmp = text.toString();
        tmp = encode(tmp, key);
        StringBuilder result = new StringBuilder(tmp);
        return result;
    }

    public static StringBuilder decode(StringBuilder text, int key) {
        String tmp = text.toString();
        tmp = decode(tmp, key);
        StringBuilder result = new StringBuilder(tmp);
        return result;
    }

    public static String decode(String text, int key) {
        return encode(text, (26 - key));
    }

    // getter und set(ter)
    public void setText(String text) {
        _text = text;
    }

    public String getText() {
        return _text;
    }
}
