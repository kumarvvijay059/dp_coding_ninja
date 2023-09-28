import java.util.* ;
import java.io.*;
public class frog_jump {
    //         Recurssion
// import java.util.* ;
// import java.io.*;
// public class Solution {
//     public static int frogJump(int n, int heights[]) {
//         return jump(heights , n-1);
//     }

//     public static int jump(int heights[] , int index)
//     {
//         if(index==0)
//         {
//             return 0;
//         }
//         int one = jump(heights , index-1) + jumping(index , index-1 , heights);
//         int two = Integer.MAX_VALUE;
//         if(index>1)
//         {
//             two = jump(heights , index-2) + jumping(index , index-2 , heights);
//         }
//         return Math.min(one , two);
//     }

//     public static int jumping(int x , int y , int heights[])
//     {
//         return Math.abs(heights[x] - heights[y]);
//     }

// }



//         dp-memoization
// import java.util.* ;
// import java.io.*;
// public class Solution {
//     public static int frogJump(int n, int heights[]) {
//         int dp[] = new int[n+1];
//         Arrays.fill(dp , -1);
//         return jump(heights , n-1 , dp);
//     }

//     public static int jump(int heights[] , int index , int dp[])
//     {
//         if(index==0)
//         {
//             return 0;
//         }
//         if(dp[index]!=-1)
//         {
//             return dp[index];
//         }
//         int one = jump(heights , index-1 , dp) + jumping(index , index-1 , heights);
//         int two = Integer.MAX_VALUE;
//         if(index>1)
//         {
//             two = jump(heights , index-2 , dp) + jumping(index , index-2 , heights);
//         }
//         return dp[index] = Math.min(one , two);
//     }

//     public static int jumping(int x , int y , int heights[])
//     {
//         return Math.abs(heights[x] - heights[y]);
//     }

// }



//        dp-tabulation

    public class Solution {
        public static int frogJump(int n, int heights[]) {
            int dp[] = new int[n+1];
            dp[0] = 0;
            for(int i = 1 ; i<n ; i++)
            {
                int one = dp[i-1] + jumping(i , i-1 , heights);
                int two = Integer.MAX_VALUE;
                if(i>1)
                {
                    two = dp[i-2] + jumping(i , i-2 , heights);
                }
                dp[i] = Math.min(one , two);
            }
            return dp[n-1];
        }

        public static int jumping(int x , int y , int heights[])
        {
            return Math.abs(heights[x] - heights[y]);
        }
    }









}
