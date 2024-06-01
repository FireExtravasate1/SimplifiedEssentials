package plugin.simplifiedessentials.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
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

public class home implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1) {
                if (args[0].length() > 50) {
                    sender.sendMessage(ChatColor.RED + "Hey, pick a shorter name!");
                    return true;
                } else {
                    // Get the player
                    UUID id = ((Player) sender).getUniqueId();
                    Player player = ((Player) sender).getPlayer();
                    assert player != null;
                    // Get the string
                    File storagefile = new File("plugins" + File.separator + "SimplifiedEssentials" + File.separator + "Homes" + ".yml");
                    FileConfiguration file = YamlConfiguration.loadConfiguration(storagefile);
                    // Teleport the player to that home if it exists
                    if (file.isSet(id + "." + args[0] + ".x")) {
                        String worldname = (String) file.get(id + "." + args[0] + ".world");
                        double x = (double) file.getInt(id + "." + args[0] + ".x");
                        double y = (double) file.getInt(id + "." + args[0] + ".y");
                        double z = (double) file.getInt(id + "." + args[0] + ".z");

                        assert worldname != null;
                        World world2 = Bukkit.getWorld(worldname);
                        if (world2 != null) {
                            Location home = new Location(world2, x, y, z);
                            player.teleport(home);
                            return true;
                        } else {
                            // Handle the case where the world does not exist
                            player.sendMessage(ChatColor.RED + "There was a error running the code, please tell administrators to check the logs/console.");
                            System.out.println("[Essentials] [home] Player " + player + " tried to do the command " + cmd + " but World " + worldname + " does not exist");
                            return true;
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "That home does not exist!");
                    }
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Hey! Use the command correctly! /home");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Hey! Only players can use this command!");
        }
        return true;
    }
}