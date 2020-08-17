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
    private Board board;
    private int size;
    private MoveController moveController;
    private Counter counter;

    public PlayerController() {
        initVariabls();
        run();
    }

    public void initVariabls(){
        size = input.getIntInputWithMessage("Podaj rozmiar planszy : ");
        board = new Board(size);
        snake = new Snake(size);
        board.putSnakeOnBoard(snake);
        board.putFoodOnCoreBoard();
        printer.printBoard(board);
        counter = new Counter();
    }


    public void run() {
        while (true) {
            moveController = new MoveController(snake,counter);
            MoveEnum moveType = input.getMoveType(input.getIntInput());
            Snake snake2 = moveController.getSnake();
            Snake snake3 = moveController.move(snake2, moveType,board);
            board.clearCoreBoard();
            board.putFoodOnCoreBoard();
            board.putSnakeOnBoard(snake3);
            printer.printBoard(board);
            printer.printMessage("Counter : "+String.valueOf(counter.getAmount()));
            printer.goNextLine();
        }
    }
}
