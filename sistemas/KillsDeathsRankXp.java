package pvp.blatantmc.sistemas;

import org.bukkit.entity.*;

import net.md_5.bungee.api.ChatColor;
import pvp.blatantmc.main.*;

import org.bukkit.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;

public class KillsDeathsRankXp
{
	public static String getRankPequeno(final Player p) {
        final double a = getKills(p);
        if(a <= 20) {
 		   return "§7⚊";
 		  }
 		  if(a <= 30) {
 		   return ChatColor.GREEN + "⚎";
 		  }
 		  if(a <= 40) {
 		   return ChatColor.YELLOW + "☰";
 		  }
 		  if(a <= 50) {
 		   return "§7⚔";
 		  }
 		  if(a <= 60) {
 		   return "§6✯";
 		  }
 		  if(a <= 70) {
 		   return "§b✪";
 		  }
 		  if(a <= 80) {
 		   return ChatColor.DARK_GREEN + "§2✤";
 		  }
 		  if(a <= 90) {
 		   return "§c✸";
 		  }
 		  if(a <= 100) {
 		   return ChatColor.DARK_RED + "✹";
 		  }
 		  if(a <= 200) {
 		   return "§1✷";
 		  }
 		  if(a <= 300) {
 		   return "§9✥";
 		  }
 		  return "§9✥";
 		 }
    
    public static String getRank(final Player p) {
        final double a = getKills(p);
        if(a <= 20) {
		   return "§7Unranked";
	    }
		if(a <= 30) {
	       return ChatColor.GREEN + "§aPrimary";
	    }
		if(a <= 40) {
		   return ChatColor.YELLOW + "§eApprentice";
		}
		if(a <= 50) {
		   return "§7Silver";
		}
		if(a <= 60) {
	       return "§6Gold";
		}
		if(a <= 70) {
	       return "§bDiamond";
		}
		if(a <= 80) {
		   return ChatColor.DARK_GREEN + "§§2Emerald";
		}
		if(a <= 90) {
	       return "§cMaster";
		}
		if(a <= 100) {
		   return ChatColor.DARK_RED + "Legendary";
		}
		if(a <= 200) {
		   return "§1Extreme";
	    }
	    if(a <= 300) {
		   return "§9Mega";
		}
		return "§9Mega";
	   }
    
    public static void adicionarKill(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(p.getName()) + ".Matou");
        Main.getInstance().status.set(String.valueOf(p.getName()) + ".Matou", (Object)(Value + i));
        Main.getInstance().save();
    }
    
    public static void adicionarDeaths(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(p.getName()) + ".Morreu");
        Main.getInstance().status.set(String.valueOf(p.getName()) + ".Morreu", (Object)(Value + i));
        Main.getInstance().save();
    }
    
    public static void adicionarXp(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(p.getName()) + ".XP");
        Main.getInstance().status.set(String.valueOf(p.getName()) + ".XP", (Object)(Value + i));
        Main.getInstance().save();
    }
    
    public static void removerXp(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(p.getName()) + ".XP");
        Main.getInstance().status.set(String.valueOf(p.getName()) + ".XP", (Object)(Value - i));
        Main.getInstance().save();
    }
    
    public static void adicionarCaixa(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(p.getName()) + ".Caixa");
        Main.getInstance().status.set(String.valueOf(p.getName()) + ".Caixa", (Object)(Value + i));
        Main.getInstance().save();
    }
    
    public static void removerCaixa(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(p.getName()) + ".Caixa");
        Main.getInstance().status.set(String.valueOf(p.getName()) + ".Caixa", (Object)(Value - i));
        Main.getInstance().save();
    }
    
    public static int getKills(final Player p) {
        return Main.getInstance().status.getInt(String.valueOf(p.getName()) + ".Matou");
    }
    
    public static int getDeaths(final Player p) {
        return Main.getInstance().status.getInt(String.valueOf(p.getName()) + ".Morreu");
    }
    
    public static int getXp(final Player p) {
        return Main.getInstance().status.getInt(String.valueOf(p.getName()) + ".XP");
    }
    
    public static int getCaixa(final Player p) {
        return Main.getInstance().status.getInt(String.valueOf(p.getName()) + ".Caixa");
    }
    
    public static int getPing(final Player p) {
        return ((CraftPlayer)p).getHandle().ping;
    }
}
