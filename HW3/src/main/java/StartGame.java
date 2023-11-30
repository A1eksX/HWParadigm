public class StartGame {
    GameField gameField = new GameField(3, 3);
    EnterCoordinateCell coordinateCell = new EnterCoordinateCell(gameField);
    StagesGame stagesGame = new StagesGame(gameField, coordinateCell);
    ResultGame resultGame = new ResultGame(gameField);

    public void game(){
        boolean player = true;
        do {
            if (player){
                stagesGame.movePlayer();
                gameField.printField();
            } else {
                System.out.println("Ход бота");
                stagesGame.moveBot();
                gameField.printField();
            }
            player = !player;
            boolean res = resultGame.allCellFilled(); //если есть пустая ячейка = false, нет - true
            resultGame.checkStateGame();
            if (resultGame.checkStateGame() != ResultGame.gameState.GAME_NOT_FINISH){
                System.out.println(resultGame.checkStateGame());
                return;
            }
        } while (true);
    }
}