import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Married {
    private Person _marriedPerson;
    private Person _husband;
    private Person _witness;
    private LocalDate _marriedDate;

    public static Map<Person, ArrayList<Married>> _married = new HashMap<>();

    public Married(Person marriedPerson, Person husband, Person witness, LocalDate marriedDate) {
        _marriedPerson = marriedPerson;
        _husband = husband;
        _witness = witness;
        _marriedDate = marriedDate;
    }

    public static void addMarried(Married married) {
        ArrayList<Married> tmp = new ArrayList<Married>();
        tmp.add(married);
        _married.put(married._marriedPerson, tmp);
    }

    public static void removeMarried(Married married) {
        _married.remove(married._marriedPerson);
    }

    public static Person getHusband(Person person) {
        return _married.get(person).get(0)._husband;
    }

    public static Person getWitness(Person person) {
        return _married.get(person).get(0)._witness;
    }

    public static LocalDate getMarriedDate(Person person) {
        return _married.get(person).get(0)._marriedDate;
    }

    public static String print() {
        String result = "";
        for (ArrayList<Married> married : _married.values()) {
            result += married.get(0)._marriedPerson.getName() + " " 
            + " is married to " + married.get(0)._husband.getName() 
            + " with witness " + married.get(0)._witness.getName() 
            + " on " + married.get(0)._marriedDate.toString() + "\n";
        }
        return result;
    }
}