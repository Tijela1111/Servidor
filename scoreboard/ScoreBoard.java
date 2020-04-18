package pvp.blatantmc.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

import pvp.blatantmc.eventos.CombatLogEvent;
import pvp.blatantmc.groups.Groups;
import pvp.blatantmc.sistemas.ApiManager;
import pvp.blatantmc.sistemas.KillsDeathsRankXp;

public class ScoreBoard
{
    @SuppressWarnings("deprecation")
	public static void FlameScore(final Player p) {
        final String jogadoronline = String.valueOf(Bukkit.getServer().getOnlinePlayers().length) + "§7/§e" + Bukkit.getServer().getMaxPlayers();
        final SimpleScoreboard scoreboard = new SimpleScoreboard(ApiManager.NomeServer);
        scoreboard.addLinha("§4 ", 13);
        scoreboard.addLinha("§fGrupo: " + Groups.getGroupMax(p), 12);
        scoreboard.addLinha("§2 ", 11);
        scoreboard.addLinha("§fKills: §7" + KillsDeathsRankXp.getKills(p), 10);
        scoreboard.addLinha("§fDeaths: §7" + KillsDeathsRankXp.getDeaths(p), 9);
        scoreboard.addLinha("§c ", 8);
        scoreboard.addLinha("§fCaixas: §6" + KillsDeathsRankXp.getCaixa(p), 7);
        scoreboard.addLinha("§fXP: §a" + KillsDeathsRankXp.getXp(p), 6);
        scoreboard.addLinha("§fRank: " + KillsDeathsRankXp.getRank(p), 5);
        scoreboard.addLinha("§b ", 4);
        scoreboard.addLinha("§7www.blatantmc.tk", 3);
      
        scoreboard.setScoreboard(p);
        final Objective o = scoreboard.getScoreboard().registerNewObjective("health", "health");
        o.setDisplayName(ChatColor.GREEN + "\u2764");
        o.setDisplaySlot(DisplaySlot.BELOW_NAME);
    }
}
