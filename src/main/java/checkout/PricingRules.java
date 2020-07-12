package checkout;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class PricingRules {

    private Map<String, ItemPrice> itemPriceMap;

    public PricingRules(ItemPrice... itemPrices) {
        this.itemPriceMap = Arrays.stream(itemPrices)
                .collect(Collectors.toMap(
                        ItemPrice::getName,
                        (ip) -> ip
                ));

    }

    public ItemPrice getPriceRules(String item) {

        if (!itemPriceMap.containsKey(item)) {
            throw new ItemNotFoundException();
        }

        return itemPriceMap.get(item);
    }
}
