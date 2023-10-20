import java.util.* ;
import java.io.*;

public class Triangle {
    
    //Memoization
    public class Solution {
        public static int minimumPathSum(int[][] triangle, int n) {
            int dp[][] = new int[n][n];
            for(int rows[] : dp)
            {
                Arrays.fill(rows , -1);
            }
            return (int)pathSum(triangle , n , 0 , 0 , dp);
        }

        public static long pathSum(int[][] triangle , int n , int r , int c , int[][] dp)
        {
            if(r == n-1)
            {
                return triangle[r][c];
            }
            if(r>=n || c>r)
            {
                return Integer.MAX_VALUE;
            }
            if(dp[r][c]!=-1)
            {
                return dp[r][c];
            }
            long down = triangle[r][c] + pathSum(triangle , n , r+1 , c , dp);
            long down_left = triangle[r][c] + pathSum(triangle , n , r+1 , c+1 , dp);
            long min = Math.min(down , down_left);
            return dp[r][c] = (int)min;
        }
    }

// Recursion
// public class Solution {
//     public static int minimumPathSum(int[][] triangle, int n) {
//         return (int)pathSum(triangle , n , 0 , 0);
//     }

//     public static long pathSum(int[][] triangle , int n , int r , int c)
//     {
//         if(r == n-1)
//         {
//             return triangle[r][c];
//         }
//         if(r>=n || c>r)
//         {
//             return Integer.MAX_VALUE;
//         }
//         long down = triangle[r][c] + pathSum(triangle , n , r+1 , c);
//         long down_left = triangle[r][c] + pathSum(triangle , n , r+1 , c+1);
//         long min = Math.min(down , down_left);
//         return min;
//     }
// }
}
