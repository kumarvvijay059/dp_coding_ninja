import java.util.* ;
import java.io.*;
public class ChocolatePickup {


    // dp memoization
    public class Solution {
        public static int maximumChocolates(int r, int c, int[][] grid) {
            int[][][] dp = new int[r][c][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }
            return fun(grid , r , c , 0 , 0 , c-1 , dp);
        }

        public static int fun(int[][] grid , int r , int c , int row , int col1 , int col2 ,int[][][] dp)
        {
            if(col1>=c || col1<0 || col2>=c || col2<0)
            {
                return (int)-1e5;
            }
            if(row==r-1)
            {
                if(col1==col2)
                {
                    return grid[row][col1];
                }
                else
                {
                    return grid[row][col1] + grid[row][col2];
                }
            }
            if(dp[row][col1][col2] != -1)
            {
                return dp[row][col1][col2];
            }
            int max = 0;
            for(int i = -1 ; i<=1 ; i++)
            {
                for(int j = -1 ; j<=1 ; j++)
                {
                    int maxi;
                    if(col1==col2)
                    {
                        maxi = grid[row][col1];
                    }
                    else
                    {
                        maxi = grid[row][col1] + grid[row][col2] + fun(grid , r , c , row+1 , col1+i , col2+j , dp);
                    }
                    if(max<maxi)
                    {
                        max = maxi;
                    }
                }
            }
            return dp[row][col1][col2] = max;
        }
    }


// Recursion
// public class Solution {
// 	public static int maximumChocolates(int r, int c, int[][] grid) {
// 		return fun(grid , r , c , 0 , 0 , c-1);
// 	}

// 	public static int fun(int[][] grid , int r , int c , int row , int col1 , int col2)
// 	{
// 		if(col1>=c || col1<0 || col2>=c || col2<0)
// 		{
// 			return (int)-1e5;
// 		}
// 		if(row==r-1)
// 		{
// 			if(col1==col2)
// 			{
// 				return grid[row][col1];
// 			}
// 			else
// 			{
// 				return grid[row][col1] + grid[row][col2];
// 			}
// 		}
// 		int max = 0;
// 		for(int i = -1 ; i<=1 ; i++)
// 		{
// 			for(int j = -1 ; j<=1 ; j++)
// 			{
// 				int maxi;
// 				if(col1==col2)
// 				{
// 					maxi = grid[row][col1];
// 				}
// 				else
// 				{
// 					maxi = grid[row][col1] + grid[row][col2] + fun(grid , r , c , row+1 , col1+i , col2+j);
// 				}
// 				if(max<maxi)
// 				{
// 					max = maxi;
// 				}
// 			}
// 		}
// 		return max;
// 	}
// }
}
