package pvp.blatantmc.kits2;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;

import pvp.blatantmc.main.*;
import pvp.blatantmc.sistemas.*;

import org.bukkit.event.*;

public class Pyro implements Listener
{
    @EventHandler
    public void aopyro(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Hability.getAbility(p).equalsIgnoreCase("Pyro") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.FIREBALL) {
            if (Cooldown.add(p)) {
                ApiManager.MensagemCooldown(p);
                return;
            }
            Cooldown.add(p, 21);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Fireball fire = (Fireball)p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
                    fire.setFireTicks(30);
                }
            }, 0L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Fireball fire = (Fireball)p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
                    fire.setFireTicks(30);
                }
            }, 15L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Fireball fire = (Fireball)p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
                    fire.setFireTicks(30);
                }
            }, 20L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Fireball fire = (Fireball)p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
                    fire.setFireTicks(30);
                }
            }, 25L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Fireball fire = (Fireball)p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
                    fire.setFireTicks(30);
                }
            }, 30L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(ApiManager.fimcooldown);
                }
            }, 420L);
        }
    }
}
