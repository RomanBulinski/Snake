package Controller;

import Enums.MoveEnum;
import Model.*;
import View.Input;
import View.Printer;
import Model.Board;

public class PlayerController {

    private final Player player = new Player("Jozek");
    private final Snake snake;
    private final Board board;
    private final Printer printer = new Printer();
    private final Input input = new Input();
    private final int size = 5;
    private MoveController moveController;

    public PlayerController() {
        board = new Board(size);
        snake = new Snake(size);
        board.putSnakeOnBoard(snake);
        board.putFoodOnCoreBoard();
        printer.printBoard(board);
        run();
    }

    public void run() {
        while (true) {
            moveController = new MoveController(snake);
            MoveEnum moveType = input.getMoveType(input.getIntInput());
            Snake snake2 = moveController.moveHead(snake, moveType);
            board.clearCoreBoard();
            board.putFoodOnCoreBoard();
            if(true){
                CellSnakeBody cellSnakeBody = new CellSnakeBody(2,3,3);
                snake2.addPartSnakeBody(2,cellSnakeBody);
                board.putSnakeOnBoard(snake2);
            }
            printer.printBoard(board);
        }
    }

}
