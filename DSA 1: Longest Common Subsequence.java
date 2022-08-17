class Solution
{
    //#DP423
    //Functions to find the length of longest common subsequence in two strings.
    //Recursive Approach
    static int lcs(int n, int m, String s1, String s2)
    {
        if(n==0 || m==0) return 0;
        if(s1.charAt(n-1)==s2.charAt(m-1)) return 1+lcs(n-1, m-1, s1, s2);
        return Math.max(lcs(n-1, m, s1, s2), lcs(n, m-1, s1, s2));
    }
    
    //Dynamic Programming Approach
    static int lcs(int n, int m, String s1, String s2){
        int[][] dp = new int[n+1][m+1];
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[n][m];
    }
}
