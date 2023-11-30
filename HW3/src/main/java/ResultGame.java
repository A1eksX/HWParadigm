import java.util.ArrayList;
import java.util.Objects;

public class ResultGame {
    GameField gameField;

    public ResultGame(GameField gameField) {
        this.gameField = gameField;
    }

    public enum gameState {
        YOU_WIN,
        YOU_LOST,
        DRAW, // ничья
        GAME_NOT_FINISH

    }

    // Метод необходим для проверки состояния игры - checkStateGame()
    // в метода подсчитываем кол-во одинаковых символов в строке/столбце/диагонали
    // если Х - 1, 0 - -1, " " - 0
    private int calculateValue(String stateCell){
        if (Objects.equals(stateCell, gameField.getCellStateX())) return 1; // Х = 1
        else if (Objects.equals(stateCell, gameField.getCellState0())) return -1; // Х = -1
        else return 0;
    }

    /**
     * Метод проверяет игровое поле - кто победил, закончена ли игра
     * @return возвращает сообщение о победе/проигрыше/ничьей или продолжении игры
     */
    public gameState checkStateGame(){
        ArrayList<Integer> sums = new ArrayList<>();
        // проверяем строки
        for (int row = 0; row < gameField.getRowCount(); row++) {
            int sumRow = 0;
            for (int col = 0; col < gameField.getColCount(); col++) {
                sumRow += calculateValue(gameField.getGameField()[row][col]);
            }
            sums.add(sumRow);
        }
        // проверяем столбцы
        for (int col = 0; col < gameField.getColCount(); col++) {
            int sumCol = 0;
            for (int row = 0; row < gameField.getRowCount(); row++) {
                sumCol += calculateValue(gameField.getGameField()[row][col]);
            }
            sums.add(sumCol);
        }
        // проверяем диагональ лево-верх - право-низ \
        for (int rows = 0; rows < gameField.getRowCount(); rows++) {
            int sumDiagonal = 0;
            sumDiagonal += calculateValue(gameField.getGameField()[rows][rows]);
            sums.add(sumDiagonal);
        }
        // проверяем диагональ право-верх - лево-низ /
        for (int row = 0; row < gameField.getRowCount() ; row++) {
            int sumDiagonal = 0;
            sumDiagonal += calculateValue(gameField.getGameField()[row][gameField.getColCount() - 1 - row]);
            sums.add(sumDiagonal);
        }

        if (sums.contains(gameField.getRowCount())){ // если сумма равна кол-ву строк/столбцов (например 3)
            return gameState.YOU_WIN;   //   "Вы победили!";
        } else if ( sums.contains(- gameField.getRowCount())){ // если сумма равна кол-ву строк/столбцов (например -3)
            return gameState.YOU_LOST;
        } else if (allCellFilled()) {
            return gameState.DRAW; // ничья
        } else {
            return gameState.GAME_NOT_FINISH;
        }
    }

    /**
     * Метод проверяет ячейки на заполнение для завершения игры
     * @return true - если все ячейки в поле заполнены
     */
    public boolean allCellFilled(){
        for (int i = 0; i < gameField.getRowCount(); i++) {
            for (int j = 0; j < gameField.getColCount(); j++) {
                if (Objects.equals(gameField.getGameField()[i][j], gameField.getCellState())){
                    return false;
                }
            }
        }
        return true;
    }
}