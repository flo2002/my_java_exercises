import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rent {
    private static Integer _idCounter = 0;
    private static List<Rent> _rents = new ArrayList<Rent>();
    private Integer _rentID;
    private RentObject _rentObject;
	private User _user;
	private LocalDate _rentDate;
	private LocalDate _returnDate;
    private Integer _extendCounter;

    Rent (RentObject rentObject, User user) {
        // if item not already rented / reserved by another user
        if (!rentObject.isReserved()) {
            if (!rentObject.isRented()) {
                _rentID = ++_idCounter;
                _rentObject = rentObject;
                _user = user;
                _rentDate = LocalDate.now();
                _returnDate = LocalDate.now().plusDays(rentObject.getLendingPeriod(user));
                _rents.add(this);
                _extendCounter = 0;
            } else {
                System.out.println("Item is already rented by another user!");
            }
        } else {
            System.out.println("Item is already reserved by another user!");
        }
    }

    public static String getAll() {
        StringBuilder sb = new StringBuilder();
        for (Rent r : _rents) {
            sb.append("\t" + r._rentID  + 
                " " + r._user.toString() + 
                " rented: " + r._rentDate + 
                " returnDate: " + r._returnDate + 
                " Rent Object: " + r._rentObject.toString() + "\n");
        }
        return sb.toString();
    }

    public static void extend(RentObject rentObject, User user) {
        for (Rent r : _rents) {
            if ((r._rentObject.getID() == rentObject.getID()) && (r._user.getID() == user.getID())) {
                if (r._extendCounter < user.getMaxExtensions()) {
                    r._returnDate = r._returnDate.plusDays(r._rentObject.getLendingPeriod(user));
                    r._extendCounter++;
                } else {
                    System.out.println("Extension limit reached!");
                }
            }
        }
    }

    public static String getAllRentsByUser(User user) {
        StringBuilder sb = new StringBuilder();
        for (Rent r : _rents) {
            if (r._user.getID() == user.getID()) {
                sb.append("\t" + r._rentID  + 
                    " " + r._user.toString() + 
                    " rented: " + r._rentDate + 
                    " returnDate: " + r._returnDate + 
                    " Rent Object: " + r._rentObject.toString() + "\n");
            }
        }
        return sb.toString();
    }

    public static Boolean isRented(RentObject rentObject) {
        for (Rent r : _rents) {
            if (r._rentObject.getID() == rentObject.getID()) {
                return true;
            }
        }
        return false;
    }
}
