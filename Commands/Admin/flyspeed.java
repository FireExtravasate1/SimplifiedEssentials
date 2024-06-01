package plugin.simplifiedessentials.Commands.Admin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flyspeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender player, Command command, String label, String[] args) {
        if (!(player instanceof Player)) {
            player.sendMessage(ChatColor.RED + "You must be in game to use this command.");
            return true;
        }
        if (args.length == 1) {
            try {
                float speed = Float.parseFloat(args[0]);
                if (speed > 0 && speed < 11) {
                    speed = speed/10;
                    ((Player) player).setFlySpeed(speed);
                } else {
                    player.sendMessage(ChatColor.RED + "FlySpeed must be 1-10.");
                    return true;
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        } else {
            player.sendMessage(ChatColor.RED + "Usage: /flySpeed <1-10>");
        }
        return true;
    }
}