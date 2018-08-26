package future.java.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author John
 * @date 2018/8/26
 */
public class FutureData extends FutureTask<RealData> implements Data {
    private RealData realData = null;
    private boolean ready = false;

    public FutureData(Callable<RealData> callable) {
        super(callable);
    }

    @Override
    public String getContent() {
        String string = null;
        try {
            string = get().getContent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return string;
    }
}
