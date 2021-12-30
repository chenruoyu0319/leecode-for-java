package leecode;

/**
 * @author cry777
 * @program demo1
 * @description 53. 最大子数组和
 * @create 2021-12-29
 */
public class Solution53 {
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
