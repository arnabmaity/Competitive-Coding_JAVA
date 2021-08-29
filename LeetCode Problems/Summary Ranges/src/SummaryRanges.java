import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums.length==0) {
            return result;
        }
        if (nums.length==1) {
            result.add(nums[0]+"");
            return result;
        }
        int startRange, endRange;
        startRange = nums[0];
        endRange = nums[0];
        for(int i=1;i<nums.length;i++) {
            int prev = nums[i-1];
            int curr = nums[i];
            if(curr == prev+1) {
                endRange = curr;
            }
            else {
                if(startRange==endRange) {
                    result.add(startRange+"");
                }
                else {
                    result.add(startRange+"->"+endRange+"");
                }
                startRange = curr;
                endRange = curr;
            }
        }
        if(startRange==endRange) {
            result.add(startRange+"");
        }
        else {
            result.add(startRange+"->"+endRange+"");
        }
        return result;

    }
}


public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4};
        Solution solution = new Solution();
        System.out.println(solution.summaryRanges(nums));
    }
}
