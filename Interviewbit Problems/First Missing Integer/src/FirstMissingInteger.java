import java.util.ArrayList;

class Solution {
    public int solve(ArrayList<Integer> A) {
        Boolean isOnePresent = false;
        int n = A.size();
        for (int i = 0; i < n; i++) {
            if (A.get(i) == 1) {
                isOnePresent = true; // If 1 is not present then return 1
                continue;
            }
            if (!isInRange(A.get(i), n)) { // check whether the range of integers are not between 1 and n. If not replace with 1
                A.set(i, 1);
            }
        }
        if (!isOnePresent) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            int indexToSet = Math.abs(A.get(i)) - 1;
            int value = -Math.abs(A.get(Math.abs(A.get(i)) - 1));
            A.set(indexToSet, value); // Map each integer with index by setting its value to negative denoting for that index value is present in the list
        }
        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0) {
                return i+1; // If one positive comes then return index+1 since that will the first small positive integer
            }
        }
        return n+1; // If all are within range and no missing then return n+1 as the smallest positive integer
    }

    private boolean isInRange(Integer integer, int n) {
        if (integer >= 1 && integer <= n) {
            return true;
        }
        return false;
    }
}

public class FirstMissingInteger {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(4);
        A.add(-1);
        A.add(1);
        System.out.println(new Solution().solve(A));
    }
}
