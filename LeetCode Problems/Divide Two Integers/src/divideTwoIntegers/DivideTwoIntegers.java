package divideTwoIntegers;

import java.util.Scanner;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many testcases: ");
        long test = sc.nextLong();
        for (long t = 0; t < test; t++) {
            System.out.println("Enter Dividend and Divisor");
            int dividend = sc.nextInt();
            int divisor = sc.nextInt();
            Solver1 solver = new Solver1();
            System.out.println("Output : " + solver.divide(dividend, divisor));

        }
    }
}


class Solver1 {
    public int divide(int dividend, int divisor)
    {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int result = 0;
        int power = 32;
        long x = Math.abs((long)dividend);
        long y = Math.abs((long)divisor);

        while(x >= y)
        {
            while((y << power) > x)
            {
                power--;
            }
            x -= y << power;
            result += 1 << power;
        }
        return result * sign;
    }
}