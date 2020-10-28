package com.Lingyu.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPlugin;

import com.sun.xml.internal.ws.api.Cancelable;

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
    	getServer().getConsoleSender().sendMessage("Stamina is disable!");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
    	Bukkit.getServer().getScheduler().runTaskTimerAsynchronously(this, new Runnable() {
    		
            public void run() {
            	Player p = event.getPlayer();
            	while (p.isOnline()) {
                    if(p.isSprinting()) {
                    	p.setFoodLevel(p.getFoodLevel() - 1);
                    }
                    else {
						p.setFoodLevel(p.getFoodLevel() + 1);
                    }
                }
            }
        }, 40l,40l);
    }
}