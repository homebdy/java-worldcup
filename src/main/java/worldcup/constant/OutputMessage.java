package worldcup.constant;

public enum OutputMessage {

    START_SERVICE("카타르 월드컵 조별리그 결과"),
    PERIOD(". "),
    NEW_LINE("\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    }