package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView logo;

    @FXML
    private TextField city;

    @FXML
    private Button getData;

    @FXML
    private Text temp_info;

    @FXML
    private Text temp_feels;

    @FXML
    private Text temp_max;

    @FXML
    private Text temp_min;

    @FXML
    private Text pressure;

    @FXML
    private ImageView image;

    @FXML
    void initialize() {
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file 'sample.fxml'.";
        assert city != null : "fx:id=\"city\" was not injected: check your FXML file 'sample.fxml'.";
        assert getData != null : "fx:id=\"getData\" was not injected: check your FXML file 'sample.fxml'.";
        assert temp_info != null : "fx:id=\"temp_info\" was not injected: check your FXML file 'sample.fxml'.";
        assert temp_feels != null : "fx:id=\"temp_feels\" was not injected: check your FXML file 'sample.fxml'.";
        assert temp_max != null : "fx:id=\"temp_max\" was not injected: check your FXML file 'sample.fxml'.";
        assert temp_min != null : "fx:id=\"temp_min\" was not injected: check your FXML file 'sample.fxml'.";
        assert pressure != null : "fx:id=\"pressure\" was not injected: check your FXML file 'sample.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
