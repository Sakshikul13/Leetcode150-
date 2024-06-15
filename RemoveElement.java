/* Remove element -> Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
The order of the elements may be changed. Then return the number of elements in nums which are not equal to val. 
It modifies the input in place, without creating a separate copy of the data structure.*/

import java.util.Scanner;

public class RemoveElement {
    public int solution(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the value to be removed: ");
        int val = sc.nextInt();
        RemoveElement solution = new RemoveElement();
        int newLength = solution.solution(nums, val);

        System.out.println("The new length of the array is: " + newLength);
        System.out.print("The modified array is: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
        sc.close();
    }
}
