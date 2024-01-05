import java.util.* ;
import java.io.*;
public class Subset_Sum_Equal_To_K {



    //dp memoization
    public class Solution {
        public static boolean subsetSumToK(int n, int k, int arr[]){
            int[][] dp = new int[n][k+1];
            for(int[] rows : dp)
            {
                Arrays.fill(rows , -1);
            }
            return fun(arr , k , n-1 , dp);
        }

        public static boolean fun(int[] arr , int target , int index , int[][] dp)
        {
            if (target == 0)
            {
                return true;
            }
            if(index == 0)
            {
                if(target == arr[index])
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            if(dp[index][target] != -1)
            {
                if(dp[index][target] == 1)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            boolean skip = fun(arr , target , index-1 , dp);
            boolean take = false;
            if(target>=arr[index])
            {
                take = fun(arr , target - arr[index] , index-1 , dp);
            }
            boolean var = skip || take;
            if(var)
            {
                dp[index][target] = 1;
            }
            else
            {
                dp[index][target] = 0;
            }
            return var;
        }
    }



//Recursion
// public class Solution {
//     public static boolean subsetSumToK(int n, int k, int arr[]){
//         return fun(arr , k , n-1);
//     }

//     public static boolean fun(int[] arr , int target , int index)
//     {
//         if (target == 0)
//         {
//             return true;
//         }
//         if(index == 0)
//         {
//             if(target == arr[index])
//             {
//                 return true;
//             }
//             else
//             {
//                 return false;
//             }
//         }
//         boolean skip = fun(arr , target , index-1);
//         boolean take = false;
//         if(target>=arr[index])
//         {
//             take = fun(arr , target - arr[index] , index-1);
//         }
//         return skip || take;
//     }
// }

}
