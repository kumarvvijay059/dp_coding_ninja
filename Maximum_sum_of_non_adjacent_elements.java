import java.util.* ;
import java.io.*;
import java.util.*;

public class Maximum_sum_of_non_adjacent_elements {


    // Tabulation

    public class Solution {
        public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
            int n = nums.size();
            int dp[] = new int[n + 1];
            dp[0] = 0;
            dp[1] = nums.get(0);
            for(int i = 2 ; i<=n ; i++)
            {
                dp[i] = Math.max(dp[i-1]  , dp[i-2] + nums.get(i-1));
            }
            return dp[n];
        }
    }

    // Recurssion

// import java.util.* ;
// import java.io.*;
// import java.util.*;
// public class Solution {
// 	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
// 		int max1 = maxSumArray(nums, 0);
// 		int max2 = maxSumArray(nums, 1);
// 		return (int)Math.max(max1 , max2);
// 	}

// 	public static int maxSumArray(ArrayList<Integer> nums , int index)
// 	{
// 		if(index>nums.size()-1)
// 		{
// 			return 0;
// 		}
// 		int max = 0;
// 		for(int i = index+2 ; i<=nums.size() + 1 ; i++)
// 		{
// 			int sum = nums.get(index) + maxSumArray(nums, i);
// 			if(sum>max)
// 			{
// 				max = sum;
// 			}
// 		}
// 		return max;
// 	}
// }

// Memoization

// import java.util.* ;
// import java.io.*;
// import java.util.*;
// public class Solution {
// 	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
// 		int dp[] = new int[nums.size() + 1];
// 		Arrays.fill(dp , -1);
// 		int max1 = maxSumArray(nums, 0 , dp);
// 		int max2 = maxSumArray(nums, 1 , dp);
// 		return (int)Math.max(max1 , max2);
// 	}

// 	public static int maxSumArray(ArrayList<Integer> nums , int index , int[] dp)
// 	{
// 		if(index>nums.size()-1)
// 		{
// 			return 0;
// 		}
// 		if(dp[index]!=-1)
// 		{
// 			return dp[index];
// 		}
// 		int max = 0;
// 		for(int i = index+2 ; i<=nums.size() + 1 ; i++)
// 		{
// 			int sum = nums.get(index) + maxSumArray(nums, i , dp);
// 			if(sum>max)
// 			{
// 				max = sum;
// 			}
// 		}
// 		return dp[index] = max;
// 	}
// }

}
