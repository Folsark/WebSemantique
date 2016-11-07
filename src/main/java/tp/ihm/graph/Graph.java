package tp.ihm.graph;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Graph extends Parent {

    public Graph() {
        Rectangle background = new Rectangle();
        background.setWidth(880);
        background.setHeight(680);
        background.setArcWidth(30);
        background.setArcHeight(30);
        background.setFill(Color.LIGHTGREY);
        this.getChildren().add(background);
        this.setTranslateX(20);
        this.setTranslateY(20);

        Node n = new Node(650, 350, "Aucun objet");
        Node n2 = new Node(150, 150, "Un autre objet");
        Relation r = new Relation(n, n2);
        this.getChildren().add(n);
        this.getChildren().add(n2);
        this.getChildren().add(r);
    }
}
