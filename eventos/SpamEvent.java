package pvp.blatantmc.eventos;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;

import pvp.blatantmc.main.*;

import org.bukkit.event.*;

public class SpamEvent implements Listener
{
    public static HashMap<Player, Long> chat;
    
    static {
        SpamEvent.chat = new HashMap<Player, Long>();
    }
    
    public SpamEvent(final Main main) {
    }
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
    public void aAntiSpam(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (!SpamEvent.chat.containsKey(p)) {
            final int zeitconfig = 2000;
            final long time = System.currentTimeMillis() + 2000L;
            if (p.hasPermission("simulator.falarspam")) {
                return;
            }
            SpamEvent.chat.put(p, time);
        }
        else if (SpamEvent.chat.get(p) <= System.currentTimeMillis()) {
            if (p.hasPermission("simulator.falarspam")) {
                return;
            }
            final int zeitconfig = 2000;
            final long time = System.currentTimeMillis() + 2000L;
            SpamEvent.chat.put(p, time);
        }
        else {
            if (SpamEvent.chat.get(p) < System.currentTimeMillis() || p.hasPermission("simulator.falarspam")) {
                return;
            }
            p.sendMessage("§c§lCHAT §fVocê está falando rápido demais!");
            e.setCancelled(true);
        }
    }
}
