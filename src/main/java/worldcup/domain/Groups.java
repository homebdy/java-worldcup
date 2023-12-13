package worldcup.domain;

import java.util.*;

public class Groups {

    private final Map<GroupName, Group> elements = new EnumMap<>(GroupName.class);

    public Groups() {
        Arrays.stream(GroupName.values())
                .forEach(name -> elements.put(name, new Group()));
    }

    public void addResult(GroupName groupName, Match match) {
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

    private void increaseResultCount(Match match, Group group) {
        if (!match.isDraw()) {
            group.increaseWinCount(match.getWinner());
            group.increaseLoseCount(match.getLoser());
        }
    }

    private void increaseDrawCount(Match match, Group group) {
        if (match.isDraw()) {
            group.increaseDrawCount(match.getWinner());
            group.increaseDrawCount(match.getLoser());
        }
    }

    private void calculateGoal(Group group, Match match) {
        group.increaseGoal(match.getWinner(), match.getWinnerScore(), match.getLoserScore());
        group.increaseGoal(match.getLoser(), match.getLoserScore(), match.getWinnerScore());
    }
}
