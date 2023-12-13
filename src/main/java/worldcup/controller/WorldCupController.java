package worldcup.controller;

import worldcup.domain.Feature;
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
        outputView.printMenu();
        outputView.printSelectFeature();
        return inputView.readFeature();
    }

    private void executeFirstFeature(Feature feature) {
        if (feature.isFirst()) {
            outputView.printAllMatches(service.getMatches());
        }
    }

    private void executeSecondFeature(Feature feature) {
        if (feature.isSecond()) {
            outputView.printReadGroup();
            outputView.printResultByGroupName(service.getGroupByGroupName(inputView.readGroupName()));
        }
    }

    private void executeThirdFeature(Feature feature) {
        if (feature.isThird()) {
            outputView.printNationMessage();
            String input = inputView.readNation();
            Nation nation = service.getNationByNationName(input);
            outputView.printNationResult(nation, service.getMatchesByNationName(input));
        }
    }

    private void executeFourthFeature(Feature feature) {
        if (feature.isFourth()) {
            outputView.printNextRoundNation(service.getNextRoundNation());
        }
    }
}
