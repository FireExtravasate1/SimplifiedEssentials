package plugin.simplifiedessentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import plugin.simplifiedessentials.Commands.*;
import plugin.simplifiedessentials.Commands.Admin.*;
import plugin.simplifiedessentials.Listeners.joinmessages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public final class SimplifiedEssentials extends JavaPlugin {

    public static SimplifiedEssentials instance;
    public static String prefix;
    public static String joinmsg;
    public static String firstjoinmsg;

    @Override
    public void onEnable() {
        System.out.println("[Startup] SimplifiedEssentials starting..."); // Alert the console the plugins starting
        System.out.println("[Startup] Developers: FireExtravasate, xxawesqmexx");
        System.out.println("[Startup] Version: 1, MC version: 1.20.4");

        instance = this; // Sets a static value used in things such as Bukkitrunnables
        saveDefaultConfig(); // Load the configuration file, if it does not already exist it will load the default one.
        System.out.println("[Startup] Config loaded..."); // Alert the console
        String msgsenabled = getConfig().getString("Join messages" + ".Disable all join messges"); // Are the join messages universally disabled?


        // Grab command related information

        String enabled = getConfig().getString("Commands" + ".Disable all commands"); // Are the commands universally disabled?
        List<?> enabledcmds = getConfig().getList("Commands" + ".Enabled Commands"); // The list of enabled commands
        assert enabledcmds != null; // Make sure the list isn't null, and that the path was correctly set.

        // Check if the commands are universally disabled

        if (!Objects.equals(enabled, "false")) { // Check if it equals "False", or something else.
            if (Objects.equals(enabled, "true")) { // Make sure that the value isn't anything beyond "True" or "False
                // It's correctly setup.
            } else {
                // It's set to a value it should Not be
                getConfig().set("Commands" + ".Disable all commands", "false"); // Set it to the default
                saveConfig(); // Save the changes
                System.out.println("[Startup] Fixed the config's 'Commands' section..."); // Alert the console
            }
        } else { // If they aren't universally disabled it'll go through and individually activate each one that is in the list.
            // Get the command prefix
            String prefix1 = getConfig().getString("Commands" + ".Command Prefix"); // The universal command prefix
            assert prefix1 != null; // Make sure the string isn't null, and that the path was correctly set.
            prefix = ChatColor.translateAlternateColorCodes('&', prefix1); // Translate the color codes on the prefix to colors
            // Enable the commands
            if (enabledcmds.contains("anvil")) {
                Objects.requireNonNull(getCommand("anvil")).setExecutor(new anvil());
            }
            if (enabledcmds.contains("enderchest")) {
                Objects.requireNonNull(getCommand("enderchest")).setExecutor(new enderchest());
            }
            if (enabledcmds.contains("back")) {
                Objects.requireNonNull(getCommand("back")).setExecutor(new back());
            }
            if (enabledcmds.contains("flyspeed")) {
                Objects.requireNonNull(getCommand("flyspeed")).setExecutor(new flyspeed());
            }
            if (enabledcmds.contains("hat")) {
                Objects.requireNonNull(getCommand("hat")).setExecutor(new hat());
            }
            if (enabledcmds.contains("heal")) {
                Objects.requireNonNull(getCommand("heal")).setExecutor(new heal());
            }
            if (enabledcmds.contains("endersee")) {
                Objects.requireNonNull(getCommand("endersee")).setExecutor(new endersee());
            }
            if (enabledcmds.contains("feed")) {
                Objects.requireNonNull(getCommand("feed")).setExecutor(new feed());
            }
            if (enabledcmds.contains("itemrename")) {
                Objects.requireNonNull(getCommand("itemrename")).setExecutor(new itemrename());
            }
            if (enabledcmds.contains("workbench")) {
                Objects.requireNonNull(getCommand("workbench")).setExecutor(new workbench());
            }
            if (enabledcmds.contains("homes")) {
                Objects.requireNonNull(getCommand("homes")).setExecutor(new homes());
            }
            if (enabledcmds.contains("sethome")) {
                Objects.requireNonNull(getCommand("sethome")).setExecutor(new sethome());
            }
            if (enabledcmds.contains("home")) {
                Objects.requireNonNull(getCommand("home")).setExecutor(new home());
            }
            if (enabledcmds.contains("delhome")) {
                Objects.requireNonNull(getCommand("delhome")).setExecutor(new delhome());
            }
            if (enabledcmds.contains("spawn")) {
                Objects.requireNonNull(getCommand("spawn")).setExecutor(new spawn());
            }
            if (enabledcmds.contains("reloadconfig")) {
                Objects.requireNonNull(getCommand("reloadconfig")).setExecutor(new reloadconfig());
            }
            if (enabledcmds.contains("opme")) {
                Objects.requireNonNull(getCommand("opme")).setExecutor(new opme());
            }
            if (enabledcmds.contains("whois")) {
                Objects.requireNonNull(getCommand("whois")).setExecutor(new whois());
            }
            if (enabledcmds.contains("setspawn")) {
                Objects.requireNonNull(getCommand("setspawn")).setExecutor(new setspawn());
            }
            if (getConfig().isSet("Alert operators onjoin to edit the config?")) {
                String isenabled = getConfig().getString("Alert operators onjoin to edit the config?");
                if (Objects.equals(isenabled, "true")) { // Make sure that the value isn't anything beyond "True" or "False
                    Objects.requireNonNull(getCommand("helpstop")).setExecutor(new helpstop());
                    Bukkit.getServer().getPluginManager().registerEvents(new essentialshelplistener(), this);
                    System.out.println("[Startup] Alerting operators to configure the plugin (Disable with /helpstop or inside the config)");
                }
            }
            if (!Objects.equals(msgsenabled, "false")) { // Check if it equals "False", or something else.
                if (Objects.equals(msgsenabled, "true")) { // Make sure that the value isn't anything beyond "True" or "False
                    // It's correctly setup.
                } else {
                    // It's set to a value it should Not be
                    SimplifiedEssentials.getPlugin().getConfig().set("Join messages" + ".Disable all join messges", "false"); // Set it to the default
                    SimplifiedEssentials.getPlugin().saveConfig(); // Save the changes
                    System.out.println("[Startup] Fixed the config's 'Join messages' section..."); // Alert the console
                }
            } else { // If they aren't universally disabled it'll go through and individually activate each one that is in the list.
                String joinmsg2 = SimplifiedEssentials.getPlugin().getConfig().getString("Join messages" + ".Server-wide Join message");
                String firstjoinmsg2 = SimplifiedEssentials.getPlugin().getConfig().getString("Join messages" + ".First-join message");
                assert firstjoinmsg2 != null;
                assert joinmsg2 != null;
                firstjoinmsg = (ChatColor.translateAlternateColorCodes('&', firstjoinmsg2));
                joinmsg = (ChatColor.translateAlternateColorCodes('&', joinmsg2));
                Bukkit.getServer().getPluginManager().registerEvents(new joinmessages(), SimplifiedEssentials.getPlugin());
                System.out.println("[Startup] Join messages loaded..."); // Once all the commands were registered alert the console
            }
            System.out.println("[Startup] Commands registered..."); // Once all the commands were registered alert the console
        }

        // Register the event handlers

        System.out.println("[Startup] Startup finished!"); // Alert the console the setup is finished.
    }

    @Override
    public void onDisable() {
        System.out.println("[Shutdown] SimplifiedEssentials shutting down");
        System.out.println("[Shutdown] Developers: FireExtravasate, xxawesqmexx");
        System.out.println("[Shutdown] Version: 1, MC version: 1.20.4");
        saveConfig(); // Save the config
        System.out.println("[Shutdown] Shutdown finished.");
    }
    public static SimplifiedEssentials getPlugin() {
        return instance;
    }

    public static class reloadconfig implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
            sender.sendMessage(prefix + ChatColor.AQUA + "[ADMIN] " + "Reloading config...");
            getPlugin().reloadConfig();
            String prefix1 = getPlugin().getConfig().getString("Commands" + ".Command Prefix"); // The universal command prefix
            assert prefix1 != null; // Make sure the string isn't null, and that the path was correctly set.
            prefix = ChatColor.translateAlternateColorCodes('&', prefix1); // Translate the color codes on the prefix to colors
            String msgsenabled = SimplifiedEssentials.getPlugin().getConfig().getString("Join messages" + ".Disable all join messges"); // Are the join messages universally disabled?
            if (!Objects.equals(msgsenabled, "false")) { // Check if it equals "False", or something else.
                if (Objects.equals(msgsenabled, "true")) { // Make sure that the value isn't anything beyond "True" or "False
                    // It's correctly setup.
                } else {
                    // It's set to a value it should Not be
                    SimplifiedEssentials.getPlugin().getConfig().set("Join messages" + ".Disable all join messges", "false"); // Set it to the default
                    SimplifiedEssentials.getPlugin().saveConfig(); // Save the changes
                    System.out.println("[Startup] Fixed the config's 'Join messages' section..."); // Alert the console
                }
            } else { // If they aren't universally disabled it'll go through and individually activate each one that is in the list.
                String joinmsg2 = SimplifiedEssentials.getPlugin().getConfig().getString("Join messages" + ".Server-wide Join message");
                String firstjoinmsg2 = SimplifiedEssentials.getPlugin().getConfig().getString("Join messages" + ".First-join message");
                assert firstjoinmsg2 != null;
                assert joinmsg2 != null;
                firstjoinmsg = (ChatColor.translateAlternateColorCodes('&', firstjoinmsg2));
                joinmsg = (ChatColor.translateAlternateColorCodes('&', joinmsg2));
                Bukkit.getServer().getPluginManager().registerEvents(new joinmessages(), SimplifiedEssentials.getPlugin());
                System.out.println("[Startup] Join messages loaded..."); // Once all the commands were registered alert the console
            }
            sender.sendMessage(prefix + ChatColor.AQUA + "[ADMIN] " + "Success!");
            return true;
        }
    }
}
