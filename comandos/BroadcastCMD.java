package pvp.blatantmc.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pvp.blatantmc.sistemas.ApiManager;

public class BroadcastCMD implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
 
        if (cmd.getName().equalsIgnoreCase("aviso")) {
            if (sender.hasPermission("simulator.aviso")) {
                if (args.length == 0) {
                    sender.sendMessage("§c§lAVISO §fUtilize: /aviso (msg)");
                    return true;
                }
                String msg = "";
                for (final String msg2 : args) {
                    msg = String.valueOf(String.valueOf(msg)) + msg2 + " ";
                }
                Bukkit.broadcastMessage(String.valueOf(ApiManager.preffix) + ChatColor.RESET + msg.replace("&", "§"));
                return true;
            }
            else {
            	sender.sendMessage(ApiManager.semperm);
            }
        }
        return false;
    }
}
