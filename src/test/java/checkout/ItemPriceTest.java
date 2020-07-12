package checkout;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemPriceTest {
    @Test
    public void price_50_count_5_calculates_250() {
        ItemPrice itemPrice = new ItemPrice(50);

        long totalPrice = itemPrice.calculate(5);

        assertEquals(250, totalPrice);
    }

    @Test
    public void price_15_count_3_calculates_45() {
        ItemPrice itemPrice = new ItemPrice(15);

        long totalPrice = itemPrice.calculate(3);

        assertEquals(45, totalPrice);
    }

    @Test
    public void price_20_count_3_calculates_60() {
        ItemPrice itemPrice = new ItemPrice(20);

        long totalPrice = itemPrice.calculate(3);

        assertEquals(60, totalPrice);
    }

    @Test
    public void price_0_count_3_calculates_0() {
        ItemPrice itemPrice = new ItemPrice(0);

        long totalPrice = itemPrice.calculate(3);

        assertEquals(0, totalPrice);
    }

    @Test
    public void price_5_count_0_calculates_0() {
        ItemPrice itemPrice = new ItemPrice(5);

        long totalPrice = itemPrice.calculate(0);

        assertEquals(0, totalPrice);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative_price_throws_IAE() {
        new ItemPrice(-42);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative_count_throws_IAE() {
        ItemPrice itemPrice = new ItemPrice(42);
        itemPrice.calculate(-15);
    }

    @Test
    public void item_price_with_name_returns_name_from_getter() {
        ItemPrice itemPrice = new ItemPrice("A", 42);
        String name = itemPrice.getName();
        assertEquals("A", name);
    }

    @Test
    public void item_with_no_name_returns_empty_string_from_getter() {
        ItemPrice itemPrice = new ItemPrice(42);
        String name = itemPrice.getName();
        assertEquals("", name);
    }

    @Test
    public void item_can_have_discount() {
        ItemPrice itemPrice = new ItemPrice("A", 50, new Discount(3, 130));
        long discountedPrice = itemPrice.calculate(3);
        assertEquals(130, discountedPrice);
    }

    @Test
    public void item_can_have_discount_and_one_more() {
        ItemPrice itemPrice = new ItemPrice("A", 50, new Discount(3, 130));
        long discountedPrice = itemPrice.calculate(4);
        assertEquals(180, discountedPrice);
    }
}