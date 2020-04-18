package pvp.blatantmc.comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import pvp.blatantmc.sistemas.*;

public class FlyCMD implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("fly")) {
            if (p.hasPermission("simulator.fly")) {
                if (args.length == 0) {
                    if (!p.getAllowFlight()) {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.sendMessage("§a§lFLY §fVocê ativou seu fly!");
                    }
                    else {
                        p.setAllowFlight(false);
                        p.setFlying(false);
                        p.sendMessage("§c§lFLY §fVocê desativou seu fly!");
                    }
                }
                else {
                    final Player target = p.getServer().getPlayer(args[0]);
                    if (target != null) {
                        if (!target.getAllowFlight()) {
                            target.setAllowFlight(true);
                            target.setFlying(true);
                            target.sendMessage("§a§lFLY §fO jogador §a" + p.getDisplayName() + " §fativou seu fly.");
                            p.sendMessage("§a§lFLY §fVocê ativou o fly do jogador §7" + target.getDisplayName());
                        }
                        else {
                            target.setAllowFlight(false);
                            target.setAllowFlight(false);
                            target.setFlying(false);
                            target.sendMessage("§c§lFLY §fO jogador §c" + p.getDisplayName() + " §fdesativou seu fly!");
                            p.sendMessage("§c§lFLY §fVocê desativou o fly do jogador §c" + target.getDisplayName());
                        }
                    }
                    else {
                        p.sendMessage(ApiManager.jogadoroff);
                    }
                }
            }
            else {
                p.sendMessage(ApiManager.semperm);
            }
        }
        return false;
    }
}
