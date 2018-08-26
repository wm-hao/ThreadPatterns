package worker.thread;

/**
 * @author John
 * @date 2018/8/26
 */
public class Channel {
    private final static int MAX_REQUEST = 100;
    private final Request[] requestQueue;
    private int tail;
    private int head;
    private int count;
    private final WorkerThread[] threadPool;

    public Channel(int threads) {
        requestQueue = new Request[MAX_REQUEST];
        head = 0;
        tail = 0;
        count = 0;
        threadPool = new WorkerThread[threads];
        for (int i = 0; i < threads; i++) {
            threadPool[i] = new WorkerThread("Worker-" + i, this);
        }
    }

    public void startWork() {
        for (WorkerThread workerThread : threadPool) {
            workerThread.start();
        }
    }

    public synchronized void putRequest(Request request) throws InterruptedException {
        while (count >= requestQueue.length) {
            System.out.println("RequestQueue is full!!!");
            wait();
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest() throws InterruptedException {
        while (count <= 0) {
            System.out.println("RequestQueue is empty!!!");
            wait();
        }
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return request;
    }

    public void stopWork() {
        for(WorkerThread workerThread : threadPool) {
            workerThread.stopThread();
        }
    }
}
