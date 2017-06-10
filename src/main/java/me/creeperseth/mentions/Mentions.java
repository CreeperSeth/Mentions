package me.creeperseth.mentions;
 
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
 
public class Mentions extends JavaPlugin implements Listener
{
 
    @Override
    public void onEnable()
    {
        this.getServer().getPluginManager().registerEvents(this, this);
    }
   
    @Override
    public void onDisable() 
    {  
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage().toLowerCase();
        for (Player player : this.getServer().getOnlinePlayers())
        {
            if (ChatColor.stripColor(message).contains("@" + player.getName().toLowerCase()))
            {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_PLING, SoundCategory.MASTER, 1337F, 0.9F);
            }
        }
    }
   
}