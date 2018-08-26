package worker.thread.blocking;

import worker.thread.Request;

/**
 * @author John
 * @date 2018/8/26
 */
public class WorkerThread extends Thread {
    private final Channel channel;

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            Request request = null;
            try {
                request = channel.takeRequest();
                request.execute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
