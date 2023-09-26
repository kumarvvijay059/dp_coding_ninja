import java.util.* ;
import java.io.*;
public class Count_Ways_To_Reach_The_Nth_Stairs {


    public class Solution {
        static int mod = 1000000007;
        public static int countDistinctWayToClimbStair(long nStairs) {
            int n = (int)nStairs;
            // int dp[] = new int[n+1];
            int prev2 = 1 , prev1 = 1;
            int curr = 0;
            for(int i = 2 ; i<=n ; i++)
            {
                curr = (prev1 + prev2)%mod;
                prev2 = prev1;
                prev1 = curr;
            }
            // Arrays.fill(dp , -1);
            // return fibonacci(n , dp);
            return prev1;
        }
        // public static int fibonacci(int n , int[] dp)
        // {
        // 	if(n<=1)
        // 	{
        // 		return 1;
        // 	}
        // 	if(dp[n]!=-1)
        // 	{
        // 		return dp[n];
        // 	}
        // 	return dp[n] = (fibonacci(n-1 , dp) + fibonacci(n - 2 , dp))%mod;
        // }
    }
}
