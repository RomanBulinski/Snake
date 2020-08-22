package View;

import Enums.MoveEnum;

import java.util.Scanner;

public class Input {

    private Scanner sc = new Scanner(System.in);
    private Printer printer = new Printer();

    public int getIntInput() {
        return sc.nextInt();
    }

    public MoveEnum getMoveType(int inputUser) {
        MoveEnum moveType = null;
        switch (inputUser) {
            case 2:
                moveType = MoveEnum.DOWN;
                break;
            case 8:
                moveType = MoveEnum.UP;
                break;
            case 4:
                moveType = MoveEnum.LEFT;
                break;
            case 6:
                moveType = MoveEnum.RIGHT;
                break;
        }
        return moveType;
    }

    public int getIntInputWithMessage(String message) {
        printer.printMessage(message);
        return sc.nextInt();
    }
}
