package sample.Game;

import javafx.scene.control.Button;

public class RollButtonHandler implements Runnable{
    private RollButton rollButton;
    private boolean toDisable;

    public RollButtonHandler(RollButton rollButton, boolean toDisable) {
        this.rollButton = rollButton;
        this.toDisable = toDisable;
    }

    @Override
    public void run() {
        if (toDisable)
            rollButton.getRollButton().setDisable(true);
        else
            rollButton.getRollButton().setDisable(false);
    }
}
