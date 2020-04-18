package pvp.blatantmc.comandos;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class YoutuberCMD implements Listener, CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        cmd.getName().equalsIgnoreCase("youtuber");
        p.sendMessage("§f");
        p.sendMessage("           §b§lYOUTUBER");
        p.sendMessage("§f");
        p.sendMessage("§f- §7Possuir 100 inscritos no canal.");
        p.sendMessage("§f- §7Gravar um vídeo no servidor.");
        p.sendMessage("§f- §7E ter 200 Views no vídeo do servidor.");
        p.sendMessage("§f");
        p.sendMessage("             §6§lPRO");
        p.sendMessage("§f");
        p.sendMessage("§f- §7Possuir 60 inscritos no canal.");
        p.sendMessage("§f- §7Gravar um vídeo no servidor.");
        p.sendMessage("§f- §7E ter 150 Views no vídeo do servidor.");
        p.sendMessage("");
        p.sendMessage("             §e§lS-PRO");
        p.sendMessage("§f");
        p.sendMessage("§f- §7Possuir 20 inscritos no canal.");
        p.sendMessage("§f- §7Gravar um vídeo no servidor.");
        p.sendMessage("§f- §7E ter 30 Views no vídeo do servidor.");
        p.sendMessage("§f");
        p.sendMessage("   §e§nDireitos reservados a BlatantMC.");
        return false;
    }
}
