class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        for (int i = n, k = 0, firstPointer=0; i < 2 * n; i++,firstPointer++,k+=2) {
            int a = nums[firstPointer];
            int b = nums[i];
            res[k] = a;
            res[k + 1] = b;
        }
        return nums;
    }
}

public class ShuffleArray {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        System.out.println(new Solution().shuffle(nums, (nums.length) / 2));
    }
}
