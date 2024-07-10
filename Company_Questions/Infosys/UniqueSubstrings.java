/* Given a string S, you can only perform two operations any number of times: delete from start or delete from end. 
Find the total number of unique substrings that can be made from string S.*/

package Company_Questions.Infosys;
import java.util.HashSet;
import java.util.Scanner;

public class UniqueSubstrings {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String S=sc.nextLine();
        int ans=CalculateUniqueSubstrings(S);
        System.out.println("Number of unique Substrings:" + ans);
        sc.close();
    }
    public static int CalculateUniqueSubstrings(String s){
        HashSet<String> uniqueSubstrings=new HashSet<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                uniqueSubstrings.add(s.substring(i, j));
            }
        }
        return uniqueSubstrings.size();
    }
}
