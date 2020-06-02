package question;

import java.util.Random;

import static sun.java2d.cmm.ColorTransform.In;

/**
 * @Description: TODO
 * @Author wang1
 * @Date 2020/6/2
 * @Version V1.0
 * <p>
 * <p>
 * 给定一个随机函数，等概率返回a-b的一个数，现在需要写一个函数等概率返回c-d的一个数
 **/
public class RandomByGivenRandom {

    private int a;
    private int b;
    private int c;
    private int d;

    public RandomByGivenRandom() {
        this.a = 1;
        this.b = 5;
        this.c = 1;
        this.d = 7;
    }


    /**
     * 给定的等概率生成a-b中的一个值
     *
     * @return
     */
    private int givenRandom() {
        return new Random().nextInt(Integer.MAX_VALUE) % (b - a + 1) + a;
    }


    private int givenRandomToZeroOne() {
        int half = (b - a + 1) / 2;
        while (true) {
            int number = givenRandom();
            if (number < (a + half)) {
                return 0;
            } else if (number > (b - half)) {
                return 1;
            }
        }
    }

    private int getUnits() {
        int differ = d - c;

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (1<<i > differ) {
                return i;
            }
        }
        return Integer.MAX_VALUE;

    }


    private int randomUnits(int units) {
        int number = 0;
        for (int i = 0; i < units; i++) {
            number +=  Math.pow(2, i) * givenRandomToZeroOne();
        }
        return number;
    }


    private int random() {
        //首先判定用多少位表示c-d
        int units = getUnits();


        while (true) {
            int randomNumber = randomUnits(units);
            if (randomNumber <= (d-c)) {
                return c + randomNumber;
            }

        }


    }


    public static void main(String[] args) {
        RandomByGivenRandom randomByGivenRandom = new RandomByGivenRandom();
        for (int i = 0; i < 100000; i++) {

            System.out.println(randomByGivenRandom.random());
        }
    }
}
