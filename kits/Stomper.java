package pvp.blatantmc.kits;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import net.minecraft.server.v1_7_R4.EntityPlayer;
import pvp.blatantmc.main.Main;
import pvp.blatantmc.sistemas.ApiManager;
import pvp.blatantmc.sistemas.Cooldown;
import pvp.blatantmc.sistemas.Hability;

public class Stomper implements Listener
{
    @EventHandler
    public void aostomper(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)event.getEntity();
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
            event.getDamage();
            return;
        }
        if (!Hability.getAbility(player).equalsIgnoreCase("Stomper")) {
            return;
        }
        if (event.getDamage() > 4.0) {
            event.setDamage(4.0);
        }
        for (final Entity stomped : player.getNearbyEntities(5.0, 5.0, 5.0)) {
            if (!(stomped instanceof Player)) {
                return;
            }
            if (!((Player)stomped).isSneaking()) {
                final Player st = (Player)stomped;
                if (!Hability.getAbility(st).equalsIgnoreCase("AntiStomper")) {
                    st.damage((double)player.getFallDistance(), (Entity)player);
                }
                else {
                    st.sendMessage("�a�lANTI-STOMPER �fVoc� quase foi esmagado!");
                }
                final EntityPlayer p = ((CraftPlayer)st).getHandle();
                if (p.getHealth() - player.getFallDistance() >= 1.0f) {
                    continue;
                }
                final Location loc = player.getLocation();
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, -5.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, -3.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, -1.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, 1.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, 3.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, 5.0f);
            }
            else {
                ((Player)stomped).damage((double)(player.getFallDistance() / 3.0f), (Entity)player);
                final Player st = (Player)stomped;
                final EntityPlayer p = ((CraftPlayer)st).getHandle();
                if (p.getHealth() - player.getFallDistance() / 4.0f >= 1.0f) {
                    continue;
                }
                final Location loc = player.getLocation();
                player.getWorld().playEffect(player.getLocation().add(0.0, 0.0, 0.0), Effect.WATERDRIP, 30);
                player.getWorld().playEffect(player.getLocation().add(-0.0, 0.0, 0.0), Effect.WATERDRIP, 30);
                player.getWorld().playEffect(player.getLocation().add(0.0, 0.0, -0.0), Effect.WATERDRIP, 30);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, -5.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, -3.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, -1.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, 1.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, 3.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, 5.0f);
            }
        }
    }
    
    @EventHandler
    public void BotaStomper(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getPlayer().getItemInHand().getType() == Material.GOLDEN_APPLE && Hability.getAbility(p).equalsIgnoreCase("Stomper") && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)) {
            e.setCancelled(true);
            p.updateInventory();
            if (Cooldown.add(p)) {
                ApiManager.MensagemCooldown(p);
                return;
            }
            final Vector vector = p.getEyeLocation().getDirection();
            vector.multiply(0.0f);
            vector.setY(10.0f);
            p.setVelocity(vector);
            final Location loc = p.getLocation();
            p.getWorld().playSound(loc, Sound.FIREWORK_BLAST2, 2.0f, 2.0f);
            Cooldown.add(p, 30);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(ApiManager.fimcooldown);
                }
            }, 600L);
        }
    }
}
