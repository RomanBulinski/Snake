package Controller;

import Enums.MoveEnum;
import Model.*;

public class MoveController {

    Snake snake;

    public MoveController(Snake snake) {
        this.snake = snake;
    }

    public Snake moveHead(Snake snake, MoveEnum moveEnum) {
        Cell head = snake.getSnakeMap().get(1);
        int row = head.getRow();
        int column = head.getColumn();
        if (moveEnum == MoveEnum.RIGHT) {
            head.setColumn(column + 1);
        } else if (moveEnum == MoveEnum.LEFT) {
            head.setColumn(column - 1);
        } else if (moveEnum == MoveEnum.UP) {
            head.setRow(row - 1);
        } else if (moveEnum == MoveEnum.DOWN) {
            head.setRow(row + 1);
        }
        return snake;
    }

}
