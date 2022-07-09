import java.time.LocalDate;

public class VideoGame extends RentObject {
    private String _title;
    private LocalDate _releaseDate;

    public VideoGame(String title, LocalDate releaseDate) {
        super();
        _title = title;
        _releaseDate = releaseDate;
    }

    @Override
    public Integer getLendingPeriod(User u) {
        switch (u.getClass().getSimpleName()) {
            case "Student":
                return 2*7;
            case "Teacher":
                return 2*7;
            case "Extern":
                return 2*7;
            default:
                return 0;
        }
    }

    public String toString () {
        return "VideoGame: " + _title + " released in " + _releaseDate;
    }
}
