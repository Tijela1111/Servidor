package pvp.blatantmc.kits;

import org.bukkit.event.block.*;
import org.bukkit.entity.*;
import org.bukkit.*;

import java.util.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

import pvp.blatantmc.main.*;
import pvp.blatantmc.sistemas.*;

import org.bukkit.event.entity.*;

public class TimeLord implements Listener
{
    public static ArrayList<String> playercongelados;
    
    static {
        TimeLord.playercongelados = new ArrayList<String>();
    }
    
    @EventHandler
    public void onTimerLord(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Hability.getAbility(p).equalsIgnoreCase("TimeLord") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getInventory().getItemInHand().getType() == Material.WATCH) {
            if (Cooldown.add(p)) {
                ApiManager.MensagemCooldown(p);
                return;
            }
            Cooldown.add(p, 15);
            p.sendMessage("§a§lTIME-LORD §fVocê congelou um jogador!");
            for (final Entity pertos : p.getNearbyEntities(5.0, 5.0, 5.0)) {
                TimeLord.playercongelados.add(((Player)pertos).getName());
                ((Player)pertos).sendMessage("§c§lTIME-LORD §fVocê foi congelado por um TIMELORD!");
                ((Player)pertos).playSound(pertos.getLocation(), Sound.WITHER_SPAWN, 1.0f, 1.0f);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        TimeLord.playercongelados.remove(((Player)pertos).getName());
                        ((Player)pertos).sendMessage("§a§lTIME-LORD §fVocê não está mais congelado!");
                    }
                }, 160L);
            }
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(ApiManager.fimcooldown);
                }
            }, 400L);
        }
    }
    
    @EventHandler
    public void onTimerLordado(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (TimeLord.playercongelados.contains(p.getName())) {
            e.setTo(p.getLocation());
        }
    }
    
    @EventHandler
    public void TirarTimelord(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        final Player s = (Player)e.getDamager();
        if (Hability.getAbility(s).equalsIgnoreCase("TimeLord") && s.getInventory().getItemInHand() != null) {
            TimeLord.playercongelados.remove(p.getName());
        }
    }
}
