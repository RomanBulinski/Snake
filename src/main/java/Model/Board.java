package Model;

import Model.Cell.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Board {

    private final Utils utils = new Utils();
    private Integer size;
    private Cell[][] coreBoard;

    public Board(int size) {
        coreBoard = createCoreBoard(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Cell[][] getCoreBoard() {
        return coreBoard;
    }

    public void setCoreBoard(Cell[][] coreBoard) {
        this.coreBoard = coreBoard;
    }

    public Cell[][] createCoreBoard(int sizeBoard) {
        size = sizeBoard;
        Cell[][] coreBoard = new Cell[sizeBoard][];
        for (int i = 0; i < sizeBoard; i++) {
            Cell[] row = new Cell[sizeBoard];
            for (int j = 0; j < sizeBoard; j++) {
                row[j] = new CellEmpty();
            }
            coreBoard[i] = row;
        }
        return coreBoard;
    }

    public Board putSnakeOnBoard(Snake snake) {
        Map<Integer, Cell> snakeMap = snake.getSnakeMap();
        if (snakeMap.size() == 1) {
            Cell head = snakeMap.get(1);
            int row = head.getRow();
            int column = head.getColumn();
            coreBoard[row][column] = head;
        } else {
            Set<Integer> keys = snakeMap.keySet();
            keys.forEach(k -> coreBoard[snakeMap.get(k).getRow()][snakeMap.get(k).getColumn()]
                    = new CellSnakeBody(k, snakeMap.get(k).getRow(), snakeMap.get(k).getColumn()));
        }
        return this;
    }

    public Board clearBoard() {
        for (int i = 0; i < coreBoard.length; i++) {
            for (int j = 0; j < coreBoard.length; j++) {
                coreBoard[i][j] = new CellEmpty();
            }
        }
        return this;
    }

    public Board removeSnake() {
        for (int i = 0; i < coreBoard.length; i++) {
            for (int j = 0; j < coreBoard.length; j++) {
                if (coreBoard[i][j] instanceof CellSnakeHead || coreBoard[i][j] instanceof CellSnakeBody) {
                    coreBoard[i][j] = new CellEmpty();
                }
            }
        }
        return this;
    }

    public Board putFoodOnCoreBoard() {
        int row = utils.getIntBetween(0, size - 1);
        int column = utils.getIntBetween(0, size - 1);
        if (isEmptyCell(row, column)) {
            coreBoard[row][column] = new CellFood(11, row, column);
        }
        return this;
    }

    public Board checkAndPutFoodOnBoard() {
        //TODO implement this method
        return this;
    }

    public Board putTrapOnCoreBoard() {
        int row = utils.getIntBetween(0, size - 1);
        int column = utils.getIntBetween(0, size - 1);
        if (isEmptyCell(row, column)) {
            coreBoard[row][column] = new CellTrap(21, row, column);
        }
        return this;
    }

    private boolean isEmptyCell(int row, int column) {
        return coreBoard[row][column] instanceof CellEmpty;
    }

    private boolean isFoodOnBoard() {
        for (int i = 0; i < coreBoard.length; i++) {
            int l = Arrays.stream(coreBoard[i]).filter(cell -> cell instanceof CellFood).
                    collect(Collectors.toList()).
                    size();
            if (l > 0) {
                return true;
            }
        }
        return false;
    }

    //dont remove - second solution for above
    private boolean isFoodOnBoard2() {
        AtomicReference<Boolean> result = new AtomicReference<>(false);
        Arrays.stream(coreBoard).
                forEach(line -> Arrays.stream(line).
                        filter(cell -> cell instanceof CellFood).forEach(x -> result.set(true)));
        return result.get();
    }

}
