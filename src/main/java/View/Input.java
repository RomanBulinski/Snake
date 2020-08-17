package View;

import Enums.MoveEnum;

import java.util.Scanner;

public class Input {

    Scanner sc = new Scanner(System.in);

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

}
