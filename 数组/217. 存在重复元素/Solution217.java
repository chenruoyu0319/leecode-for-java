package leecode;

import java.util.HashMap;

/**
 * @author cry777
 * @program demo1
 * @description
 * @create 2021-12-28
 */
public class Solution217 {

    public boolean containsDuplicate2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return true;
            }
            hashMap.put(nums[i], i);
        }
        return false;
    }

    /**
     * 插入排序后类比
     */
    public boolean containsDuplicate22(int[] nums) {
         insertSort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }


    /**
     * 快排后类比
     */
    public boolean containsDuplicate(int[] nums) {
        qSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 插入排序 log(n^2)
     */
    public static void insertSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int data = a[i];
            for (; j >= 0; j--) {
                if (a[j] > data) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = data;
        }
    }

    /**
     * 经典快排 nlog(n)
     */
    public  void qSort(int data[], int left, int right) {

        int base = data[left]; // 就是我们的基准数，取序列的第一个,不能用data[0]
        int ll = left; // 表示的是从左边找的位置
        int rr = right; // 表示从右边开始找的位置
        while (ll < rr) {
            // 从后面往前找比基准数小的数
            while (ll < rr && data[rr] >= base) {
                rr--; // 没找到就--
            }
            if (ll < rr) { // 表示是找到有比之大的
                exchange(data,ll,rr);
                ll++;
            }
            while (ll < rr && data[ll] <= base) {
                ll++;
            }
            if (ll < rr) {
                exchange(data,ll,rr);
                rr--;
            }
        }
        // 肯定是递归 分成了三部分,左右继续快排，注意要加条件不然递归就栈溢出了
        if (left < ll-1) {
            qSort(data, left, ll - 1);
        }
        if (ll < right-1) {
            qSort(data, ll + 1, right);
        }
    }

    public  void exchange(int data[], int a, int b) {
        if (a!=b){
            data[a] = data[a] - data[b];
            data[b] = data[a] + data[b];
            data[a] = data[b] - data[a];
        }else {
            return;
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 1};
        insertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

