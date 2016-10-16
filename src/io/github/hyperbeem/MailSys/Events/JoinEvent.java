package io.github.hyperbeem.MailSys.Events;

import io.github.hyperbeem.MailSys.File.FileManager;

import java.io.IOException;
import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{
	
    @EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent e) throws IOException{
    	
		UUID p = e.getPlayer().getUniqueId();
		
		if (FileManager.HasFile(p)) {
			// Do some loading shit
		} else {
			FileManager.CreatePlayerFile(p);
		}
		
		//TODO: if the player has a UUID file
	}
}
