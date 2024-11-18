public enum CellStatement {
    EMPTY("   "),
    X(" X "),
    O(" O ");

    private final String representation;

    CellStatement(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public void display(){
        System.out.print(this.representation);
    }
}
