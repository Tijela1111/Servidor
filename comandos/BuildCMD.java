package pvp.blatantmc.comandos;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

import pvp.blatantmc.sistemas.*;

public final class BuildCMD implements Listener, CommandExecutor
{
    public static ArrayList<Player> embuild;
    
    static {
        BuildCMD.embuild = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("build")) {
            if (p.hasPermission("simulator.build")) {
                if (args.length == 0) {
                    if (!BuildCMD.embuild.contains(p)) {
                        BuildCMD.embuild.add(p);
                        p.sendMessage("§a§lBUILD §fVocê ativou seu modo build!");
                    }
                    else {
                        BuildCMD.embuild.remove(p);
                        p.sendMessage("§c§lBUILD §fVocê desativou seu modo build!");
                    }
                }
                else {
                    final Player t = Bukkit.getPlayer(args[0]);
                    if (t == null) {
                        p.sendMessage(ApiManager.jogadoroff);
                        return true;
                    }
                    if (!BuildCMD.embuild.contains(t)) {
                        BuildCMD.embuild.add(t);
                        p.sendMessage("§e§lBUILD §fVocê ativou o modo build para o jogador §e" + t.getName());
                    }
                    else {
                        BuildCMD.embuild.remove(t);
                        p.sendMessage("§c§lBUILD §fVocê desativou o modo build do jogador §c" + t.getName());
                    }
                }
            }
            else {
                p.sendMessage(ApiManager.semperm);
            }
        }
        return false;
    }
    
    @EventHandler
    public void aoconstruir(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        if (!BuildCMD.embuild.contains(p)) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void aoconstruir(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        if (!BuildCMD.embuild.contains(p)) {
            e.setCancelled(true);
        }
    }
}
