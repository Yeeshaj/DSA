package DP;
/*
 * 
 * Given an array and sum, find if the sum is present using the addition of elemenets.
 */
public class count_subset {
    public static void main(String[] args) {
        int arr[]=new int[]{2,3,8,9,10};
        int sum=100;
        boolean ans=if_subset_present(arr, sum);
        System.out.println("Ans is "+ ans);
    }
    static boolean if_subset_present(int arr[],int sum)
    {
            boolean dp[][]=new boolean[arr.length+1][sum+1];
            for(int i=0;i<dp.length;i++)
            {
                for(int j=0;j<dp[0].length;j++)
                {
                    if(i==0)
                    dp[i][j]=false;
                    else if(j==0)
                    dp[i][j]=true;
                    else if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                    else
                    dp[i][j]=dp[i-1][j];
                }
            }
            return dp[arr.length][sum];
    }
}
