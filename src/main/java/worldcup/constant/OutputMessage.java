package worldcup.constant;

public enum OutputMessage {

    START_SERVICE("카타르 월드컵 조별리그 결과"),
    PERIOD(". "),
    NEW_LINE("\n"),
    SELECT_FEATURE("출력할 내용을 입력하세요. (1 ~ 5)"),
    GROUP("조"),
    END_LINE("============================================================"),
    READ_GROUP("출력할 조를 입력하세요 (A ~ H)"),
    COMMA(", "),
    WIN("승"),
    DRAW("무"),
    LOSE("패"),
    SCORE("승점"),
    DIFFERENCE("득실차"),
    GOAL("득점"),
    COLON(" : "),
    RANKING("위 "),
    READ_NATION("출력할 국가를 입력하세요 (월드컵 출전 국가)"),
    GAME_END("프로그램을 종료합니다."),
    ADVANCE("로 16강 진출에 성공했습니다."),
    NOT_ADVANCE("로 16강 진출에 실패했습니다."),
    BLANK(" ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    }