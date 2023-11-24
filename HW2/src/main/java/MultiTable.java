/**
 * Задача
 * На вход подается число n.
 * Написать скрипт в любой парадигме, который выводит на экран таблицу умножения всех чисел от 1 до n.
 * Обоснуйте выбор парадигм.
 *
 * Пример вывода:
 * 1 * 1 = 1
 * 1 * 2 = 2
 * 1 * 3 = 3
 * ..
 * 1 * 9 = 9
 */

public class MultiTable {
    public static void main(String[] args) {
        int n = 10;
        multiTable(n);

    }
    public static void multiTable(int n){
        for (int columns = 1; columns <= n; columns++) {
            for (int rows = 1; rows <= n; rows++) {
                System.out.print(columns * rows + "\t") ;
            }
            System.out.println();
        }
    }
}
