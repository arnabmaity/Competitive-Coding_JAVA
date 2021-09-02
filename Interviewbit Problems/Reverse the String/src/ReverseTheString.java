import java.util.*;

class Solver {
    public String solve(String A) {
        String[] words = A.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        String reverseString = "";
        for (int i = words.length - 1; i >= 0; i--) {
            reverseString = reverseString + words[i].trim() + "";
            if (i != 0) {
                reverseString+=" ";
            }
        }
        return reverseString;
    }
}

public class ReverseTheString {
    public static void main(String[] args) {
//        String A = "fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq";
        String A = "       fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq                 ";
        Solver solver = new Solver();
        System.out.println(solver.solve(A));
    }
}
