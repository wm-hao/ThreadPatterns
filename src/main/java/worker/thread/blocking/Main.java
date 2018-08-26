package worker.thread.blocking;

/**
 * @author John
 * @date 2018/8/26
 */
public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(100, 5);
        channel.startWork();
        for (int i = 0; i < 10; i++) {
            new ClientThread("Client No." + (i + 1), channel).start();
        }
    }
}
