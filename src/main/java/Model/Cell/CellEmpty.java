package Model.Cell;

public class CellEmpty extends CellAbstract implements Cell {


    public int getId() { return this.id; }

    public void setId(int id) { this.id = id ;}

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


}
