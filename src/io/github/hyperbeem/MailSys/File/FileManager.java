package io.github.hyperbeem.MailSys.File;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

//import org.bukkit.Bukkit;
//import java.util.logging.Logger;

//import org.bukkit.entity.*;


public class FileManager {

	public static String _Path = "/MailData/";
	
	//private void PlayerFile() {
	//	
	//}
	
	public static void CreateMailFolders() {
		
		File MailDir;
		try {
			MailDir = new File(Bukkit.getServer().getPluginManager().getPlugin("MailSys").getDataFolder(), File.separator + "MailData");
			if(!MailDir.exists()){
				System.out.println("Creating the Mail directory! YAY :)");
				MailDir.mkdirs();
			}
		} catch(SecurityException e){
			System.out.println("SecurityException when creating the mail direcory! Do you have the correct permissions?");
			return;
		}
	}
	
	public static boolean HasFile(UUID uuid) {
		File PlayerFile = new File(Bukkit.getServer().getPluginManager().getPlugin("MailSys").getDataFolder() + _Path + (uuid).toString() + ".yml");
		if(!PlayerFile.exists()){
			return false;
		} else {
			return true;
		}
	}
	
	public static void CreatePlayerFile(UUID uuid) throws IOException {
		File PlayerFile;
		try {
			PlayerFile = new File(Bukkit.getServer().getPluginManager().getPlugin("MailSys").getDataFolder() + _Path + uuid.toString() + ".yml");
			if(!PlayerFile.exists()){
				System.out.println("Creating new mailbox for " + uuid.toString());
				PlayerFile.createNewFile();
				} 
		}catch(SecurityException e){
			System.out.println("SecurityException when creating the mail direcory! Do you have the correct permissions?");
			return;
		}
		FileConfiguration Pdata = YamlConfiguration.loadConfiguration(PlayerFile);
		
		Pdata.set("UUID", uuid.toString());
		
		try{
			Pdata.save(PlayerFile);
		} catch (IOException e) {
			System.out.println("Error writing to file " + uuid.toString());
		}
	}
}
