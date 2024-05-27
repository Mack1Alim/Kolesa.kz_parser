package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Pane StartScreenPieChart;

    @FXML
    private MenuBar menubar_search;

    @FXML
    private Button search_Close_Butt;

    @FXML
    void StartScreenPieChartAct(MouseEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("mainpage.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    @FXML
    void search_close_act(ActionEvent event) {
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.stage.close();
    }

}
