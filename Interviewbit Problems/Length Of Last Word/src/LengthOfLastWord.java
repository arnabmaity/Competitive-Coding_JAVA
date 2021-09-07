class Solver {
    public int solve(final String A) {
        String[] words = A.split(" ");
        if(words.length==0) {
            return 0;
        }
        return words[words.length-1].length();
    }
}

public class LengthOfLastWord {
    public static void main(String[] args) {
        String A;
        A = "Hello World";
        System.out.println(new Solver().solve(A));
    }
}
