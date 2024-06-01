package plugin.simplifiedessentials.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.simplifiedessentials.SimplifiedEssentials;

public class enderchest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                Player player = ((Player) sender).getPlayer();
                assert player != null;
                player.openInventory(player.getEnderChest());
            } else {
                sender.sendMessage(ChatColor.RED + "Use the command correctly! /enderchest");
                return true;
            }

        } else {
            sender.sendMessage(ChatColor.RED + "Hey! Only players can use that command!");
            return false;
        }
        return true;
    }
}
