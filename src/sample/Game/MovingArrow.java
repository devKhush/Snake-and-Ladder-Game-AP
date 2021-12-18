package sample.Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MovingArrow {
    private ImageView arrow;
    private ImageView arrowFaceImage;

    public MovingArrow(ImageView arrowImage, ImageView arrowFaceImage) {
        this.arrow = arrowImage;
        this.arrowFaceImage = arrowFaceImage;
    }

    public void setArrowFaceImage(Image toBeSet) {
        arrowFaceImage.setImage(toBeSet);
    }

    public ImageView getArrow() {
        return arrow;
    }
}
