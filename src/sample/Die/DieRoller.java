package sample.Die;

public class DieRoller implements Runnable{
    private Die die;

    public DieRoller(Die die) {
        this.die = die;
    }

    @Override
    public void run() {
        die.getDiceFaceImage().setImage(die.getRollingDie().getImage());
    }
}
