package me.jerryz.coreplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Modelo implements CommandExecutor{

	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof ConsoleCommandSender) {
			sender.sendMessage("Apenas jogadores podem executar esse comando.");
		}
		
		Player p = (Player) sender;
		
		
		return false;
	}

}
