package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CountryPieChartController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart CountryPieChart;

    @FXML
    private Button Country_Close_Butt;

    @FXML
    private Pane StartScreenPieChart;

    @FXML
    private Button back_to_main_butt;

    @FXML
    private MenuBar mainmenubar;

    @FXML
    void Country_chart_close_act(ActionEvent event) {
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.stage.close();
    }

    @FXML
    void back_to_main_act(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("mainpage.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();

    }

    @FXML
    void initialize() {
        ObservableList<PieChart.Data> CountrypieChartData = FXCollections.observableArrayList(
                new PieChart.Data("USA",7),
                new PieChart.Data("Japan",30),
                new PieChart.Data("Germany",15),
                new PieChart.Data("Korea",22),
                new PieChart.Data("Russia",15),
                new PieChart.Data("China",12),
                new PieChart.Data("UK",2));
        CountryPieChart.setData(CountrypieChartData);

    }

}
