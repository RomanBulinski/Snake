package Controller;

import View.Printer;

public class GameController {

    public GameController() {
        Printer printer = new Printer();
        printer.printMessage(" *  S N A K E  * ");
        printer.goNextLine();
        PlayerController player = new PlayerController();
    }

}

