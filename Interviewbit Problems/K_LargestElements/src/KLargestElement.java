import java.util.*;

class Solver {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> kLargestElements = new ArrayList<>();
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer value : A) {
            pq.offer(value);
        }
        for (int i = 0; i < B; i++) {
            kLargestElements.add(pq.poll());
        }
        return kLargestElements;
    }
}

public class KLargestElement {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(11);
        A.add(3);
        A.add(4);
        A.add(6);
        int B = 3;
        Solver solver = new Solver();
        System.out.println(solver.solve(A, B));
    }
}
