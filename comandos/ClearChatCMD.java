package pvp.blatantmc.comandos;

import java.util.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import pvp.blatantmc.main.*;
import pvp.blatantmc.sistemas.*;

import org.bukkit.*;

public class ClearChatCMD implements CommandExecutor
{
    public static ArrayList<String> emcc;
    
    static {
        ClearChatCMD.emcc = new ArrayList<String>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("cc")) {
            if (p.hasPermission("simulator.chatclear")) {
                if (ClearChatCMD.emcc.contains(p.getName())) {
                    p.sendMessage("§c§lCHAT §fAguarde para poder limpar novamente o chat!");
                    return true;
                }
                for (int i = 0; i < 100; ++i) {
                    Bukkit.broadcastMessage(" ");
                }
                Bukkit.broadcastMessage("§e§lCHAT §fO chat do servidor foi limpo por §e" + p.getName());
                p.sendMessage(String.valueOf("§a§lCHAT §fVocê limpou o chat com sucesso!"));
                ClearChatCMD.emcc.add(p.getName());
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        ClearChatCMD.emcc.remove(p.getName());
                        p.sendMessage("§3§lCHAT §fVocê agora pode limpar o chat novamente!");
                    }
                }, 140L);
            }
            else {
                p.sendMessage(ApiManager.semperm);
            }
        }
        return false;
    }
}
