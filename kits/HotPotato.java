package pvp.blatantmc.kits;

import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.*;
import org.bukkit.scheduler.*;

import pvp.blatantmc.main.*;
import pvp.blatantmc.sistemas.*;

import org.bukkit.plugin.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.*;

public class HotPotato implements Listener
{
    public static ArrayList<String> emhotpotato;
    
    static {
        HotPotato.emhotpotato = new ArrayList<String>();
    }
    
    @EventHandler
    public void onInteract(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Player) {
            final Player k = (Player)e.getRightClicked();
            if (p.getItemInHand().getType().equals((Object)Material.getMaterial(392)) && Hability.getAbility(p).equalsIgnoreCase("HotPotato")) {
                if (Gladiator.lutando.containsKey(p.getName())) {
                	p.sendMessage("§c§lHOT-POTATO §fVocê não poder usar seu kit no gladiator ou infernor!");
                    p.sendMessage("§a§lEFEITO §fVocê irá ganhar um efeito de força e speed.");
                    ApiManager.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 10, 1);
                    ApiManager.darEfeito(p, PotionEffectType.SPEED, 10, 2);
                }
                else {
                    if (Cooldown.add(p)) {
                        ApiManager.MensagemCooldown(p);
                        return;
                    }
                    Cooldown.add(p, 20);
                    HotPotato.emhotpotato.add(k.getName());
                    p.sendMessage("§a§lHOT-POTATO §fSua dinamite foi colocada!");
                    k.sendMessage("§c§lHOT-POTATO §fVocê está com uma dinamite em sua cabeça!");
                    k.sendMessage("§e§lHOT-POTATO §fAbra seu inventário e tire ela da sua cabeça!");
                    final ItemStack tnt = new ItemStack(Material.TNT);
                    final ItemMeta tntmeta = tnt.getItemMeta();
                    tntmeta.setDisplayName("§cTNT");
                    tnt.setItemMeta(tntmeta);
                    k.getInventory().setHelmet(tnt);
                    new BukkitRunnable() {
                        public void run() {
                            if (HotPotato.emhotpotato.contains(k.getName())) {
                                k.sendMessage("§c§lHOT-POTATO §fA dinamite irá explodir em §c5 segundos!");
                                k.sendMessage("§e§lHOT-POTATO §fAbra seu inventário e tire ela da sua cabeça!");
                            }
                        }
                    }.runTaskLater((Plugin)Main.getInstance(), 0L);
                    new BukkitRunnable() {
                        public void run() {
                            if (HotPotato.emhotpotato.contains(k.getName())) {
                                k.sendMessage("§c§lHOT-POTATO §fA dinamite irá explodir em §c4 segundos!");
                                k.sendMessage("§e§lHOT-POTATO §fAbra seu inventário e tire ela da sua cabeça!");
                            }
                        }
                    }.runTaskLater((Plugin)Main.getInstance(), 20L);
                    new BukkitRunnable() {
                        public void run() {
                            if (HotPotato.emhotpotato.contains(k.getName())) {
                                k.sendMessage("§c§lHOT-POTATO §fA dinamite irá explodir em §c3 segundos!");
                                k.sendMessage("§e§lHOT-POTATO §fAbra seu inventário e tire ela da sua cabeça!");
                            }
                        }
                    }.runTaskLater((Plugin)Main.getInstance(), 40L);
                    new BukkitRunnable() {
                        public void run() {
                            if (HotPotato.emhotpotato.contains(k.getName())) {
                                k.sendMessage("§c§lHOT-POTATO §fA dinamite irá explodir em §c2 segundos!");
                                k.sendMessage("§e§lHOT-POTATO §fAbra seu inventário e tire ela da sua cabeça!");
                            }
                        }
                    }.runTaskLater((Plugin)Main.getInstance(), 60L);
                    new BukkitRunnable() {
                        public void run() {
                            if (HotPotato.emhotpotato.contains(k.getName())) {
                                k.getWorld().createExplosion(k.getLocation(), 3.0f, true);
                                k.getWorld().playEffect(k.getLocation(), Effect.EXPLOSION_HUGE, 20);
                                k.setLastDamage(9999.0);
                                HotPotato.emhotpotato.remove(k.getName());
                            }
                        }
                    }.runTaskLater((Plugin)Main.getInstance(), 80L);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            p.sendMessage(ApiManager.fimcooldown);
                        }
                    }, 500L);
                }
            }
        }
    }
    
    @EventHandler
    public void onRemoverTNT(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (Hability.getAbility(p) != "Nenhum" && e.getSlot() == 39 && e.getCurrentItem().getType().equals((Object)Material.TNT) && HotPotato.emhotpotato.contains(p.getName())) {
            HotPotato.emhotpotato.remove(p.getName());
            e.setCancelled(true);
            p.getInventory().setHelmet((ItemStack)null);
            p.playSound(p.getLocation(), Sound.CREEPER_HISS, 2.0f, 2.0f);
            p.sendMessage("§a§lHOT-POTATO §fVocê desarmou a dinamite!");
            p.closeInventory();
        }
    }
}
