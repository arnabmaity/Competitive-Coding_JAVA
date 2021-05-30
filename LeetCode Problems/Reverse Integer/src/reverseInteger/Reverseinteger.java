package reverseInteger;

import java.util.Scanner;

public class Reverseinteger {
    public static void main(String args[]) {
        solve();
    }
    public static void solve() {
//        Solver1 solver = new Solver1();
        Solver2 solver = new Solver2();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter testcases");
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            System.out.println("Enter an integer ");
            int x = sc.nextInt();
            System.out.println("Reversed Integer : " + solver.reverse(x));
        }
    }
}

class Solver2 {
    public int reverse(int x) {
        if (x >= 0 && x < 10) {
            return x;
        }
        if (x < 0 && x > -10) {
            return x;
        }
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = x * (-1);
        }
        long reverseLong = 0;
        reverseLong = getReverseLong(x, reverseLong);
        if(negative) {
            reverseLong = reverseLong * (-1);
        }
        if (reverseLong>Integer.MAX_VALUE || reverseLong<Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reverseLong;
    }

    private long getReverseLong(int x, long reverseLong) {
        long pop = 0;
        while (x > 0) {
            pop = x % 10;
            reverseLong = (reverseLong *10)+ pop;
            x = x /10;
        }
        return reverseLong;
    }
}


class Solver1 {
    public int reverse(int x) {
        String num = x + "";
        String rev = "";
        boolean negative = false;
        int n = num.length();
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '-') {
                rev = rev + num.charAt(i);
                negative = true;
            } else {
                if (negative) {
                    rev = rev + num.charAt(n - i);
                } else {
                    rev = rev + num.charAt(n - i - 1);
                }
            }
        }
        int reverseInt;
        try {
            reverseInt = Integer.parseInt(rev);
        } catch (NumberFormatException e) {
            return 0;
        }
        return reverseInt;
    }
}
