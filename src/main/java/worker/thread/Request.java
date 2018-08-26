package worker.thread;

import java.util.Random;

/**
 * @author John
 * @date 2018/8/26
 */
public class Request {
    private final String name;
    private final int number;
    private final static Random RANDOM = new Random();

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try {
            Thread.sleep(RANDOM.nextInt(1000));
        } catch (InterruptedException e) {
            
        }
    }

    @Override
    public String toString() {
        return "[ Request from " + name + " No." + number + "]";
    }
}
