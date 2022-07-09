import java.io.IOException;
import java.io.Writer;

public class CaesarWriter extends Writer {
    private final Writer _base;
    private int _shift;

    public CaesarWriter(Writer base, int shift) {
        _base = base;
        _shift = shift;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = 0; i < len; i++) {
            char character = cbuf[off + i];

            if (Character.isLetter(character)) {
                if (Character.isUpperCase(character)) {
                    character = (char) ((((character - 'A') + _shift) % 26) + 'A');
                } else if (Character.isLowerCase(character)) {
                    character = (char) ((((character - 'a') + _shift) % 26) + 'a');
                }
            }
            cbuf[off + i] = character;
        }
        _base.write(cbuf, off, len);
    }

    @Override
    public void close() throws IOException {
        _base.close();
    }

    @Override
    public void flush() throws IOException {
        _base.flush();
    }
}
