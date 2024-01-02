import java.util.* ;
import java.io.*;
public class Maximum_Path_Sum_in_the_matrix {

    //Tabulation
    public class Solution {
        public static int getMaxPathSum(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            int[][] dp = new int[n][m];
            for(int i = 0 ; i<=m-1 ; i++)
            {
                dp[0][i] = matrix[0][i];
            }
            for(int i = 1 ; i<=n-1 ; i++)
            {
                for(int j = 0 ; j<=m-1 ; j++)
                {
                    int up = Integer.MIN_VALUE;
                    int up_l = Integer.MIN_VALUE;
                    int up_r = Integer.MIN_VALUE;
                    up = matrix[i][j] + dp[i-1][j];
                    if(j-1>=0)
                    {
                        up_l = matrix[i][j] + dp[i-1][j-1];
                    }
                    if(j+1<=m-1)
                    {
                        up_r = matrix[i][j] + dp[i-1][j+1];
                    }
                    dp[i][j] = Math.max(up, Math.max(up_l , up_r));
                }
            }
            int maxi = dp[n-1][0];
            for(int i = 1 ; i<=m-1 ; i++)
            {
                if(maxi<dp[n-1][i])
                {
                    maxi = dp[n-1][i];
                }
            }
            return maxi;
        }
    }


// dp Memoization
// public class Solution {
// 	public static int getMaxPathSum(int[][] matrix) {
// 		int n = matrix.length;
// 		int m = matrix[0].length;
// 		int[][] dp = new int[n][m];
// 		for(int[] rows: dp)
// 		{
// 			Arrays.fill(rows , -1);
// 		}
// 		int max = Integer.MIN_VALUE;
// 		for(int i = 0 ; i<=m-1 ; i++)
// 		{
// 			int a = fun(matrix , n , m , 0 , i , dp);
// 			if(max<=a)
// 			{
// 				max = a;
// 			}
// 		}
// 		return max;
// 	}

// 	public static int fun(int[][] matrix , int n , int m , int r , int c , int[][] dp)
// 	{
// 		if(r>=n || c>=m)
// 		{
// 			return (int)-1e5;

// 		}
// 		if(c<0)
// 		{
// 			return (int)-1e5;

// 		}
// 		if(r==n-1)
// 		{
// 			return matrix[r][c];
// 		}
// 		if(dp[r][c] != -1)
// 		{
// 			return dp[r][c];
// 		}
// 		int down = matrix[r][c] + fun(matrix , n , m , r+1 , c , dp);
// 		int down_l = matrix[r][c] + fun(matrix , n , n , r+1 , c-1 , dp);
// 		int down_r = matrix[r][c] + fun(matrix , n , m , r+1 , c+1 , dp);
// 		int maximum = Math.max(down , Math.max(down_l, down_r));
// 		return dp[r][c] = maximum;
// 	}
// }



// Recursion
// public class Solution {
// 	public static int getMaxPathSum(int[][] matrix) {
// 		int n = matrix.length;
// 		int m = matrix[0].length;
// 		int max = Integer.MIN_VALUE;
// 		for(int i = 0 ; i<=m-1 ; i++)
// 		{
// 			int a = fun(matrix , n , m , 0 , i);
// 			if(max<=a)
// 			{
// 				max = a;
// 			}
// 		}
// 		return max;
// 	}

// 	public static int fun(int[][] matrix , int n , int m , int r , int c)
// 	{
// 		if(r>=n || c>=m)
// 		{
// 			return (int)-1e5;

// 		}
// 		if(c<0)
// 		{
// 			return (int)-1e5;

// 		}
// 		if(r==n-1)
// 		{
// 			return matrix[r][c];
// 		}
// 		int down = matrix[r][c] + fun(matrix , n , m , r+1 , c);
// 		int down_l = matrix[r][c] + fun(matrix , n , n , r+1 , c-1);
// 		int down_r = matrix[r][c] + fun(matrix , n , m , r+1 , c+1);
// 		int maximum = Math.max(down , Math.max(down_l, down_r));
// 		return maximum;
// 	}
// }

}
