/* 
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
in the future to sell that stock. Return the maximum profit you can achieve from this transaction. 
If you cannot achieve any profit, return 0
 */
import java.util.Scanner;
public class BestTimeStock{
    public int maxProfit(int[] prices){
        if(prices==null||prices.length<2){
            return 0;
        }
        int minPrice=prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]< minPrice){
                minPrice=prices[i];
            }
            else if(prices[i]-minPrice>maxProfit){
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of days:");
        int n=sc.nextInt();
        int[] prices=new int[n];
        System.out.println("Enter the stock prices for each day:");
        for(int i=0;i<n;i++){
            prices[i]=sc.nextInt();
        }
        BestTimeStock solution=new BestTimeStock();
        int profit=solution.maxProfit(prices);
        System.out.println("The maximum profit you can achieve is: "+ profit);
        sc.close();
    }
}