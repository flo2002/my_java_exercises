import java.io.IOException;
import java.io.Reader;

public class CaesarReader extends Reader {
    private final Reader _base;
    private int _shift;

    public CaesarReader(Reader base, int shift) {
        _base = base;
        _shift = shift;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int readLen = _base.read(cbuf, off, len);
        for (int i = 0; i < readLen; i++) {
            char character = cbuf[off + i];
            
            if (Character.isLetter(character)) {
                if (Character.isUpperCase(character)) {
                    character = (char) ((((character - 'A') + (26 - (_shift % 26))) % 26) + 'A');
                } else if (Character.isLowerCase(character)) {
                    character = (char) ((((character - 'a') + (26 - (_shift % 26))) % 26) + 'a');
                }
            }
            cbuf[off + i] = character;
        }
        return readLen;
    }

    @Override
    public void close() throws IOException {
        _base.close();
    }
}
