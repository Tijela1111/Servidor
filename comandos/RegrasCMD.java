package pvp.blatantmc.comandos;

import org.bukkit.event.*;

import org.bukkit.command.*;
import org.bukkit.entity.*;

public class RegrasCMD implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender Sender, final Command cmd, final String string, final String[] args) {
        final Player p = (Player)Sender;
        if (cmd.getName().equalsIgnoreCase("regras")) {
            p.sendMessage("�f");
            p.sendMessage("              �e�lREGRAS");
            p.sendMessage("�f");
            p.sendMessage("�e1. �7N�o usar nenhuma trapa�a.");
            p.sendMessage("�e2. �7N�o ofender o servidor e nem a staff.");
            p.sendMessage("�e3. �7N�o amea�ar nenhum jogador ou o servidor.");
            p.sendMessage("�e4. �7N�o chantagear ningu�m no servidor");
            p.sendMessage("�e5. �7N�o praticar Spam/Flood no chat do servidor.");
            p.sendMessage("�e6. �7N�o testar a staff do servidor.");
            p.sendMessage("�e7. �7N�o abusar de bugs do servidor.");
            p.sendMessage("�e8. �7N�o divulgar IP'S de outros servidores no chat.");
            p.sendMessage("�e9. �7N�o se passar por um staff ou membro da equipe.");
            p.sendMessage("�e10. �7N�o divulgar links pornogr�ficos no chat do servidor.");
            p.sendMessage("�f");
            p.sendMessage("     �e�nDireitos reservados a BlatantMC");
        }
        return false;
    }
}
