public class Partition_Equal_Subset_Sum {
    public class Solution {



        static boolean canPartition(int[] arr , int n)
        {
            int sum = 0;
            for (int i = 0; i < n; i++)
            {
                sum = sum + arr[i];
            }
            if (sum % 2 == 1)
            {
                return false;
            }
            else
            {
                int k = sum / 2;
                boolean prev[] = new boolean[k + 1];
                prev[0] = true;
                if (arr[0] <= k)
                {
                    prev[arr[0]] = true;
                }
                for (int ind = 1; ind < n; ind++)
                {
                    boolean curr[] = new boolean[k + 1];
                    curr[0] = true;
                    for (int target = 1; target <= k; target++)
                    {
                        boolean notTaken = prev[target];
                        boolean taken = false;
                        if (arr[ind] <= target)
                        {
                            taken = prev[target - arr[ind]];
                        }
                        curr[target] = notTaken || taken;
                    }
                    prev = curr;
                }
                return prev[k];
            }
        }

// Recursion
        // public static boolean canPartition(int[] arr, int n) {
        // 	int sum = 0;
        // 	for(int i = 0 ; i < n ; i++)
        // 	{
        // 		sum = sum + arr[i];
        // 	}
        // 	if(sum%2 == 1)
        // 	{
        // 		return false;
        // 	}
        // 	else
        // 	{
        // 		return fun(arr , sum/2 , n-1);
        // 	}
        // }

        // public static boolean fun(int[] arr , int k , int index)
        // {
        // 	if(k == 0)
        // 	{
        // 		return true;
        // 	}
        // 	if(index == 0)
        // 	{
        // 		if(k == arr[0])
        // 		{
        // 			return true;
        // 		}
        // 		else
        // 		{
        // 			return false;
        // 		}
        // 	}
        // 	boolean skip = fun(arr , k , index-1);
        // 	boolean take = false;
        // 	if(k >= arr[index])
        // 	{
        // 		take = fun(arr , k - arr[index] , index-1);
        // 	}
        // 	return skip || take;

        // }
    }
}
