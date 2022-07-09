import java.util.ArrayList;

public class Office extends Thread{
    private Object _lockQueue;
    private Object _lockWorker;
    private ArrayList<Request> _queue;

    public Office () {
        _lockQueue = new Object();
        _lockWorker = new Object();
        _queue = new ArrayList<Request>();
    }

    public void workOn(Request request) throws InterruptedException {
        synchronized (_lockQueue) {
            _queue.add(request);
            _lockQueue.notifyAll();
        }
    }

    public void workerJob(Request req) {
        new Thread() {
            public void run() {
                synchronized (_lockWorker) {
                    try {
                        System.out.println("finished request " + req);
                        Thread.sleep(req.getLength() * 1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void run() {
        while (true) {
            synchronized (_lockQueue) {
                try {
                    if (!_queue.isEmpty()) {
                        workerJob(_queue.get(0));
                        _queue.remove(0);
                    }
                    _lockQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
