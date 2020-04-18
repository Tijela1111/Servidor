package pvp.blatantmc.comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import pvp.blatantmc.sistemas.*;

import org.bukkit.*;

public class PvPCMD implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("pvp")) {
            if (p.hasPermission("simulator.pvp")) {
                if (args.length == 0) {
                    p.sendMessage("§c§lPVP §fUtilize: /pvp (on/off)");
                    return true;
                }
                if (args[0].equalsIgnoreCase("on")) {
                    Bukkit.getWorld("world").setPVP(true);
                    Bukkit.broadcastMessage("§a§lPVP §fO pvp do servidor foi §ahabilitado!");
                }
                if (args[0].equalsIgnoreCase("off")) {
                    Bukkit.getWorld("world").setPVP(false);
                    Bukkit.broadcastMessage("§c§lPVP §fO pvp do servidor foi §cdesabilitado!");
                }
            }
            else {
                p.sendMessage(ApiManager.semperm);
            }
        }
        return false;
    }
}
