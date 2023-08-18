package me.mrbedrockpy.zyaba;

import me.mrbedrockpy.zyaba.Events.DataBaseEvents;
import me.mrbedrockpy.zyaba.Commands.RegionCommand;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Zyaba extends JavaPlugin {

    private static Zyaba instance;

    public DataBase db = new DataBase();

    public ArrayList<Region> regions = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;

        System.out.println("    ===================================");
        System.out.println("    |                                 |");
        System.out.println("    |    Plugin for Zyaba project     |");
        System.out.println("    |                                 |");
        System.out.println("    |        by MrBedrockpy           |");
        System.out.println("    |                                 |");
        System.out.println("    ===================================");

        getCommand("region").setExecutor(new RegionCommand());

        getServer().getPluginManager().registerEvents(new DataBaseEvents(), this);

    }

    @Override
    public void onDisable() {
    }

    public static Zyaba getInstance() {
        return instance;
    }

    public boolean isConflictRegions(Location center, int radius) {
        for (Region region : regions) {
            if (region.getCenter().getX() + region.getRadius() >= center.getX() - radius && region.getCenter().getX() - region.getRadius() <= center.getX() - radius) {
                return true;
            }if (region.getCenter().getX() + region.getRadius() >= center.getX() + radius && region.getCenter().getX() - region.getRadius() <= center.getX() + radius) {
                return true;
            }if (region.getCenter().getY() + region.getRadius() >= center.getY() - radius && region.getCenter().getY() - region.getRadius() <= center.getY() - radius) {
                return true;
            }if (region.getCenter().getY() + region.getRadius() >= center.getY() + radius && region.getCenter().getY() - region.getRadius() <= center.getY() + radius) {
                return true;
            }if (region.getCenter().getZ() + region.getRadius() >= center.getZ() - radius && region.getCenter().getZ() - region.getRadius() <= center.getZ() - radius) {
                return true;
            }if (region.getCenter().getZ() + region.getRadius() >= center.getZ() + radius && region.getCenter().getZ() - region.getRadius() <= center.getZ() + radius) {
                return true;
            }
        }
        return false;
    }
}
