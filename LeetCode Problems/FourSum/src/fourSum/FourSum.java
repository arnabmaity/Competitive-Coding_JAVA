package fourSum;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        System.out.println("Enter testcases");
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            System.out.println("Enter size of an array ");
            int size = sc.nextInt();
            System.out.println("Enter array integers ");
            int[] arrayInt = new int[size];
            for (int i = 0; i < size; i++) {
                arrayInt[i] = sc.nextInt();
            }
            System.out.println("Enter target value ");
            int target = sc.nextInt();
            System.out.println("Possible four sums array : " + solution.fourSum(arrayInt, target));
        }
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        Collections.sort(numsList);
        int index = 0;
        for (Integer number : numsList) {
            nums[index] = number;
            index++;
        }
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int left = j + 1;
                int right = size - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        int leftValue = nums[left];
                        while (left < size && leftValue == nums[left]) {
                            left++;
                        }
                        int rightVal = nums[right];
                        while (right > left && rightVal == nums[right]) {
                            right--;
                        }
                    } else {
                        if (sum > target) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
                while ((j + 1 < size) && (nums[j + 1] == nums[j])) {
                    j++;
                }
            }
            while ((i + 1 < size) && (nums[i + 1] == nums[i])) {
                i++;
            }
        }
        return result;
    }
}

