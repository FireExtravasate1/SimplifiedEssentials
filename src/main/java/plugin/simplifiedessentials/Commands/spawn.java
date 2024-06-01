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
import java.io.IOException;

public class spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            File storagefile = new File("plugins" + File.separator + "SimplifiedEssentials" + File.separator + "Homes" + ".yml");
            FileConfiguration file = YamlConfiguration.loadConfiguration(storagefile);
            Location spawn;
            if (file.isSet("spawn")) {
                spawn = file.getLocation("spawn");
            } else {
                file.set("spawn", ((Player) sender).getLocation());
                spawn = file.getLocation("spawn");
                try {
                    file.save(storagefile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (args.length == 0) {
                Player player = ((Player) sender).getPlayer();
                assert player != null;
                assert spawn != null;
                player.teleport(spawn);
                player.sendMessage(SimplifiedEssentials.prefix + ChatColor.GREEN + "Warped to spawn");

            } else {
                if (args.length == 1) {
                    if (sender.hasPermission("essentials.spawn.others")) {
                        Player player2 = Bukkit.getServer().getPlayer(args[0]);
                        if (player2 != null) {
                            assert spawn != null;
                            player2.teleport(spawn);
                            player2.sendMessage(SimplifiedEssentials.prefix + ChatColor.GREEN + "Warped to spawn");
                            sender.sendMessage(SimplifiedEssentials.prefix + ChatColor.GREEN + "Warped " + args[0] + " to spawn");
                        } else {
                            sender.sendMessage(ChatColor.RED + "That player does not exist!");
                        }
                    } else {
                        sender.sendMessage(ChatColor.RED + "Hey! Use the command properly! /spawn");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Hey! Use the command properly! /spawn");
                    return true;
                }
            }

        } else {
            sender.sendMessage(ChatColor.RED + "Hey! Only players are allowed to use this command!");
            return true;
        }
        return true;
    }
}
