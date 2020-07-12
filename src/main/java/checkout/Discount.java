package checkout;

public class Discount {

    private final int howManyItems;
    private final int priceForThatManyItems;

    public Discount(int howManyItems, int priceForThatManyItems) {
        this.howManyItems = howManyItems;
        this.priceForThatManyItems = priceForThatManyItems;
    }

    public long calculate(int itemCount, long singlePrice) {
        int discountedSetsOfItems = itemCount / howManyItems;
        int remainingItems = itemCount % howManyItems;
        return (discountedSetsOfItems * priceForThatManyItems) + (remainingItems * singlePrice);
    }
}
