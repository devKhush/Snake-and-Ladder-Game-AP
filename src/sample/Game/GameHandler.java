package sample.Game;

import javafx.application.Platform;
import sample.Player.Player;

public class GameHandler extends Thread{
    private Player player1, player2;
    private SnakeAndLadderGame game;

    public GameHandler(Player player1, Player player2, SnakeAndLadderGame game) {
        this.player1 = player1;
        this.player2 = player2;
        this.game = game;
    }

    @Override
    public void run() {
        Platform.runLater(new MovingArrowHandler(game.getMovingArrow(),false));
        if (game.ifPlayer1Turn()) {
            player1.rollDie(game.getDie());
            game.getDie().setDiceFaceImage(game.getDie().getFaceValue());
            Platform.runLater(new RollButtonHandler(game.getRollButton(),true));
            if (game.ifPlayer1Turn() && player1.isPlayerGameStarted()) {
                player1.movePLayer(game.getDie().getFaceValue(), game.getLadder(), game.getSnake());

            }
            if ((game.ifPlayer1Turn()) && (!player1.isPlayerGameStarted()) && (game.getDie().getFaceValue() == 1)) {
                player1.initialMove();
            }
            player1.dimPlayer();
            player2.glowPlayer();
            Platform.runLater(new RollButtonHandler(game.getRollButton(),false));
        }

        else if (game.ifPlayer2Turn()) {
            player2.rollDie(game.getDie());
            game.getDie().setDiceFaceImage(game.getDie().getFaceValue());
            Platform.runLater(new RollButtonHandler(game.getRollButton(),true));
            if (game.ifPlayer2Turn() && player2.isPlayerGameStarted()) {
                player2.movePLayer(game.getDie().getFaceValue(), game.getLadder(), game.getSnake());
            }
            if ((game.ifPlayer2Turn()) && (!player2.isPlayerGameStarted()) && (game.getDie().getFaceValue() == 1)) {
                player2.initialMove();
            }
            player2.dimPlayer();
            player1.glowPlayer();
            Platform.runLater(new RollButtonHandler(game.getRollButton(),false));
        }

        Platform.runLater(new MovingArrowHandler(game.getMovingArrow(),true));

        game.setGameOver(player1.isPlayerWon() || player2.isPlayerWon());
        if (game.isGameOver()){
            Platform.runLater(new MovingArrowHandler(game.getMovingArrow(),false));
            System.out.println("Someone Won");
            if (player1.isPlayerWon()) {
                EndGameResult.setWinner(player1);
                EndGameResult.setLooser(player2);
                System.out.println("Player 1 won");
            }
            else if (player2.isPlayerWon()){
                EndGameResult.setWinner(player2);
                EndGameResult.setLooser(player1);
                System.out.println("Player 2 won");
            }
            Platform.runLater(new EndResultOpener(game));
        }
    }
}
