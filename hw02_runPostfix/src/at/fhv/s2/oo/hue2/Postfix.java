package at.fhv.s2.oo.hue2;

import java.lang.Character;

public class Postfix {
    private String _expression;
    private Stack _stack;
    private Integer _result;

    public Postfix(String expression, int maxSequentialNumbers) {
        _expression = expression;
        _stack = new Stack(maxSequentialNumbers);
    }

    public Postfix() {
        this("", 0);
    }

    private void calc() {
        Integer tmp_res = 0;

        for (int i=0; _expression.charAt(i) != ';'; i++) {
            Character c = _expression.charAt(i);
            Integer e = 0;

            while ((Character.getNumericValue(c) >= 0) && (Character.getNumericValue(c) <= 9)) {
                if (tmp_res < 0) {
                    tmp_res = -1 * Character.getNumericValue(c);
                    System.out.println(tmp_res);
                } else {
                    tmp_res = (tmp_res * 10) + Character.getNumericValue(c);
                }
                e++;
                c = _expression.charAt(i+e);
            }
            i += e;

            if (tmp_res != 0) {
                _stack.push(tmp_res);
                tmp_res = 0;
            }

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (_expression.charAt(i+1) == ' ') {
                    tmp_res = _stack.pop();
                    switch (c) {
                        case '+':
                            while (!_stack.isEmpty()) {
                                tmp_res += _stack.pop();
                            }
                            break;
                        case '-':
                            while (!_stack.isEmpty()) {
                                tmp_res -= _stack.pop();
                            }
                            break;
                        case '*':
                            while (!_stack.isEmpty()) {
                                tmp_res *= _stack.pop();
                            }
                            break;
                        case '/':
                            while (!_stack.isEmpty()) {
                                tmp_res /= _stack.pop();
                            }
                            break;
                    }
                    _stack.push(tmp_res);
                }
            }

            tmp_res = 0;
            c = _expression.charAt(i+1);
            if (_expression.charAt(i) == '-' && ((Character.getNumericValue(c) >= 0) && (Character.getNumericValue(c) <= 9))) {
                tmp_res = -1;
            }
        }

        _result = _stack.pop();
    }

    public String getResult() {
        if (_result == null || _result == 0) {
            calc();
        }
        return _result.toString();
    }

    public void setPostfix(String expression, int maxSequentialNumbers) {
        _expression = expression;
        _stack = new Stack(maxSequentialNumbers);
        _result = 0;
    }

    public String toString() {
        if (_expression == "") {
            return "No Postfix given.";
        }
        return _expression;
    }
}
