package worldcup.domain;

import worldcup.constant.ExceptionMessage;
import worldcup.constant.OutputMessage;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

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
        return elements.values().stream()
                .filter(group -> group.isContainNation(nationName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_NATION.getMessage()))
                .getNationByNationName(nationName);
    }

    public String getNextRoundNation() {
        StringBuilder sb = new StringBuilder();
        for (GroupName groupName : elements.keySet()) {
            Group group = elements.get(groupName);
            sb.append(groupName.getName()).append(OutputMessage.NEW_LINE.getMessage());
            sb.append(group.getNextRoundNation());
            if (!groupName.isLast()) {
                sb.append(OutputMessage.NEW_LINE.getMessage());
            }
        }
        return sb.toString();
    }

    public String getAdvance(GroupName groupName, String nationName) {
        Group group = elements.get(groupName);
        StringBuilder sb = new StringBuilder();
        sb.append(groupName.getName()).append(OutputMessage.BLANK.getMessage());
        appendAdvance(sb, group, nationName);
        appendNotAdvance(sb, group, nationName);
        return sb.toString();
    }

    public void appendAdvance(StringBuilder sb, Group group, String nationName) {
        if (group.isAdvance(nationName)) {
            sb.append(group.getRanking(nationName))
                    .append(OutputMessage.RANKING.getMessage())
                    .append(OutputMessage.ADVANCE.getMessage());
        }
    }

    public void appendNotAdvance(StringBuilder sb, Group group, String nationName) {
        if (!group.isAdvance(nationName)) {
            sb.append(group.getRanking(nationName))
                    .append(OutputMessage.RANKING.getMessage())
                    .append(OutputMessage.NOT_ADVANCE.getMessage());
        }
    }
}
