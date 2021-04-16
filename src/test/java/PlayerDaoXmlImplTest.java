import com.group8.mancala.playerfacing.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.group8.mancala.persistence.PlayerDaoXmlImpl;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class PlayerDaoXmlImplTest {

    @Test
    void searchByUsername() throws IOException, SAXException, ParserConfigurationException, ParseException, TransformerConfigurationException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        PlayerDaoXmlImpl testDAO = new PlayerDaoXmlImpl("src/test/resources/xml/players.xml");
        UUID uuid = UUID.fromString("4876240e-bea5-4654-9188-cca48c0fc395");
        Player match = new Player(
                uuid,
                "merchygoedwig",
                "Genevieve",
                "Clifford",
                dateFormatter.parse("10-04-2020 13:54:27"),
                "/dir/images/4876240e-bea5-4654-9188-cca48c0fc395.png",
                0.83
        );

        Player toMatch = testDAO.get("merchygoedwig");
        assertEquals(match.getUuid(), toMatch.getUuid());
        assertEquals(match.getUsername(), toMatch.getUsername());
        assertEquals(match.getFirstName(), toMatch.getFirstName());
        assertEquals(match.getLastName(), toMatch.getLastName());
        assertEquals(match.getLastLogin(), toMatch.getLastLogin());
        assertEquals(match.getImagePath(), toMatch.getImagePath());
        assertEquals(match.getWinPercentage(), toMatch.getWinPercentage());
    }

    @Test
    void searchByUUID() throws IOException, SAXException, ParserConfigurationException, ParseException, TransformerConfigurationException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        PlayerDaoXmlImpl testDAO = new PlayerDaoXmlImpl("src/test/resources/xml/players.xml");
        UUID uuid = UUID.fromString("aba1ca7d-17e3-4d82-ad22-a9964f411201");
        Player match = new Player(
                uuid,
                "secondtechaj",
                "Arnold",
                "Rimmer",
                dateFormatter.parse("01-09-2188 00:32:01"),
                "/dir/images/aba1ca7d-17e3-4d82-ad22-a9964f411201.png",
                0.21
        );

        Player toMatch = testDAO.get(uuid);
        assertEquals(match.getUuid(), toMatch.getUuid());
        assertEquals(match.getUsername(), toMatch.getUsername());
        assertEquals(match.getFirstName(), toMatch.getFirstName());
        assertEquals(match.getLastName(), toMatch.getLastName());
        assertEquals(match.getLastLogin(), toMatch.getLastLogin());
        assertEquals(match.getImagePath(), toMatch.getImagePath());
        assertEquals(match.getWinPercentage(), toMatch.getWinPercentage());
    }

    @Test
    void getNonExistentPlayerByUsername() throws IOException, SAXException, ParserConfigurationException, TransformerConfigurationException {
        PlayerDaoXmlImpl testDAO = new PlayerDaoXmlImpl("src/test/resources/xml/players.xml");
        assertThrows(ParseException.class, () -> {
            testDAO.get("Ceci n'est pas une utilisateur");
        });
    }

    @Test
    void getNonExistentPlayerByUUID() throws IOException, SAXException, ParserConfigurationException, TransformerConfigurationException {
        PlayerDaoXmlImpl testDAO = new PlayerDaoXmlImpl("src/test/resources/xml/players.xml");
        UUID uuid = UUID.fromString("716080d8-e7da-40e3-81f4-27c307093d36");
        assertThrows(ParseException.class, () -> {
            testDAO.get(uuid);
        });
    }

    @Test
    void createANewPlayerAndPersistThemToXMLFile() throws ParserConfigurationException, SAXException, TransformerException, IOException, ParseException {
        PlayerDaoXmlImpl testDAO = new PlayerDaoXmlImpl("src/test/resources/xml/players.xml");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date ll = dateFormatter.parse("2020-03-12 12:43:12");
        Player newPlayer = new Player(
                "testplayer",
                "Test",
                "Player",
                ll,
                "/some/image/path",
                0.42
        );
        testDAO.save(newPlayer);
    }
}
