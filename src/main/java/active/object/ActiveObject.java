package active.object;

/**
 * @author John
 * @date 2018/8/26
 */
public interface ActiveObject {
    Result<String> makeString(int count, char fillChar);
    void displayString(String string);
}
