package plugin.simplifiedessentials.Commands.Admin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import plugin.simplifiedessentials.SimplifiedEssentials;

import java.io.File;
import java.io.IOException;

public class setspawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                File storagefile = new File("plugins" + File.separator + "SimplifiedEssentials" + File.separator + "Homes" + ".yml");
                FileConfiguration file = YamlConfiguration.loadConfiguration(storagefile);
                file.set("spawn", ((Player) sender).getLocation());
                try {
                    file.save(storagefile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                sender.sendMessage(SimplifiedEssentials.prefix + ChatColor.GREEN + "Set the /spawn to your location.");
            } else {
                sender.sendMessage(ChatColor.RED + "Use the command correctly! /setspawn");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Hey! Only players can use this command!");
        }
        return true;
    }
}
