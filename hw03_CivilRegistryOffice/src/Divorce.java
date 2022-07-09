import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Divorce {
    private Person _divorcePerson;
    private Person _husband;
    private String _reason;
    private LocalDate _divorceDate;

    public static Map<Person, ArrayList<Divorce>> _divorce = new HashMap<>();

    public Divorce(Person divorcePerson, Person husband, String reason, LocalDate divorceDate) {
        _divorcePerson = divorcePerson;
        _husband = husband;
        _reason = reason;
        _divorceDate = divorceDate;
    }

    public static void addDivorce(Divorce divorce) {
        ArrayList<Divorce> tmp = new ArrayList<Divorce>();
        tmp.add(divorce);
        _divorce.put(divorce._divorcePerson, tmp);
    }

    public static String print() {
        String result = "";
        for (ArrayList<Divorce> divorce : _divorce.values()) {
            result += divorce.get(0)._divorcePerson.getName() 
            + " and " + divorce.get(0)._husband.getName() 
            + " divorce, because " + divorce.get(0)._reason 
            + " on " + divorce.get(0)._divorceDate.toString() + "\n";
        }
        return result;
    }
}
