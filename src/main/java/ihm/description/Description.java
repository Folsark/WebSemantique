package ihm.description;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Description extends Parent {

    private Title title;

    private Picture picture;

    private Content content;

    public Description() {
        Rectangle background = new Rectangle();
        background.setWidth(340);
        background.setHeight(680);
        background.setArcWidth(30);
        background.setArcHeight(30);
        background.setFill(Color.WHITE);
        this.getChildren().add(background);
        this.setTranslateX(920);
        this.setTranslateY(20);

        this.title = new Title();
        this.getChildren().add(this.title);

        this.picture = new Picture();
        this.getChildren().add(this.picture);

        this.content = new Content();
        this.getChildren().add(this.content);
    }

    public Description setDescription(String title, String picturePath, String content) {
        this.title.setText(title);
        //this.picture.setPicture(picturePath);
        this.content.setText(content);

        return this;
    }
}
