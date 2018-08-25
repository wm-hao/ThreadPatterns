package producer.consumer;

import java.util.Random;

/**
 * @author John
 * @date 2018/8/25
 */
public class MakerThread extends Thread{
    private final Table table;
    public final Random random = new Random(1345141);
    private static int id = 0;

    public MakerThread(String name, Table table) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        try{
            while (true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[Cake No." + nextId() + " by " + getName();
                table.put(cake);
            }
        }catch (InterruptedException e) {

        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
