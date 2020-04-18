package pvp.blatantmc.sistemas;

import java.util.*;
import org.bukkit.entity.*;

public class WarpAPI
{
    public static Map<String, String> powerMap2;
    
    static {
        WarpAPI.powerMap2 = new HashMap<String, String>();
    }
    
    public static String NomeDoWarp(final String original) {
        if (original.length() == 0) {
            return original;
        }
        return String.valueOf(original.substring(0, 1).toUpperCase()) + original.substring(1);
    }
    
    public static String getWarp(final Player player) {
        if (!WarpAPI.powerMap2.containsKey(player.getName())) {
            WarpAPI.powerMap2.put(player.getName(), "Nenhuma");
        }
        return WarpAPI.powerMap2.get(player.getName());
    }
    
    public static void setWarp(final Player player, final String warp) {
        WarpAPI.powerMap2.put(player.getName(), warp);
    }
    
    public static void removeWarp(final Player p) {
        WarpAPI.powerMap2.remove(p.getName());
    }
}
