package immutable;

/**
 * @author John
 * @date 2018/8/25
 */
public class Main {

    public static void main(String[] args) {
        Person person = new Person("John", "hangzhou");
        new PersonPrintThread(person).start();
        new PersonPrintThread(person).start();
        new PersonPrintThread(person).start();
        new PersonPrintThread(person).start();
    }
}
