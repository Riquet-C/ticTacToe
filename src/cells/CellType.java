package cells;

public enum CellType {
    EMPTY("   "),
    X(" X "),
    O(" O ");

    private final String type;

    CellType(String type) {
        this.type = type;
    }

    public void display(){
        System.out.print(this.type);
    }
}
