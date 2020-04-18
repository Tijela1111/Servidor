package pvp.blatantmc.comandos;

import org.bukkit.event.*;
import org.bukkit.event.player.*;

import pvp.blatantmc.sistemas.*;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class ChatCMD implements Listener, CommandExecutor
{
    public static boolean chat1;
    
    static {
        ChatCMD.chat1 = true;
    }
    
    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent e) {
        if (!e.getPlayer().hasPermission("simulator.falarchat") && !ChatCMD.chat1) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("§c§lCHAT §fO chat está desabilitado!");
        }
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerChat1(final PlayerChatEvent e) {
        if (!e.getPlayer().hasPermission("simulator.falarchat") && !ChatCMD.chat1) {
            e.setCancelled(true);
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        if (sender.hasPermission("simulator.chat")) {
            if (args.length > 0) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("off")) {
                        ChatCMD.chat1 = false;
                        Bukkit.broadcastMessage("§c§lCHAT §fO chat do servidor foi desativado por §c" + sender.getName());
                    }
                    else if (args[0].equalsIgnoreCase("on")) {
                        ChatCMD.chat1 = true;
                        Bukkit.broadcastMessage("§a§lCHAT §fO chat do servidor foi habilitado por §a" + sender.getName());
                    }
                }
                else {
                    sender.sendMessage("§c§lCHAT §fUtilize: /chat (on|off)");
                }
            }
            else {
            	sender.sendMessage("§c§lCHAT §fUtilize: /chat (on|off)");
            }
        }
        return true;
    }
}
