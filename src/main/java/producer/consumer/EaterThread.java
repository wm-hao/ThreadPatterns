package producer.consumer;

import java.util.Random;

/**
 * @author John
 * @date 2018/8/25
 */
public class EaterThread extends Thread{
    private final Table table;
    public final Random random = new Random(123124);

    public EaterThread(String name, Table table) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        try{
            while (true) {
                String cake = table.take();
                Thread.sleep(random.nextInt(1000));
            }
        }catch (InterruptedException e) {

        }
    }
}
