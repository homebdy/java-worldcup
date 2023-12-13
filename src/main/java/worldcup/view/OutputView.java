package worldcup.view;

import worldcup.constant.OutputMessage;
import worldcup.domain.Feature;
import worldcup.domain.Group;
import worldcup.domain.Matches;
import worldcup.domain.Nation;

public class OutputView {

    public void printStartService() {
        System.out.println(OutputMessage.START_SERVICE.getMessage());
    }

    public void printMenu() {
        System.out.println(Feature.getScreen());
    }

    public void printSelectFeature() {
        System.out.println(OutputMessage.SELECT_FEATURE.getMessage());
    }

    public void printAllMatches(Matches matches) {
        System.out.println(matches.getAllMatch());
    }

    public void printReadGroup() {
        System.out.println(OutputMessage.READ_GROUP.getMessage());
    }

    public void printResultByGroupName(Group group) {
        System.out.print(group.getResult());
    }

    public void printNationMessage() {
        System.out.println(OutputMessage.READ_NATION.getMessage());
    }

    public void printNationResult(Nation nation, String logs) {
        System.out.println(nation.getResultByNationName());
        System.out.println();
        System.out.println(logs);
    }

    public void printNextRoundNation(String message) {
        System.out.print(message);
    }

    public void printEndMessage() {
        System.out.println(OutputMessage.GAME_END.getMessage());
    }

    public void printNewLine() {
        System.out.println();
    }
}