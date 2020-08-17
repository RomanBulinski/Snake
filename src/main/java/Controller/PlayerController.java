package Controller;

import Enums.MoveEnum;
import Model.*;
import View.Input;
import View.Printer;
import Model.Board;

public class PlayerController {

    private final Printer printer = new Printer();
    private final Input input = new Input();
    private Player player = new Player("Jozek");
    private Snake snake;
    private Snake movedSnake;
    private Board board;
    private int size;
    private MoveController moveController;
    private Counter counter;
    private MoveEnum moveType;

    public PlayerController() {
        initVariabls();
        run();
    }

    public void initVariabls(){
        size = input.getIntInputWithMessage("Podaj rozmiar planszy : ");
        board = new Board(size);
        board = board.putFoodOnCoreBoard();
        snake = new Snake(size);
        board.putSnakeOnBoard(snake);
        printer.printBoard(board);
        counter = new Counter();
    }

    public void run() {
        while (true) {
            moveController = new MoveController(snake,counter);
            moveType = input.getMoveType(input.getIntInput());
            movedSnake = moveController.moveSnake(moveController.getSnake(), moveType,board);
            board = board.clearBoard();
            board = board.putFoodOnCoreBoard();
            board = board.putSnakeOnBoard(movedSnake);
            printer.printBoard(board);
            printer.printMessage("Counter : "+String.valueOf(counter.getAmount()));
            printer.goNextLine();
        }
    }
}
