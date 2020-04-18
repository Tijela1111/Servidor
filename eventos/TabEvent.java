package pvp.blatantmc.eventos;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.ProtocolInjector;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PlayerConnection;
import pvp.blatantmc.main.Main;

public class TabEvent implements Listener {
	private static int VERSION = 47;

	@EventHandler
	void TabDoServidor(PlayerJoinEvent evento) {
		final Player jogador = evento.getPlayer();
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			public void run() {

				PlayerConnection connect = ((CraftPlayer) jogador).getHandle().playerConnection;
				IChatBaseComponent top = ChatSerializer.a(
						"{'extra': [{text: '', color: 'aqua'}],'color': gold, 'text': ' §6§lBLATANT§f§lMC\n   '}");

				IChatBaseComponent bottom = ChatSerializer
						.a("{'extra': [{'color': 'aqua', 'text': ' \n        §fDiscord:§6 https://discord.gg/Pm5ksC \n§fTwitter: §6@BlatantMC \n§fIP: §6blatantmc.tk\n \n§7Problemas de Internet? Utilize: /internet"
								+ "', 'underline': 'true'}], 'color': 'gold', 'text': ''}");
				if (((CraftPlayer) jogador).getHandle().playerConnection.networkManager.getVersion() < TabEvent.VERSION) {
					return;
				}
				connect.sendPacket(new ProtocolInjector.PacketTabHeader(top, bottom));
			}
		}, 1L, 20L);
	}
}