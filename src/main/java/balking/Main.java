package balking;

/**
 * @author John
 * @date 2018/8/25
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "empty");
        new ChangerThread("ChangerThread", data).start();
        new AutoSaveThread("AutoSaveThread", data).start();
    }
}
