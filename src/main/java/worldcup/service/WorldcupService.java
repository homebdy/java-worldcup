package worldcup.service;

import worldcup.domain.*;

import java.util.Arrays;
import java.util.List;

public class WorldcupService {

    private final Groups groups = new Groups();

    public void addGroup(String message) {
        List<String> result = Arrays.stream(message.split(" ")).toList();
        GroupName name = GroupName.getGroup(String.valueOf(result.get(0).charAt(0)));
        Nation nation1 = new Nation(result.get(1));
        Nation nation2 = new Nation(result.get(3));


        int score1 = Integer.parseInt(result.get(4));
        int score2 = Integer.parseInt(result.get(6));

        Matches match = new Matches(new GameLog(nation1, score1), new GameLog(nation2, score2));
        groups.addResult(name, match);
    }

    public void print() {
        groups.print();
    }
}
