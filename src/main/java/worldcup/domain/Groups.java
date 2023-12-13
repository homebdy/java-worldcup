package worldcup.domain;

import java.util.*;

public class Groups {

    private final Map<GroupName, Group> elements = new EnumMap<>(GroupName.class);

    public Groups() {
        Arrays.stream(GroupName.values())
                .forEach(name -> elements.put(name, new Group()));
    }

    public void addResult(GroupName groupName, Matches match) {
        Group group = elements.get(groupName);
        addNation(group, match.getWinner());
        addNation(group, match.getLoser());
        increaseResultCount(match, group);
        increaseDrawCount(match, group);
        calculateGoal(group, match);
        group.calculateRanking();
    }

    private void addNation(Group group, Nation nation) {
        if (!group.contains(nation)) {
            group.add(nation);
        }
    }

    private void increaseResultCount(Matches match, Group group) {
        if (!match.isDraw()) {
            System.out.println(match.getWinner().getName());
            group.increaseWinCount(match.getWinner());
            group.increaseLoseCount(match.getLoser());
        }
    }

    private void increaseDrawCount(Matches match, Group group) {
        if (match.isDraw()) {
            group.increaseDrawCount(match.getWinner());
            group.increaseDrawCount(match.getLoser());
        }
    }

    private void calculateGoal(Group group, Matches match) {
        group.increaseGoal(match.getWinner(), match.getWinnerScore(), match.getLoserScore());
        group.increaseGoal(match.getLoser(), match.getLoserScore(), match.getWinnerScore());
    }

    public void print() {
        for (GroupName groupName : GroupName.values()) {
            System.out.println(groupName);
            Group group = elements.get(groupName);
            group.getElements().forEach(i -> System.out.println(i.getName() + " " + i.getWinCount() + " " + i.getDrawCount() + " " + i.getLoseCount() + " " + i.getPoint() + " " + i.getDifference() + " " + i.getGoal()));
        }
    }
}
