package vvcraft.hecker.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import vvcraft.hecker.Main;

public class CommandsInvite extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) 
	{
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		if(args[0].equalsIgnoreCase(Main.prefix + "invite")) 
		{
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("Invite:");		
			info.setDescription("Link: https://discord.com/api/oauth2/authorize?client_id=873932640963686422&permissions=0&scope=bot");
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();	
		}	
	}
}
