package leecode;

/**
 * @author cry777
 * @program demo1
 * @description
 * @create 2021-12-31
 */
public class Solution26 {
    /**
     * nums = [0,0,1,1,1,2,2,3,3,4]
     */
    public int removeDuplicates(int[] nums) {
        int left = 1;
        int right = 0;
        while (right < nums.length - 1) {
            if (nums[right] != nums[right + 1]) {
                nums[left] = nums[right + 1];
                left++;
            }
            right++;
        }
        return left;
    }
}
