package DP;

import java.util.Arrays;

public class longestCommonSubsequence {
    
    public static int lcs(String text1, String text2) {
        int ans = 0;
        int n = text1.length();
        int m = text2.length();
        //ans = lcsUtility(text1.toCharArray(), text2.toCharArray(), n, m);
        
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        
        //ans = memoizationLCS(text1.toCharArray(), text2.toCharArray(), n, m, dp);

        ans = tabulationLCS(text1.toCharArray(), text2.toCharArray(), n, m, dp);
        return ans;
    }

    // Recursion 
    static int lcsUtility(char a[], char b[], int n, int m )
    {
        if(n == 0 || m == 0)
        return 0;

        if(a[n-1] == b[m-1])
            return 1 + lcsUtility(a,b,n-1,m-1);

        return Math.max(lcsUtility(a,b,n-1,m), lcsUtility(a,b,n,m-1));   
    }

    // Top Down approach
    static int memoizationLCS(char a[], char b[], int n, int m, int dp[][])
    {
        if(n == 0 || m == 0)
        return 0;

        if(dp[n][m] != -1)
        return dp[n][m];

        if(a[n-1] == b[m-1])
        dp[n][m] = 1 + memoizationLCS(a, b, n-1, m-1, dp);
        else
        dp[n][m] = Math.max(memoizationLCS(a, b, n-1, m, dp), memoizationLCS(a, b, n, m-1, dp));

        return dp[n][m];
        
    }
    // Bottom Up approach
    static int tabulationLCS(char a[], char b[], int n,int m, int dp[][])
    {
        for(int i = 0 ; i <= n ; i++)
            dp[i][0] = 0;

        for(int j = 0; j <= m; j++)
            dp[0][j] = 0;    

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(a[i-1] == b[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);    
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String a = "abcde";
        String b = "ace";
        System.out.println(lcs(a,b));
    }
}
