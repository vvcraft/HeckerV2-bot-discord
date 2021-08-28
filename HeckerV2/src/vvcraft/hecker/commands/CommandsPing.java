package vvcraft.hecker.commands;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import vvcraft.hecker.Main;

public class CommandsPing extends ListenerAdapter
		{	   
	
	    @Override
	    public void onMessageReceived(MessageReceivedEvent event)
	    {
			 String[] args = event.getMessage().getContentRaw().split("\\s+");
			 long time = System.currentTimeMillis();
		     MessageChannel channel = event.getChannel();
		     
				if (args[0].equalsIgnoreCase(Main.prefix + "ping") || args[0].equalsIgnoreCase(Main.prefix + "p?") || args[0].equalsIgnoreCase(Main.prefix + "p") ) 
				{
	            channel.sendMessage("Pinging...").queue(response -> {response.editMessageFormat(":signal_strength: Pong: %d ms", System.currentTimeMillis() - time).queue();});
	        }   	        	
	    }
	}
