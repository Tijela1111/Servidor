package pvp.blatantmc.guis;

import org.bukkit.entity.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.inventory.*;
import org.bukkit.event.*;

public class GuiKits2 implements Listener
{
    public static void GuiKit2(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 54, "§aKits 2");
        final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)1);
        final ItemMeta vidrom = vidro.getItemMeta();
        vidrom.setDisplayName("§7VIDRO");
        vidro.setItemMeta(vidrom);
        final ItemStack vidrov = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)1);
        final ItemMeta vidrovm = vidrov.getItemMeta();
        vidrovm.setDisplayName("§7VIDRO");
        vidrov.setItemMeta(vidrovm);
        final ItemStack vidror = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)1);
        final ItemMeta vidrorm = vidror.getItemMeta();
        vidrorm.setDisplayName("§7VIDRO");
        vidror.setItemMeta(vidrorm);
        final ItemStack vidrob = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)1);
        final ItemMeta vidrobm = vidrob.getItemMeta();
        vidrobm.setDisplayName("§7VIDRO");
        vidrob.setItemMeta(vidrobm);
        final ItemStack carpet = new ItemStack(Material.CARPET, 1);
        final ItemMeta carpetm = carpet.getItemMeta();
        carpetm.setDisplayName("§cPágina anterior");
        carpet.setItemMeta(carpetm);
        inv.setItem(0, carpet);
        inv.setItem(1, vidro);
        inv.setItem(2, vidro);
        inv.setItem(3, vidro);
        inv.setItem(4, vidro);
        inv.setItem(5, vidro);
        inv.setItem(6, vidro);
        inv.setItem(7, vidro);
        inv.setItem(8, vidro);
        if (p.hasPermission("kit.ninja")) {
            final ItemStack pyro = new ItemStack(Material.COMPASS);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fNinja");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        
        if (p.hasPermission("kit.ajnin")) {
            final ItemStack pyro = new ItemStack(Material.NETHER_STAR);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fAjnin");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        
    
        if (p.hasPermission("kit.resouper")) {
            final ItemStack pyro = new ItemStack(Material.MUSHROOM_SOUP);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fResouper");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.pyro")) {
            final ItemStack pyro = new ItemStack(Material.FIREBALL);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fPyro");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.viper")) {
            final ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fViper");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.snail")) {
            final ItemStack pyro = new ItemStack(Material.SOUL_SAND);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fSnail");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.hulk")) {
            final ItemStack pyro = new ItemStack(Material.SADDLE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fHulk");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.reverse")) {
            final ItemStack pyro = new ItemStack(Material.ENDER_CHEST);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fReverse");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        ItemStack[] arrayOfItemStack;
        for (int descpyro2 = (arrayOfItemStack = inv.getContents()).length, metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
            final ItemStack item = arrayOfItemStack[metapyro2];
            if (item == null) {
                inv.setItem(inv.firstEmpty(), vidrob);
            }
        }
        p.openInventory(inv);
    }
    
    @EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§aKits 2") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.CARPET) {
                e.setCancelled(true);
                GuiKits.GuiKit(p);
                return;
            }
            if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit ajnin");
                return;
            }
            if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit resouper");
                return;
            }
            if (e.getCurrentItem().getType() == Material.FIREBALL) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit pyro");
                return;
            }
            if (e.getCurrentItem().getType() == Material.SPIDER_EYE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit viper");
                return;
            }
            if (e.getCurrentItem().getType() == Material.SOUL_SAND) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit snail");
                return;
            }
            if (e.getCurrentItem().getType() == Material.SADDLE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit hulk");
                return;
            }
            if (e.getCurrentItem().getType() == Material.COMPASS) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit ninja");
            }
            if (e.getCurrentItem().getType() == Material.ENDER_CHEST) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit reverse");
            }
        }
    }
}
