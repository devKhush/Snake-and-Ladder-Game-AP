package sample.Game;

public class MovingArrowHandler implements Runnable{
    private MovingArrow movingArrow;
    private boolean toDisplay;

    public MovingArrowHandler(MovingArrow movingArrow, boolean toDisplay) {
        this.movingArrow = movingArrow;
        this.toDisplay = toDisplay;
    }

    @Override
    public void run() {
        if (toDisplay)
            movingArrow.setArrowFaceImage(movingArrow.getArrow().getImage());
        else
            movingArrow.setArrowFaceImage(null);
    }
}
