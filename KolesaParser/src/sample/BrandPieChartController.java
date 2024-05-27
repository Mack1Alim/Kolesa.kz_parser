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

public class BrandPieChartController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane StartScreenPieChart;

    @FXML
    private Button back_to_main_butt;

    @FXML
    private Button bar_chart_Close_Butt;

    @FXML
    private PieChart brandPieChart;

    @FXML
    private MenuBar mainmenubar;

    @FXML
    void Bar_chart_close_act(ActionEvent event) {
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
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Toyota",20),
                new PieChart.Data("Subaru",5),
                new PieChart.Data("Nissan",13),
                new PieChart.Data("Kia",18),
                new PieChart.Data("Hyundai",19),
                new PieChart.Data("BMW",11),
                new PieChart.Data("Audi",8),
                new PieChart.Data("Lada",19));
        brandPieChart.setData(pieChartData);
    }

}
