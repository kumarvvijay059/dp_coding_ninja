import java.util.* ;
import java.io.*;
public class Unique_Paths {
    
    public class Solution {
        public static int uniquePaths(int m, int n) {
            int dp[][] = new int[m][n];
            dp[0][0] = 0;
            for(int i = 0 ; i<m ; i++)
            {
                for(int j = 0 ; j<n ; j++)
                {
                    if(i==0 && j==0)
                    {
                        dp[0][0] = 1;
                    }
                    else
                    {
                        int a = 0;
                        int b = 0;
                        if(i>0)
                        {
                            a = dp[i-1][j];
                        }
                        if(j>0)
                        {
                            b = dp[i][j-1];
                        }
                        dp[i][j] = a+b;
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }

// Tabulation
// public class Solution {
// 	public static int uniquePaths(int m, int n) {
// 		int dp[][] = new int[m][n];
// 		dp[0][0] = 0;
// 		for(int i = 0 ; i<m ; i++)
// 		{
// 			for(int j = 0 ; j<n ; j++)
// 			{
// 				if(i==0 && j==0)
// 				{
// 					dp[0][0] = 1;
// 				}
// 				else
// 				{
// 					int a = 0;
// 					int b = 0;
// 					if(i>0)
// 					{
// 						a = dp[i-1][j];
// 					}
// 					if(j>0)
// 					{
// 						b = dp[i][j-1];
// 					}
// 					dp[i][j] = a+b;
// 				}
// 			}
// 		}
// 		return dp[m-1][n-1];
// 	}
// }

// Memoization
// public class Solution {
// 	public static int uniquePaths(int m, int n) {
// 		int dp[][] = new int[m][n];
// 		for(int[] row : dp)
// 		{
// 			Arrays.fill(row , -1);
// 		}
// 		return findPath(m , n , 0 , 0 , dp);
// 	}

// 	public static int findPath(int m , int n  , int r , int c , int[][] dp)
// 	{
// 		if(r==m-1 && c==n-1)
// 		{
// 			return 1;
// 		}
// 		if(r>=m || c>=n)
// 		{
// 			return 0;
// 		}
// 		if(dp[r][c]!=-1)
// 		{
// 			return dp[r][c];
// 		}
// 		int right = findPath(m , n , r , c+1 , dp);
// 		int left = findPath(m , n , r+1 , c , dp);
// 		return dp[r][c] = right+left;
// 	}
// }

// Recursion
// public class Solution {
// 	public static int uniquePaths(int m, int n) {
// 		return findPath(m , n , 0 , 0);
// 	}

// 	public static int findPath(int m , int n  , int r , int c)
// 	{
// 		if(r==m-1 && c==n-1)
// 		{
// 			return 1;
// 		}
// 		if(r>=m || c>=n)
// 		{
// 			return 0;
// 		}
// 		int right = findPath(m , n , r , c+1);
// 		int left = findPath(m , n , r+1 , c);
// 		return right+left;
// 	}
// }
}
