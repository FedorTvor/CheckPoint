package utility.valuegetters;

import models.RootVegetable;

public class WeightOfRV extends ValueGetter<RootVegetable, Integer> {
    public java.lang.Integer get(RootVegetable rv){
        return rv.getWeight();
    }
}