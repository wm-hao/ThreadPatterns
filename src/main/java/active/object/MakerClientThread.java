package active.object;

/**
 * @author John
 * @date 2018/8/26
 */
public class MakerClientThread extends Thread {
    private final ActiveObject activeObject;
    private final char fillChar;

    public MakerClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.fillChar = name.charAt(0);
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; true; i++) {
                Result<String> result = activeObject.makeString(i, fillChar);
                Thread.sleep(10);
                long start = System.currentTimeMillis();
                String value = result.getResultValue();
                System.out.println(Thread.currentThread().getName() + ":value = " + value + ";consume:" + (System.currentTimeMillis() - start));
            }
        }catch (InterruptedException e) {

        }
    }
}
