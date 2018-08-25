package immutable;

/**
 * @author John
 * @date 2018/8/25
 */
public class PersonPrintThread extends Thread {
    private Person person;
    public PersonPrintThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " prints " + person);
        }
    }
}
