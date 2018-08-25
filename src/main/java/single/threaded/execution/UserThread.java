package single.threaded.execution;

/**
 * @author John
 * @date 2018/8/25
 */
public class UserThread extends Thread {
    private final String name;
    private final String address;
    private final Gate gate;

    public UserThread(Gate gate, String name, String address) {
        this.address = address;
        this.gate = gate;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " BEGIN");
        while (true) {
            gate.pass(name, address);
        }
    }
}
