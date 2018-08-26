package two.phase.termination.cyclicbarrier;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author John
 * @date 2018/8/26
 */
public class Main {
    private final static int THREADS = 3;

    public static void main(String[] args) {
        System.out.println("BEGIN");

        ExecutorService service = Executors.newFixedThreadPool(5);


        Runnable barrierAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("Barrier Action!");
            }
        };

        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREADS, barrierAction);
        CountDownLatch countDownLatch = new CountDownLatch(THREADS);

        try {
            for (int i = 0; i < THREADS; i++) {
                service.execute(new MyTask(cyclicBarrier, countDownLatch, i));
            }
            System.out.println("AWAIT");
            countDownLatch.await();
        } catch (InterruptedException e) {

        } finally {
            service.shutdown();
            System.out.println("END");
        }
    }
}
