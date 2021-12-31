package leecode;

/**
 * @author cry777
 * @program demo1
 * @description 移动零
 * @create 2021-12-31
 */
public class Solution283 {

    /**
     * 双指针
     * [0,1,0,3,12]
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                right++;
            } else if (nums[right] != 0) {
                exchange(nums, left, right);
                left++;
                right++;
            }
        }
    }

    public void exchange(int[] nums, int left, int right) {
        if (left == right){
            return;
        }else {
            nums[left] ^= nums[right];
            nums[right] ^= nums[left];
            nums[left] ^= nums[right];
        }
    }
}
