package pvp.blatantmc.sistemas;

import org.bukkit.event.player.*;

import pvp.blatantmc.main.Main;

import java.util.*;
import org.bukkit.event.*;

public class Plugins implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommandPreProcess(final PlayerCommandPreprocessEvent e) {
        final String[] msg = e.getMessage().split(" ");
        final List<String> plugins = new ArrayList<String>();
        plugins.add("pl");
        plugins.add("plugin");
        plugins.add("about" + msg);
        plugins.add("ver" + msg);
        plugins.add("help" + msg);
        plugins.add("ver");
        plugins.add("help");
        plugins.add("?");
        plugins.add("me");
        plugins.add("bukkit:me");
        plugins.add("calc");
        plugins.add("bukkit:help");
        plugins.add("bukkit:pl");
        plugins.add("bukkit:plugins");
        plugins.add("about");
        plugins.add("about" + msg);
        plugins.add("bukkit:?");
        plugins.add("plugins");
        plugins.add("minecraft:me");
        for (final String Loop : plugins) {
            if (msg[0].equalsIgnoreCase("/" + Loop)) {
            	e.getPlayer().sendMessage("§fPlugins (3): §aPvP§f, §aCommons§f, §aStarAPI");
                e.setCancelled(true);
            }
        }
    }
}
