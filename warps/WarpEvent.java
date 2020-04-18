package pvp.blatantmc.warps;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.*;

import pvp.blatantmc.main.*;
import pvp.blatantmc.sistemas.*;

import org.bukkit.*;

public class WarpEvent implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("warp") && args.length == 0) {
            p.sendMessage(String.valueOf(ApiManager.preffix) + "§cComando incorreto, utilize: §7/warp (nome)");
            return true;
        }
        if (args[0].equalsIgnoreCase("challenge")) {
            if (Main.getInstance().warps.getConfigurationSection("challenge") == null) {
                p.sendMessage("§c§lCHALLENGE §fA warp lava challenge não foi setada!");
                return true;
            }
            final World w = Bukkit.getServer().getWorld(Main.getInstance().warps.getString("challenge.world"));
            final double x = Main.getInstance().warps.getDouble("challenge.x");
            final double y = Main.getInstance().warps.getDouble("challenge.y");
            final double z = Main.getInstance().warps.getDouble("challenge.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Main.getInstance().warps.getDouble("challenge.pitch"));
            lobby.setYaw((float)Main.getInstance().warps.getDouble("challenge.yaw"));
            p.teleport(lobby);
            Hability.setAbility(p, "Challenge");
            p.getInventory().clear();
            p.sendMessage("§a§lCHALLENGE §fVocê foi teleportado para a warp §aLava Challenge!");
            WarpAPI.setWarp(p, "Challenge");
            p.setFireTicks(0);
            p.setGameMode(GameMode.SURVIVAL);
            ApiManager.darSopa(p, 36);
            ApiManager.tirarEfeitos(p);
            ApiManager.tirarArmadura(p);
            p.setAllowFlight(false);
            p.updateInventory();
            return true;
        }
        else if (args[0].equalsIgnoreCase("fps")) {
            if (Main.getInstance().warps.getConfigurationSection("fps") == null) {
            	p.sendMessage("§c§lFPS §fA warp fps não foi setada!");
                return true;
            }
            final World w = Bukkit.getServer().getWorld(Main.getInstance().warps.getString("fps.world"));
            final double x = Main.getInstance().warps.getDouble("fps.x");
            final double y = Main.getInstance().warps.getDouble("fps.y");
            final double z = Main.getInstance().warps.getDouble("fps.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Main.getInstance().warps.getDouble("fps.pitch"));
            lobby.setYaw((float)Main.getInstance().warps.getDouble("fps.yaw"));
            p.teleport(lobby);
            Hability.setAbility(p, "Fps");
            p.getInventory().clear();
            p.setHealth(20.0);
            p.sendMessage("§a§lFPS §fVocê foi teleportado para a warp §aFps!");
            WarpAPI.setWarp(p, "Fps");
            p.setFireTicks(0);
            ApiManager.darItem(p, Material.STONE_SWORD, 1, "§aEspada", 0);
            ApiManager.darSopa(p, 35);
            p.setGameMode(GameMode.SURVIVAL);
            ApiManager.tirarEfeitos(p);
            ApiManager.tirarArmadura(p);
            p.setAllowFlight(false);
            p.updateInventory();
            return true;
        }
        else if (args[0].equalsIgnoreCase("main")) {
            if (Main.getInstance().warps.getConfigurationSection("main") == null) {
            	p.sendMessage("§c§lMAIN §fA warp main não foi setada!");
                return true;
            }
            final World w = Bukkit.getServer().getWorld(Main.getInstance().warps.getString("main.world"));
            final double x = Main.getInstance().warps.getDouble("main.x");
            final double y = Main.getInstance().warps.getDouble("main.y");
            final double z = Main.getInstance().warps.getDouble("main.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Main.getInstance().warps.getDouble("main.pitch"));
            lobby.setYaw((float)Main.getInstance().warps.getDouble("main.yaw"));
            p.teleport(lobby);
            Hability.setAbility(p, "Main");
            p.getInventory().clear();
            p.sendMessage("§a§lMAIN §fVocê foi teleportado para a warp §aMain!");
            p.setGameMode(GameMode.SURVIVAL);
            WarpAPI.setWarp(p, "Main");
            p.setFireTicks(0);
            p.setHealth(20.0);
            ApiManager.darItemEnchant(p, Material.DIAMOND_SWORD, 1, "§aEspada", 0, Enchantment.DAMAGE_ALL, 1, true);
            p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
            p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 0));
            ApiManager.darSopa(p, 34);
            p.setAllowFlight(false);
            p.updateInventory();
            return true;
        }
        else if (args[0].equalsIgnoreCase("knock")) {
            if (Main.getInstance().warps.getConfigurationSection("knock") == null) {
            	p.sendMessage("§c§lKNOCKBACK §fA warp knockback não foi setada!");
                return true;
            }
            final World w = Bukkit.getServer().getWorld(Main.getInstance().warps.getString("knock.world"));
            final double x = Main.getInstance().warps.getDouble("knock.x");
            final double y = Main.getInstance().warps.getDouble("knock.y");
            final double z = Main.getInstance().warps.getDouble("knock.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Main.getInstance().warps.getDouble("knock.pitch"));
            lobby.setYaw((float)Main.getInstance().warps.getDouble("knock.yaw"));
            p.teleport(lobby);
            Hability.setAbility(p, "Knockback");
            p.getInventory().clear();
            p.setGameMode(GameMode.SURVIVAL);
            p.sendMessage("§a§lKNOCKBACK §fVocê foi teleportado para a warp §aKnockback!");
            WarpAPI.setWarp(p, "Knock");
            p.setFireTicks(0);
            p.setHealth(20.0);
            ApiManager.darSopa(p, 35);
            ApiManager.darItemEnchant(p, Material.STICK, 1, "§aGraveto", 0, Enchantment.KNOCKBACK, 1, true);
            ApiManager.tirarEfeitos(p);
            ApiManager.tirarArmadura(p);
            p.setAllowFlight(false);
            p.updateInventory();
            return true;
        }
        else if (args[0].equalsIgnoreCase("bolota")) {
            if (Main.getInstance().warps.getConfigurationSection("bolota") == null) {
            	p.sendMessage("§c§lBOLOTA §fA warp bolota não foi setada!");
                return true;
            }
            final World w = Bukkit.getServer().getWorld(Main.getInstance().warps.getString("bolota.world"));
            final double x = Main.getInstance().warps.getDouble("bolota.x");
            final double y = Main.getInstance().warps.getDouble("bolota.y");
            final double z = Main.getInstance().warps.getDouble("bolota.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Main.getInstance().warps.getDouble("bolota.pitch"));
            lobby.setYaw((float)Main.getInstance().warps.getDouble("bolota.yaw"));
            p.teleport(lobby);
            Hability.setAbility(p, "Bolota");
            p.getInventory().clear();
            p.setHealth(20.0);
            p.sendMessage("§a§lBOLOTA §fVocê foi teleportado para a warp §aBolota!");
            WarpAPI.setWarp(p, "Bolota");
            p.setFireTicks(0);
            ApiManager.darItem(p, Material.STONE_SWORD, 1, "§aEspada", 0);
            ApiManager.darSopa(p, 35);
            p.setGameMode(GameMode.SURVIVAL);
            ApiManager.tirarEfeitos(p);
            ApiManager.tirarArmadura(p);
            p.setAllowFlight(false);
            p.updateInventory();
            return true;
        }
        else if (args[0].equalsIgnoreCase("potionpvp")) {
            if (Main.getInstance().warps.getConfigurationSection("potionpvp") == null) {
            	p.sendMessage("§c§lPOTIONPVP §fA warp potionpvp não foi setada!");
                return true;
            }
            final World w = Bukkit.getServer().getWorld(Main.getInstance().warps.getString("potionpvp.world"));
            final double x = Main.getInstance().warps.getDouble("potionpvp.x");
            final double y = Main.getInstance().warps.getDouble("potionpvp.y");
            final double z = Main.getInstance().warps.getDouble("potionpvp.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Main.getInstance().warps.getDouble("potionpvp.pitch"));
            lobby.setYaw((float)Main.getInstance().warps.getDouble("potionpvp.yaw"));
            p.teleport(lobby);
            Hability.setAbility(p, "PotionPvP");
            p.getInventory().clear();
            p.sendMessage("§a§lPOTIONPVP §fVocê foi teleportado para a warp §aPotionPvP!");
            p.setGameMode(GameMode.SURVIVAL);
            WarpAPI.setWarp(p, "PotionPvP");
            p.setFireTicks(0);
            p.setHealth(20.0);
            ApiManager.darItemEnchant(p, Material.DIAMOND_SWORD, 1, "§aEspada", 0, Enchantment.DAMAGE_ALL, 1, true);
            p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
            p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
            ItemStack sopa = new ItemStack(Material.POTION, 1, (short)16421);
            ItemMeta sopas = sopa.getItemMeta();
            sopas.setDisplayName("§dPoção de cura");
            sopa.setItemMeta(sopas);
            for (int i = 0; i <= 34; i++) {
            p.getInventory().addItem(new ItemStack[] { sopa });
            }
            p.setAllowFlight(false);
            p.updateInventory();
            return true;
        }
        else {
            if (!args[0].equalsIgnoreCase("spawn")) {
                return false;
            }
            if (Main.getInstance().getConfig().getConfigurationSection("spawn") == null) {
            	p.sendMessage("§c§lSPAWN §fO spawn ainda não foi setado!");
                return true;
            }
            final World w = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("spawn.world"));
            final double x = Main.getInstance().getConfig().getDouble("spawn.x");
            final double y = Main.getInstance().getConfig().getDouble("spawn.y");
            final double z = Main.getInstance().getConfig().getDouble("spawn.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Main.getInstance().getConfig().getDouble("spawn.pitch"));
            lobby.setYaw((float)Main.getInstance().getConfig().getDouble("spawn.yaw"));
            p.teleport(lobby);
            p.getInventory().clear();
            Hability.removeAbility(p);
            p.sendMessage("§a§lSPAWN §fVocê foi teleportado para o §aSpawn!");
            WarpAPI.removeWarp(p);
            ApiManager.ItemServer(p);
            p.setExp(0.0f);
            p.setExhaustion(20.0f);
            p.setHealth(20.0);
            p.setFireTicks(0);
            ApiManager.tirarEfeitos(p);
            ApiManager.tirarArmadura(p);
            p.setGameMode(GameMode.ADVENTURE);
            p.setAllowFlight(false);
            p.updateInventory();
            return true;
        }
    }
}
