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

    public Group getGroupByGroupName(GroupName name) {
        return elements.get(name);
    }

    public GroupName getGroupNameByNationName(String nationName) {
        GroupName result = GroupName.A_GROUP;
        for (GroupName groupName : elements.keySet()) {
            Group group = elements.get(groupName);
            if (group.isContainNation(nationName)) {
                result = groupName;
            }
        }
        return result;
    }

    public Nation getNationByNationName(String nationName) {
        Nation nation = null;
        for (Group group : elements.values()) {
            if (group.isContainNation(nationName)) {
                nation = group.getNationtByNationName(nationName);
            }
        }
        return nation;
    }
}
