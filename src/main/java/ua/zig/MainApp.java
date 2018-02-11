package ua.zig;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {
    public static final int DISTANCE = 5000000;

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(getClass().getResource("/fxml/Scene.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("Races");
        stage.setScene(scene);
        System.out.println(Thread.currentThread().getName());
        stage.show();

        stage.setOnCloseRequest(event -> System.exit(0));
    }


    public static void main(String[] args) {
        launch(args);
    }

}
