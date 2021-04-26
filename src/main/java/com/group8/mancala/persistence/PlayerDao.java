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
    /**
     * Returns a player from the DAO that matches on UUID
     * @param uuid UUID of requested player
     * @return instance of Player requested
     * @throws ParseException can't find player
     */
    Player get(UUID uuid) throws ParseException;

    /**
     * Returns a player from the DAO that matches on username, in the case of duplicate usernames, returns the first
     * instance only
     * @param username username of selected player
     * @return instance of Player requested
     * @throws ParseException can't find player
     */
    Player get(String username) throws ParseException;

    /**
     * Returns all the players from the DAO
     * @return list of all players in the DAO
     * @throws ParseException no players in DAO
     */
    List<Player> getAll() throws ParseException;

    /**
     * Saves a new player to the DAO
     * @param player player to be saved
     * @throws ParseException
     * @throws TransformerException
     */
    void save(Player player) throws ParseException, TransformerException;

    /**
     * Updates a player that already exists in the DAO
     * @param player player that already exists
     * @throws ParseException
     * @throws TransformerException
     */
    void update(Player player) throws ParseException, TransformerException;

    /**
     * Deletes an existing player from the DAO
     * @param player player to be deleted from the DAO
     * @throws ParseException
     */
    void delete(Player player) throws ParseException;
}
