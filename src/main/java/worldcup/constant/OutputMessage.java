package worldcup.constant;

public enum OutputMessage {

    START_SERVICE("카타르 월드컵 조별리그 결과"),
    PERIOD(". "),
    NEW_LINE("\n"),
    SELECT_FEATURE("출력할 내용을 입력하세요. (1 ~ 5)"),
    GROUP("조"),
    END_LINE("============================================================"),
    READ_GROUP("출력할 조를 입력하세요 (A ~ H)");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    }