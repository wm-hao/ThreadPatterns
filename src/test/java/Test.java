/**
 * @author John
 * @date 2018/8/26
 */
public class Test {
    @org.junit.Test
    public void test01() {
        String[] strings = new String[100];
        for (int i = 0; i < 50; i++) {
            strings[i] = "str" + i;
        }
        System.out.println("strings's length is " + strings.length);
    }
}
