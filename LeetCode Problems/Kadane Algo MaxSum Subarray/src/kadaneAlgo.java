class Solver {
    public int solve(int[] nums) {
        int currSum = 0;
        int overallMaxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currSum = Math.max(nums[i], nums[i] + currSum); // Choice of taking just the value or let the sum flow
            overallMaxSum = Math.max(currSum, overallMaxSum); // choice between local max sum and overall max sum
        }
        return overallMaxSum;
    }
}

public class kadaneAlgo {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solver().solve(nums));
    }
}
