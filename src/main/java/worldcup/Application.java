package worldcup;

import worldcup.controller.WorldCupController;

public class Application {
    public static void main(String[] args) {
        WorldCupController controller = new WorldCupController();
        controller.start();
    }
}