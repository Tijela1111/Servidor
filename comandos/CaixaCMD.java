package pvp.blatantmc.comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import pvp.blatantmc.sistemas.*;

import org.bukkit.*;

public class CaixaCMD implements CommandExecutor
{
    public static String simbonaosuavel;
    public static String sonumeros;
    public static String naousar;
    public static String semquantia;
    public static String sintaxedar;
    public static String sintaxedoar;
    
    static {
        CaixaCMD.simbonaosuavel = String.valueOf("§c§lCAIXA §fSimbolo não usavel!");
        CaixaCMD.sonumeros = String.valueOf("§c§lCAIXA §fApenas é possível usar números!");
        CaixaCMD.naousar = String.valueOf("§c§lCAIXA §fVocê não pode usar nome como doação!");
        CaixaCMD.semquantia = String.valueOf("§c§lCAIXA §fVocê não tem a quantia suficiente de caixas que quer doar.");
        CaixaCMD.sintaxedar = String.valueOf("§c§lCAIXA Utilize: /caixa dar <nome> <quantidade> ou doar <nome> <quantidade>");
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ApiManager.semconsole);
            return true;
        }
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("caixa")) {
            if (args.length == 0) {
                p.sendMessage("§a§lCAIXAS §f" + KillsDeathsRankXp.getCaixa(p));
                return true;
            }
            if (args.length == 1) {
                if (p.hasPermission("simulator.darcaixa")) {
                    p.sendMessage(CaixaCMD.sintaxedar);
                }
                p.sendMessage(CaixaCMD.sintaxedoar);
                return true;
            }
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("dar")) {
                    if (p.hasPermission("simulator.darcaixa")) {
                        p.sendMessage(CaixaCMD.sintaxedar);
                    }
                }
                else if (args[0].equalsIgnoreCase("doar")) {
                    p.sendMessage(CaixaCMD.sintaxedoar);
                }
                else {
                    if (p.hasPermission("simulator.darcaixa")) {
                        p.sendMessage(CaixaCMD.sintaxedar);
                    }
                    p.sendMessage(CaixaCMD.sintaxedoar);
                }
                return true;
            }
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("dar")) {
                    if (p.hasPermission("simulator.darcaixa")) {
                        try {
                            final int caixa = Integer.valueOf(args[2]);
                            final Player t = Bukkit.getPlayerExact(args[1]);
                            if (t != null) {
                                if (args[2].contains("-")) {
                                    p.sendMessage(CaixaCMD.simbonaosuavel);
                                    return true;
                                }
                                KillsDeathsRankXp.adicionarCaixa(t, caixa);
                                p.sendMessage("§a§lCAIXA §fVocê deu §a" + caixa + "§a caixa para o §a" + t.getDisplayName());
                                t.sendMessage("§a§lCAIXA §fUm staff do servidor te deu §a" + caixa + " §fcaixas!");
                            }
                            else {
                                p.sendMessage(ApiManager.jogadoroff);
                            }
                        }
                        catch (Exception e) {
                            p.sendMessage(CaixaCMD.sonumeros);
                        }
                    }
                }
                else if (args[0].equalsIgnoreCase("doar")) {
                    try {
                        final int caixa = Integer.valueOf(args[2]);
                        final Player t = Bukkit.getPlayerExact(args[1]);
                        if (t != null) {
                            if (args[2].contains("-")) {
                                p.sendMessage(CaixaCMD.simbonaosuavel);
                                return true;
                            }
                            if (KillsDeathsRankXp.getCaixa(p) >= caixa) {
                                KillsDeathsRankXp.adicionarCaixa(t, caixa);
                                KillsDeathsRankXp.removerCaixa(p, caixa);
                                t.sendMessage("§a§lCAIXA §fO jogador §a" + p.getDisplayName() + " §ate deu §a" + caixa + " §acaixa!");
                                p.sendMessage("§a§lCAIXA §fVocê deu §a" + caixa + " §fcaixas para o §a" + t.getDisplayName());
                            }
                            else {
                                p.sendMessage(CaixaCMD.semquantia);
                            }
                        }
                        else {
                            p.sendMessage(ApiManager.jogadoroff);
                        }
                    }
                    catch (Exception e) {
                        p.sendMessage(CaixaCMD.sonumeros);
                    }
                }
                else {
                    if (p.hasPermission("simulator.darcaixa")) {
                        p.sendMessage(CaixaCMD.sintaxedar);
                    }
                    p.sendMessage(CaixaCMD.sintaxedoar);
                }
                return true;
            }
            if (p.hasPermission("simulator.darcaixa")) {
                p.sendMessage(CaixaCMD.sintaxedar);
            }
            p.sendMessage(CaixaCMD.sintaxedoar);
        }
        return false;
    }
}
