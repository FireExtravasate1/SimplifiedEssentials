package plugin.simplifiedessentials.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class back implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                Player player = ((Player) sender).getPlayer();
                assert player != null;
                Location lastdeath = player.getLastDeathLocation();
                if (lastdeath != null) {
                    player.teleport(lastdeath);
                } else {
                    sender.sendMessage(ChatColor.RED + "You have not died before.");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Use the command correctly! /back");
                return true;
            }

        } else {
            sender.sendMessage(ChatColor.RED + "Hey! Only players can use that command!");
            return true;
        }
        return true;
    }
}
