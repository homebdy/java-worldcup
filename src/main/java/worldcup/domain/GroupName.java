package worldcup.domain;

import worldcup.constant.ExceptionMessage;
import worldcup.constant.OutputMessage;

import java.util.Arrays;

public enum GroupName {

    A_GROUP("A"),
    B_GROUP("B"),
    C_GROUP("C"),
    D_GROUP("D"),
    E_GROUP("E"),
    F_GROUP("F"),
    G_GROUP("G"),
    H_GROUP("H");

    private final String name;

    GroupName(String name) {
        this.name = name;
    }

    public static GroupName getGroup(String input) {
        return Arrays.stream(GroupName.values())
                .filter(value -> value.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_GROUP.getMessage()));
    }

    public String getName() {
        return name + OutputMessage.GROUP.getMessage();
    }

    public boolean isLast() {
        int lastIndex = (int) Arrays.stream(GroupName.values())
                .count();
        return Arrays.stream(GroupName.values()).toList()
                .get(lastIndex - 1) == this;
    }
}
