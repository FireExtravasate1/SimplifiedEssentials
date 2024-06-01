package plugin.simplifiedessentials.Commands.Admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.simplifiedessentials.SimplifiedEssentials;

public class endersee implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            assert player != null;
            if (args.length == 0) {
                // Your code here
                player.sendMessage(ChatColor.RED + "Use the command correctly! /endersee <player>");
                return true;
            } else {
                if (args.length == 1) {
                    if (Bukkit.getServer().getPlayer(args[0]) == null) {
                        player.sendMessage(ChatColor.RED + "That player does not exist.");
                        return true;
                    }
                    // Your code here
                    String player2string = args[0];
                    Player player2 = Bukkit.getServer().getPlayer(player2string);
                    assert player2 != null;
                    player.openInventory(player2.getEnderChest());

                } else {
                    player.sendMessage(ChatColor.RED + "Use the command correctly! /endersee <player>");
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
