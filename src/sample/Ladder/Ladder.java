package sample.Ladder;

import sample.Player.Player;

public class Ladder {

    public void movePlayerUp(Player player, double toXPosition, double toYPosition){
        player.setPlayerXLocation(toXPosition);
        player.setPlayerYLocation(toYPosition);
    }
}