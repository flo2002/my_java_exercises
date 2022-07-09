import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        Student flo = new Student("Florian", "Schiemer", "Schwarzen 993", "Alberschwende", "Austria");
        Teacher john = new Teacher("Jonas", "Klose", "Marktplatz 3", "Dornbirn", "Austria");
        Extern jane = new Extern("Jane", "Doe", "Musterstrasse 1", "Musterstadt", "Austria");
        
        Book book = new Book("56185613241", "asdf", "flo", "fhv", LocalDate.of(2021, 11, 12), "English");
        Book book2 = new Book("56185613241", "asdf", "flo", "fhv",LocalDate.of(2021, 11, 12), "English");
        System.out.println(book2);
        VideoGame vidgame = new VideoGame("hhhh", LocalDate.of(2020, 9, 23));

        // time in days, price in cents
        System.out.println("flo: " + flo.getClass().getSimpleName());
        System.out.println("\tLending Period Book: " + flo.getLendingPeriod(book));
        System.out.println("\tLending Period VideoGame: " + flo.getLendingPeriod(vidgame));
        System.out.println("\tLending price: " + flo.getLendingPrice());
        System.out.println("\tMax Extensions: " + flo.getMaxExtensions());

        System.out.println("\njohn: " + john.getClass().getSimpleName());
        System.out.println("\tLending Period Book: " + john.getLendingPeriod(book));
        System.out.println("\tLending Period VideoGame: " + john.getLendingPeriod(vidgame));
        System.out.println("\tLending price: " + john.getLendingPrice());
        System.out.println("\tMax Extensions: " + john.getMaxExtensions());

        System.out.println("\njane: " + jane.getClass().getSimpleName());
        System.out.println("\tLending Period Book: " + jane.getLendingPeriod(book));
        System.out.println("\tLending Period VideoGame: " + jane.getLendingPeriod(vidgame));
        System.out.println("\tLending price: " + jane.getLendingPrice());
        System.out.println("\tMax Extensions: " + jane.getMaxExtensions());

        flo.rent(vidgame);
        john.rent(book);
        System.out.println("\nAll RentObjects: \n" + RentObject.getAll());
        System.out.println("All RentedObjects: \n" + Rent.getAll());
        System.out.println("Single RentedObjects: \n\t" + RentObject.get(1) + "\n\t" + RentObject.get(2) + "\n\t" + RentObject.get(3) + "\n\t" + RentObject.get(4));

        System.out.println();
        flo.rent(book);
        john.rent(vidgame);

        flo.reserve(book);
        john.reserve(vidgame);
        System.out.println("\n\nAll ReservedObjects: \n" + Reservation.getAll());

        flo.rent(book2);
        john.reserve(book2);
        jane.rent(book2);
 
        flo.extend(vidgame);
        john.extend(book);
        System.out.println("\n\nAll RentedObjects: \n" + Rent.getAll());

        System.out.println("Rents of a single user: " );
        System.out.println(flo.getAllRents());
        System.out.println(john.getAllRents());
        System.out.println("Reservations of a single user: " );
        System.out.println(flo.getAllReservations());
        System.out.println(john.getAllReservations());
    }
}
