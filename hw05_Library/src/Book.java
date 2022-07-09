import java.time.LocalDate;

public class Book extends RentObject {
    private String _isbn;
    private String _title;
    private String _author;
    private String _publisher;
    private LocalDate _publishDate;
    private String _language;

    public Book(String isbn, String title, String author, String publisher, LocalDate publishDate, String language) {
        super();
        _isbn = isbn;
        _title = title;
        _author = author;
        _publisher = publisher;
        _publishDate = publishDate;
        _language = language;
    }

    @Override
    public Integer getLendingPeriod(User u) {
        switch (u.getClass().getSimpleName()) {
            case "Student":
                return 3*7;
            case "Teacher":
                return 6*7;
            case "Extern":
                return 3*7;
            default:
                return 0;
        }
    }

    public String toString () {
        return "Book: " + _title + " (" + _isbn + ")" + " by " + _author + " published in " + _publisher + " on " + _publishDate + " in " + _language;
    }
}
