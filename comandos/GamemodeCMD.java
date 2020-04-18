package pvp.blatantmc.comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import pvp.blatantmc.sistemas.*;

import org.bukkit.*;

public class GamemodeCMD implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode")) {
            if (sender instanceof ConsoleCommandSender) {
                System.out.println(ApiManager.semconsole);
                return true;
            }
            final Player p = (Player)sender;
            if (args.length == 0) {
                p.sendMessage("§c§lGAMEMODE §fUtilize: /gamemode (1/2/3)");
            }
            else if (args.length == 1) {
                if (p.hasPermission("simulator.gm") || p.isOp()) {
                    if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("criativo")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage("§3§lGAMEMODE §fVocê entrou no modo §3Criativo.");
                    }
                    else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("sobrevivencia")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage("§3§lGAMEMODE §fVocê entrou no modo §3Sobrevivência.");
                    }
                    else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("aventura")) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage("§3§lGAMEMODE §fVocê entrou no modo §3Aventura.");
                    }
                    else {
                        p.sendMessage(ApiManager.jogadoroff);
                    }
                }
                else {
                    p.sendMessage(ApiManager.semperm);
                }
            }
        }
        return false;
    }
}
