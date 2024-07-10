package Company_Questions.Infosys;
import java.util.Scanner;

public class UniqueBirthdayGift_DP {
    public static int countValidArrays(int n, int k) {
        int[][] dp = new int[k + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            dp[1][j] = 1;
        }
        for (int len = 2; len <= k; len++) {
            for (int end = 1; end <= n; end++) {
                for (int prev = 1; prev <= n; prev++) {
                    if (end % prev == 0) {
                        dp[len][end] += dp[len - 1][prev];
                    }
                }
            }
        }
        int result = 0;
        for (int j = 1; j <= n; j++) {
            result += dp[k][j];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 3;
        int k = 2;
        System.out.println(countValidArrays(n, k));
        scanner.close();
    }
}
