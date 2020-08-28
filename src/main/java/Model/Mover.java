package Model;

import Enums.MoveEnum;
import Model.Cell.Cell;

public class Mover {

    Move move = new Move();

    public Snake moveSnake(Snake snake, MoveEnum moveEnum, Board board, Counter counter) {
        int size = snake.getSnakeMap().size();
        Cell head = snake.getSnakeMap().get(1);
        int row = head.getRow();
        int column = head.getColumn();
        int tempRow = head.getRow();
        int tempColumn = head.getColumn();
        if (moveEnum == MoveEnum.RIGHT) {
            move.moveHorizontally(snake, board, size, head, row, column, tempRow, tempColumn, column + 1, counter);
        } else if (moveEnum == MoveEnum.LEFT) {
            move.moveHorizontally(snake, board, size, head, row, column, tempRow, tempColumn, column - 1, counter);
        } else if (moveEnum == MoveEnum.UP) {
            move.moveVartically(snake, board, size, head, row, column, tempRow, tempColumn, row - 1, counter);
        } else if (moveEnum == MoveEnum.DOWN) {
            move.moveVartically(snake, board, size, head, row, column, tempRow, tempColumn, row + 1, counter);
        }
        return snake;
    }






}
