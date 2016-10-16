package io.github.hyperbeem.MailSys;

import java.util.HashMap;
import java.util.UUID;

//import org.bukkit.Bukkit;
import org.bukkit.block.Block;
//import org.bukkit.command.Command;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
//import org.bukkit.entity.Player;
//import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.hyperbeem.MailSys.Events.JoinEvent;
import io.github.hyperbeem.MailSys.File.FileManager;

public class Core extends JavaPlugin{
	
	public static String plugin_name = "Mail";
	public static String PERMISSION_NODE = plugin_name + ".";
	public static String plugin_command_lable = "/" + plugin_name.toLowerCase();
	public static String plugin_version = "0.0.0.1";
	public static Core plugin;
	
	public HashMap<Block, UUID> mail_boxes = new HashMap<>();
	public HashMap<ArmorStand, UUID> mail_box_stands = new HashMap<>();
	
	FileConfiguration cf = getConfig();
	
	
	public static Core getInstance(){
		return plugin;
	}
	
	@Override
	public void onEnable(){
		
		plugin = this;
		this.getConfig();
		cf.addDefault("YouAreAwesome", true);
		cf.options().copyDefaults(true);
		saveConfig();
		
		FileManager.CreateMailFolders();
		
		this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
	}
	
	@Override
	public void onDisable(){
		
	}

	
	
}
