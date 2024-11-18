public class Cell {



    private CellStatement cellStatement;

    public Cell(CellStatement cellStatement) {
        this.cellStatement = cellStatement;
    }

    public CellStatement getCellStatement() {
        return cellStatement;
    }

    public void setCellStatement(CellStatement cellStatement) {
        this.cellStatement = cellStatement;
    }

}
