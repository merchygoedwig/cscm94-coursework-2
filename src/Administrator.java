import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Administrator is a user and grant right to player for playing
 * @author  Siu Ho,Wu
 * @version 1.0
 */


public class Administrator {

	
    
	private ArrayList<Player> players = new ArrayList<>();
	
	//constructor
	public Administrator() {
		
	}
	
	/*
	 * 
	 * add player to the requested list when called by player.
	 */
	public void requestToPlay(Player p) {
		
		players.add(p);
	}
    
	/**
	 * getter class for showing player request at administrator's page.
	 * @return players who made requests
	 */
	public ArrayList<Player> getPlayer(){
		
		return players;
	}

	/**
	 * 
	 * assign a player's player statue be true;
	 */
   void assign(Player p) {
    	    	   	
       //p.setAssigned(true);
    }
  
   
   
   
    /*
     *   admin page controler temp design
     */
   
	@FXML
	private TableView<Player> table = new TableView<>();
	@FXML
	private TableColumn<Player,String> request;
	@FXML
	private TableColumn<Player,Integer> id;
	@FXML
	private Button showRequest;
  ObservableList<Player> list ;
  /**
   * add player to request list 
   */
  @FXML
  public void addToTable(){
	  /*
	      temp data for testing
	   */
//	 players.add(new Player(1,"Tom"));
//	 players.add(new Player(2,"Peter"));
//	 players.add(new Player(3,"David"));
	  
	 list = FXCollections.observableArrayList(
			 players
			);
	  
	 request.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
	 id.setCellValueFactory(new PropertyValueFactory<Player,Integer>("id"));
	 table.setItems(list);
	 showRequest.setVisible(false);
	 
  }
  /**
   * handle assigning  player 
   */
  
  @FXML
  public void tableHandle() {
	 
	 Player p = table.getSelectionModel().getSelectedItem();
	 if(list.size()==0) {
		 showRequest.setVisible(true);
	 }else {
	 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	 alert.setTitle("assign player");
    // alert.setContentText("are you sure to assign player: "+p.getName());     
     alert.showAndWait();
     if (alert.getResult().getText().equalsIgnoreCase("OK")) {
          assign(p);
          list.remove(p);
          players.remove(p);
          
     }
	 }
  }

	
	
}
