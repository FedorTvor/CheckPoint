package Fill;

import Class.RootVegetable;
import Utility.Help.InputHelp;
import Utility.Help.CheckHelp;

import java.util.Scanner;

public class FillRootVegetableManually implements Fill<RootVegetable> {
    final String MES_COUNT = "Ведите число корнеплодов: ";
    final String MES_TYPE = "Введите тип корнеплода: ";
    final String MES_COLOUR= "Введите цвет корнеплода: ";
    final String MES_WEIGHT = "Введите вес корнеплода: ";
    final String MES_ERROR_BUILD = "Невозможно создать корнеплод с такими параметрами";

    @Override
    public RootVegetable[] fill() {
        Scanner in = new Scanner(System.in);

        Integer countRootVegetables = InputHelp.getIntField(MES_COUNT, in);

        RootVegetable[] rootVegetables = null;

        if(countRootVegetables != null && countRootVegetables > 0) {
            rootVegetables = new RootVegetable[countRootVegetables];
        } else countRootVegetables = 0;

        int j = 0;

        for(int i = 0; i < countRootVegetables; i++) {
            String type = InputHelp.getStringField(MES_TYPE, in);

            String colour = InputHelp.getStringField(MES_COLOUR, in);

            Integer weight = InputHelp.getIntField(MES_WEIGHT, in);

            if(CheckHelp.rootVegetableCheck(type, colour, weight)) {
                rootVegetables[j] = RootVegetable.createInstance(type, colour, weight);
                j++;
            } else {
                System.out.println(MES_ERROR_BUILD);
            }
        }

        RootVegetable[] rootVegetables_result = null;
        if(j > 0) {
            rootVegetables_result = new RootVegetable[j];
            System.arraycopy(rootVegetables, 0, rootVegetables_result, 0, j);
        }

        return rootVegetables_result;
    }
}
