/* Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. 
The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. 
The remaining elements of nums are not important as well as the size of nums.
Return k.*/

import java.util.Scanner;

public class RemoveDuplicatesSortedArray1 {
    public int removeDuplicates(int[] nums){
        int j=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of elements in the sorted array:");
        int n=sc.nextInt();
        int[] nums= new int[n];
        System.out.println("Enter the elements of the sorted array:");
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        RemoveDuplicatesSortedArray1 solution= new RemoveDuplicatesSortedArray1();
        int newLength=solution.removeDuplicates(nums);
        System.out.println("The new length of the array after removing duplicates is: "+newLength);
        System.out.println("The modified array is:");
        for(int i=0;i<newLength;i++){
            System.out.print(nums[i]+" ");
        }
        sc.close();
    }
}
