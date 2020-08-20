package Model.Cell;

public class CellTrap implements Cell {

    int id;
    int row;
    int column;

    public CellTrap(int id, int row, int column) {
        this.id = id;
        this.row = row;
        this.column = column;
    }

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

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
