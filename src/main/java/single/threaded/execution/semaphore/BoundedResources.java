package single.threaded.execution.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author John
 * @date 2018/8/25
 */
public class BoundedResources {
    private final Semaphore semaphore;
    private final int permits;
    private final static Random RANDOM = new Random(314159);

    public BoundedResources(int permits) {
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    public void use() throws InterruptedException {
        semaphore.acquire();
        try {
            doUse();
        } finally {
            semaphore.release();
        }
    }

    protected void doUse() throws InterruptedException {
        Log.println("BEGIN: used" + (permits - semaphore.availablePermits()));
        Thread.sleep(RANDOM.nextInt(500));
        Log.println("END: used" + (permits - semaphore.availablePermits()));
    }
}
