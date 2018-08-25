package guarded.suspension;

/**
 * @author John
 * @date 2018/8/25
 */
public class Request {
    private String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
