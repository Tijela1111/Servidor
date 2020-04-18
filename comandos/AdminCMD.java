package pvp.blatantmc.comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import com.connorlinfoot.titleapi.TitleAPI;

import pvp.blatantmc.main.Main;
import pvp.blatantmc.sistemas.ApiManager;
import pvp.blatantmc.sistemas.KillsDeathsRankXp;

public class AdminCMD implements CommandExecutor, Listener
{
    public static ArrayList<Player> emAdmin;
    public static HashMap<String, ItemStack[]> salvarinv;
    public static HashMap<String, ItemStack[]> salrvararmor;
    public static HashMap<String, ItemStack[]> salvarinventarioautosoup;
    public static ArrayList<String> aotestarautosoup;
    
    public static ArrayList<String> hacks = new ArrayList<>();
    
    static {
        AdminCMD.emAdmin = new ArrayList<Player>();
        AdminCMD.salvarinv = new HashMap<String, ItemStack[]>();
        AdminCMD.salrvararmor = new HashMap<String, ItemStack[]>();
        AdminCMD.salvarinventarioautosoup = new HashMap<String, ItemStack[]>();
        AdminCMD.aotestarautosoup = new ArrayList<String>();
    }
    
    @SuppressWarnings("deprecation")
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("admin")) {
            if (p.hasPermission("simulator.admin")) {
                if (!AdminCMD.emAdmin.contains(p)) {
                    AdminCMD.emAdmin.add(p);
                    AdminCMD.salvarinv.put(p.getName(), p.getInventory().getContents());
                    AdminCMD.salrvararmor.put(p.getName(), p.getInventory().getArmorContents());
                    p.getInventory().clear();
                    p.sendMessage("§a§lADMIN §fVocê entrou no modo admin!");
                    p.setHealth(20.0);
                    p.setFireTicks(0);
                    p.setGameMode(GameMode.CREATIVE);
                    TitleAPI.sendFullTitle(p, 50, 50, 80, "§cAdmin", "§2§lON");
                    ApiManager.darItem(p, Material.ENDER_PEARL, 1, "§aTroca rápida", 0);
                    ApiManager.darItem(p, Material.MUSHROOM_SOUP, 1, "§aAuto-Soup", 4);
                    ApiManager.darItem(p, Material.REDSTONE, 1, "§cSair Do Admin", 8);
                    p.updateInventory();
                    Player[] onlinePlayers;
                    for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                        final Player todos = onlinePlayers[i];
                        todos.hidePlayer(p);
                    }
                }
                else {
                    AdminCMD.emAdmin.remove(p);
                    p.getInventory().clear();
                    p.getInventory().setContents((ItemStack[])AdminCMD.salvarinv.get(p.getName()));
                    p.getInventory().setArmorContents((ItemStack[])AdminCMD.salrvararmor.get(p.getName()));
                    p.updateInventory();
                    p.setHealth(20.0);
                    p.setFireTicks(0);
                    p.setGameMode(GameMode.SURVIVAL);
                    TitleAPI.sendFullTitle(p, 50, 50, 80, "§cAdmin", "§4§lOFF");
                    p.sendMessage("§c§lADMIN §fVocê saiu do modo admin!");
                    Player[] onlinePlayers2;
                    for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
                        final Player todos = onlinePlayers2[j];
                        todos.showPlayer(p);
                    }
                }
            }
            else {
                p.sendMessage(ApiManager.semperm);
            }
        }
        return false;
    }
    
    @EventHandler
    public void oaSair(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (AdminCMD.emAdmin.contains(p)) {
            AdminCMD.emAdmin.remove(p);
        }
    }
    
    @EventHandler
    public void aoInfoPlayer(final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) {
            return;
        }
        final Player p = e.getPlayer();
        final Player t = (Player)e.getRightClicked();
        if (AdminCMD.emAdmin.contains(p) && p.getInventory().getItemInHand().getType() == Material.PAPER) {
            final Damageable hp = (Damageable)t;
            p.sendMessage("§7Informa\u00e7\u00f5es Do Player: §b" + t.getDisplayName());
            p.sendMessage("§7Vida: §b" + (int)hp.getHealth());
            p.sendMessage("§7Kit: §b" + ApiManager.getKit(t));
            p.sendMessage("§7Sopas: §b" + ApiManager.getItemNoInv(t, Material.MUSHROOM_SOUP));
            p.sendMessage("§7Matou: §b" + KillsDeathsRankXp.getKills(t));
            p.sendMessage("§7Morreu: §b" + KillsDeathsRankXp.getDeaths(t));
            p.sendMessage("§7XP: §b" + KillsDeathsRankXp.getXp(t));
            p.sendMessage("§7IP: §b" + t.getAddress().getHostString());
        }
    }
    
    @EventHandler
    public void oaTrocar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (AdminCMD.emAdmin.contains(p) && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.ENDER_PEARL) {
            e.setCancelled(true);
            final BukkitScheduler scheduler = Bukkit.getScheduler();
            scheduler.scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.chat("/admin");
                }
            }, 0L);
            scheduler.scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.chat("/admin");
                }
            }, 15L);
        }
    }
    
    @EventHandler
    public void aoAutoSoup(final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) {
            return;
        }
        final Player p = e.getPlayer();
        final Player t = (Player)e.getRightClicked();
        if (AdminCMD.emAdmin.contains(p) && p.getInventory().getItemInHand().getType() == Material.MUSHROOM_SOUP) {
            if (AdminCMD.aotestarautosoup.contains(p.getName())) {
                p.sendMessage("§c§lAUTOSOUP §fVocê já está testando um player!");
                return;
            }
            AdminCMD.salvarinventarioautosoup.put(t.getName(), t.getInventory().getContents());
            t.getInventory().clear();
            t.setHealth(0.5);
            p.openInventory((Inventory)t.getInventory());
            p.sendMessage("§a§lAUTOSOUP §fVocê está testando o auto-soup do jogador §a" + t.getDisplayName());
            ApiManager.darItem(t, Material.MUSHROOM_SOUP, 1, "§e§lCALCULANDO...", 14);
            ApiManager.darItem(t, Material.MUSHROOM_SOUP, 1, "§e§lCALCULANDO...", 15);
            ApiManager.darItem(t, Material.MUSHROOM_SOUP, 1, "§e§lCALCULANDO...", 16);
            AdminCMD.aotestarautosoup.add(p.getName());
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                	p.sendMessage("§f");
                    p.sendMessage("§a§lRESULTADO");
                    p.sendMessage("§fSopas bebidas: §e" + ApiManager.getItemNoInv(t, Material.BOWL));
                    p.sendMessage("§fSopas não bebidas: §e" + ApiManager.getItemNoInv(t, Material.MUSHROOM_SOUP));
                    p.sendMessage("§f");
                    AdminCMD.aotestarautosoup.remove(p.getName());
                }
            }, 60L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    t.getInventory().setContents((ItemStack[])AdminCMD.salvarinventarioautosoup.get(t.getName()));
                }
            }, 100L);
        }
    }
    
    @EventHandler
    public void aoNofall(final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) {
            return;
        }
        final Player p = e.getPlayer();
        final Player t = (Player)e.getRightClicked();
        if (AdminCMD.emAdmin.contains(p)) {
            if (p.getInventory().getItemInHand().getType() == Material.FEATHER) {
                t.setVelocity(new Vector(0, 2, 0));
            }
            if (p.getInventory().getItemInHand().getType() == Material.AIR) {
                p.openInventory((Inventory)t.getInventory());
            }
        }
    }
    
    @EventHandler
    public void aoSair(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (AdminCMD.emAdmin.contains(p) && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.REDSTONE) {
            p.chat("/admin");
        }
    }
    
    @EventHandler
    public void onCage(final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) {
            return;
        }
        final Player p = e.getPlayer();
        final Player t = (Player)e.getRightClicked();
        
        if (AdminCMD.emAdmin.contains(p) && p.getItemInHand().getType() == Material.BEDROCK) {
            t.getLocation().add(0.0, 13.0, 0.0).getBlock().setType(Material.BEDROCK);
            t.getLocation().add(0.0, 11.0, 1.0).getBlock().setType(Material.BEDROCK);
            t.getLocation().add(1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
            t.getLocation().add(0.0, 11.0, -1.0).getBlock().setType(Material.BEDROCK);
            t.getLocation().add(-1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
            t.getLocation().add(0.0, 10.0, 0.0).getBlock().setType(Material.BEDROCK);
            t.teleport(t.getLocation().add(0.0, 11.0, -0.07));
            p.teleport(t.getLocation().add(3.0, 0.0, 0.05));
            hacks.add(t.getName());
             p.sendMessage("§aVocê prendeu o jogador: §f" + t.getName() + " §aEle Não conseguira mais usar comandos ate você o liberar usando: §f/uncage " + t.getName());
             t.sendMessage("§cO Staff: §f" + p.getName() + " §cLhe Prendeu Você não ira conseguir executar comandos ate que seja liberado");
        } 
    }
    
    
    @EventHandler
    private void onCommand(PlayerCommandPreprocessEvent e){
    	Player p = e.getPlayer();
    
    	if(hacks.contains(p.getName())){
    		e.setCancelled(true);
    		p.sendMessage("§cVocê esta sendo verificado não pode usar comandos agora.");
    	}
    	
    }
    
   
    
    
}
