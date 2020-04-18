package pvp.blatantmc.kits2;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

import pvp.blatantmc.sistemas.*;

import org.bukkit.*;
import org.bukkit.event.*;

public class Resouper implements Listener
{
    @EventHandler
    public void aomatar(final PlayerDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) {
            final Player p = e.getEntity().getKiller();
            if (Hability.getAbility(p).equalsIgnoreCase("Resouper")) {
                for (int i = 0; i < p.getInventory().getSize(); ++i) {
                    p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
                    p.updateInventory();
                }
            }
        }
    }
}
