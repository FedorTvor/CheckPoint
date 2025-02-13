package Menu;

public class ExitAction implements MenuAction {
    @Override
    public void execute() {
        System.out.println("Выход из программы...");
        System.exit(0);

    }
}