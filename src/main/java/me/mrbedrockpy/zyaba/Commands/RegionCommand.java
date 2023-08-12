package me.mrbedrockpy.zyaba.Commands;

import me.mrbedrockpy.zyaba.LogMessages;
import me.mrbedrockpy.zyaba.Region;
import me.mrbedrockpy.zyaba.Zyaba;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args[0] == "create") {
            if (Zyaba.getInstance().isConflictRegions(((Player) sender).getLocation(),Integer.parseInt(args[2]))) {
                sender.sendMessage(LogMessages.ConflictRegionsError);
                return true;
            }

            if (this.isNumeric(args[1])) {
                sender.sendMessage(LogMessages.NumInNameRegionError);
                return true;
            }

            Region region = new Region(args[1], ((Player) sender).getLocation(), Integer.parseInt(args[2]), (Player) sender);
            sender.sendMessage(LogMessages.CreateRegionSuccess);
            Zyaba.getInstance().regions.add(region);
            Zyaba.getInstance().db.addRegion(region);

            return true;
        }

        if (args[0] == "join") {
            for (Region region : Zyaba.getInstance().db.getRegions()) {
                if (region.getName() == args[1]) {
                    for (Player player : region.getPlayers()) {
                        if (player == (Player) sender) {
                            for (Player target : Zyaba.getInstance().db.getPlayers()) {
                                if (target.getName() == args[2]) {
                                    region.addPlayer(target);
                                    sender.sendMessage(LogMessages.JoinPlayerInRegionSuccess);
                                    return true;
                                }
                            }
                            sender.sendMessage(LogMessages.NotExistPlayerError);
                            return true;
                        }
                    }
                    sender.sendMessage(LogMessages.NotAccessRegionError);
                    return true;
                }
            }
            sender.sendMessage(LogMessages.NotExistRegionError);
            return true;
        }

        sender.sendMessage(LogMessages.UnknownCommandError);

        return false;
    }

    public boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
