//Find two numbers in the array such that the sum equals target

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> numToIndex= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int complement = target-nums[i];
            if(numToIndex.containsKey(complement)){
                return new int[]{numToIndex.get(complement),i};
            }
            numToIndex.put(num, i);
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n=sc.nextInt();
        int[] arr= new int[n];
        System.out.println("Enter the array elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the target value: ");
        int target=sc.nextInt();
        TwoSum solution= new TwoSum();
        int result[]= new int[2];
        result = solution.twoSum(arr, target);
        System.out.println("The two number index values are" + result[0]+"and" + result[1]);
        sc.close();
    }
}
