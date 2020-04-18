package pvp.blatantmc.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class StarPlayerJoinEvent implements Listener {
	
	@EventHandler
	public void cudokeef(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		p.hasPermission("tag.membro");
	    p.chat("/tag membro");
		p.hasPermission("tag.light");
	    p.chat("/tag light");
		p.hasPermission("tag.star");
	    p.chat("/tag star");
		p.hasPermission("tag.mega");
	    p.chat("/tag mega");
	    p.hasPermission("tag.spro");
	    p.chat("/tag spro");
	    p.hasPermission("tag.pro");
	    p.chat("/tag pro");
	    p.hasPermission("tag.youtuber");
	    p.chat("/tag youtuber");
	    p.hasPermission("tag.helper");
	    p.chat("/tag helper");
	    p.hasPermission("tag.builder");
	    p.chat("/tag builder");
	    p.hasPermission("tag.trial");
	    p.chat("/tag trial");
	    p.hasPermission("tag.mod");
	    p.chat("/tag mod");
	    p.hasPermission("tag.modgc");
	    p.chat("/tag modgc");
	    p.hasPermission("tag.mod+");
	    p.chat("/tag mod+");
	    p.hasPermission("tag.gerente");
	    p.chat("/tag gerente");
	    p.hasPermission("tag.admin");
	    p.chat("/tag admin");
	    p.hasPermission("tag.coordenador");
	    p.chat("/tag coordenador");
	    p.hasPermission("tag.diretor");
	    p.chat("/tag diretor");
	    p.hasPermission("tag.dono");
	    p.chat("/tag dono");
	    
    	
    }
	    
	    
	}


