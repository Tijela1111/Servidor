package pvp.blatantmc.comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import org.bukkit.*;

public class PingCMD implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String c, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player)sender;
            final int ping = ((CraftPlayer)p).getHandle().ping;
            if (c.equalsIgnoreCase("ping")) {
                if (args.length == 0) {
                    p.sendMessage("§3§lPING §fO seu ping é de: §3" + ping + " §fms!");
                }
                else if (p.getServer().getPlayer(args[0]) != null) {
                    final String player2 = args[0];
                    final Player target = Bukkit.getServer().getPlayer(args[0]);
                    final int ping2 = ((CraftPlayer)target).getHandle().ping;
                    p.sendMessage("§3§lPING §fO Jogador §3" + player2 + " §ftem um ping de §3" + ping2 + " §fms!");
                }
                else {
                    p.sendMessage("§c§lERRO §fO jogador está offline!");
                }
            }
        }
        return false;
    }
}
