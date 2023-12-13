package worldcup.view;

import worldcup.constant.OutputMessage;
import worldcup.domain.*;

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
        System.out.println(group.getResult());
    }

    public void printNationMessage() {
        System.out.println(OutputMessage.READ_NATION.getMessage());
    }

    public void printNationResult(Nation nation, String logs) {
        System.out.println(nation.getResult());
        System.out.println(logs);
    }
}