package pvp.blatantmc.guis;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiKits implements Listener
{
    public static ArrayList<String> emarray;
    public static ArrayList<String> emarray1;
    
    static {
        GuiKits.emarray = new ArrayList<String>();
        GuiKits.emarray1 = new ArrayList<String>();
    }
    
    public static void GuiKit(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 54, "§aKits");
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
        carpetm.setDisplayName("§aProxima Pagina");
        carpet.setItemMeta(carpetm);
        inv.setItem(0, vidro);
        inv.setItem(1, vidro);
        inv.setItem(2, vidro);
        inv.setItem(3, vidro);
        inv.setItem(4, vidro);
        inv.setItem(5, vidro);
        inv.setItem(6, vidro);
        inv.setItem(7, vidro);
        inv.setItem(8, carpet);
        if (p.hasPermission("kit.pvp")) {
            final ItemStack pyro = new ItemStack(Material.STONE_SWORD);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fPvP");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.jumper")) {
            final ItemStack pyro = new ItemStack(Material.FIREWORK_CHARGE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fJumper");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.shooter")) {
            final ItemStack pyro = new ItemStack(Material.BONE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fShooter");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.timelord")) {
            final ItemStack pyro = new ItemStack(Material.WATCH);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fTimeLord");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.jellyfish")) {
            final ItemStack pyro = new ItemStack(Material.CLAY_BALL);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fJellyFish");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.fisherman")) {
            final ItemStack pyro = new ItemStack(Material.FISHING_ROD);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fFisherman");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.magma")) {
            final ItemStack pyro = new ItemStack(Material.LAVA_BUCKET);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fMagma");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.gladiator")) {
            final ItemStack pyro = new ItemStack(Material.IRON_FENCE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fGladiator");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.hotpotato")) {
            final ItemStack pyro = new ItemStack(Material.BAKED_POTATO);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fHotpotato");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.forcefield")) {
            final ItemStack pyro = new ItemStack(Material.IRON_FENCE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fForce-Field");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.avatar")) {
            final ItemStack pyro = new ItemStack(Material.BEACON);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fAvatar");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.kangaroo")) {
            final ItemStack pyro = new ItemStack(Material.FIREWORK);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fKangaroo");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.monk")) {
            final ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fMonk");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.stomper")) {
            final ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§7Kit §a§lKIT §fStomper");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.thor")) {
            final ItemStack pyro = new ItemStack(Material.GOLD_AXE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fThor");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.quickdropper")) {
            final ItemStack pyro = new ItemStack(Material.BOWL);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fQuickDropper");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.gaara")) {
            final ItemStack pyro = new ItemStack(Material.SAND);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fGaara");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.infernor")) {
            final ItemStack pyro = new ItemStack(Material.NETHER_FENCE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fInfernor");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.poseidon")) {
            final ItemStack pyro = new ItemStack(Material.WATER_BUCKET);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fPoseidon");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.phantom")) {
            final ItemStack pyro = new ItemStack(Material.FEATHER);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fPhantom");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.viking")) {
            final ItemStack pyro = new ItemStack(Material.STONE_AXE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fViking");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.terrorista")) {
            final ItemStack pyro = new ItemStack(Material.TNT);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fTerrorista");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.flash")) {
            final ItemStack pyro = new ItemStack(Material.REDSTONE_TORCH_ON);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fFlash");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.vacuum")) {
            final ItemStack pyro = new ItemStack(Material.EYE_OF_ENDER);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fVacuum");
            final ArrayList<String> descpyro = new ArrayList<String>();
            metapyro.setLore((List)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.turtle")) {
            final ItemStack pyro = new ItemStack(Material.DIAMOND_CHESTPLATE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§a§lKIT §fTurtle");
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
        if (e.getInventory().getTitle().equalsIgnoreCase("§aKits") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.CARPET) {
                e.setCancelled(true);
                GuiKits2.GuiKit2(p);
                return;
            }
            if (e.getCurrentItem().getType() == Material.STONE_SWORD) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit pvp");
                return;
            }
            if (e.getCurrentItem().getType() == Material.FIREWORK_CHARGE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit jumper");
                return;
            }
            if (e.getCurrentItem().getType() == Material.BONE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit shooter");
                return;
            }
            if (e.getCurrentItem().getType() == Material.WATCH) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit timelord");
                return;
            }
            if (e.getCurrentItem().getType() == Material.CLAY_BALL) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit jellyfish");
                return;
            }
            if (e.getCurrentItem().getType() == Material.ANVIL) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit anchor");
                return;
            }
            if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit fisherman");
                return;
            }
            if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit magma");
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lKIT §fGladiator")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit gladiator");
                return;
            }
            if (e.getCurrentItem().getType() == Material.BAKED_POTATO) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit hotpotato");
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lKIT §fForce-Field")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit forcefield");
                return;
            }
            if (e.getCurrentItem().getType() == Material.BEACON) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit avatar");
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lKIT §fKangaroo")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit kangaroo");
                return;
            }
            if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit monk");
                return;
            }
            if (e.getCurrentItem().getType() == Material.IRON_BOOTS) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit stomper");
                return;
            }
            if (e.getCurrentItem().getType() == Material.GOLD_AXE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit thor");
                return;
            }
            if (e.getCurrentItem().getType() == Material.BOWL) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit quickdropper");
                return;
            }
            if (e.getCurrentItem().getType() == Material.SAND) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit gaara");
                return;
            }
            if (e.getCurrentItem().getType() == Material.NETHER_FENCE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit infernor");
                return;
            }
            if (e.getCurrentItem().getType() == Material.WATER_BUCKET) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit poseidon");
                return;
            }
            if (e.getCurrentItem().getType() == Material.FEATHER) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit phantom");
                return;
            }
            if (e.getCurrentItem().getType() == Material.STONE_AXE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit viking");
                return;
            }
            if (e.getCurrentItem().getType() == Material.TNT) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit terrorista");
                return;
            }
            if (e.getCurrentItem().getType() == Material.REDSTONE_TORCH_ON) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit flash");
                return;
            }
            if (e.getCurrentItem().getType() == Material.EYE_OF_ENDER) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit vacuum");
                return;
            }
            if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit turtle");
                return;
            }
        }
    }
}
