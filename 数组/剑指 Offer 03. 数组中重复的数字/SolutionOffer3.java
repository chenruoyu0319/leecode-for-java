package leecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author cry777
 * @program demo1
 * @description 剑指 Offer 03. 数组中重复的数字
 * @create 2021-12-29
 */
public class SolutionOffer3 {
    public int findRepeatNumber0(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])){
                return nums[i];
            }
        }
        return 0;
    }

    //[2, 3, 1, 0, 2, 5, 3]
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i){
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]){
                return nums[i];
            }
            // 交换nums[i] 和 i位置处的值 每次保证索引nums[i]处的值等于nums[i]
            // i=2      nums[i]=9
            if (nums[nums[i]] != nums[i]){
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

}
