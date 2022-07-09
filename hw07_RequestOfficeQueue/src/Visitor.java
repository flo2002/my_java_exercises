public class Visitor extends Thread {
    private Office _office;
    private String _name;
    private String _lunchtime_activity;
    private Object _lock;

    public Visitor(Office office, String name, String lunchtime_activity) {
        _office = office;
        _name = name;
        _lunchtime_activity = lunchtime_activity;
        _lock = new Object();
    }


    public void run() {
        try {
            synchronized (_lock) {
                for (Integer i = 0; i < 3; i++) {
                    int len = (int) (Math.random() * 5) + 1;
                    Request request = new Request("A" + i.toString() , len);

                    try {
                        System.out.println("request " + this + " " + request);
                        _office.workOn(request);
                    } catch (Exception e) {
                        i--;
                        System.out.println(e);
                    }

                    Thread.sleep(1000 * len / 2);
                }

                System.out.println(_name + " " + _lunchtime_activity);
                // start another thread to do lunchtime activity
                _lock.wait();
                // do something
                join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLunchtimeActivity () {
        return _lunchtime_activity;
    }

    @Override
    public String toString() {
        return _name;
    }
}
