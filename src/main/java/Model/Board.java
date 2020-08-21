package Model;

import Model.Cell.*;

import java.util.Map;
import java.util.Set;

public class Board {

    Integer size;
    Cell[][] coreBoard;

    public Board(int size) {
        coreBoard = createCoreBoard(size);
    }

    public int getSize() { return size; }

    public void setSize(int size) {
        this.size = size;
    }

    public Cell[][] getCoreBoard() { return coreBoard; }

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

    public Board putFoodOnCoreBoard() {
        coreBoard[1][1] = new CellFood(11, 1, 1);
        return this;
    }

    public Board putTrapOnCoreBoard() {
        coreBoard[0][0] = new CellTrap(21, 0, 0);
        return this;
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
                if(coreBoard[i][j] instanceof CellSnakeHead || coreBoard[i][j] instanceof CellSnakeBody ){
                    coreBoard[i][j] = new CellEmpty();
                }
            }
        }
        return this;
    }

}
