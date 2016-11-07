package ihm.description;

import javafx.scene.Parent;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Title extends Parent {

    private Text text;

    private Tooltip tooltip;

    final int MAX_LENGTH = 25;
    final String DEFAULT_STRING = "Aucun élément selectionné";

    public Title() {
        Rectangle background = new Rectangle();
        background.setWidth(300);
        background.setHeight(40);
        background.setArcWidth(30);
        background.setArcHeight(30);
        background.setFill(Color.WHITE);
        background.setStroke(Color.LIGHTGREY);
        this.getChildren().add(background);
        this.setTranslateX(20);
        this.setTranslateY(20);

        this.text = new Text(this.DEFAULT_STRING);
        this.text.setWrappingWidth(300);
        this.text.setFont(new Font(20));
        this.text.setTranslateX(10);
        this.text.setTranslateY(27);
        this.getChildren().add(this.text);

        this.tooltip = new Tooltip(this.DEFAULT_STRING);
        Tooltip.install(this.text, this.tooltip);
    }

    public Title setText(String text) {
        String truncText = text;
        if (text.length() > this.MAX_LENGTH) {
            truncText = text.substring(0, this.MAX_LENGTH - 1) + "...";
        }
        this.text.setText(truncText);
        this.tooltip.setText(text);

        return this;
    }
}
