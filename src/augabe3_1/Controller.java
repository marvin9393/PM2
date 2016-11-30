package augabe3_1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

/**
 * Controller für Demo.fxml
 * 
 * @author Philipp Jenke
 */
public class Controller implements Initializable {

  @FXML
  private TextArea konsole;
  @FXML
  private ImageView gleis1;
  @FXML
  private ImageView gleis2;
  @FXML
  private ImageView gleis3;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Simulator s = new Simulator();
    s.getThread().start();
    
    if (s.getBahnhof().getZug(0) == null) {
        gleis1.setOpacity((0.0));
      
    } else {
      //erscheinen
      for(double i=0;i<=10;i++){
        gleis1.setOpacity((i/10));
        System.out.println(gleis1.getOpacity());
      }
      //danach von rechts nach links?
    }
    if (s.getBahnhof().getZug(0) == null) {
      gleis2.setOpacity(0.0);
    } else {
      gleis2.setOpacity(1.0);
    }
    if (s.getBahnhof().getZug(0) == null) {
      gleis3.setOpacity(0.0);
    } else {
      gleis3.setOpacity(1.0);
    }

  }

}
