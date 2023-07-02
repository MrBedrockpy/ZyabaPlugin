package me.mrbedrockpy.zyaba;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Region {

    private String name;

    private Location center;

    private int radius;

    private Player leader;

    private ArrayList<Player> players;

    public Region(String name, Location center, int radius, Player leader) {
        this.name = name;
        this.center = center;
        this.radius = radius;
        this.leader = leader;
        this.addPlayer(leader);
    }

    public String getName() {
        return name;
    }

    public Location getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public Player getLeader() {
        return leader;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}
