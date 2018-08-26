package thread.specific.storage;

/**
 * @author John
 * @date 2018/8/26
 */
public class Log {
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();

    public static void println(String s) {
        getTSLog().println(s);
    }


    public static void close() {
        getTSLog().close();
    }

    private static TSLog getTSLog() {
        TSLog tsLog = tsLogCollection.get();
        if (null == tsLog) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }
        return tsLog;
    }
}
