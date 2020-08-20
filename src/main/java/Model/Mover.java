package Model;

import Enums.MoveEnum;
import Model.Cell.Cell;
import Model.Cell.CellFood;
import Model.Cell.CellSnakeBody;

import java.util.Arrays;
import java.util.Set;

public class Mover {

    public Snake moveSnake(Snake snake, MoveEnum moveEnum, Board board, Counter counter) {
        int size = snake.getSnakeMap().size();
        Cell head = snake.getSnakeMap().get(1);
        int row = head.getRow();
        int column = head.getColumn();
        int tempRow = head.getRow();
        int tempColumn = head.getColumn();
        if (moveEnum == MoveEnum.RIGHT) {
            moveHorizontally(snake, board, size, head, row, column, tempRow, tempColumn, column + 1, counter);
        } else if (moveEnum == MoveEnum.LEFT) {
            moveHorizontally(snake, board, size, head, row, column, tempRow, tempColumn, column - 1, counter);
        } else if (moveEnum == MoveEnum.UP) {
            moveVartically(snake, board, size, head, row, column, tempRow, tempColumn, row - 1, counter);
        } else if (moveEnum == MoveEnum.DOWN) {
            moveVartically(snake, board, size, head, row, column, tempRow, tempColumn, row + 1, counter);
        }
        return snake;
    }

    private void moveVartically(Snake snake, Board board, int size, Cell head, int row, int column, int tempRow, int tempColumn, int i, Counter counter) {
        int bordSize = board.getSize();
        if (i >= 0 && i < bordSize) {
            if (board.getCoreBoard()[i][column] instanceof CellFood) {
                addToSnakeAndCount(snake, size, row, column, counter);
            }
            if (snake.getSnakeMap().size() == 1) {
                head.setRow(i);
            } else {
                head.setRow(i);
                replaceCellQueue(snake, tempRow, tempColumn);
            }
        }
    }

    private void moveHorizontally(Snake snake, Board board, int snakeSize, Cell head, int row, int column, int tempRow, int tempColumn, int i, Counter counter) {
        int bordSize = board.getSize();
        if (i >= 0 && i < bordSize) {
            if (board.getCoreBoard()[row][i] instanceof CellFood) {
                addToSnakeAndCount(snake, snakeSize, row, column, counter);
            }
            if (snake.getSnakeMap().size() == 1) {
                head.setColumn(i);
            } else {
                head.setColumn(i);
                replaceCellQueue(snake, tempRow, tempColumn);
            }
        }
    }

    private void addToSnakeAndCount(Snake snake, int snakeSize, int row, int column, Counter counter) {
        snake.addPartSnakeBody(snakeSize + 1, new CellSnakeBody(snakeSize + 1, row, column));
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
