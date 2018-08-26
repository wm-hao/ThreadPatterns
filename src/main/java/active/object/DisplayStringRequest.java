package active.object;

/**
 * @author John
 * @date 2018/8/26
 */
public class DisplayStringRequest extends  MethodRequest<Object>{
    private final String string;
    public DisplayStringRequest(Servant servant, String string) {
        super(servant, null);
        this.string = string;
    }
    @Override
    public void execute() {
        servant.displayString(string);
    }
}
