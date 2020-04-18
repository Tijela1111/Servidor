package pvp.blatantmc.comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import pvp.blatantmc.sistemas.*;

public class ApplyCMD implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("aplicar")) {
            p.sendMessage(ApiManager.MSGAplicar1);
        }
        return false;
    }
}
