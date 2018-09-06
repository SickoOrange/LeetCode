import sun.security.util.Length;

class Solution {

    // bruct force to find all posibillities
    // time limit exceeded
    public int maxProfit(int[] prices) {

        return handleProfit(prices, 0);

    }

    public int handleProfit(int[] prices, int startIndex) {
        if (startIndex == prices.length)
            return 0;
        int max = 0;
        for (int i = startIndex; i < prices.length; i++) {
            int maxProfit = 0;
            for (int j = 0; j < prices.length; j++) {
                int profit = 0;
                if (prices[i] < prices[j]) {
                    profit = prices[j] - prices[i] + handleProfit(prices, j + 1);
                }
                maxProfit = Math.max(profit, maxProfit);
            }
            max = Math.max(max, maxProfit);
        }

        return max;
    }


    //solution 2: very easy!
        public int maxProfit2(int[] prices) {
    
            int max = 0;
            int start = 0;
            while (start < prices.length-1) {
                if (prices[start] < prices[start + 1]) {
                    max += prices[start + 1] - prices[start];
                }
                start++;
            }
            return max;
        }

}