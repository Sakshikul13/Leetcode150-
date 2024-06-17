import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArrays_alternate {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        } //appending all elements of nums2 at the end of nums1
        Arrays.sort(nums1);
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

        MergeSortedArrays_alternate solution = new MergeSortedArrays_alternate();
        solution.merge(nums1, m, nums2, n);

        System.out.println("The merged array is:");
        for (int i = 0; i < m + n; i++) {
            System.out.print(nums1[i] + " ");
        }
        scanner.close();
    }
}
