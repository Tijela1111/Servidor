package pvp.blatantmc.comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import pvp.blatantmc.sistemas.*;

import org.bukkit.*;

public class XpCMD implements CommandExecutor
{
    public static String simbonaosuavel;
    public static String sonumeros;
    public static String naousar;
    public static String semquantia;
    public static String sintaxedar;
    public static String sintaxedoar;
    
    static {
        XpCMD.simbonaosuavel = String.valueOf("§c§lERRO §fSimbolo não usavel!");
        XpCMD.sonumeros = String.valueOf("§c§lERRO §FApenas é possivel usar números!");
        XpCMD.naousar = String.valueOf("§c§lERRO §fVocê não pode usar nome como doação!");
        XpCMD.semquantia = String.valueOf("§c§lERRO §fVocê não tem a quantia suficiente de xp que quer doar.");
        XpCMD.sintaxedar = String.valueOf("§c§lXP §fUtilize: /xp dar <nome> <quantidade> ou xp doar <nome> <quantidade>");
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
 
        if (label.equalsIgnoreCase("xp")) {
            if (args.length == 0) {
            	
               if(sender instanceof Player){
            	   Player p = (Player) sender;
               	    sender.sendMessage("§a§lXP §f" + KillsDeathsRankXp.getXp(p));
               }else{
            	   sender.sendMessage(XpCMD.sintaxedar);
            	   sender.sendMessage(XpCMD.sintaxedoar);
               }
            }
            if (args.length == 1) {
                if (sender.hasPermission("simulator.darxp")) {
                	sender.sendMessage(XpCMD.sintaxedar);
                }
                sender.sendMessage(XpCMD.sintaxedoar);
                return true;
            }
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("dar")) {
                    if (sender.hasPermission("simulator.darxp")) {
                    	sender.sendMessage(XpCMD.sintaxedar);
                    }
                }
                else if (args[0].equalsIgnoreCase("doar")) {
                	sender.sendMessage(XpCMD.sintaxedoar);
                }
                else {
                    if (sender.hasPermission("simulator.darxp")) {
                    	sender.sendMessage(XpCMD.sintaxedar);
                    }
                    sender.sendMessage(XpCMD.sintaxedoar);
                }
                return true;
            }
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("dar")) {
                    if (sender.hasPermission("simulator.darxp")) {
                        try {
                            final int xp = Integer.valueOf(args[2]);
                            final Player t = Bukkit.getPlayerExact(args[1]);
                            if (t != null) {
                                if (args[2].contains("-")) {
                                	sender.sendMessage(XpCMD.simbonaosuavel);
                                    return true;
                                }
                                KillsDeathsRankXp.adicionarXp(t, xp);
                                sender.sendMessage("§a§lXP §fVocê deu §a" + xp + "§f xp para o §a" + t.getDisplayName());
                                t.sendMessage("§a§lXP §fUm staff te deu §a" + xp + "§f xp!");
                            }
                            else {
                            	sender.sendMessage(ApiManager.jogadoroff);
                            }
                        }
                        catch (Exception e) {
                        	sender.sendMessage(XpCMD.sonumeros);
                        }
                    }
                }
                else if (args[0].equalsIgnoreCase("doar")) {
                    try {
                        final int xp = Integer.valueOf(args[2]);
                        final Player t = Bukkit.getPlayerExact(args[1]);
                        if (t != null) {
                            if (args[2].contains("-")) {
                            	sender.sendMessage(XpCMD.simbonaosuavel);
                                return true;
                            }
                             Player p = (Player) sender;
                            if (KillsDeathsRankXp.getXp(p) >= xp) {
                                KillsDeathsRankXp.adicionarXp(t, xp);
                                KillsDeathsRankXp.removerXp(p, xp);
                                t.sendMessage("§a§lXP §fO jogador §a" + sender.getName() + " §fte deu §a" + xp + " §fxp!");
                                sender.sendMessage("§a§lXP §fVocê deu §a" + xp + " §fxp para o jogador §a" + t.getDisplayName());
                            }
                            else {
                            	sender.sendMessage(XpCMD.semquantia);
                            }
                        }
                        else {
                        	sender.sendMessage(ApiManager.jogadoroff);
                        }
                    }
                    catch (Exception e) {
                    	sender.sendMessage(XpCMD.sonumeros);
                    }
                }
                else {
                    if (sender.hasPermission("simulator.darxp")) {
                    	sender.sendMessage(XpCMD.sintaxedar);
                    }
                    sender.sendMessage(XpCMD.sintaxedoar);
                }
                return true;
            }
            if (sender.hasPermission("simulator.darxp")) {
            	sender.sendMessage(XpCMD.sintaxedar);
            }
            sender.sendMessage(XpCMD.sintaxedoar);
        }
        return false;
    }
}
