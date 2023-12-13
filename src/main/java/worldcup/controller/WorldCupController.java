package worldcup.controller;

import worldcup.domain.Feature;
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
        Feature feature = readFeature();
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
}
