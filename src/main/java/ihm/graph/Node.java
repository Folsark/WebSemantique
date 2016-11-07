package ihm.graph;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;

public class Node extends Parent {

    public static final double DEFAULT_RADIUS_X = 110;
    public static final double DEFAULT_RADIUS_Y = 25;
    public static final double DEFAULT_POS_X = 300;
    public static final double DEFAULT_POS_Y = 300;
    public static final double DEFAULT_FONT = 14;
    final int MAX_LENGTH = 25;
    final String DEFAULT_TEXT = "Un objet";

    private Button button;

    private double x;
    private double y;

    private Tooltip tooltip;

    public Node() {
        this.x = DEFAULT_POS_X;
        this.y = DEFAULT_POS_Y;

        Ellipse ellipse = new Ellipse();
        ellipse.setRadiusX(this.DEFAULT_RADIUS_X);
        ellipse.setRadiusY(this.DEFAULT_RADIUS_Y);
        ellipse.setCenterX(this.DEFAULT_POS_X);
        ellipse.setCenterY(this.DEFAULT_POS_Y);
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.DARKGREY);

        this.getChildren().add(ellipse);

        this.button = new Button(this.DEFAULT_TEXT);
        this.button.setFont(new Font(14));
        this.button.setTranslateX(this.DEFAULT_POS_X - this.DEFAULT_RADIUS_X / 2);
        this.button.setTranslateY(this.DEFAULT_POS_Y - 5 - this.DEFAULT_RADIUS_Y / 2);

        this.getChildren().add(this.button);
    }

    public Node(double x, double y, String text) {
        this.x = x;
        this.y = y;

        Ellipse ellipse = new Ellipse();
        ellipse.setRadiusX(this.DEFAULT_RADIUS_X);
        ellipse.setRadiusY(this.DEFAULT_RADIUS_Y);
        ellipse.setCenterX(x);
        ellipse.setCenterY(y);
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.DARKGREY);

        this.getChildren().add(ellipse);

        this.button = new Button();
        this.button.setFont(new Font(this.DEFAULT_FONT));
        this.button.setTranslateX(x - this.DEFAULT_RADIUS_X / 2);
        this.button.setTranslateY(y - 3 - this.DEFAULT_RADIUS_Y / 2);

        this.getChildren().add(this.button);

        this.tooltip = new Tooltip();

        this.setText(text);

    }

    public Node setText(String text) {
        String truncText = text;
        if (text.length() > this.MAX_LENGTH) {
            truncText = text.substring(0, this.MAX_LENGTH - 1) + "...";
        }
        this.button.setText(truncText);
        this.tooltip.setText(text);

        return this;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
