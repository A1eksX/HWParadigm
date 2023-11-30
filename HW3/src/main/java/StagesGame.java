/**
 * Класс принимает игровое поле
 */
public class StagesGame {
    private final GameField gameField;
    private final EnterCoordinateCell enterCell;

    public StagesGame(GameField gameField, EnterCoordinateCell enterCell) {
        this.gameField = gameField;
        this.enterCell = enterCell;
    }

    /**
     * Ход игрока
     */
    public void movePlayer(){
        // получаем координаты ячейки, которые ввёл игрок
        int[] coordinates = enterCell.inputCoordinateCellPlayer();
        // в игровое поле по этим координатам ячейки надо положить Х
        gameField.getGameField()[coordinates[0]][coordinates[1]] = gameField.getCellStateX();
    }

    /**
     * Ход бота
     */
    public void moveBot(){
        int[] coordinates = enterCell.randomCoordinateCellBot();
        gameField.getGameField()[coordinates[0]][coordinates[1]] = gameField.getCellState0();
    }
}