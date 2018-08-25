package read.write.lock;

/**
 * @author John
 * @date 2018/8/25
 */
public class Data {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public Data(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public synchronized char[] read() throws InterruptedException {
        lock.readLock();
        try{
            return doRead();
        } finally {
            lock.readUnlock();
        }
    }

    public synchronized void write(char c) throws InterruptedException {
        lock.writeLock();
        try{
            doWrite(c);
        }finally {
            lock.writeUnlock();
        }
    }

    private char[] doRead() {
        char[] newbuf = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newbuf[i] = buffer[i];
        }
        slowly();
        return newbuf;
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly();
        }
    }

    private void slowly() {
        try{
            Thread.sleep(50);
        }catch (InterruptedException e){

        }
    }
}
