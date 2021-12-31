package leecode;

/**
 * @author cry777
 * @program demo1
 * @description
 * @create 2021-12-31
 */
public class Solution27 {

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
