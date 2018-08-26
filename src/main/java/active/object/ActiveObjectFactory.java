package active.object;

/**
 * @author John
 * @date 2018/8/26
 */
public class ActiveObjectFactory {
    public static ActiveObject createActiveObject() {
        Servant servant = new Servant();
        ActivationQueue queue = new ActivationQueue();
        SchedulerThread schedulerThread = new SchedulerThread(queue);
        Proxy proxy = new Proxy(schedulerThread, servant);
        schedulerThread.start();
        return proxy;
    }
}
