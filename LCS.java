import java.util.Scanner;

public class LCS {

    static String lcs (String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int [][] dp = new int [m+1][n+1];
        for (int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            } 
        }
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j> 0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                lcs.insert(0, str1.charAt(i-1));
                i--;j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        return lcs.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(lcs(str1, str2));
    }    
}
