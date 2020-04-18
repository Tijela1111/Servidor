package pvp.blatantmc.comandos;

import org.bukkit.entity.*;

import pvp.blatantmc.sistemas.*;

import java.util.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class TellCMD implements CommandExecutor
{
    public static HashMap<Player, Player> gettell;
    static ArrayList<Player> telloff;
    
    static {
        TellCMD.gettell = new HashMap<Player, Player>();
        TellCMD.telloff = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("tell")) {
            if (args.length == 0) {
                p.sendMessage("§c§lTELL §fUtilize: /tell (nome) (msg)");
                return true;
            }
            final Player target = Bukkit.getPlayer(args[0]);
            if (args[0].toLowerCase().equalsIgnoreCase("on")) {
                TellCMD.telloff.remove(p);
                p.sendMessage("§a§lTELL §fVocê ativou suas mensagens privadas.");
            }
            else if (args[0].toLowerCase().equalsIgnoreCase("off")) {
                TellCMD.telloff.add(p);
                p.sendMessage("§c§lTELL §fVocê desativou suas mensagens privadas.");
            }
            if (args.length > 1) {
                if (target == null) {
                    p.sendMessage(ApiManager.jogadoroff);
                    return true;
                }
                if (TellCMD.telloff.contains(target)) {
                    p.sendMessage("§c§lTELL §fEste jogador desativou as mensagens privadas!");
                    return true;
                }
                final StringBuilder sb = new StringBuilder();
                for (int i = 1; i < args.length; ++i) {
                    sb.append(args[i]).append(" ");
                }
                final String allArgs = sb.toString().trim();
                p.sendMessage("§7[§aEu§r --> §a" + target.getDisplayName() + "§7]§f: " + allArgs);
                target.sendMessage("§7[§a" + p.getDisplayName() + " §f--> §aEu§7]§f: " + allArgs);
                TellCMD.gettell.put(p, target);
                TellCMD.gettell.put(target, p);
            }
        }
        else if (label.equalsIgnoreCase("off")) {
            if (args.length == 0) {
                p.sendMessage("§c§lTELL §fFale com o jogador no chat normal!");
                return true;
            }
            if (!TellCMD.gettell.containsKey(p)) {
                p.sendMessage("§c§lTELL §fVocê não tem ninguém para responder.");
                return true;
            }
            final Player deslogo = TellCMD.gettell.get(p);
            if (deslogo == null) {
                p.sendMessage(ApiManager.jogadoroff);
                return true;
            }
            if (TellCMD.telloff.contains(deslogo)) {
                p.sendMessage("§c§lTELL §fEste jogador desativou as mensagens privadas!");
                return true;
            }
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < args.length; ++i) {
                sb.append(args[i]).append(" ");
            }
            final String allArgs = sb.toString().trim();
            p.sendMessage("§7[§aEu§r --> §a" + deslogo.getDisplayName() + "§7]§f: " + allArgs);
            deslogo.sendMessage("§7[§a" + p.getDisplayName() + " §f--> §aEu§7]§f: " + allArgs);
        }
        return false;
    }
}
