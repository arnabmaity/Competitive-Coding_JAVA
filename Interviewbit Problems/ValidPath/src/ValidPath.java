import java.util.*;


class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solver {

    static int[] rowOffset = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] colOffset = {-1, 1, 0, -1, 1, 0, 1, -1};


    public boolean isValidPath(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F, int row, int col, int[][] visited, int[][] blocked) {

        if (blocked[0][0] == -1 || blocked[A][B] == -1) {
            return false;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row, col));
        visited[row][col] = 1;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int lastVisitedRow = p.x;
            int lastVisitedCol = p.y;
            for (int i = 0; i < 8; i++) {
                int newRow = lastVisitedRow + rowOffset[i];
                int newCol = lastVisitedCol + colOffset[i];
                if (canMove(newRow, newCol, A, B, blocked) && visited[newRow][newCol] == 0) {
                    visited[newRow][newCol] = 1;
                    queue.offer(new Pair(newRow, newCol));
                }
            }
        }

        if (visited[A][B] == 1) {
            return true;
        }
        return false;
    }

    private boolean canMove(int newRow, int newCol, int a, int b, int[][] blocked) {
        if (newRow >= 0 && newRow <= a && newCol >= 0 && newCol <= b && blocked[newRow][newCol] != -1) {
            return true;
        } else {
            return false;
        }
    }

    public void getBlocked(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F, int[][] blocked) {
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int k = 0; k < C; k++) {
                    if (Math.sqrt(Math.pow(E.get(k) - i, 2) + Math.pow(F.get(k) - j, 2)) <= D) {
                        blocked[i][j] = -1;
                    }
                }
            }
        }
    }
}


public class ValidPath {
    public static void main(String[] args) {
        int A = 2;
        int B = 3;
        int C = 1;
        int D = 1;
        ArrayList<Integer> E = new ArrayList<>();
        ArrayList<Integer> F = new ArrayList<>();
        E.add(2);
        F.add(3);
        int row = 0, col = 0;
        int[][] visited = new int[A + 1][B + 1];
        int[][] blocked = new int[A + 1][B + 1];
        Solver solve = new Solver();
        solve.getBlocked(A, B, C, D, E, F, blocked);
        System.out.println(solve.isValidPath(A, B, C, D, E, F, row, col, visited, blocked));
    }
}
