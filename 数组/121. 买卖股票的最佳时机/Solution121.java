package leecode;

/**
 * @author cry777
 * @program demo1
 * @description 121. 买卖股票的最佳时机
 * @create 2021-12-29
 */
public class Solution121 {
    //[7,1,5,3,6,4]
    public int maxProfit0(int[] prices) {
        int maxPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int price = prices[j] - prices[i];
                if (price > maxPrice) {
                    maxPrice = price;
                }
            }
        }
        return maxPrice;
    }

    //[7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        for (int i=0;i<prices.length;i++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }
            int price = prices[i] - minPrice;
            if (price > maxPrice){
                maxPrice = price;
            }
        }
        return maxPrice;
    }
}
