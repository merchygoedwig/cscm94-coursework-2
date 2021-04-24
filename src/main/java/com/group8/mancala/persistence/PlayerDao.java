package com.group8.mancala.persistence;

import com.group8.mancala.playerfacing.Player;

import javax.xml.transform.TransformerException;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

/**
 * Interface for defining a DAO for accessing a "back-catalogue" of Players which have been serialised. Although in
 * Version 1.0, this functionality will be implemented through use of an XML DOM parser, it might be nice in future
 * to switch this out with a SQLite database instead.
 * @author Genevieve Clifford
 * @version 1.0
 */
public interface PlayerDao {
    Player get(UUID uuid) throws ParseException;
    Player get(String username) throws ParseException;
    List<Player> getAll() throws ParseException;
    void save(Player player) throws ParseException, TransformerException;
    void update(Player player, String[] updates) throws ParseException;
    void delete(Player player);
}
