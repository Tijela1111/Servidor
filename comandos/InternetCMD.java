package pvp.blatantmc.comandos;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class InternetCMD implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender Sender, final Command cmd, final String string, final String[] args) {
        final Player p = (Player)Sender;
        if (cmd.getName().equalsIgnoreCase("internet")) {
        	p.sendMessage("§f");
        	p.sendMessage("§f");
        	p.sendMessage("      §6§lINTERNET §f- §6Tenha uma melhor Conexão!");
        	p.sendMessage("§f");
        	p.sendMessage("           §aSiga os passos abaixo:");
        	p.sendMessage("§f");
        	p.sendMessage("§e1. §fColoque a seguinte DNS no seu IPV4 (1.1.1.1/1.0.0.1)");
        	p.sendMessage("§e2. §fLimpe as seguintes pastas (prefetch) (temp) (%temp) (recent)");
        	p.sendMessage("§e3. §fReinicie seu computador.");
        	p.sendMessage("§e4. §fQuando reiniciar seu computador abra seu cmd (Prompt de Comando)");
        	p.sendMessage("§e5. §fDigite no cmd: ipconfig /flushdns. Isso vai limpar o cache da sua internet.");
        	p.sendMessage("§f");
        	p.sendMessage("  §7Essas foi as dicas que poderemos disponibilizar para você.");
        	p.sendMessage("  §7Caso não melhore sua internet procure em redes sociais.");
        	p.sendMessage("§f");
            p.sendMessage("§f");
        }
        return false;
    }
}
