package pvp.blatantmc.kits;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;

import pvp.blatantmc.main.*;
import pvp.blatantmc.sistemas.*;

import java.util.*;
import org.bukkit.event.*;

public class Flash implements Listener
{
    @EventHandler
    public void onFlashUse(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Hability.getAbility(p).equalsIgnoreCase("Flash") && (e.getAction() == Action.RIGHT_CLICK_AIR || (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().getType() == Material.REDSTONE_TORCH_ON))) {
            if (Gladiator.lutando.containsKey(p.getName()) || Infernor.lutando.containsKey(p.getName())) {
                p.sendMessage("§c§lFLASH §fVocê não poder usar seu kit no gladiator ou infernor, então vai ganhar um efeito de força e speed.");
                ApiManager.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 10, 1);
                ApiManager.darEfeito(p, PotionEffectType.SPEED, 10, 2);
            }
            else {
                e.setCancelled(true);
                if (Cooldown.add(p)) {
                    ApiManager.MensagemCooldown(p);
                    return;
                }
                Cooldown.add(p, 30);
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        p.sendMessage(ApiManager.fimcooldown);
                    }
                }, 600L);
                ApiManager.darEfeito(p, PotionEffectType.SPEED, 200, 2);
                for (final Entity pertos : p.getNearbyEntities(6.0, 6.0, 6.0)) {
                    ((Player)pertos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 2));
                    ((Player)pertos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 200, 2));
                }
                p.sendMessage("§a§lFLASH §fVocê roubou a velocidade dos players perto de você!");
            }
        }
    }
}
