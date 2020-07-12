package checkout;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CheckoutTest {
    PricingRules testRules;

    @Before
    public void setUp() {
        this.testRules = new PricingRules(
                new ItemPrice("A", 50, new Discount(3, 130)),
                new ItemPrice("B", 30, new Discount(2, 45)),
                new ItemPrice("C", 20),
                new ItemPrice("D", 15)
        );
    }

    @Test
    public void no_scanned_items_result_in_0_total() {
        Checkout checkout = new Checkout(testRules);
        long total = checkout.total();
        assertEquals(0, total);

    }

    @Test
    public void one_A_scanned_results_in_50_total() {
        Checkout checkout = new Checkout(testRules);
        checkout.scan("A");

        long total = checkout.total();

        assertEquals(50, total);

    }

    @Test
    public void one_B_scanned_results_in_30_total() {
        Checkout checkout = new Checkout(testRules);
        checkout.scan("B");

        long total = checkout.total();

        assertEquals(30, total);

    }

    @Test
    public void AB_scanned_results_in_80_total() {
        Checkout checkout = new Checkout(testRules);
        checkout.scan("A");
        checkout.scan("B");

        long total = checkout.total();

        assertEquals(80, total);

    }

    @Test
    public void ABCD_scanned_results_in_115_total() {
        Checkout checkout = new Checkout(testRules);
        checkout.scan("A");
        checkout.scan("B");
        checkout.scan("C");
        checkout.scan("D");

        long total = checkout.total();

        assertEquals(115, total);
    }

    @Test
    public void AA_scanned_results_in_100_total() {
        Checkout checkout = new Checkout(testRules);
        checkout.scan("A");
        checkout.scan("A");

        long total = checkout.total();

        assertEquals(100, total);

    }

    @Test
    public void AAA_scanned_results_in_130_total() {
        Checkout checkout = new Checkout(testRules);
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");

        long total = checkout.total();

        assertEquals(130, total);

    }

    @Test
    public void AAABBD_scanned_results_in_190_total() {
        // GIVEN AAABBD
        Checkout checkout = new Checkout(testRules);
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("B");
        checkout.scan("B");
        checkout.scan("D");

        long total = checkout.total();

        assertEquals(190, total);

    }

    @Test
    public void DABABA_scanned_results_in_190_total() {
        // GIVEN DABABA
        Checkout checkout = new Checkout(testRules);
        checkout.scan("D");
        checkout.scan("A");
        checkout.scan("B");
        checkout.scan("A");
        checkout.scan("B");
        checkout.scan("A");

        long total = checkout.total();

        assertEquals(190, total);

    }

    @Test
    public void test_incremental() {
        Checkout checkout = new Checkout(testRules);
        assertEquals(0, checkout.total());

        checkout.scan("A");
        assertEquals(50, checkout.total());
        checkout.scan("B");
        assertEquals(80, checkout.total());
        checkout.scan("A");
        assertEquals(130, checkout.total());
        checkout.scan("A");
        assertEquals(160, checkout.total());
        checkout.scan("B");
        assertEquals(175, checkout.total());

    }
}
