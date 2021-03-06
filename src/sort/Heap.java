package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author yuanyuan.wang
 * @Description:
 * @date 2020/6/2 15:41
 */
public class Heap {
    public enum HeapType {
        MAX("大顶堆"),
        MIN("小顶堆"),
        ;
        String desc;

        HeapType(String desc) {
            this.desc = desc;
        }

    }

    private HeapType heapType;

    private int[] array;

    public Heap() {
        this.heapType = HeapType.MAX;
        initArray();
    }

    public Heap(HeapType heapType) {
        this.heapType = heapType;
        initArray();
    }

    public Heap(HeapType heapType, int[] array) {
        this.heapType = heapType;
        this.array = array;
    }


    public void heapSort() {

        if (array == null || array.length <= 1) {
            return;
        }

        System.out.print("排序之前的数组：");
        print(array);


        buildHeap();

        for (int i = array.length - 1; i > 0; i--) {
            swap(0, i);
            heapify(0, i - 1);
        }

        System.out.print("排序之后的数组：");
        print(array);
    }


    public int[] heapSortTopK(int k) {
        System.out.print("排序之前的数组:");
        print(array);


        if (array == null || array.length <= 1) {
            return null;
        }

        if (k > array.length) {
            throw new RuntimeException("k 大于数字的长度");
        }

        buildHeap();

        for (int i = array.length - 1; i >= array.length - k; i--) {
            swap(0, i);
            heapify(0, i - 1);
        }
        int[] result = getKNumber(k);

        System.out.print("TOP " + k + "：");
        print(result);
        return result;
    }

    /**
     * 从顶到叶子节点整理堆
     */
    private void heapify(int index, int lastIndex) {
        while (findLeftChildIndex(index) <= lastIndex) {
            int mostIndex = findRightChildIndex(index) > lastIndex ? findMostIndex(index, findLeftChildIndex(index)) : findMostIndex(index, findLeftChildIndex(index), findRightChildIndex(index));
            if (mostIndex == index) {
                break;
            }
            swap(index, mostIndex);
            index = mostIndex;
        }
    }

    /**
     * 构建堆
     */
    private void buildHeap() {
        for (int i = findParentIndex(array.length - 1); i >= 0; i--) {
            heapify(i, array.length - 1);
        }
    }

    /**
     * 返回最值的下标
     *
     * @param index
     * @return
     */
    private int findMostIndex(int... index) {
        int mostIndex = index[0];
        int most = array[index[0]];
        for (int i = 1; i < index.length; i++) {
            if (index[i] >= array.length) {
                continue;
            }
            if (compare(array[index[i]], most)) {
                mostIndex = index[i];
                most = array[index[i]];
            }
        }
        return mostIndex;
    }


    /**
     * 交换数组array中A和B的数值
     *
     * @param indexA A的下标
     * @param indexB B的下标
     */
    private void swap(int indexA, int indexB) {
        if (indexA == indexB) {
            return;
        }
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    /**
     * 找到左子树节点下标
     * @param parentIndex
     * @return
     */
    private int findLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    /**
     * 找到右子树节点下边
     * @param parentIndex
     * @return
     */
    private int findRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    /**
     * 找父节点下标
     * @param childIndex
     * @return
     */
    private int findParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    /**
     * 根据堆类型设置不同的比较方式
     * @param a
     * @param b
     * @return
     */
    private boolean compare(int a, int b) {
        if (HeapType.MAX.equals(heapType)) {
            return a > b;
        }
        return a < b;
    }

    /**
     * 打印
     */
    public void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "   ");
        }
        System.out.println();
    }


    /**
     * 获取最后K个数
     * @param k
     * @return
     */
    private int[] getKNumber(int k) {

        int [] kNumber = new int[k];
        int lastIndex = array.length - 1;

        for (int i = 0; i < k; i++) {
            kNumber[i] = array[lastIndex - i];
        }
        return kNumber;
    }

    /**
     * 初始化数组
     */
    private void initArray() {
        Random random = new Random();

        array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = random.nextInt(100);
        }

    }
}
