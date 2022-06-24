package bull.common.utils;

import java.util.HashMap;
import java.util.Optional;


public enum YesNoEnum {

    YES(0, "是"),
    NO(1, "否"),
    ;
    public final Integer code;
    public final String description;

    private static class Meta {
        private final static HashMap<Integer, YesNoEnum> codeMap;
        private final static HashMap<String, YesNoEnum> descriptionMap;

        static {
            final YesNoEnum[] values = YesNoEnum.values();
            codeMap = new HashMap<Integer, YesNoEnum>(values.length);
            descriptionMap = new HashMap<>(values.length);
            for (YesNoEnum value : values) {
                codeMap.put(value.code, value);
                descriptionMap.put(value.description, value);
            }
        }
    }

    YesNoEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    /**
     * equal
     *
     * @param code
     * @return
     */
    public boolean eq(Integer code) {
        if (code == null) {
            return false;
        }
        return code.equals(this.getCode());
    }

    /**
     * equal
     *
     * @param status
     * @return
     */
    public boolean is(YesNoEnum status) {
        return this == status;
    }

    /**
     * not equal
     *
     * @param code
     * @return
     */
    public boolean ne(Integer code) {
        return !eq(code);
    }

    public static Optional<YesNoEnum> of(Integer code) {
        if (code == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(Meta.codeMap.get(code));
    }

    public static String description(Integer code, String val) {
        return of(code).map(YesNoEnum::getDescription).orElse(val);
    }

    public static Optional<YesNoEnum> ofDescription(String description) {
        if (description == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(Meta.descriptionMap.get(description));
    }

    public static Integer code(String description, Integer val) {
        return ofDescription(description).map(YesNoEnum::getCode).orElse(val);
    }

    @Override
    public String toString() {
        return YesNoEnum.class.getSimpleName() + "{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
