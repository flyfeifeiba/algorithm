package sort;

import util.BaseUtil;

/**
 * @Description: 选择排序
 * @Author wang1
 * @Date 2020/6/5
 * @Version V1.0
 **/
public class SelectionSort implements Sort{


    @Override
    public void doSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = findMinIndex(array, i, array.length - 1);
            if (minIndex != i) {
                BaseUtil.swap(array, i, minIndex);
            }

        }

        BaseUtil.print(array);


    }


    /**
     * 找到最小的下标
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private int findMinIndex(int[] array, int left, int right) {
        int minIndex = left;
        for (int i = left + 1; i <= right; i++) {
            minIndex = array[i] < array[minIndex] ?  i : minIndex;
        }
        return minIndex;
    }




    public static void main(String[] args) {
        Sort selectionSort = new SelectionSort();
        selectionSort.sort();
    }
}
