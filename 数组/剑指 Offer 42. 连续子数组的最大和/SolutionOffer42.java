package leecode;

/**
 * @author cry777
 * @program demo1
 * @description
 * @create 2021-12-30
 */
public class SolutionOffer42 {

    /**
     * 动态规划状态转移方程
     * dp[0] = nums[0]
     * dp[i - 1] < 0, dp[i] = nums[i];
     * dp[i - 1] > 0, dp[i] = dp[i - 1] + nums[i];
     */
    public int maxSubArray0(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] <= 0){
                dp[i] = nums[i];
            }else if (dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }

    /**
     * 动态规划状态转移方程
     * f(i) = max{ f(i−1)+nums[i] , nums[i] }
     */
    public int maxSubArray(int[] nums) {
        int maxAns = nums[0];
        int[] preArray = new int[nums.length];
        preArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            preArray[i] = Math.max(preArray[i - 1] + x, x);
            maxAns = Math.max(maxAns, preArray[i]);
        }
        return maxAns;
    }
}
