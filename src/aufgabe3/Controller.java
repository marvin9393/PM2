package aufgabe3;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

/**
 * 
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 3, Aufgabe 3.4
* Verwendete Quellen:
 */
public class Controller implements Initializable,Observer {

  @FXML
  private ImageView gleis1;
  @FXML
  private ImageView gleis2;
  @FXML
  private ImageView gleis3;

  Simulator s = new Simulator();
  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    s.getThread().start();
    s.getBahnhof().addObserver(this);
    }

/* (non-Javadoc)
 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
 */
@Override
public void update(Observable o, Object arg) {
	 if (s.getBahnhof().getZug(0) == null) {
	        gleis1.setOpacity((0.0));
	      
	    } else {
	      gleis1.setOpacity(1);
	    }
	 if (s.getBahnhof().getZug(1) == null) {
	      gleis2.setOpacity(0.0);
	    } else {
	      gleis2.setOpacity(1.0);
	    }
	 if (s.getBahnhof().getZug(2) == null) {
	      gleis3.setOpacity(0.0);
	 } else {
	      gleis3.setOpacity(1.0);
	 }
}
}
