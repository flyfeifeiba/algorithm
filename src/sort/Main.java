package sort;

/**
 * @author yuanyuan.wang
 * @Description:
 * @date 2020/6/2 19:08
 */
public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(Heap.HeapType.MAX);
        heap.heapSortTopK(5);

    }
}
