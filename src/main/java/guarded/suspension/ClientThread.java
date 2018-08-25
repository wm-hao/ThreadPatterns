package guarded.suspension;

import javax.naming.Name;
import java.util.Random;

/**
 * @author John
 * @date 2018/8/25
 */
public class ClientThread extends Thread {
    private final Random random;
    private final RequestQueue requestQueue;
    private final String name;

    public ClientThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.name = name;
        random = new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("NO." + i + " from " + name);
            System.out.println(Thread.currentThread().getName() + " request " + request);
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {

            }
        }
    }
}
