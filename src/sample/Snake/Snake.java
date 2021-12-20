package sample.Snake;

import sample.Game.SnakeAndLadderGame;
import sample.Player.Player;

public class Snake {

    private SnakeAndLadderGame snakeAndLadderGame;

    public Snake(SnakeAndLadderGame snakeAndLadderGame) {
        this.snakeAndLadderGame = snakeAndLadderGame;
    }

    public void bitePlayer(Player player, double toXPosition, double toYPosition){
        player.setPlayerXLocation(toXPosition);
        player.setPlayerYLocation(toYPosition);
    }
}