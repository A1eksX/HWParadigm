/**
 * Написать программу на любом языке в любой парадигме для
 * бинарного поиска. На вход подаётся целочисленный массив и
 * число. На выходе - индекс элемента или -1, в случае если искомого
 * элемента нет в массиве.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{3,4,5,6,9,16,20,22,34,91};

        System.out.println(binarySearch(array, 4, 0, array.length));
    }

    private static int binarySearch(int[] array, int value, int left, int right) {
        if(right < left){
            return -1;
        }
        int middlePoint = (right - left) / 2 + left;
        if(value < array[middlePoint]){
            return binarySearch(array, value, left, middlePoint - 1);
        }
        if (value > array[middlePoint]){
            return binarySearch(array, value, middlePoint + 1, right);
        } else {
            return middlePoint;
        }
    }
}
