package com.group8.mancala.persistence;

import com.group8.mancala.playerfacing.Player;

import javax.xml.transform.TransformerException;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

public interface PlayerDao {
    Player get(UUID uuid) throws ParseException;
    Player get(String username) throws ParseException;
    List<Player> getAll() throws ParseException;
    void save(Player player) throws ParseException, TransformerException;
    void update(Player player, String[] updates) throws ParseException;
    void delete(Player player);
}
