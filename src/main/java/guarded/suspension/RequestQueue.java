package guarded.suspension;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author John
 * @date 2018/8/25
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();

    /**
     * GuardedMethod
     *
     * @return
     */
    public synchronized Request getRequest() {
        while (queue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return queue.remove();
    }

    /**
     * setChangingMethod
     * @param request
     */
    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}
