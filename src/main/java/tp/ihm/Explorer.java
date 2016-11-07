package tp.ihm;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tp.ihm.description.Description;
import tp.ihm.graph.Graph;

public class Explorer extends Application {

    public static void main(String[] args) {
        Application.launch(Explorer.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Web Semantique - H4304");
        Group root = new Group();
        Scene scene = new Scene(root, 1280, 720, Color.DARKGREY);
        Graph graph = new Graph();
        Description description = new Description();
        root.getChildren().add(graph);
        root.getChildren().add(description);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

