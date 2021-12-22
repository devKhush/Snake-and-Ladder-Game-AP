package sample.Ladder;

import sample.Game.SnakeAndLadderGame;
import sample.Player.Player;

public class Ladder {

    private SnakeAndLadderGame snakeAndLadderGame;

    public Ladder(SnakeAndLadderGame snakeAndLadderGame) {
        this.snakeAndLadderGame = snakeAndLadderGame;
    }

    public void movePlayerUp(Player player, double toXPosition, double toYPosition){
        try {
            Thread.sleep(800);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println("Thread sleep failed in Player class...");
        }
        player.setPlayerXLocation(toXPosition);
        player.setPlayerYLocation(toYPosition);
    }
}