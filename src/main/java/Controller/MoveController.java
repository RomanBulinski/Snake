package Controller;

import Enums.MoveEnum;
import Model.*;

import java.util.Arrays;
import java.util.Set;

public class MoveController {

    private Snake snake;
    private Counter counter;

    public MoveController(Snake snake,Counter counter) {
        this.snake = snake;
        this.counter = counter;
    }
    public Snake getSnake() {
        return snake;
    }

    public Snake moveSnake(Snake snake, MoveEnum moveEnum, Board board) {
        int size = snake.getSnakeMap().size();
        Cell head = snake.getSnakeMap().get(1);
        int row = head.getRow();
        int column = head.getColumn();
        int tempRow = head.getRow();
        int tempColumn = head.getColumn();
        if (moveEnum == MoveEnum.RIGHT) {
            moveHorizontally(snake, board, size, head, row, column, tempRow, tempColumn, column + 1);
        } else if (moveEnum == MoveEnum.LEFT) {
            moveHorizontally(snake, board, size, head, row, column, tempRow, tempColumn, column - 1);
        } else if (moveEnum == MoveEnum.UP) {
            moveVartically(snake, board, size, head, row, column, tempRow, tempColumn, row - 1);
        } else if (moveEnum == MoveEnum.DOWN) {
            moveVartically(snake, board, size, head, row, column, tempRow, tempColumn, row + 1);
        }
        return snake;
    }

    private void moveVartically(Snake snake, Board board, int size, Cell head, int row, int column, int tempRow, int tempColumn, int i) {
        if (board.getCoreBoard()[i][column] instanceof CellFood) {
            addToSnakeAndCount(snake, size, row, column);
        }
        if (snake.getSnakeMap().size() == 1) {
            head.setRow(i);
        } else {
            head.setRow(i);
            replaceCellQueue(snake, tempRow, tempColumn);
        }
    }

    private void moveHorizontally(Snake snake, Board board, int size, Cell head, int row, int column, int tempRow, int tempColumn, int i) {
        if (board.getCoreBoard()[row][i] instanceof CellFood) {
            addToSnakeAndCount(snake, size, row, column);
        }
        if (snake.getSnakeMap().size() == 1) {
            head.setColumn(i);
        } else {
            head.setColumn(i);
            replaceCellQueue(snake, tempRow, tempColumn);
        }
    }

    private void addToSnakeAndCount(Snake snake, int size, int row, int column) {
        snake.addPartSnakeBody(size + 1, new CellSnakeBody(size + 1, row, column));
        counter.setAmount(counter.getAmount() + 1);
    }

    private void replaceCellQueue(Snake snake, int tempRow, int tempColumn) {
        int tempRowBis;
        int tempColumnBis;
        Set<Integer> keys = snake.getSnakeMap().keySet();
        Object[] keysA = keys.toArray();
        Arrays.sort(keysA);
        for (Object key : keysA) {
            if ((Integer) key != 1) {
                Cell cell = snake.getSnakeMap().get(key);
                tempRowBis = cell.getRow();
                tempColumnBis = cell.getColumn();
                cell.setRow(tempRow);
                cell.setColumn(tempColumn);
                tempRow = tempRowBis;
                tempColumn = tempColumnBis;
            }
        }
    }

}
