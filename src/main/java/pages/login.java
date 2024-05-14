package pages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
        primaryStage.setTitle("选课系统登录");
        Scene scene = new Scene(root, 300, 200);
        scene.getStylesheets().add(getClass().getResource("/styles/login.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("images/icon.jpg")));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
