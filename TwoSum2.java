//Two sum- Nested for loop approach , find two numbers in sorted array and return their indices+1 as it is one-indexed array that equal value target.

import java.util.Scanner;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        while(numbers[l]+numbers[r]!=target){
            if(numbers[l]+numbers[r]<target) l++;
            else r--;
        }
        return new int[] {l+1,r+1};
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
