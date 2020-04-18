package pvp.blatantmc.kits;

import org.bukkit.event.entity.*;

import pvp.blatantmc.sistemas.*;

import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class Viking implements Listener
{
    @EventHandler
    public void aoviking(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getDamager();
            if (Hability.getAbility(p).equalsIgnoreCase("Viking") && e.getEntity() instanceof Player && p.getItemInHand().getType() == Material.STONE_AXE) {
                e.setDamage(e.getDamage() * 1.66);
            }
        }
    }
}
