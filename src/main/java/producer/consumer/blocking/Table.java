package producer.consumer.blocking;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author John
 * @date 2018/8/25
 */
public class Table extends ArrayBlockingQueue<String> {
    public Table(int capacity) {
        super(capacity);
    }

    @Override
    public void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        super.put(cake);
    }

    @Override
    public String take() throws InterruptedException {
        String cake = super.take();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
