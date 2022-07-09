package at.fhv.s2.oo.hue2;

import java.util.Arrays;

public class Stack {
    private Integer[] _values;
    private int _counter;

    Stack(int size) {
        _values = new Integer[size];
    }

    Stack() {
        this(16);
    }

    public Boolean isEmpty() {
        if (_counter == 0) {
            return true;
        }
        return false;
    }

    public Boolean isFull() {
        if (_values.length == _counter) {
            return true;
        }
        return false;
    }
    
    public void push(Integer value) {
        if (!isFull()) {
            _values[_counter++] = value;
        }
    }

    public Integer pop() {
        _counter--;
        Integer tmp = _values[_counter];
        _values[_counter] = null;
        return tmp;
    }

    public String toString() {
        return Arrays.toString(_values);
    }
}
