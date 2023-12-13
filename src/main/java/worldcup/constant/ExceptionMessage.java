package worldcup.constant;

public enum ExceptionMessage {

    INVALID_REGEX("공백없이 ','로만 나누어 입력해주세요."),
    INVALID_GROUP("존재하지 않는 그룹입니다."),
    NOT_INTEGER("숫자만 입력해주세요.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
    }