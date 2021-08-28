import java.util.*;

class Solution {
    public int maxp3(ArrayList<Integer> A) {
        Collections.sort(A);
        Integer product=1;
        if(A.size()<=3) {
            for(Integer value : A) {
                product*=value;
            }
        }
        else {
            Integer highestProductOfTwo = A.get(0)*A.get(1)*A.get(A.size()-1);
            Integer highestPositiveProduct = A.get(A.size()-1)*A.get(A.size()-2)*A.get(A.size()-3);
            product = Math.max(highestProductOfTwo, highestPositiveProduct);
        }
        return product;
    }
}


public class HighestProduct {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        Solution solution = new Solution();
        System.out.println(solution.maxp3(A));
    }
}
