package fibonacci;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {
    @Test
    public void n1_is_1() {
        Fibonacci fibonacci = new Fibonacci();
        int n = fibonacci.getNthNumber(1);
        Assert.assertEquals(1, n);
    }

    @Test
    public void n2_is_1() {
        Fibonacci fibonacci = new Fibonacci();
        int n = fibonacci.getNthNumber(2);
        Assert.assertEquals(1, n);
    }

    @Test
    public void n3_is_2() {
        Fibonacci fibonacci = new Fibonacci();
        int n = fibonacci.getNthNumber(3);
        Assert.assertEquals(2, n);
    }

    @Test
    public void n8_is_21() {
        Fibonacci fibonacci = new Fibonacci();
        int n = fibonacci.getNthNumber(8);
        Assert.assertEquals(21, n);
    }

    @Test
    public void n14_is_377() {
        Fibonacci fibonacci = new Fibonacci();
        int n = fibonacci.getNthNumber(14);
        Assert.assertEquals(377, n);
    }

    @Test(expected = IllegalArgumentException.class)
    public void n0_throws_exception() {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.getNthNumber(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative_N_throws_exception() {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.getNthNumber(-1);
    }
}
