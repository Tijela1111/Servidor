package pvp.blatantmc.kits;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.util.*;

import pvp.blatantmc.main.*;
import pvp.blatantmc.sistemas.*;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.*;

public class Shooter implements Listener
{
    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Hability.getAbility(p).equalsIgnoreCase("Shooter") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getInventory().getItemInHand().getType() == Material.BONE) {
            if (Cooldown.add(p)) {
                ApiManager.MensagemCooldown(p);
                return;
            }
            final Vector velo2 = p.getLocation().getDirection().normalize().multiply(100);
            velo2.add(new Vector(Math.random() * 0.0 - 0.0, 0.0, 0.0));
            Cooldown.add(p, 30);
            ((Arrow)p.launchProjectile((Class)Arrow.class)).setVelocity(velo2);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(ApiManager.fimcooldown);
                }
            }, 600L);
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Arrow) {
            final Arrow s = (Arrow)e.getDamager();
            final Player damaged = (Player)e.getEntity();
            if (s.getShooter() instanceof Player) {
                final Player shooter = (Player)s.getShooter();
                if (Hability.getAbility(shooter).equalsIgnoreCase("Shooter")) {
                    e.setDamage(8.0);
                    damaged.getLocation().getWorld().playEffect(damaged.getLocation(), Effect.STEP_SOUND, (Object)Material.REDSTONE_WIRE);
                    damaged.getEyeLocation().getWorld().playEffect(damaged.getLocation(), Effect.BOW_FIRE, 50000, 10000);
                    damaged.getLocation().getWorld().playEffect(damaged.getLocation(), Effect.BLAZE_SHOOT, 10000, 10000);
                }
            }
        }
    }
}
