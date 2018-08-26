package thread.specific.storage;

/**
 * @author John
 * @date 2018/8/26
 */
public class Main {
    public static void main(String[] args) {
        new ClientThread("Alice").start();
        new ClientThread("Bobby").start();
        new ClientThread("Chris").start();
    }
}
