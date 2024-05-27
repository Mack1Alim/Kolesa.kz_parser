package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Text bar_chart_text;

    @FXML
    private ImageView Bar_chart_by_year;

    @FXML
    private ImageView Countries_pie_chart;

    @FXML
    private ImageView Data_search_table;

    @FXML
    private Button Main_Close_Butt;

    @FXML
    private Pane StartScreenPieChart;

    @FXML
    private Button back_to_start_butt;

    @FXML
    private ImageView brand_pie_chart;

    @FXML
    private MenuBar mainmenubar;

    @FXML
    void Main_close_act(ActionEvent event) {
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.stage.close();

    }

    @FXML
    void Open_country_pie_chart(MouseEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("countrypiechart.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    @FXML
    void Open_search_table(MouseEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("searchtable.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();

    }

    @FXML
    void back_to_start_act(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("startpage.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();

    }

    @FXML
    void open_bar_chart(MouseEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("barchart.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();

    }

    @FXML
    void open_bar_chart_text(MouseEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("barchart.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    @FXML
    void open_brand_pie_chart(MouseEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("brandpiechart.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();

    }

}
