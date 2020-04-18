package pvp.blatantmc.comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import pvp.blatantmc.groups.Groups;
import pvp.blatantmc.sistemas.*;

import org.bukkit.*;

public class StatusCMD implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (!cmd.getName().equalsIgnoreCase("status")) {
            return false;
        }
        if (args.length == 0) {
        	p.sendMessage("§f");
            p.sendMessage("         §e§lSTATUS");
            p.sendMessage("§f");
            p.sendMessage("§fGrupo: " + Groups.getGroupMax(p));
            p.sendMessage("§f");
            p.sendMessage("§fKills: §e" + KillsDeathsRankXp.getKills(p));
            p.sendMessage("§fDeaths: §e" + KillsDeathsRankXp.getDeaths(p));
            p.sendMessage("§fCaixas: §e" + KillsDeathsRankXp.getCaixa(p));
            p.sendMessage("§f");
            p.sendMessage("§fRanking: " + KillsDeathsRankXp.getRank(p));
            p.sendMessage("§fXP: §a" + KillsDeathsRankXp.getXp(p));
            p.sendMessage("§f");
            return true;
        }
        final Player t = Bukkit.getPlayer(args[0]);
        if (t == null) {
            p.sendMessage(ApiManager.jogadoroff);
            return true;
        }
        p.sendMessage("§f");
        p.sendMessage("      §e§lSTATUS §fdo jogador §e" + p.getDisplayName());
        p.sendMessage("§f");
        p.sendMessage("§fGrupo: " + Groups.getGroupMax(p));
        p.sendMessage("§f");
        p.sendMessage("§fKills: §e" + KillsDeathsRankXp.getKills(p));
        p.sendMessage("§fDeaths: §e" + KillsDeathsRankXp.getDeaths(p));
        p.sendMessage("§fCaixas: §e" + KillsDeathsRankXp.getCaixa(p));
        p.sendMessage("§f");
        p.sendMessage("§fRanking: " + KillsDeathsRankXp.getRank(p));
        p.sendMessage("§fXP: §a" + KillsDeathsRankXp.getXp(p));
        p.sendMessage("§f");
        return true;
    }
}
