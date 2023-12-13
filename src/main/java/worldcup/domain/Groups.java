package worldcup.domain;

import java.util.*;

public class Groups {

    private final Map<GroupName, Group> elements = new EnumMap<>(GroupName.class);

    public Groups() {
        Arrays.stream(GroupName.values())
                .forEach(name -> elements.put(name, new Group()));
    }

    public void addNation(GroupName groupName, Nation nation) {
        Group group = elements.get(groupName);
        group.add(nation);
    }
}
