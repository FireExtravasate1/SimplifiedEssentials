package plugin.simplifiedessentials.Commands.Admin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class itemrename implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender player, Command command, String label, String[] args) {
        if (!(player instanceof Player)) {
            player.sendMessage(ChatColor.RED + "You must be in game to use this command.");
            return true;
        }
        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Usage: /itemRename &c&lCUSTOM NAME! (Whatever name you want use '&' for color codes)");
            return true;
        }
        ItemStack heldItem = ((Player) player).getInventory().getItemInMainHand();
        if (heldItem != null && heldItem.getType() != Material.AIR) {
            ItemMeta heldItemMeta = heldItem.getItemMeta();
            heldItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[0]));
            heldItem.setItemMeta(heldItemMeta);
            ((Player) player).getInventory().setItemInMainHand(heldItem);
        } else {
            player.sendMessage(ChatColor.RED + "Held item cannot be air.");
        }
        return true;
    }
}