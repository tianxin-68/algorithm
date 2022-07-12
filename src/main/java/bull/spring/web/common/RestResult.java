package bull.spring.web.common;


/**
 * @date 2021/7/16
 */
public class RestResult<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public RestResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResult(BizCodes code, T data) {
        this(code.getCode(), code.getName(), data);
    }

    public RestResult(BizCodes code, String msg, T data) {
        this(code.getCode(), msg, data);
    }

    public static <T> RestResult<T> ok() {
        return new RestResult(BizCodes.SUCCESS, null);
    }

    public static <T> RestResult<T> ok(T data) {
        return new RestResult(BizCodes.SUCCESS, data);
    }

    public static <T> RestResult<T> error(String message) {
        return new RestResult(BizCodes.ERROR, message, null);
    }

    public static <T> RestResult<T> error(int code, String message) {
        return new RestResult(code, message, null);
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
