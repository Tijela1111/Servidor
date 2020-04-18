package pvp.blatantmc.kits;

import org.bukkit.inventory.*;
import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;

import pvp.blatantmc.main.*;
import pvp.blatantmc.sistemas.*;

import org.bukkit.event.*;
import org.bukkit.event.inventory.*;

public class Phantom implements Listener
{
    public static HashMap<String, ItemStack[]> salvararmor;
    public static ArrayList<String> emphantom;
    
    static {
        Phantom.salvararmor = new HashMap<String, ItemStack[]>();
        Phantom.emphantom = new ArrayList<String>();
    }
    
    @EventHandler
    public void aogigante(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Hability.getAbility(p).equalsIgnoreCase("Phantom") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.FEATHER) {
            if (Cooldown.add(p)) {
                ApiManager.MensagemCooldown(p);
                return;
            }
            Phantom.salvararmor.put(p.getName(), p.getInventory().getArmorContents());
            ApiManager.tirarArmadura(p);
            p.getInventory().setArmorContents(new ItemStack[] { ApiManager.darArmadura(Material.LEATHER_HELMET, Color.WHITE), ApiManager.darArmadura(Material.LEATHER_CHESTPLATE, Color.WHITE), ApiManager.darArmadura(Material.LEATHER_LEGGINGS, Color.WHITE), ApiManager.darArmadura(Material.LEATHER_BOOTS, Color.WHITE) });
            p.updateInventory();
            Phantom.emphantom.add(p.getName());
            p.setAllowFlight(true);
            p.setFlying(true);
            Cooldown.add(p, 20);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§c§lPHANTOM §fSeu fly está acabando em §c5!");
                }
            }, 0L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§c§lPHANTOM §fSeu fly está acabando em §c4!");
                }
            }, 20L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§c§lPHANTOM §fSeu fly está acabando em §c3!");
                }
            }, 40L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§c§lPHANTOM §fSeu fly está acabando em §c2!");
                }
            }, 60L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§c§lPHANTOM §fSeu fly está acabando em §c1!");
                }
            }, 80L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§c§lPHANTOM §fSeu fly do kit phantom acabou!");
                    Phantom.emphantom.remove(p.getName());
                    p.getInventory().setArmorContents((ItemStack[])Phantom.salvararmor.get(p.getName()));
                    p.updateInventory();
                    p.setAllowFlight(false);
                    p.setFlying(false);
                }
            }, 100L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(ApiManager.fimcooldown);
                }
            }, 400L);
        }
    }
    
    @EventHandler
    public void aoinv(final InventoryClickEvent e) {
        try {
            final Player p = (Player)e.getWhoClicked();
            if (Phantom.emphantom.contains(p.getName()) && e.getSlotType().equals((Object)InventoryType.SlotType.ARMOR)) {
                e.setCancelled(true);
            }
        }
        catch (Exception ex) {}
    }
}
