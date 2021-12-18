package sample.Die;

import sample.Die.Die;

public class DieFaceChanger implements Runnable{
    private Die die;

    public DieFaceChanger(Die die) {
        this.die = die;
    }

    @Override
    public void run() {
//        die.getDiceFaceImage().setImage(die.getRollingDie().getImage());
//        try {
//            Thread.sleep(4000);
//        } catch (Exception e) {
//            System.out.println(e);
//            System.out.println(e.getMessage());
//            System.out.println("Thread sleep failed...");
//        }
        if (die.getFaceValue() == 1) {
            die.getDiceFaceImage().setImage(die.getDiceImage1().getImage());
        } else if (die.getFaceValue() == 2) {
            die.getDiceFaceImage().setImage(die.getDiceImage2().getImage());
        } else if (die.getFaceValue() == 3) {
            die.getDiceFaceImage().setImage(die.getDiceImage3().getImage());
        } else if (die.getFaceValue() == 4) {
            die.getDiceFaceImage().setImage(die.getDiceImage4().getImage());
        } else if (die.getFaceValue() == 5) {
            die.getDiceFaceImage().setImage(die.getDiceImage5().getImage());
        } else if (die.getFaceValue() == 6) {
            die.getDiceFaceImage().setImage(die.getDiceImage6().getImage());
        }
    }
}
