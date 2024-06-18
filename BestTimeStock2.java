//Same thing but multiple transactions possible after performing first transaction, then summing up all the profit values to get the maximum profit.

import java.util.Scanner;

public class BestTimeStock2{
    public int maxProfit(int[] prices){
        if(prices==null || prices.length <2){
            return 0;
        }
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                maxProfit+=prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of days: ");
        int n=sc.nextInt();
        int[] prices=new int[n];
        System.out.println("Enter the stock prices for each day: ");
        for(int i=0;i<n;i++){
            prices[i]=sc.nextInt();
        }
        BestTimeStock2 solution = new BestTimeStock2();
        int profit=solution.maxProfit(prices);
        System.out.println("The maximum profit you can achieve is: "+profit);
        sc.close();
    }

}