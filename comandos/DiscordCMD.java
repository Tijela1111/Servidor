package pvp.blatantmc.comandos;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class DiscordCMD implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender Sender, final Command cmd, final String string, final String[] args) {
        final Player p = (Player)Sender;
        if (cmd.getName().equalsIgnoreCase("discord")) {
        	p.sendMessage("§f");
        	p.sendMessage("                §6§lDISCORD");
        	p.sendMessage(" §fFique atento em todas as novidades em nosso discord.");
        	p.sendMessage("         §6https://discord.gg/eWvbNxw");
            p.sendMessage("§f");
        }
        return false;
    }
}
