import java.util.Scanner;

public class FillRootVegetableManually implements Fill<RootVegetable> {

    @Override
    public RootVegetable[] fill() {
        Scanner in = new Scanner(System.in);

        Integer countRootVegetables = InputHelp.getInt("Ведите число корнеплодов: ", in);

        RootVegetable[] rootVegetables = null;

        if(countRootVegetables != null && countRootVegetables > 0) {
            rootVegetables = new RootVegetable[countRootVegetables];
        } else countRootVegetables = 0;

        for(int i = 0; i < countRootVegetables; i++) {
            String type = InputHelp.getString("Введите тип корнеплода: ", in);

            String colour = InputHelp.getString("Введите цвет корнеплода: ", in);

            Integer weight = InputHelp.getInt("Введите вес корнеплода: ", in);

            rootVegetables[i] = RootVegetable.collectorClass(type, colour, weight);

            if(rootVegetables[i] == null) i--;
        }

        return rootVegetables;
    }
}
