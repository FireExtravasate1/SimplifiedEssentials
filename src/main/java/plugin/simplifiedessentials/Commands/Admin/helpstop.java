package plugin.simplifiedessentials.Commands.Admin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import plugin.simplifiedessentials.SimplifiedEssentials;

public class helpstop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[]args) {
        SimplifiedEssentials.getPlugin().getConfig().set("Alert operators onjoin to edit the config?", "False");
        SimplifiedEssentials.getPlugin().saveConfig();
        sender.sendMessage(SimplifiedEssentials.prefix + ChatColor.AQUA + "[ADMIN] Success");
        return true;
    }
}
