package single.threaded.execution.semaphore;

/**
 * @author John
 * @date 2018/8/25
 */
public class Main {
    public static void main(String[] args) {
        BoundedResources boundedResources = new BoundedResources(3);
        for (int i = 0; i < 10; i++) {
            new UserThread(boundedResources).start();
        }
    }
}
