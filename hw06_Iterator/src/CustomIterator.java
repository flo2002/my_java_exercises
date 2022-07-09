import java.util.Iterator;

public class CustomIterator<T> implements Iterator<T> {
    private Iterator<T> _base;

    public CustomIterator(Iterator<T> base) {
        _base = base;
    }

    public boolean hasNext() {
        return _base.hasNext();
    }

    public T next() {
        T t = _base.next();
        if (t instanceof Integer) {
            if (((Integer) t) % 2 == 1) {
                remove();                   // this took me a long time to figure out!!! 
                return t;
            }
        }
        return null;
    }

    public void remove() {
        _base.remove();
    }
    
}
