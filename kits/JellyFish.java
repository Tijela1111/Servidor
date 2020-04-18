package pvp.blatantmc.kits;

import java.util.*;

import org.bukkit.block.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;
import org.bukkit.potion.*;

import pvp.blatantmc.main.*;
import pvp.blatantmc.sistemas.*;

public class JellyFish implements Listener
{
    ArrayList<Block> naoescorrer;
    public static String naocolocaragua;
    
    static {
        JellyFish.naocolocaragua = String.valueOf("§c§lJELLYFISH §fVocê não pode colocar água neste local!");
    }
    
    public JellyFish() {
        this.naoescorrer = new ArrayList<Block>();
    }
    
    @EventHandler
    public void colocaragua(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (Hability.getAbility(p).equalsIgnoreCase("JellyFish") && p.getItemInHand().getType() == Material.AIR && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            final Block b = event.getClickedBlock();
            final BlockFace lado = event.getBlockFace();
            final int x = b.getLocation().getBlockX();
            final int y = b.getLocation().getBlockY();
            final int z = b.getLocation().getBlockZ();
            if (lado == BlockFace.DOWN) {
                final Block b2 = b.getWorld().getBlockAt(x, y - 1, z);
                if (b2.getType() == Material.AIR) {
                    b2.setType(Material.STATIONARY_WATER);
                    this.naoescorrer.add(b2);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            b2.setType(Material.AIR);
                            JellyFish.this.naoescorrer.remove(b2);
                        }
                    }, 60L);
                }
                else {
                    p.sendMessage(JellyFish.naocolocaragua);
                }
            }
            else if (lado == BlockFace.UP) {
                final Block b2 = b.getWorld().getBlockAt(x, y + 1, z);
                if (b2.getType() == Material.AIR) {
                    b2.setType(Material.STATIONARY_WATER);
                    this.naoescorrer.add(b2);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            b2.setType(Material.AIR);
                            JellyFish.this.naoescorrer.remove(b2);
                        }
                    }, 60L);
                }
                else {
                    p.sendMessage(JellyFish.naocolocaragua);
                }
            }
            else if (lado == BlockFace.NORTH) {
                final Block b2 = b.getWorld().getBlockAt(x, y, z - 1);
                if (b2.getType() == Material.AIR) {
                    b2.setType(Material.STATIONARY_WATER);
                    this.naoescorrer.add(b2);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            b2.setType(Material.AIR);
                            JellyFish.this.naoescorrer.remove(b2);
                        }
                    }, 60L);
                }
                else {
                    p.sendMessage(JellyFish.naocolocaragua);
                }
            }
            else if (lado == BlockFace.SOUTH) {
                final Block b2 = b.getWorld().getBlockAt(x, y, z + 1);
                if (b2.getType() == Material.AIR) {
                    b2.setType(Material.STATIONARY_WATER);
                    this.naoescorrer.add(b2);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            b2.setType(Material.AIR);
                            JellyFish.this.naoescorrer.remove(b2);
                        }
                    }, 60L);
                }
                else {
                    p.sendMessage(JellyFish.naocolocaragua);
                }
            }
            else if (lado == BlockFace.WEST) {
                final Block b2 = b.getWorld().getBlockAt(x - 1, y, z);
                if (b2.getType() == Material.AIR) {
                    b2.setType(Material.STATIONARY_WATER);
                    this.naoescorrer.add(b2);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            b2.setType(Material.AIR);
                            JellyFish.this.naoescorrer.remove(b2);
                        }
                    }, 60L);
                }
                else {
                    p.sendMessage(JellyFish.naocolocaragua);
                }
            }
            else if (lado == BlockFace.EAST) {
                final Block b2 = b.getWorld().getBlockAt(x + 1, y, z);
                if (b2.getType() == Material.AIR) {
                    b2.setType(Material.STATIONARY_WATER);
                    this.naoescorrer.add(b2);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            b2.setType(Material.AIR);
                            JellyFish.this.naoescorrer.remove(b2);
                        }
                    }, 60L);
                }
                else {
                    p.sendMessage(JellyFish.naocolocaragua);
                }
            }
        }
    }
    
    @EventHandler
    public void naoescorrer(final BlockPhysicsEvent event) {
        final Block b = event.getBlock();
        if (b.getType() == Material.STATIONARY_WATER && this.naoescorrer.contains(b)) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void veneno(final PlayerMoveEvent event) {
        final Player p = event.getPlayer();
        final Block b = p.getLocation().getBlock();
        if (b.getType() == Material.STATIONARY_WATER && !p.getInventory().contains(Material.CLAY_BALL) && this.naoescorrer.contains(b)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
        }
    }
}
