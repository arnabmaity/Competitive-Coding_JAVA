class Solver {
    public void solve(int[] nums1, int m, int[] nums2, int n) {
        int start1 = 0;
        int start2 = 0;
        int k =0;
        int[] sortedMerge = new int[m+n];
        while(start1<m && start2<n) {
            if(nums1[start1]<=nums2[start2]) {
                sortedMerge[k] = nums1[start1];
                start1++;
                k++;
            }
            else {
                sortedMerge[k] = nums2[start2];
                start2++;
                k++;
            }
        }
        while(start1<m) {
            sortedMerge[k] = nums1[start1];
            start1++;
            k++;
        }
        while(start2<n) {
            sortedMerge[k] = nums2[start2];
            start2++;
            k++;
        }
        for(int i=0;i<m+n;i++) {
            nums1[i] = sortedMerge[i];
        }
    }
}

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        new Solver().solve(nums1, m, nums2, n);
        for(int i=0;i<m+n;i++) {
            System.out.print(nums1[i] + " ");
        }
    }
}
