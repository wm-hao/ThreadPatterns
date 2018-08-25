package producer.consumer;

/**
 * @author John
 * @date 2018/8/25
 */
public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);
        for (int i = 0; i < 3; i++) {
            new MakerThread("Maker No." + (i + 1), table).start();
        }
        for (int i = 0; i < 3; i++) {
            new EaterThread("Eater No." + (i + 1), table).start();
        }
    }
}
