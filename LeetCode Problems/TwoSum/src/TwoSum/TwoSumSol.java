package TwoSum;

import java.util.*;

public class TwoSumSol {
    public static void main(String args[]) {
        solve();
    }

    public static void solve() {
//        Sol1 solver = new Sol1();
        Sol2 solver = new Sol2();
        Scanner sc = new Scanner(System.in);
        long testCases = sc.nextLong();
        for (long test = 0; test < testCases; test++) {
            int arraySize = sc.nextInt();
            int[] nums = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                nums[i] = sc.nextInt();
            }
            int target = sc.nextInt();
            int[] result = new int[2];
            result = solver.twoSum(nums, target);
            System.out.println(Arrays.toString(result));
        }
    }
}


class Sol2 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int j = 0;
        Map<Integer, Integer> numberIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int otherSum = target - nums[i];
            if (numberIndexMap.containsKey(otherSum)) {
                setResult(result, j, numberIndexMap, i, otherSum);
                break;
            } else {
                numberIndexMap.put(nums[i], i);
            }
        }
        return result;
    }

    private void setResult(int[] result, int j, Map<Integer, Integer> numberIndexMap, int i, int otherSum) {
        result[j] = numberIndexMap.get(otherSum);
        j++;
        result[j] = i;
    }
}


class Sol1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> countOfNumbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countOfNumbers.put(nums[i], 0);
        }
        for (int i = 0; i < nums.length; i++) {
            countOfNumbers.put(nums[i], countOfNumbers.get(nums[i]) + 1);
        }
        for (Integer key : countOfNumbers.keySet()) {
            Integer otherSum = target - key;
            if (countOfNumbers.containsKey(otherSum)) {
                if (otherSum.equals(key)) {
                    if (countOfNumbers.get(otherSum) > 1) {
                        setResult(nums, result, key, otherSum);
                        break;
                    }
                } else {
                    setResult(nums, result, key, otherSum);
                    break;
                }
            }
        }
        return result;
    }

    private void setResult(int[] nums, int[] result, Integer key, Integer otherSum) {
        int count = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key || nums[i] == otherSum) {
                result[j] = i;
                j++;
                count++;
                if (count == 2) {
                    break;
                }
            }
        }
    }
}
