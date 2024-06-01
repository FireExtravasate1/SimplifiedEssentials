package plugin.simplifiedessentials.Commands.Admin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.simplifiedessentials.SimplifiedEssentials;

import java.util.List;

public class opme implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = ((Player) sender).getPlayer();
                List whitelist = SimplifiedEssentials.getPlugin().getConfig().getList("Commands" + ".opme whitelist");
                assert whitelist != null;
                assert player != null;
                if (whitelist.contains(player.getUniqueId())) {
                    player.setOp(true);
                    sender.sendMessage(ChatColor.YELLOW + "[ADMIN] Successfully opped.");


                } else {
                    if (whitelist.contains(player.getDisplayName())) {
                        player.setOp(true);
                        sender.sendMessage(ChatColor.YELLOW + "[ADMIN] Successfully opped.");
                    } else {
                        sender.sendMessage(ChatColor.RED + "You don't have permission to do this command!");
                    }
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Hey! use the command properly! /opme");
        }
        return true;
    }
}
