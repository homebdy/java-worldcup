package worldcup.service;

import worldcup.domain.*;

import java.util.Arrays;
import java.util.List;

public class WorldcupService {

    private final Groups groups = new Groups();
    private final Matches matches = new Matches();

    public void addGroup(String message) {
        List<String> result = Arrays.stream(message.split(" ")).toList();
        GroupName name = GroupName.getGroup(String.valueOf(result.get(0).charAt(0)));
        Nation nation1 = new Nation(result.get(1));
        Nation nation2 = new Nation(result.get(3));

        int score1 = Integer.parseInt(result.get(4));
        int score2 = Integer.parseInt(result.get(6));

        Match match = new Match(new GameLog(nation1, score1), new GameLog(nation2, score2), message.substring(3));
        matches.addMatch(name, match);
        groups.addResult(name, match);
    }

    public Matches getMatches() {
        return matches;
    }

    public Group getGroupByGroupName(GroupName name) {
        return groups.getGroupByGroupName(name);
    }
}
