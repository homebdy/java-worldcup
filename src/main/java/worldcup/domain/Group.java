package worldcup.domain;

import worldcup.constant.ExceptionMessage;
import worldcup.constant.OutputMessage;

import java.util.*;

public class Group {

    private final List<Nation> elements;

    public Group() {
        this.elements = new ArrayList<>();
    }

    public void add(Nation nation) {
        if (!elements.contains(nation)) {
            elements.add(nation);
        }
    }

    public boolean contains(Nation nation) {
        return elements.contains(nation);
    }

    public void increaseWinCount(Nation nation) {
        elements.stream()
                .filter(n -> Objects.equals(n.getName(), nation.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(ExceptionMessage.INVALID_NATION.getMessage()))
                .increaseWin();
    }

    public void increaseDrawCount(Nation nation) {
        elements.stream()
                .filter(n -> Objects.equals(n.getName(), nation.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_NATION.getMessage()))
                .increaseDraw();
    }

    public void increaseLoseCount(Nation nation) {
        elements.stream()
                .filter(n -> Objects.equals(n.getName(), nation.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_NATION.getMessage()))
                .increaseLose();
    }

    public void increaseGoal(Nation nation, int ourGoal, int otherGoal) {
        elements.stream()
                .filter(n -> Objects.equals(n.getName(), nation.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_NATION.getMessage()))
                .increaseGoal(ourGoal, otherGoal);
    }

    public void calculateRanking() {
        elements.sort(Comparator.comparing(Nation::getGoal));
        elements.sort(Comparator.comparing(Nation::getDifference));
        elements.sort(Comparator.comparing(Nation::getPoint));
        Collections.reverse(elements);
    }

    public int size() {
        return elements.size();
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.size(); i++) {
            sb.append(i + 1).append(OutputMessage.RANKING.getMessage()).append(OutputMessage.BLANK.getMessage());
            Nation nation = elements.get(i);
            sb.append(nation.getResult()).append(OutputMessage.NEW_LINE.getMessage());
        }
        return sb.toString();
    }

    public boolean isContainNation(String nationName) {
        boolean flag = false;
        for (Nation nation : elements) {
            if (nation.isEqualName(nationName)) {
                flag = true;
            }
        }
        return flag;
    }

    public Nation getNationByNationName(String nationName) {
        return elements.stream()
                .filter(nation -> nation.isEqualName(nationName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_NATION.getMessage()));
    }

    public String getNextRoundNation() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            Nation nation = elements.get(i);
            stringBuilder.append(i + 1).append(OutputMessage.RANKING.getMessage())
                    .append(OutputMessage.BLANK.getMessage())
                    .append(nation.getName())
                    .append(OutputMessage.NEW_LINE.getMessage());
        }
        return stringBuilder.toString();
    }

    public boolean isAdvance(String nationName) {
        boolean flag = false;
        for (int i = 0; i < 2; i++) {
            Nation nation = elements.get(i);
            if (nation.isEqualName(nationName)) {
                flag = true;
            }
        }
        return flag;
    }

    public int getRanking(String nationName) {
        int index = 0;
        for (int i = 0; i < elements.size(); i++) {
            Nation nation = elements.get(i);
            if (nation.isEqualName(nationName)) {
                index = i + 1;
            }
        }
        return index;
    }
}
