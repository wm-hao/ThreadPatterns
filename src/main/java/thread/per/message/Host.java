package thread.per.message;

/**
 * @author John
 * @date 2018/8/26
 */
public class Host {
    private final Helper helper = new Helper();

    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        new Thread(new Runnable() {
            @Override
            public void run() {
                helper.handle(count, c);
            }
        }).start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
