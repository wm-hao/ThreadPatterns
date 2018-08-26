package thread.specific.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author John
 * @date 2018/8/26
 */
public class TSLog {
    private PrintWriter writer = null;

    public TSLog(String fileName) {
        try {
            writer = new PrintWriter(new FileWriter(System.getProperty("user.dir") + File.pathSeparator + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String s) {
        writer.println(s);
    }

    public void close() {
        writer.close();
    }
}
