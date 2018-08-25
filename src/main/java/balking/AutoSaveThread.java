package balking;

import java.io.IOException;

/**
 * @author John
 * @date 2018/8/25
 */
public class AutoSaveThread extends Thread {
    private final Data data;

    public AutoSaveThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try{
            while (true) {
                data.save();
                Thread.sleep(1000);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
