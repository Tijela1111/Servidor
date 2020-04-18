package pvp.blatantmc.kits;

import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.potion.*;

import pvp.blatantmc.sistemas.*;

import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.event.*;

public class Poseidon implements Listener
{
    @EventHandler
    public void aoPoseidon(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final Block b = p.getLocation().getBlock();
        if (Hability.getAbility(p).equalsIgnoreCase("Poseidon") && (b.getType() == Material.WATER || b.getType() == Material.STATIONARY_WATER)) {
            ApiManager.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 10, 1);
            ApiManager.darEfeito(p, PotionEffectType.DAMAGE_RESISTANCE, 10, 1);
            ApiManager.darEfeito(p, PotionEffectType.SPEED, 8, 0);
        }
    }
}
