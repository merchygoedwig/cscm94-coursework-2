package com.group8.admin;
import java.io.FileInputStream;
import java.util.HashSet;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import com.group8.mancala.playerfacing.Player;

import javafx.scene.Node;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableRow;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.event.*;


/**
 * Administrator receive request from player and 
 * have the right to start game for players 
 * @author  NAVINA JAYANTHAN
 * @author  Siu Ho,Wu
 * @version 1.1
 */


public class Administrator {

	//the request list
	private static ArrayList<Player> players = new ArrayList<>();
	
	/*
	 * 
	 * add player to the requested list when called by player.
	 * and it should be static and there exist only one request list
	 */
	public static void requestToPlay(Player p) {
		players.add(p);

	}
    /*
     *     ui control--javafx
     */

   
	@FXML
	private TableView<Player> table = new TableView<>();
	@FXML
	private TableColumn<Player,String> lastName;
	@FXML
	private TableColumn<Player,String> firstName;
	@FXML
	private TableColumn<Player,Double> winPercent;
	@FXML
	private TableColumn<Player,Date> lastLogin;

	@FXML
	private Button showRequest;
    ObservableList<Player> list ;
  
  //add request list to table
  @FXML
  public void addToTable(){
     
	 //add request list, 'players' to the list
	 list = FXCollections.observableArrayList(
			 players
			);
    
	  //binding columns
	 lastName.setCellValueFactory(new PropertyValueFactory<Player,String>("lastName"));
	 firstName.setCellValueFactory(new PropertyValueFactory<Player,String>("firstName"));
	 winPercent.setCellValueFactory(new PropertyValueFactory<Player,Double>("winPercentage"));
	 lastLogin.setCellValueFactory(new PropertyValueFactory<Player,Date>("lastLogin"));
	 table.setItems(list);
     //allow multiple select
	 table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
  

  }

  
  @FXML
  private VBox gameMode;
  @FXML
  private HBox imgBox;
  @FXML
  private HBox tournament;
  @FXML 
  private ImageView tour;

	@FXML
	private ImageView player1Img;
	@FXML
	private ImageView player2Img;
	@FXML
	private Label name1;
	@FXML
	private Label name2;
	
  
 
 private ArrayList<Player> selectedPlayer = new ArrayList<>();
 final String defaultFolder = "src/image/";
 final String[] defaultImg = {defaultFolder+"tom.jpg", defaultFolder+"dylan.jpg"};
 final String[] defaultName = {"player 1", "player2"};
 

  @FXML
  public void tableHandle() throws FileNotFoundException {
	   
	  ObservableList<Player> selectedItems  = table.getSelectionModel().getSelectedItems();
	   //get player item from table when clicked
	   Player player = selectedItems.get(0);
	  
     //if it is selected, deselect
     if(selectedPlayer.contains(player)) {
         selectedPlayer.remove(player);
    	 int selected = table.getSelectionModel().getSelectedIndex();
        table.getSelectionModel().clearSelection(selected);
        
       
       }else {
    	  
    	   selectedPlayer.add(player);
    		
       }

     ImageView[] img = {player1Img, player2Img};
     Label[] name = {name1,name2};
     
     int im = 0;
     //multiple select
     for(Player p : selectedPlayer) {
    	 table.getSelectionModel().select(p);	 
     if(selectedPlayer.size() == 2) {
    	 setImage(img[im],name[im],p.getUsername(),p.getImagePath());
 	     im++; }
 	 
      }
       
     //if number of selected players equal to 2
     if(selectedPlayer.size() == 2) {
    	 gameMode.setVisible(true);
     }else {
    	 gameMode.setVisible(false);
    	 for(int i = 0 ; i<img.length;i++) {
    		 setImage(img[i],name[i],defaultName[i],defaultImg[i]);
    	 }
      }
     //if number of selected player > 2 , show tournament page
     if(selectedPlayer.size() > 2) {
    	 imgBox.setVisible(false);
    	 tournament.setPrefHeight(250);
    	 tournament.setVisible(true);
    	 tour.setFitHeight(150);
     }else {
    	 imgBox.setVisible(true);
    	 tournament.setVisible(false);
    	 tournament.setPrefHeight(5);
    	 tour.setFitHeight(5);
      }
    }
  
  
  /*
   * control for different game mode and start the game
   */
  @FXML
  public void gameMode(ActionEvent e) throws IOException, SAXException, ParserConfigurationException, TransformerException, ParseException {
	  
//      System.out.println(((Button)e.getSource()).getText());
      for(Player p : selectedPlayer) {
          players.remove(p);
      }
      addToTable();
     
      //begin game by calling session
      Session session = new Session(selectedPlayer);
      session.beginGame(selectedPlayer);
      selectedPlayer.clear();
      tableHandle();
	  
  }
  
//helper method for setting image
public void setImage(ImageView iv, Label name, String text, String path) throws FileNotFoundException {
	 FileInputStream stream = new FileInputStream(path);	
 	 Image image = new Image(stream);
 	 iv.setImage(image);
 	 name.setText(text);
}

	
	
}
