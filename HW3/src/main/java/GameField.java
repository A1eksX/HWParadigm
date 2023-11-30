public class GameField {
    private String[][] gameField;
    private final int rowCount;
    private final int colCount;
    private final String cellState = " ";   // состояние ячейки
    private final String cellStateX = "X";  // состояние ячейки X
    private final String cellState0 = "0";  // состояние ячейки 0


    public String getCellState() {
        return cellState;
    }

    public String getCellStateX() {
        return cellStateX;
    }

    public String getCellState0() {
        return cellState0;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public String[][] getGameField() {
        return gameField;
    }

    // в конструкторе инициализирую 2D массив и заполняю его " "
    public GameField(int rowCount, int colCount) {
        gameField = new String[rowCount][colCount];
        this.rowCount = rowCount;
        this.colCount = colCount;
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                gameField[row][col] = cellState;
            }
        }
    }
    public void printField() {
        System.out.println("----------");
        for (int col = 0; col < this.rowCount; col++) {
            System.out.print(gameField[col][0] + " | " + gameField[col][1] + " | " + gameField[col][2]);
            System.out.println();
            System.out.println("----------");
        }
    }
}