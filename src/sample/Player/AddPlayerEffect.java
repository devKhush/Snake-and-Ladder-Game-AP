package sample.Player;

import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import sample.Player.*;

public class AddPlayerEffect<T extends PlayerComponent> implements Runnable{
    private T playerComponent;
    boolean toGlow;

    public AddPlayerEffect(T playerComponent, boolean toGlow) {
        this.playerComponent = playerComponent;
        this.toGlow = toGlow;
    }

    @Override
    public void run() {
        if (toGlow) {
            if (playerComponent!=null && playerComponent.getClass().getName().equals("sample.Player.PlayerToken")) {
                PlayerToken token = (PlayerToken) playerComponent;
                Glow glow = new Glow(1);
                token.getPlayerTokenImage().setEffect(glow);
            }
            else if (playerComponent!=null && playerComponent.getClass().getName().equals("sample.Player.PlayerImage")){
                PlayerImage imageProfile = (PlayerImage) playerComponent;
                Glow glow = new Glow(1);
                imageProfile.getPlayerImage().setEffect(glow);
            }
            else if (playerComponent!=null && playerComponent.getClass().getName().equals("sample.Player.PlayerTextName")){
                PlayerTextName playerTextName = (PlayerTextName) playerComponent;
                Effect glow = new Glow(1);
                playerTextName.getTextName().setFill(Color.WHITE);
                playerTextName.getTextName().setEffect(glow);
                playerTextName.getTextName().setUnderline(true);
                playerTextName.getTextName().setOpacity(1);
            }
        }
        else{
            if (playerComponent != null && playerComponent.getClass().getName().equals("sample.Player.PlayerToken")) {
                PlayerToken token = (PlayerToken) playerComponent;
                Glow glow = new Glow(0.0);
                token.getPlayerTokenImage().setEffect(glow);
            }
            else if (playerComponent!=null && playerComponent.getClass().getName().equals("sample.Player.PlayerImage")){
                PlayerImage imageProfile = (PlayerImage) playerComponent;
                Glow glow = new Glow(0.0);
                imageProfile.getPlayerImage().setEffect(glow);
            }
            else if (playerComponent!=null && playerComponent.getClass().getName().equals("sample.Player.PlayerTextName")){
                PlayerTextName playerTextName = (PlayerTextName) playerComponent;
                Effect glow = new Glow(0.0);
                playerTextName.getTextName().setFill(Color.BLACK);
                playerTextName.getTextName().setEffect(glow);
                playerTextName.getTextName().setUnderline(false);
                playerTextName.getTextName().setOpacity(1);
            }
        }
    }
}
