import java.util.HashMap;
import java.util.Scanner;

public class Menu implements MenuAction{
    private HashMap<String,Pair<String, MenuAction>> choices=new HashMap<String,Pair<String, MenuAction>>();
    private static Scanner scan= new Scanner(System.in);

    public String prelude="Выберите действие:";
    public String prompt=">";
    public String wrong="Неверный выбор. Попробуйте снова.";
    public boolean reopen_after_submenu_closes=false;

    public void removeAction(String key){
        choices.remove(key);
    }
    public void clearActions(){
        choices.clear();
    }

    //private Map<Integer, MenuAction> actions = new HashMap<>();
    public Menu() {
    }
    public void addAction(String key, String name, MenuAction action){
        choices.put(key, new Pair<String, MenuAction>(name, action));
    }

    public MenuAction execute(){
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
                return null;
            }
            next.b.execute();
        }while(reopen_after_submenu_closes);
        return null;
    }
}