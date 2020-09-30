package com.Lingyu.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
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
    	getServer().getConsoleSender().sendMessage("Stamina is disable!");
    }

    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        Bukkit.getScheduler().runTaskLaterAsynchronously(this, new Runnable() {
           
            @Override
            public void run() {
                while(p.isOnline()) {
                    if(p.isSprinting()) {
                    	p.setFoodLevel(p.getFoodLevel() -1);
                    }
                    else {
						p.setFoodLevel(p.getFoodLevel() +1);
					}
                }
            }
        }, 40l);
    }
}