package pvp.blatantmc.kits2;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;

import pvp.blatantmc.main.Main;
import pvp.blatantmc.sistemas.ApiManager;
import pvp.blatantmc.sistemas.Cooldown;
import pvp.blatantmc.sistemas.Hability;

public class Ninja implements Listener
{
    public HashMap<Player, Player> ajinhash;
    public HashMap<Player, Long> ajincooldown;
    
    public Ninja() {
        this.ajinhash = new HashMap<Player, Player>();
        this.ajincooldown = new HashMap<Player, Long>();
    }
    
    @EventHandler
    public void a(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            final Player p = (Player)e.getDamager();
            final Player t = (Player)e.getEntity();
            if (Hability.getAbility(p).equalsIgnoreCase("Ninja")) {
                this.ajinhash.put(p, t);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 200L);
            }
        }
    }
    
    @EventHandler
    public void aPlayerToggle(final PlayerToggleSneakEvent e) {
        final Player p = e.getPlayer();
        if (Cooldown.add(p)) {
            ApiManager.MensagemCooldown(p);
            return;
        }
        if (e.isSneaking() && Hability.getAbility(p).equalsIgnoreCase("Ninja") && this.ajinhash.containsKey(p)) {
            final Player t = this.ajinhash.get(p);
            if (t != null && !t.isDead()) {
                String s = null;
                if (this.ajincooldown.get(p) != null) {
                    final long l = this.ajincooldown.get(p) - System.currentTimeMillis();
                    final DecimalFormat localDecimalFormat = new DecimalFormat("##");
                    final int i = (int)l / 1000;
                    s = localDecimalFormat.format(i);
                }
                if (p.getLocation().distance(t.getLocation()) < 200.0) {
                    p.teleport(t.getLocation());
                    p.sendMessage("§aTeleportado");
                    Cooldown.add(p, 3);
                    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            p.sendMessage(ApiManager.fimcooldown);
                        }
                    }, 60L);
                }
                else {
                    p.sendMessage("§c§lNINJA §fO último jogador hitado está muito longe!");
                }
            }
        }
    }
    
    @EventHandler
    public void aomorrer(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        final Player t = this.ajinhash.get(p);
        this.ajinhash.remove(t);
        this.ajinhash.remove(p);
    }
    
    @EventHandler
    public void aosair(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        final Player t = this.ajinhash.get(p);
        this.ajinhash.remove(t);
        this.ajinhash.remove(p);
    }
}
