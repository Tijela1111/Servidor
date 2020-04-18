package pvp.blatantmc.kits2;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;

import java.util.*;
import org.bukkit.potion.*;

import pvp.blatantmc.sistemas.*;

import org.bukkit.event.*;

public class Viper_Snail implements Listener
{
    @EventHandler
    public void onviper(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player d = (Player)e.getDamager();
            if (Hability.getAbility(d).equalsIgnoreCase("Viper")) {
                final Random r = new Random();
                final int rand = r.nextInt(100);
                if (rand >= 67) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 1));
                }
            }
        }
    }
    
    @EventHandler
    public void onsnail(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player d = (Player)e.getDamager();
            if (Hability.getAbility(d).equalsIgnoreCase("Snail")) {
                final Random r = new Random();
                final int rand = r.nextInt(100);
                if (rand >= 67) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 1));
                }
            }
        }
    }
}
