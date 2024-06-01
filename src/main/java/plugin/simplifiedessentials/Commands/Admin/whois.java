package plugin.simplifiedessentials.Commands.Admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import plugin.simplifiedessentials.SimplifiedEssentials;

import java.net.InetSocketAddress;
import java.util.UUID;

public class whois implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Use the command properly! /whois <player>");
            return true;
        } else {
            String playerName = args[0];
            Player player2 = Bukkit.getPlayer(playerName);
            if (player2 != null) {
                try {
                    // Get information about the player
                    UUID player2id = player2.getUniqueId();
                    boolean player2flying = player2.isFlying();
                    int player2x = (int) player2.getLocation().getX();
                    int player2y = (int) player2.getLocation().getY();
                    int player2z = (int) player2.getLocation().getZ();
                    String player2world = player2.getWorld().getName();
                    String player2health = String.valueOf(player2.getHealth());
                    boolean player2sleeping = player2.isSleeping();
                    boolean player2sneaking = player2.isSneaking();
                    boolean player2sprinting = player2.isSprinting();
                    String player2previousgamemode = String.valueOf(player2.getPreviousGameMode());
                    String player2gamemode = String.valueOf(player2.getGameMode());
                    InetSocketAddress player2ip = player2.getAddress();
                    // Send it to the sender
                    sender.sendMessage(SimplifiedEssentials.prefix + ChatColor.BOLD + ChatColor.YELLOW + playerName + "'s player information");
                    sender.sendMessage(ChatColor.WHITE + " -UUID: " + player2id);
                    sender.sendMessage(ChatColor.WHITE + " -Location: " + player2x + " " + player2y + " " + player2z + " " + player2world);
                    sender.sendMessage(ChatColor.WHITE + " -Flying: " + player2flying);
                    sender.sendMessage(ChatColor.WHITE + " -Health: " + player2health);
                    sender.sendMessage(ChatColor.WHITE + " -Sleeping: " + player2sleeping);
                    sender.sendMessage(ChatColor.WHITE + " -Sprinting: " + player2sprinting);
                    sender.sendMessage(ChatColor.WHITE + " -Sneaking: " + player2sneaking);
                    sender.sendMessage(ChatColor.WHITE + " -Gamemode: " + player2gamemode);
                    sender.sendMessage(ChatColor.WHITE + " -Previous Gamemode: " + player2previousgamemode);
                    sender.sendMessage(ChatColor.WHITE + " -IP: " + player2ip);
                    return true;
                } catch (NullPointerException e) {
                    // Handle the NullPointerException gracefully
                    sender.sendMessage("An error occurred while processing the command.");
                    e.printStackTrace(); // Print the stack trace for debugging purposes
                    return false;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Player not found.");
                return true;
            }
        }
    }
}