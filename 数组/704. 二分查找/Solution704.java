package leecode;

/**
 * @author cry777
 * @program demo1
 * @description 二分查找
 * @create 2021-12-27
 */
public class Solution704 {

    /**
     * 循环
     */
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 说明target已经在mid右边
                left = mid;
            } else if (nums[mid] > target) {
                // 说明target已经在mid左边
                right = mid;
            }

        }
        return -1;
    }

    /**
     * 尾递归
     */
    public static int search(int[] nums, int target, int left, int right) {

        if (left>right){
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            // 说明target已经在mid右边
            left = mid;
        } else if (nums[mid] > target) {
            right = mid;
        }
        return search(nums, target, left, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        int left = 0;
        int right = nums.length - 1;
        int search = search(nums, target, left, right);
        System.out.println(search);

    }
}
