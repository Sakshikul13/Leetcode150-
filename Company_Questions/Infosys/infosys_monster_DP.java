package Company_Questions.Infosys;
import java.util.Scanner;

public class infosys_monster_DP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of monsters:");
        n = sc.nextInt();
        int player_score;
        System.out.println("Enter the experience of the current player:");
        player_score = sc.nextInt();
        int[] monster_powers = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the power of monster" + (i + 1) + " :");
            monster_powers[i] = sc.nextInt();
        }
        int[] monster_bonus = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the bonus of monster" + (i + 1) + " :");
            monster_bonus[i] = sc.nextInt();
        }

        // Dynamic Programming approach
        int[] dp = new int[player_score + 1];
        
        // Iterate over each monster
        for (int i = 0; i < n; i++) {
            int power = monster_powers[i];
            int bonus = monster_bonus[i];
            
            // Update dp array backwards to avoid overwriting values
            for (int score = player_score; score >= power; score--) {
                dp[score] = Math.max(dp[score], dp[score - power] + 1);
            }
        }

        // The answer will be the maximum value in dp array
        int maxMonsters = dp[player_score];

        System.out.println("The maximum possible number of monsters that can be defeated is: " + maxMonsters);
        sc.close();
    }
}
