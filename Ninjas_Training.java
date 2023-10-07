import java.util.Arrays;
public class Ninjas_Training {
    
    // best solution space optimized
    public class Solution {
        public static int ninjaTraining(int n, int points[][]) {
            int dp[] = new int[4];
            Arrays.fill(dp , 0);
            dp[0] = Math.max(points[0][1] , points[0][2]);
            dp[1] = Math.max(points[0][0] , points[0][2]);
            dp[2] = Math.max(points[0][0] , points[0][1]);
            dp[3] = Math.max(points[0][0] , Math.max(points[0][1] , points[0][2]));
            for(int i = 1 ; i<n ; i++)
            {
                int temp[] = new int[4];
                Arrays.fill(temp, 0);
                for(int j = 0 ; j<4 ; j++)
                {
                    temp[j] = 0;
                    for(int k = 0 ; k<3 ; k++)
                    {
                        if(k!=j)
                        {
                            temp[j] = Math.max(temp[j] , points[i][k] + dp[k]);
                        }
                    }
                }
                dp = temp;
            }
            return dp[3];
        }
    }

// tabulation
// public class Solution {
//     public static int ninjaTraining(int n, int points[][]) {
//         int dp[][] = new int[n][4];
//         for (int[] row : dp)
//         {
//             Arrays.fill(row, 0);
//         }
//         dp[0][0] = Math.max(points[0][1] , points[0][2]);
//         dp[0][1] = Math.max(points[0][0] , points[0][2]);
//         dp[0][2] = Math.max(points[0][0] , points[0][1]);
//         int a = points[0][0];
//         int b = points[0][1];
//         int c = points[0][2];
//         int maxi = 0;
//         if(a>b && a>c)
//         {
//             maxi = a;
//         }
//         if(b>a && b>a)
//         {
//             maxi = b;
//         }
//         else
//         {
//             maxi = c;
//         }
//         dp[0][3] = maxi;
//         for(int i = 1 ; i<n ; i++)
//         {
//             for(int j = 0 ; j<4 ; j++)
//             {
//                 int maximum = 0;
//                 for(int k = 0 ; k<3 ; k++)
//                 {
//                     if(k!=j)
//                     {
//                         int gain = points[i][k] + dp[i-1][k];
//                         if(gain>maximum)
//                         {
//                             maximum = gain;
//                         }
//                     }
//                 }
//                 dp[i][j] = maximum;
//             }
//         }
//         return dp[n-1][3];
//     }
// }

// memoization
// public class Solution {
//     public static int ninjaTraining(int n, int points[][]) {
//         int dp[][] = new int[n][4];
//         for (int[] row : dp)
//         {
//             Arrays.fill(row, -1);
//         }
//         return training(n-1, 3 , points , dp);
//     }

//     public static int training(int index , int last_used , int points[][] , int dp[][])
//     {
//         if(index<0)
//         {
//             return 0;
//         }
//         if(dp[index][last_used]!=-1)
//         {
//             return dp[index][last_used];
//         }
//         int maximum = 0;
//         for(int i = 0 ; i<3 ; i++)
//         {
//             if(last_used!=i)
//             {
//                 int temp = last_used;
//                 last_used = i;
//                 int gain = points[index][i] + training(index - 1 , last_used , points , dp);
//                 last_used = temp;
//                 if(maximum<gain)
//                 {
//                     maximum = gain;
//                 }
//             }
//         }
//         return dp[index][last_used] = maximum;
//     }

// }

// recursion
// public class Solution {
//     public static int ninjaTraining(int n, int points[][]) {
//         //int n = points.length;
//         return training(n-1, 3 , points);
//     }

//     public static int training(int index , int last_used , int points[][])
//     {
//         if(index<0)
//         {
//             return 0;
//         }
//         int maximum = 0;
//         for(int i = 0 ; i<3 ; i++)
//         {
//             if(last_used!=i)
//             {
//                 int temp = last_used;
//                 last_used = i;
//                 int gain = points[index][i] + training(index - 1 , last_used , points);
//                 last_used = temp;
//                 if(maximum<gain)
//                 {
//                     maximum = gain;
//                 }
//             }
//         }
//         return maximum;
//     }

// }


}
