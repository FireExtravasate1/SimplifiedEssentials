package plugin.simplifiedessentials.Commands.Admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.simplifiedessentials.SimplifiedEssentials;

public class Commandbases implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            assert player != null;
            if (args.length == 0) {
                // Your code here


            } else {
                if (args.length == 1) {
                    if (Bukkit.getServer().getPlayer(args[0]) == null) {
                        player.sendMessage(SimplifiedEssentials.prefix + ChatColor.RED + " That player does not exist.");
                        return true;
                    }
                    // Your code here

                } else {
                    sender.sendMessage(SimplifiedEssentials.prefix + ChatColor.RED + " Use the command correctly!");
                    return true;
                }
            }

        } else {
            sender.sendMessage(SimplifiedEssentials.prefix + ChatColor.RED + "Hey! Only players can use that command!");
            return false;
        }
        return true;
    }
}
