package thread.per.message;

/**
 * @author John
 * @date 2018/8/26
 */
public class Helper {
    public void handle(int count, char c) {
        System.out.println("    handle (" + count + ", " + c + ") BEGIN");
        for (int i = 0; i < count; i++) {
            slowly();
            System.out.print(c);
        }
        System.out.println("    handle (" + count + ", " + c + ") END");
    }

    private void slowly() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
