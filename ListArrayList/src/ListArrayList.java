/**
 *
 * @author jenre
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class ListArrayList extends Application {
    private List<String> items;
    private ListView<String> listView;
    
    //add the item to the list of items & refresh the list
    private void addItem(String newItem){  
        items.add(newItem);
        listView.setItems(FXCollections.observableList(items));
    }

    //for loop to cycle through the list of item. When the item
    //is found, it is removed from the list, and the list is refreshed.
    private void removeItem(){
        int index = listView.getSelectionModel().getSelectedIndex();
        if(index >=0){
            items.remove(index);
            listView.refresh();
        }
    }
        
    @Override
    public void start(Stage primaryStage) throws Exception {
        //initialize the list of items
        items = new ArrayList<>();
        listView = new ListView<>();
        
        //bind the listview to the list of items
        listView.setItems(FXCollections.observableList(items));
        
        //initialize the gridpane
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(25, 25, 25, 25));
        
        //add the list view to the GridPane
        gridpane.add(listView,0,0,2,1);
        
        //add the label and textfield for entering new items
        Label new_item_label = new Label("New item: ");
        gridpane.add(new_item_label,0,1);
        TextField new_item_text_field = new TextField();
        gridpane.add(new_item_text_field,1,1);
        
        //add a button for adding a new item to the list, and create an action handler
        Button add_button = new Button("Add");
        add_button.setOnAction(e -> addItem(new_item_text_field.getText()));
        gridpane.add(add_button, 2, 1);
        
        //add a button for removing an item from the list
        Button remove_button = new Button("Remove");
        remove_button.setOnAction(e -> removeItem());
        gridpane.add(remove_button, 2, 0);
        
        //set the scene and show the stage
        Scene scene = new Scene(gridpane,400,400);
        primaryStage.setTitle("To Do List App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String [] args){
        launch(args);
    }
}
