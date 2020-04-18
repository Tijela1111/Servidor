package pvp.blatantmc.guis;

import org.bukkit.entity.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import pvp.blatantmc.sistemas.*;

import org.bukkit.event.inventory.*;
import org.bukkit.event.*;

public class GuiLoja implements Listener
{
    public static String semxp;
    
    static {
        GuiLoja.semxp = String.valueOf("§c§lXP §fVocê não tem xp suficiente.");
    }
    
    public static void GuiLojaKit(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "§aLoja De Kits");
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
        if (!p.hasPermission("kit.gaara")) {
            final ItemStack gaara = new ItemStack(Material.SAND);
            final ItemMeta gaaram = gaara.getItemMeta();
            gaaram.setDisplayName("§a§lKIT §fGaara");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§fPreço: §a15.000XP");
            desc.add("§7Prenda os jogadores em uma caixa de areia!");
            gaaram.setLore((List)desc);
            gaara.setItemMeta(gaaram);
            inv.setItem(9, gaara);
        }
        else if (p.hasPermission("kit.gaara")) {
            final ItemStack gaara = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta gaaram = gaara.getItemMeta();
            gaaram.setDisplayName("§c§lKIT §fGaara");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVocê já possui este kit!");
            gaaram.setLore((List)desc);
            gaara.setItemMeta(gaaram);
            inv.setItem(9, gaara);
        }
        inv.setItem(10, vidro);
        if (!p.hasPermission("kit.magma")) {
            final ItemStack magma = new ItemStack(Material.LAVA_BUCKET);
            final ItemMeta magmam = magma.getItemMeta();
            magmam.setDisplayName("§a§lKIT §fMagma");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§fPreço: §a10.000XP");
            desc.add("§7Coloque fogos nos jogadores, e seja imune a lava.");
            magmam.setLore((List)desc);
            magma.setItemMeta(magmam);
            inv.setItem(11, magma);
        }
        else if (p.hasPermission("kit.magma")) {
            final ItemStack magma = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta magmam = magma.getItemMeta();
            magmam.setDisplayName("§c§lKIT §fMagma");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVocê já possui este kit!");
            magmam.setLore((List)desc);
            magma.setItemMeta(magmam);
            inv.setItem(11, magma);
        }
        inv.setItem(12, vidro);
        if (!p.hasPermission("kit.avatar")) {
            final ItemStack avatar = new ItemStack(Material.BEACON);
            final ItemMeta avatarm = avatar.getItemMeta();
            avatarm.setDisplayName("§a§lKIT §fAvatar");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§fPreço: §a15.000XP");
            desc.add("§7Domine os 4 elementos!");
            avatarm.setLore((List)desc);
            avatar.setItemMeta(avatarm);
            inv.setItem(13, avatar);
        }
        else if (p.hasPermission("kit.avatar")) {
            final ItemStack avatar = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta avatarm = avatar.getItemMeta();
            avatarm.setDisplayName("§c§lKIT §fAvatar");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVocê já possui este kit!");
            avatarm.setLore((List)desc);
            avatar.setItemMeta(avatarm);
            inv.setItem(13, avatar);
        }
        inv.setItem(14, vidro);
        if (!p.hasPermission("kit.shooter")) {
            final ItemStack shooter = new ItemStack(Material.BONE);
            final ItemMeta shooterm = shooter.getItemMeta();
            shooterm.setDisplayName("§a§lKIT §fShooter");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§fPreço: §a13.000XP");
            desc.add("§7De muito dano no player com uma flechada!");
            shooterm.setLore((List)desc);
            shooter.setItemMeta(shooterm);
            inv.setItem(15, shooter);
        }
        else if (p.hasPermission("kit.shooter")) {
            final ItemStack shooter = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta shooterm = shooter.getItemMeta();
            shooterm.setDisplayName("§c§lKIT §fShooter");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVocê já possui este kit!");
            shooterm.setLore((List)desc);
            shooter.setItemMeta(shooterm);
            inv.setItem(15, shooter);
        }
        inv.setItem(16, vidro);
        if (!p.hasPermission("kit.hotpotato")) {
            final ItemStack hotpotato = new ItemStack(Material.BAKED_POTATO);
            final ItemMeta hotpotatom = hotpotato.getItemMeta();
            hotpotatom.setDisplayName("§a§lKIT §fHotPotato");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§fPreço: §a20.000XP");
            desc.add("§7Exploda a cabeça dos jogadores.");
            hotpotatom.setLore((List)desc);
            hotpotato.setItemMeta(hotpotatom);
            inv.setItem(17, hotpotato);
        }
        else if (p.hasPermission("kit.hotpotato")) {
            final ItemStack hotpotato = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta hotpotatom = hotpotato.getItemMeta();
            hotpotatom.setDisplayName("§c§lKIT §fHotPotato");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVocê já possui este kit!");
            hotpotatom.setLore((List)desc);
            hotpotato.setItemMeta(hotpotatom);
            inv.setItem(17, hotpotato);
        }
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
    public void inventarioKit(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§aLoja De Kits") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                e.setCancelled(true);
                return;
            }
            ApiManager.venderItem(e, p, Material.SAND, 15000, "§a§lLOJA DE KITS §fVocê comprou o kit §aGaara", "kit.gaara");
            ApiManager.venderItem(e, p, Material.LAVA_BUCKET, 10000, "§a§lLOJA DE KITS §fVocê comprou o kit §aMagma", "kit.magma");
            ApiManager.venderItem(e, p, Material.BEACON, 15000, "§a§lLOJA DE KITS §fVocê comprou o kit §aAvatar", "kit.avatar");
            ApiManager.venderItem(e, p, Material.BONE, 13000, "§a§lLOJA DE KITS §fVocê comprou o kit §aShooter", "kit.shooter");
            ApiManager.venderItem(e, p, Material.BAKED_POTATO, 20000, "§a§lLOJA DE KITS §fVocê comprou o kit §aHotPotato", "kit.hotpotato");
        }
    }
    
    public static void GuiLojaCaixa(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§aLoja De Caixas");
        ApiManager.darItemInv(inv, Material.STAINED_GLASS_PANE, 1, 15, "", 0);
        ApiManager.darItemInvDesc(inv, Material.CHEST, 1, 0, "§fQuantidade §a1", "§fPreço §a1000Xp", 1);
        ApiManager.darItemInv(inv, Material.STAINED_GLASS_PANE, 1, 15, "", 2);
        ApiManager.darItemInv(inv, Material.STAINED_GLASS_PANE, 1, 15, "", 3);
        ApiManager.darItemInvDesc(inv, Material.CHEST, 1, 0, "§fQuantidade §a10", "§fPreço §a10.000Xp", 4);
        ApiManager.darItemInv(inv, Material.STAINED_GLASS_PANE, 1, 15, "", 5);
        ApiManager.darItemInv(inv, Material.STAINED_GLASS_PANE, 1, 15, "", 6);
        ApiManager.darItemInvDesc(inv, Material.CHEST, 1, 0, "§fQuantidade §a50", "§fPreço §a50.000Xp", 7);
        ApiManager.darItemInv(inv, Material.STAINED_GLASS_PANE, 1, 15, "", 8);
        p.openInventory(inv);
    }
    
    @EventHandler
    public void inventariocaixa(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§aLoja De Caixas") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                e.setCancelled(true);
                return;
            }
            ApiManager.venderCaixa(e, p, "§fQuantidade §a1", 1000, "§a§lCAIXA §fVocê comprou §a1 Caixa!", 1);
            ApiManager.venderCaixa(e, p, "§fQuantidade §a10", 10000, "§a§lCAIXA §fVocê comprou §a10 Caixas!", 10);
            ApiManager.venderCaixa(e, p, "§fQuantidade §a50", 50000, "§a§lCAIXA §fVocê comprou §a50 Caixas!", 50);
        }
    }
    
    public static void GuiLojas(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "§aLojas");
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
        inv.setItem(10, vidro);
        ApiManager.darItemInv(inv, Material.DIAMOND, 1, 0, "§aDiscord do servidor", 11);
        inv.setItem(12, vidro);
        ApiManager.darItemInv(inv, Material.GOLD_INGOT, 1, 0, "§aLoja de Caixas", 13);
        inv.setItem(14, vidro);
        ApiManager.darItemInv(inv, Material.EMERALD, 1, 0, "§aLoja de Kits", 15);
        inv.setItem(16, vidro);
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
    public void inventarioLoja(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§aLojas") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.DIAMOND) {
                e.setCancelled(true);
                p.chat("/discord");
                p.closeInventory();
                return;
            }
            if (e.getCurrentItem().getType() == Material.EMERALD) {
                e.setCancelled(true);
                GuiLojaKit(p);
                return;
            }
            if (e.getCurrentItem().getType() == Material.GOLD_INGOT) {
                e.setCancelled(true);
                GuiLojaCaixa(p);
            }
        }
    }
}
