/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package aufgabe4;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.sun.org.apache.bcel.internal.generic.NEW;

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

   
  
  @SuppressWarnings("rawtypes")
  @Override
  public void start(Stage primaryStage) {
    // Simulation zusammenstellen
    BVSimulation sim = erzeugeSimulationsszene();
    Thread thread= new Thread(sim);
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
    Pane pane =new Pane();
    wurzel.setRight(pane);
    
    /**
     * 4.1 Button und checkbox gesetzt
     */
    Button simbut = new Button();
    CheckBox check = new CheckBox();
    
    /**
     * 4.3 eventhandler für die KomboBox
     */
    EventHandler<ActionEvent> abstossen=new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        
        sim.getVehikel(0).setBewegung(new BVBewegungAbstossung());
      }
      
    };
    ComboBox[] comboArray=new ComboBox[sim.getAnzahlVehike()];
    Text[] txt = new Text[sim.getAnzahlVehike()];
    /**
     * 4.3 Combo Boxen erstellen
     */
    for(int i=0;i<sim.getAnzahlVehike();i++){
      comboArray[i]=new ComboBox();
      txt[i]=new Text();
      pane.getChildren().add(comboArray[i]);
      pane.getChildren().add(txt[i]);
      txt[i].setLayoutX(-50);
      txt[i].setText(sim.getVehikel(i).getName());
      
      comboArray[i].getItems().add(new BVBewegungAbstossung().getId());
      comboArray[i].getItems().add(new BVBewegungAttraktion().getId());    
      
      
      comboArray[i].setPromptText(sim.getVehikel(i).getBewegung().getId());
      if(i==0){
        txt[i].setLayoutY(100);
        
      
      comboArray[i].setLayoutY(80);
      }else{
        txt[i].setLayoutY(txt[i-1].getLayoutY()+80);
        
        comboArray[i].setLayoutY(comboArray[i-1].getLayoutY()+80);
        
      }
      
      
    }
   
    
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
    
    /**
     * 4.2 alle autos sagen wer der observer ist.
     */
    for(int i=0;i<sim.getAnzahlVehike();i++){
      sim.getVehikel(i).addObserver(canvas);
    }
    
    /**
     * 4.2sim sagen das er vom canvas beobachtet wird
     */
    sim.addObserver(canvas);
    

    check.selectedProperty().addListener(new ChangeListener<Boolean>() {

      /**
       * 4.1 Hacken setzten und entfernen momentan beim erneuten setzten fehler beim ausführen läuft nicht weiter aber über den debug läuft er weiter. scheint sich
       * auf die gui zu spielen.
       */
      @Override
      public void changed(ObservableValue<? extends Boolean> observable,
          Boolean oldValue, Boolean newValue) {
        if(!thread.isAlive()){
          thread.start();
          
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
