class Solver {
    public void solve(int[] nums, int k) {
        int[] result = new int[nums.length];
        if (k % nums.length == 0) {
            return;
        }
        int remainder = k % nums.length;
        int index = 0;
        for (int i = (nums.length - remainder); i < nums.length; i++) {
            result[index] = nums[i];
            index++;
        }
        for (int i = 0; i < (nums.length - remainder); i++) {
            result[index] = nums[i];
            index++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public void solve2(int[] nums, int k) {
        int remainder = k % nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, remainder - 1);
        reverseArray(nums, remainder, nums.length - 1);
    }

    private void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 3;
        new Solver().solve(nums, k);
    }
}
