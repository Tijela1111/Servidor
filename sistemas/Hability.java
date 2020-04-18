package pvp.blatantmc.sistemas;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class Hability
{
    public static Map<String, String> powerMap;
    
    static {
        Hability.powerMap = new HashMap<String, String>();
    }
    
    public static String NomeDoKit(final String original) {
        if (original.length() == 0) {
            return original;
        }
        return String.valueOf(original.substring(0, 1).toUpperCase()) + original.substring(1);
    }
    
    public static String getAbility(final Player player) {
        if (!Hability.powerMap.containsKey(player.getName())) {
            Hability.powerMap.put(player.getName(), "Nenhum");
        }
        return Hability.powerMap.get(player.getName());
    }
    
    public static void setAbility(final Player player, final String ability) {
        Hability.powerMap.put(player.getName(), ability);
    }
    
    public static void removeAbility(final Player p) {
        Hability.powerMap.remove(p.getName());
    }
}
