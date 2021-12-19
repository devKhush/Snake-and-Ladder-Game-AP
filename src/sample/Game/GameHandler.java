package sample.Game;

import javafx.application.Platform;
import sample.Die.DieRoller;
import sample.Player.Player;

public class GameHandler extends Thread{
    private Player player1, player2;
    private SnakeAndLadderGame game;
    private MovingArrow movingArrow;
    private RollButton rollButton;
    private MovingArrowHandler movingArrowHandler;
    private EndResultOpener endResultOpener;
    private RollButtonDisabler rollButtonDisabler;
    private DieRoller dieRoller;

    public GameHandler(Player player1, Player player2, SnakeAndLadderGame game) {
        this.player1 = player1;
        this.player2 = player2;
        this.game = game;
        this.rollButton = game.getRollButton();
        this.movingArrow = game.getMovingArrow();
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
            if (player1.isPlayerWon()) {
                EndGameResult.setWinner(player1);
                EndGameResult.setLooser(player2);
                EndGameResult.setGameToBeClose(game);
                System.out.println("Player 1 won");
            }
            else if (player2.isPlayerWon()){
                EndGameResult.setWinner(player2);
                EndGameResult.setLooser(player1);
                EndGameResult.setGameToBeClose(game);
                System.out.println("Player 2 won");
            }
            endResultOpener = new EndResultOpener(game);
            Platform.runLater(endResultOpener);
        }
    }
}
