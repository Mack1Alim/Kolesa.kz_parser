package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SearchTableController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    String query = null;
    @FXML
    private Button back_to_log_butt;
    @FXML
    private MenuBar menubar_search;

    @FXML
    private TableView<ProductSearchModel> productTableView;
    @FXML
    private TextField productTextField;
    @FXML
    private TableColumn<ProductSearchModel, String> car_body_type_col;
    @FXML
    private TableColumn<ProductSearchModel, String> car_brand_col;
    @FXML
    private TableColumn<ProductSearchModel, String> car_city_col;
    @FXML
    private TableColumn<ProductSearchModel, String> car_color_col;
    @FXML
    private TableColumn<ProductSearchModel, String> car_drive_col;
    @FXML
    private TableColumn<ProductSearchModel, String> car_eng_col;
    @FXML
    private TableColumn<ProductSearchModel, String> car_gen_col;
    @FXML
    private TableColumn<ProductSearchModel, String> car_link_col;
    @FXML
    private TableColumn<ProductSearchModel, String> car_mileage_col;
    @FXML
    private TableColumn<ProductSearchModel, String> car_name_col;
    @FXML
    private TableColumn<ProductSearchModel, String> car_passtamoj_col;
    @FXML
    private TableColumn<ProductSearchModel, String> car_price_col;
    @FXML
    private TableColumn<ProductSearchModel, String> car_trans_col;
    @FXML
    private TableColumn<ProductSearchModel, String> car_wheel_col;
    @FXML
    private TableColumn<ProductSearchModel, String> car_year_col;
    ObservableList<ProductSearchModel>productSearchModelObservableList= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resource)
    {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB=connectNow.getDBConnection();
        String productViewQuery="SELECT car_link,car_brand,car_name,car_year,car_city,car_gen,car_body_type,car_engine_capacity,car_mileage,car_transmission,car_drive_unit,car_wheel,car_color,car_passtamoj,car_price FROM kolesa_ttb";
        try{
            Statement statement= connectDB.createStatement();
            ResultSet queryOutput= statement.executeQuery(productViewQuery);
            while(queryOutput.next()){
                String queryLink=queryOutput.getString("car_link");
                String queryBrand=queryOutput.getString("car_brand");
                String queryName=queryOutput.getString("car_name");
                String queryYear=queryOutput.getString("car_year");
                String queryCity=queryOutput.getString("car_city");
                String queryGen=queryOutput.getString("car_gen");
                String queryBody_Type=queryOutput.getString("car_body_type");
                String queryEngine_capacity=queryOutput.getString("car_engine_capacity");
                String queryMileage=queryOutput.getString("car_mileage");
                String queryTrasmission=queryOutput.getString("car_transmission");
                String queryDrive_unit=queryOutput.getString("car_drive_unit");
                String queryWheel=queryOutput.getString("car_wheel");
                String queryColor=queryOutput.getString("car_color");
                String queryPasstamoj=queryOutput.getString("car_passtamoj");
                String queryPrice=queryOutput.getString("car_price");
                productSearchModelObservableList.add(new ProductSearchModel(queryLink,queryBrand,queryName,queryYear,queryCity,queryGen,queryBody_Type,queryEngine_capacity,queryMileage,queryTrasmission,queryDrive_unit,queryWheel,queryColor,queryPasstamoj,queryPrice));
            }
            car_link_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_link"));
            car_brand_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_brand"));
            car_name_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_name"));
            car_year_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_year"));
            car_city_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_city"));
            car_gen_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_gen"));
            car_body_type_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_body_type"));
            car_eng_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_engine_capacity"));
            car_mileage_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_mileage"));
            car_trans_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_transmission"));
            car_drive_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_drive_unit"));
            car_wheel_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_wheel"));
            car_color_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_color"));
            car_passtamoj_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_passtamoj"));
            car_price_col.setCellValueFactory(new PropertyValueFactory<ProductSearchModel, String>("car_price"));
            productTableView.setItems(productSearchModelObservableList);

            FilteredList<ProductSearchModel> filteredData = new FilteredList<>(productSearchModelObservableList,b -> true);
            productTextField.textProperty().addListener((observable,oldValue,newValue) ->{
                filteredData.setPredicate(productSearchModel ->{
                    if(newValue.isEmpty()|| newValue.isBlank() || newValue==null )
                    {
                        return true;
                    }
                    String searchKeyword= newValue.toLowerCase();
                    if(productSearchModel.getCar_brand().toLowerCase().indexOf(searchKeyword)>-1)
                    {
                        return true;
                    }
                    else if(productSearchModel.getCar_name().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else if(productSearchModel.getCar_wheel().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else if(productSearchModel.getCar_city().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else if(productSearchModel.getCar_color().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else if(productSearchModel.getCar_body_type().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else if(productSearchModel.getCar_transmission().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else if(productSearchModel.getCar_gen().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else if(productSearchModel.getCar_drive_unit().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else if(productSearchModel.getCar_price().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else if(productSearchModel.getCar_engine_capacity().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else if(productSearchModel.getCar_mileage().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else if(productSearchModel.getCar_year().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else if(productSearchModel.getCar_link().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else if(productSearchModel.getCar_passtamoj().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else if(productSearchModel.getCar_year().toLowerCase().indexOf(searchKeyword)>-1){
                        return true;
                    }
                    else return false;
                } );
            });
            SortedList<ProductSearchModel> sortedData= new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(productTableView.comparatorProperty());
            productTableView.setItems(sortedData);
        }
        catch (SQLException e){
            Logger.getLogger(SearchTableController.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
        }

    }
    @FXML
    private Button search_Close_Butt;

    @FXML
    void back_to_log_act(ActionEvent event) throws IOException {
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