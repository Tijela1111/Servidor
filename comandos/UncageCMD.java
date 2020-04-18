package pvp.blatantmc.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UncageCMD implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cApenas jogadores podem executar este comando!");
			return true;
		} else {
			if (!sender.hasPermission("simulator.uncage")) {
				sender.sendMessage("§c§lERRO §fVocê não tem permissão para executar este comando!");
				return true;
			} else {
				if (args.length == 0) {
					sender.sendMessage("§c§lUNCAGE §fUtilize: /uncage (nick)");
					return true;
				}
				if (args.length == 1) {
					if (!CageCMD.cage.containsKey(Bukkit.getPlayerExact(args[0]))) {
						sender.sendMessage("§c§lUNCAGE §fEsse jogador não está em uma cage.");
						return true;
					}
					if (Bukkit.getPlayerExact(args[0]) != null) {
					CageCMD.cage.remove(Bukkit.getPlayerExact(args[0]));
					Bukkit.getPlayerExact(args[0]).chat("/spawn");
					sender.sendMessage("§a§lUNCAGE §fVocê liberou o jogador §a"+ Bukkit.getPlayerExact(args[0]).getName() + " §fda cage.");		
					} else {
						sender.sendMessage("§c§lERRO §fO jogador está offline!");
					}
				}

			}
		}
		return false;
	}

}
