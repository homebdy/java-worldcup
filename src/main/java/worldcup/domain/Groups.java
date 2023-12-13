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
    }

    private void addNation(Group group, Nation nation) {
        if (!group.contains(nation)) {
            group.add(nation);
        }
    }

    private void increaseResultCount(Matches match, Group group) {
        if (!match.isDraw()) {
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

    public void print() {
        for (GroupName groupName : GroupName.values()) {
            Group group = elements.get(groupName);
            group.getElements().forEach(i -> System.out.println(i.getName() + " " + i.getWinCount() + " " + i.getDrawCount() + " " + i.getLoseCount()));
        }
    }
}
