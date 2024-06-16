package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {


    private static int[] findCoordinates(int currVal, int n) {

        int r = n - (currVal - 1) / n - 1;
        int c = (currVal - 1) % n;

        if (r % 2 == n % 2) return new int[]{r, n - 1 - c};

        else return new int[]{r, c};
    }

    private static int snakeladder(int[][] board) {
        Queue<Integer> tracker = new LinkedList<>();
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        visited[n - 1][0] = true;
        tracker.add(1);
        int step = 0;
        int currVal = Integer.MIN_VALUE;
        int val = Integer.MIN_VALUE;
        while (!tracker.isEmpty()) {
            int elementLength = tracker.size();
            while (elementLength > 0) {
                currVal = tracker.poll();
                if (currVal == (n * n))
                    return step;
                for (int k = 1; k <= 6; k++) {
                    val = currVal + k;
                    if (val > (n * n))
                        break;
                    int[] coordinates = findCoordinates(val, n);
                    if (visited[coordinates[0]][coordinates[1]] == true)
                        continue;
                    else
                        visited[coordinates[0]][coordinates[1]] = true;
                    if (board[coordinates[0]][coordinates[1]] == -1)
                        tracker.add(val);
                    else
                        tracker.add(board[coordinates[0]][coordinates[1]]);
                }
                elementLength--;
            }
            step++;
        }

        return -1;
    }


    public static void main(String[] args) {
        int[][] board = new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };

        System.out.println(snakeladder(board));

    }
}
