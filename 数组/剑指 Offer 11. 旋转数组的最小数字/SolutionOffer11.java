package leecode;

/**
 * @author cry777
 * @program demo1
 * @description 最小数字
 * @create 2021-12-31
 */
public class SolutionOffer11 {

    /**
     * 动态规划 O(n)
     */
    public int minArray0(int[] numbers) {
        int res = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < res) {
                res = numbers[i];
            }
        }
        return res;
    }

    /**
     * 二分查找 O(log(n))
     * [3 4 5 1 2]
     */
    public int minArray1(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid = (left + right) / 2;
        while (mid >= left && mid <= right) {
            // 只要找到mid节点是谷点就行
            if (numbers[mid] < numbers[mid - 1] && numbers[mid] > numbers[mid + 1]) {
                return numbers[mid];
            } else if (numbers[mid] < numbers[mid - 1] && numbers[mid] < numbers[mid + 1]) {
                mid++;
            } else if (numbers[mid] > numbers[mid - 1] && numbers[mid] > numbers[mid + 1]) {
                mid--;
            }
        }
        return -1;
    }

    /**
     * 分治二分查找 O(log(n)) 核心思路: 对撞指针, 两端向中间平移
     * [4 5 6 1 2 3]
     */
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                // 当前m在左序列,平移左端点
                left = mid + 1;
            } else if (numbers[mid] < numbers[left]) {
                // 当前m在右序列,平移右端点
                right = mid;
            } else {
                // m等于右端点
                right--;

            }
        }
        return numbers[right];
    }
}
