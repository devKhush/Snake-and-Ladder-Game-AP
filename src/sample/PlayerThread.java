package sample;

public class PlayerThread extends Thread{
    Player player1, player2;
    SnakeAndLadderGame game;

    public PlayerThread(Player player1, Player player2, SnakeAndLadderGame game) {
        this.player1 = player1;
        this.player2 = player2;
        this.game = game;
    }

    @Override
    public void run() {
        if (game.ifPlayer1Turn()) {
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
        }

        else if (game.ifPlayer2Turn()) {
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
        }
        game.count++;
    }
}
