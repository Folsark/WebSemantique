package tp.ihm.description;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Content extends Parent {

    private Text text;

    public Content() {
        Rectangle background = new Rectangle();
        background.setWidth(300);
        background.setHeight(360);
        background.setArcWidth(30);
        background.setArcHeight(30);
        background.setFill(Color.WHITE);
        background.setStroke(Color.LIGHTGREY);
        this.getChildren().add(background);
        this.setTranslateX(20);
        this.setTranslateY(300);

        this.text = new Text();
        this.text = new Text("Aucun élément sélectionné Aucun élément sélectionné Aucun élément sélectionné Aucun élément sélectionné");
        this.text.setWrappingWidth(300);
        this.text.setFont(new Font(10));
        this.text.setTranslateX(10);
        this.text.setTranslateY(22);
        this.getChildren().add(this.text);
    }

    public void setText(String text) {
        this.text.setText(text);
    }
}
