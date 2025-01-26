package DP;

public class knapsack {
    static int dp[][];
    public static void main(String[] args) {
        int weight[]=new int[]{4,5,1};
        int value[]=new int[]{1,2,3};
        int bag_weight=4;
        int index=weight.length;
        int ans=0;
        dp=new int[weight.length+1][bag_weight+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length ;j++)
                {
                    dp[i][j]=-1;
                }
        }
        int ans_recursive = recursive(weight,value,bag_weight,index);
        int ans_bottom_up = bottom_up(weight,value,bag_weight,index);
        ans=top_down(weight,value,bag_weight,index);
        System.out.println("max profit is recursive "+ans_recursive+" bottom up or memoization "+ans_bottom_up + " top down "+ans  );
    }

    static int recursive(int weight[],int value[],int bag_weight , int index)
    {
        if(index == 0 || bag_weight == 0)
        return 0 ;
        
        if(weight[index-1] <= bag_weight)
        {
            return Math.max(value[index-1] + recursive(weight,value,bag_weight-weight[index-1],index-1) , recursive(weight,value,bag_weight,index-1));

        }
        else
        return recursive(weight, value, bag_weight, index-1);
    }
    
    // Used for recursive approach
    static int bottom_up (int weight[],int value[],int bag_weight,int index)
    {
        if(index == 0 || bag_weight == 0)
        return 0 ;
        
        if(dp[index-1][bag_weight] != -1)
            return dp[index-1][bag_weight];
        if(weight[index-1] <= bag_weight)
        {
            dp[index][bag_weight] = Math.max(value[index-1] + recursive(weight,value,bag_weight-weight[index-1],index-1) , recursive(weight,value,bag_weight,index-1));

        }
        else
        dp[index][bag_weight] = recursive(weight, value, bag_weight, index-1);
        return dp[index][bag_weight];
    }

    // Used for Iterative  approach
    static int top_down(int weight[],int value[],int bag_weight,int index)
    {
        
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
                {
                    if(i==0 || j==0)
                    dp[i][j]=0; 

                    else if(weight[i-1]<=j)
                    dp[i][j]=Math.max(value[i-1]+dp[i-1][j-weight[i-1]],dp[i-1][j]);
                    else
                    dp[i][j]=dp[i-1][j];
                }
        }
        return dp[index][bag_weight];
    }
}
