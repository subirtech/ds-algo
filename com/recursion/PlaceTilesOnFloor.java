package com.recursion;

/**
 * Place tiles of size 1*m in a floor of size n*m.
 */
public class PlaceTilesOnFloor {
    public static int placeTiles(int n, int m) {
        if (n < m)
            return 1;
        else if (n == m)
            return 2;

        //horizontal
        int horizontalCount = placeTiles(n - 1, m);

        //Vertical
        int verticalCount = placeTiles(n - m, m);
        return horizontalCount + verticalCount;

    }

    public static void main(String[] args) {

        System.out.println(placeTiles(4,2));

    }
}
