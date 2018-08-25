package single.threaded.execution.semaphore;

import java.util.Random;

/**
 * @author John
 * @date 2018/8/25
 */
public class UserThread extends Thread {
    private final static Random RANDOM = new Random(26535);
    private final BoundedResources resources;

    public UserThread(BoundedResources boundedResources) {
        this.resources = boundedResources;
    }

    @Override
    public void run() {
        try {
            while (true) {
                resources.use();
                Thread.sleep(RANDOM.nextInt(3000));
            }
        } catch (InterruptedException e) {

        }
    }
}
