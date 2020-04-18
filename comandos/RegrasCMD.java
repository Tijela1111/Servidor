package pvp.blatantmc.comandos;

import org.bukkit.event.*;

import org.bukkit.command.*;
import org.bukkit.entity.*;

public class RegrasCMD implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender Sender, final Command cmd, final String string, final String[] args) {
        final Player p = (Player)Sender;
        if (cmd.getName().equalsIgnoreCase("regras")) {
            p.sendMessage("§f");
            p.sendMessage("              §e§lREGRAS");
            p.sendMessage("§f");
            p.sendMessage("§e1. §7Não usar nenhuma trapaça.");
            p.sendMessage("§e2. §7Não ofender o servidor e nem a staff.");
            p.sendMessage("§e3. §7Não ameaçar nenhum jogador ou o servidor.");
            p.sendMessage("§e4. §7Não chantagear ninguém no servidor");
            p.sendMessage("§e5. §7Não praticar Spam/Flood no chat do servidor.");
            p.sendMessage("§e6. §7Não testar a staff do servidor.");
            p.sendMessage("§e7. §7Não abusar de bugs do servidor.");
            p.sendMessage("§e8. §7Não divulgar IP'S de outros servidores no chat.");
            p.sendMessage("§e9. §7Não se passar por um staff ou membro da equipe.");
            p.sendMessage("§e10. §7Não divulgar links pornográficos no chat do servidor.");
            p.sendMessage("§f");
            p.sendMessage("     §e§nDireitos reservados a BlatantMC");
        }
        return false;
    }
}
