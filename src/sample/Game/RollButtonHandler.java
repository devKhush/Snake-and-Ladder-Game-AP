package sample.Game;

import javafx.scene.control.Button;

public class RollButtonHandler implements Runnable{
    private Button rollButton;
    private boolean toDisable;

    public RollButtonHandler(Button rollButton, boolean toDisable) {
        this.rollButton = rollButton;
        this.toDisable = toDisable;
    }

    @Override
    public void run() {
        if (toDisable)
            rollButton.setDisable(true);
        else
            rollButton.setDisable(false);
    }
}
