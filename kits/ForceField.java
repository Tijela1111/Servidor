package pvp.blatantmc.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import pvp.blatantmc.main.Main;
import pvp.blatantmc.sistemas.ApiManager;
import pvp.blatantmc.sistemas.Cooldown;
import pvp.blatantmc.sistemas.Hability;

public class ForceField implements Listener
{
    public static ArrayList<Player> forcefielddano;
    
    static {
        ForceField.forcefielddano = new ArrayList<Player>();
    }
    
    @EventHandler
    public void stomperApple(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (event.getPlayer().getItemInHand().getType() == Material.IRON_FENCE && Hability.getAbility(p).equalsIgnoreCase("ForceField")) {
            if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                event.setCancelled(true);
            }
            if (Cooldown.add(p)) {
                ApiManager.MensagemCooldown(p);
                return;
            }
            final Location loc = p.getLocation();
            p.getWorld().playSound(loc, Sound.MAGMACUBE_WALK2, 5.0f, -5.0f);
            Cooldown.add(p, 30);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    ForceField.forcefielddano.add(p);
                    p.sendMessage("§a§lFORCE-FIELD §fSeu kit force-field foi ativado!");
                }
            }, 0L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    ForceField.forcefielddano.remove(p);
                }
            }, 200L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(ApiManager.fimcooldown);
                }
            }, 600L);
        }
    }
    
    @SuppressWarnings("unused")
	@EventHandler
    public void darForceField(final PlayerMoveEvent event) {
        final Player p = event.getPlayer();
        if (ForceField.forcefielddano.contains(p)) {
            final List<Entity> Local = (List<Entity>)p.getNearbyEntities(4.0, 4.0, 4.0);
            for (final Entity inimigos : Local) {
                if (!(inimigos instanceof Player)) {
                    return;
                }
                if (inimigos == null) {
                    p.sendMessage("§c§lFORCE-FIELD §fNão existe nenhum player por perto de você!");
                    return;
                }
                final Player local = (Player)inimigos;
                local.damage(3.0);
                inimigos.setVelocity(new Vector(0.2, 0.0, 0.2));
            }
        }
    }
}
