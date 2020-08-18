package Model;

import Model.Cell.Cell;
import Model.Cell.CellSnakeHead;

import java.util.HashMap;
import java.util.Map;

public class Snake {

    Map<Integer, Cell> snakeMap = new HashMap<>();
    int size;

    public Snake(int size){
        this. size = size;
        this.putHeadOnStart();
    }

    public  Map<Integer, Cell>  getSnakeMap(){
        return snakeMap;
    }

    public void putHeadOnStart(){
        CellSnakeHead cellSnakeHead = new CellSnakeHead(1, size/2, size/2);
        snakeMap.put(1, cellSnakeHead);
    }

    public void addPartSnakeBody(int id, Cell cell){
        snakeMap.put(id,cell);
    }

}
