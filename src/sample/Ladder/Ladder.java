package sample.Ladder;

import sample.Game.SnakeAndLadderGame;
import sample.Player.Player;

public class Ladder {

    private SnakeAndLadderGame snakeAndLadderGame;

    public Ladder(SnakeAndLadderGame snakeAndLadderGame) {
        this.snakeAndLadderGame = snakeAndLadderGame;
    }

    public void movePlayerUp(Player player, double toXPosition, double toYPosition){
        player.setPlayerXLocation(toXPosition);
        player.setPlayerYLocation(toYPosition);
    }
}