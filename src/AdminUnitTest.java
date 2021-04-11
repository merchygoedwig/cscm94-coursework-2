import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
/**
 * @author Siu Ho,Wu
 * Unit Test for Administrator class verision 1.0
 */

//temperarily not compiled, due to player class under constructing...
public class AdminUnitTest {

	private ArrayList<Player> testPlayer = new ArrayList<>();
	void createPlayer() {
		testPlayer.add(new Player(1,"Tom"));
		testPlayer.add(new Player(2,"Peter"));
		testPlayer.add(new Player(3,"Marry"));
		testPlayer.add(new Player(4,"David"));
		testPlayer.add(new Player(5,"Joe"));
	}

	Administrator admin = new Administrator();
	
    
	@Test
	public void requestToPlayTest() {
		ArrayList<Player> players = new ArrayList<>();
		createPlayer();
		for(Player p : players) {
		admin.requestToPlay(p);
		
		}
		//check output correctness
		assertEquals(admin.getPlayer(),testPlayer);
	}
	 @Test
	 public void assignTest() {
   	   	
	    createPlayer();
	    for(Player p : testPlayer) {
	    admin.assign(p);
	   
	    }
	    //check output correctness
	   for(Player p : testPlayer) {
		 assertEquals(p.,getAssigned,true);
		  }
	  }

}













