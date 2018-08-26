package worker.thread;

import java.util.Random;

/**
 * @author John
 * @date 2018/8/26
 */
public class ClientThread extends Thread {
    private final Channel channel;
    private static final Random RANDOM = new Random();
    private volatile boolean terminated = false;

    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; !terminated; i++) {
                Request request = new Request(getName(), i);
                channel.putRequest(request);
                Thread.sleep(RANDOM.nextInt(1000));
            }
        } catch (InterruptedException e) {
            terminated = true;
        }
    }

    public void stopThread() {
        terminated = true;
        interrupt();
    }
}
