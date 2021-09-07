import java.util.Locale;

class Solution {
    public static String reverseWord(String str) {
        int start = 0;
        int end = str.length() - 1;
        char[] s = str.toCharArray();
        while (start < end) {
            char ch = s[start];
            s[start] = s[end];
            s[end] = ch;
            start++;
            end--;
        }
        str = "";
        for (int i = 0; i < s.length; i++) {
            str+=s[i];
        }
        return str;
    }

    public static String reverseWordRecursive(String str) {
        if(str.isEmpty()) {
            return "";
        }
        return reverseWordRecursive(str.substring(1)) + str.charAt(0);
    }

}

public class ReverseAString {
    public static void main(String[] args) {
        String str = "Geeks";
        System.out.println(new Solution().reverseWord(str));

    }
}
