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

public class delhome implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1) {
                if (args[0].length() > 50) {
                    sender.sendMessage(ChatColor.RED + "Pick a shorter name!");
                    return true;
                } else {
                    // Get the player
                    Player player = ((Player) sender).getPlayer();
                    assert player != null;
                    String id = player.getUniqueId().toString();
                    // Get the file
                    File storagefile = new File("plugins" + File.separator + "SimplifiedEssentials" + File.separator + "Homes" + ".yml");
                    FileConfiguration file = YamlConfiguration.loadConfiguration(storagefile);
                    // Get the home info
                    int amount = file.getInt(id + ".homecount");
                    if (amount != 0) {
                        int counter = 1;
                        while (amount >= counter) {
                            if (file.isSet(id + "." + counter)) {
                                String msg = file.getString(id + "." + counter);
                                file.set(id + "." + args[0] + ".world", null);
                                file.set(id + "." + counter, null);
                                file.set(id + "." + args[0] + ".x", null);
                                file.set(id + "." + args[0] + ".y", null);
                                file.set(id + "." + args[0] + ".z", null);
                                amount--;
                                file.set(id + ".homecount", amount);
                                try {
                                    file.save(storagefile);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                player.sendMessage(SimplifiedEssentials.prefix + ChatColor.GOLD + "Home deleted");
                                return true;
                            }
                            counter++;
                        }
                    }
                    sender.sendMessage(ChatColor.RED + "That home does not exist.");
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
