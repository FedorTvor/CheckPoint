public class ExitAction implements MenuAction{
    @Override
    public MenuAction execute() {
        System.out.println("Выход из программы...");
        System.exit(0);

        return null;
    }
}