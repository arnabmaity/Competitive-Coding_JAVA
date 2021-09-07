import java.util.*;

class Solver {
    public String solve(String A, int B) {
        String result = "";
        if(B==1) {
            return result;
        }
        int lengthOfString = A.length();
        Stack<Pair> stack = new Stack<>();
        int counter = 0;
        for (int i=0;i<lengthOfString;i++) {
            // if stack is empty then simply add the
            // character with count 1 else check if
            // character is same as top of stack
            if(stack.size()==0) {
                stack.push(new Pair(A.charAt(i), 1));
            }
            else {
                Pair p = stack.peek();
                counter = p.count;
                // // if character at top of stack is same as
                // current character and also previous character in the string increase the number of
                // repetitions in the top of stack by 1
                if (A.charAt(i)==p.ch && A.charAt(i)==A.charAt(i-1)) {
                    stack.pop();
                    counter++;
                    p.count = counter;
                    if(counter==B) {
                        continue; // since that character is already removed from stack its taken care of.
                    }
                    else {
                        stack.push(new Pair(A.charAt(i), counter)); // push the repeated character with new count.
                    }
                }
                else {
                    stack.push(new Pair(A.charAt(i), 1));
                }
            }
        }

        // iterate through the stack
        // Use string(int,char) in order to replicate the
        // character multiple times and convert into string
        // then add in front of output string
        while(stack.size()>0) {
            Pair p = stack.peek();
            char ch = p.ch;
            int cnt = p.count;
            while(cnt>0) {
                result = ch + result;
                cnt--;
            }
            stack.pop();
        }
        return result;
    }
}

class Pair {
    char ch;
    int count;
    // pair of count of a character which is consecutive
    Pair (char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

public class RemoveConsecutiveCharacters {
    public static void main(String[] args) {
        String A = "abcddcbsa";
        int B = 2;
        Solver solver = new Solver();
        System.out.println(solver.solve(A, B));
    }
}
