import java.util.Arrays;

class Solve {
    public int[] solve(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] solve2(int[] nums) {
        int[] result = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[start]) >= Math.abs(nums[end])) {
                result[i] = (int) Math.pow(nums[start], 2);
                start++;
            } else {
                result[i] = (int) Math.pow(nums[end], 2);
                end--;
            }
        }
        return result;
    }
}


public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(new Solve().solve(nums));
    }
}
