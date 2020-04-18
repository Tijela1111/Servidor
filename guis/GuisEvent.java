package pvp.blatantmc.guis;

import java.util.*;
import org.bukkit.event.player.*;

import pvp.blatantmc.sistemas.*;

import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class GuisEvent implements Listener
{
    public static ArrayList<String> aocaixa;
    
    static {
        GuisEvent.aocaixa = new ArrayList<String>();
    }
    
    @EventHandler
    public void onBauKit(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType().equals((Object)Material.CHEST) && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eKits §7(Clique)")) {
            e.setCancelled(true);
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                GuiKits.GuiKit(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            }
        }
    }
    
    @EventHandler
    public void onWarp(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType().equals((Object)Material.COMPASS) && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eWarps §7(Clique)")) {
            e.setCancelled(true);
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                GuiWarps.GuiWarp(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            }
        }
    }
    
    @EventHandler
    public void onLojas(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType().equals((Object)Material.GOLD_INGOT) && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eLojas §7(Clique)")) {
            e.setCancelled(true);
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                GuiLoja.GuiLojas(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            }
        }
    }
    
    @EventHandler
    public void onCaixa(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType().equals((Object)Material.ENDER_CHEST) && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eCaixa §7(Clique)")) {
            e.setCancelled(true);
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (KillsDeathsRankXp.getCaixa(p) >= 1) {
                    if (GuisEvent.aocaixa.contains(p.getName())) {
                        p.sendMessage("§c§lCAIXA §fVocê já está abrindo uma caixa!");
                        return;
                    }
                    GuiCaixa.GuiCaixas(p);
                    KillsDeathsRankXp.removerCaixa(p, 1);
                    GuisEvent.aocaixa.add(p.getName());
                }
                else {
                    p.sendMessage("§c§lCAIXA §fVocê não possui nenhuma caixa!");
                }
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            }
        }
    }
}
