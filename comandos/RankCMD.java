package pvp.blatantmc.comandos;

import org.bukkit.event.*;

import pvp.blatantmc.sistemas.KillsDeathsRankXp;

import org.bukkit.command.*;
import org.bukkit.entity.*;

public class RankCMD implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender Sender, final Command cmd, final String string, final String[] args) {
        final Player p = (Player)Sender;
        if (cmd.getName().equalsIgnoreCase("ranks")) {
        	p.sendMessage("§f");
            p.sendMessage("       §6§lRANKINGS");
            p.sendMessage(" §f");
            p.sendMessage(" §7(-) Unranked §f- §a0 kills");
            p.sendMessage(" §a(⚎) Primary §f- §a30 kills");
            p.sendMessage(" §e(☰) Apprentice §f- §a40 kills");
            p.sendMessage(" §7(⚔) Silver §f- §a50 kills");
            p.sendMessage(" §6(✯) Gold §f- §a60 kills");
            p.sendMessage(" §b(✪) Diamond §f- §a70 kills");
            p.sendMessage(" §2(✤) Emerald §f- §a80 kills");
            p.sendMessage(" §c(✸) Master §f- §a90 kills");
            p.sendMessage(" §4(✹) Legendary §f- §a100 kills");
            p.sendMessage(" §1(✷) Extreme §f- §a200 kills");
            p.sendMessage(" §9(✥) Mega §f- §a300 kills");
            p.sendMessage(" §f");
            p.sendMessage(" §fSeu ranking atualmente: " + KillsDeathsRankXp.getRank(p));
            p.sendMessage(" §fSuas kills§a: " + KillsDeathsRankXp.getKills(p));
            p.sendMessage(" §f");
        }
        return false;
    }
}
