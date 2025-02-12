import java.util.Scanner;

public class FillRootVegetableManually implements Fill<RootVegetable> {

    @Override
    public RootVegetable[] fill() {
        Scanner in = new Scanner(System.in);

        System.out.println("Ведите число корнеплодов: ");
        Integer countRootVegetables = InputHelp.InputInt(in);

        RootVegetable[] rootVegetables = null;

        if(countRootVegetables != null && countRootVegetables > 0) {
            rootVegetables = new RootVegetable[countRootVegetables];
        } else countRootVegetables = 0;

        for(int i = 0; i < countRootVegetables; i++) {

            System.out.println("Введите тип корнеплода: ");
            String type = in.nextLine();

            System.out.println("Введите цвет корнеплода: ");
            String colour = in.nextLine();

            System.out.println("Введите вес корнеплода: ");
            Integer weight = InputHelp.InputInt(in);

            if(!CheckHelp.rootVegetableCheck(type, colour, weight)) {
                System.out.println("Невозможно создать корнеплод с такими параметрами");
                i--;
            } else {
                rootVegetables[i] = new RootVegetable.Builder()
                        .setColour(colour)
                        .setType(type)
                        .setWeight(weight)
                        .build();
            }
        }

        return rootVegetables;
    }
}
