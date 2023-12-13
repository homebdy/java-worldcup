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
        increaseWinnerCount(groupName, match.getWinner());
    }

    private void addNation(Group group, Nation nation) {
        if (!group.contains(nation)) {
            group.add(nation);
        }
    }

    private void increaseWinnerCount(GroupName name, Nation nation) {
        Group group = elements.get(name);
        group.increaseWinCount(nation);
    }

    public void print() {
        for (GroupName groupName : GroupName.values()) {
            Group group = elements.get(groupName);
            group.getElements().forEach(i -> System.out.println(i.getName() + " " + i.getWinCount()));
        }
    }
}
