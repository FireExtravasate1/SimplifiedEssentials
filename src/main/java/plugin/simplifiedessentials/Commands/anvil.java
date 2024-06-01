package plugin.simplifiedessentials.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

import static org.bukkit.Bukkit.createInventory;

public class anvil implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                Player player = ((Player) sender).getPlayer();
                assert player != null;
                player.openInventory(createInventory(null, InventoryType.ANVIL));
            } else {
                sender.sendMessage(ChatColor.RED + "Use the command correctly! /anvil");
                return true;
            }

        } else {
            sender.sendMessage(ChatColor.RED + "Hey! Only players can use that command!");
            return false;
        }
        return true;
    }
}
