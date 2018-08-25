package read.write.lock;

/**
 * @author John
 * @date 2018/8/25
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data(10);
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new WriterThread(data, "ABCDEFGHIGKL").start();
        new WriterThread(data, "abcdefghijkl").start();
    }
}
