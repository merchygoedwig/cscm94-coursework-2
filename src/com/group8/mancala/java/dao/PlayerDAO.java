package com.group8.mancala.java.dao;

import com.group8.mancala.java.Player;

import java.util.List;

/**
 * This is an interface for an implementation of a generic DAO for storing player records, an example of a List
 * based DAO is to be implemented for testing, followed by (hopefully) a database/file-based DAO.
 *
 * @author Genevieve Clifford
 * @version %I%, %G%
 */
public interface PlayerDAO {
    List<Player> getAllPlayers();
    Player getPlayer(int uuid);
    void updatePlayer(Player player);
    void deletePlayer(Player player);
}
