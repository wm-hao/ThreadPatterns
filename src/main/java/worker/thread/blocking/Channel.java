package worker.thread.blocking;

import worker.thread.Request;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author John
 * @date 2018/8/26
 */
public class Channel extends ArrayBlockingQueue<Request> {
    private final WorkerThread[] threadPool;

    public Channel(int capacity, int threads) {
        super(capacity);
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

    public void putRequest(Request request) throws InterruptedException {
        System.out.println("Channel Put Request");
        super.put(request);
    }

    public Request takeRequest() throws InterruptedException {
        System.out.println("Channel Take Request");
        return super.take();
    }


}
