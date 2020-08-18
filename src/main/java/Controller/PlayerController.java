package Controller;

import Enums.MoveEnum;
import Model.*;
import View.Input;
import View.Printer;
import Model.Board;

public class PlayerController {

    public final Printer printer = new Printer();
    public final Input input = new Input();
    private Player player;
    private Snake snake;
    private Board board;
    private int size;
    private Mover mover;
    private Counter counter;
    private MoveEnum moveType;

    public PlayerController() {
        initVariabls();
        run();
    }

    public void initVariabls(){
        player = new Player("Jozek");
        size = input.getIntInputWithMessage("Podaj rozmiar planszy : ");
        board = new Board(size);
        board = board.putFoodOnCoreBoard();
        snake = new Snake(size);
        board.putSnakeOnBoard(snake);
        printer.printBoard(board);
        counter = new Counter();
        mover = new Mover();
    }

    public void run() {
        while (true) {
            moveType = input.getMoveType(input.getIntInput());
            snake = mover.moveSnake(snake, moveType,board, counter);
            board = board.clearBoard();
            board = board.putFoodOnCoreBoard();
            board = board.putSnakeOnBoard(snake);
            printer.printBoard(board);
            printer.printMessage("Counter : "+String.valueOf(counter.getAmount()));
            printer.goNextLine();
        }
    }
}
