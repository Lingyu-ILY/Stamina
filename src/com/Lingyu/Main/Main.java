package com.Lingyu.Main;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	// Fired when plugin is enabled
    @Override
    public void onEnable() {
    	PluginManager pm = this.getServer().getPluginManager();
    	pm.registerEvents(this, this);
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	getServer().getConsoleSender().sendMessage("HungerLock is disable!");
    }
    

public void startTimer(Plugin plugin)
{
    GameTimer timer = new GameTimer();
    Bukkit.getServer().getScheduler().runTaskTimer(plugin, timer, 20, 20); // 20 ticks is 1 second
}
 
private class GameTimer implements Runnable
{
    int remainingTime = 2; // Seconds
 
    @Override
    public void run() {
    	Player player = (Player) player.getPlayer();
        if (remainingTime == 0)
        {
        	player.setFoodLevel(player.getFoodLevel() +1);
        }
        remainingTime -= 1;
}
}

    public void onPlayerRun(PlayerMoveEvent event) {
    	Player player = event.getPlayer();
    	if(player.isSprinting()) {
    		player.setFoodLevel(player.getFoodLevel() -1);
    	}
    	else
			player.setFoodLevel(player.getFoodLevel() +1);
    }
}