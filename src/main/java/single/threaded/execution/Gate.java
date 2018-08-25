package single.threaded.execution;

/**
 * @author John
 * @date 2018/8/25
 */
public class Gate {
    private int counter = 0;
    private String name = "NoBody";
    private String address = "NoAddress";

    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    private void check() {
        if(name.charAt(0) != address.charAt(0)) {
            System.out.println("****** BROKEN ******" + toString());
        }
    }

    @Override
    public synchronized String toString() {
        return "No." + this.counter + ": " + name + ", " + address;
    }
}
