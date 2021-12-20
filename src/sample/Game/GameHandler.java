package sample.Game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import sample.Die.DieRoller;
import sample.Player.Player;
import java.io.IOException;

public class GameHandler extends Thread{
    private Player player1, player2;
    private SnakeAndLadderGame game;
    private MovingArrow movingArrow;
    private RollButton rollButton;
    private MovingArrowHandler movingArrowHandler;
    private EndResultOpener endResultOpener;
    private RollButtonDisabler rollButtonDisabler;
    private DieRoller dieRoller;
    private EndGameResult endGameResult;
    private ActionEvent event;

    public GameHandler(SnakeAndLadderGame game, ActionEvent event) {
        this.player1 = game.getPlayer1();
        this.player2 = game.getPlayer2();
        this.game = game;
        this.rollButton = game.getRollButton();
        this.movingArrow = game.getMovingArrow();
        this.endGameResult = game.getGameEndGameResult();
        this.event = event;
    }

    @Override
    public void run() {
        movingArrowHandler = new MovingArrowHandler(game.getMovingArrow(),false);
        Platform.runLater(movingArrowHandler);
        if (game.ifPlayer1Turn()) {
            rollButtonDisabler = new RollButtonDisabler(game.getRollButton(),true);
            Platform.runLater(rollButtonDisabler);
            dieRoller = new DieRoller(game.getDie());
            Platform.runLater(dieRoller);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
                System.out.println("Die rolling gif thread sleep failed...");
            }
            player1.rollDie(game.getDie());
            game.getDie().setDiceFaceImage(game.getDie().getFaceValue());
            if (game.ifPlayer1Turn() && player1.isPlayerGameStarted()) {
                player1.movePLayer(game.getDie().getFaceValue(), game.getLadder(), game.getSnake());

            }
            if ((game.ifPlayer1Turn()) && (!player1.isPlayerGameStarted()) && (game.getDie().getFaceValue() == 1)) {
                player1.initialMove();
            }
            player1.dimPlayer();
            player2.glowPlayer();
            rollButtonDisabler = new RollButtonDisabler(game.getRollButton(),false);
            Platform.runLater(rollButtonDisabler);
        }

        else if (game.ifPlayer2Turn()) {
            rollButtonDisabler = new RollButtonDisabler(game.getRollButton(),true);
            Platform.runLater(rollButtonDisabler);
            dieRoller = new DieRoller(game.getDie());
            Platform.runLater(dieRoller);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
                System.out.println("Die rolling gif thread sleep failed...");
            }
            player2.rollDie(game.getDie());
            game.getDie().setDiceFaceImage(game.getDie().getFaceValue());
            if (game.ifPlayer2Turn() && player2.isPlayerGameStarted()) {
                player2.movePLayer(game.getDie().getFaceValue(), game.getLadder(), game.getSnake());
            }
            if ((game.ifPlayer2Turn()) && (!player2.isPlayerGameStarted()) && (game.getDie().getFaceValue() == 1)) {
                player2.initialMove();
            }
            player2.dimPlayer();
            player1.glowPlayer();
            rollButtonDisabler = new RollButtonDisabler(game.getRollButton(),false);
            Platform.runLater(rollButtonDisabler);
        }

        movingArrowHandler = new MovingArrowHandler(game.getMovingArrow(),true);
        Platform.runLater(movingArrowHandler);

        game.setGameOver(player1.isPlayerWon() || player2.isPlayerWon());
        if (game.isGameOver()){
            movingArrowHandler = new MovingArrowHandler(game.getMovingArrow(),false);
            Platform.runLater(movingArrowHandler);
            System.out.println("Someone Won");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../EndGameResult.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                System.out.println("Loader failed...");
            }
            endGameResult = loader.getController();
            System.out.println(endGameResult);
            game.setGameEndGameResult(endGameResult);

            if (player1.isPlayerWon()) {
                endGameResult.setWinner(player1);
                endGameResult.setLooser(player2);
                endGameResult.setGameToBeClose(game);
                System.out.println("Player 1 won");
            }
            else if (player2.isPlayerWon()){
                endGameResult.setWinner(player2);
                endGameResult.setLooser(player1);
                endGameResult.setGameToBeClose(game);
                System.out.println("Player 2 won");
            }
            endResultOpener = new EndResultOpener(game,event, root);
            Platform.runLater(endResultOpener);
        }
    }
}
