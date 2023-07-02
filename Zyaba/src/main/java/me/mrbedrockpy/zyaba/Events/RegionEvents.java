package me.mrbedrockpy.zyaba.Events;

import me.mrbedrockpy.zyaba.LogMessages;
import me.mrbedrockpy.zyaba.Region;
import me.mrbedrockpy.zyaba.Zyaba;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;

public class RegionEvents implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        Location pos = event.getBlock().getLocation();
        Player player = event.getPlayer();

        for (Region region : Zyaba.getInstance().regions) {

            Location center = region.getCenter();
            int radius = region.getRadius();

            if (center.getX() + radius > pos.getBlockX() && center.getX() - radius < pos.getBlockX()) {
                if (center.getY() + radius > pos.getBlockY() && center.getY() - radius < pos.getBlockY()) {
                    if (center.getZ() + radius > pos.getBlockZ() && center.getZ() - radius < pos.getBlockZ()) {

                        if (!(region.getPlayers().contains(player))) {
                            event.setDropItems(false);
                            pos.getBlock().setType(event.getBlock().getType());
                            player.sendMessage(LogMessages.BrokeBlockInAlienRegionError);
                            return;
                        }

                    }
                }
            }
        }
    }

    @EventHandler
    public void onBlockExplode(BlockExplodeEvent event) {
        Block block = event.getBlock();
        Location pos = block.getLocation();

    }
}
