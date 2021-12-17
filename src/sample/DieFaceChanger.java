package sample;

public class DieFaceChanger implements Runnable{
    private Die die;

    public DieFaceChanger(Die die) {
        this.die = die;
    }

    @Override
    public void run() {
        if (die.getFaceValue() == 1) {
            die.getDiceFaceImage().setImage(die.getDice_image1().getImage());
        } else if (die.getFaceValue() == 2) {
            die.getDiceFaceImage().setImage(die.getDice_image2().getImage());
        } else if (die.getFaceValue() == 3) {
            die.getDiceFaceImage().setImage(die.getDice_image3().getImage());
        } else if (die.getFaceValue() == 4) {
            die.getDiceFaceImage().setImage(die.getDice_image4().getImage());
        } else if (die.getFaceValue() == 5) {
            die.getDiceFaceImage().setImage(die.getDice_image5().getImage());
        } else if (die.getFaceValue() == 6) {
            die.getDiceFaceImage().setImage(die.getDice_image6().getImage());
        }
    }
}
