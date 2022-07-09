
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;


public class DBFactory {
    private static final Integer _maxConnections = 3;
    private static Integer _connectionCounter = 0;
    private ArrayList<DBConnection> _connections;
    private final Object _lock = new Object();
    
    DBFactory () {
        _connections = new ArrayList<DBConnection>();
        
        Thread t1 = new Thread(new CheckIfConnectionUnused());
        t1.start();
    }

    public DBConnection createDBConnection() throws Exception {
        if (_connectionCounter < _maxConnections) {
            synchronized (_lock) {
                _connections.add(new DBConnection());
            }
            _connectionCounter++;
        } else {
            throw new Exception("Max connections reached");
        }

        return _connections.get(_connectionCounter - 1);
    }

    public void removeDBConnection(DBConnection dbc) {
        synchronized (_lock) {
            _connections.remove(dbc);
        }
        _connectionCounter--;
    }

    public class CheckIfConnectionUnused implements Runnable {
        public void run() {
            while (true) {
                System.out.println("DBConnections: " + _connections.size());

                synchronized (_lock) {
                    Iterator<DBConnection> it = _connections.iterator();
                    while (it.hasNext()) {
                        DBConnection dbc = it.next();
                        if (dbc.getLastUsed().plusSeconds(3).isBefore(LocalDateTime.now())) {
                            it.remove();
                            _connectionCounter--;
                        }
                    }
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("got interrupted!");
                }
            }
        }
    }
}
