package two.phase.termination;

/**
 * @author John
 * @date 2018/8/26
 */
public class CountupThread extends Thread {
    private long counter = 0;

    private volatile boolean shutdownRequested = false;

    public void shutdownRequest() {
        shutdownRequested = true;
        interrupt();
    }

    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    @Override
    public void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (InterruptedException e) {

        } finally {
            doShutdown();
        }
    }

    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }

    private void doShutdown() {
        System.out.println("doShutdown counter = " + counter);
    }
}
