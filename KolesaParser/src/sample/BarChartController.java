package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BarChartController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    final static String aa = "1980";
    final static String bb = "1990";
    final static String cc = "2000";
    final static String dd = "2010";
    final static String ee = "2020";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<?, ?> Bar_Chart_Diagram;




    @FXML
    private NumberAxis Count_category;

    @FXML
    private Pane StartScreenPieChart;

    @FXML
    private CategoryAxis Year_category;

    @FXML
    private Button back_to_main_butt;

    @FXML
    private Button bar_chart_Close_Butt;

    @FXML
    private Button button;

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
    void starter(ActionEvent event) {

    }

    @FXML
    void initialize() {


        XYChart.Series series1 = new XYChart.Series();
        series1.setName("USA");
        series1.getData().add(new XYChart.Data(aa, 25601.34));
        series1.getData().add(new XYChart.Data(bb, 20148.82));
        series1.getData().add(new XYChart.Data(cc, 10000));
        series1.getData().add(new XYChart.Data(dd, 35407.15));
        series1.getData().add(new XYChart.Data(ee, 12000));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Japan");
        series2.getData().add(new XYChart.Data(aa, 57401.85));
        series2.getData().add(new XYChart.Data(bb, 41941.19));
        series2.getData().add(new XYChart.Data(cc, 45263.37));
        series2.getData().add(new XYChart.Data(dd, 51732.16));
        series2.getData().add(new XYChart.Data(ee, 14845.27));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Germany");
        series3.getData().add(new XYChart.Data(aa, 45000.65));
        series3.getData().add(new XYChart.Data(bb, 44835.76));
        series3.getData().add(new XYChart.Data(cc, 18722.18));
        series3.getData().add(new XYChart.Data(dd, 17557.31));
        series3.getData().add(new XYChart.Data(ee, 92633.68));

        Bar_Chart_Diagram.getData().addAll(series1,series2,series3);

    }

}
