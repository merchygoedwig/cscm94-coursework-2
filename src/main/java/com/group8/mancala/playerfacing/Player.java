package com.group8.mancala.playerfacing;

import java.util.Date;
import java.util.UUID;

public class Player implements Comparable<Player> {
    private UUID uuid;
    private String username;
    private String firstName;
    private String lastName;
    private Date lastLogin;
    private String imagePath;
    private Double winPercentage;
    private Hand hand;

    public Player() {

    }

    public Player(String un, String fn, String ln, Date ll, String ip, Double wp) {
        uuid = UUID.randomUUID();
        username = un;
        firstName = fn;
        lastName = ln;
        lastLogin = ll;
        imagePath = ip;
        winPercentage = wp;

    }

    public Player(UUID uu, String un, String fn, String ln, Date ll, String ip, Double wp) {
        uuid = uu;
        username = un;
        firstName = fn;
        lastName = ln;
        lastLogin = ll;
        imagePath = ip;
        winPercentage = wp;

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Double getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(Double winPercentage) {
        this.winPercentage = winPercentage;
    }

    @Override
    public int compareTo(Player player) {
        return getWinPercentage().compareTo(player.getWinPercentage());
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
