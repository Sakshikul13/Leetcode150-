/* Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the 
letters from magazine and false otherwise. Each letter in magazine can only be used once in ransomNote. */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        //Edge case
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        Map<Character,Integer> charCount= new HashMap<>();
        for(char c:magazine.toCharArray()){
            charCount.put(c,charCount.getOrDefault(c, 0)+1);
        }
        //Logic
        for(char c:ransomNote.toCharArray()){
            if(charCount.containsKey(c) && charCount.get(c)>0){
                charCount.put(c,charCount.get(c)-1);
            }else{
                return false;
            }
        }
        return true;

        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the ransomNote string: ");
        String ransomNote = sc.nextLine();

        System.out.print("Enter the magazine string: ");
        String magazine = sc.nextLine();
        RansomNote solution= new RansomNote();
        boolean result=solution.canConstruct(ransomNote, magazine);
        System.out.println("Can construct? " + result);
        sc.close();
        

    }
}
