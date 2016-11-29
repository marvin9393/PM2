package augabe3_1;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * JavaFX-Application which used the Scene Builder to layout the components.
 * 
 * @author Philipp Jenke
 */
public class Main extends Application {
  @Override
  public void start(Stage primaryStage) {
    try {
      BorderPane wurzel =
          (BorderPane)FXMLLoader.load(getClass().getResource("./GuiBahnhof.fxml"));
      Scene scene = new Scene(wurzel, 800, 400);
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
