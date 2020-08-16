package View;

import Model.*;

public class Printer {

    public void printBoard(Board board) {
        System.out.print("\033[H\033[2J");
        Cell[][] coreBoard = board.getCoreBoard();
        //TODO  change to stream
        for (int i = 0; i < coreBoard[0].length; i++) {
            for (int j = 0; j < coreBoard[0].length; j++) {
                if (coreBoard[i][j] instanceof CellEmpty) {
                    printMessage(" .");
                } else if(coreBoard[i][j] instanceof CellSnakeHead){
                    printMessage(" H");
                }else if(coreBoard[i][j] instanceof CellSnakeBody) {
                    printMessage(" x");
                }else if(coreBoard[i][j] instanceof CellFood) {
                    printMessage(" F");
                }
            }
            goNextLine();
        }
        goNextLine();
    }

    public void goNextLine() {
        System.out.println();
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

}
