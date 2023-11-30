import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Класс определяющий ячейку, куда вводится символ
 */
public class EnterCoordinateCell {
    private GameField gameField;
    private Scanner scan = new Scanner(System.in);
    private Random random = new Random();
    // чтобы ввести номер ячейки, надо знать куда вводить, т.е. нужно поле, поэтому создаю конструктор, куда передаю поле
    public EnterCoordinateCell(GameField gameField) {
        this.gameField = gameField;
    }

    /**
     * Метод для ввода координат ячейки
     * @return возвращает координаты x, y - для ввода символа
     */
    public int[] inputCoordinateCellPlayer() {
        do {
            try {
                System.out.println("Введите 2 числа столбец/строка через пробел (0 1, 2 0, 2 1 и т.д.) от 0 до 2:");
                String[] data = scan.nextLine().split(" ");
                int row = Integer.parseInt(data[0]);
                int col = Integer.parseInt(data[1]);
                if (row > gameField.getRowCount() || col > gameField.getColCount()) {
                    System.out.println("Значение строки не может быть больше " + gameField.getRowCount()
                            + " Значение столбца не может быть больше " + gameField.getColCount());
                } else if (row < 0 || col < 0) {
                    System.out.println("Строка и столбец должны быть >= 0");
                } else if (!Objects.equals(gameField.getGameField()[row][col], gameField.getCellState())) {
                    System.out.println("ячейка занята");
                } else {
                    return new int[]{row, col}; // если все проверки прошли, возвращаем координаты ячейки
                }
            }catch (Exception e){
                System.out.println("Вы ошиблись при вводе номера ячейки\n");
            }
        } while (true);
    }

    public int[] randomCoordinateCellBot(){
        do{
            int row = random.nextInt(gameField.getRowCount());
            int col = random.nextInt(gameField.getColCount());

            if (Objects.equals(gameField.getGameField()[row][col], gameField.getCellState())){
                return new int[]{row, col};
            }
        }while(true);
    }
}