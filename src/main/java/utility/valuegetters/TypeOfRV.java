package utility.valuegetters;

import models.RootVegetable;

public class TypeOfRV extends ValueGetter<RootVegetable, String> {
    public java.lang.String get(RootVegetable rv){
        return rv.getType();
    }
}