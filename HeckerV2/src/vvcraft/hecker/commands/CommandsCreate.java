package vvcraft.hecker.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import vvcraft.hecker.Main;

public class CommandsCreate extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) 
	{
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		if(args[0].equalsIgnoreCase(Main.prefix + "creation")) 
		{
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("⏲️Creation Date:");		
			info.setDescription("the bot was created on 07/08/2021");
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();	
		}	
	}
}
