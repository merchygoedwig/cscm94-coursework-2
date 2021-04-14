import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
/**
 * @author Paulina Mielewska
 * Unit Test for Hole class verision 1.0
 */

//not yet tested
public class HoleUnitTest {

  private Player assignedPlayer;
  private Stack<Counter> counters = new Stack<>();
  private int counterAmount;
	void createCounter() {
		testHole.push(new Counter(1));
		testHole.push(new Counter(2));
		testHole.push(new Counter(1));
		testHole.push(new Counter(1));
		testHole.push(new Counter(1));
	}
    Hole hole = new Hole();
    
	@Test
	public void acceptCounterTest(Counter someCounter) {
        Stack<Counter> counters = new Stack<>();
        Counter counter = new Counter(someCounter);
		for(Counter c : counters) {
            counters.push(counter);
            counterAmount++;	
		}
		//check output correctness
		assertEquals();
    }
    

	 @Test
	 public void giveUpCounterTest() {
   	   	
	    createPlayer();
	    for(Hole h : holes) {
	    hole.giveUpCounter();	   
	    }
	    //check output correctness
		 assertEquals();
		
	  }

}




