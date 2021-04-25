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
    private int counterTotal = 0;
    private boolean computerControlled;
    private ComputerControl ai;

    /**
     * Default constructor for player, don't use this unless you plan to set every variable using get/set methods.
     * You SHOULDN'T do this unless you have a very good reason.
     */
    public Player() {

    }

    /**
     * Constructor for creating a new Player, the UUID will be randomly generated here
     * @param un username
     * @param fn first name
     * @param ln last name
     * @param ll last login
     * @param ip path to the player's image
     * @param wp win percentage
     */
    public Player(String un, String fn, String ln, Date ll, String ip, Double wp) {
        uuid = UUID.randomUUID();
        username = un;
        firstName = fn;
        lastName = ln;
        lastLogin = ll;
        imagePath = ip;
        winPercentage = wp;
    }

    /**
     * Constructor for creating a player with a pre-determined UUID
     * @param uu UUID
     * @param un username
     * @param fn first name
     * @param ln last name
     * @param ll last login
     * @param ip path to the player's image
     * @param wp win percentage
     */
    public Player(UUID uu, String un, String fn, String ln, Date ll, String ip, Double wp) {
        uuid = uu;
        username = un;
        firstName = fn;
        lastName = ln;
        lastLogin = ll;
        imagePath = ip;
        winPercentage = wp;

    }

    /**
     * Getter for player's UUID
     * @return player's UUID
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Setter for player's UUID
     * @param uuid player's UUID
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Setter for player's username
     * @return player's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for player's username
     * @param username player's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for player's first name
     * @return player's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for player's first name
     * @param firstName player's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for player's last name
     * @return player's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for player's last name
     * @param lastName player's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for last login for player
     * @return last login for player
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * Setter for last login for player
     * @param lastLogin last login for player
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * Getter for image path for player
     * @return image path for player
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Setter for image path for player
     * @param imagePath
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Getter for win percentage for player
     * @return win percentage for player
     */
    public Double getWinPercentage() {
        return winPercentage;
    }

    /**
     * Setter for win percentage for player
     * @param winPercentage win percentage for player
     */
    public void setWinPercentage(Double winPercentage) {
        this.winPercentage = winPercentage;
    }

    /**
     * Compares the win percentage on the player to get the larger one
     * @param player
     * @return returns the instance of player that has the larger win percentage
     */
    @Override
    public int compareTo(Player player) {
        return getWinPercentage().compareTo(player.getWinPercentage());
    }

    /**
     * Getter for player's hand
     * @return player's hand
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Setter for player's hand
     * @param hand player's hand
     */
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    /**
     * Getter for player's counter total
     * @return player's counter total
     */
    public int getCounterTotal() {
        return counterTotal;
    }

    /**
     * Setter for player's counter total
     * @param counterTotal player's counter total
     */
    public void setCounterTotal(int counterTotal) {
        this.counterTotal = counterTotal;
    }

    public boolean isComputerControlled() {
        return computerControlled;
    }

    public void setComputerControlled(boolean computerControlled) {
        this.computerControlled = computerControlled;
    }
    public ComputerControl getAi() {
        return ai;
    }

    public void setAi(ComputerControl ai) {
        this.ai = ai;
    }


    /**
     * Returns string interpretation of an instance of Player
     * @return String representing Player
     */
    public String toString() {
        return username + counterTotal;
    }
}
