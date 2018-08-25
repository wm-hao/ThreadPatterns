package guarded.suspension;

/**
 * @author John
 * @date 2018/8/25
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Client1", 3141592L).start();
        new ClientThread(requestQueue, "Client2", 3141592L).start();
        new ServerThread(requestQueue, "Server1", 6535897L).start();
        new ServerThread(requestQueue, "Server2", 6535897L).start();
        new ServerThread(requestQueue, "Server3", 6535897L).start();
    }
}
