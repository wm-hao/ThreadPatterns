package two.phase.termination.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author John
 * @date 2018/8/26
 */
public class MyTask implements Runnable {
    private final CountDownLatch doneLatch;
    private final int context;
    private static final Random RANDOM = new Random(314159);

    public MyTask(CountDownLatch doneLatch, int context) {
        this.doneLatch = doneLatch;
        this.context = context;
    }


    @Override
    public void run() {
        doTask();
        doneLatch.countDown();
    }

    protected void doTask() {
        String name = Thread.currentThread().getName();
        System.out.println(name + ":MyTask:BEGIN:Context = " + context);
        try {
            Thread.sleep(RANDOM.nextInt(1000));
        } catch (InterruptedException e) {

        }finally {
            System.out.println(name + ":MyTask:END:Context = " + context);
        }
    }
}
