/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package aufgabe4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.security.auth.login.CredentialExpiredException;

import com.sun.glass.events.MouseEvent;

import aufgabe4.braitenbergvehikel.BVBewegungAbstossung;
import aufgabe4.braitenbergvehikel.BVBewegungAttraktion;
import aufgabe4.braitenbergvehikel.BVSimulation;
import aufgabe4.braitenbergvehikel.BraitenbergVehikel;
import aufgabe4.braitenbergvehikel.Vektor2;
import aufgabe4.view.BVCanvas;

/**
 * JavaFX Anwendung zur Darstellung und Interaktion mit einer
 * Braitenberg-Vehikel-Simulation.
 * 
 * @author Philipp Jenke
 */
public class BVAnwendung extends Application {

  @SuppressWarnings("static-access")
  @Override
  public void start(Stage primaryStage) {
    // Simulation zusammenstellen
    BVSimulation sim = erzeugeSimulationsszene();

    // Canvas setzen
    BVCanvas canvas = new BVCanvas(600, 600, sim);
    
    Pane pane = new Pane();
    CheckBox check = new CheckBox();
    Button simbut=new Button();
    
    simbut.setText("Simuliere!");
    
    pane.getChildren().add(0, check);
    pane.getChildren().add(0, simbut);
    check.setLayoutX(71);
    simbut.setOnAction(new EventHandler<ActionEvent>(){

      @Override
      public void handle(ActionEvent event) {
        System.out.println(sim.getSignal());
        sim.simulationsSchritt();
        canvas.zeichneSimulation();
      }
      
      
    });
    

    

    canvas.zeichneSimulation();

    // Szenengraph aufbauen
    primaryStage.setTitle("Braitenberg-Vehikel!");
    BorderPane wurzel = new BorderPane();
    wurzel.setLeft(canvas);
    wurzel.setRight(pane);
    System.out.println(sim.getVehikel(0).getName());



    primaryStage.setScene(new Scene(wurzel, 800, 600));
    
    primaryStage.show();
  }

  /**
   * Erzeugt eine Simulationsszene zum Testen.
   */
  public BVSimulation erzeugeSimulationsszene() {
    BraitenbergVehikel vehikel1 =
        new BraitenbergVehikel("Susi", new BVBewegungAttraktion());
    BraitenbergVehikel vehikel2 = new BraitenbergVehikel("Mike",
        new BVBewegungAbstossung(), new Vektor2(-100, 100), new Vektor2(1, 0));
    BVSimulation sim = new BVSimulation();
    sim.vehikelHinzufuegen(vehikel1);
    sim.vehikelHinzufuegen(vehikel2);
    return sim;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
