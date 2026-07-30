class Solution {
    public int maxProfit(int[] prices) {
       int minValue = Integer.MAX_VALUE;
       int maxProfit = 0;

        for (int price : prices){
            if(price < minValue){
                minValue = price;
            }

            int profit = price - minValue;

            if (profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}