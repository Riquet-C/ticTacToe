package display.view;

public abstract class View {
    public void display(String message, Object... parameters) {
        System.out.printf(message, parameters);
    }
}
