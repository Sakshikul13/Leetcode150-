package Company_Questions.Infosys;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class infosys_monster {

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

        class Monster {
            private final int power, bonus;

            public Monster(int power, int bonus) {
                this.power = power;
                this.bonus = bonus;
            }
        }

        Monster[] monsters = new Monster[n];
        for (int i = 0; i < n; i++) {
            monsters[i] = new Monster(monster_powers[i], monster_bonus[i]);
        }

        Arrays.sort(monsters, Comparator.comparingInt(m -> m.power));
        int count = 0;
        for (Monster m : monsters) {
            if (player_score >= m.power) {
                player_score += m.bonus;
                ++count;
            } else {
                break;
            }
        }

        System.out.println("The maximum possible number of monsters that can be defeated are: " + count);
        sc.close();
    }
}
