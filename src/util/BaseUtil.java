package util;

import java.util.Random;

/**
 * @Description: 基础工具类
 * @Author wang1
 * @Date 2020/6/5
 * @Version V1.0
 **/
public class BaseUtil {

    /**
     * 交换数组的两个值
     * @param array
     * @param indexA
     * @param indexB
     */
    public static void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    /**
     * 打印数组
     * @param array
     */
    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    /**
     * 初始化一个Length长度的数组
     * @param length
     * @return
     */
    public static int[] initArray(int length) {
        Random random = new Random(100);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }


}
