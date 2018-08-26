package thread.per.message;

/**
 * @author John
 * @date 2018/8/26
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host();
        host.request(20, 'a');
        host.request(10, 'b');
        host.request(30, 'c');
        host.request(5, 'd');
        System.out.println("main END");
    }
}
