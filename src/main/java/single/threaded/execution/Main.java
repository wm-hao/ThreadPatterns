package single.threaded.execution;

/**
 * @author John
 * @date 2018/8/25
 */
public class Main {
    /**
     * 1.Gate.pass()非synchronized
     * 调试结果 表明调试信息不可靠
     * ****** BROKEN ******No.7093: Bobby, Brazil
     * ****** BROKEN ******No.7382: Alice, Alaska
     * ****** BROKEN ******No.7661: Alice, Alaska
     * ****** BROKEN ******No.7940: Bobby, Brazil
     * ****** BROKEN ******No.8239: Alice, Brazil
     * ****** BROKEN ******No.8239: Alice, Brazil
     * ****** BROKEN ******No.8588: Bobby, Brazil
     * ****** BROKEN ******No.8791: Alice, Alaska
     * ****** BROKEN ******No.9121: Alice, Alaska
     * ****** BROKEN ******No.9461: Bobby, Brazil
     *
     * 2.Gate.pass() synchronized
     * 调试结果
     * Alice BEGIN
     * Bobby BEGIN
     * Chris BEGIN
     */
    public static void main(String[] args) {
        System.out.println("Testing Gate, hit CTRL+C to exit.");
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}
