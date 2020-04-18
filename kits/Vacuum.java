package pvp.blatantmc.kits;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import pvp.blatantmc.main.Main;
import pvp.blatantmc.sistemas.ApiManager;
import pvp.blatantmc.sistemas.Cooldown;
import pvp.blatantmc.sistemas.Hability;

public class Vacuum implements Listener
{
    @EventHandler
    public void onVacuum(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (Hability.getAbility(p).equalsIgnoreCase("Vacuum") && p.getItemInHand().getType().equals((Object)Material.EYE_OF_ENDER)) {
            for (final Entity targetplayer : p.getNearbyEntities(15.0, 15.0, 15.0)) {
                final Entity nearby = targetplayer;
                if (!(targetplayer instanceof Player)) {
                    return;
                }
                if (Cooldown.add(p)) {
                    ApiManager.MensagemCooldown(p);
                    return;
                }
                final Location lc = targetplayer.getLocation();
                final Location to = p.getLocation();
                lc.setY(lc.getY() + 0.5);
                final double g = -0.08;
                final double t;
                final double d = t = to.distance(lc);
                final double v_x = (1.0 + 0.17 * t) * (to.getX() - lc.getX()) / t;
                final double v_y = (1.0 + 0.03 * t) * (to.getY() - lc.getY()) / t - 0.5 * g * t;
                final double v_z = (1.0 + 0.17 * t) * (to.getZ() - lc.getZ()) / t;
                final Vector v = p.getVelocity();
                v.setX(v_x);
                v.setY(v_y);
                v.setZ(v_z);
                targetplayer.setVelocity(v);
                p.sendMessage("§a§lVACUUM §fVocê está puxando os players em volta de você!");
                Cooldown.add(p, 15);
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        p.sendMessage(ApiManager.fimcooldown);
                    }
                }, 300L);
            }
        }
    }
}
