package active.object;

/**
 * @author John
 * @date 2018/8/26
 */
public class RealResult<T> extends Result<T>{
    private final T resultValue;
    public RealResult(T resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public T getResultValue() {
        return resultValue;
    }

}
