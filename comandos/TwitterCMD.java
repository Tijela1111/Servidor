package pvp.blatantmc.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class TwitterCMD implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cApenas jogadores podem executar este comando!");
			return true;
		} else {
			TextComponent twitter = new TextComponent("§7@BlatantMC");
			twitter.setColor(ChatColor.YELLOW);
			twitter.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://twitter.com/BlatantMC"));
			twitter.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
					new ComponentBuilder("§aClique para abrir o twitter.").create()));

			sender.sendMessage("");
			sender.sendMessage("§e§lTWITTER DO SERVIDOR");
			p.spigot().sendMessage(twitter);
			sender.sendMessage("");
		}
		return false;
	}

}