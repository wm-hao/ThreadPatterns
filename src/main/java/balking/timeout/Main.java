package balking.timeout;

import java.util.concurrent.TimeoutException;

/**
 * @author John
 * @date 2018/8/25
 */
public class Main {
    public static void main(String[] args) {
        Host host = new Host(5000);
        System.out.println("execute BEGIN");
        try {
            host.execute();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
