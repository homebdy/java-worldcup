package worldcup.controller;

import worldcup.domain.Feature;
import worldcup.domain.GroupName;
import worldcup.domain.Nation;
import worldcup.service.WorldcupService;
import worldcup.view.InputView;
import worldcup.view.OutputView;

import java.util.function.Supplier;

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
        return attemptedRead(() -> {
            outputView.printNewLine();
            outputView.printMenu();
            outputView.printSelectFeature();
            Feature feature = inputView.readFeature();
            outputView.printNewLine();
            return feature;
        });
    }

    private void executeFirstFeature(Feature feature) {
        if (feature.isFirst()) {
            outputView.printAllMatches(service.getMatches());
        }
    }

    private void executeSecondFeature(Feature feature) {
        if (feature.isSecond()) {
            GroupName groupName = readGroupName();
            outputView.printResultByGroupName(service.getGroupByGroupName(groupName));
        }
    }

    private GroupName readGroupName() {
        return attemptedRead(() -> {
            outputView.printReadGroup();
            GroupName groupname = inputView.readGroupName();
            outputView.printNewLine();
            return groupname;
        });
    }

    private void executeThirdFeature(Feature feature) {
        if (feature.isThird()) {
            Nation nation = readNation();
            outputView.printNationResult(nation, service.getMatchesByNationName(nation.getName()));
            outputView.printNextRoundNation(service.getAdvanceMessage(nation.getName()));
            outputView.printNewLine();
        }
    }

    private Nation readNation() {
        return attemptedRead(() -> {
            outputView.printNationMessage();
            String input = inputView.readNation();
            outputView.printNewLine();
            return service.getNationByNationName(input);
        });
    }

    private void executeFourthFeature(Feature feature) {
        if (feature.isFourth()) {
            outputView.printNextRoundNation(service.getNextRoundNation());
        }
    }

    private <T> T attemptedRead(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            outputView.printNewLine();
            return supplier.get();
        }
    }
}
