package pvp.blatantmc.kits;

import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.plugin.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;
import org.bukkit.event.entity.*;
import org.bukkit.potion.*;

import pvp.blatantmc.main.*;
import pvp.blatantmc.sistemas.*;

public class Infernor implements Listener
{
    public static ArrayList<String> gladinfernor;
    public boolean generateGLASS;
    public HashMap<String, Location> oldl;
    public static HashMap<String, String> lutando;
    public HashMap<Integer, ArrayList<Location>> blocks;
    public HashMap<Player, Location> localizacao;
    public HashMap<Location, Block> bloco;
    public HashMap<Integer, String[]> players;
    public HashMap<String, Integer> tasks;
    int nextID;
    public int id1;
    public int id2;
    
    static {
        Infernor.gladinfernor = new ArrayList<String>();
        Infernor.lutando = new HashMap<String, String>();
    }
    
    public Infernor() {
        this.generateGLASS = true;
        this.oldl = new HashMap<String, Location>();
        this.blocks = new HashMap<Integer, ArrayList<Location>>();
        this.localizacao = new HashMap<Player, Location>();
        this.bloco = new HashMap<Location, Block>();
        this.players = new HashMap<Integer, String[]>();
        this.tasks = new HashMap<String, Integer>();
        this.nextID = 0;
    }
    
    @EventHandler
    public void aoComando(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        if (Infernor.lutando.containsKey(p.getName()) && e.getMessage().startsWith("/")) {
            e.setCancelled(true);
            p.sendMessage("�c�lINFERNOR �fVoc� n�o pode usar comandos enquanto est� em um INFERNOR!");
        }
    }
    
    @EventHandler
    public void aoInfernor(final PlayerInteractEntityEvent event) {
        final Player p = event.getPlayer();
        if (event.getRightClicked() instanceof Player) {
            final Player r = (Player)event.getRightClicked();
            if (p.getItemInHand().getType() == Material.NETHER_FENCE && Hability.getAbility(p).equalsIgnoreCase("Infernor")) {
                final Location loc = new Location(p.getWorld(), (double)p.getLocation().getBlockX(), (double)(p.getLocation().getBlockY() + 70), (double)p.getLocation().getBlockZ());
                this.localizacao.put(p, loc);
                this.localizacao.put(r, loc);
                final Location loc2 = new Location(p.getWorld(), (double)(p.getLocation().getBlockX() - 5), (double)(p.getLocation().getBlockY() + 70), (double)(p.getLocation().getBlockZ() - 5));
                final Location loc3 = new Location(p.getWorld(), (double)(p.getLocation().getBlockX() + 6), (double)(p.getLocation().getBlockY() + 70), (double)(p.getLocation().getBlockZ() + 6));
                if (Gladiator.lutando.containsKey(p.getName()) || Gladiator.lutando.containsKey(r.getName()) || Infernor.lutando.containsKey(p.getName()) || Infernor.lutando.containsKey(r.getName())) {
                    event.setCancelled(true);
                    p.sendMessage("�c�lINFERNOR �fVoc� j� est� em combate!");
                    return;
                }
                final Integer currentID = this.nextID;
                ++this.nextID;
                final ArrayList<String> list = new ArrayList<String>();
                list.add(p.getName());
                list.add(r.getName());
                this.players.put(currentID, list.toArray(new String[1]));
                this.oldl.put(p.getName(), p.getLocation());
                this.oldl.put(r.getName(), r.getLocation());
                if (this.generateGLASS) {
                    final List<Location> cuboid = new ArrayList<Location>();
                    cuboid.clear();
                    for (int bX = -8; bX <= 8; ++bX) {
                        for (int bZ = -8; bZ <= 8; ++bZ) {
                            for (int bY = -1; bY <= 4; ++bY) {
                                final Block b = loc.clone().add((double)bX, (double)bY, (double)bZ).getBlock();
                                if (!b.isEmpty()) {
                                    event.setCancelled(true);
                                    p.sendMessage("�c�lINFERNOR �fVoc� n�o pode criar uma arena infernor neste local!");
                                    return;
                                }
                                if (bY == 4) {
                                    cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                                }
                                else if (bY == -1) {
                                    cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                                }
                                else if (bX == -8 || bZ == -8 || bX == 8 || bZ == 8) {
                                    cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                                }
                            }
                        }
                    }
                    for (final Location loc4 : cuboid) {
                        loc4.getBlock().setType(Material.STAINED_GLASS);
                        loc4.getBlock().setData(DyeColor.RED.getData());
                        this.bloco.put(loc4, loc4.getBlock());
                    }
                    loc2.setYaw(-75.0f);
                    p.teleport(loc2);
                    loc3.setYaw(75.0f);
                    r.teleport(loc3);
                    ApiManager.darEfeito(p, PotionEffectType.DAMAGE_RESISTANCE, 5, 5);
                    ApiManager.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 16, 1);
                    ApiManager.darEfeito(r, PotionEffectType.DAMAGE_RESISTANCE, 5, 5);
                    p.sendMessage("�a�lINFERNOR �fVoc� desafiou um jogador!");
                    p.sendMessage("�6�lINVENCIBILIDADE �fVoc� ganhou 5 segundos de invencibilidade!");
                    p.sendMessage("�e�lINFERNOR �fCaso n�o tenha nenhum vencedor depois de 4 minutos, voc� voltara ao seu local de origem!");
                    r.sendMessage("�3�lINFERNOR �fVoc� foi desafiado!");
                    r.sendMessage("�6�lINVENCIBILIDADE �fVoc� ganhou 5 segundos de invencibilidade!)");
                    r.sendMessage("�e�lINFERNOR �fCaso n�o tenha nenhum vencedor depois de 4 minutos, voc� voltara ao seu local de origem!");
                    Infernor.lutando.put(p.getName(), r.getName());
                    Infernor.lutando.put(r.getName(), p.getName());
                    Infernor.gladinfernor.add(p.getName());
                    Infernor.gladinfernor.add(r.getName());
                    this.id2 = Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (Infernor.lutando.containsKey(p.getName()) && Infernor.lutando.get(p.getName()).equalsIgnoreCase(r.getName()) && Infernor.lutando.containsKey(r.getName()) && Infernor.lutando.get(r.getName()).equalsIgnoreCase(p.getName())) {
                                p.setFireTicks(9999999);
                                r.setFireTicks(9999999);
                            }
                        }
                    }, 2400L);
                    this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (Infernor.lutando.containsKey(p.getName()) && Infernor.lutando.get(p.getName()).equalsIgnoreCase(r.getName()) && Infernor.lutando.containsKey(r.getName()) && Infernor.lutando.get(r.getName()).equalsIgnoreCase(p.getName())) {
                                Infernor.lutando.remove(p.getName());
                                Infernor.lutando.remove(r.getName());
                                Infernor.gladinfernor.remove(p.getName());
                                Infernor.gladinfernor.remove(r.getName());
                                p.teleport((Location)Infernor.this.oldl.get(p.getName()));
                                r.teleport((Location)Infernor.this.oldl.get(r.getName()));
                                Infernor.this.oldl.remove(p.getName());
                                Infernor.this.oldl.remove(r.getName());
                                p.sendMessage("�c�lINFERNOR �fN�o houve nenhum vencedor, voc� foi teleportado para o seu lugar de origem!");
                                r.sendMessage("�c�lINFERNOR �fN�o houve nenhum vencedor, voc� foi teleportado para o seu lugar de origem!");
                                r.setFireTicks(0);
                                p.setFireTicks(0);
                                final Location loc = Infernor.this.localizacao.get(p);
                                final List<Location> cuboid = new ArrayList<Location>();
                                for (int bX = -8; bX <= 8; ++bX) {
                                    for (int bZ = -8; bZ <= 8; ++bZ) {
                                        for (int bY = -1; bY <= 4; ++bY) {
                                            if (bY == 4) {
                                                cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                                            }
                                            else if (bY == -1) {
                                                cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                                            }
                                            else if (bX == -8 || bZ == -8 || bX == 8 || bZ == 8) {
                                                cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                                            }
                                        }
                                    }
                                }
                                for (final Location loc2 : cuboid) {
                                    loc2.getBlock().setType(Material.AIR);
                                    Infernor.this.bloco.get(loc2).setType(Material.AIR);
                                }
                            }
                        }
                    }, 4800L);
                }
            }
        }
    }
    
    @EventHandler
    public void onPlayerInteractGlad(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.NETHER_FENCE && Hability.getAbility(p).equalsIgnoreCase("Infernor")) {
            e.setCancelled(true);
            p.updateInventory();
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlyaerInteract(final PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.STAINED_GLASS && e.getClickedBlock().getData() == DyeColor.RED.getData() && e.getPlayer().getGameMode() != GameMode.CREATIVE && Infernor.lutando.containsKey(e.getPlayer().getName())) {
            e.setCancelled(true);
            e.getClickedBlock().setType(Material.BEDROCK);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    if (Infernor.lutando.containsKey(e.getPlayer().getName())) {
                        e.getClickedBlock().setType(Material.STAINED_GLASS);
                        e.getClickedBlock().setData(DyeColor.RED.getData());
                    }
                }
            }, 30L);
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockBreak(final BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.STAINED_GLASS && e.getPlayer().getGameMode() != GameMode.CREATIVE && Infernor.lutando.containsKey(e.getPlayer().getName())) {
            e.setCancelled(true);
            e.getBlock().setType(Material.BEDROCK);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    if (e.getPlayer().getGameMode() != GameMode.CREATIVE && Infernor.lutando.containsKey(e.getPlayer().getName())) {
                        e.getBlock().setType(Material.STAINED_GLASS);
                        e.getBlock().setData(DyeColor.RED.getData());
                    }
                }
            }, 30L);
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlyaerInteract2(final PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.NETHERRACK && e.getPlayer().getGameMode() != GameMode.CREATIVE && Infernor.lutando.containsKey(e.getPlayer().getName())) {
            e.setCancelled(true);
            e.getClickedBlock().setType(Material.BEDROCK);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    if (Infernor.lutando.containsKey(e.getPlayer().getName())) {
                        e.getClickedBlock().setType(Material.STAINED_GLASS);
                        e.getClickedBlock().setData(DyeColor.RED.getData());
                    }
                }
            }, 30L);
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockBreak2(final BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.NETHERRACK && e.getPlayer().getGameMode() != GameMode.CREATIVE && Infernor.lutando.containsKey(e.getPlayer().getName())) {
            e.setCancelled(true);
            e.getBlock().setType(Material.BEDROCK);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    if (e.getPlayer().getGameMode() != GameMode.CREATIVE && Infernor.lutando.containsKey(e.getPlayer().getName())) {
                        e.getBlock().setType(Material.STAINED_GLASS);
                        e.getBlock().setData(DyeColor.RED.getData());
                    }
                }
            }, 30L);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLeft(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (Infernor.lutando.containsKey(p.getName())) {
            final Player t = Bukkit.getServer().getPlayer((String)Infernor.lutando.get(p.getName()));
            Infernor.lutando.remove(t.getName());
            Infernor.lutando.remove(p.getName());
            Infernor.gladinfernor.remove(p.getName());
            Infernor.gladinfernor.remove(t.getName());
            final Location old = this.oldl.get(t.getName());
            t.teleport(old);
            t.sendMessage("�c�lINFERNOR �fO jogador �c" + p.getName() + " �fdeslogou no infernor!");
            Bukkit.getScheduler().cancelTask(this.id1);
            Bukkit.getScheduler().cancelTask(this.id2);
            t.setFireTicks(0);
            p.setFireTicks(0);
            final Location loc = this.localizacao.get(p);
            final List<Location> cuboid = new ArrayList<Location>();
            for (int bX = -8; bX <= 8; ++bX) {
                for (int bZ = -8; bZ <= 8; ++bZ) {
                    for (int bY = -1; bY <= 4; ++bY) {
                        if (bY == 4) {
                            cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                        }
                        else if (bY == -1) {
                            cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                        }
                        else if (bX == -8 || bZ == -8 || bX == 8 || bZ == 8) {
                            cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                        }
                    }
                }
            }
            for (final Location loc2 : cuboid) {
                loc2.getBlock().setType(Material.AIR);
                this.bloco.get(loc2).setType(Material.AIR);
            }
            for (final Location loc2 : cuboid) {
                loc2.getBlock().setType(Material.AIR);
                this.bloco.get(loc2).setType(Material.AIR);
            }
            for (final Location loc2 : cuboid) {
                loc2.getBlock().setType(Material.AIR);
                this.bloco.get(loc2).setType(Material.AIR);
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDeathInfernor(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        if (Infernor.lutando.containsKey(p.getName())) {
            final Player k = Bukkit.getServer().getPlayer((String)Infernor.lutando.get(p.getName()));
            final Location old = this.oldl.get(p.getName());
            k.teleport(old);
            k.sendMessage("�a�lINFERNOR �fVoc� ganhou a batalha contra o jogador �a" + p.getName());
            Bukkit.getScheduler().cancelTask(this.id1);
            Bukkit.getScheduler().cancelTask(this.id2);
            k.setFireTicks(0);
            p.setFireTicks(0);
            k.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
            Infernor.lutando.remove(k.getName());
            Infernor.lutando.remove(p.getName());
            Infernor.gladinfernor.remove(p.getName());
            Infernor.gladinfernor.remove(k.getName());
            final Location loc = this.localizacao.get(p);
            final List<Location> cuboid = new ArrayList<Location>();
            cuboid.clear();
            for (int bX = -8; bX <= 8; ++bX) {
                for (int bZ = -8; bZ <= 8; ++bZ) {
                    for (int bY = -1; bY <= 4; ++bY) {
                        if (bY == 4) {
                            cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                        }
                        else if (bY == -1) {
                            cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                        }
                        else if (bX == -8 || bZ == -8 || bX == 8 || bZ == 8) {
                            cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                        }
                    }
                }
            }
            for (final Location loc2 : cuboid) {
                loc2.getBlock().setType(Material.AIR);
                if (this.bloco.containsKey(loc2)) {
                    this.bloco.get(loc2).setType(Material.AIR);
                }
            }
        }
    }
}
