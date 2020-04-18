package pvp.blatantmc.guis;

import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import pvp.blatantmc.sistemas.*;

import org.bukkit.event.inventory.*;
import org.bukkit.command.*;
import org.bukkit.event.*;

public class GuiWarps implements Listener
{
    public static void GuiWarp(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "§aWarps");
        final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)1);
        final ItemMeta vidrom = vidro.getItemMeta();
        vidrom.setDisplayName("§7Vidro");
        vidro.setItemMeta(vidrom);
        inv.setItem(0, vidro);
        inv.setItem(1, vidro);
        inv.setItem(2, vidro);
        inv.setItem(3, vidro);
        inv.setItem(4, vidro);
        inv.setItem(5, vidro);
        inv.setItem(6, vidro);
        inv.setItem(7, vidro);
        inv.setItem(8, vidro);
        inv.setItem(9, vidro);
        ApiManager.darItemInv(inv, Material.BLAZE_ROD, 1, 0, "§a§l1V1", 10);
        ApiManager.darItemInv(inv, Material.LAVA_BUCKET, 1, 0, "§a§lLAVA CHALLENGE", 11);
        ApiManager.darItemInv(inv, Material.GLASS, 1, 0, "§a§lFPS", 12);
        inv.setItem(13, vidro);
        ApiManager.darItemInv(inv, Material.EYE_OF_ENDER, 1, 0, "§a§lMAIN", 14);
        ApiManager.darItemInv(inv, Material.GLOWSTONE, 1, 0, "§a§lBOLOTA", 15);
        ApiManager.darItemInv(inv, Material.POTION, 1, 0, "§a§lPOTIONPVP", 16);
        inv.setItem(17, vidro);
        inv.setItem(18, vidro);
        inv.setItem(19, vidro);
        inv.setItem(20, vidro);
        inv.setItem(21, vidro);
        inv.setItem(22, vidro);
        inv.setItem(23, vidro);
        inv.setItem(24, vidro);
        inv.setItem(25, vidro);
        inv.setItem(26, vidro);
        p.openInventory(inv);
    }
    
    @EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§aWarps") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
                e.setCancelled(true);
                Bukkit.dispatchCommand((CommandSender)p, "warp challenge");
                return;
            }
            if (e.getCurrentItem().getType() == Material.GLASS) {
                e.setCancelled(true);
                Bukkit.dispatchCommand((CommandSender)p, "warp fps");
                return;
            }
            if (e.getCurrentItem().getType() == Material.EYE_OF_ENDER) {
                e.setCancelled(true);
                Bukkit.dispatchCommand((CommandSender)p, "warp main");
                return;
            }
            if (e.getCurrentItem().getType() == Material.ANVIL) {
                e.setCancelled(true);
                Bukkit.dispatchCommand((CommandSender)p, "dono");
                return;
            }
            if (e.getCurrentItem().getType() == Material.GLOWSTONE) {
                e.setCancelled(true);
                Bukkit.dispatchCommand((CommandSender)p, "warp bolota");
                return;
            }
            if (e.getCurrentItem().getType() == Material.POTION) {
                e.setCancelled(true);
                Bukkit.dispatchCommand((CommandSender)p, "warp potionpvp");
                return;
            }
            if (e.getCurrentItem().getType() == Material.DRAGON_EGG) {
                e.setCancelled(true);
                Bukkit.dispatchCommand((CommandSender)p, "warp spawn");
            }
            if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
                e.setCancelled(true);
                Bukkit.dispatchCommand((CommandSender)p, "1v1");
            }
        }
    }
}
