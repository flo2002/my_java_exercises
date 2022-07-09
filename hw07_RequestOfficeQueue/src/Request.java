public class Request {
    private String _name;
    private int _len;

    public Request(String name, int len) {
        _name = name;
        _len = len;
    }

    public String getName() {
        return _name;
    }

    public int getLength() {
        return _len;
    }

    public String toString() {
        return _name + " " + _len;
    }
}
