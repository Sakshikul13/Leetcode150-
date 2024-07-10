/* We need to generate all arrays of length 𝐾 where each element is between 1 and  𝑁 and each element must be divisible by its previous element.
The task is to count how many such arrays exist and return the count modulo 10000.*/

package Company_Questions.Infosys;
import java.util.*;
public class UniqueBirthdayGift {
    private static final int MOD = 10000;
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of N:");
        int N = scanner.nextInt();
        System.out.println("Enter the value of K(length of arrays cannot be zero):");
        int K = scanner.nextInt();
        // Memoization map to store results of subproblems
        // Memoization ensures that a function doesn't run for the same inputs more than once
        if (K == 1) {
            System.out.println("The number of different arrays is: 1");
            return;
        }

        Map<String, Integer> memo = new HashMap<>();
        int result = 0;
        for (int i = 1; i <= N; i++) {    //so i is current
            result = (result + countArrays(N, K, i, memo)) % MOD;  //if you input K=1, it'll be a one element array.
        }
        System.out.println("The number of different arrays is: " + result);
        scanner.close();
    }
    private static int countArrays(int N, int K, int current, Map<String, Integer> memo) {
        // Base case: if K is 1, there's only one array of length 1 that ends with `current`
        if (K == 1) {
            return 1;
        }
        // Memoization key
        String key = K + "," + current;    //length,ending of the array
        if (memo.containsKey(key)) {         //if the hashmap has a key with the given length and ending value that means the count of this has already been calcuakted, just get the calue from hashmap
            return memo.get(key);
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (i % current == 0) {   //check if current divides previous element
                count = (count + countArrays(N, K - 1, i, memo)) % MOD;    //recursion till 1 9
            }
        }
        memo.put(key, count);
        return count;
    }
}
