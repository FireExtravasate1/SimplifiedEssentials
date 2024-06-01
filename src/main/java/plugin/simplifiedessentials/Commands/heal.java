package plugin.simplifiedessentials.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.simplifiedessentials.SimplifiedEssentials;

public class heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                Player player = ((Player) sender).getPlayer();
                player.setHealth(20);
                player.sendMessage(ChatColor.GREEN + "You've been healed!");
            } else {
                if (args.length == 1) {
                    if (sender.hasPermission("essentials.heal.others")) {
                        String player2string = args[0];
                        if (Bukkit.getServer().getPlayer(player2string) == null) {
                            sender.sendMessage(ChatColor.RED + "That player does not exist.");
                            return true;
                        }
                        Player player2 = Bukkit.getServer().getPlayer(player2string);
                        assert player2 != null;
                        player2.setHealth(20);
                        player2.sendMessage(ChatColor.GREEN + "You've been healed!");
                    } else {
                        sender.sendMessage(ChatColor.RED + "Use the command correctly! /heal");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Use the command correctly! /heal");
                    return true;
                }
            }

        } else {
            sender.sendMessage(ChatColor.RED + "Hey! Only players can use that command!");
            return false;
        }
        return true;
    }
}
