public class StudentIn {
    private String _name;
    private String _codeword;

    public StudentIn(String name) {
        _name = name;
        _codeword = Codewords.generate(8);
    }
    
    public String toString() {
        return _codeword + ": " + _name;
    }
}
