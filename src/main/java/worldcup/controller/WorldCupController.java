package worldcup.controller;

import worldcup.domain.Feature;
import worldcup.domain.GroupName;
import worldcup.domain.Nation;
import worldcup.service.WorldcupService;
import worldcup.view.InputView;
import worldcup.view.OutputView;

public class WorldCupController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final WorldcupService service = new WorldcupService();

    public void start() {
        readFile();
        outputView.printStartService();
        while (true) {
            Feature feature = readFeature();
            executeFirstFeature(feature);
            executeSecondFeature(feature);
            executeThirdFeature(feature);
            executeFourthFeature(feature);
            if (feature.isFifth()) {
                break;
            }
        }
        outputView.printEndMessage();
    }

    private void readFile() {
        ReadFile file = new ReadFile();
        file.getMatches()
                .forEach(service::addGroup);
    }

    private Feature readFeature() {
        outputView.printNewLine();
        outputView.printMenu();
        outputView.printSelectFeature();
        Feature feature = inputView.readFeature();
        outputView.printNewLine();
        return feature;
    }

    private void executeFirstFeature(Feature feature) {
        if (feature.isFirst()) {
            outputView.printAllMatches(service.getMatches());
        }
    }

    private void executeSecondFeature(Feature feature) {
        if (feature.isSecond()) {
            outputView.printReadGroup();
            GroupName groupname = inputView.readGroupName();
            outputView.printNewLine();
            outputView.printResultByGroupName(service.getGroupByGroupName(groupname));
        }
    }

    private void executeThirdFeature(Feature feature) {
        if (feature.isThird()) {
            outputView.printNationMessage();
            String input = inputView.readNation();
            outputView.printNewLine();
            Nation nation = service.getNationByNationName(input);
            outputView.printNationResult(nation, service.getMatchesByNationName(input));
            outputView.printNextRoundNation(service.getAdvanceMessage(input));
            outputView.printNewLine();
        }
    }

    private void executeFourthFeature(Feature feature) {
        if (feature.isFourth()) {
            outputView.printNextRoundNation(service.getNextRoundNation());
        }
    }
}
