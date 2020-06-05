/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excerciselayout.addBook;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import excerciselayout.db.DatabaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author CzirkO
 */
public class FXMLDocumentController implements Initializable {

    DatabaseHandler dbHandler;

    private Label label;
    @FXML
    private JFXTextField tfAddTitle;
    @FXML
    private JFXTextField tfAddId;
    @FXML
    private JFXTextField tfAddAuthor;
    @FXML
    private JFXTextField tfAddPublisher;
    @FXML
    private JFXButton btnAddSave;
    @FXML
    private JFXButton btnAddCancel;
    @FXML
    private AnchorPane rootPane;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dbHandler = new DatabaseHandler();
        // TODO
    }

    @FXML
    private void addSave(ActionEvent event) {
        String bookId = tfAddId.getText();
        String title = tfAddTitle.getText();
        String author = tfAddAuthor.getText();
        String publisher = tfAddPublisher.getText();

        if (bookId.isEmpty() || title.isEmpty() || author.isEmpty() || publisher.isEmpty()) {
            showAlert("Please Enter all fields",", ");
            return;
        }
      
             
        if (dbHandler.addBook(bookId, title, author, publisher, true)) {
                showAlert("siker more", "");
        }else{
            showAlert("Gáz van tesa", "Ujujj");
        }

    }

    private void showAlert(String msg, String hdrTxt) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(hdrTxt);
        alert.setContentText(msg);
        alert.showAndWait();
        
        

    }

    @FXML
    private void addCancel(ActionEvent event) {
        
        Stage stage =(Stage) rootPane.getScene().getWindow();
        stage.close();
    }

}
