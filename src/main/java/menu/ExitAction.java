package menu;

public class ExitAction implements MenuAction {
    @Override
    public void execute() {
        System.out.println("Exiting program...");
        System.exit(0);
    }
}
