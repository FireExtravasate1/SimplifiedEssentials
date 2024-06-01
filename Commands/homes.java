package plugin.simplifiedessentials.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import plugin.simplifiedessentials.SimplifiedEssentials;

import java.io.File;
import java.util.List;
import java.util.UUID;

public class homes implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                // Get the player
                UUID id = ((Player) sender).getUniqueId();
                Player player = ((Player) sender).getPlayer();
                assert player != null;
                // Get the string
                File storagefile = new File("plugins" + File.separator + "SimplifiedEssentials" + File.separator + "Homes" + ".yml");
                FileConfiguration file = YamlConfiguration.loadConfiguration(storagefile);

                int amount = file.getInt(id + ".homecount");
                if (amount != 0) {
                    int counter = 1;
                    player.sendMessage(SimplifiedEssentials.prefix + ChatColor.BOLD + ChatColor.AQUA + "Here's a list of your homes");
                while (amount >= counter) {
                    String msg = file.getString(id + "." + counter);
                    player.sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "-" + ChatColor.GREEN + msg);
                    counter++;
                    }
                } else {
                    player.sendMessage(SimplifiedEssentials.prefix + ChatColor.YELLOW + "You have no homes currently set.");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Hey! Use the command correctly! /homes");
            }

        } else {
            sender.sendMessage(ChatColor.RED + "Hey! Only players can use this command!");
        }
        return true;
    }
}