
import java.util.ArrayList;

/**
 * Administrator is a user and grant right to player for playing
 * @author  Siu Ho,Wu
 * @version 1.0
 */


public class Administrator {
	

	private ArrayList<Player> players = new ArrayList<>();
	
	/**
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
	 * assign a player's playing statue be true;
	 */
   void assigned(Player p) {
    	    	   	
       // p.setAssigned(true);
    }
}
