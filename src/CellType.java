public enum CellType {
    EMPTY("   "),
    Player_X(" X "),
    Player_O(" O ");

    private final String type;

    CellType(String type) {
        this.type = type;
    }

    public void display(){
        System.out.print(this.type);
    }
}
