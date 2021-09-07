import java.util.Collections;

class ReverseString {
    public void reverse(char[] s, int start, int end) {
        if (start >= end) {
            return;
        }
        reverse(s, start + 1, end - 1);
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
    }

    public String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}

public class ReverseCharArray {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o' };
        // Iterative
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        System.out.println(s);

        // Recursive
        ReverseString reverseString = new ReverseString();
        reverseString.reverse(s, 0, s.length - 1);
        System.out.println(s);

        String str = "Bazinga";
        String reverseStr = reverseString.reverseString(str);
        System.out.println(reverseStr);
    }
}