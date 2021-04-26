package com.group8.mancala.admin;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.junit.jupiter.api.Test;

import com.group8.mancala.playerfacing.Player;



class AdminTest {

	private ArrayList<Player> testPlayer = new ArrayList<>();
	void createPlayer() throws ParseException {
		 SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		    testPlayer.add(new Player("Messi","Tom","Owen",dateFormatter.parse("10-04-2020 13:54:27"),"src/image/1.jpg",93.7));
	          testPlayer.add(new Player("Mbappe","Gareth","Bale",dateFormatter.parse("10-04-2020 13:54:27"),"src/image/2.jpg",93.8));
	          testPlayer.add(new Player("Ronaldo","Neymar","da Silva",dateFormatter.parse("10-04-2020 13:54:27"),"src/image/1.jpg",93.7));
	          testPlayer.add(new Player("Neymar","Alan","Turing",dateFormatter.parse("10-04-2020 13:54:27"),"src/image/2.jpg",93.8));
	        testPlayer.add(new Player("Kane","Harry","Kane",dateFormatter.parse("10-04-2020 13:54:27"),"src/image/1.jpg",93.7));
	          testPlayer.add(new Player("Messi","Tom","Owen",dateFormatter.parse("10-04-2020 13:54:27"),"src/image/1.jpg",93.7));
	          testPlayer.add(new Player("Mbappe","Gareth","Bale",dateFormatter.parse("10-04-2020 13:54:27"),"src/image/2.jpg",93.8));
	          testPlayer.add(new Player("Ronaldo","Neymar","da Silva",dateFormatter.parse("10-04-2020 13:54:27"),"src/image/1.jpg",93.7));
	          testPlayer.add(new Player("Neymar","Alan","Turing",dateFormatter.parse("10-04-2020 13:54:27"),"src/image/2.jpg",93.8));
	        testPlayer.add(new Player("Kane","Harry","Kane",dateFormatter.parse("10-04-2020 13:54:27"),"src/image/1.jpg",93.7));
	
	}


	
    
	@Test
	public void requestToPlayTest() {
		
		try {
			createPlayer();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Player p : testPlayer) {
		Administrator.requestToPlay(p);
		
		}
		//check output correctness
		assertEquals(Administrator.getPlayers(),testPlayer);
	}
}
