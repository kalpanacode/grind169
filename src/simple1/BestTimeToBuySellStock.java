// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=problem-list-v2&envId=rabvlt31  

package simple1;

public class BestTimeToBuySellStock {
    // Method to find maximum profit
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;  // update minimum buying price
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;  // update max profit if selling today is better
            }
        }
        
        return maxProfit;
    }

    // Main method for testing
    public static void main(String[] args) {
        BestTimeToBuySellStock solution = new BestTimeToBuySellStock();

        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = solution.maxProfit(prices);

        System.out.println("Maximum profit: " + result);  // Output: 5
    }
}

