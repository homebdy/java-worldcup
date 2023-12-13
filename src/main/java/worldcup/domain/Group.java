package worldcup.domain;

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
                .get()
                .increaseWin();
    }

    public void increaseDrawCount(Nation nation) {
        elements.stream()
                .filter(n -> Objects.equals(n.getName(), nation.getName()))
                .findFirst()
                .get()
                .increaseDraw();
    }

    public void increaseLoseCount(Nation nation) {
        elements.stream()
                .filter(n -> Objects.equals(n.getName(), nation.getName()))
                .findFirst()
                .get()
                .increaseLose();
    }

    public void increaseGoal(Nation nation, int ourGoal, int otherGoal) {
        elements.stream()
                .filter(n -> Objects.equals(n.getName(), nation.getName()))
                .findFirst()
                .get()
                .increaseGoal(ourGoal, otherGoal);
    }

    public void calculateRanking() {
        Collections.sort(elements, Comparator.comparing(Nation::getGoal));
        Collections.sort(elements, Comparator.comparing(Nation::getDifference));
        Collections.sort(elements, Comparator.comparing(Nation::getPoint));
        Collections.reverse(elements);
    }

    public int size() {
        return elements.size();
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.size(); i++) {
            sb.append(i + 1).append(OutputMessage.RANKING.getMessage());
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

    public Nation getNationtByNationName(String nationName) {
        Nation n = null;
        for (Nation nation : elements) {
            if (nation.isEqualName(nationName)) {
                n = nation;
            }
        }
        return n;
    }

    public String getNextRoundNation() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            Nation nation = elements.get(i);
            stringBuilder.append(i + 1).append(OutputMessage.RANKING.getMessage())
                    .append(nation.getName())
                    .append(OutputMessage.NEW_LINE.getMessage());
        }
        return stringBuilder.toString();
    }
}
