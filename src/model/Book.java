/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author CzirkO
 */
public class Book {
    
    private SimpleStringProperty id;
    private SimpleStringProperty title;
    private SimpleStringProperty author;
    private SimpleStringProperty publisher;
    private SimpleBooleanProperty avaibility;

    public Book(String id,String title,String author,String pub,Boolean avail) {
       this. title=new SimpleStringProperty(title);
       this. id=new SimpleStringProperty(id);
       this. author=new SimpleStringProperty(author);
       this. publisher=new SimpleStringProperty(pub);
       this. avaibility=new SimpleBooleanProperty(avail);
        
        
    }

    public String getId() {
        return id.get();
    }

    public String getTitle() {
        return title.get();
    }

    public String getAuthor() {
        return author.get();
    }

    public String getPublisher() {
        return publisher.get();
    }

    public Boolean getAvaibility() {
        return avaibility.get();
    }
    
    
    
    
    
    


    
    
    
}
