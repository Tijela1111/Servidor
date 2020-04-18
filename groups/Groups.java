package pvp.blatantmc.groups;

import org.bukkit.entity.*;

public class Groups {
	
    public static String getGroupMax(final Player p) {
        if (p.hasPermission("tag.dono")) {
            return "§4§lDONO";
        }
        if (p.hasPermission("tag.diretor")) {
            return "§4§lDIRETOR";
        }
        if (p.hasPermission("tag.coordenador")) {
            return "§9§lCOORD";
        }
        if (p.hasPermission("tag.admin")) {
            return "§c§lADMIN";
        }
        if (p.hasPermission("tag.gerente")) {
            return "§c§lGERENTE";
        }
        if (p.hasPermission("tag.mod+")) {
            return "§5§lMOD+";
        }
        if (p.hasPermission("tag.modgc")) {
            return "§5§lMODGC";
        }
        if (p.hasPermission("tag.mod")) {
            return "§5§lMOD";
        }
        if (p.hasPermission("tag.trial")) {
            return "§5§lTRIAL";
        }
        if (p.hasPermission("tag.builder")) {
            return "§e§lBUILDER";
        }
        if (p.hasPermission("tag.helper")) {
            return "§2§lHELPER";
        }
        if (p.hasPermission("tag.youtuber")) {
            return "§b§lYT";
        }
        if (p.hasPermission("tag.pro")) {
            return "§6§lPRO";
        }
        if (p.hasPermission("tag.spro")) {
            return "§e§lSPRO";
        }
        if (p.hasPermission("tag.mega")) {
            return "§6§lMEGA";
        }
        if (p.hasPermission("tag.star")) {
            return "§e§lSTAR";
        }
        if (p.hasPermission("tag.light")) {
            return "§a§lLIGHT";
        }
        return "§7§lMEMBRO";
    }
    
    public static String getGroupMin(final Player p) {
    	if (p.hasPermission("tag.ceo")) {
            return "§4CEO";
        }
        if (p.hasPermission("tag.dono")) {
            return "§4DONO";
        }
        if (p.hasPermission("tag.diretor")) {
            return "§1DIRETOR";
        }
        if (p.hasPermission("tag.coordenador")) {
            return "§9COORD";
        }
        if (p.hasPermission("tag.admin")) {
            return "§cADMIN";
        }
        if (p.hasPermission("tag.admingc")) {
            return "§cADMINGC";
        }
        if (p.hasPermission("tag.gerente")) {
            return "§cGERENTE";
        }
        if (p.hasPermission("tag.gerentegc")) {
            return "§cGERENTEGC";
        }
        if (p.hasPermission("tag.mod+")) {
            return "§5MOD+";
        }
        if (p.hasPermission("tag.modgc")) {
            return "§5MODGC";
        }
        if (p.hasPermission("tag.mod")) {
            return "§5MOD";
        }
        if (p.hasPermission("tag.trial")) {
            return "§dTRIAL";
        }
        if (p.hasPermission("tag.trialgc")) {
            return "§dTRIALGC";
        }
        if (p.hasPermission("tag.builder")) {
            return "§eBUILDER";
        }
        if (p.hasPermission("tag.helper")) {
            return "§2HELPER";
        }
        if (p.hasPermission("tag.youtuber+")) {
            return "§3YT+";
        }
        if (p.hasPermission("tag.youtuber")) {
            return "§bYT";
        }
        if (p.hasPermission("tag.discloser")) {
            return "§3DISCLOSER";
        }
        if (p.hasPermission("tag.ultimato")) {
            return "§aULTIMATO";
        }
        if (p.hasPermission("tag.legend")) {
            return "§6LEGEND";
        }
        if (p.hasPermission("tag.beta")) {
            return "§1BETA";
        }
        if (p.hasPermission("tag.star")) {
            return "§eSTAR";
        }
        return "§7JOGADOR";
    }
}