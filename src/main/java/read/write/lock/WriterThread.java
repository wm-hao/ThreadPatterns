package read.write.lock;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author John
 * @date 2018/8/25
 */
public class WriterThread extends Thread {
    private final Data data;
    private static final Random RANDOM = new Random();
    private final String filter;
    private int index = 0;
    public WriterThread(Data data, String filter) {
        this.data = data;
        this.filter = filter;
    }

    @Override
    public void run() {
        try{
            while (true) {
                char c = nextChar();
                data.write(c);
                Thread.sleep(RANDOM.nextInt(3000));
            }
        }catch (InterruptedException e){

        }
    }

    private char nextChar() {
        char c = filter.charAt(index);
        index++;
        if (index >= filter.length()) {
            index = 0;
        }
        return c;
    }
}
