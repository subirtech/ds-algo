package com.recursion;


/**\
 * only right and downward traverse is allowed.
 * complexity O(2Power(m*n))
 */

public class CountPathInMaze {
    public static int countPath(int startX, int startY, int endX,int endY)
    {
        if(startX==endX || startY==endY)
            return 0;
        if((startX==endX-1) && (startY==endY-1))
            return 1;

        int downCount=countPath(startX+1, startY, endX, endY);
        int rightCount=countPath(startX, startY+1, endX, endY);

        return downCount+rightCount;
    }

    public static void main(String[] args) {
        int m=3, n=3;
        System.out.println(countPath(0,0,m,n));
    }
}
