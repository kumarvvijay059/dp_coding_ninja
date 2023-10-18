import java.util.* ;
import java.io.*;

public class Minimum_Path_Sum {

    // Memoization dp
    public class Solution {
        public static int minSumPath(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] dp = new int[n][m];
            for(int[] rows : dp)
            {
                Arrays.fill(rows , -1);
            }
            return (int)pathSum(grid , n , m , 0 , 0 , dp);
        }

        public static long pathSum(int[][] grid, int n, int m, int r, int c , int[][] dp)
        {
            if (r == n - 1 && c == m - 1)
            {
                return grid[r][c];
            }
            if (r >= n || c >= m)
            {
                return Integer.MAX_VALUE;
            }
            if(dp[r][c]!=-1)
            {
                return dp[r][c];
            }
            long path_d = grid[r][c] + pathSum(grid, n, m, r + 1, c , dp);
            long path_r = grid[r][c] + pathSum(grid, n, m, r, c + 1 , dp);
            long min = Math.min(path_d, path_r);
            return dp[r][c] = (int)min;
        }
    }

// Recurrsion
// public class Solution {
//     public static int minSumPath(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//     	return (int)pathSum(grid , n , m , 0 , 0);
//     }

//     public static long pathSum(int[][] grid, int n, int m, int r, int c)
//     {
//         if (r == n - 1 && c == m - 1)
//         {
//             return grid[r][c];
//         }
//         if (r >= n || c >= m)
//         {
//             return Integer.MAX_VALUE;
//         }
//         long path_d = grid[r][c] + pathSum(grid, n, m, r + 1, c);
//         long path_r = grid[r][c] + pathSum(grid, n, m, r, c + 1);
//         long min = Math.min(path_d, path_r);
//         return min;
//     }
// }


}
