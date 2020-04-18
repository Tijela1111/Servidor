package pvp.blatantmc.comandos;

import java.util.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import pvp.blatantmc.scoreboard.*;
import pvp.blatantmc.sistemas.*;

public class ScoreboardCMD extends ScoreBoard implements CommandExecutor
{
    public static ArrayList<String> temscore;
    public static ArrayList<String> ntemscore;
    
    static {
        ScoreboardCMD.temscore = new ArrayList<String>();
        ScoreboardCMD.ntemscore = new ArrayList<String>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("score")) {
        	p.sendMessage("§c§lSCOREBOARD §fEste comando está em §cdesenvolvimento!");
        }
		return false;
    }
}

