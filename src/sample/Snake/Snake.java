package sample.Snake;

import sample.Player.Player;

public class Snake {

    public void bitePlayer(Player player, double toXPosition, double toYPosition){
        player.setPlayerXLocation(toXPosition);
        player.setPlayerYLocation(toYPosition);
    }
}