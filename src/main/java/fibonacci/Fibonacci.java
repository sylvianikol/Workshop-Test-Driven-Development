package fibonacci;

public class Fibonacci {

    public int getNthNumber(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        if (n <= 2) return 1;

        int first = 1;
        int second = 1;

        for (int i = 3; i <= n; ++i) {
            int sum = first + second;
            first = second;
            second = sum;
        }

        return second;
    }
}
