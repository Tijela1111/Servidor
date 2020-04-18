package pvp.blatantmc.comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;

public class SpawnCMD implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("spawn")) {
            final Player p = (Player)sender;
            p.chat("/warp spawn");
        }
        return false;
    }
}
