package DP;
/*
 * Problem statement : Given an array , you need to divide the array in two subset such that the elements sum is equal
 * Observation : if the sum is odd then you cannot divide the sum in integer it will always  float .
 *               using this observation we will check if the sum is odd and even if odd return false and if even 
 *               the problem reduces to equal subset problem. 
 */
public class EqualSubsetProblem {
    public static void main(String[] args) {
        int arr[]=new int[]{1,5,5,11};
        
        boolean ans=isEqualSubset(arr);

        System.out.println("Ans is "+ ans);
    }
    static boolean isEqualSubset(int arr[])
    {   
        int sum=0;
        for(int i:arr)
        sum+=i;
        if(sum%2!=0)
        return false;
        return isSubet(arr,sum/2);

    }
    static boolean isSubet(int arr[],int sum)
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
                dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                dp[i][j]=dp[i-1][j];
            }
        }
        return dp[arr.length][sum];
    }
}
