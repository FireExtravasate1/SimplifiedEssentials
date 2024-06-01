package plugin.simplifiedessentials.Commands.Admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import plugin.simplifiedessentials.SimplifiedEssentials;

import java.util.Objects;

public class essentialshelplistener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (event.getPlayer().isOp()) {
            if (SimplifiedEssentials.getPlugin().getConfig().isSet("Alert operators onjoin to edit the config?")) {
                String isenabled = SimplifiedEssentials.getPlugin().getConfig().getString("Alert operators onjoin to edit the config?");
                if (Objects.equals(isenabled, "true")) { // Make sure that the value isn't anything beyond "True" or "False
                    event.getPlayer().sendMessage(SimplifiedEssentials.prefix + ChatColor.AQUA + "Heyo, it appears you're yet to configure the SimplifiedEssentials plugin! Please check out the config, and if you wish to stop seeing this simply do /helpstop");

                }
            }
        }
    }
}
