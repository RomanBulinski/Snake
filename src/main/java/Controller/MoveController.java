package Controller;

import Enums.MoveEnum;
import Model.*;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class MoveController {

    Snake snake;

    public MoveController(Snake snake) {
        this.snake = snake;
    }

    public Snake move(Snake snake, MoveEnum moveEnum, Board board) {
        Cell head = snake.getSnakeMap().get(1);
        int row = head.getRow();
        int column = head.getColumn();
        if (moveEnum == MoveEnum.RIGHT) {
            if (board.getCoreBoard()[row][column + 1] instanceof CellFood) {
                snake.addPartSnakeBody(2, new CellSnakeBody(2, row, column));
            }
            if (snake.getSnakeMap().size() == 1) {
                head.setColumn(column + 1);
            } else {
                int tempRow = head.getRow();
                int tempColumn = head.getColumn();
                int tempRowBis;
                int tempColumnBis;
                head.setColumn(column + 1);
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
        } else if (moveEnum == MoveEnum.LEFT) {
            if (board.getCoreBoard()[row][column - 1] instanceof CellFood) {
                snake.addPartSnakeBody(2, new CellSnakeBody(2, row, column));
            }
            if (snake.getSnakeMap().size() == 1) {
                head.setColumn(column - 1);
            } else {
                int tempRow = head.getRow();
                int tempColumn = head.getColumn();
                int tempRowBis;
                int tempColumnBis;
                head.setColumn(column - 1);
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
        } else if (moveEnum == MoveEnum.UP) {
            if (board.getCoreBoard()[row - 1][column] instanceof CellFood) {
                snake.addPartSnakeBody(2, new CellSnakeBody(2, row, column));
            }
            if (snake.getSnakeMap().size() == 1) {
                head.setRow(row - 1);
            } else {
                int tempRow = head.getRow();
                int tempColumn = head.getColumn();
                int tempRowBis;
                int tempColumnBis;
                head.setRow(row - 1);
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
        } else if (moveEnum == MoveEnum.DOWN) {
            if (board.getCoreBoard()[row + 1][column] instanceof CellFood) {
                snake.addPartSnakeBody(2, new CellSnakeBody(2, row, column));
            }
            if (snake.getSnakeMap().size() == 1) {
                head.setRow(row + 1);
            } else {
                int tempRow = head.getRow();
                int tempColumn = head.getColumn();
                int tempRowBis;
                int tempColumnBis;
                head.setRow(row +1 );
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
        return snake;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }
}
