package worldcup.view;

import camp.nextstep.edu.missionutils.Console;
import worldcup.domain.Feature;
import worldcup.validator.InputValidator;

public class InputView {

    private final InputValidator validator = new InputValidator();

    public Feature readFeature() {
        String input = Console.readLine();
        validator.validateNumber(input);
        return Feature.getFeature(Integer.parseInt(input));
    }
}