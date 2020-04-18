package pvp.blatantmc.warps;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import pvp.blatantmc.main.*;
import pvp.blatantmc.sistemas.*;

public class SetWarpEvent implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("setwarp") && p.hasPermission("simulator.setwarp") && args.length == 0) {
            p.sendMessage("§c§lSETWARP §fUtilize: /setwarp (nome)");
            return true;
        }
        if (args[0].equalsIgnoreCase("challenge")) {
            Main.getInstance().warps.set("challenge.x", (Object)p.getLocation().getX());
            Main.getInstance().warps.set("challenge.y", (Object)p.getLocation().getY());
            Main.getInstance().warps.set("challenge.z", (Object)p.getLocation().getZ());
            Main.getInstance().warps.set("challenge.pitch", (Object)p.getLocation().getPitch());
            Main.getInstance().warps.set("challenge.yaw", (Object)p.getLocation().getYaw());
            Main.getInstance().warps.set("challenge.world", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            p.sendMessage("§a§lSETWARP §fVocê setou a warp §aLava Challenge!");
            return true;
        }
        if (args[0].equalsIgnoreCase("fps")) {
            Main.getInstance().warps.set("fps.x", (Object)p.getLocation().getX());
            Main.getInstance().warps.set("fps.y", (Object)p.getLocation().getY());
            Main.getInstance().warps.set("fps.z", (Object)p.getLocation().getZ());
            Main.getInstance().warps.set("fps.pitch", (Object)p.getLocation().getPitch());
            Main.getInstance().warps.set("fps.yaw", (Object)p.getLocation().getYaw());
            Main.getInstance().warps.set("fps.world", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            p.sendMessage("§a§lSETWARP §fVocê setou a warp §aFps!");
            return true;
        }
        if (args[0].equalsIgnoreCase("knock")) {
            Main.getInstance().warps.set("knock.x", (Object)p.getLocation().getX());
            Main.getInstance().warps.set("knock.y", (Object)p.getLocation().getY());
            Main.getInstance().warps.set("knock.z", (Object)p.getLocation().getZ());
            Main.getInstance().warps.set("knock.pitch", (Object)p.getLocation().getPitch());
            Main.getInstance().warps.set("knock.yaw", (Object)p.getLocation().getYaw());
            Main.getInstance().warps.set("knock.world", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            p.sendMessage("§a§lSETWARP §fVocê setou a warp §aKnockback!");
            return true;
        }
        if (args[0].equalsIgnoreCase("main")) {
            Main.getInstance().warps.set("main.x", (Object)p.getLocation().getX());
            Main.getInstance().warps.set("main.y", (Object)p.getLocation().getY());
            Main.getInstance().warps.set("main.z", (Object)p.getLocation().getZ());
            Main.getInstance().warps.set("main.pitch", (Object)p.getLocation().getPitch());
            Main.getInstance().warps.set("main.yaw", (Object)p.getLocation().getYaw());
            Main.getInstance().warps.set("main.world", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            p.sendMessage("§a§lSETWARP §fVocê setou a warp §aMain!");
            return true;
        }
        if (args[0].equalsIgnoreCase("bolota")) {
            Main.getInstance().warps.set("bolota.x", (Object)p.getLocation().getX());
            Main.getInstance().warps.set("bolota.y", (Object)p.getLocation().getY());
            Main.getInstance().warps.set("bolota.z", (Object)p.getLocation().getZ());
            Main.getInstance().warps.set("bolota.pitch", (Object)p.getLocation().getPitch());
            Main.getInstance().warps.set("bolota.yaw", (Object)p.getLocation().getYaw());
            Main.getInstance().warps.set("bolota.world", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            p.sendMessage("§a§lSETWARP §fVocê setou a warp §aBolota!");
            return true;
        }
        if (args[0].equalsIgnoreCase("potionpvp")) {
            Main.getInstance().warps.set("potionpvp.x", (Object)p.getLocation().getX());
            Main.getInstance().warps.set("potionpvp.y", (Object)p.getLocation().getY());
            Main.getInstance().warps.set("potionpvp.z", (Object)p.getLocation().getZ());
            Main.getInstance().warps.set("potionpvp.pitch", (Object)p.getLocation().getPitch());
            Main.getInstance().warps.set("potionpvp.yaw", (Object)p.getLocation().getYaw());
            Main.getInstance().warps.set("potionpvp.world", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            p.sendMessage("§a§lSETWARP §fVocê setou a warp §aPotionPvP!");
            return true;
        }
        if (args[0].equalsIgnoreCase("spawn")) {
            Main.getInstance().getConfig().set("spawn.x", (Object)p.getLocation().getX());
            Main.getInstance().getConfig().set("spawn.y", (Object)p.getLocation().getY());
            Main.getInstance().getConfig().set("spawn.z", (Object)p.getLocation().getZ());
            Main.getInstance().getConfig().set("spawn.pitch", (Object)p.getLocation().getPitch());
            Main.getInstance().getConfig().set("spawn.yaw", (Object)p.getLocation().getYaw());
            Main.getInstance().getConfig().set("spawn.world", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().saveConfig();
            p.sendMessage("§a§lSETWARP §fVocê setou o §aSpawn!");
            p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
            return true;
        }
        return false;
    }
}
