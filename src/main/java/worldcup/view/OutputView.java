package worldcup.view;

import worldcup.constant.OutputMessage;
import worldcup.domain.Feature;
import worldcup.domain.Group;
import worldcup.domain.Groups;
import worldcup.domain.Matches;

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
}