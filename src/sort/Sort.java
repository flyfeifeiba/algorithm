package sort;

import util.BaseUtil;

public interface Sort {

    /**
     * 对数组array进行排序
     */
    default void sort() {
        int[] array = BaseUtil.initArray(30);

        System.out.println("排序之前的数组：");
        BaseUtil.print(array);

        doSort(array);

        System.out.println("排序之后的数组：");
        BaseUtil.print(array);

    }

    void doSort(int[] array);


}
