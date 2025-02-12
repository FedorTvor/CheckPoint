public class RootVegetableComporator implements CustomComparator<RootVegetable>{
    @Override
    public int compare(RootVegetable rootVgtbl1, RootVegetable rootVgtbl2) {
        if (rootVgtbl1.getWeight() != rootVgtbl2.getWeight()) {
            return CustomComparator.compareINT(rootVgtbl1.getWeight(), rootVgtbl2.getWeight());
        } else if (!rootVgtbl1.getType().equals(rootVgtbl2.getType())) {
            return rootVgtbl1.getType().compareTo(rootVgtbl2.getType());
        } else {
            return rootVgtbl1.getColour().compareTo(rootVgtbl2.getColour());
        }
    };
}