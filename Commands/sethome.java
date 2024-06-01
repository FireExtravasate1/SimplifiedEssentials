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
import java.io.IOException;
import java.util.UUID;

public class sethome implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1) {
                if (args[0].length() > 50) {
                    sender.sendMessage(ChatColor.RED + " Hey, pick a shorter name!");
                    return true;
                } else {
                        Player player = ((Player) sender).getPlayer();
                        assert player != null;
                        File storagefile = new File("plugins" + File.separator + "SimplifiedEssentials" + File.separator + "Homes" + ".yml");
                        FileConfiguration file = YamlConfiguration.loadConfiguration(storagefile);
                        UUID id = ((Player) sender).getUniqueId();
                        String world = player.getWorld().getName();
                        double x = player.getLocation().getX();
                        double y = player.getLocation().getY();
                        double z = player.getLocation().getZ();
                        int count = file.getInt(id + ".homecount");
                        if (count <5) {
                            count++;
                            file.set(id + ".homecount", count);
                            file.set(id + "." + count, args[0]);
                            file.set(id + "." + args[0] + ".world", world);
                            file.set(id + "." + args[0] + ".x", x);
                            file.set(id + "." + args[0] + ".y", y);
                            file.set(id + "." + args[0] + ".z", z);
                            try {
                                file.save(storagefile);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            player.sendMessage(SimplifiedEssentials.prefix + ChatColor.GREEN + "Set your home.");
                        } else {
                            player.sendMessage(ChatColor.RED + "You have reached the maximum amount of homes.");
                        }
                        return true;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Hey! Use the command correctly! /sethome <name>");
            }

        } else {
            sender.sendMessage(ChatColor.RED + "Hey! Only players can use this command!");
        }
        return true;
    }
}
