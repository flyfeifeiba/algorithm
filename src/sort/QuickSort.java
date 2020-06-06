package sort;

/**
 * @Description: 快排
 * @Author wang1
 * @Date 2020/6/6
 * @Version V1.0
 **/
public class QuickSort implements Sort {


    @Override
    public void doSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        int position = 0;
        while (left < right) {
            position = partition(array, left, right);
            quickSort(array, left, position - 1);
            quickSort(array, position + 1, right);
        }

    }

    private int partition(int[] array, int left, int right) {
        int temp = array[left];
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= temp) {
                left++;
            }
            array[right] = array[left];
        }

        array[left] = temp;
        return left;
    }

    public static void main(String[] args) {
        Sort quickSort = new QuickSort();
        quickSort.sort();

    }
}
