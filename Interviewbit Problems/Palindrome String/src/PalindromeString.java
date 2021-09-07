class Solver {
    public int isPalindromic(String A) {
        int isPalindrome = 1;
        int startPointer = 0;
        int lengthOfString = A.length();
        int endPointer = lengthOfString - 1;
        for (; startPointer < endPointer; startPointer++, endPointer--) {
            char startCharacter = A.charAt(startPointer);
            char endCharacter = A.charAt(endPointer);
            // Traverse through those character which are not alphanumeric from left side
            while (!Character.isLetterOrDigit(startCharacter) && startPointer < endPointer) {
                startPointer++;
                startCharacter = A.charAt(startPointer);
            }
            // Traverse through those character which are not alphanumeric from right side
            while (!Character.isLetterOrDigit(endCharacter) && endPointer > startPointer) {
                endPointer--;
                endCharacter = A.charAt(endPointer);
            }
            if (startPointer >= endPointer) {
                break;
            }
            // check if characters are palindromic or not
            if (Character.toLowerCase(startCharacter) != Character.toLowerCase(endCharacter)) {
                isPalindrome = 0;
                break;
            }
        }
        return isPalindrome;
    }
}

public class PalindromeString {
    public static void main(String[] args) {
        String A = "A man, a plan, a canal: Panama";
        Solver solver = new Solver();
        System.out.println(solver.isPalindromic(A));
    }
}
