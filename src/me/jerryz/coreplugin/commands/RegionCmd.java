package me.jerryz.coreplugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.jerryz.coreplugin.api.CoreAPI;
import me.jerryz.coreplugin.regions.Region;
import net.md_5.bungee.api.ChatColor;

public class RegionCmd implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof ConsoleCommandSender) {
			sender.sendMessage("Apenas jogadores podem executar esse comando");
		}
		
		Player p = (Player) sender;
		
		if(args.length == 0) {
			p.sendMessage(ChatColor.YELLOW + "Digite /region help para mais ajuda");
		}
		if(args.length >= 1) {
			
			if(args[0].equalsIgnoreCase("help")) {
				p.sendMessage(ChatColor.AQUA + "-------- Region Help --------");
				p.sendMessage("");
				p.sendMessage(ChatColor.AQUA + "/region criar <nome> - Cria uma região");
				p.sendMessage(ChatColor.AQUA + "/region list - Lista todas as regiões");
				p.sendMessage(ChatColor.AQUA + "/region setspawn <nome> - Seta o spawn da região");
				p.sendMessage(ChatColor.AQUA + "/region setpvp <nome> <on/off> - Ativa/Desativa o PVP na região");
				p.sendMessage(ChatColor.AQUA + "/region addbuild <nome> <id> - Adiciona o bloco para a lista de blocos permitidos para construir");
				p.sendMessage(ChatColor.AQUA + "/region addbreak <nome> <id> - Adiciona o bloco para a lista de blocos permitidos para quebrar");
				p.sendMessage(ChatColor.AQUA + "/region addinteract <nome> <id> - Adiciona o bloco para a lista de blocos permitidos para interagir");
				p.sendMessage(ChatColor.AQUA + "/region delete <nome> - Deleta a região");
				p.sendMessage("");
			}
			
			if(args[0].equalsIgnoreCase("criar")) {
					
				if(args.length == 2) {
					CoreAPI.createRegion(args[1]);
					p.sendMessage(ChatColor.GREEN + "Região " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " criada com sucesso");
				}else {
					p.sendMessage(ChatColor.YELLOW + "Use /region criar <nome>");
				}
			}
			
			if(args[0].equalsIgnoreCase("list")) {
				
				p.sendMessage(ChatColor.AQUA + "-------- Lista de Regiões --------");
				
				for(Region r : CoreAPI.getAllRegions()) {
					p.sendMessage(ChatColor.YELLOW + "- " + ChatColor.GRAY + r.getRegion());
				}
			}
			
			if(args[0].equalsIgnoreCase("setspawn")) {
				if(args.length == 2) {
					if(CoreAPI.getRegion(args[1]) == null) {
						p.sendMessage(ChatColor.RED + "A Região" + args[1] + " não existe");
					}
						CoreAPI.getRegion(args[1]).setSpawnLocation(p.getLocation());
						p.sendMessage(ChatColor.GREEN + "Spawn configurado com sucesso");
				}else {
					p.sendMessage(ChatColor.YELLOW + "Use /region setspawn <nome>");
				}
			}
			
			if(args[0].equalsIgnoreCase("setpvp")) {
				if(args.length == 3) {
					if(CoreAPI.getRegion(args[1]) == null) {
						p.sendMessage(ChatColor.RED + "A Região" + args[1] + " não existe");
					}
					if(!args[2].equalsIgnoreCase("on") || !args[2].equalsIgnoreCase("off")) {
						p.sendMessage(ChatColor.YELLOW + "Use /region setpvp <nome> <on/off>");
					}
					
					if(args[2].equalsIgnoreCase("on")){
						CoreAPI.getRegion(args[1]).setCanPvp(true);
					}
					if(args[2].equalsIgnoreCase("off")){
						CoreAPI.getRegion(args[1]).setCanPvp(false);
					}
					
					
					CoreAPI.getRegion(args[1]).setSpawnLocation(p.getLocation());
						p.sendMessage(ChatColor.GREEN + "Spawn configurado com sucesso");
				}else {
					p.sendMessage(ChatColor.YELLOW + "Use /region setpvp <nome> <on/off>");
				}
			}
			
			if(args[0].equalsIgnoreCase("addbuild")) {
				if(args.length == 3) {
					if(CoreAPI.getRegion(args[1]) == null) {
						p.sendMessage(ChatColor.RED + "A Região" + args[1] + " não existe");
					}
					int id = 1;
					try {
						id = Integer.parseInt(args[2]);
					}catch(Exception e) {
						p.sendMessage(ChatColor.RED + "Use apenas números no campo <id>");
					}
					CoreAPI.getRegion(args[1]).addCanBuild(Material.getMaterial(id));
				}
				if(args.length == 2) {
					if(CoreAPI.getRegion(args[1]) == null) {
						p.sendMessage(ChatColor.RED + "A Região" + args[1] + " não existe");
					}
					if(p.getInventory().getItemInHand() == null) {
						p.sendMessage(ChatColor.RED + "Você não possui nenhum item na mão");

					}else {
						CoreAPI.getRegion(args[1]).addCanBuild(p.getInventory().getItemInHand().getType());
					}
					
				}
			}
			
			if(args[0].equalsIgnoreCase("addinteract")) {
				if(args.length == 3) {
					if(CoreAPI.getRegion(args[1]) == null) {
						p.sendMessage(ChatColor.RED + "A Região" + args[1] + " não existe");
					}
					int id = 1;
					try {
						id = Integer.parseInt(args[2]);
					}catch(Exception e) {
						p.sendMessage(ChatColor.RED + "Use apenas números no campo <id>");
					}
					CoreAPI.getRegion(args[1]).addCanInteract(Material.getMaterial(id));
				}				if(args.length == 2) {
					if(CoreAPI.getRegion(args[1]) == null) {
						p.sendMessage(ChatColor.RED + "A Região" + args[1] + " não existe");
					}
					if(p.getInventory().getItemInHand() == null) {
						p.sendMessage(ChatColor.RED + "Você não possui nenhum item na mão");

					}else {
						CoreAPI.getRegion(args[1]).addCanBuild(p.getInventory().getItemInHand().getType());
					}
					
				}
			}
			
			if(args[0].equalsIgnoreCase("addbreak")) {
				if(args.length == 3) {
					if(CoreAPI.getRegion(args[1]) == null) {
						p.sendMessage(ChatColor.RED + "A Região" + args[1] + " não existe");
					}
					int id = 1;
					try {
						id = Integer.parseInt(args[2]);
					}catch(Exception e) {
						p.sendMessage(ChatColor.RED + "Use apenas números no campo <id>");
					}
					CoreAPI.getRegion(args[1]).addCanBuild(Material.getMaterial(id));
				}				if(args.length == 2) {
					if(CoreAPI.getRegion(args[1]) == null) {
						p.sendMessage(ChatColor.RED + "A Região" + args[1] + " não existe");
					}
					if(p.getInventory().getItemInHand() == null) {
						p.sendMessage(ChatColor.RED + "Você não possui nenhum item na mão");

					}else {
						CoreAPI.getRegion(args[1]).addCanBuild(p.getInventory().getItemInHand().getType());
					}
					
				}
			}	
					
			if(args[0].equalsIgnoreCase("delete")) {
				
				if(args.length == 2) {
					if(CoreAPI.getRegion(args[1]) == null) {
						p.sendMessage(ChatColor.RED + "A Região" + args[1] + " não existe");
					}
					CoreAPI.deleteRegion(args[1]);
					p.sendMessage(ChatColor.GREEN + "A Região " + args[1] + " foi deletada");
				}else {
					p.sendMessage(ChatColor.YELLOW + "Use /region delete <nome>");
				}
			}		
					
		}
		
		
		
		return false;
	}
	
	

}
