package active.object;

/**
 * @author John
 * @date 2018/8/26
 */
public class Proxy implements ActiveObject{
    private final SchedulerThread scheduler;
    private final Servant servant;

    public Proxy(SchedulerThread scheduler, Servant servant) {
        this.scheduler = scheduler;
        this.servant = servant;
    }

    @Override
    public Result<String> makeString(int count, char fillChar) {
        FutureResult<String> future = new FutureResult<String>();
        scheduler.invoke(new MakeStringRequest(servant, future, count, fillChar));
        return future;
    }

    @Override
    public void displayString(String string) {
        scheduler.invoke(new DisplayStringRequest(servant, string));
    }
}
