/* You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, 
representing the number of elements in nums1 and nums2 respectively. Merge nums1 and nums2 into a single array 
sorted in non-decreasing order. The final sorted array should not be returned by the function, but instead be 
stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements 
denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. 
nums2 has a length of n. */

import java.util.Scanner;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in nums1 (excluding the extra space): ");
        int m = scanner.nextInt();

        int[] nums1 = new int[m + 10];
        System.out.println("Enter the elements of nums1:");
        for (int i = 0; i < m; i++) {
            nums1[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of elements in nums2: ");
        int n = scanner.nextInt();

        int[] nums2 = new int[n];
        System.out.println("Enter the elements of nums2:");
        for (int i = 0; i < n; i++) {
            nums2[i] = scanner.nextInt();
        }

        for (int i = m; i < m + n; i++) {
            nums1[i] = 0;
        }

        MergeSortedArrays solution = new MergeSortedArrays();
        solution.merge(nums1, m, nums2, n);

        System.out.println("The merged array is:");
        for (int i = 0; i < m + n; i++) {
            System.out.print(nums1[i] + " ");
        }
        scanner.close();
    }
}
