package vvcraft.hecker.commands;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;

import vvcraft.hecker.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CommandsInfo extends ListenerAdapter{
	
	File file = new File("path");
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) 
	{
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		if(args[0].equalsIgnoreCase(Main.prefix + "info")) 
		{
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("Hecker");
			info.setDescription("its a simple bot =>");			
			info.setFooter("created by _vvcraft_#9523",event.getAuthor().getAvatarUrl());									
			info.addField("Use &help:","for commands",true).addField("Game played:",Main.GamePlayed,false);
			info.addField("", "", true).addField("", "", true).addField("", "", true);
			info.addField("", "", true).addField("", "", true).addField("", "", true);
			info.setColor(0xf45642);
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();			
		}
	}

}
