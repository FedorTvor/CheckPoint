package utility.valuegetters;

import models.RootVegetable;

public class ColourOfRV extends ValueGetter<RootVegetable, String> {
    public java.lang.String get(RootVegetable rv){
        return rv.getColour();
    }
}