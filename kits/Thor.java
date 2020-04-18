package pvp.blatantmc.kits;

import org.bukkit.event.player.*;

import pvp.blatantmc.main.*;
import pvp.blatantmc.sistemas.*;

import org.bukkit.event.block.*;

import java.util.*;

import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class Thor implements Listener
{
    @EventHandler
    public void ThorKit(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Hability.getAbility(p).equalsIgnoreCase("Thor") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.GOLD_AXE) {
            if (Cooldown.add(p)) {
                ApiManager.MensagemCooldown(p);
                return;
            }
            Cooldown.add(p, 5);
            final Location loc = p.getTargetBlock((HashSet)null, 30).getLocation();
            p.getWorld().strikeLightning(loc);
            e.setCancelled(true);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(ApiManager.fimcooldown);
                }
            }, 100L);
        }
    }
}
