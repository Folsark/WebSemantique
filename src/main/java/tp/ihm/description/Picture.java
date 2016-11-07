package tp.ihm.description;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Picture extends Parent {

    private ImageView picture;

    final String DEFAULT_URL = "http://www.knowledgebrain.com/NothingImages/Nothing_512_512.jpg";

    public Picture() {
        Rectangle background = new Rectangle();
        background.setWidth(300);
        background.setHeight(200);
        background.setArcWidth(30);
        background.setArcHeight(30);
        background.setFill(Color.WHITE);
        background.setStroke(Color.LIGHTGREY);
        this.getChildren().add(background);
        this.setTranslateX(20);
        this.setTranslateY(80);

        this.picture = new ImageView(new Image(this.DEFAULT_URL));
        this.picture.setFitHeight(200);
        this.picture.setFitWidth(300);
        this.getChildren().add(picture);

    }

    public ImageView getPicture() {
        return picture;
    }

    public void setPicture(String path) {
        this.picture.setImage(new Image(path));
    }
}
