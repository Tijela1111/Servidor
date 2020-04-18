/*    */ package pvp.blatantmc.comandos;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class StaffChatCMD
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {
/* 14 */     if (!(sender instanceof Player)) {
/* 15 */       sender.sendMessage("§cApenas jogadores podem executar este comando!");
/* 16 */       return true;
/*    */     } 
/*    */     
/* 19 */     if (cmd.getName().equalsIgnoreCase("SC")) {
/* 20 */       Player p = (Player)sender;
/* 21 */       if (!p.hasPermission("simulator.staffchat")) {
/* 22 */         p.sendMessage("§c§lERRO §fVocê não tem permissão para executar este comando!");
/* 23 */         return true;
/*    */       } 
/*    */       
/* 26 */       if (a.length == 0) {
/* 27 */         p.sendMessage("§c§lSTAFFCHAT §fUtilize: /sc (mensagem)");
/* 28 */         return true;
/*    */       } 
/* 30 */       String msg = "";
/* 31 */       for (int i = 0; i < a.length; i++) {
/* 32 */         if (i == a.length - 1) {
/* 33 */           msg = String.valueOf(msg) + a[i];
/*    */         } else {
/* 35 */           msg = String.valueOf(msg) + a[i] + " ";
/*    */         } 
/*    */       } 
/* 38 */       for (Player s : Bukkit.getOnlinePlayers()) {
/* 39 */         if (s.hasPermission("simulator.staffchat")) {
/* 40 */           s.sendMessage("§e§l[SC] §r" + p.getDisplayName() + " §f» " + msg.replace("&", "§"));
/*    */         }
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 47 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Developer\Downloads\ZChatStaff.jar!\zekthor\sc\CommandSC.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */