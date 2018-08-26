package worker.thread;

/**
 * @author John
 * @date 2018/8/26
 */
public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWork();
        ClientThread[] clientThreads = new ClientThread[10];
        for (int i = 0; i < 10; i++) {
            clientThreads[i] = new ClientThread("Client No." + (i + 1), channel);
            clientThreads[i].start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            clientThreads[i].stopThread();
        }
        channel.stopWork();

    }
}
