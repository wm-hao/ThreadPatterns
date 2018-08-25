package single.threaded.execution.semaphore;

/**
 * @author John
 * @date 2018/8/25
 */
public class Log {

    public static void println(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}
