import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Stack;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;

import com.group8.mancala.gameplayobjects.Counter;
import com.group8.mancala.gameplayobjects.Hole;
import com.group8.mancala.gameplayobjects.HoleImp;
import com.group8.mancala.persistence.PlayerDaoXmlImpl;
//???
import com.group8.mancala.playerfacing.Player;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

/**
 * @author Paulina Mielewska Unit Test for Hole class verision 1.0
 */

// not yet tested
public class HoleImplTest {

  @Test
  void testPlayerAssigned() throws ParseException, TransformerConfigurationException, ParserConfigurationException,
      IOException, SAXException {
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    new PlayerDaoXmlImpl("src/test/resources/xml/players.xml");
    UUID uuid = UUID.fromString("aba1ca7d-17e3-4d82-ad22-a9964f411201");
    Player testPlayer = new Player(uuid, "secondtechaj", "Arnold", "Rimmer", dateFormatter.parse("01-09-2188 00:32:01"),
        "/dir/images/aba1ca7d-17e3-4d82-ad22-a9964f411201.png", 0.21);
    boolean isMancala = false;
    HoleImp testHole = new HoleImp(testPlayer, isMancala);
    assertEquals(testHole.getAssignedPlayer(), testPlayer);
  }

  @Test
  void testEmptyHole() throws ParseException {
    Stack<Counter> counters = new Stack<Counter>();
    counters.push(new Counter());
    counters.push(new Counter());
    Stack<Counter> tempStack = new Stack<Counter>();
    tempStack.addAll(counters);
    assertEquals(((Hole) counters).giveUpCounter(), null);
  }

}