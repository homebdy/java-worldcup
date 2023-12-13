package worldcup.domain;

import worldcup.constant.OutputMessage;

import java.util.*;

public class Matches {

    private final Map<GroupName, List<Match>> elements = new EnumMap<>(GroupName.class);

    public Matches() {
        Arrays.stream(GroupName.values())
                .forEach(name -> elements.put(name, new ArrayList<>()));
    }

    public void addMatch(GroupName name, Match match) {
        List<Match> newMatch = elements.get(name);
        newMatch.add(match);
        elements.put(name, newMatch);
    }

    public String getAllMatch() {
        StringBuilder sb = new StringBuilder();
        for (GroupName name : elements.keySet()) {
            sb.append(name.getName()).append(OutputMessage.NEW_LINE.getMessage());
            getLogsScreen(sb, name);
            sb.append(OutputMessage.NEW_LINE.getMessage());
        }
        sb.append(OutputMessage.END_LINE.getMessage());
        return sb.toString();
    }

    private void getLogsScreen(StringBuilder sb, GroupName name) {
        for (Match match : elements.get(name)) {
            sb.append(match.getMessage()).append(OutputMessage.NEW_LINE.getMessage());
        }
    }

    public String getLogsByNationName(GroupName groupName, String nationName) {
        StringBuilder sb = new StringBuilder();
        for (Match match : elements.get(groupName)) {
            if (match.isContain(nationName)) {
                sb.append(match.getMessage()).append(OutputMessage.NEW_LINE.getMessage());
            }
        }
        return sb.toString();
    }
}
