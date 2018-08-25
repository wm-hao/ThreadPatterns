package balking;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author John
 * @date 2018/8/25
 */
public class Data {
    private final String fileName;
    private String content;
    private boolean changed;

    public Data(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    public synchronized void save() throws IOException {
        if (!changed) {
            System.out.println("内容没有变化，本次不保存");
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, new content: " + content);
        Writer writer = new FileWriter(System.getProperty("user.dir") + File.separator + fileName);
        writer.write(content);
        writer.close();
    }
}
