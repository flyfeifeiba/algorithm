package question;

/**
 * @author yuanyuan.wang
 * @Description: 在一个数组中找到超过半数的数
 * @date 2020/6/3 17:10
 */
public class MoreThanHalf {

    private int findMoreThanHalf(int[] array) {
        int hp = 0;
        int cand = 0;
        for (int arrayNumber : array) {
            if (hp == 0) {
                hp++;
                cand = arrayNumber;
            } else if (cand == arrayNumber) {
                hp++;
            } else {
                hp--;
            }
        }

        int number = 0;
        for (int arrayNumber : array) {
            if (arrayNumber == cand) {
                number++;
            }
        }


        return number * 2 > array.length ? cand : 0;
    }

    public static void main(String[] args) {
        MoreThanHalf moreThanHalf = new MoreThanHalf();
        int[] array = {1, 1, 3, 4, 5, 1, 4, 1};
        System.out.println(moreThanHalf.findMoreThanHalf(array));
    }


}
