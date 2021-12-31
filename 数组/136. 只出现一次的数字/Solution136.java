package leecode;

/**
 * @author cry777
 * @program demo1
 * @description 136. 只出现一次的数字
 * @create 2021-12-31
 */
public class Solution136 {
    
    /**
     * 异或, 时间复杂度:O(n)  空间复杂度:O(1)
     */
    public int singleNumber0(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^=nums[i];
        }
        return nums[0];
    }

    // HashMap实现,遍历数组,记录次数，遍历hashMap取出次数=1的value   O(n)
    // Set实现,遍历数组,记录到set里,如果已经有值就删除,最后迭代Set的结果返回  O(n)
    // 排序, 遍历排序后的数组,比较每个元素前后的值,取出与前后值都不相等的那一个 O(nlog(n))
    // 2层曾循环 O(n^2)
}
