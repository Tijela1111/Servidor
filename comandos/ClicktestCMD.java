package pvp.blatantmc.comandos;

import java.util.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

import pvp.blatantmc.main.Main;

import org.bukkit.event.block.*;

public class ClicktestCMD implements CommandExecutor, Listener
{
    public static ArrayList<String> emclicktest;
    public static ArrayList<String> fazendoclicktest;
    
    static {
        ClicktestCMD.emclicktest = new ArrayList<String>();
        ClicktestCMD.fazendoclicktest = new ArrayList<String>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (!(sender instanceof Player)) {
            p.sendMessage("§c§lERRO §fApenas jogadores podem executar este comando!");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("clicktest")) {
            if (ClicktestCMD.fazendoclicktest.contains(p.getName())) {
                p.sendMessage("§cVoce j\u00e1 esta em clicktest");
                return true;
            }
            ClicktestCMD.fazendoclicktest.add(p.getName());
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§7ClickTest iniciando em §b5§7s");
                }
            }, 0L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§7ClickTest iniciando em §b4§7s");
                }
            }, 20L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§7ClickTest iniciando em §b3§7s");
                }
            }, 40L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§7ClickTest iniciando em §b2§7s");
                }
            }, 60L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§7ClickTest iniciando em §b1§7s");
                }
            }, 80L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§7ClickTest iniciado");
                    ClicktestCMD.emclicktest.add(p.getName());
                }
            }, 100L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    if (p.getLevel() >= 200) {
                        Bukkit.broadcast("§b" + p.getDisplayName() + " §7Pode estar de macro quantidade de clicks no clicktest: §b" + p.getLevel(), "flame.staff");
                        ClicktestCMD.emclicktest.remove(p.getName());
                        ClicktestCMD.fazendoclicktest.remove(p.getName());
                    }
                    p.sendMessage("§7ClickTest acabado quantidade de clicks §bABAIXO");
                    p.sendMessage("§7Quantidade de click(s) dado: §b" + p.getLevel());
                    ClicktestCMD.emclicktest.remove(p.getName());
                    ClicktestCMD.fazendoclicktest.remove(p.getName());
                    p.setLevel(0);
                }
            }, 250L);
        }
        return false;
    }
    
    @EventHandler
    public void comandos(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        if (ClicktestCMD.emclicktest.contains(p.getName()) && e.getMessage().startsWith("/")) {
            e.setCancelled(true);
            p.sendMessage("§7Voc\u00ea n\u00e3o pode digitar comandos quando estiver fazendo clicktest");
        }
    }
    
    @EventHandler
    public void click(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (ClicktestCMD.emclicktest.contains(p.getName()) && e.getAction() == Action.LEFT_CLICK_AIR) {
            p.setLevel(p.getLevel() + 1);
        }
    }
}
