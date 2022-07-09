import java.util.ArrayList;
import java.util.List;

public abstract class RentObject {
    private static Integer _IDCounter = 0;
    private static List<RentObject> _rentObjects = new ArrayList<RentObject>();
    private Integer _id;

    RentObject() {
        _id = ++_IDCounter;
        _rentObjects.add(this);
    }

    public abstract Integer getLendingPeriod(User u);
    public abstract String toString();

    public Integer getID() {
        return _id;
    }

    public static String getAll() {
        StringBuilder sb = new StringBuilder();
        for (RentObject ro : _rentObjects) {
            sb.append("\t" + ro._id  + " " + ro.toString() + "\n");
        }
        return sb.toString();
    }

    public static String get(Integer id) {
        for (RentObject ro : _rentObjects) {
            if (ro._id == id) {
                return ro.toString();
            }
        }
        return "No RentObject with id " + id + " found!";
    }

    public Boolean isRented() {
        return Rent.isRented(this);
    }

    public Boolean isReserved() {
        return Reservation.isReserved(this);
    }
}
