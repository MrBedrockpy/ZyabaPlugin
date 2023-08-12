package me.mrbedrockpy.zyaba.Events;

import me.mrbedrockpy.zyaba.Zyaba;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

public class DataBaseEvents implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        for (Player dbplayer : Zyaba.getInstance().db.getPlayers()) {
            if (player == dbplayer) {
                return;
            }
        }
        Zyaba.getInstance().db.addPlayer(player);
    }
}
