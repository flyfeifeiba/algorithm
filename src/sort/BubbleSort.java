package sort;

import util.BaseUtil;

/**
 * @Description: 冒泡排序
 * @Author wang1
 * @Date 2020/6/5
 * @Version V1.0
 **/
public class BubbleSort implements Sort {


    @Override
    public void doSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length ; j++) {
                if (array[i] > array[j]) {
                    BaseUtil.swap(array, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Sort bubbleSort = new BubbleSort();
        bubbleSort.sort();
    }
}
