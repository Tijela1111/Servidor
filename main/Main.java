package pvp.blatantmc.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;

import pvp.blatantmc.comandos.AdminCMD;
import pvp.blatantmc.comandos.ApplyCMD;
import pvp.blatantmc.comandos.BroadcastCMD;
import pvp.blatantmc.comandos.BuildCMD;
import pvp.blatantmc.comandos.CageCMD;
import pvp.blatantmc.comandos.CaixaCMD;
import pvp.blatantmc.comandos.ChatCMD;
import pvp.blatantmc.comandos.ClearChatCMD;
import pvp.blatantmc.comandos.ClicktestCMD;
import pvp.blatantmc.comandos.DiscordCMD;
import pvp.blatantmc.comandos.FlyCMD;
import pvp.blatantmc.comandos.GamemodeCMD;
import pvp.blatantmc.comandos.InternetCMD;
import pvp.blatantmc.comandos.KitCMD;
import pvp.blatantmc.comandos.PingCMD;
import pvp.blatantmc.comandos.PvPCMD;
import pvp.blatantmc.comandos.RankCMD;
import pvp.blatantmc.comandos.RegrasCMD;
import pvp.blatantmc.comandos.ReportCMD;
import pvp.blatantmc.comandos.ScoreboardCMD;
import pvp.blatantmc.comandos.SetarenaCMD;
import pvp.blatantmc.comandos.SkitCMD;
import pvp.blatantmc.comandos.SpawnCMD;
import pvp.blatantmc.comandos.StaffChatCMD;
import pvp.blatantmc.comandos.StatusCMD;
import pvp.blatantmc.comandos.TagCMD;
import pvp.blatantmc.comandos.TellCMD;
import pvp.blatantmc.comandos.TpCMD;
import pvp.blatantmc.comandos.TwitterCMD;
import pvp.blatantmc.comandos.UncageCMD;
import pvp.blatantmc.comandos.XpCMD;
import pvp.blatantmc.comandos.YoutuberCMD;
import pvp.blatantmc.eventos.CombatLogEvent;
import pvp.blatantmc.eventos.DamageEvent;
import pvp.blatantmc.eventos.DeathEvent;
import pvp.blatantmc.eventos.DropEvent;
import pvp.blatantmc.eventos.NaturalEvent;
import pvp.blatantmc.eventos.NerfsEvent;
import pvp.blatantmc.eventos.PlayerEvent;
import pvp.blatantmc.eventos.SpamEvent;
import pvp.blatantmc.eventos.StarPlayerJoinEvent;
import pvp.blatantmc.eventos.TabEvent;
import pvp.blatantmc.guis.GuiCaixa;
import pvp.blatantmc.guis.GuiKits;
import pvp.blatantmc.guis.GuiKits2;
import pvp.blatantmc.guis.GuiLoja;
import pvp.blatantmc.guis.GuiWarps;
import pvp.blatantmc.guis.GuisEvent;
import pvp.blatantmc.kits.Avatar;
import pvp.blatantmc.kits.FisherMan;
import pvp.blatantmc.kits.Flash;
import pvp.blatantmc.kits.ForceField;
import pvp.blatantmc.kits.Gaara;
import pvp.blatantmc.kits.Gladiator;
import pvp.blatantmc.kits.HotPotato;
import pvp.blatantmc.kits.Infernor;
import pvp.blatantmc.kits.JellyFish;
import pvp.blatantmc.kits.Jumper;
import pvp.blatantmc.kits.Kangaroo;
import pvp.blatantmc.kits.Magma;
import pvp.blatantmc.kits.Monk;
import pvp.blatantmc.kits.Phantom;
import pvp.blatantmc.kits.Poseidon;
import pvp.blatantmc.kits.Shooter;
import pvp.blatantmc.kits.Stomper;
import pvp.blatantmc.kits.Terrorista;
import pvp.blatantmc.kits.Thor;
import pvp.blatantmc.kits.TimeLord;
import pvp.blatantmc.kits.Turtle;
import pvp.blatantmc.kits.Vacuum;
import pvp.blatantmc.kits.Viking;
import pvp.blatantmc.kits2.Ajnin;
import pvp.blatantmc.kits2.Hulk;
import pvp.blatantmc.kits2.Ninja;
import pvp.blatantmc.kits2.Pyro;
import pvp.blatantmc.kits2.Resouper;
import pvp.blatantmc.kits2.Viper_Snail;
import pvp.blatantmc.scoreboard.ScoreBoard;
import pvp.blatantmc.sistemas.ApiManager;
import pvp.blatantmc.sistemas.AutoMessages;
import pvp.blatantmc.sistemas.BlockJump;
import pvp.blatantmc.sistemas.Plugins;
import pvp.blatantmc.sistemas.SignRecraft;
import pvp.blatantmc.sistemas.SignSoups;
import pvp.blatantmc.warps.SetWarpEvent;
import pvp.blatantmc.warps.WarpEvent;


@SuppressWarnings({"all"})
public class Main extends JavaPlugin
{
    public static Plugin plugin;
    public static Main instance;
    public static Integer score;
    private AutoMessages AutoMessanger;
    public File statusfile;
    public YamlConfiguration status;
    public File warpsfile;
    public YamlConfiguration warps;
    public File arenasfile;
    public YamlConfiguration arenas;
    
    static {
        Main.score = null;
    }
    
    public void onLoad() {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player todos = onlinePlayers[i];
            ArrayList<String> msg = new ArrayList<>();
            msg.add("§e§lRESTART\n§fO servidor está reiniciando ou desligando.");
            todos.kickPlayer(String.valueOf(msg));
        }
    }
    
    public void onEnable() {
        Main.plugin = (Plugin)this;
        Main.instance = this;
        final File status = new File(this.getDataFolder(), "status.yml");
        if (!status.exists()) {
            this.saveResource("status.yml", false);
        }
        this.statusfile = new File(this.getDataFolder(), "status.yml");
        this.status = YamlConfiguration.loadConfiguration(this.statusfile);
        final File warps = new File(this.getDataFolder(), "warps.yml");
        if (!warps.exists()) {
            this.saveResource("warps.yml", false);
        }
        this.warpsfile = new File(this.getDataFolder(), "warps.yml");
        this.warps = YamlConfiguration.loadConfiguration(this.warpsfile);
        final File arenas = new File(this.getDataFolder(), "arenas.yml");
        if (!arenas.exists()) {
            this.saveResource("arenas.yml", false);
        }
        this.arenasfile = new File(this.getDataFolder(), "arenas.yml");
        this.arenas = YamlConfiguration.loadConfiguration(this.arenasfile);
        this.AutoMessanger = new AutoMessages();
        AutoMessages.start();
        this.save();
        this.Eventos();
        this.Comandos();
        this.Kits();
        this.Guis();
        this.saveDefaultConfig();
        ApiManager.novaReceita();
        Bukkit.getConsoleSender().sendMessage("§e§lPLUGIN §fO plugin foi ativado!");
        Main.score = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)getInstance(), (Runnable)new Runnable() {
            @Override
            public void run() {
                Player[] arrayOfPlayer;
                for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
                    final Player p = arrayOfPlayer[i];
                    if (ScoreboardCMD.ntemscore.contains(p.getName())) {
                        ScoreBoard.FlameScore(p);
                    }
                    if (ScoreboardCMD.temscore.contains(p.getName())) {
                        p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
                    }
                }
            }
        }, 1L, 200L);
    }
    
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§c§lPLUGIN §fO plugin foi desativado!");
    }
    
    public void Eventos() {
        final PluginManager evento = Bukkit.getPluginManager();
        evento.registerEvents((Listener)new DeathEvent(), (Plugin)this);
        evento.registerEvents((Listener)new SpamEvent(this), (Plugin)this);
        evento.registerEvents((Listener)new NaturalEvent(), (Plugin)this);
        evento.registerEvents((Listener)new NerfsEvent(), (Plugin)this);
        evento.registerEvents((Listener)new PlayerEvent(), (Plugin)this);
        evento.registerEvents((Listener)new DropEvent(), (Plugin)this);
        evento.registerEvents((Listener)new TabEvent(), (Plugin)this);
        evento.registerEvents((Listener)new DamageEvent(), (Plugin)this);
        evento.registerEvents((Listener)new BuildCMD(), (Plugin)this);
        evento.registerEvents((Listener)new AdminCMD(), (Plugin)this);
        evento.registerEvents((Listener)new GuiLoja(), (Plugin)this);
        evento.registerEvents((Listener)new BlockJump(), (Plugin)this);
        evento.registerEvents((Listener)new SignRecraft(), (Plugin)this);
        evento.registerEvents((Listener)new SignSoups(), (Plugin)this);
        evento.registerEvents((Listener)new ChatCMD(), (Plugin)this);
        evento.registerEvents((Listener)new CombatLogEvent(), (Plugin)this); 
        evento.registerEvents((Listener)new StarPlayerJoinEvent(), (Plugin)this); 
        evento.registerEvents(new Ninja(), this);
        evento.registerEvents(new Plugins(), this);
    }
    
    public void Comandos() {
        this.getCommand("fly").setExecutor((CommandExecutor)new FlyCMD());
        this.getCommand("report").setExecutor((CommandExecutor)new ReportCMD());
        this.getCommand("status").setExecutor((CommandExecutor)new StatusCMD());
        this.getCommand("regras").setExecutor((CommandExecutor)new RegrasCMD());
        this.getCommand("twitter").setExecutor((CommandExecutor)new TwitterCMD());
        this.getCommand("discord").setExecutor((CommandExecutor)new DiscordCMD());
        this.getCommand("cage").setExecutor((CommandExecutor)new CageCMD());
        this.getCommand("uncage").setExecutor((CommandExecutor)new UncageCMD());
        this.getCommand("sc").setExecutor((CommandExecutor)new StaffChatCMD());
        this.getCommand("internet").setExecutor((CommandExecutor)new InternetCMD());
        this.getCommand("ranks").setExecutor((CommandExecutor)new RankCMD());
        this.getCommand("xp").setExecutor((CommandExecutor)new XpCMD());
        this.getCommand("clicktest").setExecutor((CommandExecutor)new ClicktestCMD());
        this.getCommand("tp").setExecutor((CommandExecutor)new TpCMD());
        this.getCommand("ping").setExecutor((CommandExecutor)new PingCMD());
        this.getCommand("skit").setExecutor((CommandExecutor)new SkitCMD());
        this.getCommand("score").setExecutor((CommandExecutor)new ScoreboardCMD());
        this.getCommand("gm").setExecutor((CommandExecutor)new GamemodeCMD());
        this.getCommand("gamemode").setExecutor((CommandExecutor)new GamemodeCMD());
        this.getCommand("build").setExecutor((CommandExecutor)new BuildCMD());
        this.getCommand("admin").setExecutor((CommandExecutor)new AdminCMD());
        this.getCommand("pvp").setExecutor((CommandExecutor)new PvPCMD());
        this.getCommand("tag").setExecutor((CommandExecutor)new TagCMD());
        this.getCommand("setwarp").setExecutor((CommandExecutor)new SetWarpEvent());
        this.getCommand("warp").setExecutor((CommandExecutor)new WarpEvent());
        this.getCommand("aviso").setExecutor((CommandExecutor)new BroadcastCMD());
        this.getCommand("cc").setExecutor((CommandExecutor)new ClearChatCMD());
        this.getCommand("tell").setExecutor((CommandExecutor)new TellCMD());
        this.getCommand("chat").setExecutor((CommandExecutor)new ChatCMD());
        this.getCommand("aplicar").setExecutor((CommandExecutor)new ApplyCMD());
        this.getCommand("setarena").setExecutor((CommandExecutor)new SetarenaCMD());
        this.getCommand("caixa").setExecutor((CommandExecutor)new CaixaCMD());
        this.getCommand("spawn").setExecutor((CommandExecutor)new SpawnCMD());
        this.getCommand("youtuber").setExecutor((CommandExecutor)new YoutuberCMD());
    }
    
    public void Kits() {
        final PluginManager kits = Bukkit.getPluginManager();
        this.getCommand("kit").setExecutor((CommandExecutor)new KitCMD());
        kits.registerEvents((Listener)new Jumper(), (Plugin)this);
        kits.registerEvents((Listener)new Shooter(), (Plugin)this);
        kits.registerEvents((Listener)new TimeLord(), (Plugin)this);
        kits.registerEvents((Listener)new JellyFish(), (Plugin)this);
        kits.registerEvents((Listener)new FisherMan(), (Plugin)this);
        kits.registerEvents((Listener)new Magma(), (Plugin)this);
        kits.registerEvents((Listener)new Gladiator(), (Plugin)this);
        kits.registerEvents((Listener)new HotPotato(), (Plugin)this);
        kits.registerEvents((Listener)new ForceField(), (Plugin)this);
        kits.registerEvents((Listener)new Avatar(), (Plugin)this);
        kits.registerEvents((Listener)new Kangaroo(), (Plugin)this);
        kits.registerEvents((Listener)new Monk(), (Plugin)this);
        kits.registerEvents((Listener)new Stomper(), (Plugin)this);
        kits.registerEvents((Listener)new Thor(), (Plugin)this);
        kits.registerEvents((Listener)new Gaara(), (Plugin)this);
        kits.registerEvents((Listener)new Infernor(), (Plugin)this);
        kits.registerEvents((Listener)new Poseidon(), (Plugin)this);
        kits.registerEvents((Listener)new Phantom(), (Plugin)this);
        kits.registerEvents((Listener)new Viking(), (Plugin)this);
        kits.registerEvents((Listener)new Terrorista(), (Plugin)this);
        kits.registerEvents((Listener)new Flash(), (Plugin)this);
        kits.registerEvents((Listener)new Vacuum(), (Plugin)this);
        kits.registerEvents((Listener)new Turtle(), (Plugin)this);
        kits.registerEvents((Listener)new Ajnin(), (Plugin)this);
        kits.registerEvents((Listener)new Pyro(), (Plugin)this);
        kits.registerEvents((Listener)new Resouper(), (Plugin)this);
        kits.registerEvents((Listener)new Viper_Snail(), (Plugin)this);
        kits.registerEvents((Listener)new Hulk(), (Plugin)this);
    }
    
    public void Guis() {
        final PluginManager guis = Bukkit.getPluginManager();
        guis.registerEvents((Listener)new GuisEvent(), (Plugin)this);
        guis.registerEvents((Listener)new GuiKits(), (Plugin)this);
        guis.registerEvents((Listener)new GuiKits2(), (Plugin)this);
        guis.registerEvents((Listener)new GuiWarps(), (Plugin)this);
        guis.registerEvents((Listener)new GuiCaixa(), (Plugin)this);
    }
    
    public static Plugin getPlugin() {
        return Main.plugin;
    }
    
    public static Main getInstance() {
        return Main.instance;
    }
    
   
    
    public void save() {
        try {
            this.status.save(this.statusfile);
            this.warps.save(this.warpsfile);
            this.arenas.save(this.arenasfile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
