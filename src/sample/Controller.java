package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.json.JSONObject;

public class Controller {
    boolean catchedEx = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView logo;

    @FXML
    private TextField city;

    @FXML
    private Text info_table;

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
    private ImageView great;

    @FXML
    void initialize() {
        getData.setOnAction(event -> {
            String getUserCity = city.getText().trim();

            if (!getUserCity.equals("")) {
                String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=" + getUserCity + "&appid=82b797b6ebc625032318e16f1b42c016&units=metric");
                if (!output.isEmpty() && !catchedEx) {
                    image.setVisible(false);
                    great.setVisible(true);

                    info_table.setText("ИНФОРМАЦИЯ:");
                    JSONObject obj = new JSONObject(output);
                    temp_info.setText("Температура: " + obj.getJSONObject("main").getDouble("temp"));
                    temp_feels.setText("Ощущается: " + obj.getJSONObject("main").getDouble("feels_like"));
                    temp_max.setText("Макс.: " + obj.getJSONObject("main").getDouble("temp_max"));
                    temp_min.setText("Мин.: " + obj.getJSONObject("main").getDouble("temp_min"));
                    pressure.setText("Давление: " + obj.getJSONObject("main").getDouble("pressure"));
                }
            }
        });
    }

    private String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlCon = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line + "\n");
            }
            catchedEx = false;
            reader.close();
        } catch (Exception e) {
            catchedEx = true;
            image.setVisible(true);
            great.setVisible(false);

            info_table.setText("Город не найден!");
            temp_info.setText("Температура: ");
            temp_feels.setText("Ощущается: ");
            temp_max.setText("Макс.: ");
            temp_min.setText("Мин.: ");
            pressure.setText("Давление:");
        }
        return content.toString();
    }
}
