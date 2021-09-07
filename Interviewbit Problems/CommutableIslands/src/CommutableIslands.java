import java.util.*;

class Solver {
    public int getMinimalCost(int A, ArrayList<ArrayList<Integer>> B) {
        Collections.sort(B, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(2).compareTo(o2.get(2));
            }
        });
        int minimalCost = 0;
        int minimalEdgesCount = 0;
        int[] parent = new int[A + 1];
        for (int i = 0; i <= A; i++) {
            parent[i] = i;
        }
        for (ArrayList<Integer> bridge : B) {
            if (minimalEdgesCount == (A - 1)) {
                break;
            }
            int srcParent = findParent(bridge.get(0), parent);
            int destParent = findParent(bridge.get(1), parent);

            if(srcParent!=destParent) {
                minimalCost+=bridge.get(2);
                minimalEdgesCount++;
                parent[destParent] = srcParent;
            }
        }
        return minimalCost;
    }

    // Using disjoint sets to detect cycle
    private int findParent(Integer vertex, int[] parent) {
        if(parent[vertex] ==  vertex) {
            return vertex;
        }
        return findParent(parent[vertex], parent);
    }
}

public class CommutableIslands {
    public static void main(String[] args) {
        int A = 4;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        // Set Bridges
        setBridges(B, 1, 2, 1);
        setBridges(B, 2, 3, 4);
        setBridges(B, 1, 4, 3);
        setBridges(B, 4, 3, 2);
        setBridges(B, 1, 3, 10);

        for (ArrayList<Integer> bridges : B) {
            for (Integer values : bridges) {
                System.out.print(values + " ");
            }
            System.out.println();
        }
        Solver solve = new Solver();
        System.out.println(solve.getMinimalCost(A, B));
    }

    private static void setBridges(ArrayList<ArrayList<Integer>> b, int island1, int island2, int costOfBridge) {
        ArrayList<Integer> bridges = new ArrayList<>();
        bridges.add(island1);
        bridges.add(island2);
        bridges.add(costOfBridge);
        b.add(bridges);
    }
}
