/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package aufgabe4;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import com.sun.javafx.scene.paint.GradientUtils.Point;
import com.sun.xml.internal.ws.server.provider.AsyncProviderInvokerTube.FiberResumer;

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

  @Override
  public void start(Stage primaryStage) {
    // Simulation zusammenstellen
    BVSimulation sim = erzeugeSimulationsszene();

    // Canvas setzen
    BVCanvas canvas = new BVCanvas(600, 600, sim);

    canvas.zeichneSimulation();

    // Szenengraph aufbauen
    primaryStage.setTitle("Braitenberg-Vehikel!");
    BorderPane wurzel = new BorderPane();
    wurzel.setCenter(canvas);

    primaryStage.setScene(new Scene(wurzel, 850, 600));
    primaryStage.show();

    /**
     * 4.1 Pane gesetzt und an der rechten seite der boarder pane hinzugefügt.
     */
    Pane pane = new Pane();
    wurzel.setRight(pane);

    /**
     * 4.1 Button und checkbox gesetzt
     */
    Button simbut = new Button();
    CheckBox check = new CheckBox();

    /**
     * 4.1 Button und checkbox zur pane hinzugefügt.
     */
    pane.getChildren().add(simbut);
    pane.getChildren().add(check);

    /**
     * 4.1 die checkbox runter gesetzt
     */
    check.setLayoutY(60);

    /**
     * 4.1 Text gesetzt
     */
    simbut.setText("Simuliere!");
    check.setText("Simuliere");

    simbut.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        sim.simulationsSchritt();
      }
    });

    //check.setOnMouseClicked(new EventHandler<MouseEvent>() {

//      @Override
//      public void handle(MouseEvent event) {
//        if (!sim.getVehikel(0).getPosition().equals(sim.getSignal())&&check.isSelected()) {
//          sim.start();
//          
//        } else{
//          sim.getVehikel(0).setPosition(sim.getVehikel(0).getPosition());
//          sim.getVehikel(1).setPosition(sim.getVehikel(1).getPosition());
//          
//        }
//      }
//
//    });

    /**
     * 4.2 alle autos sagen wer der observer ist.
     */
    for (int i = 0; i < sim.getAnzahlVehike(); i++) {
      sim.getVehikel(i).addObserver(canvas);
    }
     check.selectedProperty().addListener(new ChangeListener<Boolean>() {
    
     /**
     * 4.1 Hacken setzten und entfernen momentan beim erneuten setzten fehler
     beim ausführen läuft nicht weiter aber über den debug läuft er
     weiter. scheint sich
     * auf die gui zu spielen.
     */
     public void changed(ObservableValue<? extends Boolean> observable,
     Boolean oldValue, Boolean newValue) {
    
     if(!sim.isAlive()){
     sim.start();
     }
     if(newValue){
     sim.isGedrueckt=true;
     System.out.println(sim.isGedrueckt);
     }
     if(oldValue){
     sim.isGedrueckt=false;
     System.out.println(sim.isGedrueckt);
     }
    
    
    
    
     }
    
     });

  }

  /**
   * Erzeugt eine Simulationsszene zum Testen.
   */
  public BVSimulation erzeugeSimulationsszene() {
    BraitenbergVehikel vehikel1 = new BraitenbergVehikel("Susi",
        new BVBewegungAttraktion());
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
