package plugin.simplifiedessentials.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Arrays;

import static plugin.simplifiedessentials.SimplifiedEssentials.firstjoinmsg;
import static plugin.simplifiedessentials.SimplifiedEssentials.joinmsg;

public class joinmessages implements Listener {
    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPlayedBefore()) {
            if (joinmsg.contains("%player%")) {
                if (joinmsg.contains("%uniquejoin%")) {
                    int amount1 = Bukkit.getServer().getOfflinePlayers().length;
                    int amount2 = Bukkit.getServer().getOnlinePlayers().size();
                    int amount3 = amount2 + amount1 -1;

                    int startIndex = 0;
                    int endIndex = joinmsg.indexOf("%player%");
                    int length = joinmsg.length();

                    // Extract the current chunk of the message
                    String chunk = joinmsg.substring(startIndex, endIndex);
                    String chunk2 = joinmsg.substring(endIndex + 8, length);
                    String msg = chunk + event.getPlayer().getDisplayName() + chunk2;

                    int startIndex2 = 0;
                    int endIndex2 = msg.indexOf("%uniquejoin%");
                    int length2 = msg.length();

                    // Extract the current chunk of the message
                    String chunk3 = msg.substring(startIndex2, endIndex2);
                    String chunk4 = msg.substring(endIndex2 + 12, length2);
                    String msg2 = chunk3 + amount3 + chunk4;
                    event.setJoinMessage(msg2);
                } else {

                    int startIndex = 0;
                    int endIndex = joinmsg.indexOf("%player%");
                    int length = joinmsg.length();

                    // Extract the current chunk of the message
                    String chunk = joinmsg.substring(startIndex, endIndex);
                    String chunk2 = joinmsg.substring(endIndex + 8, length);
                    String msg = chunk + event.getPlayer().getDisplayName() + chunk2;
                    event.setJoinMessage(msg);
                }
            } else {
                event.setJoinMessage(joinmsg);
            }
        } else {
            if (firstjoinmsg.contains("%player%")) {
                if (firstjoinmsg.contains("%uniquejoin%")) {
                    int amount1 = Bukkit.getServer().getOfflinePlayers().length;
                    int amount2 = Bukkit.getServer().getOnlinePlayers().size();
                    int amount3 = amount2 + amount1 -1;

                    int startIndex = 0;
                    int endIndex = firstjoinmsg.indexOf("%player%");
                    int length = firstjoinmsg.length();

                    // Extract the current chunk of the message
                    String chunk = firstjoinmsg.substring(startIndex, endIndex);
                    String chunk2 = firstjoinmsg.substring(endIndex + 8, length);
                    String msg = chunk + event.getPlayer().getDisplayName() + chunk2;

                    int startIndex2 = 0;
                    int endIndex2 = msg.indexOf("%uniquejoin%");
                    int length2 = msg.length();

                    // Extract the current chunk of the message
                    String chunk3 = msg.substring(startIndex2, endIndex2);
                    String chunk4 = msg.substring(endIndex2 + 12, length2);
                    String msg2 = chunk3 + amount3 + chunk4;
                    event.setJoinMessage(msg2);
                } else {
                    int startIndex = 0;
                    int endIndex = firstjoinmsg.indexOf("%player%");
                    int length = firstjoinmsg.length();

                    // Extract the current chunk of the message
                    String chunk = firstjoinmsg.substring(startIndex, endIndex);
                    String chunk2 = firstjoinmsg.substring(endIndex + 8, length);
                    String msg = chunk + event.getPlayer().getDisplayName() + chunk2;
                    event.setJoinMessage(msg);
                }
            } else {
                if (firstjoinmsg.contains("%uniquejoin%")) {
                    int amount1 = Bukkit.getServer().getOfflinePlayers().length;
                    int amount2 = Bukkit.getServer().getOnlinePlayers().size();
                    int amount3 = amount2 + amount1 -1;

                    int startIndex = 0;
                    int endIndex = firstjoinmsg.indexOf("%uniquejoin%");
                    int length = firstjoinmsg.length();

                    // Extract the current chunk of the message
                    String chunk = firstjoinmsg.substring(startIndex, endIndex);
                    String chunk2 = firstjoinmsg.substring(endIndex + 12, length);
                    String msg2 = chunk + amount3 + chunk2;
                    event.setJoinMessage(msg2);
                } else {
                    event.setJoinMessage(firstjoinmsg);
                }
            }
        }
    }
}
