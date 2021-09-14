import java.util.ArrayList;

class Solver {
    public int solve(ArrayList<Integer> A, int B) {
        if(B>A.size()) {
            return -1;
        }
        int start  = 0;
        int end = 0;
        for(Integer val : A) {
            end+=val;
            start = Math.max(start, val);
        }
        int result = -1;
        while(start<=end) {
            int mid = (start+end)>>1;
            if(isValid(A, B, mid)) {
                result = mid;
                end = mid-1;
            }
            else {
                start = mid + 1;
            }
        }
        return result;
    }

    private boolean isValid(ArrayList<Integer> A, int B, int mid) {
        int readers = 1;
        int currVal = 0;
        for (Integer val : A) {
            if(currVal+val>mid) {
                readers++;
                currVal = val;
                if(readers>B) {
                    return false;
                }
            }
            else {
                currVal+=val;
            }
        }
        return true;
    }
}

public class AllocateBooks {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(12);
        A.add(34);
        A.add(67);
        A.add(90);
        int B = 2;
        System.out.println(new Solver().solve(A, B));
    }
}
