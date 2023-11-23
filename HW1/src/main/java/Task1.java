import java.util.Arrays;

public class Task1 {
    /*
    Задача №1
    Дан список целых чисел numbers. Необходимо написать в императивном стиле процедуру для
    сортировки числа в списке в порядке убывания. Можно использовать любой алгоритм сортировки
     Задача №2
    Написать точно такую же процедуру, но в декларативном стиле
     */
    public static void main(String[] args) {
        int [] array = new int[]{5, 2, 4, 5, 3, 4, 1, 8, 6, 9};

        // Task 1
//        sortMyArray(array);

//        sortSelect(array);

//        sortInsert(array);

        // Task 2
        Arrays.sort(array);


        for (int item:array) {
            System.out.print(item + " ");
        }

    }
    public static int[] sortMyArray(int [] array){
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int [] sortSelect(int [] array){  // 0  1  2  3  4  5  6  7  8  9
        int temp;
        int indexMin;
        for (int i = 0; i < array.length; i++) {    // 5, 2, 4, 5, 3, 4, 1, 8, 6, 9
            indexMin = i; // 0-1,
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[indexMin]){
                    indexMin = j;
                }
            }
            if (i != indexMin){
                temp = array[i];
                array[i] = array[indexMin];
                array[indexMin] = temp;
            }
        }
        return array;
    }

    public static int [] sortInsert(int [] array){
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length ; j++) {
                if (array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

}
