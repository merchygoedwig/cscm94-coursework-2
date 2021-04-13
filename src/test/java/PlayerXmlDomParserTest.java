import com.group8.mancala.playerfacing.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.group8.mancala.persistence.PlayerXmlDomParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class PlayerXmlDomParserTest {

    @Test
    void searchByUsername() throws IOException, SAXException, ParserConfigurationException, ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        PlayerXmlDomParser testDOM = new PlayerXmlDomParser("src/test/resources/xml/players.xml");
        UUID uuid = UUID.fromString("4876240e-bea5-4654-9188-cca48c0fc395");
        Player match = new Player(
                uuid,
                "merchygoedwig",
                "Genevieve",
                "Clifford",
                dateFormatter.parse("10-04-2020 13:54:27"),
                "/dir/images/4876240e-bea5-4654-9188-cca48c0fc395.png",
                (float) 0.83
        );

        Player toMatch = testDOM.getPlayerByUsername("merchygoedwig");
        assertEquals(match.getUuid(), toMatch.getUuid());
        assertEquals(match.getUsername(), toMatch.getUsername());
        assertEquals(match.getFirstName(), toMatch.getFirstName());
        assertEquals(match.getLastName(), toMatch.getLastName());
        assertEquals(match.getLastLogin(), toMatch.getLastLogin());
        assertEquals(match.getImagePath(), toMatch.getImagePath());
        assertEquals(match.getWinPercentage(), toMatch.getWinPercentage());
    }

    @Test
    void searchByUUID() throws IOException, SAXException, ParserConfigurationException, ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        PlayerXmlDomParser testDOM = new PlayerXmlDomParser("src/test/resources/xml/players.xml");
        UUID uuid = UUID.fromString("aba1ca7d-17e3-4d82-ad22-a9964f411201");
        Player match = new Player(
                uuid,
                "secondtechaj",
                "Arnold",
                "Rimmer",
                dateFormatter.parse("01-09-2188 00:32:01"),
                "/dir/images/aba1ca7d-17e3-4d82-ad22-a9964f411201.png",
                (float) 0.21
        );

        Player toMatch = testDOM.getPlayerByUUID(uuid);
        assertEquals(match.getUuid(), toMatch.getUuid());
        assertEquals(match.getUsername(), toMatch.getUsername());
        assertEquals(match.getFirstName(), toMatch.getFirstName());
        assertEquals(match.getLastName(), toMatch.getLastName());
        assertEquals(match.getLastLogin(), toMatch.getLastLogin());
        assertEquals(match.getImagePath(), toMatch.getImagePath());
        assertEquals(match.getWinPercentage(), toMatch.getWinPercentage());
    }
}
