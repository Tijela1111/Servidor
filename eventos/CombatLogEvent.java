package pvp.blatantmc.eventos;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.*;

import pvp.blatantmc.main.Main;
import pvp.blatantmc.sistemas.Hability;

import org.bukkit.plugin.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;

public class CombatLogEvent implements Listener
{
    public static HashMap<Player, Player> emcombate;
    
    static {
        CombatLogEvent.emcombate = new HashMap<Player, Player>();
    }
    
    public static boolean emCombate(final Player p) {
        return CombatLogEvent.emcombate.containsKey(p);
    }
    
    public static String statuscombat(final Player p) {
        String nome = "";
        if (emCombate(p)) {
            nome = "§aSim";
        }
        else if (!emCombate(p)) {
            nome = "§cNão";
        }
        return nome;
    }
    
    @EventHandler
    public void aocombatlog(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player hitter = (Player)e.getDamager();
            if (Hability.getAbility(p) != "Nenhum" && Hability.getAbility(hitter) != "Nenhum" && !CombatLogEvent.emcombate.containsKey(p) && !CombatLogEvent.emcombate.containsKey(hitter)) {
                CombatLogEvent.emcombate.put(p, hitter);
                CombatLogEvent.emcombate.put(hitter, p);
                hitter.sendMessage("§c§lCOMBATLOG §fVocê entrou em combate com §c" + p.getDisplayName());
                p.sendMessage("§c§lCOMBATLOG §fVocê entrou em combate com §c" + hitter.getDisplayName());
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        CombatLogEvent.emcombate.remove(p);
                        CombatLogEvent.emcombate.remove(hitter);
                        hitter.sendMessage("§a§lCOMBATLOG §fVocê está fora de combate!");
                        p.sendMessage("§a§lCOMBATLOG §fVocê está fora de combate!");
                    }
                }, 400L);
            }
        }
    }
    
    @EventHandler
    public void aomorrer(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        if (CombatLogEvent.emcombate.containsKey(p.getName())) {
            final Player t = CombatLogEvent.emcombate.get(p.getName());
            p.teleport(p.getWorld().getSpawnLocation());
            t.sendMessage("§a§lCOMBATLOG §fVocê está fora de combate!");
            CombatLogEvent.emcombate.remove(p);
            CombatLogEvent.emcombate.remove(t);
        }
    }
    
    @EventHandler
    public void aosair(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (CombatLogEvent.emcombate.containsKey(p.getName())) {
            final Player t = CombatLogEvent.emcombate.get(p.getName());
            p.setHealth(0.0);
            p.teleport(p.getWorld().getSpawnLocation());
            CombatLogEvent.emcombate.remove(p);
            CombatLogEvent.emcombate.remove(t);
            Bukkit.broadcastMessage("§c§lCOMBATLOG §fO jogador §c" + p.getName() + "§fdeslogou em combate!");
            t.sendMessage("§a§lCOMBATLOG §fVocê está fora de combate!");
        }
    }
    
    @EventHandler
    public void aocomando(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        if (e.getMessage().toLowerCase().startsWith("/") && CombatLogEvent.emcombate.containsKey(p)) {
            p.sendMessage("§c§lCOMBATLOG §fVocê não pode usar comandos em combate!");
            e.setCancelled(true);
        }
    }
}
