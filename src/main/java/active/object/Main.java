package active.object;

/**
 * @author John
 * @date 2018/8/26
 */
public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread("Alice", activeObject).start();
        new MakerClientThread("Bob", activeObject).start();
//        new MakerClientThread("Candy", activeObject).start();
        new DisplayClientThread("Chris", activeObject).start();
    }
}
