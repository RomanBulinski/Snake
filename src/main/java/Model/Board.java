package Model;

import Enums.MoveEnum;

import java.util.Map;

public class Board {

    int size;
    Cell[][] coreBoard;

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

    public void putFoodOnCoreBoard(){
        coreBoard[1][1] = new CellFood(11, 1 ,1);
    }

    public void putSnakeOnBoard(Snake snake) {
        Map<Integer, Cell> snakeMap = snake.getSnakeMap();
        Cell head = snakeMap.get(1);
        int row = head.getRow();
        int column = head.getColumn();
        coreBoard[row][column] = head;

        if(snakeMap.get(2) != null){
            Cell body1 = snakeMap.get(2);
            int row1 = body1.getRow();
            int column1 = body1.getColumn();
            coreBoard[row1][column1] = body1;
        }
    }

    public void  clearCoreBoard(){
        Cell[][] core =  getCoreBoard();
        for(int i =0; i<core.length; i++){
            for(int j =0; j<core.length; j++){
                core[i][j] = new CellEmpty();
            }
        }
    }

}
