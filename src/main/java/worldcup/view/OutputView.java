package worldcup.view;

import worldcup.constant.OutputMessage;
import worldcup.domain.Feature;

public class OutputView {

    public void printStartService() {
        System.out.println(OutputMessage.START_SERVICE.getMessage());
    }

    public void printMenu() {
        System.out.println(Feature.getScreen());
    }
}