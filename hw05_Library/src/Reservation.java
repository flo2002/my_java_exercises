import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private static Integer _idCounter = 0;
    private static List<Reservation> _reservations = new ArrayList<Reservation>();
    private Integer _reservationID;
    private RentObject _rentObject;
    private User _user;
    private LocalDate _reservationDate;

    Reservation(RentObject rentObject, User user) {
        _reservationID = ++_idCounter;
        _rentObject = rentObject;
        _user = user;
        _reservationDate = LocalDate.now();
        _reservations.add(this);
    }

    public static String getAll() {
        StringBuilder sb = new StringBuilder();
        for (Reservation r : _reservations) {
            sb.append("\t" + r._reservationID  + 
                " " + r._user.toString() + 
                " reserved on: " + r._reservationDate + 
                " Rent Object: " + r._rentObject.toString() + "\n");
        }
        return sb.toString();
    }

    public static String getAllReservationsByUser(User user) {
        StringBuilder sb = new StringBuilder();
        for (Reservation r : _reservations) {
            if (r._user.getID() == user.getID()) {
                sb.append("\t" + r._reservationID  + 
                    " " + r._user.toString() + 
                    " reserved on: " + r._reservationDate + 
                    " Rent Object: " + r._rentObject.toString() + "\n");
            }
        }
        return sb.toString();
    }

    public static Boolean isReserved(RentObject rentObject) {
        for (Reservation r : _reservations) {
            if (r._rentObject.getID() == rentObject.getID()) {
                return true;
            }
        }
        return false;
    }
}
