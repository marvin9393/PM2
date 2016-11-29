package kap08_guifx.scenebuilder;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import kap08_guifx.Datensatz;
import kap08_guifx.Person;

/**
 * Controller für Demo.fxml
 * 
 * @author Philipp Jenke
 */
public class Controller implements Initializable {

  @FXML
  private TextField titel;

  @FXML
  private VBox stationbox;

  @FXML
  private VBox zugbox;

  @FXML
  private TextField fusszeile;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    titel.setText("HBF");
 }

}
