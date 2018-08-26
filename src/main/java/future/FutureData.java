package future;

/**
 * @author John
 * @date 2018/8/26
 */
public class FutureData implements Data {
    private RealData realData = null;
    private boolean ready = false;

    public synchronized void setRealData(RealData data) {
        if (ready) {
            return;
        }
        this.ready = true;
        this.realData = data;
        notifyAll();
    }

    @Override
    public synchronized String getContent() {
        while (!ready) {
            try{
                wait();
            }catch (InterruptedException e) {

            }
        }
        return realData.getContent();
    }

}
