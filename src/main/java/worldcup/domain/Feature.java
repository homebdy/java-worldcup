package worldcup.domain;

import worldcup.constant.ExceptionMessage;
import worldcup.constant.OutputMessage;

import java.util.Arrays;

public enum Feature {

    FIRST(1, "경기 결과 출력"),
    SECOND(2, "조별 결과 출력"),
    THIRD(3, "국가 경기 및 순위 결과 출력"),
    FOURTH(4, "16강 진출 국가 출력"),
    FIFTH(5, "종료");

    private final int number;
    private final String message;

    Feature(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public static Feature getFeature(int number) {
        return Arrays.stream(Feature.values())
                .filter(f -> f.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_FEATURE.getMessage()));
    }

    public static String getScreen() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(Feature.values())
                .forEach(f ->
                        sb.append(f.number).append(OutputMessage.PERIOD.getMessage())
                                .append(f.message)
                                .append(OutputMessage.NEW_LINE.getMessage())
                );
        return sb.toString();
    }

    public boolean isFirst() {
        return this == FIRST;
    }

    public boolean isSecond() {
        return this == SECOND;
    }

    public boolean isThird() {
        return this == THIRD;
    }

    public boolean isFourth() {
        return this == FOURTH;
    }

    public boolean isFifth() {
        return this == FIFTH;
    }
}
