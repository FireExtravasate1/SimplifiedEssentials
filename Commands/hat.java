package plugin.simplifiedessentials.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import plugin.simplifiedessentials.SimplifiedEssentials;

public class hat implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender player, Command command, String label, String[] args) {
        if (!(player instanceof Player)) {
                player.sendMessage(ChatColor.RED + "Hey! Only players can use that command!");
            return true;
        }
        ItemStack hat = ((Player) player).getInventory().getItemInMainHand();
        if (hat != null && hat.getType() != Material.AIR && hat.getAmount() == 1) {
            ItemStack currentHelmetItem = ((Player) player).getInventory().getHelmet();
            if (currentHelmetItem == null || currentHelmetItem.getType() == Material.AIR) {
                ((Player) player).getInventory().setHelmet(hat);
                ((Player) player).getInventory().setItemInMainHand(new ItemStack(Material.AIR));
            } else {
                ((Player) player).getInventory().setHelmet(hat);
                ((Player) player).getInventory().setItemInMainHand(currentHelmetItem);
            }
        } else {
            player.sendMessage(ChatColor.RED + "Hat must not be air, and must only be one item.");
        }

        return true;
    }
}