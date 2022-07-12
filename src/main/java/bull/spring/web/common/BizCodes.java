package bull.spring.web.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/7/16
 */
public enum BizCodes {
    SUCCESS(0, "成功"),
    ERROR(1, "失败"),
    ;

    private static class Inner {
        private static final Map<Integer, BizCodes> CODES = new HashMap<>();
    }

    private final int code;
    private final String name;

    BizCodes(int code, String name) {
        this.code = code;
        this.name = name;
        BizCodes exist = Inner.CODES.putIfAbsent(code, this);
        if (exist != null) {
            throw new IllegalStateException("BizCodes duplicated:" + code);
        }
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BizCodes{" +
                "code=" + code +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }
}
