package vvcraft.hecker.commands;

import java.io.*;
import java.net.*;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import vvcraft.hecker.Main;

public class CommandsPingServer extends ListenerAdapter{
	
	public void onMessageReceived(MessageReceivedEvent event) 
	{		
		
		 String[] args = event.getMessage().getContentRaw().split("\\s+");
		 
			if(args[0].equalsIgnoreCase(Main.prefix + "PingIP")) 				
			{
				//IP
			    String ipAddress = "test.2b2t.org";
			    
			    InetAddress inet = null;
			    EmbedBuilder info = new EmbedBuilder();
			    
		    	long time = System.currentTimeMillis();			    				    
		    
				try {
					inet = InetAddress.getByName(ipAddress);									
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}

			    System.out.println("Sending Ping Request to " + ipAddress);	            
			    try {
			    			    	
					System.out.println(inet.isReachable(5000) ? "Host is reachable" + (System.currentTimeMillis() - time) : "Host is not reachable");																									
					
					if(time <= 5000) 
					{
						info.setTitle("mcPing:");
						info.setDescription("IP: " + ipAddress);
						info.addField("Status:","🔴 Offline",false);
						info.setColor(0xff0000);
						
						event.getChannel().sendTyping().queue();
						event.getChannel().sendMessage(info.build()).queue();
					}else if (time >= 5000)
					{
						info.setTitle("mcPing:");
						info.setDescription("IP: " + ipAddress);
						info.addField("Status:",":green_circle: Online",true);
						info.setFooter("Ping: " + (System.currentTimeMillis() - time));
						info.setColor(0x00ff00);
						
						event.getChannel().sendTyping().queue();
						event.getChannel().sendMessage(info.build()).queue();
					}					
				} catch (IOException e) {
					e.printStackTrace();						
				}		    
			}                       	                                 
	}   
}