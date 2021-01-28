package com.zzz.pontos.java.alg.order.bubleSort;

import java.util.Arrays;

/**
 * @ClassName BubleSort
 * @Description 冒泡排序
 * @Author 25703
 * @Date 2020/9/9 17:13
 * @Version 1.0.0
 **/
public class BubleSort {
    public static int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            for (int num : nums) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 4, 3, 2, 1};
        nums = BubleSort.sort(nums);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }
}
