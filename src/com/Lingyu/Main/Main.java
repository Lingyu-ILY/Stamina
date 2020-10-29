package com.Lingyu.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

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
    	new BukkitRunnable() {
    		
            public void run() {
            	Player p = event.getPlayer();
            	int pfl = p.getFoodLevel();
            		if(!p.isOnline()) {
            			this.cancel();
            		}
                    if(p.isSprinting()) {
                    	p.setFoodLevel(pfl - 1);
                    }
                    else {
                    	if(pfl < 19)
                    		p.setFoodLevel(pfl + 1);
                    }
            }
        }.runTaskTimerAsynchronously(this, 40l,20l);
    }
}