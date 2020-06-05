/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excerciselayout.listbook;

import excerciselayout.db.DatabaseHandler;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Book;

/**
 * FXML Controller class
 *
 * @author CzirkO
 */
public class BookListController implements Initializable {

    ObservableList<Book> books = FXCollections.observableArrayList();
    DatabaseHandler dbh;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Book> tbview;
    @FXML
    private TableColumn<Book, String> tbvTitle;
    @FXML
    private TableColumn<Book, String> tbvBookId;
    @FXML
    private TableColumn<Book, String> tbvAuthor;
    @FXML
    private TableColumn<Book, String> tbvPublisher;
    @FXML
    private TableColumn<Book, Boolean> tbvAviability;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("init");
        initCol();
        dbh = new DatabaseHandler();
        loadData();
    }

    private void initCol() {

        tbvTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tbvAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        tbvBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbvPublisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        tbvAviability.setCellValueFactory(new PropertyValueFactory<>("availability"));

    }

    private void loadData(){
        List<Book> bks= new ArrayList<>();
        bks=dbh.getAllBook();
        books.addAll(bks);
        tbview.getItems().setAll(books); 
    }


                
        
        
    }
    
    
    
    

