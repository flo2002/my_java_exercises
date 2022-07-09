import java.time.LocalDateTime;

public class DBConnection {
    private LocalDateTime _lastUsed;

    DBConnection() {
        _lastUsed = LocalDateTime.now();
        connect();
    }

    public void connect() {
        _lastUsed = LocalDateTime.now();
        System.out.println("creating DB connection");
    }

    public void close(DBFactory dbf) {
        dbf.removeDBConnection(this);
        System.out.println("\tclosing DB connection");
    }

    public LocalDateTime getLastUsed() {
        return _lastUsed;
    }
}
