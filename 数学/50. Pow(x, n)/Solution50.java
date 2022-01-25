package leecode;

/**
 * @author cry777
 * @program demo1
 * @description 快速幂算法
 * @create 2022-01-25
 */
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        // 如果是正数次方幂,quickMul(x, N);如果是负数次方幂,1.0 / quickMul(x, -N);
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        // 递归结束条件N==0
        if (N == 0) {
            return 1.0;
        }
        // 每次N/2
        double y = quickMul(x, N / 2);
        // 每次递归的幂次数N是偶数, 就返回y*y;如果是N是奇数,就返回y*y*x (y为上一次递归计算的结果)
        return N % 2 == 0 ? y * y : y * y * x;
    }


    public double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul2(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul2(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}
