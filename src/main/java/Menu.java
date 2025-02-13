import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu implements MenuAction{
    private HashMap<String,Pair<String, MenuAction>> choices=new HashMap<String,Pair<String, MenuAction>>();
    private static Scanner scan= new Scanner(System.in);
    
    public String prelude="Выберите действие:";
    public String prompt=">";
    public String wrong="Неверный выбор. Попробуйте снова.";
    public boolean reopen_after_submenu_closes=false;
    
    public Menu removeAction(String key){
        choices.remove(key);
        return this;
    }
    public Menu clearActions(){
        choices.clear();
        return this;
    }
    
    //private Map<Integer, MenuAction> actions = new HashMap<>();

    public Menu() {
    }

    public Menu addAction(String key, String name, MenuAction action){
        choices.put(key, new Pair<String, MenuAction>(name, action));
        return this;
    }

    /*
    public void display() {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Заполнение массива объектов вручную");
            System.out.println("2. Создание массива объектов с рандомными значениями");
            System.out.println("3. Вывод массива объектов на экран");
            System.out.println("4. Сортировка массива");
            System.out.println("0. Выход");

            int choice = getIntInput();
            MenuAction action = actions.get(choice);
            if (action != null) {
                action.execute();
            } else if (choice == 0) {
                actions.get(0).execute();
            } else {
                System.out.println("Неверный выбор. Попробуйте снова.");
            }
            System.out.println();
        }
    }*/
    
    public void execute(){
        String input;
        do{
            for (String k : choices.keySet()){
                System.out.printf("%s: %s\n",k, choices.get(k).a);
            }
            
            Pair<String, MenuAction> next=null;
            while(true){
                System.out.print(prompt);
                input=scan.nextLine();
                next=choices.get(input);
                if (next!=null){
                    break;
                }
                System.out.println(wrong);
            }
            if (next.b==null){
                return;
            }
            next.b.execute();
        }while(reopen_after_submenu_closes);
    }
    /*
    private int getIntInput() {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print("Введите целое число: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка: Введено не целое число. Попробуйте снова.");
                scanner.next(); // Очистить некорректный ввод
            }
        }
        return number;

    }*/
}