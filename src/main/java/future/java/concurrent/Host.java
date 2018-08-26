package future.java.concurrent;

import java.util.concurrent.Callable;

/**
 * @author John
 * @date 2018/8/26
 */
public class Host {
    public FutureData request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        FutureData futureData = new FutureData(new Callable<RealData>() {
            @Override
            public RealData call() throws Exception {
                return new RealData(count, c);
            }
        });
        new Thread(futureData).start();
        System.out.println("    request(" + count + ", " + c + ") END");
        return futureData;
    }
}
