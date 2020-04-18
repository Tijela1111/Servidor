package pvp.blatantmc.kits;

import org.bukkit.event.player.*;
import org.bukkit.entity.*;

import java.util.*;
import org.bukkit.*;
import org.bukkit.plugin.*;

import pvp.blatantmc.main.*;
import pvp.blatantmc.sistemas.*;

import org.bukkit.inventory.*;
import org.bukkit.event.*;

public class Monk implements Listener
{
    @EventHandler
    public void aoMonk(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Player) {
            final Player jogadorClicado = (Player)e.getRightClicked();
            if (Hability.getAbility(p).equalsIgnoreCase("Monk") && p.getItemInHand().getType() == Material.BLAZE_ROD) {
                if (Cooldown.add(p)) {
                    ApiManager.MensagemCooldown(p);
                    return;
                }
                final int random = new Random().nextInt(jogadorClicado.getInventory().getSize() - 10 + 1 + 10);
                final ItemStack ItemSelecionado = jogadorClicado.getInventory().getItem(random);
                final ItemStack ItemMudado = jogadorClicado.getItemInHand();
                jogadorClicado.setItemInHand(ItemSelecionado);
                jogadorClicado.getInventory().setItem(random, ItemMudado);
                jogadorClicado.sendMessage("§c§lMONK §fUm jogador com o kit monk bagunçou seu inventário!");
                p.sendMessage("§a§lMONK §fVocê monkou o jogador §a" + jogadorClicado.getName());
                Cooldown.add(p, 20);
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        p.sendMessage(ApiManager.fimcooldown);
                    }
                }, 400L);
            }
        }
    }
}
