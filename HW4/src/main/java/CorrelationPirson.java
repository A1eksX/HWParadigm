import java.util.Arrays;
/**
 * Ваша задача
 * Написать скрипт для расчета корреляции Пирсона между двумя случайными величинами (двумя массивами). Можете
 * использовать любую парадигму, но рекомендую использовать функциональную, т.к. в этом примере она значительно
 * упростит вам жизнь.
 * Контекст
 * Корреляция - статистическая мера, используемая для оценки связи между двумя случайными величинами.
 */

public class CorrelationPirson {
    public static void main(String[] args) {
        int[] oneArray = new int[]{14, 16, 18, 20, 22};
        int[] twoArray = new int[]{24, 25, 27, 28, 30};

        double oneAverage = Arrays.stream(oneArray).mapToDouble(a -> a).average().orElse(0); //+
        double twoAverage = Arrays.stream(twoArray).mapToDouble(a -> a).average().orElse(0); // +

        double[] deviationX = deviations(oneArray, oneAverage); // +
        double[] deviationY = deviations(twoArray, twoAverage); // +

        double sumDeviationXSquare = sumDeviationSquare(deviationX);
        double sumDeviationYSquare = sumDeviationSquare(deviationY);

        double sumDxMultyDy = sumDxMultyDy(deviationX, deviationY);   // ----------------------

        double correlationPirson = correlationPirson(sumDxMultyDy, sumDeviationXSquare, sumDeviationYSquare);
        System.out.println(correlationPirson);
    }

    /**
     *
     * @param sumDxMultyDy сумму (dx * dy)
     * @param sumDeviationXSquare  Находим сумму квадратов dx
     * @param sumDeviationYSquare Находим сумму квадратов dy
     * @return коэффициент корреляции Пирсона
     */
    public static double correlationPirson(double sumDxMultyDy, double sumDeviationXSquare, double sumDeviationYSquare) {
        return sumDxMultyDy / Math.sqrt(sumDeviationXSquare *  sumDeviationYSquare);
    }

    /**
     * Находим сумму квадратов dx или dy
     * @param arr массив отклонений для dx/dy
     * @return сумму квадратов dx/dy
     */
    // sum d^2
    public static double sumDeviationSquare(double[]arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * arr[i];
        }
        return sum;
    }

    /**
     *  находим числитель для ф-лы корреляции
     * @param oneArr массив отклонений для dx
     * @param twoArr массив отклонений для dy
     * @return возвращает сумму (dx * dy)
     */
    public static double sumDxMultyDy(double[] oneArr, double[] twoArr) {
        int size = oneArr.length;
        double[] unionArray = new double[size];
        if (oneArr.length == twoArr.length) {
            for (int i = 0; i < size; i++) {
                unionArray[i] = oneArr[i] * twoArr[i];
            }
        }
        return Arrays.stream(unionArray).sum();
    }

    /**
     * Находим отклонения (deviations) dx/dy
     * @param array массив данных 1
     * @param average массив данных 2
     * @return возвращает массив отклонений dx/dy
     */
    public static double[] deviations(int[] array, double average) {
        int size = array.length;
        double[] deviation = new double[size];
        for (int i = 0; i < size; i++) {
            deviation[i] = array[i] - average;
        }
        return deviation;
    }
}
