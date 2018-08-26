package two.phase.termination.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author John
 * @date 2018/8/26
 */
public class Main {
    private static final int TASKS = 10;

    public static void main(String[] args) {
        System.out.println("BEGIN");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CountDownLatch downLatch = new CountDownLatch(TASKS);
        try {
            for (int i = 0; i < TASKS; i++) {
                executorService.execute(new MyTask(downLatch, i));
            }
            System.out.println("AWAIT");
            downLatch.await();
        } catch (InterruptedException e) {

        } finally {
            executorService.shutdown();
            System.out.println("END");
        }
    }
}
