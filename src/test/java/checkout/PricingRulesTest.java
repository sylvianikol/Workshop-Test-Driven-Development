package checkout;

import org.junit.Test;

import static org.junit.Assert.*;

public class PricingRulesTest {

    @Test
    public void instantiate_rules_with_one_item_price() {
        PricingRules pricingRules = new PricingRules(new ItemPrice(42));
    }

    @Test(expected = ItemNotFoundException.class)
    public void empty_rules_throws_item_not_found_ex_when_asked_for_price() {
        PricingRules pricingRules = new PricingRules();
        pricingRules.getPriceRules("A");
    }

    @Test
    public void pricing_rule_with_rule_A_returns_rule_from_getPriceRules() {
        PricingRules pricingRules = new PricingRules(new ItemPrice("A", 42));
        ItemPrice itemPrice = pricingRules.getPriceRules("A");
        assertEquals(new ItemPrice("A", 42), itemPrice);

    }

    @Test
    public void pricing_rule_with_rule_A_and_rule_B_returns_rule_from_getPriceRules() {
        PricingRules pricingRules = new PricingRules(
                new ItemPrice("A", 42),
                new ItemPrice("B", 42)
        );

        ItemPrice itemPriceA = pricingRules.getPriceRules("A");
        ItemPrice itemPriceB = pricingRules.getPriceRules("B");

        assertEquals(new ItemPrice("A", 42), itemPriceA);
        assertEquals(new ItemPrice("B", 42), itemPriceB);

    }
}