import java.util.ArrayList;
import java.util.*;
public class Unique_Paths_II {

    // most optimized
    public class Solution {

        static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
            int prev[] = new int[m];
            Arrays.fill(prev , 0);
            int mod = 1000000007;
            for(int i = 0 ; i<n ; i++)
            {
                int curr[] = new int[m];
                Arrays.fill(curr , 0);
                for(int j = 0 ; j<m ; j++)
                {
                    if(mat.get(i).get(j)==-1)
                    {
                        curr[j] = 0;
                    }
                    else if(i==0 && j==0)
                    {
                        curr[j] = 1;
                    }
                    else
                    {
                        int a = 0;
                        int b = 0;
                        if(i>0)
                        {
                            a = prev[j];
                        }
                        if(j>0)
                        {
                            b = curr[j-1];
                        }
                        curr[j] = (a+b)%mod;
                    }
                }
                prev = curr;
            }
            return prev[m-1];
        }
    }

// Tabulation
// public class Solution {
//     static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
//         int dp[][] = new int[n][m];
//         int mod = 1000000007;
// 		for(int i = 0 ; i<n ; i++)
// 		{
// 			for(int j = 0 ; j<m ; j++)
// 			{
//                 if(mat.get(i).get(j)==-1)
//                 {
//                     dp[i][j] = 0;
//                 }
// 				else if(i==0 && j==0)
// 				{
// 					dp[i][j] = 1;
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
// 					dp[i][j] = (a+b)%mod;
// 				}
// 			}
// 		}
// 		return dp[n-1][m-1];
//     }
// }

// Memoization
// public class Solution {
//     static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
//         int dp[][] = new int[n][m];
//         for(int[] row : dp)
//         {
//             Arrays.fill(row , -1);
//         }
//         return maze(mat , n , m , 0 , 0 , dp);
//     }

//     public static int maze(ArrayList<ArrayList<Integer>> mat , int n , int m , int r , int c , int[][] dp)
//     {
//         int mod = 1000000007;
//         if(r<n && c<m && mat.get(r).get(c)==-1)
//         {
//             return 0;
//         }
//         if(r==n-1 && c==m-1)
//         {
//             return 1;
//         }
//         if(r>=n || c>=m)
//         {
//             return 0;
//         }
//         if(dp[r][c]!=-1)
//         {
//             return dp[r][c];
//         }
//         int right = maze(mat , n , m , r+1 , c , dp);
//         int down = maze(mat , n , m , r , c+1 , dp);
//         return dp[r][c] = (right+down)%mod;
//     }
// }

// Recursion
// public class Solution {
//     static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
//         return maze(mat , n , m , 0 , 0);
//     }

//     public static int maze(ArrayList<ArrayList<Integer>> mat , int n , int m , int r , int c)
//     {
//         int mod = 1000000007;
//         if(r<n && c<m && mat.get(r).get(c)==-1)
//         {
//             return 0;
//         }
//         if(r==n-1 && c==m-1)
//         {
//             return 1;
//         }
//         if(r>=n || c>=m)
//         {
//             return 0;
//         }
//         int right = maze(mat , n , m , r+1 , c);
//         int down = maze(mat , n , m , r , c+1);
//         return (right+down)%mod;
//     }

// }

}
