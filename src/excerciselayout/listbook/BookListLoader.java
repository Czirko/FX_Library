/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excerciselayout.listbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author CzirkO
 */
public class BookListLoader extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("bookList.fxml"));
       Scene sc = new Scene(root);
       
       stage.setScene(sc);
       stage.show();
       
       
       
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
}
