package pvp.blatantmc.sistemas;

import org.bukkit.*;

import pvp.blatantmc.main.*;

import java.util.*;

public class AutoMessages
{
    public static void start() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, (Runnable)new Runnable() {
            String[] msg = { String.valueOf(ApiManager.preffix) + ApiManager.AutoM1, String.valueOf(ApiManager.preffix) + ApiManager.AutoM2, String.valueOf(ApiManager.preffix) + ApiManager.AutoM3, String.valueOf(ApiManager.preffix) + ApiManager.AutoM4, String.valueOf(ApiManager.preffix) + ApiManager.AutoM5 };
            
            @Override
            public void run() {
                Bukkit.getServer().broadcastMessage(this.msg[new Random().nextInt(this.msg.length)]);
            }
        }, 0L, 420L);
    }
}
