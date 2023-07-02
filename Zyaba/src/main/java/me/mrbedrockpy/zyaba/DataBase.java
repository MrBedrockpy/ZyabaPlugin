package me.mrbedrockpy.zyaba;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class DataBase {

    private ArrayList<Region> regions = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void addRegion(Region region) {
        this.regions.add(region);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}
