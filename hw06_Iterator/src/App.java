import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App  {
    public static void main(String[] args) throws Exception {
        List<Integer> _values = new ArrayList<Integer>();
        //List<Integer> _values = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            _values.add(i);
        }

        CustomIterator<Integer> iter = new CustomIterator<Integer>(_values.iterator());
        while (iter.hasNext()) {
            Integer value = iter.next();
            _values.remove(value);
		}
        
        System.out.println(_values);
    }
}
