package pvp.blatantmc.comandos;

import org.bukkit.event.*;
import org.bukkit.inventory.*;

import pvp.blatantmc.main.Main;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import java.util.*;

public class SkitCMD implements Listener, CommandExecutor
{
    public HashMap<String, ItemStack[]> kits;
    public HashMap<String, ItemStack[]> armor;
    
    public SkitCMD() {
        this.kits = new HashMap<String, ItemStack[]>();
        this.armor = new HashMap<String, ItemStack[]>();
    }
    
    public boolean isInt(final String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException ex) {
            return false;
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem executar este comando!");
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("skit")) {
            if (!p.hasPermission("simulator.skit")) {
                p.sendMessage(ChatColor.RED + "§c§lERRO §fVocê não tem permissão para executar este comando!");
                p.playSound(p.getLocation(), Sound.LAVA_POP, 15.0f, 1.0f);
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("§c§lSKIT §fUtilize: /skit (criar) (aplicar) (nome) (distância)");
                return true;
            }
            if (args[0].equalsIgnoreCase("criar")) {
                if (args.length == 1) {
                    p.sendMessage("§c§lSKIT §fUtilize: /skit <criar> <nome>");
                    return true;
                }
                final String name = args[1];
                this.kits.put(name, p.getInventory().getContents());
                this.armor.put(name, p.getInventory().getArmorContents());
                p.sendMessage(String.valueOf("§a§lSKIT §fVocê criou o kit §a" + args[1] + "§a!"));
                return true;
            }
            else if (args[0].equalsIgnoreCase("aplicar")) {
                if (args.length <= 2) {
                    p.sendMessage(String.valueOf("§c§lSKIT §fUtilize:/skit <aplicar> <nome> <distancia>"));
                    return true;
                }
                final String name = args[1];
                if (!this.kits.containsKey(name) && !this.armor.containsKey(name)) {
                    p.sendMessage("§a§lSKIT §fO kit §a" + name + "§f não foi encontrado!");
                    return true;
                }
                if (this.isInt(args[2])) {
                    final int numero = Integer.parseInt(args[2]);
                    for (final Entity ent : p.getNearbyEntities((double)numero, (double)numero, (double)numero)) {
                        if (ent instanceof Player) {
                            final Player p2 = (Player)ent;
                            p2.getInventory().setArmorContents((ItemStack[])this.armor.get(name));
                            p2.getInventory().setContents((ItemStack[])this.kits.get(name));
                        }
                    }
                    Bukkit.getServer().broadcastMessage("§e§lSKIT §fO kit §e" + name + "§f foi aplicado para jogadores em um raio de §e" + numero + "§f blocos do staffer §e" + p.getName());
                    return true;
                }
                return true;
            }
        }
        return true;
    }
}
