package pvp.blatantmc.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class DamageEvent implements Listener {
	
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
    if(event.getEntity() instanceof Player) {
    	Player p = (Player) event.getEntity();
    	
    	if(event.getCause() == DamageCause.FALL){
    	event.setCancelled(true);
    }
		
	}
	}
}
