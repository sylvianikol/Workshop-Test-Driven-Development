package checkout;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
    private final Map<String, Integer> scannedItems;
    private PricingRules pricingRules;

    public Checkout(PricingRules pricingRules) {
        this.scannedItems = new HashMap<>();
        this.pricingRules = pricingRules;
    }

    public long total() {
        return scannedItems.entrySet().stream()
                .mapToLong(entry ->
                        pricingRules.getPriceRules(entry.getKey())
                            .calculate(entry.getValue()))
                .sum();
    }

    public void scan(String item) {
        this.scannedItems.putIfAbsent(item, 0);
        this.scannedItems.put(item, scannedItems.get(item) + 1);
    }
}
