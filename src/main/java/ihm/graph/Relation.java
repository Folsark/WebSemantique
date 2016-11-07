package ihm.graph;

import javafx.scene.Parent;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

import java.awt.*;

public class Relation extends Parent {

    private Node start;

    private Node end;

    private double xStart;
    private double yStart;
    private double xEnd;
    private double yEnd;

    private String text;

    public Relation() {
        this.xStart = 0;
        this.xEnd = 0;
        this.yStart = 0;
        this.yEnd = 0;
    }

    public Relation(Node s, Node e) {
        this.start = s;
        this.end = e;

        double xDiff = s.getX() - e.getX();
        double yDiff = s.getY() - e.getY();

        System.out.println(xDiff + "  ---- " + yDiff);

        if (xDiff >= 0) {
            if (xDiff >= 2*Node.DEFAULT_RADIUS_X) {
                xStart = s.getX() - Node.DEFAULT_RADIUS_X;
                xEnd = e.getX() + Node.DEFAULT_RADIUS_X;
                yStart = s.getY();
                yEnd = e.getY();
            } else if (yDiff >= 0) {
                xStart = s.getX();
                xEnd = e.getX();
                yStart = s.getY() - Node.DEFAULT_RADIUS_Y;
                yEnd = e.getY() + Node.DEFAULT_RADIUS_Y;
            } else {
                xStart = s.getX();
                xEnd = e.getX();
                yStart = s.getY() + Node.DEFAULT_RADIUS_Y;
                yEnd = e.getY() - Node.DEFAULT_RADIUS_Y;
            }
        } else {
            xStart = s.getX() + Node.DEFAULT_RADIUS_X;
            xEnd = e.getX() - Node.DEFAULT_RADIUS_X;
        }

        Line l = new Line(this.xStart, this.yStart, this.xEnd, this.yEnd);
        this.getChildren().add(l);
    }
}
