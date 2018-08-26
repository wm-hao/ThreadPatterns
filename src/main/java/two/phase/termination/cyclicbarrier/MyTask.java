package two.phase.termination.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author John
 * @date 2018/8/26
 */
public class MyTask implements Runnable {
    private final static int PHASE = 5;
    private final Random random = new Random();
    private final CountDownLatch downLatch;
    private final CyclicBarrier cyclicBarrier;
    private final int id;

    public MyTask(CyclicBarrier barrier, CountDownLatch latch, int id) {
        this.cyclicBarrier = barrier;
        this.downLatch = latch;
        this.id = id;
    }


    @Override
    public void run() {
        try {
            for (int i = 0; i < PHASE; i++) {
                doPhase(i);
                cyclicBarrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } finally {
            downLatch.countDown();
        }
    }

    private void doPhase(int phase) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ":MyTask:Begin:Id = " + id + ",phase = " + phase);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {

        } finally {
            System.out.println(name + ":MyTask:End:Id = " + id + ",phase = " + phase);
        }
    }
}
