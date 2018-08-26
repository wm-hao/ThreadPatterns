package future.java.concurrent;

/**
 * @author John
 * @date 2018/8/26
 */
public class RealData implements Data {
    private final String content;

    @Override
    public String getContent() {
        return content;
    }

    public RealData(int count, char c) {
        System.out.println("    making RealData(" + count + ", " + c + ") BEGIN");
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        System.out.println("    making RealData(" + count + ", " + c + ") END");
        this.content = new String(buffer);
    }
}
