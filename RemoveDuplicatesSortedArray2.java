/* Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that 
each unique element appears at most twice. The relative order of the elements should be kept the same.
*/
import java.util.Scanner;
public class RemoveDuplicatesSortedArray2 {
        public int removeDuplicates(int[] nums) {
            int j = 1;
            for (int i = 1; i < nums.length; i++) {
                if (j == 1 || nums[i] != nums[j - 2]) {
                    nums[j++] = nums[i];
                }
            }
            return j;
        }
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the nunmber of elements in the sorted array: ");
            int n=sc.nextInt();
            
            int[] nums=new int[n];
            System.out.println("Enter the elements in the sorted array: ");
            for(int i=0;i<n;i++){
                nums[i] = sc.nextInt(); 
            }

            RemoveDuplicatesSortedArray2 solution = new RemoveDuplicatesSortedArray2();
            int newLength= solution.removeDuplicates(nums);
            System.out.println("The new length of the array after removing duplicates is: "+newLength);
            System.out.println("The modified array is:");
            for(int i=0;i<newLength;i++){
                System.out.print(nums[i]+" ");
            }
            sc.close();


        }
}
