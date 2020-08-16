package Controller;

import Enums.MoveEnum;
import Model.*;

import java.util.Arrays;
import java.util.Set;

public class MoveController {

    Snake snake;

    public MoveController(Snake snake) {
        this.snake = snake;
    }

    public Snake move(Snake snake, MoveEnum moveEnum, Board board) {
        int size = snake.getSnakeMap().size();
        Cell head = snake.getSnakeMap().get(1);
        int row = head.getRow();
        int column = head.getColumn();
        if (moveEnum == MoveEnum.RIGHT) {
            if (board.getCoreBoard()[row][column + 1] instanceof CellFood) {
                snake.addPartSnakeBody(size+1, new CellSnakeBody(size+1, row, column));
            }
            if (snake.getSnakeMap().size() == 1) {
                head.setColumn(column + 1);
            } else {
                int tempRow = head.getRow();
                int tempColumn = head.getColumn();
                head.setColumn(column + 1);
                replaceCellQueue(snake, tempRow, tempColumn);
            }
        } else if (moveEnum == MoveEnum.LEFT) {
            if (board.getCoreBoard()[row][column - 1] instanceof CellFood) {
                snake.addPartSnakeBody(size+1, new CellSnakeBody(size+1, row, column));
            }
            if (snake.getSnakeMap().size() == 1) {
                head.setColumn(column - 1);
            } else {
                int tempRow = head.getRow();
                int tempColumn = head.getColumn();
                head.setColumn(column - 1);
                replaceCellQueue(snake, tempRow, tempColumn);
            }
        } else if (moveEnum == MoveEnum.UP) {
            if (board.getCoreBoard()[row - 1][column] instanceof CellFood) {
                snake.addPartSnakeBody(size+1, new CellSnakeBody(size+1, row, column));
            }
            if (snake.getSnakeMap().size() == 1) {
                head.setRow(row - 1);
            } else {
                int tempRow = head.getRow();
                int tempColumn = head.getColumn();
                head.setRow(row - 1);
                replaceCellQueue(snake, tempRow, tempColumn);
            }
        } else if (moveEnum == MoveEnum.DOWN) {
            if (board.getCoreBoard()[row + 1][column] instanceof CellFood) {
                snake.addPartSnakeBody(size+1, new CellSnakeBody(size+1, row, column));
            }
            if (snake.getSnakeMap().size() == 1) {
                head.setRow(row + 1);
            } else {
                int tempRow = head.getRow();
                int tempColumn = head.getColumn();
                head.setRow(row +1 );
                replaceCellQueue(snake, tempRow, tempColumn);
            }
        }
        return snake;
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

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }
}
