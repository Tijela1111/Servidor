package pvp.blatantmc.kits2;

import org.bukkit.event.player.*;

import pvp.blatantmc.sistemas.*;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class Hulk implements Listener
{
    @EventHandler
    public void PickUpPlayer(final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) {
            return;
        }
        if (e.getRightClicked() instanceof Player) {
            final Player p = e.getPlayer();
            if (Hability.getAbility(p).equalsIgnoreCase("Hulk")) {
                final Player r = (Player)e.getRightClicked();
                if (Cooldown.add(p)) {
                    ApiManager.MensagemCooldown(p);
                    return;
                }
                if (p.getItemInHand().getType() != Material.AIR) {
                    return;
                }
                if (p.getPassenger() != null) {
                    p.sendMessage("§c§lHULK §fVocê já tem alguém, espere ele sair!");
                    return;
                }
                if (r.getPassenger() != null) {
                    return;
                }
                Cooldown.add(p, 6);
                p.setPassenger((Entity)r);
                r.sendMessage("§c§lHULK §fUm hulk te prendeu!");
                r.sendMessage("§a§lDICA §fAperte shift para SAIR.");
            }
        }
    }
}
